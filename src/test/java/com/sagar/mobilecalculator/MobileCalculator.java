package com.sagar.mobilecalculator;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MobileCalculator {
    public AndroidDriver driver;


    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","6dfc885b");
        capabilities.setCapability("appPackage","com.miui.calculator");
        capabilities.setCapability("appActivity","com.miui.calculator.cal.CalculatorActivity");
        capabilities.setCapability("platformVersion","12.0");
        capabilities.setCapability("platformName","Android");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
//        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("setup success");
    }

    @Test
    public void clickButtons() {
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout")).click();

        driver.findElement(By.id("com.miui.calculator:id/btn_1_s")).click();

        driver.findElement(By.id("com.miui.calculator:id/btn_2_s")).click();

        driver.findElement(By.id("com.miui.calculator:id/btn_3_s")).click();

        driver.findElement(By.id("com.miui.calculator:id/btn_4_s")).click();

        driver.findElement(By.id("com.miui.calculator:id/btn_5_s")).click();

        driver.findElement(By.id("com.miui.calculator:id/btn_6_s")).click();

        driver.findElement(By.id("com.miui.calculator:id/btn_7_s")).click();

        driver.findElement(By.id("com.miui.calculator:id/btn_8_s")).click();

        driver.findElement(By.id("com.miui.calculator:id/btn_9_s")).click();

        driver.findElement(By.id("com.miui.calculator:id/btn_0_s")).click();

        driver.findElement(AppiumBy.accessibilityId("multiply")).click();

        driver.findElement(By.id("com.miui.calculator:id/btn_1_s")).click();
    }

    @Test
    public void operations() {

        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout")).click();


        driver.findElement(By.id("com.miui.calculator:id/btn_1_s")).click();

        driver.findElement(By.id("com.miui.calculator:id/btn_2_s")).click();

        driver.findElement(AppiumBy.accessibilityId("plus")).click();

        driver.findElement(By.id("com.miui.calculator:id/btn_2_s")).click();

        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        String res = driver.findElement(By.id("com.miui.calculator:id/result")).getText();

        Assert.assertEquals(res,"= 14");

        driver.findElement(AppiumBy.accessibilityId("minus")).click();

        driver.findElement(By.id("com.miui.calculator:id/btn_2_s")).click();

        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        driver.findElement(By.id("com.miui.calculator:id/result")).getText();

        driver.findElement(AppiumBy.accessibilityId("divide")).click();

        driver.findElement(By.id("com.miui.calculator:id/btn_2_s")).click();

        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        driver.findElement(AppiumBy.accessibilityId("delete")).click();

        driver.findElement(AppiumBy.accessibilityId("clear")).click();

    }

    @Test
    public void others() {
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout")).click();
        driver.findElement(By.id("com.miui.calculator:id/btn_2_s")).click();

        driver.findElement(By.id("com.miui.calculator:id/btn_switch")).click();
    }
}
