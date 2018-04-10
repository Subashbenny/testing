package com.parentof.mai.ui.onboarding.registration.otp;

import com.parentof.mai.di.FragmentScoped;
import com.parentof.mai.ui.base.BasePresenter;
import com.parentof.mai.utils.rx.SchedulerProvider;

import javax.inject.Inject;

/**
 * Created by gaurav on 14/06/17.
 */

@FragmentScoped
public class PhoneOTPPresenter<V extends PhoneOTPContract.View, I extends PhoneOTPContract.Interactor> extends BasePresenter<V, I> implements PhoneOTPContract.Presenter<V, I> {

    @Inject
    public PhoneOTPPresenter(I interactor,
                             SchedulerProvider schedulerProvider) {
        super(interactor, schedulerProvider);
    }

    @Override
    public void onPhoneOTPSuccess(String otp) {
        getView().gotoNextFragment();
        /*getView().showLoading();
        getCompositeDisposable().add(getDataManager()
                .setPhoneNumber(phoneNumber)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(@NonNull Long aLong) throws Exception {
                        *//*User user = getDataManager().getUser();
                        Log.i(TAG, user.toString());
                        getDataManager().setPhoneNumberDone();
                        getBaseView().hideLoading();*//*
                        goToNextFragment();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (!isViewAttached()) {
                            return;
                        }
                        getView().hideLoading();
                        getView().onError(R.string.some_error);
                    }
                }));*/
    }
}
