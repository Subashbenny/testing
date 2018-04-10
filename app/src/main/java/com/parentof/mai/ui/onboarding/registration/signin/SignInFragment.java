package com.parentof.mai.ui.onboarding.registration.signin;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.plus.Plus;
import com.parentof.mai.R;
import com.parentof.mai.ui.base.BaseFragment;
import com.parentof.mai.ui.onboarding.registration.FragmentCallback;
import com.parentof.mai.ui.onboarding.registration.RegistrationAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

/**
 * Created by gaurav on 14/06/17.
 */

public class SignInFragment extends BaseFragment implements SignInContract.View, GoogleApiClient.OnConnectionFailedListener {

    @Inject
    SignInContract.Presenter<SignInContract.View, SignInContract.Interactor> mPresenter;

    private FragmentCallback callback;

    private GoogleApiClient mGoogleApiClient;
    public static final int RC_SIGN_IN = 9001;

    CallbackManager callbackManager;
    @BindView(R.id.facebook_sign_in_button)
    LoginButton loginButton;
    private AccessToken accessToken;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);

        setUnBinder(ButterKnife.bind(this, view));

        mPresenter.onAttach(this);

        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        int status = googleApiAvailability.isGooglePlayServicesAvailable(getContext());
        int version = 0;
        try {
            version = getActivity().getPackageManager().getPackageInfo(googleApiAvailability.GOOGLE_PLAY_SERVICES_PACKAGE, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {

        }
        FacebookSdk.sdkInitialize(getActivity());
        callbackManager = CallbackManager.Factory.create();
        accessToken = AccessToken.getCurrentAccessToken();
        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        mPresenter.setFacebookData(loginResult);
                    }

                    @Override
                    public void onCancel() {
                        LoginManager.getInstance().logOut();
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        Toast.makeText(getActivity(), exception.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
        AccessTokenTracker accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(
                    AccessToken oldAccessToken,
                    AccessToken currentAccessToken) {

                if (currentAccessToken == null) {
                    LoginManager.getInstance().logOut();
                }
            }
        };
        return view;
    }
    @OnClick(R.id.google_sign_in_button)
    public void onGoogleSignInClick(View v) {
        mPresenter.googleSignIn(this, RC_SIGN_IN, mGoogleApiClient);
    }
    @OnClick(R.id.mai_account_button)
    public void onMaiSignInClick(View v) {
        mPresenter.moveToNextPage(getActivity());
    }
    @OnClick(R.id.facebook_sign_in_button)
    public void onFaceBookSignInClick(View v) {
        loginButton.setFragment(this);
        mPresenter.facebookLogin(this);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            mPresenter.handleSignInResult(result);
        }
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Timber.d("onConnectionFailed:" + connectionResult);
    }
    @Override
    public void onStart() {
        super.onStart();
        if (mGoogleApiClient != null) mGoogleApiClient.connect();
    }
    @Override
    public void onStop() {
        super.onStop();
        if (mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }
    @Override
    protected void setUp(View view) {
        callback = (FragmentCallback) getActivity();
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .requestScopes(new Scope(Scopes.PROFILE))
                .requestScopes(new Scope(Scopes.PLUS_LOGIN))
                .requestProfile()
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
                .enableAutoManage(getActivity(), this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .addApi(Plus.API)
                .build();
    }
    @Override
    public void gotoNextFragment() {
        callback.gotoStepperScreen(RegistrationAdapter.STEP_ENTER_PHONE_NUMBER);
    }
}
