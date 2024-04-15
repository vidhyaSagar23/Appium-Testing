package com.sagar.calci;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Calculator {

    public AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","emulator-5554");
        capabilities.setCapability("appPackage","com.android.calculator2");
        capabilities.setCapability("appActivity","com.android.calculator2.Calculator");
        capabilities.setCapability("platformVersion","9.0");
        capabilities.setCapability("platformName","Android");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        System.out.println("setup success");
    }

    @Test
    public void calculate(){
        driver.findElement(By.id("com.android.calculator2:id/digit_1")).click();

        driver.findElement(By.id("com.android.calculator2:id/digit_2")).click();

        driver.findElement(By.id("com.android.calculator2:id/digit_3")).click();

        driver.findElement(By.id("com.android.calculator2:id/digit_4")).click();

        driver.findElement(By.id("com.android.calculator2:id/digit_5")).click();

        driver.findElement(By.id("com.android.calculator2:id/digit_6")).click();

        driver.findElement(By.id("com.android.calculator2:id/digit_7")).click();

        driver.findElement(By.id("com.android.calculator2:id/digit_8")).click();

        driver.findElement(By.id("com.android.calculator2:id/digit_9")).click();

        driver.findElement(By.id("com.android.calculator2:id/digit_0")).click();

        driver.findElement(AppiumBy.accessibilityId("point")).click();

        String res = driver.findElement(By.id("com.android.calculator2:id/formula")).getText();

        Assert.assertEquals(res,"1,234,567,890.");
    }

    @Test
    public void add(){

        driver.findElement(By.id("com.android.calculator2:id/digit_1")).click();

        driver.findElement(AppiumBy.accessibilityId("plus")).click();

        driver.findElement(By.id("com.android.calculator2:id/digit_2")).click();

        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        String res = driver.findElement(By.id("com.android.calculator2:id/result")).getText();

        Assert.assertEquals(res,"3");
    }

    @Test
    public void minus(){

        driver.findElement(By.id("com.android.calculator2:id/digit_3")).click();

        driver.findElement(AppiumBy.accessibilityId("minus")).click();

        driver.findElement(By.id("com.android.calculator2:id/digit_2")).click();

        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        String res = driver.findElement(By.id("com.android.calculator2:id/result")).getText();

        Assert.assertEquals(res,"1");
    }

    @Test
    public void multiply(){

        driver.findElement(By.id("com.android.calculator2:id/digit_3")).click();

        driver.findElement(AppiumBy.accessibilityId("multiply")).click();

        driver.findElement(By.id("com.android.calculator2:id/digit_2")).click();

        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        String res = driver.findElement(By.id("com.android.calculator2:id/result")).getText();

        Assert.assertEquals(res,"6");
    }

    @Test
    public void divide(){

        driver.findElement(By.id("com.android.calculator2:id/digit_6")).click();

        driver.findElement(AppiumBy.accessibilityId("divide")).click();

        driver.findElement(By.id("com.android.calculator2:id/digit_2")).click();

        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        String res = driver.findElement(By.id("com.android.calculator2:id/result")).getText();

        Assert.assertEquals(res,"3");
    }

    @Test
    public void moreOptions(){
        driver.findElement(AppiumBy.accessibilityId("More options")).click();

        driver.findElement(By.xpath("\t\n" +
                "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]" +
                "/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")).click();

        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();

    }
}
