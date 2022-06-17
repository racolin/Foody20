package hcmute.spkt.group20.foody_20.dao;

import android.content.ContentProvider;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hcmute.spkt.group20.foody_20.DatabaseHelper;
import hcmute.spkt.group20.foody_20.Support;
import hcmute.spkt.group20.foody_20.model.Comment;
import hcmute.spkt.group20.foody_20.model.Notification;
import hcmute.spkt.group20.foody_20.model.Shop;
import hcmute.spkt.group20.foody_20.model.User;

public class CommentDao {
    public static final int ID = 0;
    public static final int USER_ID = 1;
    public static final int MEAL_ID = 2;
    public static final int TIME_CREATED = 3;
    public static final int RATE = 4;
    public static final int CONTENT = 5;

    public static List<Comment> get(Context context, String condition) {
        List<Comment> list = new ArrayList<>();
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "SELECT * FROM comment";
        if (condition != null) {
            sql += " " + condition;
        }

        Cursor cs = db.rawQuery(sql, null);
        cs.moveToFirst();
        while (!cs.isAfterLast())
        {
            int id = cs.getInt(ID);
            int user_id = cs.getInt(USER_ID);
            int meal_id = cs.getInt(MEAL_ID);
            Date time_created = Support.toDate(cs.getString(TIME_CREATED), "yyyy-MM-dd HH:mm:ss");
            float rate = cs.getFloat(RATE);
            String content = cs.getString(CONTENT);

            Comment comment = new Comment(id, user_id, meal_id, time_created, rate, content);
            list.add(comment);
            cs.moveToNext();
        }
        cs.close();
        db.close();
        return list;
    }

    public static List<Comment> getCommentsByMealId(Context context, int meal_id)
    {
        List<Comment> comments = get(context, "WHERE meal_id=" + meal_id);
        return comments;
    }

    public static void save(Context context, Comment comment)
    {
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL(comment.toSaveString());
        db.close();
    }
}
