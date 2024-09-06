package javaBasic;

import org.testng.annotations.Test;

import java.util.ArrayList;

public class Topic_04_Rest_Parameter {
    //Click vào page Address:
    String addressLink = "xpath=//div[@class='side-2']//a[text()='Addresses']";
    //Click vào page Orders:
    String orderLink = "xpath=//div[@class='side-2']//a[text()='Orders']";

    String sidebarLink = "xpath=//div[@class='side-2']//a[text()='%s']";

    String dynamicLink = "//div[@class='%s']//a[text()='%s']";

    String afghanistan = "//td[@data-key='females' and text()='384187']/following-sibling::td[@data-key='country' and text()='Afghanistan']" +
            "/following-sibling::td[@data-key='males' and text()='407124']/following-sibling::td[@data-key='total' and text()='791312']";

    String dynamicCountry = "//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']" +
            "/following-sibling::td[@data-key='males' and text()='%s']/following-sibling::td[@data-key='total' and text()='%s']";

    @Test
    public void TC_01_Rest_Param() {
        //Cố định
        clickToElement(sidebarLink, "Customer info");
        clickToElement(sidebarLink, "Addresses");

        // 1 param
        clickToElement(dynamicLink, "footer", "Orders");
        clickToElement(dynamicLink, "footer", "Blog");

        // 2 param
        clickToElement(dynamicLink, "header", "Register");
        clickToElement(dynamicLink, "header", "Log in");

        // 4 param
        clickToElement(dynamicCountry, "338282", "Argentina", "349238", "687522");
        clickToElement(dynamicCountry, "24128", "Albania", "25266", "49397");

        ArrayList<String> countries = new ArrayList<>();
    }

//    //Hàm để click vào 1 element cố định
//    public void clickToElement(String locatorValue) {
//        System.out.println("Click to: " + locatorValue);
//    }
//
//    //Hàm để click vào 1 element không cố định vs 1 tham số
//    public void clickToElement(String locatorValue, String pageName) {
//        locatorValue = String.format(locatorValue, pageName);
//        System.out.println("Click to: " + locatorValue);
//    }
//
//    //Hàm để click vào 1 element không cố định vs 2 tham số
//    public void clickToElement(String locatorValue, String pageType, String pageName) {
//
//        locatorValue = String.format(locatorValue, pageType, pageName);
//        System.out.println("Click to: " + locatorValue);
//    }
//
//    //Hàm để click vào 1 element không cố định vs 4 tham số
//    public void clickToElement(String locatorValue, String female, String country, String male, String total) {
//        locatorValue = String.format(locatorValue, female, country, male, total);
//        System.out.println("Click to: " + locatorValue);
//    }

    //Var Argument = Rest Parameter
    //Hàm để click vào 1 element không cố định vs bất kì tham số (1-n tham số)
    public void clickToElement(String locatorValue, String... values) {
        locatorValue = String.format(locatorValue, (Object[]) values); //String.format(String, Object)
        System.out.println("Click to: " + locatorValue);
    }
}
