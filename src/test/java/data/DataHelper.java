package data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;
import java.util.Random;

public class DataHelper {
    public static final Faker faker = new Faker(new Locale("en"));

    private DataHelper() {
    }

    public static AuthInfo getAuthInfowithTestData() {

        return new AuthInfo("vasya", "qwerty123");
    }

    public static String generateRandomLogin() {
        return faker.name().username();
    }

    public static String generateRandomPassword() {
        return faker.internet().password();
    }

    public static AuthInfo generateRandonUser() {
        return new AuthInfo(generateRandomLogin(), generateRandomPassword());
    }




    public static class VerificationCode {
        String code;

        public VerificationCode(String value) {
            code = value;
        }

        public String getCode() {
            return code;
        }

    }


    public static class CardInfo {
        String cardNumber;
        String testId;

        public CardInfo(String cardNumberValue, String testIdValue) {
            cardNumber = cardNumberValue;
            testId = testIdValue;
        }

        public String getCardNumber() {
            return cardNumber;
        }

        public String getTestId() {
            return testId;
        }

    }


    public static class AuthInfo {
        String login;
        String password;

        public AuthInfo(String loginValue, String passwordValue) {
            login = loginValue;
            password = passwordValue;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }
    }
}