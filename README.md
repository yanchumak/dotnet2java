# Transition .NET to Java developer guide
## How to use
<!-- TOC -->
- [Preparation](#preparation)
- [Ecosystem overview](#ecosystem-overview)
- [Build tools](#build-tool)
  - [Maven](#build-tool-maven)
- [Basics](#basics)
- [Core](#core)
    - [Collections](#core-collections)
    - [Generics](#core-generics)
    - [Stream API vs LINQ](#core-stream-api)
- [First console application](#first-app)
- [Unit testing](#unit-testing)
- [Logging](#logging)
- [Web](#web)
  - [Spring vs ASP.NET](#web-spring)
    - [Spring boot and starters](#web-spring-boot)
    - [12 factor](#web-spring-12-factor)
  - [ORM](#web-orm)
    - [Hibernate](#web-orm-hibernate)
  - [Template language](#web-template-lang)
  - [First web application](#web-first-app)
  - [DTO to Entity mapping](#web-dto-entity-mapping)
- [Advanced](#advanced)
  - [Memory model](#advanced-memory-model)
  - [Concurrency](#advanced-concurrency)
  - [Troubleshooting](#advanced-troubleshooting)
  - [Hexagonal architecture](#advanced-hexagonal-architecture)
<!-- TOC -->

### Preparation
Download and install required tools and software
   1. [Java 11.0.2 (build 11.0.2+9)](https://jdk.java.net/archive/)
      1. Set up JAVA_HOME and add Java bin to path [for Windows](https://www.ibm.com/docs/en/b2b-integrator/5.2?topic=installation-setting-java-variables-in-windows) [for Mac](https://gist.github.com/fabianogoes/bf7aa20b007d8dda1ed2)
      2. Verify. Result of `echo %JAVA_HOME%`(Windows, for Mac use `echo $JAVA_HOME`) `java --version` should be something like this
         ```
         C:\Users\user>echo %JAVA_HOME%
         C:\workspace\soft\jdk-11.0.13+8
         
         C:\Users\ychum>java --version
         openjdk 11.0.13 2021-10-19
         OpenJDK Runtime Environment Temurin-11.0.13+8 (build 11.0.13+8)
         OpenJDK 64-Bit Server VM Temurin-11.0.13+8 (build 11.0.13+8, mixed mode)
         ```
         
   2. [Download and install Maven](https://maven.apache.org/install.html)
      1. Verify. Result of `mvn --version` should be something like this
         ```
         C:\Users\user>mvn --version
         Apache Maven 3.6.3 (cecedd343002696d0abb50b32b541b8a6ba2883f)
         Maven home: c:\workspace\soft\apache-maven-3.6.3\bin\..
         Java version: 11.0.13, vendor: Eclipse Adoptium, runtime: C:\workspace\soft\jdk-11.0.13+8
         Default locale: en_US, platform encoding: Cp1252
         OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
         ```
   3. [Java IDE IntelliJ IDEA Community edition](https://www.jetbrains.com/idea/download). [Set up Intellij Idea to use your Java](https://www.jetbrains.com/help/idea/sdk.html#set-up-jdk)

### Ecosystem overview

Java platform

![https://www.oracle.com/java/technologies/platform-glance.html](./doc/images/java-platform.png "Java platform")

Comparison with .NET

![https://www.overops.com/blog/clr-vs-jvm-how-the-battle-between-net-and-java-extends-to-the-vm-level](./doc/images/java-vs-dotnet.png "")


JVM more info
[link#1](https://dzone.com/articles/jvm-architecture-explained) 
[link#2](https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-2.html)

### Build tools
[Overview](https://www.jrebel.com/blog/java-build-tools-comparison)

#### Maven
[Getting Started in 5 Minutes](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)

[Getting Started in 30 Minutes](https://maven.apache.org/guides/getting-started/index.html)

[Lifecycles](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html)

### Basics
[Language basics](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/index.html)

[Oracle code conventions](https://www.oracle.com/java/technologies/javase/codeconventions-introduction.html)

[Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)

### Core
Recommended books
- [Effective Java](https://www.amazon.com/Effective-Java-Joshua-Bloch-dp-0134685997/dp/0134685997/ref=dp_ob_image_bk)
- [Modern Java in action](https://www.manning.com/books/modern-java-in-action)

[Tutorial](https://www.digitalocean.com/community/tutorials/core-java-tutorial)

#### Collections

![Collections](./doc/images/java-collections.png)
[Tutorial](https://docs.oracle.com/javase/tutorial/collections/interfaces/index.html)

#### Generics

[Tutorial](https://docs.oracle.com/javase/tutorial/extra/generics/intro.html)

#### Stream API vs LINQ

[Comparison](https://www.iodigital.com/en/history/foreach/java-and-net-comparing-streams-linq)

Stream API [#1](https://www.oracle.com/technical-resources/articles/java/ma14-java-se-8-streams.html) [#2](https://www.oracle.com/technical-resources/articles/java/architect-streams-pt2.html) 


### First console application
Maven project structure

![](./doc/images/maven-project-structure.png)

`dotnet2java\java\console-app\src\main\java\com\mycompany\app\HelloWorldApp.java`
```java
public class HelloWorldApp {

  public static void main(String[] args) {
    System.out.println("Hello World!");
  }
}
```
How to run

`mvn clean package` 

`java -cp  ./target/console-app-1.0-SNAPSHOT.jar com.mycompany.app.HelloWorldApp`


[A Closer Look at the "Hello World!" Application
](https://docs.oracle.com/javase/tutorial/getStarted/application/index.html)
### Unit testing

### Logging

### Web
[Spring overview](https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/overview.html)

![](https://docs.spring.io/spring-framework/docs/3.0.x/spring-framework-reference/html/images/spring-overview.png)

Main concepts
- [DI & IoC](https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/beans.html#beans-introduction)
- [AOP](https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/aop.html#aop-introduction)
- Beans [scopes](https://docs.spring.io/spring-framework/docs/3.0.0.M3/reference/html/ch04s04.html)
  ![](https://i.stack.imgur.com/gL8Ky.jpg)

#### Spring vs ASP.NET
[Comparison](https://medium.com/@putuprema/spring-boot-vs-asp-net-core-a-showdown-1d38b89c6c2d)
##### Spring boot and starters
TODO
##### 12 factor
[Origin](https://12factor.net/)

[Cloud Native Apps ](https://www.infoq.com/presentations/12factor-spring/)

### Advanced

#### Troubleshooting

[Guide](https://docs.oracle.com/en/java/javase/11/troubleshoot/index.html)


