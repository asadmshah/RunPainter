package com.asadmshah.runpainter.screens.settings_container;

import com.asadmshah.runpainter.utils.Bundler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SettingsContainerScreenPresenterTest {

    @Mock SettingsContainerScreenContract.View view;
    @Mock Bundler bundler;

    @InjectMocks SettingsContainerScreenPresenter presenter;

    @Test
    public void testOnCreateWithNoBundleShouldShowSettingsScreen() {
        presenter.onCreate(null);

        verify(view).showSettingsScreen();
    }

    @Test
    public void testOnCreateWithBundleShouldNotShowSettingsScreen() {
        presenter.onCreate(bundler);

        verify(view, never()).showSettingsScreen();
    }

}
