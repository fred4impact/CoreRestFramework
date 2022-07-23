Feature: Adding users to Core Mock API

@PostRequestTest
Scenario Outline: Verify users can Add records to Rest API endpoint
  Given The API url is set with payload "<name>" "<quantity>" "<brand>" "<category>"
  When I send "POST" request to "PostProducts" endpoint
  Then I receive success response with status code <code>
  And Verify id of data created equals to "<name>" using "GetProducts"

Examples:
  | name          | quantity | brand | category | code |
  | Voxwagen Golf | 5        | VW    | Car      | 201  |


  @DeleteProduct
Scenario: Verify product can be deleted
  Given The API url is set
  When I send "DELETE" request to "DeleteProduct" endpoint
  Then I receive success response with status code 200





