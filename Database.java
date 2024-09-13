package com.example.travel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;



public class Database extends SQLiteOpenHelper {

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry1="create table users(username text,email text,password text);";
        sqLiteDatabase.execSQL(qry1);

        String qry2="create table yourplaces(place text, time text);";
        sqLiteDatabase.execSQL(qry2);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

        public void register(String username, String email, String password) {
            ContentValues cv = new ContentValues();
            cv.put("username", username);
            cv.put("email", email);
            cv.put("password", password);

            SQLiteDatabase db = getWritableDatabase();
            db.insert("users", null, cv);
            db.close();
        }


    public int Login(String username, String password) {
        int result = 0;
        SQLiteDatabase db = getReadableDatabase();

        try {
            String[] selectionArgs = {username, password.trim()};  // Trim the password
            Cursor c = db.rawQuery("SELECT * FROM users WHERE username=? AND password=?", selectionArgs);

            if (c.moveToFirst()) {
                // Username and password match
                result = 1;
            } else {
                // Username and password do not match
                result = 0;
            }

            c.close();
        } catch (Exception e) {
            // Log any exceptions for debugging
            e.printStackTrace();
        } finally {
            db.close();
        }

        return result;
    }

}
