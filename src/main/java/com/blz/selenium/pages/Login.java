package com.blz.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;;

public class Login extends BaseClass {

    @FindBy(xpath = "//*[@id=\"SW\"]/div[1]/div[1]/ul/li[3]")
    WebElement login_or_create_account;

    @FindBy(xpath = "//input[@id='username']")
    WebElement username_or_mobile;

    @FindBy(xpath = "//button[@class='capText font16']")
    WebElement continue_btn;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password_input;

    @FindBy(xpath = "//span[normalize-space()='Login']")
    WebElement login_btn;


    public Login(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void login_with_credentials() throws InterruptedException {
        login_or_create_account.click();
        Thread.sleep(2000);
        username_or_mobile.sendKeys("vaishnavibirle1133@gmail.com");
        Thread.sleep(2000);
        continue_btn.click();
        Thread.sleep(2000);
        password_input.sendKeys("Saniya@123");
        Thread.sleep(2000);
        login_btn.click();
        Thread.sleep(2000);
    }
}
