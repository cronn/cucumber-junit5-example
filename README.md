# Cucumber with JUnit5

This repository contains an example project that integrates [Cucumber](https://cucumber.io/) with [JUnit5](https://junit.org/junit5/). It is the same setup explained in the [blog post](https://www.blog.cronn.de/en/testing/2020/08/17/cucumber-junit5.html).

## Quick Start

```shell
$ git clone https://github.com/cronn/cucumber-junit5-example your-own-tests
$ cd your-own-tests
$ ./gradlew test
```

Gradle will execute all feature files which are located in the same package as [BuildToolSupport](https://github.com/cronn/cucumber-junit5-example/blob/master/src/test/java/com/example/BuildToolSupport.java) or any subpackage of that. In order to filter execution to just a subset of all features, use the `cucumber.filter.tags` option like this:

```shell script
$ ./gradlew test -Dcucumber.filter.tags="@first or @awesome"
```

In order to ignore just a subset of features, use the `cucumber.filter.tags` option like this:

```shell script
$ ./gradlew test -Dcucumber.filter.tags="not @second"
```

[build.gradle.kts](https://github.com/cronn/cucumber-junit5-example/blob/main/build.gradle.kts#L51) uses `cucumber.execution.parallel.enabled` to enable parallel test execution by default. Additionally, it uses the `cucumber.plugin` option to write a JSON report file to `build/reports/cucumber.json`. All Cucumber scenarios annotated by `@disabled` are filter by default. This project declares an extra dependency to [picocontainer](http://picocontainer.com/) in order to show dependency-injection in tests - remove it in case you don't need it.

Note that while this project uses JUnit5, it only requires the jupiter-api in order use JUnit 5 assertions. Replace this dependency in case you want to use another assertion library like [AssertJ](https://assertj.github.io/doc/). If you are planning on running regular JUnit 5 tests along with your Cucumber scenarios, add a dependency to jupiter-engine. The Gradle configuration is annotated to help you make changes for your own test setup, thus feel free to modify it!

[<img src="https://www.cronn.de/img/logo_name_rgb_1200x630.png" alt="cronn GmbH" width="200"/>](https://www.cronn.de/)
