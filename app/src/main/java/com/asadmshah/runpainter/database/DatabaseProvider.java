package com.asadmshah.runpainter.database;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class DatabaseProvider extends ContentProvider {

    private static final int LIST_RUNS = 10;
    private static final int ITEM_RUNS = 11;
    private static final int LIST_POINTS = 20;

    private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

    private DatabaseHelper databaseHelper;

    static {
        URI_MATCHER.addURI(Contracts.AUTHORITY, Contracts.Runs.PATH, LIST_RUNS);
        URI_MATCHER.addURI(Contracts.AUTHORITY, Contracts.Runs.PATH + "/#", ITEM_RUNS);
        URI_MATCHER.addURI(Contracts.AUTHORITY, Contracts.Points.PATH + "/#", LIST_POINTS);
    }

    @Override
    public boolean onCreate() {
        databaseHelper = new DatabaseHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (URI_MATCHER.match(uri)) {
            case LIST_RUNS:
                return Contracts.Runs.CONTENT_TYPE;
            case ITEM_RUNS:
                return Contracts.Runs.CONTENT_ITEM_TYPE;
            case LIST_POINTS:
                return Contracts.Points.CONTENT_TYPE;
            default:
                throw new IllegalUriException(uri);
        }
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        String table;
        String where;
        String[] whereArgs;
        switch (URI_MATCHER.match(uri)) {
            case LIST_RUNS:
                table = Contracts.Runs.TABLE_NAME;
                where = selection;
                whereArgs = selectionArgs;
                break;
            case ITEM_RUNS:
                table = Contracts.Runs.TABLE_NAME;
                where = Contracts.Runs.ID + " = ? ";
                whereArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                break;
            case LIST_POINTS:
                table = Contracts.Points.TABLE_NAME;
                where = Contracts.Points.RUN_ID + " = ? ";
                whereArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                break;
            default:
                throw new IllegalUriException(uri);
        }
        return db.query(table, projection, where, whereArgs, null, null, sortOrder);
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, ContentValues values) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        long rowId;
        Uri rowUri;
        switch (URI_MATCHER.match(uri)) {
            case LIST_RUNS:
                rowId = db.insert(Contracts.Runs.TABLE_NAME, null, values);
                rowUri = Contracts.Runs.CONTENT_URI;
                break;
            default:
                throw new IllegalUriException(uri);
        }
        if (rowId == -1) {
            throw new SQLException("Unable to insert with uri: " + uri);
        }
        notifyChange(uri);
        return ContentUris.withAppendedId(rowUri, rowId);
    }

    @Override
    public int delete(@NonNull Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        String table;
        String where;
        String[] whereArgs;
        switch (URI_MATCHER.match(uri)) {
            case ITEM_RUNS:
                table = Contracts.Runs.TABLE_NAME;
                where = Contracts.Runs.ID + " = ? ";
                whereArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                break;
            default:
                throw new IllegalUriException(uri);
        }
        int rows = db.delete(table, where, whereArgs);
        if (rows > 0) {
            notifyChange(uri);
        }
        return rows;
    }

    @Override
    public int update(@NonNull Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        int rows;
        switch (URI_MATCHER.match(uri)) {
            case ITEM_RUNS:
                rows = db.update(Contracts.Runs.TABLE_NAME,
                        values,
                        Contracts.Runs.ID + " = ? ",
                        new String[]{String.valueOf(ContentUris.parseId(uri))});
                break;
            default:
                throw new IllegalUriException(uri);
        }
        if (rows > 0) {
            notifyChange(uri);
        }
        return rows;
    }

    @Override
    public int bulkInsert(@NonNull Uri uri, @NonNull ContentValues[] values) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        int rowsInserted = 0;
        switch (URI_MATCHER.match(uri)) {
            case LIST_POINTS:
                db.beginTransaction();
                long runId = ContentUris.parseId(uri);
                try {
                    for (ContentValues cv : values) {
                        cv.put(Contracts.Points.RUN_ID, runId);
                        if (db.insert(Contracts.Points.TABLE_NAME, null, cv) > 0) {
                            rowsInserted++;
                        }
                    }
                    db.setTransactionSuccessful();
                } finally {
                    db.endTransaction();
                }
                break;
            default:
                throw new IllegalUriException(uri);
        }
        if (rowsInserted > 0) {
            notifyChange(uri);
        }
        return rowsInserted;
    }

    private void notifyChange(Uri uri) {
        Context context = getContext();
        if (context != null) {
            context.getContentResolver().notifyChange(uri, null);
        }
    }
}
