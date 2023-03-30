package com.library.steps;


import com.library.pages.BorrowedBooksPage;
import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

    public class BorrowedBookStepDefs_YO {

        LoginPage loginPage = new LoginPage();
        BorrowedBooksPage borrowedBooksPage = new BorrowedBooksPage();
        DashBoardPage dashBoardPage = new DashBoardPage();
        String actualBorrowedBookNumber;
        @Given("the {string} on the home page_YO")
        public void the_on_the_home_page(String librarian) {
            BrowserUtil.waitFor(2);
            loginPage.login(librarian);
            BrowserUtil.waitFor(2);
        }
        @When("the librarian gets borrowed books number_YO")
        public void the_librarian_gets_borrowed_books_number() {
            BrowserUtil.waitFor(2);
            actualBorrowedBookNumber = dashBoardPage.borrowedBooksNumber.getText();
            System.out.println("actualBorrowedBookNumber = " + actualBorrowedBookNumber);
            BrowserUtil.waitFor(2);

        }
        @Then("borrowed books number information must match with DB_YO")
        public void borrowed_books_number_information_must_match_with_db() {
            BrowserUtil.waitFor(2);
            DB_Util.runQuery("select count(*) from book_borrow\n" +
                    "where is_returned=0");
            String expectedBorrowedBookNumber = DB_Util.getFirstRowFirstColumn();
            System.out.println("expectedBorrowedBookNumber = " + expectedBorrowedBookNumber);
            Assert.assertEquals(actualBorrowedBookNumber,expectedBorrowedBookNumber);

            BrowserUtil.waitFor(2);


        }
}
