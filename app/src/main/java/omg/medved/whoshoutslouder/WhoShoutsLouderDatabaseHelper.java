package omg.medved.whoshoutslouder;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by medvedomg on 16.04.16.
 */
public class WhoShoutsLouderDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "WhoShoutsLouder";

    private static final int DB_VERSION = 1;

    public WhoShoutsLouderDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, 0, DB_VERSION);


    }

    private static void insertRecords(SQLiteDatabase db, String data, String player, String time, String score) {
        ContentValues recordsValues = new ContentValues();
        recordsValues.put("DATA", data);
        recordsValues.put("PLAYER", player);
        recordsValues.put("TIME", time);
        recordsValues.put("SCORE", score);

        db.insert("RECORDS", null, recordsValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 1) {
            db.execSQL("CREATE TABLE RECORDS (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "DATA TEXT, " +
                    "PLAYER TEXT, " +
                    "TIME TEXT, " +
                    "SCORE TEXT);");
            insertRecords(db, "16.04.16", "MedveDomg", "18:06","100 dB");
            insertRecords(db, "29.05.16", "SubZero", "11:54","67 dB");
            insertRecords(db, "07.03.15", "Ritka", "22:33","28 dB");
        }
        if (oldVersion < 2) {
//            db.execSQL("ALTER TABLE DRINK ADD COLUMN FAVORITE NUMERIC;");
        }
    }
}
