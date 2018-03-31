Feature: Math Calculation for addition, subtraction, multiplication and division with method=GET

Scenario: Scenario1: Validate add operation with the HTTP Status Code
When the client calls GET /math/add/20/10
Then the client receives response status code of 200

Scenario: Scenario2: Validate add operation result with the HTTP Status Code
When the client calls GET "/math/add/30/20 validate result
Then the client receives output of addition operation response status code of 200
And match $ == 50L

Scenario: Scenario3: Validate subtraction operation result with the HTTP Status Code
When the client calls GET "/math/sub/45/15 validate result
Then the client receives output of subtraction operation response status code of 200
And the subtraction result match $ == 30L

Scenario: Scenario4: Validate multiplication operation result with the HTTP Status Code
When the client calls GET "/math/mul/50/12 validate result
Then the client receives output of multiplication operation response status code of 200
And the multiplication result match $ == 600L

Scenario: Scenario5: Validate division operation result with the HTTP Status Code
When the client calls GET "/math/div/90/30 validate result
Then the client receives output of division operation response status code of 200
And the division result match $ == 3L
