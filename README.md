Vaccination Centre Locator
Project to find nearest Covid-19 vaccination centre is designed on REST API and Spring Boot Framework.
Following are the steps to run the project on your local system
•	Clone the project from the GIT and switch to main branch
•	Import the project as Maven in your IDE
•	Run command mvn –clean compile install to download and configure all the dependencies
•	Run the application with VM args as: -Dserver.port=8088
URL to test if the application is up and running: http://localhost:8080/status
URL to get the vaccination centres for Citizens: http://localhost:8080/covid/vaccination/centre-details
HTTP Protocol: POST
Request Body: 
*Please note that key of JSON should be lowercase for the application to work.
Sample Request Body
[
 {  "name": "Sebastian Gerth",
    "age": 47,
    "latitude": "52.53627304145948",
    "longitude": "-6.822509765625001"
  },
  {
    "name": "Sherise Hambly",
    "age": 38,
    "latitude": "53.39090261307827",
    "longitude": "-7.063240487792548"
  },
  {
    "name": "Toni Appleby",
    "age": 45,
    "latitude": "53.89830497300189",
    "longitude": "-8.116737588176672"
  },
  {
    "name": "Clark Ospina",
    "age": 29,
    "latitude": "54.06769454247903",
    "longitude": "-8.66817747665899"
  },
  {
    "name": "Celinda Hamilton",
    "age": 91,
    "latitude": "53.542786433740105",
    "longitude": "-9.585872216446724"
  }
]


