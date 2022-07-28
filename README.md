# Your Cast RSS Feed

Your Cast RSS Feed is a Java (Spring Boot) application for generate RSS feed for employee.

# Setup

Use the package manager [maven](https://maven.apache.org) to build an artifact and install payments processing service. Ensure that all db migration have been performed (if persistence layer is available).

```
maven mvn clean install
```

Service should be accessible on [localhost:9999](localhost:9999).

# Libraries

Regarding keep our services consistent, please use libraries listed below, accordingly to their usecases.
Application has been written in Java 13th version so feel free to use any modern features it brings.

### Lombok
Project Lombok is a java library that automatically plugs into your editor and build tools, spicing up your java.

[Check documentation](https://projectlombok.org)

### netty.io
Netty is a NIO client server framework which enables quick and easy development of network applications such as protocol servers and clients.
It greatly simplifies and streamlines network programming such as TCP and UDP socket server.

[Check documentation](https://netty.io)

# Contributing

- Dmytro Kuchura