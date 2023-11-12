package by.itacademy.pakulnitskaya;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebSiteTest {

    @Test
    public void testOnliner() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://onliner.by");
        String inputAuthButtonXpath = "/html/body/div[1]/div/div/div/header/div[3]/div/div[2]/div[2]/div[1]/div/div/div[1]";
        By inputAuthButtonBy = By.xpath(inputAuthButtonXpath);
        WebElement inputAuthButtonElement = driver.findElement(inputAuthButtonBy);
        inputAuthButtonElement.click();
        String textAuthFormXpath = "/html/body/div[3]/div/div/div/div/div/div/div/div[2]/div/div[1]";
        By textAuthFormBy = By.xpath(textAuthFormXpath);
        Thread.sleep(7000);
        WebElement textAuthFormElement = driver.findElement(textAuthFormBy);
        String actualResult = textAuthFormElement.getText();
        String expectedResult = "Вход";
        Assertions.assertEquals(expectedResult, actualResult);
        driver.quit();

    }

    @Test
    public void testDevby() {
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.navigate().to("https://dev.by");
        String inputAuthButtonXpath = "/html/body/div[2]/header/div[1]/div[3]/a";
        By inputAuthButtonBy = By.xpath(inputAuthButtonXpath);
        WebElement inputAuthButtonElement = driver.findElement(inputAuthButtonBy);
        inputAuthButtonElement.click();
        String textAuthFormXpath = "//*[@id=\"root\"]/div/div/div/div/ul/a[1]";
        By textAuthFormBy = By.xpath(textAuthFormXpath);
        WebElement textAuthFormElement = driver.findElement(textAuthFormBy);
        String actualResult = textAuthFormElement.getText();
        String expectedResult = "Вход";
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testOnlinerMultiple() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://dev.by");

        String enterButtonLocator = "//*[@id=\"userbar\"]/div[1]/div/div/div[1]";
        By enterButtonBy = By.xpath(enterButtonLocator);
        WebElement enterButtonWebElement = driver.findElement(enterButtonBy);
        enterButtonWebElement.click();

        String buttonEnter = "//*[@id=\"auth-container\"]/div/div[2]/div/form/div[3]/button";
        By buttonEnterBy = By.xpath(buttonEnter);
        WebElement buttonEnterWebElement = driver.findElement(buttonEnterBy);
        buttonEnterWebElement.click();

        String errorMassageLogin = "//*[@id=\"auth-container\"]/div/div[2]/div/form/div[1]/div/div[2]/div/div/div[2]/div";
        By errorMassageLoginBy = By.xpath(errorMassageLogin);
        WebElement errorMassageLoginWebElement = driver.findElement(errorMassageLoginBy);
        String actualErrorMassageLogin = errorMassageLoginWebElement.getText();
        String expectedErrorMassageLogin = "Укажите ник или e-mail";
        Assertions.assertEquals(expectedErrorMassageLogin, actualErrorMassageLogin);

        String errorMassagePassword = "//*[@id=\"auth-container\"]/div/div[2]/div/form/div[2]/div/div/div[2]/div";
        By errorMassagePasswordBy = By.xpath(errorMassagePassword);
        WebElement errorMassagePasswordWebElement = driver.findElement(errorMassagePasswordBy);
        String actualErrorMassagePassword = errorMassagePasswordWebElement.getText();
        String expectedErrorMassagePassword = "Укажите пароль";
        Assertions.assertEquals(expectedErrorMassagePassword, actualErrorMassagePassword);


    }

    @Test
    public void testAvBy() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://av.by");

        AvPage avPage = new AvPage();

        WebElement buttonEnter = driver.findElement(By.xpath(avPage.buttonEnterLocator));
        buttonEnter.click();

        WebElement buttonLoginOption = driver.findElement(By.xpath(avPage.buttonLoginOptionLocator));
        buttonLoginOption.click();

        WebElement inputEmail = driver.findElement(By.xpath(avPage.inputEmailLocator));
        inputEmail.sendKeys("test@test");

        WebElement inputPassword = driver.findElement(By.xpath(avPage.inputPasswordLocator));
        inputPassword.sendKeys("test");

        WebElement buttonSubmit = driver.findElement(By.xpath(avPage.buttonSubmitLocator));
        buttonSubmit.click();

        WebElement errorMessage = driver.findElement(By.xpath((avPage.errorMessageLocator)));
        String actualErrorMessage = errorMessage.getText();
        Assertions.assertEquals("Неверный логин или пароль. Если забыли пароль, восстановите его", actualErrorMessage);

    }
}
