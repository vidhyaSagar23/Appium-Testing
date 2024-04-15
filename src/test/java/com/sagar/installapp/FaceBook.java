package com.sagar.installapp;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FaceBook {
   public AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","emulator-5554");
        capabilities.setCapability("appPackage","com.facebook.katana");
        capabilities.setCapability("appActivity","com.facebook.katana.LoginActivity");
        capabilities.setCapability("platformVersion","9.0");
        capabilities.setCapability("platformName","Android");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        System.out.println("setup success");
    }

    @Test
    public void findLogo() throws InterruptedException {
        Thread.sleep(7000);
        driver.findElement(By.id("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout" +
                "/android.widget.FrameLayout/android.widget.FrameLayout")).click();
        Thread.sleep(3000);
       boolean res= driver.findElement(By.id("\t\n" +
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout" +
                "/android.widget.FrameLayout/android.widget.FrameLayout/android.widget." +
                "ImageView[1]")).isDisplayed();

        Assert.assertTrue(res);
    }
}
