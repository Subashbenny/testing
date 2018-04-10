package com.parentof.mai.receivers;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Telephony;
import android.telephony.SmsMessage;

import com.parentof.mai.callbacks.SMSCallBackInterface;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import timber.log.Timber;

/**
 * Created by gaurav on 22/01/18.
 */

public class SMSReceiver extends BroadcastReceiver {
    String smsFormNumber = "";
    String smsMessageBody = "";
    SharedPreferences preferences;
    private static SMSCallBackInterface mListener;


    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public void onReceive(Context context, Intent intent) {
        Timber.d("Call OnReceive-");
        if (null != context && intent != null) {
            preferences = PreferenceManager.getDefaultSharedPreferences(context);
            Timber.d("inside onReceive reading sms");
            Bundle bundle = intent.getExtras();
            StringBuilder finalSMSBody = new StringBuilder();
            if (bundle != null) {
                Object[] pdus = (Object[]) bundle.get("pdus");
                if (pdus == null)
                    return;
                SmsMessage[] msgs = Telephony.Sms.Intents.getMessagesFromIntent(intent);
                for (int i = 0; i < msgs.length; i++) {
                    smsFormNumber = msgs[i].getOriginatingAddress(); // get the number from sender
                    Timber.d("smsFormNumber--" + smsFormNumber);
                    finalSMSBody.append(msgs[i].getMessageBody()); // append the message body to final string
                }
                if (smsFormNumber != null) {
                    smsMessageBody = finalSMSBody.toString(); // getting sms body and storing into final string
                    Timber.d("smsMessageBody--" + smsMessageBody);

                }
                if (smsMessageBody != null && !smsMessageBody.isEmpty() && smsFormNumber.contains("askMAI")) {
                    Timber.d("inside final if reading sms");
                    Pattern p = Pattern.compile("(|^)\\d{4}");
                    Matcher m = p.matcher(smsMessageBody);
                    if (m.find()) {
                        String otp = m.group(0);
                        Timber.d("SMS OTP--" + otp);
                        if (mListener != null && otp != null)
                            mListener.populateSMSOtp(otp);
                    }
                }
            }

        }
    }


    public static void bindListener(SMSCallBackInterface listener) {
        mListener = listener;
    }
}
