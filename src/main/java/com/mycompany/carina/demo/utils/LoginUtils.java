package com.mycompany.carina.demo.utils;
import com.mycompany.carina.mydemo.uitest.pages.HomePage;
import com.mycompany.carina.mydemo.uitest.pages.LoginPage;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;


public class LoginUtils implements ICustomTypePageFactory {

    public HomePage login(String username, String password){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        return loginPage.clickLoginButton();
    }

    public HomePage loginAsStandardUser(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeUsername(R.TESTDATA.get("user"));
        loginPage.typePassword(R.TESTDATA.get("password"));
        return loginPage.clickLoginButton();
    }
}
