package com.parentof.mai.ui.onboarding.registration.phone;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.parentof.mai.R;
import com.parentof.mai.ui.base.BaseFragment;
import com.parentof.mai.ui.onboarding.registration.FragmentCallback;
import com.parentof.mai.ui.onboarding.registration.RegistrationAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gaurav on 14/06/17.
 */

public class PhoneNumberFragment extends BaseFragment implements PhoneNumberContract.View {

    @Inject
    PhoneNumberContract.Presenter<PhoneNumberContract.View, PhoneNumberContract.Interactor> mPresenter;

    @Inject
    LinearLayoutManager mLayoutManager;

    @BindView(R.id.et_phone_number)
    EditText phoneNumberEditText;

    @BindView(R.id.phone_number_button)
    Button phoneNumberButton;

    private FragmentCallback callback;

    @Inject
    public PhoneNumberFragment() {
        // Requires empty public constructor
    }

    public static PhoneNumberFragment newInstance() {
        PhoneNumberFragment fragment = new PhoneNumberFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_enter_phone_number, container, false);

        setUnBinder(ButterKnife.bind(this, view));

        mPresenter.onAttach(this);

        return view;
    }

    @OnClick(R.id.phone_number_button)
    public void onNextClick(View v) {
        String phoneNumber = phoneNumberEditText.getText().toString();
        if (!Patterns.PHONE.matcher(phoneNumberEditText.getText().toString()).matches() || phoneNumber.length() != 10) {
            Bundle params = new Bundle();
            params.putString("phoneNumber", phoneNumber);
            phoneNumberEditText.setError("10 digit Phone number required.");
            return;
        }
        mPresenter.onPhoneNumberSuccess(phoneNumber);
    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }

    @Override
    protected void setUp(View view) {
        callback = (FragmentCallback) getActivity();
        phoneNumberEditText.addTextChangedListener(mTextWatcher);
    }

    @Override
    public void gotoNextFragment() {
        callback.gotoStepperScreen(RegistrationAdapter.STEP_ENTER_OTP);
    }

    private final TextWatcher mTextWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (count == 0) {
                phoneNumberButton.setEnabled(false);
            } else if (count == 10) {
                phoneNumberButton.setEnabled(true);
            }
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // TODO Auto-generated method stub
        }

        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public void afterTextChanged(Editable s) {
            String text = phoneNumberEditText.getText().toString();
            if (text.length() == 10) {
                phoneNumberButton.setEnabled(true);
            }
        }
    };
}
