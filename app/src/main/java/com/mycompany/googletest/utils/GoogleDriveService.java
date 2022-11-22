package com.mycompany.googletest.utils;

import android.app.Activity;

import androidx.annotation.RestrictTo;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveClient;
import com.google.android.gms.drive.DriveResourceClient;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.*;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public class GoogleDriveService {
    private final Activity activity = null;
    private final GoogleDriveConfig config = null;
    private ServiceListener serviceListener;
    private DriveClient driveClient;
    private DriveResourceClient driveResourceClient;
    private GoogleSignInAccount signInAccount;


    public static class Companion {
        public Set<Scope> SCOPES = new HashSet<>(Arrays.asList(
                Drive.SCOPE_FILE, Drive.SCOPE_APPFOLDER));
        List<String> documentMimeTypes = new ArrayList<>(Arrays.asList(
                "application/pdf",
                "application/msword",
                "application/vnd.openxmlformats-officedocument.wordprocessingml.document"));
        static final int REQUEST_CODE_OPEN_ITEM = 100;
        static final int REQUEST_CODE_SIGN_IN = 101;
        static final String TAG = "GoogleDriveService";
    }
    Lazy<GoogleSignInClient> googleSignInClient = kotlin.LazyKt.lazy(
            val builder = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        for (scope in SCOPES) {
            builder.requestScopes(scope)
        }
        val signInOptions = builder.build()
        GoogleSignIn.getClient(activity, signInOptions)
            )
    }
    public synchronized GoogleSignInClient getGoogleSignInClient() {
        //GoogleSignInOptions.Builder builder = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN);
        GoogleSignInOptions.Builder builder = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN);
        for (Scope scope : SCOPES) {
            builder.requestScopes(scope);
        }
        GoogleSignInOptions signInOptions = builder.build();
        assert false;
        return GoogleSignIn.getClient(activity, signInOptions);
    }
}
