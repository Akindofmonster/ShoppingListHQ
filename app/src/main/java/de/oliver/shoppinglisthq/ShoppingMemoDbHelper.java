package de.oliver.shoppinglisthq;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ShoppingMemoDbHelper extends SQLiteOpenHelper{

    private static final String LOG_TAG = ShoppingMemoDbHelper.class.getSimpleName();

    public static final String DB_NAME = "shopping_list.db";
    public static final int DB_VERSION = 1;

    public static final String TABLE_SHOPPING_LIST = "shopping_list";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PRODUCT = "product";
    public static final String COLUMN_QUANTITY = "quantity";

    public static final String SQL_CREATE_Shopping_List =
            "CREATE TABLE " + TABLE_SHOPPING_LIST +
                    "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_PRODUCT + " TEXT NOT NULL, " +
                    COLUMN_QUANTITY + " INTEGER NOT NULL);";



    public ShoppingMemoDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        Log.d(LOG_TAG, "DbHelper hat die Datenbank: " + getDatabaseName() + " erzeugt.");
    }

    //Wird nur aufgerufen, wenn die Datenbank neu erstellt wir
    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            Log.d(LOG_TAG, "Die Tabelle wird mit SQL-Befehl: " + SQL_CREATE_Shopping_List + " angelegt.");
            db.execSQL(SQL_CREATE_Shopping_List);
        }
        catch (Exception ex) {
            Log.e(LOG_TAG, "Fehler beim Anlegen der Tabelle: " + ex.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
