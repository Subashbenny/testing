package com.parentof.mai.ui.mai;

import android.content.Context;
import android.media.SoundPool;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.parentof.mai.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gaurav on 07/03/18.
 */

public class MaiView extends RelativeLayout {

    View rootView;

    @BindView(R.id.mai_chat_1)
    TextView maiChat1;

    @BindView(R.id.mai_chat_2)
    TextView maiChat2;

    @BindView(R.id.mai_chat_3)
    TextView maiChat3;

    @BindView(R.id.mai_logo)
    ImageView maiLogo;

    List<String> texts;

    Handler handler = new Handler();

    private final SoundPool soundPool = new SoundPool(1, 5, 0);
    int maiAlertId;

    int currentDelay = 0;

    public MaiView(Context context) {
        super(context);
        init(context);
    }

    public MaiView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        rootView = inflate(context, R.layout.mai, this);
        ButterKnife.bind(this, rootView);
        texts = new ArrayList<>();
        maiChat1.setVisibility(GONE);
        maiChat2.setVisibility(GONE);
        maiChat3.setVisibility(GONE);
        maiLogo.setVisibility(GONE);
        maiAlertId = this.soundPool.load(context, R.raw.mai_alert, 1);
    }

    public void addChat(final String text) {
        if (currentDelay == 0) currentDelay += 10;
        else currentDelay += 2000;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                maiChat1.setVisibility(GONE);
                if (texts.size() == 0) {
                    soundPool.play(maiAlertId, 1.0f, 1.0f, 1, 0, 1.0f);
                    maiLogo.setVisibility(VISIBLE);
                } else if (texts.size() == 1) {
                    maiChat2.setText(maiChat1.getText());
                    maiChat2.setVisibility(VISIBLE);
                } else if (texts.size() > 1) {
                    maiChat3.setText(maiChat2.getText());
                    maiChat3.setVisibility(VISIBLE);
                    maiChat2.setText(maiChat1.getText());
                    maiChat2.setVisibility(VISIBLE);
                }
                texts.add(text);
                maiChat1.setText(text);
                maiChat1.setVisibility(VISIBLE);
            }
        }, currentDelay);
    }
}
