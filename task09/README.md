# pjatk-tpo-tasks/task09

Dziewiąte zadanie laboratoryjne z przedmiotu TPO.

## Otwieranie

Po sklonowaniu repozytorium, projekt należy otworzyć (lub zaimportować) w IDE własnego wyboru.

## Licencja

Kod źródłowy jest objęty linencją MIT. Treść licencji jest dostępna w pliku [LICENSE.md](../LICENSE.md).

---

## Treść zadania

Write a solution based on Java Messaging Service technology composed of two types of parties:

- 10 requestor threads run in a pool sending requests;
- 5 service threads run in a pool responsible for processing the received requests.

Your solution should support the following scenario:

1. Requestor prepares the body of request message.
2. Requestor puts a request message into a JMS destination and awaits result of processing.
3. An idle service retrieves the request message from the JMS destination.
4. Service processes the request – processing should take a random amount of time between 3 and 5 seconds.
5. Service puts the response message into a JMS destination.
6. Requestor retrieves the message from JMS destination and consumes the result. Please note that requestor should consume only the response of the request it has put in step (2).

All the above steps should be logged with standard Java logger – each log entry should be a single line of the following format: `hh:mm:ss.SSS    <participant>: <log-message>`.

A sample log message could look as follows:

```
12:31:34.678    REQUESTOR-1: request put into destination
```

Your application should support two different types of requests:

1. Generating random number;
2. Performing a simple two-argument arithmetic operation: addition, subtraction, multiplication or division.

Both types of requests/responses should be your custom types:

- `RandomRequest`/`RandomResponse`;
- `ArithmeticRequest`/`ArithmeticResponse`.

Please note that `ArithmeticRequest` should specify the type of operation to be performed.

The requestors and services should be started from one entry point (i.e. method main).

During a session each requestor should put 3 different requests and consume the processing results.

```apache
# Sample Apache ActiveMQ configuration

java.naming.factory.initial = org.apache.activemq.jndi.ActiveMQInitialContextFactory

java.naming.provider.url = vm://localhost
java.naming.provider.url = tcp://localhost:61616

connectionFactoryNames = connectionFactory, queueConnectionFactory, topicConnectionFactry

queue.[jndiName] = [physicalName]
queue.Queue = pl.edu.pjwstk.tpr.jms.Queue

topic.[jndiName] = [physicalName]
topic.Topic = pl.edu.pjwstk.tpr.jms.Topic
```

```apache
# Sample log4j configuration required by Apache ActiveMQ

log4j.rootLogger = INFO, A1, A2
log4j.rootLogger = INFO, A2
log4j.rootLogger = DEBUG, A1, A2
log4j.rootLogger = INFO, A2

log4j.appender.A1 = org.apache.log4j.ConsoleAppender
log4j.appender.A1.layout = org.apache.log4j.SimpleLayout
log4j.appender.A1.layout = org.apache.log4j.PatternLayout
log4j.appender.A1.layout.ConversionPattern = %d %5p [%t] (%F:%L) - %m%n
log4j.appender.A1.layout.ConversionPattern = %d{HH:mm:ss,SSS} %5p [%t] %C{1}.%M - %m%n
log4j.appender.A2 = org.apache.log4j.RollingFileAppender
log4j.appender.A2.MaxFileSize = 1MB
log4j.appender.A2.File = C:/Temp/edek-jms.html
log4j.appender.A2.Append = false
log4j.appender.A2.layout = org.apache.log4j.HTMLLayout
```
