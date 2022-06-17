package hcmute.spkt.group20.foody_20.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.Date;

import hcmute.spkt.group20.foody_20.DatabaseHelper;
import hcmute.spkt.group20.foody_20.R;
import hcmute.spkt.group20.foody_20.Support;
import hcmute.spkt.group20.foody_20.model.User;

public class UserDao {
    public static final int ID = 0;
    public static final int FULL_NAME = 1;
    public static final int GENDER = 2;
    public static final int DOB = 3;
    public static final int PHONE = 4;
    public static final int GMAIL = 5;
    public static final int FACEBOOK = 6;
    public static final int ADDRESS = 7;
    public static final int USERNAME = 8;
    public static final int PASSWORD = 9;
    public static final int IMAGE = 10;

    public static int check(Context context, String username, String password)
    {
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        int id = -1;
        Cursor cs = db.rawQuery("SELECT * FROM user WHERE username='"+username + "' AND password='" + password+"'", null);
        cs.moveToFirst();
        if (!cs.isAfterLast()) {
            id = cs.getInt(ID);
        }
        cs.close();
        db.close();
        return id;
    }

    public static User getUserByUsername(Context context, String username) {
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cs = db.rawQuery("SELECT * FROM user WHERE username='"+username + "'", null);
        cs.moveToFirst();

        User user = null;
        if (!cs.isAfterLast()) {
            String full_name = cs.getString(FULL_NAME);
            int id = cs.getInt(ID);
            int gender = cs.getInt(GENDER);
            Date dob = new Date(cs.getLong(DOB));
            String phone = cs.getString(PHONE);
            String gmail = cs.getString(GMAIL);
            String facebook = cs.getString(FACEBOOK);
            String address = cs.getString(ADDRESS);
            String password = cs.getString(PASSWORD);
            int image = cs.getInt(IMAGE);

            user = new User(id, full_name, gender, dob, phone, gmail, facebook, address, username, password, image);
        }

        cs.close();
        db.close();
        return user;
    }

    public static User getUserById(Context context, int id) {
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cs = db.rawQuery("SELECT * FROM user WHERE id="+id, null);
        cs.moveToFirst();

        User user = null;
        if (!cs.isAfterLast()) {
            String username = cs.getString(USERNAME);
            String password = cs.getString(PASSWORD);
            int image = cs.getInt(IMAGE);
            int gender = cs.getInt(GENDER);

            String full_name = cs.getString(FULL_NAME);
            Date dob = Support.toDate(cs.getString(DOB), "yyyy-MM-dd HH:mm:ss");
            String phone = cs.getString(PHONE);
            String gmail = cs.getString(GMAIL);
            String facebook = cs.getString(FACEBOOK);
            String address = cs.getString(ADDRESS);

            user = new User(id, full_name, gender, dob, phone, gmail, facebook, address, username, password, image);
        }

        cs.close();
        db.close();
        return user;
    }

    public static void save(Context context, User user) {
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL(user.toSaveString());
        db.close();
    }

    public static int create(Context context, User user) {
        int user_id = -1;
        User u = getUserByUsername(context, user.getUsername());
        if (u == null) {
            save(context, user);
            user = getUserByUsername(context, user.getUsername());
            user_id = user.getId();
        }
        return user_id;
    }

    public static void update(Context context, User user) {
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL(user.toUpdateString());
        db.close();
    }
}
