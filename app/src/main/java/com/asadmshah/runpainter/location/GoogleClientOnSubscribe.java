package com.asadmshah.runpainter.location;

import android.content.Context;
import android.support.annotation.NonNull;

import com.google.android.gms.common.api.GoogleApiClient;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;

class GoogleClientOnSubscribe implements Observable.OnSubscribe<GoogleApiClient> {

    private final Context context;

    GoogleClientOnSubscribe(@NonNull Context context) {
        this.context = context;
    }

    @Override
    public void call(Subscriber<? super GoogleApiClient> subscriber) {
        GoogleClient client = new GoogleClient(context, new GoogleClient.Listener() {
            @Override
            public void onGoogleClientConnected(GoogleApiClient client) {
                subscriber.onNext(client);
            }

            @Override
            public void onGoogleClientError(Throwable throwable) {
                subscriber.onError(throwable);
            }
        });
        client.connect();

        subscriber.add(Subscriptions.create(new Action0() {
            @Override
            public void call() {
                client.disconnect();
            }
        }));
    }

}
