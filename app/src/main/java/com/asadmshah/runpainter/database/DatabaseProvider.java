package com.asadmshah.runpainter.database;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.asadmshah.runpainter.database.Contracts.RoutePoints;
import com.asadmshah.runpainter.database.Contracts.Runs;

public class DatabaseProvider extends ContentProvider {

    private static final int LIST_RUNS = 10;
    private static final int ITEM_RUNS = 11;
    private static final int LIST_ROUTE_POINTS = 20;

    private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

    private DatabaseHelper databaseHelper;

    static {
        URI_MATCHER.addURI(Contracts.AUTHORITY, Runs.PATH, LIST_RUNS);
        URI_MATCHER.addURI(Contracts.AUTHORITY, Runs.PATH + "/#", ITEM_RUNS);
        URI_MATCHER.addURI(Contracts.AUTHORITY, RoutePoints.PATH + "/#", LIST_ROUTE_POINTS);
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
                return Runs.CONTENT_TYPE;
            case ITEM_RUNS:
                return Runs.CONTENT_ITEM_TYPE;
            case LIST_ROUTE_POINTS:
                return RoutePoints.CONTENT_TYPE;
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
                table = Runs.TABLE_NAME;
                where = selection;
                whereArgs = selectionArgs;
                break;
            case ITEM_RUNS:
                table = Runs.TABLE_NAME;
                where = buildWhere(Runs.ID);
                whereArgs = buildWhereArgs(uri);
                break;
            case LIST_ROUTE_POINTS:
                table = RoutePoints.TABLE_NAME;
                where = buildWhere(RoutePoints.RUN_ID);
                whereArgs = buildWhereArgs(uri);
                break;
            default:
                throw new IllegalUriException(uri);
        }
        return db.query(table, projection, where, whereArgs, null, null, sortOrder);
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, ContentValues values) {
        Uri insertedUri = null;

        if (URI_MATCHER.match(uri) == LIST_RUNS) {
            long id = databaseHelper.getWritableDatabase().insert(Runs.TABLE_NAME, null, values);
            if (id != -1) {
                notifyChange(uri);
                insertedUri = ContentUris.withAppendedId(uri, id);
            }
        } else {
            throw new IllegalUriException(uri);
        }

        return insertedUri;
    }

    @Override
    public int delete(@NonNull Uri uri, String selection, String... selectionArgs) {
        int rowsDeleted;

        if (URI_MATCHER.match(uri) == ITEM_RUNS) {
            rowsDeleted = databaseHelper.getWritableDatabase().delete(Runs.TABLE_NAME, buildWhere(Runs.ID), buildWhereArgs(uri));
            if (rowsDeleted > 0) {
                notifyChange(uri);
            }
        } else {
            throw new IllegalUriException(uri);
        }

        return rowsDeleted;
    }

    @Override
    public int update(@NonNull Uri uri, ContentValues values, String selection, String... selectionArgs) {
        int rowsUpdated;

        if (URI_MATCHER.match(uri) == ITEM_RUNS) {
            rowsUpdated = databaseHelper.getWritableDatabase().update(Runs.TABLE_NAME, values, buildWhere(Runs.ID), buildWhereArgs(uri));
            if (rowsUpdated > 0) {
                notifyChange(uri);
            }
        } else {
            throw new IllegalUriException(uri);
        }

        return rowsUpdated;
    }

    @Override
    public int bulkInsert(@NonNull Uri uri, @NonNull ContentValues... values) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        int rowsInserted = 0;

        if (URI_MATCHER.match(uri) == LIST_ROUTE_POINTS) {
            db.beginTransaction();
            long runId = ContentUris.parseId(uri);
            try {
                for (ContentValues cv : values) {
                    cv.put(RoutePoints.RUN_ID, runId);
                    if (db.insert(RoutePoints.TABLE_NAME, null, cv) > 0) {
                        rowsInserted++;
                    }
                }
                db.setTransactionSuccessful();
            } finally {
                db.endTransaction();
            }

            if (rowsInserted > 0) {
                notifyChange(uri);
            }
        } else {
            throw new IllegalUriException(uri);
        }

        return rowsInserted;
    }

    private void notifyChange(Uri uri) {
        Context context = getContext();
        if (context != null) {
            context.getContentResolver().notifyChange(uri, null);
        }
    }

    private String buildWhere(String column) {
        return column + " = ? ";
    }

    private String[] buildWhereArgs(Uri uri) {
        return new String[]{String.valueOf(ContentUris.parseId(uri))};
    }

}
