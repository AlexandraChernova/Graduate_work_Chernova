package data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;
import java.util.Random;

public class DataHelper {
    private static Faker faker = new Faker(new Locale("en"));
    static Random random = new Random();

    @Value
    public static class ApplicationProcessing {
        private String cardNumber;
        private String month;
        private String year;
        private String owner;
        private String cvc;
    }

    private DataHelper() {
    }

    public static ApplicationProcessing getAuthInfoUseTestData() {

        return new ApplicationProcessing("4444 4444 4444 4441", "08", "25", "ALEXANDRA IVANOVA", "987");
    }

    public static int getCardMonth() {
       int month = 1 + random.nextInt(10-1);
       return month;
    }

    public static int getInvalidCardMonth() {
        int invalidMonth = 2 + random.nextInt(10-1);
        return invalidMonth;
    }

    public static int getCardYear() {
        int year = 23 + random.nextInt(10-1);
        return year;
    }

    public static int getInvalidYear(){
        int invalidYear = 3 + random.nextInt(9);
        return invalidYear;
    }

    public static String getOwnersName(){
        return faker.name().fullName();
    }

    public static String generateCvc() {

        return faker.numerify("###");
    }

    public static String approvedCardNumber() {
        return "4444 4444 44444 4441";
    }

    public static String declinedCardNumber() {
        return "4444 4444 44444 4442";
    }


}
