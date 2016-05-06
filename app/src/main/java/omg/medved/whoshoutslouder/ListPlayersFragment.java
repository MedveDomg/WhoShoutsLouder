package omg.medved.whoshoutslouder;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListPlayersFragment extends DialogFragment {


    int mNum;
    ListView mListView;
    static ArrayList<Player> mPlayers;
    ArrayAdapter<Player> mStringArrayAdapter;
//    String[] players = {"Dima", "Guf", "ferrari"};

    /**
     * Create a new instance of MyDialogFragment, providing "num"
     * as an argument.
     */
    static ListPlayersFragment newInstance(ArrayList arrayList) {
        ListPlayersFragment f = new ListPlayersFragment();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putParcelableArrayList("mPlayers", arrayList);
        f.setArguments(args);

        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPlayers = getArguments().getParcelableArrayList("mPlayers");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.customlist, container, false);

        mListView = (ListView) v.findViewById(R.id.custom_listview);

        mStringArrayAdapter = new ArrayAdapter<Player>(getActivity(), android.R.layout.simple_list_item_1, mPlayers);
        mListView.setAdapter(mStringArrayAdapter);

        return v;
    }
}

