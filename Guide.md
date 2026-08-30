### Guide - TODO's

* 1 - Abstract Class -> Audit:
  * Create at
  * Updated at
  * Version
  
###

* 2 - User Types:
    * CLient
    * Owner
  
###

* 3 - CRUD:
    * POST: /users/api/v1/ + RequestBody: UserDTO
    * GET: /users/api/v1/{name}
    * PUT: /users/api/v1/{id}
    * DELETE: /users/api/v1/{id}

###

* 4 - Login + Spring Security: 
  * POST: /users/api/v1/login + RequestBody: userName, Password
  * GET: /users/api/v1/

###

* 5 - Docker:
    * Docker - Multistage Image: 1 - generate Artifact: jar | 2 - execute application
    * Put the JSON file at projectRoot directory

###

* 6 - New Password:
  * UPDATE: /users/api/v1/newpassword + RequestBody: userName, newPassword, passwordConfirmation

###

* 7 - Swagger doc:
  * At least one successful case for each endpoint
  * At least one fail case for each endpoint

###

* 8 - Collections for POSTMAN Tests:
  * Export the collections into a JSON file
  * Put the JSON file at projectRoot directory

###

* 9 - Unit Tests
  * controller
  * domain
  * service

###

* 10 - Relatório Técnico
  * PDF - Estrutura no google Drive



