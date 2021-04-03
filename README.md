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

[<img src="https://www.cronn.de/img/logo_name_rgb_1200x630.png" alt="cronn GmbH" width="200"/>](https://www.cronn.de/)
