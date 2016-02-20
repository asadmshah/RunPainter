package com.asadmshah.runpainter.screens.new_run;

import com.asadmshah.runpainter.utils.Bundler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class NewRunScreenPresenterTest {

    @Mock NewRunScreenContract.View view;
    @Mock Bundler bundler;

    @InjectMocks NewRunScreenPresenter presenter;

    @Test
    public void testDoNothing() {

    }

}
