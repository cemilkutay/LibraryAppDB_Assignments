package com.library.steps;

import com.library.pages.BookPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class BookCategoriesStepDefs {

    BookPage bookPage = new BookPage();
    List<String> actualCategoryList ;
    @When("the user clicks book categories_CKT")
    public void the_user_clicks_book_categories_ckt() {
        BrowserUtil.waitFor(1);
        bookPage.mainCategoryElement.click();
        BrowserUtil.waitFor(1);
    }

    @Then("verify book categories must match book_categories table from db_CKT")
    public void verify_book_categories_must_match_book_categories_table_from_db_ckt() {
        actualCategoryList = BrowserUtil.getAllSelectOptions(bookPage.mainCategoryElement);
        System.out.println("actualCategoryList = " + actualCategoryList);
        actualCategoryList.remove(0);
        System.out.println("actualCategoryList = " + actualCategoryList);

        DB_Util.runQuery("select name from book_categories");
        List<String> expectedCategoryList = DB_Util.getColumnDataAsList(1);
        System.out.println("expectedCategoryList = " + expectedCategoryList);

        Assert.assertEquals(expectedCategoryList,actualCategoryList);

    }

}
