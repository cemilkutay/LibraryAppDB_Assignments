
@B28G51-255
Feature: As a librarian, I want to know borrowed books number
@Nihal @db  @B28G51-254
  Scenario: verify the total amount of borrowed books
    Given the "librarian" on the home page_ND
    When the librarian gets borrowed books number_ND
    Then borrowed books number information must match with DB_ND