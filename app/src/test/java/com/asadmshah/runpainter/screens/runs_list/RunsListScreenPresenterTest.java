package com.asadmshah.runpainter.screens.runs_list;

import com.asadmshah.runpainter.utils.Bundler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RunsListScreenPresenterTest {

    @Mock RunsListScreenContract.View view;
    @Mock Bundler bundler;

    @InjectMocks RunsListScreenPresenter presenter;

    @Test
    public void testDoNothing() {

    }

}
