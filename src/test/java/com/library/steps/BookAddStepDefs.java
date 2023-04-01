package com.library.steps;

import com.library.pages.BookPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import com.library.utility.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.Map;

public class BookAddStepDefs {

    BookPage bookPage= new BookPage();
    @When("the librarian click to add book")
    public void theLibrarianClickToAddBook() {
        BrowserUtil.waitFor(3);
        bookPage.addBook.click();
        BrowserUtil.waitFor(3);
    }

    @And("the librarian enter {string} {string}")
    public void theLibrarianEnter(String infoBox, String information) {
        Driver.getDriver().findElement(By.xpath("//input[@placeholder='"+infoBox+"']")).sendKeys(information);
    }

    @And("the librarian click to save changes")
    public void theLibrarianClickToSaveChanges() {
        bookPage.saveChanges.click();

    }

    @And("the librarian choose the book category {string}")
    public void theLibrarianChooseTheBookCategory(String category) {
        BrowserUtil.selectOptionDropdown(bookPage.categoryDropdown, category);
    }

    @Then("verify {string} message is displayed")
    public void verifyMessageIsDisplayed(String expectedMessage) {
        String actualMessage = bookPage.toastMessage.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
        BrowserUtil.waitFor(5);
    }

    @And("verify {string} information must match with DB")
    public void verifyInformationMustMatchWithDB(String actualBookName) {

        bookPage.search.sendKeys(actualBookName + Keys.ENTER );

        BrowserUtil.waitFor(3);

        String actualAuthorName = bookPage.author.getAttribute("value");
        String actualISBN = bookPage.isbn.getAttribute("value");
        String actualYear = bookPage.year.getAttribute("value");

        String query="select * from books\n" +
                "where name='"+actualBookName+"'";
        DB_Util.runQuery(query);
        Map<String, String> bookInfo = DB_Util.getRowMap(1);
        System.out.println("bookInfo = " + bookInfo);

        String expectedBookName = bookInfo.get("name");
        String expectedISBN = bookInfo.get("isbn");
        String expectedYear = bookInfo.get("year");
        String expectedAuthorName =bookInfo.get("author");

        Assert.assertEquals(actualBookName,expectedBookName);
        Assert.assertEquals(actualAuthorName,expectedAuthorName);
        Assert.assertEquals(actualISBN,expectedISBN);
        Assert.assertEquals(actualYear,expectedYear);
    }

}
