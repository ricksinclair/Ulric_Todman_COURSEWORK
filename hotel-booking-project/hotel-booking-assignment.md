# Hotel Booking Service

Time to complete: 90 minutes

### Objective:

1. Create a hotel and rewards points calculation service for a given hotel room.
2. This microservice must use the Room and Rewards services.
3. This microservice must have adequate unit and integration tests.
4. This microservice must include exception handling.

### Infrastructure (Supplied)

You will be supplied the following services to help complete your project. Each service includes a README file with instructions for running the service and documentation of the API:

* Eureka Service Registry
* Room Service
* Rewards Service

### Hotel Booking Service Requirements (You Implement)

Your service will calculate the cost of a hotel room, and any rewards points for a given hotel room. The calculation will take the following into account:

* Whether the customer is a rewards member
* Whether the room is discount eligible
* Whether today is a Double Bonus Day
* Whether the room can have its rewards points doubled

Notes:
* If ```doubleBonusDay``` is true and ```canDouble``` is true on the room, ```totalRewardsPoints``` is ```baseRewardsPoints * 2```.
* If ```rewardsMember``` is false, ```totalRewardPoints``` is 0.
* If ```rewardsMember``` is true, ```finalCost``` is ```baseRate * (1 - memberDiscount)```

#### API

* URL: /hotelRewards/{roomId}?rewardsMember=[true|false]&doubleBonusDay=[true|false]
* HTTP Method: GET
* RequestBody: None
* ResponseBody: Room rate and rewards (JSON - see below)

#### Response Format

```javascript
{
   "roomId":"237",
   "rewardsMember":"true",
   "doubleBonusDay":"true",
   "baseRate":"200.00",
   "memberDiscount":".10",
   "baseRewardsPoints":"2100",
   "canDouble":"true",
   "finalCost":"180.00"
   "totalRewardsPoints":"4200"
}
```

