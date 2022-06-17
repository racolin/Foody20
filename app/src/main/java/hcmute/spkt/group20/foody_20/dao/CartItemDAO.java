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
import hcmute.spkt.group20.foody_20.model.Notification;
import hcmute.spkt.group20.foody_20.model.Order;
import hcmute.spkt.group20.foody_20.model.OrderItem;

public class CartItemDAO {
    public static final int ID = 0;
    public static final int CART_ID = 1;
    public static final int MEAL_ID = 2;
    public static final int AMOUNT = 3;

    public static List<CartItem> get(Context context, String condition) {
        List<CartItem> list = new ArrayList<>();

        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "SELECT * FROM cart_item";
        if (condition != null) {
            sql += " " + condition;
        }

        Cursor cs = db.rawQuery(sql, null);
        cs.moveToFirst();
        while (!cs.isAfterLast())
        {
            int id = cs.getInt(ID);
            int cart_id = cs.getInt(CART_ID);
            int meal_id = cs.getInt(MEAL_ID);
            int amount = cs.getInt(AMOUNT);

            CartItem cartItem = new CartItem(id, cart_id, meal_id, amount);
            list.add(cartItem);
            cs.moveToNext();
        }
        cs.close();
        db.close();
        return list;
    }

    public static List<CartItem> getCartItemsByCartId(Context context, int cart_id) {
        List<CartItem> cartItems = get(context, "WHERE cart_id=" + cart_id);
        return cartItems;
    }

    public static void save(Context context, CartItem cartItem) {
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL(cartItem.toSaveString());
        db.close();
    }

    public static void update(Context context, CartItem cartItem) {
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL(cartItem.toUpdateString());
        db.close();
    }

    public static void delete(Context context, CartItem cartItem) {
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL(cartItem.toDeleteString());
        db.close();
    }

    public static CartItem getCartItemByCartIdAndMealId(Context context, int cart_id, int meal_id) {
        List<CartItem> cartItems = get(context, String.format("WHERE cart_id=%d AND meal_id=%d", cart_id, meal_id));
        return cartItems.size() > 0 ? cartItems.get(0) : null;
    }
}
