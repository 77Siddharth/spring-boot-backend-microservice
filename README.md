# spring-boot-backend-microservice

A Simple app microservice backend built having - load balancing , Gateway feature , tracing all request paths to understand the point of failure displaying processing time for each service per request.

TechStack -> 
Spring Boot, JPA ,DOCKER,
EUREKA ( Name Server),
FEIGN ( for connecting different micro services )  ,
ZIPKIN ,OPEN TELEMETRY ,Micrometer ( tracing , assigning ID to each request and anaylsing)

FLOW ====> GATEWAY-> CURRENCY CONVERSION SERVICE -> CURRENCY EXCHANGE SERVICE
Sequence of starting --> Name server -> Exchange service -> conversion service 
No sequence of starting these->  Gateway service , Tracing server

EXCHANGE SERVICE
http://localhost:8000/currency-exchange/from/USD/to/INR
![image](https://user-images.githubusercontent.com/30522963/232289463-03313b34-3cb5-441c-89a5-fc9a9f193afe.png)

CONVERSION SERVICE
http://localhost:8100/currency-conversion-feign/from/USD/to/INR/quantity/10
![image](https://user-images.githubusercontent.com/30522963/232289467-1c0859da-44cc-4a7b-a183-c5e2dc3ac409.png)

GATEWAY SERVICE
http://localhost:8765/currency-conversion-feign/from/USD/to/INR/quantity/10
![image](https://user-images.githubusercontent.com/30522963/232289505-071a076c-daad-40b5-895c-e42701bf5d6d.png)

NAME SERVER - EUREKA
http://localhost:8761/
![image](https://user-images.githubusercontent.com/30522963/232289528-b270e452-a7f4-4795-9a47-fafade90c05d.png)

ZIPKIN -  Distributed Tracing Server
http://127.0.0.1:9411/zipkin
![image](https://user-images.githubusercontent.com/30522963/232289554-cacb71ba-39a4-4596-8aa7-25d0e6c72a6c.png)


![image](https://user-images.githubusercontent.com/30522963/232290163-a5c0ae0e-df49-43cb-b95b-95ddb298a336.png)
