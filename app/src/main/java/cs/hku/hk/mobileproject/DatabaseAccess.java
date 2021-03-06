package cs.hku.hk.mobileproject;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
}

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }
    public long count() {
        return DatabaseUtils.queryNumEntries(database,"user");
    }
    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    /**
     * Read all quotes from the database.
     *
     * @return a List of quotes
     */
    public Cursor extract(String sql,String[] args) {

        Cursor cursor = database.rawQuery(sql , args);
        return cursor;
    }


    public void insert(String insert) {
        this.database.execSQL(insert);
    }

    public List<String> selectSQL(String item, String table){
        String query = "select "+item+" From "+table;
        Cursor cursor = database.rawQuery("SELECT * FROM user", null);
        List<String> result = new ArrayList<>();

        if(cursor.getCount()>0){
            if(cursor.moveToFirst()){
                do{
                    result.add(cursor.getString(0));

                }while (cursor.moveToNext());
            }
        }
        return result;
    }

    public List<String> whereSQL(String query,String[] whereArgs){

        Cursor cursor = database.rawQuery(query, whereArgs);
        List<String> result = new ArrayList<>();

        if(cursor.getCount()>0){
            if(cursor.moveToFirst()){
                do{
                    result.add(cursor.getString(0));

                }while (cursor.moveToNext());
            }
        }
        return result;
    }
}