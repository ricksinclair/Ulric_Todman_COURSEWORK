# Rewards Service

This microservice provides information related to rewards information for a given room type.

* ```/rewards/type/{roomType}``` (GET) returns rewards information for a type of room.
* ```/rewards``` (GET) retrieves a list of rewards information for all room types

To run this service, type the following command in the project directory:

```./gradlew clean build bootRun```

The service runs on port 8235.