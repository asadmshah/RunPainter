package com.asadmshah.runpainter.database;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.test.ProviderTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import junit.framework.Assert;

import static com.google.common.truth.Truth.assertThat;

@LargeTest
public class DatabaseProviderTest extends ProviderTestCase2<DatabaseProvider> {

    public DatabaseProviderTest() {
        super(DatabaseProvider.class, Contracts.AUTHORITY);
    }

    public void testInsertRun() {
        Uri uri = insertRun(1);
        assertThat(uri).isNotNull();
        assertThat(uri).isEqualTo(Contracts.Runs.buildUri(1));
    }

    public void testInsertIllegalUri() {
        ContentValues cv = new ContentValues();
        ContentResolver cr = getMockContentResolver();

        try {
            cr.insert(Contracts.Runs.buildUri(1), cv);
            Assert.fail();
        } catch (IllegalUriException ignore) {

        }

        try {
            cr.insert(Contracts.RoutePoints.buildUri(), cv);
            Assert.fail();
        } catch (IllegalUriException ignore) {

        }

        try {
            cr.insert(Contracts.RoutePoints.buildUri(1), cv);
            Assert.fail();
        } catch (IllegalUriException ignore) {

        }
    }

    public void testQueryRuns() {
        insertRun(1);
        insertRun(2);

        Cursor cursor = getMockContentResolver().query(Contracts.Runs.buildUri(), null, null, null, null);
        assertThat(cursor).isNotNull();
        assertThat(cursor.getCount()).isEqualTo(2);
        cursor.close();
    }

    public void testQueryRun() {
        insertRun(1);
        insertRun(2);

        Cursor cursor;

        cursor = getMockContentResolver().query(Contracts.Runs.buildUri(1), new String[]{Contracts.Runs.DATETIME}, null, null, null);
        assertThat(cursor).isNotNull();
        assertThat(cursor.getCount()).isEqualTo(1);
        assertThat(cursor.moveToNext()).isTrue();
        assertThat(cursor.getInt(0)).isEqualTo(1);
        cursor.close();

        cursor = getMockContentResolver().query(Contracts.Runs.buildUri(2), new String[]{Contracts.Runs.DATETIME}, null, null, null);
        assertThat(cursor).isNotNull();
        assertThat(cursor.getCount()).isEqualTo(1);
        assertThat(cursor.moveToNext()).isTrue();
        assertThat(cursor.getInt(0)).isEqualTo(2);
        cursor.close();
    }

    public void testQueryRoutePoints() {
        insertRun(1);
        insertRun(2);
        insertRoutePoints(1, 2);
        insertRoutePoints(2, 2);

        Cursor cursor;

        cursor = getMockContentResolver().query(Contracts.RoutePoints.buildUri(1), new String[]{Contracts.RoutePoints.RUN_ID}, null, null, null);
        assertThat(cursor).isNotNull();
        assertThat(cursor.getCount()).isEqualTo(2);
        assertThat(cursor.moveToNext()).isTrue();
        assertThat(cursor.getInt(0)).isEqualTo(1);
        assertThat(cursor.moveToNext()).isTrue();
        assertThat(cursor.getInt(0)).isEqualTo(1);
        cursor.close();

        cursor = getMockContentResolver().query(Contracts.RoutePoints.buildUri(2), new String[]{Contracts.RoutePoints.RUN_ID}, null, null, null);
        assertThat(cursor).isNotNull();
        assertThat(cursor.getCount()).isEqualTo(2);
        assertThat(cursor.moveToNext()).isTrue();
        assertThat(cursor.getInt(0)).isEqualTo(2);
        assertThat(cursor.moveToNext()).isTrue();
        assertThat(cursor.getInt(0)).isEqualTo(2);
        cursor.close();
    }

    public void testQueryIllegalUri() {
        ContentResolver cr = getMockContentResolver();

        try {
            cr.query(Contracts.RoutePoints.buildUri(), null, null, null, null, null);
            Assert.fail();
        } catch (IllegalUriException ignore) {

        }
    }

    public void testDeleteRun() {
        insertRun(1);
        insertRun(2);
        insertRoutePoints(1, 2);
        insertRoutePoints(2, 2);

        int deletedRows = getMockContentResolver().delete(Contracts.Runs.buildUri(2), null, null);
        assertThat(deletedRows).isEqualTo(1);

        Cursor cursor = getMockContentResolver().query(Contracts.RoutePoints.buildUri(2), null, null, null, null);
        assertThat(cursor).isNotNull();
        assertThat(cursor.moveToNext()).isFalse();
        cursor.close();
    }

    public void testDeleteIllegalUri() {
        ContentResolver cr = getMockContentResolver();

        try {
            cr.delete(Contracts.RoutePoints.buildUri(), null, null);
            Assert.fail();
        } catch (IllegalUriException ignore) {

        }

        try {
            cr.delete(Contracts.RoutePoints.buildUri(), null, null);
            Assert.fail();
        } catch (IllegalUriException ignore) {

        }

        try {
            cr.delete(Contracts.RoutePoints.buildUri(1), null, null);
            Assert.fail();
        } catch (IllegalUriException ignore) {

        }
    }

    public void testUpdateRun() {
        insertRun(1);
        insertRun(2);

        ContentValues cv = new ContentValues();
        cv.put(Contracts.Runs.DURATION, 200);
        int updatedRows = getMockContentResolver().update(Contracts.Runs.buildUri(2), cv, null, null);
        assertThat(updatedRows).isEqualTo(1);

        Cursor cursor = getMockContentResolver().query(Contracts.Runs.buildUri(2), new String[]{Contracts.Runs.DURATION}, null, null, null);
        assertThat(cursor).isNotNull();
        assertThat(cursor.moveToNext()).isTrue();
        assertThat(cursor.getInt(0)).isEqualTo(200);
        cursor.close();
    }

    public void testUpdateIllegalUri() {
        ContentValues cv = new ContentValues();
        ContentResolver cr = getMockContentResolver();

        try {
            cr.update(Contracts.Runs.buildUri(), cv, null, null);
            Assert.fail();
        } catch (IllegalUriException ignore) {

        }

        try {
            cr.update(Contracts.RoutePoints.buildUri(), cv, null, null);
            Assert.fail();
        } catch (IllegalUriException ignore) {

        }

        try {
            cr.update(Contracts.RoutePoints.buildUri(1), cv, null, null);
            Assert.fail();
        } catch (IllegalUriException ignore) {

        }
    }

    public void testBulkInsertRoutePoints() {
        insertRun(1);
        int insertedRows = insertRoutePoints(1, 4);

        assertThat(insertedRows).isEqualTo(4);
    }

    public void testBulkInsertIllegalUri() {
        ContentResolver cr = getMockContentResolver();
        ContentValues[] cv = new ContentValues[]{};

        try {
            cr.bulkInsert(Contracts.Runs.CONTENT_URI, cv);
            Assert.fail();
        } catch (IllegalUriException ignore) {

        }

        try {
            cr.bulkInsert(ContentUris.withAppendedId(Contracts.Runs.CONTENT_URI, 1), cv);
            Assert.fail();
        } catch (IllegalUriException ignore) {

        }

        try {
            cr.bulkInsert(Contracts.RoutePoints.CONTENT_URI, cv);
            Assert.fail();
        } catch (IllegalUriException ignore) {

        }

    }

    private Uri insertRun(int x) {
        ContentValues cv = new ContentValues();
        cv.put(Contracts.Runs.DATETIME, x);
        cv.put(Contracts.Runs.DISTANCE, x);
        cv.put(Contracts.Runs.DURATION, x);
        cv.put(Contracts.Runs.FORMAT, x);
        cv.put(Contracts.Runs.COLOR_BG_A, x);
        cv.put(Contracts.Runs.COLOR_BG_B, x);
        cv.put(Contracts.Runs.COLOR_TEXT, x);
        cv.put(Contracts.Runs.COLOR_PATH, x);
        return getMockContentResolver().insert(Contracts.Runs.buildUri(), cv);
    }

    private int insertRoutePoints(long runId, int n) {
        ContentValues[] cvs = new ContentValues[n];
        for (int i = 0; i < n; i++) {
            ContentValues cv = new ContentValues();
            cv.put(Contracts.RoutePoints.DATETIME, i+1);
            cv.put(Contracts.RoutePoints.LATITUDE, i+1);
            cv.put(Contracts.RoutePoints.LONGITUDE, i+1);
            cv.put(Contracts.RoutePoints.ALTITUDE, i+1);
            cv.put(Contracts.RoutePoints.ACCURACY, i+1);
            cv.put(Contracts.RoutePoints.BEARING, i+1);
            cv.put(Contracts.RoutePoints.SPEED, i+1);
            cvs[i] = cv;
        }
        return getMockContentResolver().bulkInsert(Contracts.RoutePoints.buildUri(runId), cvs);
    }

}
