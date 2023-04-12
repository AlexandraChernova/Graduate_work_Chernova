package page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class OptionSelection {
    @FindBy(xpath = "//button[@class=\"button button_size_m button_theme_alfa-on-white\"]");
    private SelenideElement order;
    @FindBy(xpath = "//*[@id=\"root\"]/div/button[2]");
    private SelenideElement credit;

    public OptionSelection orderTrip(){
        order.click();
        return this;
    }

    private OptionSelection creditTrip(){
        credit.click();
        return this;
    }
}
