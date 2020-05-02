# MowItNow
Program made for a job interview at ***Publicis Sapient Engineering***

## Run the project

First, create inputs.txt file wherever you want. You can put the following content in it:
```
5 5
1 2 N
GAGAGAGAA
3 3 E
AADAADADDA
```

then run the following command:
```
mvn clean compile assembly:single
```

Go to the target folder and run the generated jar. Don't forget to give the inputs file as first argument.
```
java -jar MowItNow.jar C:\inputs.txt
```

## Run the tests
```
mvn test
```