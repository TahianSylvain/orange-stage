![company](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTNE7hhUvWXZiSKRuv3gaDf2tt3chPYyknH-g&usqp=CAU)
![backend](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSyUkJVUPxbVDLPhRZ7zFF_34242cwGN_MHzQ&usqp=CAU)
![engine](https://avatars.githubusercontent.com/u/2443838?s=200&v=4)
# Camunda Platform Runtime: Quarkus Engine Extension Spin Example

This example uses Quarkus, the Supersonic Subatomic Java Framework, 
in combination with the extension `camunda-bpm-quarkus-engine`.

If you want to learn more about Quarkus, please visit: https://quarkus.io/.

The example demonstrates how you can use the Camunda Platform Runtime Engine in combination with Quarkus and Home Made Artificial Intelligence:
________                               _______________
___  __/__________________________________  ____/__  /________      __
__  /  _  _ \_  __ \_  ___/  __ \_  ___/_  /_   __  /_  __ \_ | /| / /
_  /   /  __/  / / /(__  )/ /_/ /  /   _  __/   _  / / /_/ /_ |/ |/ /
/_/    \___//_/ /_//____/ \____//_/    /_/      /_/  \____/____/|__/


To store order items, perform the following REST API request:

```sh
curl -X POST 'http://localhost:9090/store-order-items' \
  -H 'Content-Type: application/json' \
  --data-raw '
  [
    {
      "name": "All-purpose flour",
      "price": 6.99,
      "period": 3,
      "origine": "£"
    },
    {
      "name": "Granulated sugar",
      "price": 7.99,
      "period": 6,
      "origine": "€"
    },
    {
      "name": "Cocoa powder",
      "price": 9.99,
      "period": 9,
      "origine": "$"
    },
    {
      "name": "Baking Soda",
      "price": 0.0009,
      "period": 12,
      "origine": "BTC"
    }
  ]'
```

Observe the console and watch out for the following log output:

```
2021-08-25 15:04:16,772 INFO  [org.cam.bpm.qua.exa.ser.StoreOrderItemService] (executor-thread-0) Hurray, order item Skin Care with price 4,56 stored!
2021-08-25 15:04:16,782 INFO  [org.cam.bpm.qua.exa.ser.StoreOrderItemService] (executor-thread-0) Hurray, order item Watch with price 60,55 stored!
2021-08-25 15:04:16,788 INFO  [org.cam.bpm.qua.exa.ser.StoreOrderItemService] (executor-thread-0) Hurray, order item Cookies with price 1,99 stored!
2021-08-25 15:04:16,793 INFO  [org.cam.bpm.qua.exa.ser.StoreOrderItemService] (executor-thread-0) Hurray, order item Pasta with price 0,95 stored!
```

## Requirements

* Java 17+
* Maven 3.8.1+

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
mvn clean compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:9090/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
mvn clean package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
mvn clean package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/camunda-bpm-quarkus-example-spin-plugin-1.0.0-SNAPSHOT-runner.jar`.
