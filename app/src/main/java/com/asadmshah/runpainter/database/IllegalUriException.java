package com.asadmshah.runpainter.database;

import android.net.Uri;

public class IllegalUriException extends IllegalArgumentException {

    public IllegalUriException(Uri uri) {
        super("Unknown Uri: " + uri);
    }
}
