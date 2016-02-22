package com.asadmshah.runpainter.services.current_run;

import android.support.test.rule.ServiceTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.asadmshah.runpainter.utils.DisableAnimationsRule;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class CurrentRunServiceTest {

    @ClassRule
    public static DisableAnimationsRule disableAnimationsRule = new DisableAnimationsRule();

    @Rule
    public ServiceTestRule serviceTestRule = new ServiceTestRule();

    @Test
    public void testNothing() {

    }

}
