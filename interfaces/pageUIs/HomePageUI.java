package pageUIs;

public class HomePageUI {
    // 1 - public
    //Không set protected vì các class bên ngoài package sẽ không dùng được -> không áp dụng kế thừa
    //Không set private: ngoài class không dùng được
    //Không set default: ngoài package không dùng được
    //public: bất kì 1 clas nào cũng gọi tới để sử dụng được

    // 2 - static
    //Truy cập từ phạm vi class ở 1 class khác

    // 3 - final
    //Không được phép thay đổi giá trị của biến khi sử dụng
    //Không nên thay đổi trong quá trình chạy

    //Không có từ khoá nào là đại diện cho hằng số
    //Kết hợp 2 từ khoá lại với nhau = HẰNG SỐ
    //static + final
    //Tên biến của hằng số: Viết hoa
    //Nhiều hơn 1 từ phân tách bởi dấu _

    // 4 - Xpath/ Css/ Id/ Class/ Name: tham số của class By

    public static final String REGISTER_LINK = "//a[@class='ico-register']";
    public static final String LOGIN_LINK = "//a[@class='ico-login']";
    public static final String LOGOUT_LINK = "//a[@class='ico-logout']";
    public static final String MY_ACCOUNT_LINK = "//a[@class='ico-account']";
}
