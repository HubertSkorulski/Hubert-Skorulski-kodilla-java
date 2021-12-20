package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookTestingApp {

    public static final String XPATH_DAY = "//div[@class = \"_5k_5\"]/span/span/select[1]";
    public static final String XPATH_MONTH = "//div[@class = \"_5k_5\"]/span/span/select[2]";
    public static final String XPATH_YEAR = "//div[@class = \"_5k_5\"]/span/span/select[3]";
    public static final String XPATH_SELECT = "//div[@class = \"_9xo5\"]/button[2]";
    public static final String XPATH_CREATE = "//div[@class = \"_6ltg\"]/a";
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://facebook.com/");

        driver.findElement(By.xpath(XPATH_SELECT)).click();
        driver.findElement(By.xpath(XPATH_CREATE)).click();
        Thread.sleep(3000);
        while (!driver.findElement(By.xpath(XPATH_DAY)).isEnabled());

        WebElement day = driver.findElement(By.xpath(XPATH_DAY));
        Select selectDay = new Select(day);
        selectDay.selectByValue("25");

        WebElement month = driver.findElement(By.xpath(XPATH_MONTH));
        Select selectMonth = new Select(month);
        selectMonth.selectByValue("10");

        WebElement year = driver.findElement(By.xpath(XPATH_YEAR));
        Select selectYear = new Select(year);
        selectYear.selectByValue("1997");


    }
}
