package com.asadmshah.runpainter.screens.home_container;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.asadmshah.runpainter.utils.DisableAnimationsRule;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class HomeContainerScreenActivityTest {

    @ClassRule
    public static DisableAnimationsRule disableAnimationsRule = new DisableAnimationsRule();

    @Rule
    public ActivityTestRule<HomeContainerScreenActivity> activityTestRule = new ActivityTestRule<>(HomeContainerScreenActivity.class, true, true);

    @Test
    public void testNothing() {

    }

}
