package commons;

public class GloblalConstants {
    //Server Url: Dev/ Testing/ Staging/ Product
    //Database: Ip/ port
    //Timeout: Short/ Long
    //Username/ Pass
    //Third Party: Sandbox Paypall
    //Download/ Upload folder
    //Relative Project Path
    //OS Name
    //Cloud Testing: Browserstack/ Saucelab/ Crossbrowser Testing (Acess Token/ ID)
    //...

    public static final String DEV_USER_URL = "http://demo.nopcommerce/";
    public static final String DEV_ADMIN_URL = "http://demo.nopcommerce/";
    public static final long SHORT_TIMEOUT = 5;
    public static final long LONG_TIMEOUT = 30;
    public static final String DEV_ADMIN_USERNAME = "admin@nopcommerce.com";
    public static final String DEV_ADMIN_PASSWORD = "admin@nopcommerce.com";
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String RELATIVE_PROJECT_PATH = System.getProperty("user.dir");
    public static final String UPLOAD_PATH = RELATIVE_PROJECT_PATH + "/uploadFiles/";
    public static final String DOWNLOAD_PATH = RELATIVE_PROJECT_PATH + "/downloadFiles/";
}
