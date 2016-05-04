package omg.medved.whoshoutslouder;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class StartActivity extends FragmentActivity implements ListPlayersFragment.OnListDialogItemSelect {

    final String LOG_TAG = "myLogs";




    ArrayList<EditText> playersArrayList;

    ArrayAdapter<EditText> adapterPlayers;

    final int DIALOG_ADAPTER = 2;
    final int DIALOG_CURSOR = 3;
    int cnt = 0;
    Cursor cursor;

    String[] players;

    int amountOfPlayers;


    public static int counter = 1;

    final int DIALOG_ITEMS = 1;


    private static final String TAG = "myTAG";
   public Counter counterPlayers;
    Counter counterMinutes;
    EditText edWord;
    public final String WORD_FROM_EDIT = "WORD";

    TextView tvAmountOfPlayers;
    TextView tvAmountOfMinutes;

    ImageButton imageButtonPlus;
    ImageButton imageButtonMinus;

    ImageButton imageButtonPlusMinutes;
    ImageButton imageButtonMinusMinutes;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        assignViews();

        EditText editText = new EditText(this);
        editText.setText("sooka");

//        playersArrayList = new ArrayList<EditText>();
//        playersArrayList.add(0,editText);
//
//        adapterPlayers = new ArrayAdapter<EditText>(this,
//               android.R.layout.simple_list_item_1,playersArrayList);
        counterPlayers = new Counter(tvAmountOfPlayers, imageButtonPlus, imageButtonMinus);
        counterMinutes = new Counter(tvAmountOfMinutes, imageButtonPlusMinutes, imageButtonMinusMinutes);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageButtonPlus:
                counterPlayers.plusOne();
//                Log.d(TAG, counterPlayers + "PLUS");
//                adapterPlayers.add(editText);
//                adapterPlayers.notifyDataSetChanged();
                break;
            case R.id.imageButtonMinus:
                counterPlayers.minusOne();
                Log.d(TAG, "PLUS");
//                playersArrayList.remove("Player");
//                adapterPlayers.add(editText);
//                adapterPlayers.notifyDataSetChanged();
                break;
            case R.id.imagebuttonminusminutes:
                counterMinutes.minusOne();

                Log.d(TAG, counterPlayers.toString() + "PLUS");
                break;
            case R.id.imageButtonplusminutes:
                counterMinutes.plusOne();
                Log.d(TAG, counterPlayers.toString() + "PLUS");
                break;
            case R.id.play:
                System.out.println("TEST PLAY");
                String word = edWord.getText().toString();
                System.out.println(word + " WORD");
                Log.d(TAG, word);
                Intent intent = new Intent(this, PlayActivity.class);
                intent.putExtra(WORD_FROM_EDIT, word);
                startActivity(intent);
        }
    }


    void assignViews() {

        final Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Chunkfive.otf");




        TextView howManyPlayers = (TextView) findViewById(R.id.howmanyplayers);

        howManyPlayers.setTypeface(font);

        tvAmountOfPlayers = (TextView) findViewById(R.id.amountofplayers);
        tvAmountOfPlayers.setTypeface(font);

        tvAmountOfPlayers.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                return false;
            }
        });

        TextView tvTimeForGame = (TextView) findViewById(R.id.timeforgame);
        tvTimeForGame.setTypeface(font);

        tvAmountOfMinutes = (TextView) findViewById(R.id.amountofminutes);
        tvAmountOfMinutes.setTypeface(font);

        TextView tvWhatWord = (TextView) findViewById(R.id.whatword);
        tvWhatWord.setTypeface(font);

        edWord = (EditText) findViewById(R.id.editword);
        edWord.setTypeface(font);

        imageButtonPlus = (ImageButton) findViewById(R.id.imageButtonPlus);

        imageButtonPlusMinutes = (ImageButton) findViewById(R.id.imageButtonplusminutes);

        imageButtonMinus = (ImageButton) findViewById(R.id.imageButtonMinus);

        imageButtonMinusMinutes = (ImageButton) findViewById(R.id.imagebuttonminusminutes);

        Button buttonPlay = (Button) findViewById(R.id.play);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    public void openDialogListView(View view) {
        showFragment();
//        ListPlayersFragment listPlayersFragment = new ListPlayersFragment();
    }



//    protected Dialog onCreateDialog(int id) {
//        Dialog dialog;
//        switch(id) {
//            case 0:
//
//                String stringFont = "fonts/Chunkfive.otf";
//
//                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
//
//                LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//                alertDialogBuilder.setView(inflater.inflate(R.layout.login, null));
//
////                alertDialogBuilder.set
//                alertDialogBuilder.setTitle("Players");
//
//                alertDialogBuilder.show();
//                break;
//            default:
//                dialog = null;
//        }
//        return null;
//    }

//    protected void onPrepareDialog(int id, Dialog dialog) {
//        // получаем доступ к адаптеру списка диалога
//        AlertDialog aDialog = (AlertDialog) dialog;
//        ListAdapter lAdapter = aDialog.getListView().getAdapter();
//
//        switch (id) {
//
//            case 0:
//                // проверка возможности преобразования
//                if (lAdapter instanceof BaseAdapter) {
//                    // преобразование и вызов метода-уведомления о новых данных
//                    BaseAdapter bAdapter = (BaseAdapter) lAdapter;
//                    bAdapter.notifyDataSetChanged();
//                }
//                break;
//            default:
//                break;
//        }
//    };

    // обработчик нажатия на пункт списка диалога
    DialogInterface.OnClickListener myClickListener = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            // выводим в лог позицию нажатого элемента
            Log.d(LOG_TAG, "which = " + which);
        }
    };

    private void showFragment(){
        FragmentManager fm = getSupportFragmentManager();
        ListPlayersFragment newFragment = new ListPlayersFragment(this,playersArrayList,"Players");
        newFragment.show(fm,"tag");
    }

    @Override
    public void onListItemSelected(String selection) {

    }

}








