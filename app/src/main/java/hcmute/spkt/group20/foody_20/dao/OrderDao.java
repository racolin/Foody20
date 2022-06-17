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
import hcmute.spkt.group20.foody_20.model.Notification;
import hcmute.spkt.group20.foody_20.model.Order;
import hcmute.spkt.group20.foody_20.model.OrderItem;
import hcmute.spkt.group20.foody_20.model.Shop;
import hcmute.spkt.group20.foody_20.model.User;

public class OrderDao {
    public static final int ID = 0;
    public static final int USER_ID = 1;
    public static final int SH0P_ID = 2;
    public static final int TIME_START = 3;
    public static final int TIME_END = 4;
    public static final int STATUS = 5;
    public static final int CAUSE = 6;

    public static List<Order> get(Context context, String condition) {
        ArrayList<Order> list = new ArrayList<>();

        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "SELECT * FROM `order`";
        if (condition != null) {
            sql += " " + condition;
        }

        Cursor cs = db.rawQuery(sql, null);
        cs.moveToFirst();
        while (!cs.isAfterLast())
        {
            int id = cs.getInt(ID);
            int user_id = cs.getInt(USER_ID);
            int shop_id = cs.getInt(SH0P_ID);
            Date time_start = Support.toDate(cs.getString(TIME_START), "yyyy-MM-dd HH:mm:ss");
            Date timm_end = Support.toDate(cs.getString(TIME_END), "yyyy-MM-dd HH:mm:ss");
            String status = cs.getString(STATUS);
            String cause = cs.getString(CAUSE);

            Order order = new Order(id, user_id, shop_id, time_start, timm_end, status, cause);
            list.add(order);
            cs.moveToNext();
        }
        cs.close();
        db.close();
        return list;
    }

    public static List<Order> getOrdersByUserId(Context context, int user_id) {
        List<Order> orders = get(context, "WHERE user_id=" + user_id);
        return orders;
    }

    public static List<Order> getOrdersByUserIdAndShopId(Context context, int user_id, int shop_id) {
        List<Order> orders = get(context, String.format("WHERE user_id=%d AND shop_id=%d", user_id, shop_id));
        return orders;
    }

    public static void save(Context context, Order order)
    {
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL(order.toSaveString());
        db.close();
    }

    public static void update(Context context, Order order)
    {
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL(order.toUpdateString());
        db.close();
    }

    public static void saveFromCart(Context context, Cart cart, Date time)
    {
        Order order = new Order(-1, cart.getUser_id(), cart.getShop_id(), new Date(), time, "Đang đợi", "");
        save(context, order);
        CartDao.delete(context, cart);
        List<Order> orders = getOrdersByUserIdAndShopId(context, order.getUser_id(), order.getShop_id());
        order.setId(orders.get(orders.size() - 1).getId());
        int total = 0;
        List<CartItem> cartItems = CartItemDAO.getCartItemsByCartId(context, cart.getId());
        for (CartItem cartItem : cartItems) {
            CartItemDAO.delete(context, cartItem);
            OrderItem orderItem = new OrderItem(-1, order.getId(), cartItem.getMeal_id(),
                    cartItem.getAmount(), MealDao.getMealById(context, cartItem.getMeal_id()).getPrice());
            OrderItemDao.save(context, orderItem);
            total += orderItem.getPrice() * orderItem.getAmount();
        }
        Shop shop = ShopDao.getShopById(context, cart.getShop_id());
        String title = String.format("Bạn vừa đặt món thành công");
        String description = String.format("Bạn vừa đặt món từ cửa hàng %s với tổng giá trị của đơn là %s", shop.getName(), Support.toCurrency(total));
        Notification notification = new Notification(-1, cart.getUser_id(), title, description, new Date());
        NotificationDao.save(context, notification);
    }
}
