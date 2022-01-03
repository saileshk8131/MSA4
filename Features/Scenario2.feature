#Author: Kasetty.Sailesh@mindtree.com

Feature: Gillete

  Scenario Outline: Search
    Given Go to gillete website1
    Then Click on search icon
    Then Pass text as "<text>"
    Then Verify the text Results For Razor appears at top of the search results

    Examples: 
      |text  | 
      |Razor |
