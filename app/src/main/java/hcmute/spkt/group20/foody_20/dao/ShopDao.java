package hcmute.spkt.group20.foody_20.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import hcmute.spkt.group20.foody_20.DatabaseHelper;
import hcmute.spkt.group20.foody_20.model.Meal;
import hcmute.spkt.group20.foody_20.model.Shop;
import hcmute.spkt.group20.foody_20.model.ShopChain;

public class ShopDao {
    public static final int ID = 0;
    public static final int NAME = 1;
    public static final int SHOP_CHAIN_ID = 2;
    public static final int TIME_OPEN = 3;
    public static final int DESCRIPTION = 4;
    public static final int PHONE_NUMBER = 5;
    public static final int ADDRESS = 6;
    public static final int DISTANCE = 7;
    public static final int IMAGE = 8;

    public static ArrayList<Shop> get(Context context, String condition){
        ArrayList<Shop> list = new ArrayList<>();

        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "SELECT * FROM shop";
        if (condition != null) {
            sql += " " + condition;
        }

        Cursor cs = db.rawQuery(sql, null);
        cs.moveToFirst();
        while (!cs.isAfterLast())
        {
            int id = cs.getInt(ID);
            int shop_chain_id = cs.getInt(SHOP_CHAIN_ID);
            String phone_number = cs.getString(PHONE_NUMBER);
            String name = cs.getString(NAME);
            String description = cs.getString(DESCRIPTION);
            String address = cs.getString(ADDRESS);
            String time_open = cs.getString(TIME_OPEN);
            String distance = cs.getString(DISTANCE);
            int image = cs.getInt(IMAGE);

            Shop shop = new Shop(id, name, shop_chain_id, time_open, description, phone_number, address,
                    distance, image);
            list.add(shop);
            cs.moveToNext();
        }
        cs.close();
        db.close();
        return list;
    }

    public static List<Shop> getAllShops(Context context) {
        return get(context, null);
    }

    public static List<Shop> getShopsByShopChainId(Context context, int shop_chain_id) {
        return get(context, "WHERE shop_chain_id=" + shop_chain_id);
    }

    public static Shop getShopById(Context context , int id){
        List<Shop> shops = get(context, "WHERE id=" + id);
        Shop shop = null;
        if (shops.size() > 0) {
            shop = shops.get(0);
        }
        return shop;
    }
}
