package com.parentof.mai.ui.onboarding.registration.signin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.parentof.mai.di.FragmentScoped;
import com.parentof.mai.ui.base.BasePresenter;
import com.parentof.mai.ui.onboarding.user.UserDataActivity;
import com.parentof.mai.utils.rx.SchedulerProvider;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import javax.inject.Inject;


/**
 * Created by gaurav on 14/06/17.
 */

@FragmentScoped
public class SignInPresenter<V extends SignInContract.View, I extends SignInContract.Interactor> extends BasePresenter<V, I> implements SignInContract.Presenter<V, I> {

    @Inject
    public SignInPresenter(I interactor,
                           SchedulerProvider schedulerProvider) {
        super(interactor, schedulerProvider);
    }

    @Override
    public void facebookLogin(Fragment context) {
        LoginManager.getInstance().logInWithReadPermissions(context,
                Arrays.asList("user_friends", "email", "public_profile"));//user_birthday

    }

    @Override
    public void googleSignIn(Fragment context, int code, GoogleApiClient client) {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(client);
        context.startActivityForResult(signInIntent, code);
    }

    @Override
    public void moveToNextPage(Context context) {
        Intent intent = UserDataActivity.getStartIntent(context);
        context.startActivity(intent);
    }

    @Override
    public void setFacebookData(LoginResult result) {
        GraphRequest request = GraphRequest.newMeRequest(result.getAccessToken(),
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        // Application code
                        try {
                            String email = response.getJSONObject().getString("email");
                            String firstName = response.getJSONObject().getString("first_name");
                            String lastName = response.getJSONObject().getString("last_name");
                            String gender = response.getJSONObject().getString("gender");
                            // String bday = response.getJSONObject().getString("birthday");


                            Profile profile = Profile.getCurrentProfile();
                            String id = profile.getId();
                            String link = profile.getLinkUri().toString();
                            if (Profile.getCurrentProfile() != null) {
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,email,first_name,last_name,gender");//birthday
        request.setParameters(parameters);
        request.executeAsync();
    }

    @Override
    public void handleSignInResult(GoogleSignInResult result) {
        if (result.isSuccess()) {
            GoogleSignInAccount acct = result.getSignInAccount();
            String userName = acct.getDisplayName();
            String email = acct.getEmail();
            Uri url = null;
            if (acct.getPhotoUrl() != null) {
                url = acct.getPhotoUrl();
            }
            String imageUrl = null;
            if (url != null && (!TextUtils.isEmpty(url.toString()))) {
                imageUrl = url.toString();
            }
        } else {
            //  DialogClass.dismissDialog(this);
        }
    }
}
