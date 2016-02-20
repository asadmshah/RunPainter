package com.asadmshah.runpainter.screens.old_run_container;

import com.asadmshah.runpainter.utils.Bundler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class OldRunContainerScreenPresenterTest {

    @Mock OldRunContainerScreenContract.View view;
    @Mock Bundler bundler;

    @InjectMocks OldRunContainerScreenPresenter presenter;

    @Test
    public void testOnCreateWithNoBundleShouldShowOldRunScreen() {
        presenter.onCreate(null);

        verify(view).showOldRunScreen();
    }

    @Test
    public void testOnCreateWithBundleShouldNotShowOldRunScreen() {
        presenter.onCreate(bundler);

        verify(view, never()).showOldRunScreen();
    }

}
