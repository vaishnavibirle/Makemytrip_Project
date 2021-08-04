package com.blz.selenium.test;

import com.blz.selenium.base.BaseClass;
import com.blz.selenium.pages.Home_Page;
import com.blz.selenium.pages.Login;
import com.blz.selenium.pages.Sign_UP;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Make_my_trip_test extends BaseClass {

    @Test
    public void signup_test() throws InterruptedException {
        Sign_UP sign_up = new Sign_UP(driver);
        sign_up.sign_up_with_otp();
    }

    @Test
    public void login_test() throws InterruptedException {
        Login login = new Login(driver);
        login.login_with_credentials();
    }

    @Test
    public void flights_booking_test() throws InterruptedException {
        Login login = new Login(driver);
        login.login_with_credentials();
        Home_Page homePage = new Home_Page(driver);
        String actual = homePage.flights_booking();
        String expected = "MakeMyTrip";
        Assert.assertEquals(actual,expected);
        System.out.println("Verified all details for booking.");
    }
}
