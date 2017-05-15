

# TWITTER


To build the project you will need Maven installed (https://maven.apache.org/).

Clone the repository, then in the root directory (where the pom.xml is located) run 
```
	./mvnw spring-boot:run
```

Simpler way is to download the .jar file ```twitter-1.0.jar ``` (https://drive.google.com/file/d/0B-sQfCIWQJaOMC12LXQ3c01rQlk/view?usp=sharing) and invoke   
```java -jar <PATH TO DOWNLOADED JAR>```

Twitter should be now accessible under ```http://localhost:8080/>```

API Guide:

1. Registering a new user is bound together with posting the first message.

Send POST request to http://localhost:8080/users/new/tweets/ Sample Body looks like that:
```
{  
   "username":"michal",
   "firstTweet":{  
      "message":"This is my first twit!"
   }
}
```

The response will contain a json object with the id of the newly created user:
```
{
  "id": 1,
  "username": "michal"
}
```

2. Once you have your user created, you can freely add new tweets by sending a POST request to http://localhost:8080/users/<ID>/tweets/ , where <ID> is the ID of your user. The sample body looks like that:
```
{  
   "message":"second tweet!"
}
```
The response will contain details of the new tweet:
```
 {
  "id": 2,
  "message": "second tweet!",
  "authorId": 1,
  "dateAdded": "2017-05-15 14:44:28"
}

```

3. You can also see your Wall - a list of all your Tweets in a reverse chronological order. Send a GET request to http://localhost:8080/users/1/tweets/ 
The response will look like this:
```
[
  {
    "id": 2,
    "message": "second tweet!",
    "authorId": 1,
    "dateAdded": "2017-05-15 14:44:28"
  },
  {
    "id": 1,
    "message": "This is my first twit!",
    "authorId": 1,
    "dateAdded": "2017-05-15 14:41:45"
  }
]
```
4. To get a list of all users in the system, send a GET request to http://localhost:8080/users/?query=ma
The ```query``` parameter is optional, when provided - the filter ``` username like %query%``` will be applied. Otherwise, unfiltered list will be returned

5. To follow a user sent a POST request to http://localhost:8080/users/1/followees/ with a json body containing the ```followeeId``` property, like:
```
{
    "followeeId":"2"
}
```
6. To stop following a user send a DELETE request to http://localhost:8080/users/1/followees/<FOLLOWEE ID>
7. To view a Timeline (a list of all tweets created by the people you follow in a reverse chronological order) send a GET request to 

```http://localhost:8080/users/1/feed/```




