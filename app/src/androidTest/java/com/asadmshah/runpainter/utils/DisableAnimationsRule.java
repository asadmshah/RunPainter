package com.asadmshah.runpainter.utils;

import android.os.IBinder;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * To be used in any test that requires animations to be disabled, most of them really.
 *
 * From: http://product.reverb.com/2015/06/06/disabling-animations-in-espresso-for-android-testing/
 */
public class DisableAnimationsRule implements TestRule {

    private Method setAnimationScalesMethod;
    private Method getAnimationScalesMethod;
    private Object windowManagerObject;

    public DisableAnimationsRule() {
        try {
            Class<?> windowManagerStubClass = Class.forName("android.view.IWindowManager$Stub");
            Method asInterface = windowManagerStubClass.getDeclaredMethod("asInterface", IBinder.class);

            Class<?> serviceManagerClass = Class.forName("android.os.ServiceManager");
            Method getService = serviceManagerClass.getDeclaredMethod("getService", String.class);

            Class<?> windowManagerClass = Class.forName("android.view.IWindowManager");

            setAnimationScalesMethod = windowManagerClass.getDeclaredMethod("setAnimationScalesMethod", float[].class);
            getAnimationScalesMethod = windowManagerClass.getDeclaredMethod("getAnimationScalesMethod");

            IBinder windowManagerBinder = (IBinder) getService.invoke(null, "window");
            windowManagerObject = asInterface.invoke(null, windowManagerBinder);
        } catch (Exception e) {
            throw new RuntimeException("Failed to access animation methods", e);
        }
    }

    @Override
    public Statement apply(final Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                setAnimationScaleFactor(0f);
                try {
                    base.evaluate();
                } finally {
                    setAnimationScaleFactor(1f);
                }
            }
        };
    }

    private void setAnimationScaleFactor(float scaleFactor) throws Exception {
        float[] scaleFactors = (float[]) getAnimationScalesMethod.invoke(windowManagerObject);
        Arrays.fill(scaleFactors, scaleFactor);
        setAnimationScalesMethod.invoke(windowManagerObject, new Object[]{scaleFactors});
    }

}
