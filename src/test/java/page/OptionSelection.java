package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OptionSelection {
    // @FindBy(xpath = "//*[@id="root"]/div/form/fieldset/div[1]/span/span/span[2]/input");
    // private SelenideElement cardNumber;
    // @FindBy(xpath = "//*[@id="root"]/div/form/fieldset/div[2]/span/span[1]/span/span/span[2]/input");
    // private SelenideElement month;
    //@FindBy(xpath = "//*[@id="root"]/div/form/fieldset/div[2]/span/span[2]/span/span/span[2]/input");
    // private SelenideElement year;
    //@FindBy(xpath = "//*[@id="root"]/div/form/fieldset/div[3]/span/span[1]/span/span/span[2]/input");
    // private SelenideElement owner;
    //@FindBy(xpath = "//*[@id=\"root\"]/div/form/fieldset/div[3]/span/span[2]/span/span/span[2]/input");
    // private SelenideElement cvc;
    // @FindBy(xpath = "//*[@id=\"root\"]/div/form/fieldset/div[4]/button");
    //private SelenideElement continueButton;
    //@FindBy(xpath = "//div[@class='notification__content'][text()='Операция одобрена Банком.']");
    //private SelenideElement successfulNotification;
    //@FindBy(xpath = "//div[@class='notification__content'][text()='Ошибка! Банк отказал в проведении операции.']");
    // private SelenideElement errorNotification;

    // public void verifyErrorNotificationVisibility() {
    //      errorNotification.shouldBe(Condition.visible);
    // }

    //  public MakingPayment orderCreation(DataHelper.ApplicationProcessing data) {
    //  cardNumber.setValue(data.getCardNumber());
    //month.setValue(data.getMonth());
    //year.setValue(data.getYear());
    //owner.setValue(data.getOwner());
    // cvc.setValue(data.getCvc());
    //continueButton.click();
    //return MakingPayment.this;
    // }

    private SelenideElement debitPayment = $$(".button").find(exactText("Купить"));
    private SelenideElement creditPayment = $$(".button").find(exactText("Купить в кредит"));
    private SelenideElement kindOfPayment = $("#root > div > h3");

    public MakingPayment buyByDebitCard() {
        debitPayment.click();
        kindOfPayment.shouldHave(exactText("Оплата по карте"));
        return new MakingPayment();
    }

    public MakingPayment buyByCreditCard() {
        creditPayment.click();
        kindOfPayment.shouldHave(exactText("Кредит по данным карты"));
        return new MakingPayment();
    }
}


