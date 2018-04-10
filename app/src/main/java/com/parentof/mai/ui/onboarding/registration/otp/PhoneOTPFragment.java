package com.parentof.mai.ui.onboarding.registration.otp;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.parentof.mai.R;
import com.parentof.mai.callbacks.SMSCallBackInterface;
import com.parentof.mai.receivers.SMSReceiver;
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

public class PhoneOTPFragment extends BaseFragment implements PhoneOTPContract.View {

    @Inject
    PhoneOTPContract.Presenter<PhoneOTPContract.View, PhoneOTPContract.Interactor> mPresenter;

    @Inject
    LinearLayoutManager mLayoutManager;

    @BindView(R.id.et_phone_otp)
    EditText phoneNumberOTPEditText;

    @BindView(R.id.phone_otp_button)
    Button phoneOTPButton;

    private FragmentCallback callback;

    @Inject
    public PhoneOTPFragment() {
        // Requires empty public constructor
    }

    private void bindSmsReceiver() {

    }

    public static PhoneOTPFragment newInstance() {
        PhoneOTPFragment fragment = new PhoneOTPFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_enter_phone_otp, container, false);

        setUnBinder(ButterKnife.bind(this, view));

        mPresenter.onAttach(this);

        return view;
    }

    @OnClick(R.id.phone_otp_button)
    public void onNextClick(View v) {
        String otp = phoneNumberOTPEditText.getText().toString();
        if (otp.length() != 4) {
            Bundle params = new Bundle();
            params.putString("otp", otp);
            phoneNumberOTPEditText.setError("4 digit OTP number required.");
            return;
        }
        mPresenter.onPhoneOTPSuccess(otp);
    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }

    @Override
    protected void setUp(View view) {
        callback = (FragmentCallback) getActivity();
        phoneNumberOTPEditText.addTextChangedListener(mTextWatcher);
        SMSReceiver.bindListener(new SMSCallBackInterface() {
            @Override
            public void populateSMSOtp(String smsOtp) {
                Timber.d("message text " + smsOtp);
                phoneNumberOTPEditText.setText(smsOtp);
            }
        });
    }

    @Override
    public void gotoNextFragment() {
        callback.gotoStepperScreen(RegistrationAdapter.STEP_SIGN_IN);
    }

    private final TextWatcher mTextWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (count == 0) {
                phoneOTPButton.setEnabled(false);
            } else if (count == 4) {
                phoneOTPButton.setEnabled(true);
            }
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // TODO Auto-generated method stub
        }

        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public void afterTextChanged(Editable s) {
            String text = phoneNumberOTPEditText.getText().toString();
            if (text.length() == 4) {
                phoneOTPButton.setEnabled(true);
            }
        }
    };
}
