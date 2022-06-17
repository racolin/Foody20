package hcmute.spkt.group20.foody_20;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "foody_20.db";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public void QueryData(String sql)
    {
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public Cursor GetData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql;
        //Create cart
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS cart(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "user_id INTEGER NOT NULL, " +
                "shop_id INTEGER NOT NULL)");

        //Create saved_meal
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS saved_meal(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "user_id INTEGER NOT NULL, " +
                "meal_id INTEGER NOT NULL)");

        //Create saved_shop
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS saved_shop(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "user_id INTEGER NOT NULL, " +
                "shop_id INTEGER NOT NULL)");

        //Create cart item
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS cart_item(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "cart_id INTEGER NOT NULL, " +
                "meal_id INTEGER NOT NULL, " +
                "amount INTEGER)");

        //Create comment
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS comment(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "user_id INTEGER NOT NULL, " +
                "meal_id INTEGER NOT NULL, " +
                "time_created DATETIME, " +
                "rate FLOAT, " +
                "content TEXT)");


        //Create meal
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS meal(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "name TEXT, " +
                "shop_id INTEGER NOT NULL, " +
                "description TEXT, " +
                "price INTEGER, " +
                "saved_count INTEGER, " +
                "shared_count INTEGER, " +
                "image INTEGER)");

        //Create user
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS user(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "full_name TEXT, " +
                "gender INTEGER, " +
                "dob TEXT, " +
                "phone TEXT, " +
                "gmail TEXT," +
                "facebook TEXT, " +
                "address TEXT, " +
                "username TEXT, " +
                "password TEXT, " +
                "image INTEGER)");

        //Create notification
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS notification(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "user_id INTEGER NOT NULL, " +
                "title TEXT, " +
                "description TEXT, " +
                "time DATETIME)");

        //Tạo bảng order
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `order`(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "user_id INTEGER NOT NULL, " +
                "shop_id INTEGER NOT NULL, " +
                "time_end DATETIME, " +
                "time_start DATETIME, " +
                "status TEXT, " +
                "cause TEXT)");

        //Tạo bảng order item
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS order_item(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "order_id INTEGER NOT NULL, " +
                "meal_id INTEGER NOT NULL, " +
                "amount INTEGER," +
                "price INTEGER)");

        //Create Shop
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS shop(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "name TEXT, " +
                "shop_chain_id INTEGER NOT NULL, " +
                "time_open TEXT, " +
                "description TEXT, " +
                "phone_number TEXT, " +
                "address TEXT," +
                "distance TEXT, " +
                "image INTEGER )");

        //Create shop_chain
        sqLiteDatabase.execSQL("CREATE TABLE if not EXISTS shop_chain(" +
                "id integer PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "name TEXT, " +
                "description TEXT, " +
                "image INTEGER)");
    }

    public void createData() {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        sqLiteDatabase.execSQL("INSERT INTO saved_shop VALUES(null, 1, 1), (null, 1, 3), (null, 1, 5)");
        sqLiteDatabase.execSQL("INSERT INTO saved_meal VALUES(null, 1, 1), (null, 1, 3), (null, 1, 5)" +
                ", (null, 1, 6), (null, 1, 9), (null, 1, 14), (null, 1, 19), (null, 1, 16), (null, 1, 17), (null, 1, 18), (null, 1, 20)");


        sqLiteDatabase.execSQL("INSERT INTO user VALUES(null, 'Phan Trung Tín', 1, '2001-05-11 14:40:00', " +
                "'0868754872', 'phantrungtin@gmail.com', 'facebook.com/phantrungtinh', 'Ho Chi Minh', 'tinphan', '11052001',"
                + R.drawable.avatar_user_default +")");
        sqLiteDatabase.execSQL("INSERT INTO user VALUES(null, 'Võ Minh Trí', 1, '2001-01-01 14:40:00'," +
                "'0882669175', 'tri@gmail.com', 'facebook.com/tri', 'Ho Chi Minh', 'trivo', '123',"+R.drawable.avatar_user_default+")");
//        "tsukOHhB81xB4S6dQSoa" 1
        sqLiteDatabase.execSQL("INSERT INTO shop_chain VALUES(null, 'Hệ thống cửa hàng Vựa Hải Sản Xanh', 'Vựa Hải Sản Xanh chuyên cung cấp sỉ và lẻ các loại hải sản tươi sống giá rẻ, nguồn hàng tận gốc không qua trung gian, giao hàng tận nơi, bao ăn bao chất.'," + R.drawable.sc1+")");

//        "pfHkwJrX52MuvN3Btdc3" 2
        sqLiteDatabase.execSQL("INSERT INTO shop_chain VALUES(null, 'Lotteria', 'Lotteria là một chuỗi cửa hàng thức ăn nhanh với cửa hàng đầu tiên ở Tokyo, Nhật Bản vào tháng 9 năm 1972.'," + R.drawable.sc2+")");

//        Xujtvzqr5z9YUAEQKHlw 3
        sqLiteDatabase.execSQL("INSERT INTO shop_chain VALUES(null, 'KFC - Kentucky Fried Chicken', 'KFC là cụm từ viết tắt của Kentucky Fried Chicken - Gà Rán Kentucky, một trong các thương hiệu thuộc Tập đoàn Yum Brands Inc (Hoa Kỳ). KFC chuyên về các sản phẩm gà rán và nướng, với các món ăn kèm theo và các loại sandwiches chế biến từ thịt gà tươi.'," + R.drawable.sc3+")");

//        0WJRCEUGfBCF01Iylhou 4
        sqLiteDatabase.execSQL("INSERT INTO shop_chain VALUES(null, 'Phở ông Hùng', 'Phở món ăn quốc hồn được nhiều du khách tìm kiếm mỗi khi đặt chân đến Việt Nam. Phở ông Hùng là thương hiệu làm rung động lòng người.'," + R.drawable.sc4+")");

//        0F9hLKTCjPUQAOrmadPI 5
        sqLiteDatabase.execSQL("INSERT INTO shop_chain VALUES(null, 'Cơm tấm Sài Gòn Nam Phương', 'Cơm Tấm Nam Phương là cái tên không còn xa lạ với người dân. Quán được lên khá nhiều các mặt báo và các trang ẩm thực và Nhận được rất nhiều phản hồi tốt.'," + R.drawable.sc5 + ")");


//        1
//        "tsukOHhB81xB4S6dQSoa"
//        "41VQ0VcdHAQip8fxR207" 1
        sqLiteDatabase.execSQL("INSERT INTO shop VALUES(null, 'Vựa Hải Sản Xanh - 57 Đường Cây Keo', 1, 'Cả ngày', " +
                "'Địa chỉ văn phòng công ty Vựa Hải Sản Xanh, văn phòng đẹp, có chỗ gửi xe cho nhân viên và khách hàng. Chú bảo vệ dễ thương, nhệt tình dẫn xe cho mình. Mọi người có thể đi từ Tô ngọc vân rẽ vào hoặc đi từ đường Hiệp bình.', " +
                "'0707 888 885', '57 Đường Cây Keo, Tam Phú, Thủ Đức, TP. HCM', '5km',"+ R.drawable.s1+")");
//        2
//        "pfHkwJrX52MuvN3Btdc3"
//        "H841U5q3hH3ICnYipzl8"
        sqLiteDatabase.execSQL("INSERT INTO shop VALUES(null, 'Lotteria Đỗ Xuân Hợp', 2, '8:00 - 20:30', " +
                "'Xem menu & đặt món trực tuyến từ Lotteria Đỗ Xuân Hợp rất dễ dàng. Giao hàng tận nơi trong vòng ít phút.', " +
                "'028 6282 5859', '286 Đỗ Xuân Hợp, P. Phước Long A, Quận 9, TP. HCM.', '8km',"+ R.drawable.s2+")");
//        3
        /*
        shop_chain_id
        "Xujtvzqr5z9YUAEQKHlw"
        shop_id
        "LPP7Dp0j3cZNA0p3c8Qd" 2
        */
        sqLiteDatabase.execSQL("INSERT INTO shop VALUES(null, 'KFC Big C Dĩ An', 3, '10:00 - 21:30', " +
                "'Chuỗi nhà hàng nổi tiếng với những phần gà rán, cánh gà và món ăn kèm. Các tùy chọn dịch vụ: Ăn tại chỗ · Đồ ăn mang đi · Giao hàng gián tiếp', " +
                "'1800 6088', 'VQQG+M8X, Quốc lộ 1K, Đông Hoà, Dĩ An, Bình Dương','3km',"+ R.drawable.s3+")");
//        4
        /*
shop_chain_id
"pfHkwJrX52MuvN3Btdc3"
shop_id
"T4LrZUriZv4xJoUA0fi1" 3
         */
        sqLiteDatabase.execSQL("INSERT INTO shop VALUES(null, 'Lotteria BA THANG HAI', 2, '7:30 - 20:30', " +
                "'Xem menu & đặt món trực tuyến từ Lotteria BA THANG HAI rất dễ dàng. Giao hàng tận nơi trong vòng ít phút.', " +
                "'028 6282 5859', '572A Đường 3 Tháng 2, P. 14, Quận 10, TP. HCM.','3km',"+ R.drawable.s4+")");
//        5
        /*
sqLiteDatabase.execSQL("INSERT INTO shop VALUES(null, '$3', 2, '$5', '$2', " +
                "'$4', '$1','3km',"+ R.drawable.s5+")");

shop_chain_id
"0F9hLKTCjPUQAOrmadPI"
shop_id
"Xd2NSz7SL1nd9XpSRv6E" 4
         */
        sqLiteDatabase.execSQL("INSERT INTO shop VALUES(null, 'Cơm Tấm Ngô Quyền - Đường Số 36', 5, '6:00 - 23:00', 'Bạn tìm thực đơn giao hàng tận nơi của Cơm Tấm Ngô Quyền - Thủ Đức? Đặt ngay trên GrabFood và nhận món ăn giao đến tận nhà.', " +
                "'0961.49.5679', 'Đường Vào Đại Học Quốc Gia, Tp. Thủ Đức, TP. HCM.','3km',"+ R.drawable.s5+")");
//        6
        /*

shop_chain_id
"Xujtvzqr5z9YUAEQKHlw"
shop_id
"bhZGkPVP5WHM7MaHndPL" 5
         */
        sqLiteDatabase.execSQL("INSERT INTO shop VALUES(null, 'Gà Rán KFC - Lotte Mart Bình Dương', 3, '9:00 - 20:30', 'Xem menu & đặt món trực tuyến từ Gà Rán KFC - Lotte Mart Bình Dương rất dễ dàng. Giao hàng tận nơi trong vòng ít phút.', " +
                "'096 790 98 22', 'WP46+2MP, Lái Thiêu, Thuận An, Bình Dương','3km',"+ R.drawable.s6+")");
//        7
        /*

shop_chain_id
"pfHkwJrX52MuvN3Btdc3"
shop_id
"eeKbEXAIL5PoOgS9g441" 6
         */

        sqLiteDatabase.execSQL("INSERT INTO shop VALUES(null, 'Lotteria XO VIET NGHE TINH', 2, '8:30 - 21:30', 'Xem menu & đặt món trực tuyến từ Lotteria - Xô Viết Nghệ Tĩnh rất dễ dàng. Giao hàng tận nơi trong vòng ít phút.', " +
                "'1800 8099', '222A Xô Viết Nghệ Tĩnh, P. 21, Quận Bình Thạnh, TP. HCM.','3km',"+ R.drawable.s7+")");
//        8
        /*

shop_chain_id
"0F9hLKTCjPUQAOrmadPI"
shop_id
"jj3o6yilYLc2pTEkGmQL" 7
         */
        sqLiteDatabase.execSQL("INSERT INTO shop VALUES(null, 'Cơm Tấm SuSu - Sườn Bì Chả - 535/54 Thống Nhất', 5, '10:00 - 14:00', 'Xem menu & đặt món trực tuyến từ Cơm Tấm SuSu - Sườn Bì Chả - 535/54 Thống Nhất rất dễ dàng. Giao hàng tận nơi trong vòng ít phút.', " +
                "'031 697 5154', '535/54 Thống Nhất, P. 16, Quận Gò Vấp, TP. HCM.','3km',"+ R.drawable.s8+")");
//        9
        /*

shop_chain_id
"0WJRCEUGfBCF01Iylhou"
shop_id
"pk4JwdFsngsIPMklysef" 8
         */
        sqLiteDatabase.execSQL("INSERT INTO shop VALUES(null, 'Phở Hùng - Nguyễn Trãi', 4, '7:00 - 18:30', 'Những bát phở vẫn là hương vị món ăn mà không người sành ăn nào không nếm thử một lần. Phở Ông Hùng sẽ là nơi bạn phải ghé đến để thực sự thưởng thức một bát phở ngon đúng điệu.', " +
                "'084 725 1582', '243 Nguyễn Trãi, P. Nguyễn Cư Trinh, Quận 1, TP. HCM.','3km',"+ R.drawable.s9+")");



        //        jj3o6yilYLc2pTEkGmQL 1
        sqLiteDatabase.execSQL("INSERT INTO meal VALUES(null, 'Cơm cuộn rong biển - Sushi', 8, 'Cơm cuộn rong biển là một món ăn tiêu biểu của ẩm thực Hàn Quốc.'," +
                " 50000, 0, 0, " + R.drawable.m1 + ")");

        //        41VQ0VcdHAQip8fxR207 2
        sqLiteDatabase.execSQL("INSERT INTO meal VALUES(null, 'Sò điệp nướng mỡ hành béo bỡ', 1, 'Trong các món ốc, ếch thì sò điệp nướng mỡ hành là món nhậu dễ làm và thơm ngon, dễ ăn và đưa cay khá chuẩn. Món này Nam Nhi có thể tự mần, tự măn, tự rót, tự zô cùng các chiến hữu.'," +
                " 100000, 0, 0, " + R.drawable.m2 + ")");

        //        Xd2NSz7SL1nd9XpSRv6E 3
        sqLiteDatabase.execSQL("INSERT INTO meal VALUES(null, 'Cơm tấm Sài Gòn Nam Phương', 5, 'Cơm tấm là món ăn đặc sản của người dân miền Nam. Nó được ưa chuộng tại rất nhiều vùng miền, đặc biệt là Sài Gòn.'," +
                " 35000, 0, 0, " + R.drawable.m3 + ")");

        //        jj3o6yilYLc2pTEkGmQL 4
        sqLiteDatabase.execSQL("INSERT INTO meal VALUES(null, 'Cơm chiên Dương Châu', 8, 'Cách làm cơm chiên Dương Châu với hạt cơm rất giòn, thơm ngon vừa nhiều màu sắc bắt mắt, đậm đà và giàu chất dinh dưỡng, hạt cơm tơi đều.'," +
                " 30000, 0, 0, " + R.drawable.m4 + ")");

        //        pk4JwdFsngsIPMklysef 5
        sqLiteDatabase.execSQL("INSERT INTO meal VALUES(null, 'Phở đặc biệt - Phở ông Hùng', 9, 'Đến với Phở Ông Hùng, thực khách có thể thưởng thức nhiều vị phở khác nhau như phở gà, phở bò và đặc biệt mình khuyên các bạn nên ăn thử món phở thập cẩm.'," +
                " 75000, 0, 0, " + R.drawable.m5 + ")");

        //        41VQ0VcdHAQip8fxR207 6
        sqLiteDatabase.execSQL("INSERT INTO meal VALUES(null, 'Cá chẽm chiên giòn chấm sốt chua ngọt.', 1, 'Món chiên từ cá chẽm với da cá vàng giòn và nước sốt chua ngọt hao cơm. ... trắng và một chén nước chấm tỏi ớt chua cay thì rất tuyệt vời.'," +
                " 60000, 0, 0, " + R.drawable.m6 + ")");

        //        41VQ0VcdHAQip8fxR207 7
        sqLiteDatabase.execSQL("INSERT INTO meal VALUES(null, 'Cua Cà Mau rang me', 1, 'Cua rang me là món ăn hấp dẫn nhiều người thưởng thức bởi vị tươi ngon của cua quyện lẫn vị chua chua ngọt ngọt, đậm đà của sốt me.'," +
                " 200000, 0, 0, " + R.drawable.m7 + ")");

        //        T4LrZUriZv4xJoUA0fi1 8
        sqLiteDatabase.execSQL("INSERT INTO meal VALUES(null, 'Hamburger Gà - Lotteria', 4, 'Hamburger Gà – Nếu như bạn đang băn khoăn và thắc mắc rằng mình nên chọn ăn bánh hamburger bò hay hamburger trứng thì tại sao bạn không thử món mới này nhỉ?'," +
                " 30000, 0, 0, " + R.drawable.m8 + ")");

        //        eeKbEXAIL5PoOgS9g441 9
        sqLiteDatabase.execSQL("INSERT INTO meal VALUES(null, 'Combo 3 món với giá cực kỳ rẻ!', 7, 'Combo Hamburger khoai tây chiên và coca'," +
                " 50000, 0, 0, " + R.drawable.m9 + ")");

        //        eeKbEXAIL5PoOgS9g441 10
        sqLiteDatabase.execSQL("INSERT INTO meal VALUES(null, 'Hamburger Gà - Lotteria', 7, 'Hamburger Gà – Nếu như bạn đang băn khoăn và thắc mắc rằng mình nên chọn ăn bánh hamburger bò hay hamburger trứng thì tại sao bạn không thử món mới này nhỉ?'," +
                " 30000, 0, 0, " + R.drawable.m10 + ")");

        //        41VQ0VcdHAQip8fxR207 11
        sqLiteDatabase.execSQL("INSERT INTO meal VALUES(null, 'Sò huyết hấp sả ớt', 1, 'Sò huyết là một loại hải sản có vị ngọt, mặn, tính ấm, có tác dụng chính là bổ huyết, kiện vị, ôn trung, hỗ trợ chữa chứng huyết hư, thiếu máu, kiết lỵ ra máu, tiêu hóa kém, viêmloét dạ dày tá tràng.'," +
                " 125000, 0, 0, " + R.drawable.m11 + ")");

        //        LPP7Dp0j3cZNA0p3c8Qd 12
        sqLiteDatabase.execSQL("INSERT INTO meal VALUES(null, 'Combo Hamburger khoai tây chiên và coca nhiều người', 3, 'Combo 3 món cho 2 đến 3 người với giá cực kỳ rẻ!'," +
                " 125000, 0, 0, " + R.drawable.m12 + ")");

        //        41VQ0VcdHAQip8fxR207 13
        sqLiteDatabase.execSQL("INSERT INTO meal VALUES(null, 'Ếch sào xả ớt', 1, 'Ếch Xào Sả Ớt là món ngon gia đình đậm đà, hương vị thì ngon không cưỡng nổi.'," +
                " 90000, 0, 0, " + R.drawable.m13 + ")");

        //        pk4JwdFsngsIPMklysef 14
        sqLiteDatabase.execSQL("INSERT INTO meal VALUES(null, 'Nui xào bò bằm cà chua ', 9, 'Nui xào bò bằm cà chua và nui xào bò sốt bò kho thơm ngon lạ miệng cho cả gia đình bữa sáng đầy dinh dưỡng.'," +
                " 35000, 0, 0, " + R.drawable.m14 + ")");

        //        41VQ0VcdHAQip8fxR207 15
        sqLiteDatabase.execSQL("INSERT INTO meal VALUES(null, 'Cá chim biển hấp sì dầu thơm lừng', 1, 'Cá chim hấp xì dầu thơm lừng hấp dẫn quả là một ý tưởng cho bữa cơm nhà thêm ngon miệng phải không nào.'," +
                " 70000, 0, 0, " + R.drawable.m15 + ")");

        //        LPP7Dp0j3cZNA0p3c8Qd 16
        sqLiteDatabase.execSQL("INSERT INTO meal VALUES(null, 'Combo Hamburger khoai tây chiên và coca', 3, 'Combo 3 món với giá cực kỳ rẻ!'," +
                " 55000, 0, 0, " + R.drawable.m16 + ")");

        //        H841U5q3hH3ICnYipzl8 17
        sqLiteDatabase.execSQL("INSERT INTO meal VALUES(null, 'Hamburger Gà - Lotteria', 2, 'Hamburger Gà – Nếu như bạn đang băn khoăn và thắc mắc rằng mình nên chọn ăn bánh hamburger bò hay hamburger trứng thì tại sao bạn không thử món mới này nhỉ?'," +
                " 30000, 0, 0, " + R.drawable.m17 + ")");

        //        Xd2NSz7SL1nd9XpSRv6E 18
        sqLiteDatabase.execSQL("INSERT INTO meal VALUES(null, 'Cơm chiên Dương Châu', 5, 'Cách làm cơm chiên Dương Châu với hạt cơm rất giòn, thơm ngon vừa nhiều màu sắc bắt mắt, đậm đà và giàu chất dinh dưỡng, hạt cơm tơi đều.'," +
                " 30000, 0, 0, " + R.drawable.m18 + ")");

        //        T4LrZUriZv4xJoUA0fi1 19
        sqLiteDatabase.execSQL("INSERT INTO meal VALUES(null, 'Combo 3 món với giá cực kỳ rẻ!', 4, 'Combo Hamburger khoai tây chiên và coca'," +
                " 50000, 0, 0, " + R.drawable.m19 + ")");

        //        jj3o6yilYLc2pTEkGmQL 20
        sqLiteDatabase.execSQL("INSERT INTO meal VALUES(null, 'Cơm tấm Sài Gòn Nam Phương', 8, 'Cơm tấm là món ăn đặc sản của người dân miền Nam. Nó được ưa chuộng tại rất nhiều vùng miền, đặc biệt là Sài Gòn.'," +
                " 35000, 0, 0, " + R.drawable.m20 + ")");

        //        H841U5q3hH3ICnYipzl8 21
        sqLiteDatabase.execSQL("INSERT INTO meal VALUES(null, 'Combo Hamburger khoai tây chiên và coca', 2, 'Combo 3 món với giá cực kỳ rẻ!'," +
                " 50000, 0, 0, " + R.drawable.m21 + ")");

        //        41VQ0VcdHAQip8fxR207 22
        sqLiteDatabase.execSQL("INSERT INTO meal VALUES(null, 'Ốc Hương sào bơ tỏi ngon bá cháy', 1, 'Ốc hương xào bơ tỏi béo ngậy với nguyên liệu ốc hương dai, mềm quyện cùng vị bơ tỏi cực hấp dẫn.'," +
                " 150000, 0, 0, " + R.drawable.m22 + ")");

        //        Xd2NSz7SL1nd9XpSRv6E 23
        sqLiteDatabase.execSQL("INSERT INTO meal VALUES(null, 'Cơm cuộn rong biển - Sushi', 5, 'Cơm cuộn rong biển là một món ăn tiêu biểu của ẩm thực Hàn Quốc.'," +
                " 50000, 0, 0, " + R.drawable.m23 + ")");

        //        bhZGkPVP5WHM7MaHndPL 24
        sqLiteDatabase.execSQL("INSERT INTO meal VALUES(null, 'Combo Hamburger khoai tây chiên và coca', 6, 'Combo 3 món với giá cực kỳ rẻ!'," +
                " 55000, 0, 0, " + R.drawable.m24 + ")");

        //        pk4JwdFsngsIPMklysef 25
        sqLiteDatabase.execSQL("INSERT INTO meal VALUES(null, 'Bún bò Huế - Ông Hùng', 9, 'Bún bò là một trong những đặc sản của xứ Huế, mặc dù món bún này phổ biến trên cả ba miền ở Việt Nam và cả người Việt tại hải ngoại.'," +
                " 75000, 0, 0, " + R.drawable.m25 + ")");
//        ----

        sqLiteDatabase.execSQL("INSERT INTO `order` VALUES(null, 1, 1, '2022-05-07 14:40:00', '2022-05-07 14:40:00', 'Đang giao', null)");
        sqLiteDatabase.execSQL("INSERT INTO `order` VALUES(null, 1, 3, '2022-05-07 14:40:00', '2022-05-07 14:40:00', 'Đã giao', null)");
        sqLiteDatabase.execSQL("INSERT INTO `order` VALUES(null, 1, 4, '2022-05-07 14:40:00', '2022-05-07 14:40:00', 'Đang đợi', null)");
        sqLiteDatabase.execSQL("INSERT INTO `order` VALUES(null, 1, 7, '2022-05-07 14:40:00', '2022-05-07 14:40:00', 'Bạn hủy', 'Đặt nhầm')");
        sqLiteDatabase.execSQL("INSERT INTO `order` VALUES(null, 1, 8, '2022-05-07 14:40:00', '2022-05-07 14:40:00', 'Shop hủy', 'Hết món')");

        sqLiteDatabase.execSQL("INSERT INTO order_item VALUES(null, 1, 2, 1, 100000)");
        sqLiteDatabase.execSQL("INSERT INTO order_item VALUES(null, 1, 7, 2, 200000)");
        sqLiteDatabase.execSQL("INSERT INTO order_item VALUES(null, 1, 15, 1, 70000)");
        sqLiteDatabase.execSQL("INSERT INTO order_item VALUES(null, 1, 13, 3, 90000)");
        sqLiteDatabase.execSQL("INSERT INTO order_item VALUES(null, 2, 12, 1, 125000)");
        sqLiteDatabase.execSQL("INSERT INTO order_item VALUES(null, 2, 16, 2, 55000)");
        sqLiteDatabase.execSQL("INSERT INTO order_item VALUES(null, 3, 8, 1, 30000)");
        sqLiteDatabase.execSQL("INSERT INTO order_item VALUES(null, 3, 19, 2, 50000)");
        sqLiteDatabase.execSQL("INSERT INTO order_item VALUES(null, 4, 9, 1, 50000)");
        sqLiteDatabase.execSQL("INSERT INTO order_item VALUES(null, 4, 10, 3, 30000)");
        sqLiteDatabase.execSQL("INSERT INTO order_item VALUES(null, 5, 1, 1, 50000)");
        sqLiteDatabase.execSQL("INSERT INTO order_item VALUES(null, 5, 4, 3, 30000)");
        sqLiteDatabase.execSQL("INSERT INTO order_item VALUES(null, 5, 20, 1, 35000)");
//
        sqLiteDatabase.execSQL("INSERT INTO cart VALUES(null, 1, 1)");
        sqLiteDatabase.execSQL("INSERT INTO cart VALUES(null, 1, 8)");

        sqLiteDatabase.execSQL("INSERT INTO cart_item VALUES(null, 1, 6, 1)");
        sqLiteDatabase.execSQL("INSERT INTO cart_item VALUES(null, 1, 22, 2)");
        sqLiteDatabase.execSQL("INSERT INTO cart_item VALUES(null, 1, 13, 3)");
        sqLiteDatabase.execSQL("INSERT INTO cart_item VALUES(null, 2, 4, 2)");
        sqLiteDatabase.execSQL("INSERT INTO cart_item VALUES(null, 2, 20, 2)");

        sqLiteDatabase.execSQL("INSERT INTO notification VALUES(null, 1, 'Chào mừng bạn đến với Foody'," +
                " 'Bạn mới đăng ký Foody hãy đặt món ngay nào!!!', '2022-05-07 14:40:00')");
        sqLiteDatabase.execSQL("INSERT INTO notification VALUES(null, 2, 'Chào mừng bạn đến với Foody'," +
                " 'Bạn mới đăng ký Foody hãy đặt món ngay nào!!!', '2022-05-07 14:40:00')");
        sqLiteDatabase.execSQL("INSERT INTO notification VALUES(null, 1, 'Mừng khai trương quán Thành Mập 1'," +
                " 'Quán Thành Mập mới khai trương ưu đãi lớn cho mọi khách hàng!', '2022-05-07 14:40:00')");
        sqLiteDatabase.execSQL("INSERT INTO notification VALUES(null, 2, 'Mừng khai trương quán Thành Mập 1'," +
                " 'Quán Thành Mập mới khai trương ưu đãi lớn cho mọi khách hàng!', '2022-05-07 14:40:00')");
        sqLiteDatabase.execSQL("INSERT INTO notification VALUES(null, 1, 'Mừng khai trương quán Thành Mập 2'," +
                " 'Quán Thành Mập 2 mới khai trương ưu đãi lớn cho mọi khách hàng!', '2022-05-07 14:40:00')");
        sqLiteDatabase.execSQL("INSERT INTO notification VALUES(null, 2, 'Mừng khai trương quán Thành Mập 2'," +
                " 'Quán Thành Mập 2 mới khai trương ưu đãi lớn cho mọi khách hàng!', '2022-05-07 14:40:00')");
        sqLiteDatabase.execSQL("INSERT INTO notification VALUES(null, 1, 'Mừng khai trương quán KFC 1'," +
                " 'Quán KFC 1 mới khai trương ưu đãi lớn cho mọi khách hàng!', '2022-05-07 14:40:00')");
        sqLiteDatabase.execSQL("INSERT INTO notification VALUES(null, 2, 'Mừng khai trương quán KFC 1'," +
                " 'Quán KFC 1 mới khai trương ưu đãi lớn cho mọi khách hàng!', '2022-05-07 14:40:00')");
        sqLiteDatabase.execSQL("INSERT INTO notification VALUES(null, 1, 'Mừng khai trương quán KFC 2'," +
                " 'Quán KFC 2 mới khai trương ưu đãi lớn cho mọi khách hàng!', '2022-05-07 14:40:00')");
        sqLiteDatabase.execSQL("INSERT INTO notification VALUES(null, 2, 'Mừng khai trương quán KFC 2'," +
                " 'Quán KFC 2 mới khai trương ưu đãi lớn cho mọi khách hàng!', '2022-05-07 14:40:00')");
        sqLiteDatabase.execSQL("INSERT INTO notification VALUES(null, 1, 'Mừng khai trương quán KFC 3'," +
                " 'Quán KFC 3 mới khai trương ưu đãi lớn cho mọi khách hàng!', '2022-05-07 14:40:00')");
        sqLiteDatabase.execSQL("INSERT INTO notification VALUES(null, 2, 'Mừng khai trương quán KFC 3'," +
                " 'Quán KFC 4 mới khai trương ưu đãi lớn cho mọi khách hàng!', '2022-05-07 14:40:00')");


        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS comment(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "user_id INTEGER NOT NULL, " +
                "meal_id INTEGER NOT NULL, " +
                "time_created DATETIME, " +
                "rate FLOAT, " +
                "content TEXT)");

        sqLiteDatabase.execSQL("INSERT INTO comment VALUES(null, 1, 1, '2022-05-07 14:40:00', 4, 'Món ăn tuyệt với')");
        sqLiteDatabase.execSQL("INSERT INTO comment VALUES(null, 2, 1, '2022-05-07 14:40:00', 5, 'Thật là ngon!')");

        sqLiteDatabase.execSQL("INSERT INTO comment VALUES(null, 1, 2, '2022-05-07 14:40:00', 5, 'Món ăn tuyệt với')");
        sqLiteDatabase.execSQL("INSERT INTO comment VALUES(null, 2, 2, '2022-05-07 14:40:00', 4.5, 'Thật là ngon!')");

        sqLiteDatabase.execSQL("INSERT INTO comment VALUES(null, 1, 3, '2022-05-07 14:40:00', 3.4, 'Món ăn tuyệt với')");
        sqLiteDatabase.execSQL("INSERT INTO comment VALUES(null, 2, 3, '2022-05-07 14:40:00', 4.4, 'Thật là ngon!')");

        sqLiteDatabase.execSQL("INSERT INTO comment VALUES(null, 1, 4, '2022-05-07 14:40:00', 4.7, 'Món ăn tuyệt với')");
        sqLiteDatabase.execSQL("INSERT INTO comment VALUES(null, 2, 4, '2022-05-07 14:40:00', 4.1, 'Thật là ngon!')");

        sqLiteDatabase.execSQL("INSERT INTO comment VALUES(null, 1, 5, '2022-05-07 14:40:00', 4, 'Món ăn tuyệt với')");
        sqLiteDatabase.execSQL("INSERT INTO comment VALUES(null, 2, 5, '2022-05-07 14:40:00', 4.5, 'Thật là ngon!')");

        sqLiteDatabase.execSQL("INSERT INTO comment VALUES(null, 1, 6, '2022-05-07 14:40:00', 4.9, 'Món ăn tuyệt với')");
        sqLiteDatabase.execSQL("INSERT INTO comment VALUES(null, 2, 6, '2022-05-07 14:40:00', 4.2, 'Thật là ngon!')");

        sqLiteDatabase.execSQL("INSERT INTO comment VALUES(null, 1, 8, '2022-05-07 14:40:00', 4, 'Món ăn tuyệt với')");
        sqLiteDatabase.execSQL("INSERT INTO comment VALUES(null, 2, 8, '2022-05-07 14:40:00', 4.6, 'Thật là ngon!')");

        sqLiteDatabase.execSQL("INSERT INTO comment VALUES(null, 1, 9, '2022-05-07 14:40:00', 5, 'Món ăn tuyệt với')");
        sqLiteDatabase.execSQL("INSERT INTO comment VALUES(null, 2, 9, '2022-05-07 14:40:00', 3.9, 'Thật là ngon!')");

        sqLiteDatabase.execSQL("INSERT INTO comment VALUES(null, 1, 11, '2022-05-07 14:40:00', 5, 'Món ăn tuyệt với')");
        sqLiteDatabase.execSQL("INSERT INTO comment VALUES(null, 2, 11, '2022-05-07 14:40:00', 3.5, 'Thật là ngon!')");

        sqLiteDatabase.execSQL("INSERT INTO comment VALUES(null, 1, 13, '2022-05-07 14:40:00', 5, 'Món ăn tuyệt với')");
        sqLiteDatabase.execSQL("INSERT INTO comment VALUES(null, 2, 13, '2022-05-07 14:40:00', 3, 'Thật là ngon!')");

        sqLiteDatabase.execSQL("INSERT INTO comment VALUES(null, 1, 14, '2022-05-07 14:40:00', 4.3, 'Món ăn tuyệt với')");
        sqLiteDatabase.execSQL("INSERT INTO comment VALUES(null, 2, 14, '2022-05-07 14:40:00', 4.9, 'Thật là ngon!')");

        sqLiteDatabase.execSQL("INSERT INTO comment VALUES(null, 1, 15, '2022-05-07 14:40:00', 4.2, 'Món ăn tuyệt với')");
        sqLiteDatabase.execSQL("INSERT INTO comment VALUES(null, 2, 15, '2022-05-07 14:40:00', 4.8, 'Thật là ngon!')");

        sqLiteDatabase.execSQL("INSERT INTO comment VALUES(null, 1, 16, '2022-05-07 14:40:00', 4.8, 'Món ăn tuyệt với')");
        sqLiteDatabase.execSQL("INSERT INTO comment VALUES(null, 2, 16, '2022-05-07 14:40:00', 4, 'Thật là ngon!')");

        sqLiteDatabase.execSQL("INSERT INTO comment VALUES(null, 1, 17, '2022-05-07 14:40:00', 4.1, 'Món ăn tuyệt với')");
        sqLiteDatabase.execSQL("INSERT INTO comment VALUES(null, 2, 17, '2022-05-07 14:40:00', 4.6, 'Thật là ngon!')");

        sqLiteDatabase.execSQL("INSERT INTO comment VALUES(null, 1, 18, '2022-05-07 14:40:00', 4.5, 'Món ăn tuyệt với')");
        sqLiteDatabase.execSQL("INSERT INTO comment VALUES(null, 2, 18, '2022-05-07 14:40:00', 4.7, 'Thật là ngon!')");

        sqLiteDatabase.execSQL("INSERT INTO comment VALUES(null, 1, 19, '2022-05-07 14:40:00', 4.5, 'Món ăn tuyệt với')");
        sqLiteDatabase.execSQL("INSERT INTO comment VALUES(null, 2, 19, '2022-05-07 14:40:00', 5, 'Thật là ngon!')");

        sqLiteDatabase.execSQL("INSERT INTO comment VALUES(null, 1, 20, '2022-05-07 14:40:00', 3.9, 'Món ăn tuyệt với')");
        sqLiteDatabase.execSQL("INSERT INTO comment VALUES(null, 2, 20, '2022-05-07 14:40:00', 4.1, 'Thật là ngon!')");

        sqLiteDatabase.execSQL("INSERT INTO comment VALUES(null, 1, 21, '2022-05-07 14:40:00', 4.2, 'Món ăn tuyệt với')");
        sqLiteDatabase.execSQL("INSERT INTO comment VALUES(null, 2, 21, '2022-05-07 14:40:00', 4.7, 'Thật là ngon!')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
