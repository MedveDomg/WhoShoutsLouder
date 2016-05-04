package omg.medved.whoshoutslouder;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.EditText;

import java.util.ArrayList;

public class ListPlayersFragment extends DialogFragment {

    private OnListDialogItemSelect listener;
    private String title;
    private ArrayList<EditText> list;

    public ListPlayersFragment(OnListDialogItemSelect listener, ArrayList<EditText> list, String title) {
        this.listener=listener;
        this.list=list;
        this.title=title;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        return new AlertDialog.Builder(getActivity())
                .setTitle(title)
                .setCancelable(false)
                .create();

    }

    public interface OnListDialogItemSelect{
        public void onListItemSelected(String selection);
    }

}
