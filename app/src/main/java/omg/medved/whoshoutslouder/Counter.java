package omg.medved.whoshoutslouder;

import android.os.Handler;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by medvedomg on 30.03.16.
 */
public class Counter {

    private int counter = 0;
    private TextView textView;
    private ImageButton imageButtonPlus;
    private ImageButton imageButtonMinus;


    public Counter(TextView textView, ImageButton imageButtonPlus, ImageButton imageButtonMinus) {
        this.textView = textView;
        this.imageButtonMinus = imageButtonMinus;
        this.imageButtonPlus = imageButtonPlus;
    }

    public void plusOne() {
        Handler h = new Handler();
        h.post(new Runnable() {
            @Override
            public void run() {
                counter++;
                textView.setText(Integer.toString(counter));
            }
        });
    }

    public void minusOne() {
        Handler h = new Handler();
        h.post(new Runnable() {
            @Override
            public void run() {
                if (counter > 0) {

                    counter--;
                    textView.setText(Integer.toString(counter));
                }
            }
        });
    }
}
