package omg.medved.whoshoutslouder;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ListPlayersFragment extends DialogFragment {

    private OnListDialogItemSelect listener;
    private String title;
    private ArrayList<EditText> list;
    ArrayList<String> players;

//    public ListPlayersFragment(OnListDialogItemSelect listener, ArrayList<EditText> list, String title) {
//        this.listener=listener;
//        this.list=list;
//        this.title=title;
//    }
    public ListPlayersFragment() {

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        LayoutInflater inflater = new
//        View v = View.inflate(getActivity(), R.layout.customlist, false);
        Log.d("HI", "HELLO FROM DAILOGFRAGMENT");
        ListView lv = new ListView(getActivity());
        int sizeOfPlayers = savedInstanceState.getInt("size");
        players = new ArrayList<>();



//        ArrayAdapter<ArrayList> adapter = new ArrayAdapter<ArrayList>(getActivity(), android.R.layout.simple_list_item_1, players);
//
//        lv.setAdapter(adapter);

        return new AlertDialog.Builder(getActivity())
                .setTitle(title)
                .setCancelable(false)
                .create();

    }

    public interface OnListDialogItemSelect{
        public void onListItemSelected(String selection);
    }

}
