package com.mycompany.googletest.utils;

import com.google.api.services.drive.model.File;

public interface ServiceListener {
    void loggedIn();

    void fileDownloaded(File file);

    void cancelled();

    void cancelled(Exception exception);
}
