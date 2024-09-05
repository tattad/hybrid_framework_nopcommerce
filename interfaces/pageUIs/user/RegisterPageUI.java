package pageUIs.user;

public class RegisterPageUI {
    //Tránh việc lặp lại
    //Define 1 lần duy nhất ở đây = không trùng lặp chỗ khác
    //Màn hình nào quản lí element riêng của màn hình đó
    public static final String FIRSTNAME_TEXTBOX = "xpath=//input[@id='FirstName']";
    public static final String LASTNAME_TEXTBOX = "xpath=//input[@id='LastName']";
    public static final String EMAIL_TEXTBOX = "xpath=//input[@id='Email']";
    public static final String PASSWORD_TEXTBOX = "xpath=//input[@id='Password']";
    public static final String CONFIRM_PASSWORD_TEXTBOX = "xpath=//input[@id='ConfirmPassword']";
    public static final String REGISTER_BTN = "xpath=//button[@id='register-button']";
    public static final String FIRSTNAME_ERROR_MSG = "id=FirstName-error";
    public static final String LASTNAME_ERROR_MSG = "id=LastName-error";
    public static final String EMAIL_ERROR_MSG = "id=Email-error";
    public static final String PASSWORD_ERROR_MSG = "xpath=//span[@data-valmsg-for='Password']";
    public static final String CONFIRM_PASSWORD_ERROR_MSG = "id=ConfirmPassword-error";
    public static final String REGISTRATION_COMPLETED_MSG = "class=result";
    public static final String NOP_COMMERCE_LOGO = "xpath=//div[@class='header-logo']//img";
}
//input[@id='Password']/following-sibling::span[@class='field-validation-error']