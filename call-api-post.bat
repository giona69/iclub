curl -X POST -H "Content-Type: application/json" -d "{"deleted": false,"id": "","mainrepo": false,"namespace": "test","nomedb": "manualdb","project": "manual"}" http://localhost:8080/_ah/api/databaseApi/v1/database
curl -X POST -H "Content-Type: application/json" -d '{}' http://localhost:8080/_ah/api/databaseApi/v1/database

curl -X POST -H "Content-Type: application/json" -d "" http://localhost:8080/_ah/api/myApi/v1/sayHi/giona
curl -X POST -H "Content-Type: application/json" -d "" https://river-inquiry-861.appspot.com/_ah/api/myApi/v1/sayHi/giona
curl -X POST -H "Content-Type: application/json" -d "" https://image-recognition-giona69-it.appspot.com/_ah/api/myApi/v1/sayHi/giona