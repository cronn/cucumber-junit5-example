# Cucumber with JUnit5

This repository contains an example project that integrates [Cucumber](https://cucumber.io/) with [JUnit5](https://junit.org/junit5/). It is the same setup explained in the [blog post](https://www.blog.cronn.de/en/testing/2020/08/17/cucumber-junit5.html).

## Quick Start

```shell
$ git clone https://github.com/cronn/cucumber-junit5-example your-own-tests
$ cd your-own-tests
$ ./gradlew test
```

Gradle will execute all feature files which are located in the `src/test/resources/features` folder as specified in [RunAllCucumberTests](https://github.com/cronn/cucumber-junit5-example/blob/main/src/test/java/com/example/RunAllCucumberTests.java). In order to filter execution to just a subset of all features, use the `includeTags` property as in the following example. It uses [JUnit5 tag expressions](https://junit.org/junit5/docs/current/user-guide/#running-tests-tag-expressions):

```shell script
$ ./gradlew test --project-prop includeTags="first | awesome"
```

In order to ignore just a subset of features, use the `includeTags` property like this:

```shell script
$ ./gradlew test --project-prop includeTags="!second"
```

[build.gradle.kts](https://github.com/cronn/cucumber-junit5-example/blob/main/build.gradle.kts#L36-L43) uses `cucumber.execution.parallel.enabled` to enable parallel test execution by default. Additionally, it uses the `cucumber.plugin` option to write a reports file to `build/reports/cucumber.ndjson`, an execution timeline to `build/reports/timeline` and an HTML report to `build/reports/cucumber.html`. All Cucumber features/rules/examples/scenarios annotated with `@disabled` are filtered by default and are not executed. This project declares an extra dependency to [picocontainer](http://picocontainer.com/) in order to show dependency injection within tests - remove it in case you don't need it. The Gradle configuration is annotated to help you make changes for your own test setup, thus feel free to modify it!

[<img src="https://www.cronn.de/img/logo_name_rgb_1200x630.png" alt="cronn GmbH" width="200"/>](https://www.cronn.de/)
