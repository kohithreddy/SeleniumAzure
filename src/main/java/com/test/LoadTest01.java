package com.test;

import java.util.concurrent.TimeUnit;

//--
import org.openqa.selenium.By;
//--
import org.openqa.selenium.WebDriver;
//--
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//--
import org.openqa.selenium.firefox.FirefoxDriver;
//--
import org.testng.Assert;
//--
import org.testng.annotations.AfterClass;
//--
import org.testng.annotations.BeforeClass;
//--
import org.testng.annotations.Test;

public class LoadTest01 {

    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
    	String browser="chrome";
    	
    	if(browser=="chrome")
    	{
        	System.setProperty("webdriver.chrome.driver","jars\\chromedriver.exe");
        	driver= new ChromeDriver();
    	}
    	else if ( browser=="firefox")
    	{

        	System.setProperty("webdriver.gecko.driver","jars\\geckodriver.exe");
        	driver = new FirefoxDriver();
    	}

        
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Test
    public void verifySearchButton() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://www.google.com");

        String search_text = "Google Search";
        WebElement search_button = driver.findElement(By.name("btnK"));

        String text = search_button.getAttribute("value");
        
        System.out.println("Hello World");

        Assert.assertEquals(text, search_text, "Text not found!");
    }
}