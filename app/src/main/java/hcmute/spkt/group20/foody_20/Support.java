package hcmute.spkt.group20.foody_20;

import android.content.Context;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import hcmute.spkt.group20.foody_20.dao.CartDao;
import hcmute.spkt.group20.foody_20.dao.CommentDao;
import hcmute.spkt.group20.foody_20.dao.MealDao;
import hcmute.spkt.group20.foody_20.dao.ShopDao;
import hcmute.spkt.group20.foody_20.model.Cart;
import hcmute.spkt.group20.foody_20.model.CartItem;
import hcmute.spkt.group20.foody_20.model.Comment;
import hcmute.spkt.group20.foody_20.model.Meal;
import hcmute.spkt.group20.foody_20.model.Notification;
import hcmute.spkt.group20.foody_20.model.Order;
import hcmute.spkt.group20.foody_20.model.OrderItem;
import hcmute.spkt.group20.foody_20.model.RatingClass;
import hcmute.spkt.group20.foody_20.model.Shop;
import hcmute.spkt.group20.foody_20.model.Slider;
import hcmute.spkt.group20.foody_20.state_fragment.HomeStateFragment;

public class Support{

    public static String toCurrency(int value) {
        String input = String.valueOf(value);
        StringBuilder builder = new StringBuilder();
        int len = input.length();
        for (int i = len - 1; i > 0; i--) {
            builder.append(input.charAt(i));
            if ((len - i) % 3 == 0) {
                builder.append(",");
                builder.toString();
            }
        }
        return builder.append(input.charAt(0)).reverse().toString() + "đ";
    }

    public static String toDateString(Date date, String fm) {
        SimpleDateFormat format = new SimpleDateFormat(fm);
        return format.format(date);
    }

    public static Date toDate(String date, String fm) {
        SimpleDateFormat format = new SimpleDateFormat(fm);
        Date d = new Date();
        try {
            d = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;
    }

    public static String toDateString(Calendar calendar, String fm) {
        SimpleDateFormat format = new SimpleDateFormat(fm);
        return format.format(calendar.getTime());
    }

    public static List<String> getProvinces() {
        List<String> provinces = new ArrayList<>();
        provinces.add("Bắc Kạn");
        provinces.add("Bắc Ninh");
        provinces.add("Hà Nam");
        provinces.add("Hải Dương");
        provinces.add("Hải Phòng");
        provinces.add("Hưng Yên");
        provinces.add("Nam Định");
        provinces.add("Ninh Bình");
        provinces.add("Thái Bình");
        provinces.add("An Giang");
        provinces.add("Vũng Tàu");
        provinces.add("Bắc Giang");
        provinces.add("Bạc Liêu");
        provinces.add("Bến Tre");
        provinces.add("Bình Định");
        provinces.add("Bình Dương");
        provinces.add("Bình Phước");
        provinces.add("Bình Thuận");
        provinces.add("Cà Mau");
        provinces.add("Cần Thơ");
        provinces.add("Cao Bằng");
        provinces.add("Đà Nẵng");
        provinces.add("Đắk Lắk");
        provinces.add("Đăk Nông");
        provinces.add("Điện Biên");
        provinces.add("Đồng Nai");
        provinces.add("Đồng tháp");
        provinces.add("Gia Lai");
        provinces.add("Hà Giang");
        provinces.add("Hà Nội");
        provinces.add("Hà Tĩnh");
        provinces.add("Hòa Bình");
        provinces.add("Khánh Hòa");
        provinces.add("Kiên Giang");
        provinces.add("Kon Tum");
        provinces.add("Lai Châu");
        provinces.add("Lâm Đồng");
        provinces.add("Lạng Sơn");
        provinces.add("Lào Cai");
        provinces.add("Long an");
        provinces.add("Nghệ An");
        provinces.add("Ninh Thuận");
        provinces.add("Phú Thọ");
        provinces.add("Phú Yên");
        provinces.add("Quảng Bình");
        provinces.add("Quảng Nam");
        provinces.add("Quảng Ngãi");
        provinces.add("Quảng Ninh");
        provinces.add("Quảng Trị");
        provinces.add("Sóc Trăng");
        provinces.add("Sơn La");
        provinces.add("Tây Ninh");
        provinces.add("Thái Nguyên");
        provinces.add("Thanh Hóa");
        provinces.add("TT. Huế");
        provinces.add("Tiền Giang");
        provinces.add("TP. HCM");
        provinces.add("Trà Vinh");
        provinces.add("Tuyên Quang");
        provinces.add("Vĩnh Long");
        provinces.add("Vĩnh Phúc");
        provinces.add("Yên Bái");
        return provinces;
    }

    public static void getOutstandingMeals(HomeStateFragment adapter) {
        List<Meal> meals = new ArrayList<>();
        adapter.setOutstanding(meals);

    }

    public static void getNearMeals(HomeStateFragment adapter) {
        List<Meal> meals = new ArrayList<>();

        adapter.setNear(meals);
    }

    public static List<Slider> createSliders() {
        List<Slider> sliders = new ArrayList<>();
        sliders.add(new Slider(R.drawable.slider1));
        sliders.add(new Slider(R.drawable.slider2));
        sliders.add(new Slider(R.drawable.slider3));
        return sliders;
    }

    public static float getRating(List<Comment> comments) {
        if (comments != null && comments.size() != 0) {
            float rate = 0;
            for (Comment comment : comments) {
                rate += comment.getRate();
            }
            return rate / comments.size();
        }
        return 5;
    }

    static List<RatingClass> rc = new ArrayList<>(Arrays.asList(new RatingClass[]{
            new RatingClass("Ngon tuyệt!", 5, 4),
            new RatingClass("Khá ngon!", 4, 3),
            new RatingClass("Tạm được!", 3, 2),
            new RatingClass("Quá dở!", 2, 1),
            new RatingClass("Kinh khủng!", 1, 0)})
    );

    public static String getTypeRate(float rate) {
        String type = "";
        for (RatingClass r : rc) {
            if (r.isThisType(rate)) {
                type = r.getType();
            }
        }
        return type;
    }
}

