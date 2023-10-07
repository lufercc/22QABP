Feature: Api testing
  @bug
  Scenario: api
    ## The first name email and last name was not updated successfully in the rest application under test, this test fails because there is an bug
    Given url 'https://petstore.swagger.io/v2/user'
    And request {"id": 0, "username": "usert987","firstName": "Joan","lastName": "Smith","email": "jsmith@mail.com","password": "Strong*123","phone": "5579629","userStatus": 0}
    When method post
    And status 200
    And url 'https://petstore.swagger.io/v2/user/usert987'
    And method get
    And status 200
    And match response.username == 'usert987'
    And url 'https://petstore.swagger.io/v2/user/usert987'
    Then request {"id": 0, "username": "usert987","firstName": "Jonatan","lastName": "Mity","email": "jmity@mail.com","password": "Strong*123","phone": "5579629","userStatus": 0}
    And method put
    And match response.lastName == 'Mity'
    And match response.firstName == 'Jonatan'
    And match response.email == 'jmity@mail.com'
    And status 200
    And url 'https://petstore.swagger.io/v2/user/usert987'
    And method get
    And status 200
    And match response.lastName == 'Mity'
    And match response.email == 'jmity@mail.com'
    And url 'https://petstore.swagger.io/v2/user/usert987'
    And method delete
    And status 200
