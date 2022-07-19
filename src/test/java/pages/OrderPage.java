package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderPage {

    private final WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
    // Заголовок успешного заказа
    private final By successOrderText = By.xpath("//div[@class = 'Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");

    //Кнопка Далее
    private final By nextButton  = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button");

    //Поле для ввода Имя
    private final By nameField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input");

    //Поле для ввода Фамилия
    private final By surnameField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input");

    //Поле для ввода Адрес
    private final By addressField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input");

    //Поле выбора станции метро
    private final By metroStationField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div/input");

    // Поле ввода номера телефона
    private final By phoneNumberField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input");

    // Поле ввода даты когда привезти самокат
    private final By startRentDateField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/input");

    // Поле выбора срока аренды
    private final By rentDurationField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/div[1]");

    // Поле выбора цвета самоката
    private final By scouterColorField = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[3]");

    //Поле комменатрий
    private final By commentForCourier = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/input");

    //Кнопка Закать
    private  final By orderButtonOnOrderPage = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");

    //Кнопка Да на форме подтверждения заказа
    private final By yesOrderButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]");

    //Метод заполнения поля Имя
    public OrderPage writeNameOnNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
        return this;
    }

    //Метод заполнения поля Фамилия
    public OrderPage writeSurnameOnSurnameField(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
        return this;
    }

    //Метод заполнения адреса
    public OrderPage writeAddressOnAddressField(String address) {
        driver.findElement(addressField).sendKeys(address);
        return this;
    }

    //Метод  выбора станции Станции метро
    public OrderPage chooseMetroStation(String MetroStation) {
        driver.findElement(metroStationField).sendKeys(MetroStation + Keys.ARROW_DOWN + Keys.ENTER);
        return this;
    }

    //Метод заполнения номер телефона
    public OrderPage writePhoneNumberField(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
        return this;
    }

    //Метод который нажимает на кнопку далее
    public OrderPage clickOnNextButtonForNextOrderPage() {
        driver.findElement(nextButton).click();
        return this;
    }

    //Метод ввода даты
    public OrderPage writeOrderDate(String orderDate) {
        driver.findElement(startRentDateField).sendKeys(orderDate + Keys.ENTER );
        return this;
    }

    //Метод выбора срока аренды
    public OrderPage chooseDurationOfOrder(String rentalPeriod) {
        driver.findElement(rentDurationField).click();
        String xpathRentalPeriodDropDown = "//div[@class ='Dropdown-option' and text()='%s']";
        driver.findElement(By.xpath(String.format(xpathRentalPeriodDropDown, rentalPeriod))).click();
        return this;
    }
    //Метод кликает по чекбоксу цвета
    public OrderPage chooseColourOfScooter (String scooterColour) {
        String xpathColorScooter ="//*[text() = '%s']/input";
        driver.findElement(By.xpath(String.format(xpathColorScooter, scooterColour))).click();
        return this;
    }

    //Метод записи комментария курьеру
    public OrderPage writeCommentForDeliveryMan(String orderComment) {
        driver.findElement(commentForCourier).sendKeys(orderComment);
        return this;
    }

    //Метод клика на итоговую кнопку заказать в конце оформления заказа
    public OrderPage  clickOnFinalOrderButton() {
        driver.findElement(orderButtonOnOrderPage).click();
        driver.findElement(yesOrderButton).click();
        return this;
    }

    //Метод получения информации о успешном заказе
    public boolean getInformationAboutOrder() {

        return driver.findElement(successOrderText).isDisplayed();
    }

    public OrderPage fillOrderForScooter(OrderForm orderForm) {
        writeNameOnNameField(orderForm.getName());
        writeSurnameOnSurnameField(orderForm.getSurname());
        writeAddressOnAddressField(orderForm.getAddress());
        chooseMetroStation(orderForm.getMetroStation());
        writePhoneNumberField(orderForm.getPhoneNumber());
        clickOnNextButtonForNextOrderPage();
        writeOrderDate(orderForm.getOrderDate());
        chooseDurationOfOrder(orderForm.getRentalPeriod());
        chooseColourOfScooter(orderForm.getScooterColour());
        writeCommentForDeliveryMan(orderForm.getOrderComment());
        return this;
    }






}
