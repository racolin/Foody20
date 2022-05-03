package hcmute.spkt.group20.foody_20;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hcmute.spkt.group20.foody_20.model.Cart;
import hcmute.spkt.group20.foody_20.model.Comment;
import hcmute.spkt.group20.foody_20.model.Meal;
import hcmute.spkt.group20.foody_20.model.Notification;
import hcmute.spkt.group20.foody_20.model.Order;
import hcmute.spkt.group20.foody_20.model.Shop;
import hcmute.spkt.group20.foody_20.model.Slider;

public class Support {
    public static String toCurrency(int value) {
        String input = String.valueOf(value);
        StringBuilder builder = new StringBuilder();
        int len = input.length();
        for (int i = len; i > 0; i--) {
            builder.append(input.charAt(i));
            if ((len - i) % 3 == 0) {
                builder.append(",");
            }
        }
        return builder.append(input.charAt(0)).toString();
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
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_image));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_image));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_image));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_image));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_image));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_image));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_image));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_image));
        return meals;
    }

    public static List<Meal> createMeals1() {
        List<Meal> meals = new ArrayList<>();
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_image));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_image));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_image));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_image));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_image));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_image));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_image));
        return meals;
    }

    public static List<Meal> createMeals2() {
        List<Meal> meals = new ArrayList<>();
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_image));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_image));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_image));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_image));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_image));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_image));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_image));
        meals.add(new Meal("Canh cá Quỳnh Côi",
                "Món ăn gốc luôn ghi dấu bởi...", "2.3km", "Thành Mập 1", R.drawable.meal_image));
        return meals;
    }

    public static List<Cart> createCarts() {
        List<Cart> carts = new ArrayList<>();
        carts.add(new Cart("Canh cá Quỳnh Côi", "75.000đ", R.drawable.meal_image));
        carts.add(new Cart("Canh cá Quỳnh Côi", "75.000đ", R.drawable.meal_image));
        carts.add(new Cart("Canh cá Quỳnh Côi", "75.000đ", R.drawable.meal_image));
        carts.add(new Cart("Canh cá Quỳnh Côi", "75.000đ", R.drawable.meal_image));
        carts.add(new Cart("Canh cá Quỳnh Côi", "75.000đ", R.drawable.meal_image));
        carts.add(new Cart("Canh cá Quỳnh Côi", "75.000đ", R.drawable.meal_image));
        carts.add(new Cart("Canh cá Quỳnh Côi", "75.000đ", R.drawable.meal_image));
        carts.add(new Cart("Canh cá Quỳnh Côi", "75.000đ", R.drawable.meal_image));
        return carts;
    }

    public static List<Order> createAllOrders() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("#21", "Canh cá Quỳnh Côi", "11:41 10/04/2022", "11:41 10/04/2022",
                "Đang đợi", "", R.drawable.meal_image, "75.000đ", "1"));
        orders.add(new Order("#20", "Canh cá Quỳnh Côi", "11:41 10/04/2022", "11:41 10/04/2022",
                "Đang đợi", "", R.drawable.meal_image, "75.000đ", "1"));
        orders.add(new Order("#19", "Canh cá Quỳnh Côi", "11:41 10/04/2022", "11:41 10/04/2022",
                "Đang đợi", "", R.drawable.meal_image, "75.000đ", "1"));
        orders.add(new Order("#18", "Canh cá Quỳnh Côi", "11:41 10/04/2022", "11:41 10/04/2022",
                "Đang đợi", "", R.drawable.meal_image, "75.000đ", "1"));

        orders.add(new Order("#14", "Canh cá Quỳnh Côi", "11:41 10/04/2022", "11:41 10/04/2022",
                "Đang giao", "", R.drawable.meal_image, "75.000đ", "1"));
        orders.add(new Order("#13", "Canh cá Quỳnh Côi", "11:41 10/04/2022", "11:41 10/04/2022",
                "Đang giao", "", R.drawable.meal_image, "75.000đ", "1"));
        orders.add(new Order("#12", "Canh cá Quỳnh Côi", "11:41 10/04/2022", "11:41 10/04/2022",
                "Đang giao", "", R.drawable.meal_image, "75.000đ", "1"));

        orders.add(new Order("#7", "Canh cá Quỳnh Côi", "11:41 10/04/2022", "11:41 10/04/2022",
                "Đã giao", "", R.drawable.meal_image, "75.000đ", "1"));
        orders.add(new Order("#6", "Canh cá Quỳnh Côi", "11:41 10/04/2022", "11:41 10/04/2022",
                "Đã giao", "", R.drawable.meal_image, "75.000đ", "1"));
        orders.add(new Order("#5", "Canh cá Quỳnh Côi", "11:41 10/04/2022", "11:41 10/04/2022",
                "Đã giao", "", R.drawable.meal_image, "75.000đ", "1"));
        orders.add(new Order("#4", "Canh cá Quỳnh Côi", "11:41 10/04/2022", "11:41 10/04/2022",
                "Đã giao", "", R.drawable.meal_image, "75.000đ", "1"));

        orders.add(new Order("#29", "Canh cá Quỳnh Côi", "11:41 10/04/2022", "11:41 10/04/2022",
                "Bạn hủy", "Đặt nhầm", R.drawable.meal_image, "75.000đ", "1"));
        orders.add(new Order("#28", "Canh cá Quỳnh Côi", "11:41 10/04/2022", "11:41 10/04/2022",
                "Bạn hủy", "Đặt đặt món khác", R.drawable.meal_image, "75.000đ", "1"));

        orders.add(new Order("#37", "Canh cá Quỳnh Côi", "11:41 10/04/2022", "11:41 10/04/2022",
                "Shop hủy", "Hết nguyên liệu", R.drawable.meal_image, "75.000đ", "1"));

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
                R.drawable.shop_image));
        shops.add(new Shop("Thành Mập 1 ",
                "Quán cơm sáng trưa tối bình dân.",
                "Địa chỉ: Quận 9, TP. Hồ Chí Minh.", "2.3km",
                R.drawable.shop_image));
        shops.add(new Shop("Thành Mập 1 ",
                "Quán cơm sáng trưa tối bình dân.",
                "Địa chỉ: Quận 9, TP. Hồ Chí Minh.", "2.3km",
                R.drawable.shop_image));
        shops.add(new Shop("Thành Mập 1 ",
                "Quán cơm sáng trưa tối bình dân.",
                "Địa chỉ: Quận 9, TP. Hồ Chí Minh.", "2.3km",
                R.drawable.shop_image));
        shops.add(new Shop("Thành Mập 1 ",
                "Quán cơm sáng trưa tối bình dân.",
                "Địa chỉ: Quận 9, TP. Hồ Chí Minh.", "2.3km",
                R.drawable.shop_image));
        shops.add(new Shop("Thành Mập 1 ",
                "Quán cơm sáng trưa tối bình dân.",
                "Địa chỉ: Quận 9, TP. Hồ Chí Minh.", "2.3km",
                R.drawable.shop_image));
        return shops;
    }

    public static Shop getShop() {
        return new Shop("Thành Mập 1",
                "Quán cơm sáng trưa tối bình dân.",
                "Địa chỉ: Quận 9, TP. Hồ Chí Minh.", "2.3km",
                R.drawable.shop_image);
    }

    public static Shop getShopChain() {
        return new Shop("Thành Mập",
                "Quán cơm sáng trưa tối bình dân.",
                "Địa chỉ: Quận 9, TP. Hồ Chí Minh.", "2.3km",
                R.drawable.shop_image);
    }
}

