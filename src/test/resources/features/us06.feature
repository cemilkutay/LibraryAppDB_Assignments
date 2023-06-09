@B28G51-268
Feature: Books module
  As a librarian, I should be able to add new book into library

  @ui @db @B28G51-267
  Scenario Outline: Verify added book is matching with DB
    Given the "librarian" on the home page
    And the user navigates to "Books" page
    When the librarian click to add book
    And the librarian enter "Book Name" "<Book Name>"
    And the librarian enter "ISBN" "<ISBN>"
    And the librarian enter "Year" "<Year>"
    And the librarian enter "Author" "<Author>"
    And the librarian choose the book category "<Book Category>"
    And the librarian click to save changes
    Then verify "The book has been created." message is displayed
    And verify "<Book Name>" information must match with DB

    Examples:
      | Book Name               | ISBN     | Year | Author          | Book Category        |
      | Clean Code 1            | 09112021 | 2021 | Robert C.Martin | Drama                |
      | Head First Java 1       | 10112021 | 2021 | Kathy Sierra    | Action and Adventure |
      | The Scrum Field Guide 1 | 11112021 | 2006 | Mitch Lacey     | Short Story          |