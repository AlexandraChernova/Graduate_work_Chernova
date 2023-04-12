package data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;

public class DataHelper {
    private static Faker faker = new Faker(new Locale("en"));

    @Value
    public static class applicationProcessing {
        private String cardNumber;
        private String month;
        private String year;
        private String owner;
        private String cvc;
    }

    private DataHelper() {
    }

    public static ApplicationProcessing getOwnersName() {
        return faker.name().fullName();
    }

    public static String generateCvc() {
        return faker.numerify("###");
    }

    public static String validCardNumber(){
        return "4444 4444 44444 4441";
    }
}
