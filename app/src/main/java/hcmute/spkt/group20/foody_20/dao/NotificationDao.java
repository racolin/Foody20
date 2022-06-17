package hcmute.spkt.group20.foody_20.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hcmute.spkt.group20.foody_20.DatabaseHelper;
import hcmute.spkt.group20.foody_20.Support;
import hcmute.spkt.group20.foody_20.model.Notification;

public class NotificationDao {
    public static final int ID = 0;
    public static final int USER_ID = 1;
    public static final int TITLE = 2;
    public static final int DESCRIPTION = 3;
    public static final int TIME = 4;

    public static List<Notification> get(Context context, String condition) {
        ArrayList<Notification> list = new ArrayList<>();

        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "SELECT * FROM notification";
        if (condition != null) {
            sql += " " + condition;
        }

        Cursor cs = db.rawQuery(sql, null);
        cs.moveToFirst();
        while (!cs.isAfterLast())
        {
            int id = cs.getInt(ID);
            int user_id = cs.getInt(USER_ID);
            String title = cs.getString(TITLE);
            String description = cs.getString(DESCRIPTION);
            Date time_created = Support.toDate(cs.getString(TIME), "yyyy-MM-ddd HH:mm:ss");

            Notification notification = new Notification(id, user_id, title, description, time_created);
            list.add(notification);
            cs.moveToNext();
        }
        cs.close();
        db.close();
        return list;
    }

    public static List<Notification> getNotificationsByUserId(Context context, int user_id)
    {
        List<Notification> notifications = get(context, "WHERE user_id=" + user_id + " ORDER BY time DESC");
        return notifications;
    }

    public static void save(Context context, Notification notification)
    {
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL(notification.toSaveString());
        db.close();
    }
}
