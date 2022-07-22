mvn clean install && mvn spring-boot:run -pl web

curl -XPOST -H'Content-Type:application/json' -d '{"amount":2}' http://localhost:8080/payment

