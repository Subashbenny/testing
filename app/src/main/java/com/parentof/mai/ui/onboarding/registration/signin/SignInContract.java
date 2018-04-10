package com.parentof.mai.ui.onboarding.registration.signin;


import android.content.Context;
import android.support.v4.app.Fragment;

import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.parentof.mai.ui.base.BaseInteractorContract;
import com.parentof.mai.ui.base.BasePresenterContract;
import com.parentof.mai.ui.base.BaseViewContract;

/**
 * Created by gaurav on 20/01/18.
 */

public interface SignInContract {

    public interface View extends BaseViewContract {
        void gotoNextFragment();
    }

    public interface Interactor extends BaseInteractorContract {
    }

    public interface Presenter<V extends View, I extends Interactor> extends BasePresenterContract<V, I> {
        void facebookLogin(Fragment context);
        void googleSignIn(Fragment con, int signCode, GoogleApiClient client);
        void moveToNextPage(Context con);
        void setFacebookData(LoginResult result);
        void handleSignInResult(GoogleSignInResult result);
    }
}
