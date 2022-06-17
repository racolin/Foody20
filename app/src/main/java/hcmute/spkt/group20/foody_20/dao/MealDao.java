package hcmute.spkt.group20.foody_20.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hcmute.spkt.group20.foody_20.DatabaseHelper;
import hcmute.spkt.group20.foody_20.Support;
import hcmute.spkt.group20.foody_20.model.Meal;
import hcmute.spkt.group20.foody_20.model.Notification;
import hcmute.spkt.group20.foody_20.model.Shop;

public class MealDao {
    public static final int ID = 0;
    public static final int NAME = 1;
    public static final int SHOP_ID = 2;
    public static final int DESCRIPTION = 3;
    public static final int PRICE = 4;
    public static final int SAVED_COUNT = 5;
    public static final int SHARED_COUNT = 6;
    public static final int IMAGE = 7;

    public static List<Meal> get(Context context, String condition) {
        ArrayList<Meal> list = new ArrayList<>();

        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "SELECT * FROM meal";
        if (condition != null) {
            sql += " " + condition;
        }

        Cursor cs = db.rawQuery(sql, null);
        cs.moveToFirst();
        while (!cs.isAfterLast())
        {
            int id = cs.getInt(ID);
            String name = cs.getString(NAME);
            int shop_id = cs.getInt(SHOP_ID);
            String description = cs.getString(DESCRIPTION);
            int price = cs.getInt(PRICE);
            int saved_count = cs.getInt(SAVED_COUNT);
            int shared_count = cs.getInt(SHARED_COUNT);
            int image = cs.getInt(IMAGE);

            Meal meal = new Meal(id, name, shop_id, description, price, saved_count, shared_count, image);
            list.add(meal);
            cs.moveToNext();
        }
        cs.close();
        db.close();
        return list;
    }

    public static List<Meal> getAllMeals(Context context){
        List<Meal> meals = get(context, null);
        return meals;
    }

    public static List<Meal> getMealsByShopId(Context context, int shop_id){
        List<Meal> meals = get(context, "WHERE shop_id=" + shop_id);
        return meals;
    }

    public static List<Meal> getMealsBySearch(Context context, String text){
        String str = "";
        if (text != null) {
            str = text;
        }
        List<Meal> meals = get(context, "WHERE name LIKE '%" + str + "%'");
        return meals;
    }

    public static Meal getMealById(Context context, int id)
    {
        List<Meal> meals = get(context, "WHERE id=" + id);
        return meals.size() > 0 ? meals.get(0) : null;
    }
}
