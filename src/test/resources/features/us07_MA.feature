@us07
Feature: Books module
  As a students, I should be able to borrow book
@ui@db
  Scenario: Student borrow new book
    Given the "student" on the home page
    And the user navigates to "Books" page
    And the user searches for "Self Confidence2" book_MA
    When the user clicks Borrow Book_MA
    Then verify that book is shown in "Borrowing Books" page_MA
    And  verify logged student has same book in database_MA