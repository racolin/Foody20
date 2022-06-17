package hcmute.spkt.group20.foody_20.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import hcmute.spkt.group20.foody_20.DatabaseHelper;
import hcmute.spkt.group20.foody_20.model.ShopChain;

public class ShopChainDao {
    public static final int ID = 0;
    public static final int NAME = 1;
    public static final int DESCRIPTION = 2;
    public static final int IMAGE = 3;

    public static ArrayList<ShopChain> get(Context context, String condition){
        ArrayList<ShopChain> list = new ArrayList<>();

        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "SELECT * FROM shop_chain";
        if (condition != null) {
            sql += " " + condition;
        }

        Cursor cs = db.rawQuery(sql, null);
        cs.moveToFirst();
        while (!cs.isAfterLast())
        {
            int id = cs.getInt(ID);
            String name = cs.getString(NAME);
            String description = cs.getString(DESCRIPTION);
            int image = cs.getInt(IMAGE);

            ShopChain shop_chain = new ShopChain(id, name, description, image);
            list.add(shop_chain);
            cs.moveToNext();
        }
        cs.close();
        db.close();
        return list;
    }

    public static ShopChain getShopChainById(Context context, int id)
    {
        List<ShopChain> shopChains =  get(context, "WHERE id=" + id);
        ShopChain shopChain = null;
        if (shopChains != null) {
            shopChain = shopChains.get(0);
        }
        return shopChain;
    }
}
