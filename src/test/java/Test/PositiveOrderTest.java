package Test;

import PageObject.MainPage;
import PageObject.OrderForm;
import PageObject.OrderPage;
import org.junit.Test;
import static org.junit.Assert.*;

public class PositiveOrderTest  extends BaseUITest {

    @Test
    public void checkPositiveOrderScooterButtonInHeader(){
        driver.get(MainPage.URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.ClickButtonAcceptCookies();
        mainPage.ClickOrderButtonInHeader();

        OrderPage orderPage = new OrderPage(driver);
        OrderForm orderForm = new OrderForm("Дмитрий","Васильев","Рахманинова д7.к3.","Стахановская","+79855044455","18.07.2022","сутки","чёрный жемчуг","Нужно позвонить за 30 минут");

        orderPage.writeNameOnNameField(orderForm.getName());
        orderPage.writeSurnameOnSurnameField(orderForm.getSurname());
        orderPage.writeAddressOnAddressField(orderForm.getAddress());
        orderPage.chooseMetroStation(orderForm.getMetroStation());
        orderPage.writePhoneNumberField(orderForm.getPhoneNumber());
        orderPage.clickOnNextButtonForNextOrderPage();
        orderPage.writeOrderDate(orderForm.getOrderDate());
        orderPage.chooseDurationOfOrder(orderForm.getRentalPeriod());
        orderPage.chooseColourOfScooter(orderForm.getScooterColour());
        orderPage.writeCommentForDeliveryMan(orderForm.getOrderComment());
        orderPage.clickOnFinalOrderButton();


        boolean result = orderPage.getInformationAboutOrder();

        assertTrue(result);
    }

    @Test
    public void checkPositiveOrderScooterButtonInMiddle(){
        driver.get(MainPage.URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.ClickButtonAcceptCookies();
        mainPage.scrollToTheQuestionsSection();
        mainPage.ClickOrderButtonInMiddle();

        OrderPage orderPage = new OrderPage(driver);
        OrderForm orderForm = new OrderForm("Иван","Иванов","Рахманинова д7.к9.","Котельники","+79855043355","19.07.2022","двое суток","серая безысходность","Нужно позвонить в калитку");

        orderPage.writeNameOnNameField(orderForm.getName());
        orderPage.writeSurnameOnSurnameField(orderForm.getSurname());
        orderPage.writeAddressOnAddressField(orderForm.getAddress());
        orderPage.chooseMetroStation(orderForm.getMetroStation());
        orderPage.writePhoneNumberField(orderForm.getPhoneNumber());
        orderPage.clickOnNextButtonForNextOrderPage();
        orderPage.writeOrderDate(orderForm.getOrderDate());
        orderPage.chooseDurationOfOrder(orderForm.getRentalPeriod());
        orderPage.chooseColourOfScooter(orderForm.getScooterColour());
        orderPage.writeCommentForDeliveryMan(orderForm.getOrderComment());
        orderPage.clickOnFinalOrderButton();


        boolean result = orderPage.getInformationAboutOrder();

        assertTrue(result);
    }





}
