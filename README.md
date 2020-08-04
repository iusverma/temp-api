# temp-api
This is for testing reading different dynamic configuration via yaml

# Purpose
* Same type of configuration are read from different config file e.g. name & code are read from application-COUNTRYCODE.yaml and application-LANGUAGE.yaml. After reading a completed list of information is returned to client.
* If client has not added any thing in request, all data is returned. Empty request is {} or [] or [{}]
* If client has requested for any specific generic, data for same generic willbe returned.

# How to run
* Clone the code and run mvn clean install
* mvn spring-boot:run

# URL
http://localhost:8085/api/generics
