Feature: Journey Planner Functionality

  Background: User is on the TFL website.
    Given User is on the TFL website homepage

#  Scenario Outline: User is able to verify that a valid journey can be planned successfully using a widget.
#    When User enters "<From>" from destination
#    And User enters "<To>" to destination
#    And User clicks on 'Plan my journey' button
#    Then User is on Journey results page
#    Examples:
#      | From                         | To                          |
#      | Watford Junction             | Edgware Underground Station |
#      | Ealing Broadway              | Southall Broadway           |
#      | Carpenders Park Rail Station | Wembley Central             |

#  Scenario Outline: Verify that the widget is unable to provide results when an invalid journey is planned.
#    When User enters invalid "<From>" from destination
#    And User enters invalid "<To>" to destination
#    And User clicks on 'Plan my journey' button to find the route
#    Then User is getting an "<Error Message>" error message
#    Examples:
#      | From                     | To              | Error Message                                         |
#      | ..//jh                   | 784512          | Sorry, we can't find a journey matching your criteria |
#      | Seven Kings Rail Station | !£..,,12        | Sorry, we can't find a journey matching your criteria |
#      | £$%$                     | North Greenwich | Sorry, we can't find a journey matching your criteria |


#  Scenario Outline: Verify that the widget is unable to plan a journey if no locations are entered into the widget.
#    When User does not put "<From>" from destination
#    And User does not enter "<To>" to destination
#    And User clicks 'Plan my journey' option
#    Then User is not getting any Journey results
#    Examples:
#      | From             | To                               |
#      |                  | Baker Street Underground Station |
#      | Liverpool Street |                                  |
#      |                  |                                  |

  Scenario Outline: Verify that a journey can be amended by using the “Edit Journey” button
    When User enters "<From>" from destination
    And User enters "<To>" to destination
    And User clicks on 'Plan my journey' button
    And User is on Journey results page
    And User clicks on 'Edit Journey' label
    And User change "<Updated_To>" to destination
    And User select 'tomorrow' date from dropdown
    And User clicks on 'Update Journey' button
    Then User is on Journey results page with new "<Updated_To>" to destination
    Examples:
      | From             | To                          | Updated_To      |
      | Watford Junction | Edgware Underground Station | Wembley Central |
