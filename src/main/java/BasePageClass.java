import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class BasePageClass extends BaseObjectClass{

    public BasePageClass(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }



    public void addVehicle(String year,String make, String model)  {

        elementClick(btnAddVehicle);
        btnYear.click();
        ddnSelection(lstYear,year);
        elementClick(btnMake);
        ddnSelection(lstMake,make);
        elementClick(btnModel);
        ddnSelection(lstModel,model);
    }

    public void addToCart(String item, String StoreZip){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(vehicleTxt));
        txtSearch.sendKeys(item);
        elementClick(btnSearch);
        elementClick(searchResult);
        elementClick(btnSelectStore);
        enterText(txtZip, StoreZip);
        elementClick(btnSearchZip);
        elementClick(btnSetStore);
        elementClick(btnAddToCart);
        elementClick(btnCheckOut);
        String actual=getText(lblProductTitle);
        Assert.assertEquals(actual,item,"Product expected"+item+"but found"+lblProductTitle);
    }

    public void enterCartDetails(String cardNo, String exp, String cvv, String price){
        elementClick(btnCheckOutCart);
        elementClick(btnGuest);
        elementClick(btnContinueCart);
        enterText(txtCardNo,cardNo);
        enterText(txtExpiry, exp);
        enterText(txtSecurityCode, cvv);
        elementClick(btnContinuePayment);
        String actual=txtPrice.getText();
        Assert.assertEquals(actual,price,"Price expected"+txtPrice+"but found"+actual);

    }

    public void enterAddress(String fname, String lName, String phone, String email, String add, String city, String zip,String stateValue){
        enterText(txtFirstName, fname);
        enterText(txtlastName, lName);
        enterText(txtphoneNumber, phone);
        enterText(txtemail, email);
        enterText(txtaddress1, add);
        enterText(txtcity, city);
        enterText(txtzipCode, zip);
        new Select(ddnState).selectByValue(stateValue);
    }



    @FindBy(xpath = "//*[@data-testid='add-vehicle-header-btn']")
    WebElement btnAddVehicle;
    @FindBy(xpath = "//div/div/input[@data-testid='yearheader-input']")
    WebElement btnYear;
    @FindBy(xpath="//div/ul[@aria-labelledby='yearheader']/li")
    List<WebElement> lstYear;
    @FindBy(xpath = "//div/div/input[@data-testid='makeheader-input']")
    WebElement btnMake;
    @FindBy(xpath="//div/ul[@aria-labelledby='makeheader']/li")
    List<WebElement> lstMake;
    @FindBy(xpath = "//div/div/input[@data-testid='modelheader-input']")
    WebElement btnModel;
    @FindBy(xpath="//div/ul[@aria-labelledby='modelheader']/li")
    List<WebElement> lstModel;
    @FindBy(xpath = "//input[@data-testid='desktop-search-input']")
    WebElement txtSearch;
    @FindBy(xpath = "//button[@id='searchBtnDesktopAndTablet']")
    WebElement btnSearch;
    @FindBy(id = "search-result-text-rv-battery")
    WebElement searchResult;
    @FindBy(xpath = "//button[@data-testid='cart-action-shelf-0']")
    WebElement btnAddToCart;
    @FindBy(xpath = "//button[@data-testid='view-cart-and-checkout-button']")
    WebElement btnCheckOut;
    @FindBy(xpath = "//button[@data-testid=\"search-store-button\" and text()='SELECT STORE']")
    WebElement btnSelectStore;
    @FindBy(id="SearchInput")
    WebElement txtZip;
    @FindBy(xpath = "//button[@data-testid='address-search-keyword']")
    WebElement btnSearchZip;
    @FindBy(id="setStore")
    WebElement btnSetStore;
    @FindBy(xpath="//h2[@data-testid='cart-product-title']")
    WebElement lblProductTitle;
    @FindBy(xpath = "//div[@data-testid='cart-checkout-button']")
    WebElement btnCheckOutCart;
    @FindBy(id="continueAsGuestCartTrigger")
    WebElement btnGuest;
    @FindBy(xpath = "//*[@data-testid='delivery-options-continue-btn']")
    WebElement btnContinueCart;
    @FindBy(id="cardNumber")
    WebElement txtCardNo;
    @FindBy(id="expiry")
    WebElement txtExpiry;
    @FindBy(id="securityCode")
    WebElement txtSecurityCode;
    @FindBy(id="at_submit_button_address_form")
    WebElement btnContinuePayment;

    @FindBy(id="firstName")
    WebElement txtFirstName;
    @FindBy(id="lastName")
    WebElement txtlastName;
    @FindBy(id="phoneNumber")
    WebElement txtphoneNumber;
    @FindBy(id="email")
    WebElement txtemail;
    @FindBy(id="address1")
    WebElement txtaddress1;
    @FindBy(id="city")
    WebElement txtcity;
    @FindBy(id="zipCode")
    WebElement txtzipCode;
    @FindBy(id="state")
    WebElement ddnState;
    @FindBy(xpath = "//div[@data-testid='price-fragment']")
    WebElement txtPrice;
    @FindBy(xpath="//div[@data-testid='vehicle-text']")
    WebElement vehicleTxt;


}
