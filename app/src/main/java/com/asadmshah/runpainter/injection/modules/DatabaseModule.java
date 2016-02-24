package com.asadmshah.runpainter.injection.modules;

import android.content.Context;

import com.asadmshah.runpainter.database.Database;
import com.asadmshah.runpainter.database.DatabaseImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.schedulers.Schedulers;

@Module
public class DatabaseModule {

    @Provides
    @Singleton
    public Database providesDatabase(Context context) {
        return new DatabaseImpl(context.getContentResolver(), Schedulers.io());
    }

}
