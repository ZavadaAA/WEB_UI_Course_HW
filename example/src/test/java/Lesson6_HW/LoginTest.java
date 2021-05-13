package Lesson6_HW;


import Lesson6_HW.pages.BaseView;
import Lesson6_HW.pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static Lesson6_HW.Configuration.LOGIN;
import static Lesson6_HW.Configuration.PASSWORD;

public class LoginTest extends BaseView {

    public LoginTest(WebDriver driver) {
        super(driver);
    }

    @Test
    public void positiveLoginTest() {
        new LoginPage(driver)
                .fillInputLogin(LOGIN)
                .fillInputPassword(PASSWORD)
                .submitLogin();
    }


   // @Test
   // public void emptyFieldsTest(){
   //     new LoginPage(driver)
   //             .checkFalse();
   // }
//
   // @Test
   // public void emptyLoginTest(){
   //     new LoginPage(driver)
   //             .fillInputPassword("asdfg")
   //             .checkFalse();
   // }
//
   // @Test
   // public void emptyPasswordTest(){
   //     new LoginPage(driver)
   //             .fillInputLogin("qwerty")
    //            .checkFalse();
   // }
//
   // @Test
   // public void wrongLoginTest(){
   //     new LoginPage(driver)
   //             .fillInputLogin("qwerty")
   //             .fillInputPassword(PASSWORD)
   //             .checkFalse();
   // }
//
   // @Test
   // public void wrongPasswordTest()//
}

