package com.sagar.browserapp;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserApp {
    public AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
        capabilities.setCapability("chromeOptions", ImmutableMap.of("w3c",false));
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.get("https://www.amazon.com");
        System.out.println("setup success");
    }

    @Test
    public void getText(){
        String res=driver.findElement(By.xpath("//span[@class='a-truncate-cut' and text()='Create an account']")).getText();
        Assert.assertEquals(res,"Create an account");
    }

    @Test
    public void clickDeals() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@id='intlDeals']")).click();
    }

    @Test
    public void clickAmazonBasics(){
        driver.findElement(By.xpath("//a[text()='Amazon Basics']")).click();
    }

    @Test
    public void clickBestSellers() throws InterruptedException {
        driver.findElement(By.xpath("//a[text()='Best Sellers']")).click();
    }

    @Test
    public void signIn(){
        driver.findElement(By.xpath("//a[text()='Sign in securely']")).click();
    }

    @Test
    public void search(){
        driver.findElement(By.xpath("//input[@placeholder='Search Amazon']")).sendKeys("shoes");
    }

    @Test
    public void copyRight(){
       String res= driver.findElement(By.xpath("//div[@id='nav-ftr-copyright']")).getText();
       Assert.assertEquals(res,"© 1996-2024, Amazon.com, Inc. or its affiliates");
    }
}
