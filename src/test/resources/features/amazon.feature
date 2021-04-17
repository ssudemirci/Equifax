Feature: End to End Functional Test
  As I user, I should be able to buy item on amazon page


  Background:
    Given I visit amazon.com page

  Scenario: Search Result Price and Add to Card price verification
    When I search  a "qa testing for beginners"
    And I click on "1"  item on the listed results.
    Then Add to Card  item price  should the same with  Search Result Price


  Scenario: Search Result Price and Proceed to Checkout price verification
    When I search  a "qa testing for beginners"
    And I click on "1"  item on the listed results.
    And I click on Add to Cart
    Then Proceed to Checkout price should the same with Search Result Price

  @wip
  Scenario Outline: End to End Functional Test
    When I search  a "<item>"
    And I click on "<place>"  item on the listed results.
    And I click on Add to Cart
    And I click on Proceed to checkout
    Then I verifies that page title is "<title>"

    Examples:
      | item                     | place | title          |
      | qa testing for beginners | 1     | Amazon Sign-In |








