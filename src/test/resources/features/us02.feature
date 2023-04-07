@B28G51-257
Feature: As a librarian, I want to know borrowed books number

 @B28G51-256 @ui @db
  Scenario: verify the total amount of borrowed books
    Given the "librarian" on the home page_YO
    When the librarian gets borrowed books number_YO
    Then borrowed books number information must match with DB_YO


