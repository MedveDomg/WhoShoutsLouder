package omg.medved.whoshoutslouder;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

public class RecordsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}
