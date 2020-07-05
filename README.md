# Fishdiary

This project is for fishers who want to be able to store their catches in a digital diary.

The thought is that you will be able to insert into a database your fish, picture, coordinates
and other info to be able to keep track of all your catches.

## Technology

* Jakarta EE 9
* Wildfly 20
* JUnit
* Maven

<hr>

## Setting it up

* Install latest [Wildfly](https://wildfly.org/) and then use the CMD to go to the directory.<BR>
Inside wildfly, go to `bin` folder. run the add-user script. What type of user you want is up to you, 
for this project I have a standard root user. <BR> Start the server with following command: `standalone`

* Download the [Postgres](https://jdbc.postgresql.org/download.html) JDBC jar file, and place it under `C:\Users`.<BR>
  Rename it to `postgresql.jar` so the script will work.

* Install [Postgresql](https://www.postgresql.org/download/windows/) and setup a user, create a database named `fishdiary`.
  I have used the username `postgres` with password `root`. Change them in the `fishdiary.cli` if you have other credentials. 
  
* Copy the file `fishdiary.cli` to `wildfly\bin`.<BR>
In the CMD again, write `jboss-cli -c --file=fishdiary.cli` and it will write out success three times.
It will generate the datasource and logging to both file and System.out to Wildfly console.

* Import the project to your IDE, and create a Maven Run configuration.
Use `wildfly:undeploy clean:clean wildfly:deploy` to deploy it to your server.

## JSON bodies and Endpoints

##### Get All Fishes
```
Type: GET
URL: /fishdiary/fish

Response: [
              {
                "id": null,
                "name": "Pike",
                "weight": 12.0,
                "length": 43.0,
                "diaryNumber": 1,
                "diaryOwner": "xxx"
              },
          ]
```
##### Get all Diaries
```
Type: GET
URL: /fishdiary/diary

Response: 
        [
          {
            "id": 1,
            "catches": [
              {
                "id": null,
                "name": "Pike",
                "weight": 7.0,
                "length": 76.0,
                "diaryNumber": null,
                "diaryOwner": null
              },
            ],
            "user": "xxx"
          },
        ]
```
##### Get all users
```
Type: GET
URL: /fishdiary/user

Response: 
        [
          {
            "username": "xxx"
          },
        ]
```
##### Get Diary by name
```
Type: GET
URL: /fishdiary/diary/xxx
"id": null,
  "catches": [
    {
      "id": null,
      "name": "Pike",
      "weight": 12.0,
      "length": 43.0,
      "diaryNumber": null,
      "diaryOwner": null
    },
    {
      "id": null,
      "name": "Squid",
      "weight": 30.0,
      "length": 50.0,
      "diaryNumber": null,
      "diaryOwner": null
    }
  ],
  "user": "xxx"
```
##### Add User
```
Type: POST
URL: /fishdiary/user
Body: {
      	"username":"xxx",
      	"password":"yyy"
      }
```
##### Add Fish
```
Type: POST
URL: /fishdiary/fish
Body: {
      	"name": "xxx",
      	"length": 10,
      	"weight": 14,
      	"username":"xxx"
      }
```
##### Add Diary to User
```
Type: POST
URL: /fishdiary/diary
Body: {
      	"username":"xxx"
      }
```
