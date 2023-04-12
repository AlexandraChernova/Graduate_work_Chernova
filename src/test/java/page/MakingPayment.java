package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;
import org.openqa.selenium.support.FindBy;

public class MakingPayment {
    @FindBy(xpath = "//*[@id="root"]/div/form/fieldset/div[1]/span/span/span[2]/input");
    private SelenideElement cardNumber;
    @FindBy(xpath = "//*[@id="root"]/div/form/fieldset/div[2]/span/span[1]/span/span/span[2]/input");
    private SelenideElement month;
    @FindBy(xpath = "//*[@id="root"]/div/form/fieldset/div[2]/span/span[2]/span/span/span[2]/input");
    private SelenideElement year;
    @FindBy(xpath = "//*[@id="root"]/div/form/fieldset/div[3]/span/span[1]/span/span/span[2]/input");
    private SelenideElement owner;
    @FindBy(xpath = "//*[@id=\"root\"]/div/form/fieldset/div[3]/span/span[2]/span/span/span[2]/input");
    private SelenideElement cvc;
    @FindBy(xpath = "//*[@id=\"root\"]/div/form/fieldset/div[4]/button");
    private SelenideElement continueButton;
    @FindBy(xpath = "//div[@class='notification__content'][text()='Операция одобрена Банком.']");
    private SelenideElement successfulNotification;
    @FindBy(xpath = "//div[@class='notification__content'][text()='Ошибка! Банк отказал в проведении операции.']");
    private SelenideElement errorNotification;

    public void verifyErrorNotificationVisibility() {
        errorNotification.shouldBe(Condition.visible);
    }

    public MakingPayment orderCreation(DataHelper.applicationProcessing data) {
        cardNumber.setValue(data.getCardNumber());
        month.setValue(data.getMonth());
        year.setValue(data.getYear());
        owner.setValue(data.getOwner());
        cvc.setValue(data.getCvc());
        continueButton.click();
        return MakingPayment.this;
    }
}
