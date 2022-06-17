package hcmute.spkt.group20.foody_20.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import hcmute.spkt.group20.foody_20.DatabaseHelper;
import hcmute.spkt.group20.foody_20.model.Meal;
import hcmute.spkt.group20.foody_20.model.Shop;

public class SavedShopDAO {
    public static final int ID = 0;
    public static final int USER_ID = 1;
    public static final int SHOP_ID = 2;

    public static ArrayList<Shop> get(Context context, String condition){
        ArrayList<Shop> list = new ArrayList<>();

        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "SELECT * FROM saved_shop";
        if (condition != null) {
            sql += " " + condition;
        }

        Cursor cs = db.rawQuery(sql, null);
        cs.moveToFirst();
        while (!cs.isAfterLast())
        {
            int id = cs.getInt(ID);
            int user_id = cs.getInt(USER_ID);
            int shop_id = cs.getInt(SHOP_ID);
            list.add(ShopDao.getShopById(context, shop_id));
            cs.moveToNext();
        }
        cs.close();
        db.close();
        return list;
    }

    public static List<Shop> getSavedShopsByUserId(Context context, int user_id) {
        List<Shop> shops = get(context, "WHERE user_id=" + user_id);
        return shops;
    }

    public static void save(Context context, int user_id, int shop_id) {
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();

        List<Shop> shops = get(context, String.format("WHERE user_id=%d AND shop_id=%d", user_id, shop_id));
        if (shops.size() == 0) {
            db.execSQL(String.format("INSERT INTO saved_shop VALUES(null, %d, %d)", user_id, shop_id));
        }
        db.close();
    }

    public static int saved_count(Context context, int shop_id) {

        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();

        List<Shop> shops = get(context, String.format("WHERE shop_id=%d", shop_id));
        db.close();

        return shops == null ? 0 : shops.size();
    }

    public static void delete(Context context, int user_id, int shop_id) {
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();

        List<Shop> shops = get(context, String.format("WHERE user_id=%d AND shop_id=%d", user_id, shop_id));
        if (shops.size() != 0) {
            db.execSQL(String.format("DELETE FROM saved_shop WHERE user_id=%d AND shop_id=%d)", user_id, shop_id));
        }
        db.close();
    }
}
