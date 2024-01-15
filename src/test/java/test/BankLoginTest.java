package test;

import data.DataHelper;
import data.SQLHelper;
import org.junit.jupiter.api.*;
import page.LoginPage;

import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.open;
import static data.SQLHelper.cleanDatabase;

public class BankLoginTest {
    @AfterAll
    static void teandown() throws SQLException {
        cleanDatabase();
    }

    @Test
    @DisplayName("Shuld successfully login to dashboard with exist login and password from sut test data")
    void shouldSuccessfulLogin() throws SQLException {
        var loginPage = open("http://Localhost:9999", LoginPage.class);
        var authInfo = DataHelper.getAuthInfowithTestData();
        var verificationPage = loginPage.validLogin(authInfo);
        verificationPage.verifycationPageVisiblity();
        var verificationCode = SQLHelper.getVerificationCode();
        verificationPage.validVerify(verificationCode.getCode());
    }

}