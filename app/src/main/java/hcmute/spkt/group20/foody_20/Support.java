package hcmute.spkt.group20.foody_20;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hcmute.spkt.group20.foody_20.model.Cart;
import hcmute.spkt.group20.foody_20.model.CartItem;
import hcmute.spkt.group20.foody_20.model.Comment;
import hcmute.spkt.group20.foody_20.model.Meal;
import hcmute.spkt.group20.foody_20.model.Notification;
import hcmute.spkt.group20.foody_20.model.Order;
import hcmute.spkt.group20.foody_20.model.OrderItem;
import hcmute.spkt.group20.foody_20.model.Shop;
import hcmute.spkt.group20.foody_20.model.Slider;

public class Support {
    public static boolean check(String type) {
        boolean result = false;
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            for (UserInfo info : user.getProviderData()) {
                result = result || info.getProviderId().equals(type);
            }
        }
        return result;
    }
    public static boolean checkGoogle() {
        return Support.check("google.com");
    }
    public static boolean checkFacebook() {
        return Support.check("facebook.com");
    }
    public static boolean checkPhone() {
        return Support.check("phone");
    }
    public static boolean checkLogin() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        return user == null ? false : user.getProviderData().size() > 1;
    }


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
        return builder.append(input.charAt(0)).reverse().toString();
    }
    public static String toDateString(Date date, String fm) {
        SimpleDateFormat format = new SimpleDateFormat(fm);
        return format.format(date);
    }

    public static List<Meal> createMeals() {
        List<Meal> meals = new ArrayList<>();
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_image));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_2));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_3));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_4));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_5));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_6));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_7));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_8));
        return meals;
    }

    public static List<Meal> createMeals1() {
        List<Meal> meals = new ArrayList<>();
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_image));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_6));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_7));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_5));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_10));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_9));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_3));
        return meals;
    }

    public static List<Meal> createMeals2() {
        List<Meal> meals = new ArrayList<>();
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_10));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_3));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_5));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_9));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_6));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_4));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_7));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_8));
        return meals;
    }

    public static List<Cart> createCarts() {
        List<Cart> carts = new ArrayList<>();
        carts.add(new Cart("Thành Mập 1", "2.3km", createCartItems()));
        carts.add(new Cart("Thành Mập 1", "2.3km", createCartItems()));
        carts.add(new Cart("Thành Mập 1", "2.3km", createCartItems()));
        carts.add(new Cart("Thành Mập 1", "2.3km", createCartItems()));
        carts.add(new Cart("Thành Mập 1", "2.3km", createCartItems()));
        return carts;
    }

    public static List<CartItem> createCartItems() {
        List<CartItem> items = new ArrayList<>();
        items.add(new CartItem("Canh cá Quỳnh Côi", 75000, 1, R.drawable.meal_image));
        items.add(new CartItem("Canh cá Quỳnh Côi", 150000, 2, R.drawable.meal_10));
        return items;
    }
    public static List<OrderItem> createOrderItems() {
        List<OrderItem> items = new ArrayList<>();
        items.add(new OrderItem(new Meal("Cơm Tấm Cây Khế 3 - Nguyễn Văn Khối",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_10), 2, 15000));
        items.add(new OrderItem(new Meal("Cơm Tấm Cây Khế 3 - Nguyễn Văn Khối",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_4), 2, 15000));
        return items;
    }

    public static List<Order> createAllOrders() {
        List<Order> orders = new ArrayList<>();

        orders.add(new Order("#21", "Thành Mập 1", "11:41 10/04/2022", "11:41 10/04/2022",
                "Đang đợi", "", R.drawable.shop_7, createOrderItems()));
        orders.add(new Order("#19", "Thành Mập 1", "11:41 10/04/2022", "11:41 10/04/2022",
                "Đang đợi", "", R.drawable.shop_6, createOrderItems()));
        orders.add(new Order("#18", "Thành Mập 1", "11:41 10/04/2022", "11:41 10/04/2022",
                "Đang đợi", "", R.drawable.shop_5, createOrderItems()));

        orders.add(new Order("#16", "Thành Mập 1", "11:41 10/04/2022", "11:41 10/04/2022",
                "Đang giao", "", R.drawable.shop_7, createOrderItems()));
        orders.add(new Order("#15", "Thành Mập 1", "11:41 10/04/2022", "11:41 10/04/2022",
                "Đang giao", "", R.drawable.shop_6, createOrderItems()));
        orders.add(new Order("#13", "Thành Mập 1", "11:41 10/04/2022", "11:41 10/04/2022",
                "Đang giao", "", R.drawable.shop_5, createOrderItems()));

        orders.add(new Order("#12", "Thành Mập 1", "11:41 10/04/2022", "11:41 10/04/2022",
                "Đã giao", "", R.drawable.shop_2, createOrderItems()));
        orders.add(new Order("#11", "Thành Mập 1", "11:41 10/04/2022", "11:41 10/04/2022",
                "Đã giao", "", R.drawable.shop_3, createOrderItems()));
        orders.add(new Order("#10", "Thành Mập 1", "11:41 10/04/2022", "11:41 10/04/2022",
                "Đã giao", "", R.drawable.shop_8, createOrderItems()));

        orders.add(new Order("#09", "Thành Mập 1", "11:41 10/04/2022", "11:41 10/04/2022",
                "Bạn hủy", "Đặt nhầm", R.drawable.meal_4, createOrderItems()));
        orders.add(new Order("#07", "Thành Mập 1", "11:41 10/04/2022", "11:41 10/04/2022",
                "Bạn hủy", "Đặt đặt món khác", R.drawable.meal_9, createOrderItems()));

        orders.add(new Order("#06", "Thành Mập 1", "11:41 10/04/2022", "11:41 10/04/2022",
                "Shop hủy", "Hết nguyên liệu", R.drawable.meal_10, createOrderItems()));

        return orders;
    }

    public static List<Notification> createNotifications() {
        List<Notification> notifications = new ArrayList<>();
        notifications.add(new Notification("Đơn hàng #21 của bạn đã hoàn tất",
                "Cửa hàng đã phê duyệt đơn hàng của bạn. Giá trị đơn " +
                        "hàng là 150.000đ. Thời gian nhận món: 11:41 10/04/2022.",
                "1 giờ trước"));
        notifications.add(new Notification("Mừng khai trường quán Thành Mập 1",
                "Mừng khai trương, Thành Mập 1 giảm giá 25% cho mọi món " +
                        "ăn trong cửa hàng. Nhanh tay đặt món nào!",
                "2 giờ trước"));
        notifications.add(new Notification("Đơn hàng #20 của bạn đã bị hủy",
                "Đơn hàng của bạn bị hủy vì: Món ăn đã hết" +
                        "Quán Thành Mập 1 chân thành cảm ơn!",
                "12 giờ trước"));
        notifications.add(new Notification("Bạn được Foody tặng mã code giảm giá",
                "Cảm ơn bạn đã tin dùng và sử dụng ứng dụng của chúng tôi trong thời gian qua.",
                "13 giờ trước"));
        notifications.add(new Notification("Đơn hàng #19 của bạn đã hoàn tất",
                "Cửa hàng đã phê duyệt đơn hàng của bạn. Giá trị đơn " +
                        "hàng là 150.000đ. Thời gian nhận món: 11:41 10/04/2022.",
                "15 giờ trước"));
        notifications.add(new Notification("Đơn hàng #18 của bạn đã hoàn tất",
                "Cửa hàng đã phê duyệt đơn hàng của bạn. Giá trị đơn " +
                        "hàng là 150.000đ. Thời gian nhận món: 11:41 10/04/2022.",
                "19 giờ trước"));
        notifications.add(new Notification("Đơn hàng #17 của bạn đã hoàn tất",
                "Cửa hàng đã phê duyệt đơn hàng của bạn. Giá trị đơn " +
                        "hàng là 150.000đ. Thời gian nhận món: 11:41 10/04/2022.",
                "1 ngày trước"));
        notifications.add(new Notification("Đơn hàng #16 của bạn đã hoàn tất",
                "Cửa hàng đã phê duyệt đơn hàng của bạn. Giá trị đơn " +
                        "hàng là 150.000đ. Thời gian nhận món: 11:41 10/04/2022.",
                "2 ngày trước"));
        return notifications;
    }

    public static List<String> createProvince() {
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

    public static List<Slider> createSliders() {
        List<Slider> sliders = new ArrayList<>();
        sliders.add(new Slider(R.drawable.slider1));
        sliders.add(new Slider(R.drawable.slider2));
        sliders.add(new Slider(R.drawable.slider3));
        return sliders;
    }

    public static List<Comment> createComments() {
        List<Comment> comments = new ArrayList<>();
        comments.add(new Comment("Phan Trung Tín",
                "11:43 10/04/2020", "Món ăn quá tuyện vời",
                4F, R.drawable.user_avatar));
        comments.add(new Comment("Phan Trung Tín",
                "11:43 10/04/2020", "Món ăn quá tuyện vời",
                4.5F, R.drawable.user_avatar));
        comments.add(new Comment("Phan Trung Tín",
                "11:43 10/04/2020", "Món ăn quá tuyện vời",
                3.5F, R.drawable.user_avatar));
        comments.add(new Comment("Phan Trung Tín",
                "11:43 10/04/2020", "Món ăn quá tuyện vời",
                5F, R.drawable.user_avatar));
        comments.add(new Comment("Phan Trung Tín",
                "11:43 10/04/2020", "Món ăn quá tuyện vời",
                5F, R.drawable.user_avatar));
        return comments;
    }

    public static List<Shop> createShops() {
        List<Shop> shops = new ArrayList<>();
        shops.add(new Shop("Thành Mập 1 ",
                "Quán cơm sáng trưa tối bình dân.",
                "Địa chỉ: Quận 9, TP. Hồ Chí Minh.", "2.3km",
                R.drawable.shop_image));
        shops.add(new Shop("Thành Mập 1 ",
                "Quán cơm sáng trưa tối bình dân.",
                "Địa chỉ: Quận 9, TP. Hồ Chí Minh.", "2.3km",
                R.drawable.shop_2));
        shops.add(new Shop("Thành Mập 1 ",
                "Quán cơm sáng trưa tối bình dân.",
                "Địa chỉ: Quận 9, TP. Hồ Chí Minh.", "2.3km",
                R.drawable.shop_2));
        shops.add(new Shop("Thành Mập 1 ",
                "Quán cơm sáng trưa tối bình dân.",
                "Địa chỉ: Quận 9, TP. Hồ Chí Minh.", "2.3km",
                R.drawable.shop_7));
        shops.add(new Shop("Thành Mập 1 ",
                "Quán cơm sáng trưa tối bình dân.",
                "Địa chỉ: Quận 9, TP. Hồ Chí Minh.", "2.3km",
                R.drawable.shop_8));
        shops.add(new Shop("Thành Mập 1 ",
                "Quán cơm sáng trưa tối bình dân.",
                "Địa chỉ: Quận 9, TP. Hồ Chí Minh.", "2.3km",
                R.drawable.shop_6));
        shops.add(new Shop("Thành Mập 1 ",
                "Quán cơm sáng trưa tối bình dân.",
                "Địa chỉ: Quận 9, TP. Hồ Chí Minh.", "2.3km",
                R.drawable.shop_4));
        return shops;
    }

    public static Shop getShop() {
        return new Shop("Thành Mập 1",
                "Quán cơm sáng trưa tối bình dân.",
                "Địa chỉ: Quận 9, TP. Hồ Chí Minh.", "2.3km",
                R.drawable.shop_5);
    }

    public static Shop getShopChain() {
        return new Shop("Thành Mập",
                "Quán cơm sáng trưa tối bình dân.",
                "Địa chỉ: Quận 9, TP. Hồ Chí Minh.", "2.3km",
                R.drawable.shop_7);
    }
}

