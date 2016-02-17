package com.asadmshah.runpainter.database;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;

import com.asadmshah.runpainter.BuildConfig;

final class Contracts {

    static final String AUTHORITY = BuildConfig.DATABASE_PROVIDER_AUTHORITY;
    static final String BASE_CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + AUTHORITY;
    static final String BASE_CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + AUTHORITY;

    static final Uri BASE_URI = Uri.parse("content://" + AUTHORITY);

    private Contracts() {
        super();
    }

    static final class Runs {

        static final String TABLE_NAME = Runs.class.getSimpleName();

        static final String ID = "_id";
        static final String DATETIME = "datetime";
        static final String DISTANCE = "distance";
        static final String DURATION = "duration";
        static final String FORMAT = "format";
        static final String COLOR_BG_A = "color_bg_a";
        static final String COLOR_BG_B = "color_bg_b";
        static final String COLOR_TEXT = "color_text";
        static final String COLOR_PATH = "color_path";

        static final String PATH = TABLE_NAME;
        static final String CONTENT_TYPE = BASE_CONTENT_TYPE + "/" + PATH;
        static final String CONTENT_ITEM_TYPE = BASE_CONTENT_ITEM_TYPE + "/" + PATH;

        static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_URI, PATH);

        private Runs() {

        }

        static Uri buildUri() {
            return CONTENT_URI;
        }

        static Uri buildUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }

    static final class Points {

        static final String TABLE_NAME = Points.class.getSimpleName();

        static final String ID = "_id";
        static final String RUN_ID = "run_id";
        static final String DATETIME = "datetime";
        static final String LATITUDE = "latitude";
        static final String LONGITUDE = "longitude";
        static final String ALTITUDE = "altitude";
        static final String ACCURACY = "accuracy";
        static final String BEARING = "bearing";
        static final String SPEED = "speed";

        static final String PATH = TABLE_NAME;
        static final String CONTENT_TYPE = BASE_CONTENT_TYPE + "/" + PATH;

        static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_URI, PATH);

        private Points() {

        }

        static Uri buildUri() {
            return CONTENT_URI;
        }

        static Uri buildUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }

}
