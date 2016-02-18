package com.asadmshah.runpainter.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.asadmshah.runpainter.database.Contracts.RoutePoints;
import com.asadmshah.runpainter.database.Contracts.Runs;

final class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "runpainter";
    private static final int DATABASE_VERSION = 1;

    private static final String TRIGGER_ON_DELETE_RUN = "OnDeleteRun";

    DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    @SuppressWarnings("PMD.AvoidDuplicateLiterals")
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + Runs.TABLE_NAME + " ("
                + Runs.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Runs.DATETIME + " INTEGER NOT NULL, "
                + Runs.DISTANCE + " INTEGER NOT NULL, "
                + Runs.DURATION + " INTEGER NOT NULL, "
                + Runs.FORMAT + " INTEGER NOT NULL, "
                + Runs.COLOR_BG_A + " INTEGER NOT NULL, "
                + Runs.COLOR_BG_B + " INTEGER NOT NULL, "
                + Runs.COLOR_TEXT + " INTEGER NOT NULL, "
                + Runs.COLOR_PATH + " INTEGER NOT NULL); "
        );

        db.execSQL("CREATE TABLE " + RoutePoints.TABLE_NAME + " ("
                + RoutePoints.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + RoutePoints.RUN_ID + " INTEGER NOT NULL, "
                + RoutePoints.DATETIME + " INTEGER NOT NULL, "
                + RoutePoints.LATITUDE + " REAL NOT NULL, "
                + RoutePoints.LONGITUDE + " REAL NOT NULL, "
                + RoutePoints.ALTITUDE + " REAL NOT NULL, "
                + RoutePoints.ACCURACY + " REAL NOT NULL, "
                + RoutePoints.BEARING + " REAL NOT NULL, "
                + RoutePoints.SPEED + " REAL NOT NULL, "
                + "FOREIGN KEY (" + RoutePoints.RUN_ID + ") REFERENCES " + Runs.TABLE_NAME + "(" + Runs.ID + "));"
        );

        db.execSQL("CREATE TRIGGER " + TRIGGER_ON_DELETE_RUN + " BEFORE DELETE ON " + Runs.TABLE_NAME
                + " FOR EACH ROW BEGIN "
                + " DELETE FROM " + RoutePoints.TABLE_NAME + " WHERE " + RoutePoints.RUN_ID + "=OLD." + Runs.ID + ";"
                + " END;"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Runs.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + RoutePoints.TABLE_NAME);
        db.execSQL("DROP TRIGGER IF EXISTS " + TRIGGER_ON_DELETE_RUN);
    }

}
