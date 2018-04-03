Feature: Math Calculation with Input and Output as XML with method=POST
  Math Calculation for addition, subtraction, multiplication and division with method=POST with XML as Input and Output

  Scenario: Scenario1: Validate Math Operation with expected output Scenario   
    When the client calls POST /math/calc with :      
        | num1  | num2  | operator |
        | 2     |     5 | add      | 
        | 12    |    27 | add      | 
        | 20    |    15 | sub      |
        | 89    |    19 | sub      | 
        | 15    |    10 | mul      | 
        | 30    |    20 | mul      | 
        | 20    |    6  | div      | 
        | 40    |    10 | div      | 
    Then the response has the following attributes:
        | num1  | num2  | operator | result|
        | 2     |     5 | add      | 7		 |
        | 12    |    27 | add      | 39		 |
        | 20    |    15 | sub      | 5		 |
        | 89    |    19 | sub      | 70		 |
        | 15    |    10 | mul      | 150	 |
        | 30    |    20 | mul      | 600	 |
        | 20    |    6  | div      | 3	   |
        | 40    |    10 | div      | 4	   |