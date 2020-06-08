Feature: Rest API Test Invalid

  Scenario: Get Single Emp Info invalid GET Request

    Given baseUrl and invalid resourcePath
    When  Make a invalid GET Call
    Then  I should receive status code 404
