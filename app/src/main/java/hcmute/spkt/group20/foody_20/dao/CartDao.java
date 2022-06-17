package hcmute.spkt.group20.foody_20.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hcmute.spkt.group20.foody_20.DatabaseHelper;
import hcmute.spkt.group20.foody_20.Support;
import hcmute.spkt.group20.foody_20.model.Cart;
import hcmute.spkt.group20.foody_20.model.CartItem;
import hcmute.spkt.group20.foody_20.model.Meal;
import hcmute.spkt.group20.foody_20.model.Order;
import hcmute.spkt.group20.foody_20.model.Shop;

public class CartDao{
    public static final int ID = 0;
    public static final int USER_ID = 1;
    public static final int SHOP_ID = 2;

    public static List<Cart> get(Context context, String condition) {
        ArrayList<Cart> list = new ArrayList<>();

        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "SELECT * FROM cart";
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

            Cart cart = new Cart(id, user_id, shop_id);
            list.add(cart);
            cs.moveToNext();
        }
        cs.close();
        db.close();
        return list;
    };

    public static List<Cart> getCartsByUserID(Context context , int user_id){
        List<Cart> carts = get(context, "WHERE user_id=" + user_id);
        return carts;
    }

    public static Cart getCartByShopIdAndUserId(Context context, int shop_id, int user_id) {
        List<Cart> carts = get(context, String.format("WHERE user_id=%d AND shop_id=%d", user_id, shop_id));
        return carts.size() > 0 ? carts.get(0) : null;
    }

    public static void save(Context context, Cart cart) {
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL(cart.toSaveString());
        db.close();
    }

    public static void delete(Context context, Cart cart) {
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL(cart.toDeleteString());
        db.close();
    }
}
