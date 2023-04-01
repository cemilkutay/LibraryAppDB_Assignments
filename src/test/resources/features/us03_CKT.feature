@B28G51-266
Feature: As a data consumer, I want UI and DB book categories are match.
  @B28G51-265 @db @ui
  Scenario: verify book categories with DB
    Given the "librarian" on the home page
    When the user navigates to "Books" page
    And the user clicks book categories_CKT
    Then verify book categories must match book_categories table from db_CKT