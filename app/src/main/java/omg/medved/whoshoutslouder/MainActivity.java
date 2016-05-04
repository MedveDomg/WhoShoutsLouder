package omg.medved.whoshoutslouder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonStart = (Button) findViewById(R.id.start);
        buttonStart.setOnClickListener(this);

        Button buttonRecords = (Button) findViewById(R.id.records);
        buttonRecords.setOnClickListener(this);

        Button buttonRules = (Button) findViewById(R.id.rules);
        buttonRules.setOnClickListener(this);

        Button buttonAbout = (Button) findViewById(R.id.about);
        buttonAbout.setOnClickListener(this);



//        AdRequest request = new AdRequest.Builder()
//                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)        // All emulators
////                .addTestDevice("AC98C820A50B4AD8A2106EDE96FB87D4")  // An example device ID
//                .build();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start:
                System.out.println("hello");
                Intent intent = new Intent(this, StartActivity.class);
                startActivity(intent);
                break;
            case R.id.records:
                System.out.println("records");
                intent = new Intent(this, RecordsActivity.class);
                startActivity(intent);
                break;
            case R.id.rules:
                System.out.println("rules");
                intent = new Intent(this, RulesActivity.class);
                startActivity(intent);
                break;
            case R.id.about:
                System.out.println("about");
                intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                break;
        }
    }
}
