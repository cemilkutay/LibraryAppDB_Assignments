package com.library.steps;

import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.ConfigurationReader;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import com.library.pages.DashBoardPage;

import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import io.cucumber.java.en.Given;

public class BorrowedBkStepDefs_ND {

    String  actualBorrowedBookNumber;
    @Given("the {string} on the home page_ND")
    public void the_on_the_home_page_nd(String librarian) {
        LoginPage loginPage = new LoginPage();

        loginPage.login(librarian);
        BrowserUtil.waitFor(2);

    }
    @When("the librarian gets borrowed books number_ND")
    public void the_librarian_gets_borrowed_books_number_nd() {
        DashBoardPage dashBoardPage = new DashBoardPage();
        BrowserUtil.waitFor(2);
        actualBorrowedBookNumber = dashBoardPage.borrowedBooksNumber.getText();
        BrowserUtil.waitFor(2);


    }
    @Then("borrowed books number information must match with DB_ND")
    public void borrowed_books_number_information_must_match_with_db_nd() {


        String query= "select count(*) from book_borrow\n" +
                "where is_returned=0";

        DB_Util.runQuery(query);

        String expectedBorrowedBookNumber = DB_Util.getFirstRowFirstColumn();
        Assert.assertEquals(actualBorrowedBookNumber,expectedBorrowedBookNumber);
        BrowserUtil.waitFor(2);

    }

}
