package omg.medved.whoshoutslouder;

import android.app.ActionBar;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
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

//import android.v4.app.Fragment;


public class StartActivity extends FragmentActivity  {

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

    ArrayList<Player> mNamesListOfPlayers;
    private static int mStackLevel = 0;



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        assignViews();

        EditText editText = new EditText(this);
        editText.setText("sooka");

        mNamesListOfPlayers = new ArrayList<>();

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
            case R.id.imagebutton_plus:
                counterPlayers.plusOne();
//                Log.d(TAG, counterPlayers + "PLUS");
//                adapterPlayers.add(editText);
//                adapterPlayers.notifyDataSetChanged();
                mNamesListOfPlayers.add(new Player());

                Log.d(LOG_TAG, "Amount of players: " + mNamesListOfPlayers.size());
                break;
            case R.id.imagebutton_minus:
                counterPlayers.minusOne();
                Log.d(TAG, "PLUS");

//                playersArrayList.remove("Player");
//                adapterPlayers.add(editText);
//                adapterPlayers.notifyDataSetChanged();
                break;
            case R.id.imagebutton_minus_minutes:
                counterMinutes.minusOne();

                Log.d(TAG, counterPlayers.toString() + "PLUS");
                break;
            case R.id.imagebutton_plus_minutes:
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
                break;
            case R.id.amount_of_players:
                showFragment();
                break;
        }
    }


    void assignViews() {

        final Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Chunkfive.otf");


        TextView howManyPlayers = (TextView) findViewById(R.id.textview_how_many_players);

        howManyPlayers.setTypeface(font);

        tvAmountOfPlayers = (TextView) findViewById(R.id.amount_of_players);
        tvAmountOfPlayers.setTypeface(font);

        tvAmountOfPlayers.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                return false;
            }
        });

        TextView tvTimeForGame = (TextView) findViewById(R.id.time_for_game);
        tvTimeForGame.setTypeface(font);

        tvAmountOfMinutes = (TextView) findViewById(R.id.amount_of_minutes);
        tvAmountOfMinutes.setTypeface(font);

        TextView tvWhatWord = (TextView) findViewById(R.id.what_word);
        tvWhatWord.setTypeface(font);

        edWord = (EditText) findViewById(R.id.edit_word);
        edWord.setTypeface(font);

        imageButtonPlus = (ImageButton) findViewById(R.id.imagebutton_plus);

        imageButtonPlusMinutes = (ImageButton) findViewById(R.id.imagebutton_plus_minutes);

        imageButtonMinus = (ImageButton) findViewById(R.id.imagebutton_minus);

        imageButtonMinusMinutes = (ImageButton) findViewById(R.id.imagebutton_minus_minutes);

        Button buttonPlay = (Button) findViewById(R.id.play);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }


    private void showFragment() {
        mStackLevel++;

        // DialogFragment.show() will take care of adding the fragment
        // in a transaction.  We also want to remove any currently showing
        // dialog, so make our own transaction and take care of that here.
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment prev = getSupportFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        // Create and show the dialog.
        DialogFragment newFragment = ListPlayersFragment.newInstance(mNamesListOfPlayers);
        newFragment.show(ft, "dialog");
    }

}








