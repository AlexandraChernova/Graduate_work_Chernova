package test;


import com.codeborne.selenide.logevents.SelenideLogger;
import data.DataHelper;
import data.SQLHelper;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.OptionSelection;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

    public class MakingPaymentTest {
        @BeforeAll
        static void setUpAll() {

            SelenideLogger.addListener("allure", new AllureSelenide());
        }

        @BeforeEach
        void setUp() {
            String appUrl = System.getProperty("app.url");
            open(appUrl);
        }

        @AfterAll
        static void tearDownAll() {

            SelenideLogger.removeListener("allure");
        }

        @Test
        void shouldSuccessWithValidDebitCard() {
            val optionSelection = new OptionSelection();
            val makingPayment = optionSelection.buyByDebitCard();
            val validCardInformation = DataHelper.getAuthInfoUseTestData();
            makingPayment.fillingInThePayersData(validCardInformation);
            makingPayment.checkPaymentSuccess();
            val paymentId = SQLHelper.getPaymentId();
            val statusForPaymentByDebitCard = SQLHelper.getPaymentStatusByDebitCard(paymentId);
            val paymentAmount = SQLHelper.getPaymentAmount(paymentId);
            assertEquals("APPROVED", statusForPaymentByDebitCard);
            assertEquals("45000", paymentAmount);

        }
}
