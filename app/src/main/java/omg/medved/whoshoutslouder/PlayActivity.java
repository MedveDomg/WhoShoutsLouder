package omg.medved.whoshoutslouder;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.liulishuo.magicprogresswidget.MagicProgressBar;

import java.util.Random;

import cn.dreamtobe.percentsmoothhandler.ISmoothTarget;

public class PlayActivity extends Activity {

    private MagicProgressBar demo1Mpb;

    private boolean isAnimActive;
    private final Random random = new Random();

    Button button;
    TextView tvPlayer;
    TextView tvTimer;
    TextView tvWord;
    Button noiseRecorder;
    float dBGlobal;
//    NoiseRecorder recorder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        System.out.println("test");

        Intent intent = getIntent();
        String word = intent.getExtras().toString();
        System.out.println(word);


         noiseRecorder = (Button) findViewById(R.id.noiserecorder);
        noiseRecorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        System.out.println("test Noise Recorder Button");
                        NoiseRecorder newRecoder = new NoiseRecorder();
//                        int dB = (int) Math.round(newRecoder.getNoiseLevel());
                         dBGlobal = (float) (newRecoder.getNoiseLevel()/100);
                        System.out.println(dBGlobal + " : convert in percent");
//                        anim();
                        if (dBGlobal >= 0.2f) {
                            demo1Mpb.setSmoothPercent(getIncreasedPercent(demo1Mpb,dBGlobal));
                        }
//                        newRecoder.stop();
//                        demo1Mpb.setPercent(0.0f);
//                        demo1Mpb.setSmoothPercent(getIncreasedPercent(demo1Mpb,dB));
                        handler.postDelayed(this,1000);

                    }
                });

            }
        });



        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
//NoiseRecorder recorder = new NoiseRecorder();
//        double a = recorder.getNoiseLevel();
//        System.out.println(a);
//        Button button = (Button) findViewById(R.id.button);

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
////                recorder.getNoiseLevel();
//                if (isAnimActive) {
//            return;
//        }
////                startNoiseRecorder();
//        demo1Mpb.setSmoothPercent(getIncreasedPercent(demo1Mpb));
//
//
//                final Handler handler = new Handler();
//
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//
//                        System.out.println("test Noise Recorder Button");
//                        NoiseRecorder newRecoder = new NoiseRecorder();
//                        newRecoder.getNoiseLevel();
//
//                        handler.postDelayed(this,100);
//                    }
//                });
//
//            }
//        });

        assignViews();

//        anim();
    }

    private void assignViews() {

        final Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Chunkfive.otf");



        demo1Mpb = (MagicProgressBar) findViewById(R.id.demo_1_mpb);

        button = (Button) findViewById(R.id.button);

        tvPlayer = (TextView) findViewById(R.id.player);

        tvTimer = (TextView) findViewById(R.id.timer);

        tvWord = (TextView) findViewById(R.id.word);


        tvPlayer.setTypeface(font);
        tvTimer.setTypeface(font);
        tvWord.setTypeface(font);

    }

    public void startNoiseRecorder() {



//        System.out.println("test method startNoiseRecorder");
//        NoiseRecorder noiseRecorder = new NoiseRecorder();
//        float a = (float) noiseRecorder.getNoiseLevel();
//
//        System.out.println(a);
    }

    private void anim() {
        final int ceil = 26;
        final int progress = 150;
//        NoiseRecorder noiseRecorder = new NoiseRecorder();
//        double a = noiseRecorder.getNoiseLevel();
        AnimatorSet demo1Mbp = new AnimatorSet();
        demo1Mbp.playTogether(
                ObjectAnimator.ofFloat(demo1Mpb, "percent", 0, 30 / 1500f)
//                ObjectAnimator.ofFloat
        );
        demo1Mbp.setDuration(600);
        demo1Mbp.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                isAnimActive = true;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                isAnimActive = false;
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        demo1Mbp.setInterpolator(new AccelerateInterpolator());
        demo1Mbp.start();
    }


    public void onReRandomPercent(final View view) {
        if (isAnimActive) {
            return;
        }
        anim();
    }

    public void onClickIncreaseSmoothly(final View view) {
        if (isAnimActive) {
            return;
        }
        System.out.println(dBGlobal);
//        demo1Mpb.setSmoothPercent(getIncreasedPercent(demo1Mpb,dBGlobal));
//        demo1Mpb.setSmoothPercent(getIncreasedPercent(demo1Mpb,0.0f));
//        demo1Mpb.set
    }

    private float getIncreasedPercent(ISmoothTarget target, float percentOfdB) {
        float increasedPercent = target.getPercent() + percentOfdB;
        return Math.min(1, increasedPercent);
    }


}
