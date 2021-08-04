package com.blz.selenium.pages;

import com.blz.selenium.base.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Home_Page extends BaseClass {

    @FindBy(xpath = "//span[normalize-space()='Flights']")
    WebElement flights;

    @FindBy(xpath = "//li[@data-cy='roundTrip']")
    WebElement round_trip;

    @FindBy(xpath = "//span[normalize-space()='From']")
    WebElement from_location;

    @FindBy(xpath = "//input[@placeholder='From']")
    WebElement from_location_input;

    @FindBy(xpath = "//p[normalize-space()='Mumbai, India']")
    WebElement go_to_location;

    @FindBy(xpath = "//span[normalize-space()='To']")
    WebElement to_location;

    @FindBy(xpath = "//div[@class='hsw_autocomplePopup autoSuggestPlugin makeFlex column spaceBetween']/div/input")
    WebElement to_location_input;

    @FindBy(css = "p[class='font14 appendBottom5 blackText']")
    List<WebElement> list_of_locations;

    @FindBy(xpath = "//label[contains(@for,'departure')]")
    WebElement Departure;

    @FindBy(xpath = "//div[@aria-label='Fri Aug 06 2021']//div[@class='dateInnerCell']")
    WebElement select_departure_date;

    @FindBy(xpath = "//span[normalize-space()='RETURN']")
    WebElement Return;

    @FindBy(xpath = "//div[contains(@aria-label,'Fri Aug 13 2021')]//div[contains(@class,'dateInnerCell')]")
    WebElement select_return_date;

    @FindBy(xpath = "//a[normalize-space()='Search']")
    WebElement search_btn;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[1]/div[2]")
    List<WebElement> departure_flights;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[2]/div[2]")
    List<WebElement> returnFlights;

    @FindBy(xpath = "//div[@class='filtersOuter simplev2'][1]/div/div/div/label[1]")
    WebElement on_non_stop;

    @FindBy(xpath = "//div[@class='filtersOuter simplev2'][1]/div/div/div/label[2]")
    WebElement on_one_stop;

    @FindBy(xpath = "//div[@class='filtersOuter simplev2'][2]/div/div/div/label[1]")
    WebElement return_non_stop;

    @FindBy(xpath = "//div[@class='filtersOuter simplev2'][2]/div/div/div/label[2]")
    WebElement return_one_stop;

    @FindBy(xpath = "//div[@class='paneView'][1]/div[2]/div/div/label/div/div[2]/div[2]/p")
    List<WebElement> departurePrice;

    @FindBy(xpath = "//div[@class='paneView'][2]/div[2]/div/div/label/div/div[2]/div[2]/p")
    List<WebElement> returnPrice;

    @FindBy(xpath = "//span[@class='whiteText blackFont fontSize16']")
    List<WebElement> bottomPagePrice;

    @FindBy(xpath = "//span[@class='whiteText fontSize22 boldFont']")
    WebElement bottomTotalPrice;


    public Home_Page(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public String flights_booking() throws InterruptedException {
        flights.click();
        Thread.sleep(2000);
        round_trip.click();
        Thread.sleep(3000);
        from_location.click();
        Thread.sleep(2000);
        from_location_input.sendKeys("Mumbai");
        Thread.sleep(3000);
        go_to_location.click();
        Thread.sleep(3000);
        to_location.click();
        Thread.sleep(2000);
        to_location_input.sendKeys("Bengaluru");
        Thread.sleep(2000);
        for(WebElement toWebElement:list_of_locations) {
            String toCityName = toWebElement.getText();
            System.out.println("To list of cities:-> " + toCityName);
            if (toCityName.contains("Bengaluru")) {
                toWebElement.click();
                break;
            }
        }
        Thread.sleep(2000);
        Departure.click();
        Thread.sleep(5000);
        select_departure_date.click();
        Thread.sleep(5000);
        Return.click();
        Thread.sleep(5000);
        select_return_date.click();
        Thread.sleep(5000);
        search_btn.click();
        Thread.sleep(1000);

        System.out.println("List of departure flights : " + departure_flights.size());
        System.out.println("------------------------------------------------------");
        for (WebElement departure_flights : departure_flights){
            String flights_Name = departure_flights.getText();
            Thread.sleep(4000);
            System.out.println("Departure Flights : " +flights_Name);
            System.out.println("-----------------------------------");
        }

        System.out.println("List of return flights : " + returnFlights.size());
        System.out.println("------------------------------------------------------");
        for (WebElement return_flights : returnFlights){
            String flights_Name = return_flights.getText();
            Thread.sleep(4000);
            System.out.println("Return Flights : " +flights_Name);
            System.out.println("-----------------------------------");
        }

        on_non_stop.click();
        Thread.sleep(1000);
        on_one_stop.click();
        Thread.sleep(1000);
        return_non_stop.click();
        Thread.sleep(1000);
        return_one_stop.click();
        Thread.sleep(2000);

        System.out.println("List of departure flights : " + departure_flights.size());
        System.out.println("------------------------------------------------------");
        for (WebElement departure_flights : departure_flights){
            String flights_Name = departure_flights.getText();
            Thread.sleep(1000);
            System.out.println("Departure Flights : " +flights_Name);
            System.out.println("-----------------------------------");
        }

        System.out.println("List of return flights : " + returnFlights.size());
        System.out.println("------------------------------------------------------");
        for (WebElement return_flights : returnFlights){
            String flights_Name = return_flights.getText();
            Thread.sleep(1000);
            System.out.println("Return Flights : " +flights_Name);
            System.out.println("-----------------------------------");
        }

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", departure_flights.get(0));
        Thread.sleep(2000);
        departure_flights.get(0).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", returnFlights.get(0));
        Thread.sleep(2000);
        returnFlights.get(0).click();
        Thread.sleep(1000);

        int priceDeparture = priceConverter(departurePrice.get(0).getText());
        int priceReturn = priceConverter(returnPrice.get(0).getText());

        System.out.println("Departure flight Price: " + priceDeparture);
        System.out.println("Return flight Price: " + priceReturn);

        boolean verify_Departure_Price = departurePrice.get(0).getText().equals(bottomPagePrice.get(0).getText());
        System.out.println("Verifying departure price with bottom page departure price:" + verify_Departure_Price);
        boolean verify_Return_Price = returnPrice.get(0).getText().equals(bottomPagePrice.get(1).getText());
        System.out.println("Verifying return price with bottom page return price price:" + verify_Return_Price);
        int Departure_bottom_price = priceConverter(bottomPagePrice.get(0).getText());
        System.out.println("Departure price at bottom : " + Departure_bottom_price);
        int Return_bottom_price = priceConverter(bottomPagePrice.get(1).getText());
        System.out.println("Return price at bottom : " + Return_bottom_price);
        int totalBottomPrice = priceConverter(bottomTotalPrice.getText());
        System.out.println("Total price " + totalBottomPrice);
        int Addition_of_prices = Departure_bottom_price + Return_bottom_price;
        System.out.println("Addition of departure and return flight price :" + Addition_of_prices);
        boolean verityBottomTotal = totalBottomPrice == Addition_of_prices;

        System.out.println("verifying total price of bottom page: " + verityBottomTotal);
        return driver.getTitle();
    }

    private int priceConverter(String priceText) {
        String priceValue = priceText.replaceAll("[^(0-9)]+", "");
        return Integer.parseInt(priceValue);

    }
}
