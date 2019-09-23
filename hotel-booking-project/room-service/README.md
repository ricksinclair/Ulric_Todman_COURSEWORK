# Room Service

This microservice provides information about each hotel room.

* ```/room/{roomNumber}``` (GET) returns information about a hotel with number ```roomNumber```
* ```/room``` (GET) retrieves a list of all hotel rooms

To run this service, type the following command in the project directory:

```./gradlew clean build bootRun```

The service runs on port 8234.