package core;


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;

public class Firefox {

    static WebDriver driver;

    public static boolean isPresent(final By by) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        if (!driver.findElements(by).isEmpty()) return true;
           else return false;
    }


    public static void main(String[] args) throws InterruptedException {
        Logger.getLogger("").setLevel(Level.OFF);
        String driverPath = "";
        String url = "https://www.macys.com/shop/product/apple-watch-series-3-gps-cellular-42mm-space-black-stainless-steel-case-with-black-sport-band?ID=5302660&CategoryID=55285";

        if (System.getProperty("os.name").toUpperCase().contains("MAC"))
        driverPath = "./resources/webdrivers/mac/geckodriver.sh";
             else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))
        driverPath = "./resources/webdrivers/pc/geckodriver.exe";
             else throw new IllegalArgumentException("Unknown OS");

        System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.get(url);

String [][] elements = {{"Logo", "//*[@id=\"Layer_1\"]"},
        {"Sign In", "//*[@id=\"globalMastheadSignIn\"]"},
        {"My Account", "//*[@id=\"href_myAccountHeader\"]"},
        {"Stores", "//header/div[1]/div/ul/li[5]/a"},
        {"Customer Service", "//header/div[1]/div/ul/li[7]/a"},
        {"Search", "//*[@id=\"globalSearchInputField\"]"},
        {"Search Submit", "//*[@id=\"searchSubmit\"]"},
        {"My Bag Button", "//*[@id=\"itemInfo\"]"},
        {"Count Of Items", "//*[@id=\"itemCount\"]"},
        {"Small image 1", "//div[2]/div[2]/ul/li[1]"},
        {"Small image 2", "//div[2]/div[2]/ul/li[2]"},
        {"Video Icon", "//aside/div[2]/div"},
        {"Item's Title", "//div[1]/div[1]/div/div[1]/div/div/div/div/a"},
        {"Item's Title 2", "//div[1]/div/div[1]/div/div/div/div/h1"},
        {"Rating", "//span[1]/span/span[1]/span[2]"},
        {"Reviews", "//span/span[2]/a"},
        {"Price", "//section[2]/div/div[1]/span"},
        {"Color Title", "//div[1]/div[2]/div[1]/div/div/span[1]"},
        {"Color Value", "/x/div[1]/div[2]/div[1]/div/div/span[2]"},
        {"Item’s Quantity Title", "//div[3]/div[1]/div[1]/label"},
        {"Item’s Quantity", "//*[@id=\"productQuantity_3197663\"]"},
        {"Add To Bag Button", "//div[2]/button"},
        {"Add To List Button", "//div[3]/div/label"},
        {"Add To Registry Button", "//div[2]/a/div"},
        {"Let Gift Recipient Button", "//div[2]/div[1]/div/a/div[1]"},
        {"Gift Now Button", "//div/a/div[2]"},
        {"Availability Title", "//div[2]/div/div/div[1]/div[3]/div/div/div[1]/strong"},
        {"Ship Icon", "//div[3]/div/div/div[2]/div[2]/div"},
        {"Ship Title", "//div[3]/b"},
        {"Ship Value", "//div[3]/div/div/span"}};

        System.out.println("Browser: Firefox");
        System.out.println("Page URL: " + driver.getCurrentUrl());
        for (int i = 0; i < elements.length; i++){
            System.out.println("Element " + (i+1) + ": \"" + elements[i][0] + "\" " + (isPresent(By.xpath(elements[i][1])) ? "Exists" : " Not exist "));
        }

        driver.quit();
    }
}

