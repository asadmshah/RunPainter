package com.asadmshah.runpainter.screens.settings;

import com.asadmshah.runpainter.utils.Bundler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SettingsScreenPresenterTest {

    @Mock SettingsScreenContract.View view;
    @Mock Bundler bundler;

    @InjectMocks SettingsScreenPresenter presenter;

    @Test
    public void testDoNothing() {

    }

}
