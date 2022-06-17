package hcmute.spkt.group20.foody_20.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import hcmute.spkt.group20.foody_20.DatabaseHelper;
import hcmute.spkt.group20.foody_20.model.OrderItem;

public class OrderItemDao {
    public static final int ID = 0;
    public static final int ORDER_ID = 1;
    public static final int MEAL_ID = 2;
    public static final int AMOUNT = 3;
    public static final int PRICE = 4;

    public static List<OrderItem> get(Context context, String condition) {
        ArrayList<OrderItem> list = new ArrayList<>();

        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "SELECT * FROM order_item";
        if (condition != null) {
            sql += " " + condition;
        }

        Cursor cs = db.rawQuery(sql, null);
        cs.moveToFirst();
        while (!cs.isAfterLast())
        {
            int id = cs.getInt(ID);
            int order_id = cs.getInt(ORDER_ID);
            int meal_id = cs.getInt(MEAL_ID);
            int amount = cs.getInt(AMOUNT);
            int price = cs.getInt(PRICE);

            OrderItem orderItem = new OrderItem(id, order_id, meal_id, amount, price);
            list.add(orderItem);
            cs.moveToNext();
        }
        cs.close();
        db.close();
        return list;
    }

    public static List<OrderItem> getOrderItemsByOrderId(Context context, int order_id)
    {
        List<OrderItem> orderItems = get(context, "WHERE order_id=" + order_id);
        return orderItems;
    }

    public static void save(Context context, OrderItem orderItem) {
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL(orderItem.toSaveString());
        db.close();
    }
}
