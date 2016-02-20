package com.asadmshah.runpainter.screens.home_container;

import com.asadmshah.runpainter.utils.Bundler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class HomeContainerScreenPresenterTest {

    @Mock HomeContainerScreenContract.View view;
    @Mock Bundler bundler;

    @InjectMocks HomeContainerScreenPresenter presenter;

    @Test
    public void testOnCreateWithNoBundleShouldShowRunsListScreen() {
        presenter.onCreate(null);

        verify(view).showRunsListScreen();
    }

    @Test
    public void testOnCreateWithBundleShouldNotShowRunsListScreen() {
        presenter.onCreate(bundler);

        verify(view, never()).showRunsListScreen();
    }

}
