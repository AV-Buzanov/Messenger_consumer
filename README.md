### Messenger consumer
Приложение слушает очередь и в случае появления сообщения отправляет его в H2 in memory базу данных.
Просмотр содержимого базы данных доступен по адресу http://localhost:8080/h2-console/

## Commands to build project
```
mvn clean
mvn install
```
## Commands to start application
```
java -jar 
```

## Стек технологий

* Java 1.8
* Maven 3.6.0 
* Spring Boot 2.2.2.RELEASE
