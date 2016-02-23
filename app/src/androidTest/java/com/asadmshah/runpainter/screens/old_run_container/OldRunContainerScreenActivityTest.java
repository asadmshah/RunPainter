package com.asadmshah.runpainter.screens.old_run_container;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class OldRunContainerScreenActivityTest {

    @Rule
    public ActivityTestRule<OldRunContainerScreenActivity> activityTestRule = new ActivityTestRule<>(OldRunContainerScreenActivity.class, true, true);

    @Test
    public void testNothing() {

    }

}
