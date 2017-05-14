

# TWITTER


To run the project from the source code, you will need to have Maven installed (https://maven.apache.org/).

Clone the repository, then in the root directory (where the pom.xml is located) run 
```
	./mvnw spring-boot:run
```

Simpler way is to download the prepared .jar file ```twitter-1.0-SNAPSHOT.jar ``` and invoke   
```java -jar <PATH TO DOWNLOADED JAR>```

Twitter should be now accessible under ```http://localhost:8080/>```

API Guide:

1. Registering a new user is binded together with posting the first message.

Send POST request to ``` http://localhost:8080/users/new/twits/``` Sample Body looks like that:
```
{
	"username":"michal",
	"firstTwit":
			{
			"message": "This is my first twit"
			}	
    }
```

In a Response you should receive a json object with the id of a newly created user:
```
{
  "id": 1,
  "username": "michal"
}
```

2. Once you have your user created, you can freely add new twits by sending a POST request to ```http://localhost:8080/users/<ID>/twits/ ```, where <ID> is the ID of your user. The sample body looks like that:
```
{
	"message": "Second Twit"
}
```
In the Response, you should receive the details of the new twit:
```
{
  "id": 2,
  "message": "Second Twit",
  "authorId": 1,
  "dateAdded": 1494770752104
}

```

3. You can also see your Wall - a list of all your Twits in a reverse chronological order. Send a GET request to ```http://localhost:8080/users/1/twits/```  
The Response should be similar to:
```
[
  {
    "id": 2,
    "message": "Second Twit",
    "authorId": 1,
    "dateAdded": 1494770752104
  },
  {
    "id": 1,
    "message": "This is my first twit",
    "authorId": 1,
    "dateAdded": 1494770746407
  }
]
```
4. To get a list of all users in the system, send a GET request to ```http://localhost:8080/users/?query=ma```
The ```query``` parameter is optional, when provided - the filter ``` username like %query%``` will be applied. Otherwise, unfiltered list will be returned

5. To follow a user sent a POST request to http://localhost:8080/users/1/followees/ with a json body containing the ```followeeId``` property, like:
```
{
	"followeeId":"2"
}
```
6. To stop following a user send a DELETE request to ```http://localhost:8080/users/1/followees/<FOLLOWEE ID>```
7. To view a Timeline (a list of all twits created by the people you follow in a reverse chronological order) send a GET request to 

```http://localhost:8080/users/1/feed/```




