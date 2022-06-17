package hcmute.spkt.group20.foody_20.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import hcmute.spkt.group20.foody_20.DatabaseHelper;
import hcmute.spkt.group20.foody_20.model.Meal;

public class SavedMealDAO {

    public static final int ID = 0;
    public static final int USER_ID = 1;
    public static final int MEAL_ID = 2;

    public static ArrayList<Meal> get(Context context, String condition){
        ArrayList<Meal> list = new ArrayList<>();

        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "SELECT * FROM saved_meal";
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
            list.add(MealDao.getMealById(context, meal_id));
            cs.moveToNext();
        }
        cs.close();
        db.close();
        return list;
    }

    public static List<Meal> getSavedMealsByUserId(Context context, int user_id) {
        List<Meal> meals = get(context, "WHERE user_id=" + user_id);
        return meals;
    }

    public static void save(Context context, int user_id, int meal_id) {
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();

        List<Meal> meals = get(context, String.format("WHERE user_id=%d AND meal_id=%d", user_id, meal_id));
        if (meals.size() == 0) {
            db.execSQL(String.format("INSERT INTO saved_meal VALUES(null, %d, %d)", user_id, meal_id));
        }
        db.close();
    }

    public static int saved_count(Context context, int meal_id) {

        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();

        List<Meal> meals = get(context, String.format("WHERE meal_id=%d", meal_id));
        db.close();

        return meals == null ? 0 : meals.size();
    }

    public static void delete(Context context, int user_id, int meal_id) {
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();

        List<Meal> meals = get(context, String.format("WHERE user_id=%d AND meal_id=%d", user_id, meal_id));
        if (meals.size() != 0) {
            db.execSQL(String.format("DELETE FROM saved_meal WHERE user_id=%d AND meal_id=%d)", user_id, meal_id));
        }
        db.close();
    }
}
