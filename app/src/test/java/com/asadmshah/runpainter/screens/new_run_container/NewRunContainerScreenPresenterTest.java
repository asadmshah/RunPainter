package com.asadmshah.runpainter.screens.new_run_container;

import com.asadmshah.runpainter.utils.Bundler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class NewRunContainerScreenPresenterTest {

    @Mock NewRunContainerScreenContract.View view;
    @Mock Bundler bundler;

    @InjectMocks NewRunContainerScreenPresenter presenter;

    @Test
    public void testOnCreateWithNoBundleShouldShowNewRunScreen() {
        presenter.onCreate(null);

        verify(view).showNewRunScreen();
    }

    @Test
    public void testOnCreateWithBundleShouldNotShowNewRunScreen() {
        presenter.onCreate(bundler);

        verify(view, never()).showNewRunScreen();
    }

}
