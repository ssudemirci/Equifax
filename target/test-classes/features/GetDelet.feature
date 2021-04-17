Feature:Get&Delete HTTP request methods


  Scenario Outline: Verification of HTTP request methods.

    Given Request payload
    When User Performs "<method>" HTTP methods with "<id>" a employee
    Then User should see the success status "<code>"
    And  Payload "<body>" value is "<value>"
    Examples:
      | method | id | code | body                 | value                                 |
      | Get    | 1  | 200  | data.employee_name   | Tiger Nixon                           |
      | Get    | 1  | 200  | data.employee_salary | 320800                                |

      | Delete | 1  | 200  | status               | success                               |
      | Delete | 1  | 200  | data                 | 1                                     |
      | Delete | 1  | 200  | message              | Successfully! Record has been deleted |
