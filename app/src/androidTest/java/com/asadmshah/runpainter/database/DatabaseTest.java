package com.asadmshah.runpainter.database;

import android.test.ProviderTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import com.asadmshah.runpainter.models.RoutePoint;
import com.asadmshah.runpainter.models.Run;

import java.util.Arrays;
import java.util.List;

import rx.observers.TestSubscriber;
import rx.schedulers.TestScheduler;

import static com.google.common.truth.Truth.assertThat;

@LargeTest
public class DatabaseTest extends ProviderTestCase2<DatabaseProvider> {

    private final TestScheduler scheduler = new TestScheduler();

    private Database database;

    public DatabaseTest() {
        super(DatabaseProvider.class, Contracts.AUTHORITY);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        database = new DatabaseImpl(getMockContentResolver(), scheduler);
    }

    public void testGetRuns() {
        TestSubscriber<List<Run>> subscriber = new TestSubscriber<>();

        database.insertRun(createRun(1, 1), createRoutePoints(createRoutePoint(1, 1, 1), createRoutePoint(2, 1, 2))).subscribe();
        database.insertRun(createRun(1, 2), createRoutePoints(createRoutePoint(3, 2, 1), createRoutePoint(4, 2, 1))).subscribe();
        database.getRuns().subscribe(subscriber);

        scheduler.triggerActions();

        subscriber.assertNoErrors();
        subscriber.assertNotCompleted();
        List<List<Run>> results = subscriber.getOnNextEvents();

        assertThat(results.size()).isEqualTo(1);
        assertThat(results.get(0).size()).isEqualTo(2);
        assertThat(results.get(0).get(0).datetime()).isEqualTo(2);

        subscriber.unsubscribe();
    }

    public void testGetRun() {
        TestSubscriber<Run> subscriber = new TestSubscriber<>();

        database.insertRun(createRun(1, 1), createRoutePoints(createRoutePoint(1, 1, 1), createRoutePoint(2, 1, 2))).subscribe();
        database.insertRun(createRun(1, 2), createRoutePoints(createRoutePoint(3, 2, 1), createRoutePoint(4, 2, 1))).subscribe();
        database.getRun(2).subscribe(subscriber);

        scheduler.triggerActions();

        subscriber.assertNoErrors();
        subscriber.assertNotCompleted();
        List<Run> results = subscriber.getOnNextEvents();

        assertThat(results.size()).isEqualTo(1);
        assertThat(results.get(0).datetime()).isEqualTo(2);

        subscriber.unsubscribe();
    }

    public void testGetRoutePoints() {
        TestSubscriber<List<RoutePoint>> subscriber = new TestSubscriber<>();

        database.insertRun(createRun(1, 1), createRoutePoints(createRoutePoint(1, 1, 1), createRoutePoint(2, 1, 2))).subscribe();
        database.insertRun(createRun(1, 2), createRoutePoints(createRoutePoint(3, 2, 1), createRoutePoint(4, 2, 1))).subscribe();
        database.getRoutePoints(1).subscribe(subscriber);

        scheduler.triggerActions();

        subscriber.assertNoErrors();
        subscriber.assertNotCompleted();
        List<List<RoutePoint>> results = subscriber.getOnNextEvents();

        assertThat(results.size()).isEqualTo(1);
        assertThat(results.get(0).size()).isEqualTo(2);
        assertThat(results.get(0).get(0).datetime()).isEqualTo(1);

        subscriber.unsubscribe();
    }

    public void testInsertRun() {
        TestSubscriber<Run> subscriber = new TestSubscriber<>();

        database.insertRun(createRun(1, 1), createRoutePoints(createRoutePoint(1, 1, 1), createRoutePoint(2, 1, 2))).subscribe(subscriber);

        scheduler.triggerActions();

        subscriber.assertNoErrors();
        subscriber.assertCompleted();
        List<Run> results = subscriber.getOnNextEvents();

        assertThat(results.size()).isEqualTo(1);
        assertThat(results.get(0).datetime()).isEqualTo(1);

        subscriber.unsubscribe();
    }

    public void testDeleteRun() {
        TestSubscriber<Void> voidSubscriber = new TestSubscriber<>();
        TestSubscriber<Run> runSubscriber = new TestSubscriber<>();

        database.insertRun(createRun(1, 1), createRoutePoints(createRoutePoint(1, 1, 1), createRoutePoint(2, 1, 2))).subscribe();
        database.insertRun(createRun(1, 2), createRoutePoints(createRoutePoint(3, 2, 1), createRoutePoint(4, 2, 1))).subscribe();
        database.deleteRun(createRun(1, 1)).subscribe(voidSubscriber);
        database.getRun(1).subscribe(runSubscriber);

        scheduler.triggerActions();

        voidSubscriber.assertNoErrors();
        voidSubscriber.assertCompleted();

        assertThat(runSubscriber.getOnNextEvents().size()).isEqualTo(0);

        voidSubscriber.unsubscribe();
        runSubscriber.unsubscribe();
    }

    public void testUpdateRun() {
        TestSubscriber<Void> voidSubscriber = new TestSubscriber<>();
        TestSubscriber<Run> runSubscriber = new TestSubscriber<>();

        database.insertRun(createRun(1, 1), createRoutePoints(createRoutePoint(1, 1, 1), createRoutePoint(2, 1, 2))).subscribe();
        database.updateRun(createRun(1, 2)).subscribe(voidSubscriber);
        database.getRun(1).subscribe(runSubscriber);

        scheduler.triggerActions();

        voidSubscriber.assertNoErrors();
        voidSubscriber.assertCompleted();

        assertThat(runSubscriber.getOnNextEvents().get(0).datetime()).isEqualTo(2);

        voidSubscriber.unsubscribe();
        runSubscriber.unsubscribe();
    }

    private static Run createRun(long id, int i) {
        return Run.create(id, i, i, i, i, i, i, i, i);
    }

    private static RoutePoint createRoutePoint(long id, long runId, long i) {
        return RoutePoint.create(id, runId, i, i, i, i, i, i, i);
    }

    private static List<RoutePoint> createRoutePoints(RoutePoint... points) {
        return Arrays.asList(points);
    }
}
