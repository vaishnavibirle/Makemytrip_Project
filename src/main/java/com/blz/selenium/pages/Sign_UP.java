package com.blz.selenium.pages;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Sign_UP extends BaseClass {


    public static final String ACCOUNT_SID = "AC8523209237ebeac2780fb4fbf2cb9805";
    public static final String AUTH_TOKEN = "fb1e2bd516e71e0105308591a29bcc8f";

    @FindBy(xpath = "//*[@id=\"SW\"]/div[1]/div[1]/ul/li[3]")
    WebElement login_or_create_account;

    @FindBy(xpath = "//input[@id='username']")
    WebElement username_or_mobile;

    @FindBy(xpath = "//i[@class='drop-down down']")
    WebElement dropdown;

    @FindBy(xpath = "//form//div[3]")
    WebElement US_country_code;

    @FindBy(xpath = "//button[@class='capText font16']")
    WebElement continue_btn;

    @FindBy(xpath = "//input[@placeholder='Enter OTP here']")
    WebElement otp_input;

    @FindBy(xpath = "//span[normalize-space()='Verify & Create Account']")
    WebElement verify;

    @FindBy(xpath = "//input[@id='firstName']")
    WebElement first_name;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submit;

    public Sign_UP(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void sign_up_with_otp() throws InterruptedException {
        login_or_create_account.click();
        Thread.sleep(2000);
        username_or_mobile.sendKeys("2243026816");
        Thread.sleep(2000);
        dropdown.click();
        Thread.sleep(2000);
        US_country_code.click();
        Thread.sleep(1500);
        continue_btn.click();
        Thread.sleep(2000);
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Thread.sleep(200);
        String smsBody = getMessage();
        Thread.sleep(200);
        System.out.println(smsBody);
        Thread.sleep(200);
        String[] OTPNumber = smsBody.split("[^\\d]+");
        Thread.sleep(200);
        System.out.println(Arrays.toString(OTPNumber));
        Thread.sleep(2000);
        otp_input.sendKeys(OTPNumber);
        Thread.sleep(3000);
        verify.click();
        Thread.sleep(3000);
        first_name.sendKeys("Harshal");
        Thread.sleep(2000);
        password.sendKeys("Harshal@123");
        Thread.sleep(2000);
        submit.click();
        Thread.sleep(2000);
    }

    public static String getMessage() {
        return getMessages().filter(m -> m.getDirection().compareTo(Message.Direction.INBOUND) == 0)
                .filter(m -> m.getTo().equals("+12243026816")).map(Message::getBody).findFirst()
                .orElseThrow(IllegalStateException::new);
    }

    private static Stream<Message> getMessages() {
        ResourceSet<Message> messages = Message.reader(ACCOUNT_SID).read();
        return StreamSupport.stream(messages.spliterator(), false);
    }
}
