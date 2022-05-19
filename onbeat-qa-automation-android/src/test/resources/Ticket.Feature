Feature: Ticket search scenarios

  Scenario Outline: Search invalid ticket
    Given I am on ticket search page
    When I enter ticket number as "<ticket>"
    And I tap next
    Then Search should fail with error message "<err>"
    Examples:
    | ticket | err|
    | invalid_ticket | Please enter valid ticket number to continue  |

  Scenario Outline: Search valid ticket
    Given I am on ticket search page
    When I enter ticket number as "<ticket>"
    And I tap next
    Then I should see register screen with title "<title>"
    Examples:
      | ticket | title|
      | test@0004 | Register or Login  |