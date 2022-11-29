plugins {
    // REQUIRED: We are writing tests in Java, change this only if you want to use another language
    java
}

// REQUIRED: Declare the dependencies that you want to use in your tests. We are using dynamic version ranges here
//           and later on lock the currently used versions in a lockfile. If you want to use a specific version
//           of a dependency, feel free to adjust the version here.
dependencies {
    testImplementation("io.cucumber:cucumber-java:latest.release") {
        because("we want to use Cucumber JVM")
    }
    testImplementation("io.cucumber:cucumber-junit-platform-engine:latest.release") {
        because("we want to use Cucumber with JUnit 5")
    }
    testImplementation("org.junit.platform:junit-platform-suite:latest.release") {
        because("we want to use the JUnit 5 @Suite annotation to select/run Cucumber tests")
    }
    testImplementation("org.junit.jupiter:junit-jupiter-api:latest.release") {
        because("we want to use JUnit 5 assertions - replace this if you want to use another assertions library")
    }
    testImplementation("io.cucumber:cucumber-picocontainer:latest.release") {
        because("we want to use dependency injection in our Cucumber tests - remove this if you don't")
    }
}

tasks {
    test {
        // REQUIRED: Tell Gradle to use the JUnit 5 platform to execute tests
        // see https://docs.gradle.org/current/userguide/java_testing.html#using_junit5
        useJUnitPlatform {
            // OPTIONAL: Exclude all tests (examples/scenarios) annotated with @disabled by default
            excludeTags("disabled")
            // OPTIONAL: Include only specified tags using JUnit5 tag expressions
            if (project.hasProperty("includeTags")) includeTags(project.property("includeTags") as String?)
        }
        // OPTIONAL: Ignore test failures so that build pipelines won't get blocked by failing examples/scenarios
        ignoreFailures = true
        // OPTIONAL: Copy all system properties from the command line (-D...) to the test environment
        systemProperties(project.gradle.startParameter.systemPropertiesArgs)
        // OPTIONAL: Enable parallel test execution
        systemProperty("cucumber.execution.parallel.enabled", true)
        // OPTIONAL: Set parallel execution strategy (defaults to dynamic)
        systemProperty("cucumber.execution.parallel.config.strategy", "fixed")
        // OPTIONAL: Set the fixed number of parallel test executions. Only works for the "fixed" strategy defined above
        systemProperty("cucumber.execution.parallel.config.fixed.parallelism", 4)
        // OPTIONAL: Enable Cucumber plugins, enable/disable as desired
        systemProperty("cucumber.plugin", "message:build/reports/cucumber.ndjson, timeline:build/reports/timeline, html:build/reports/cucumber.html")
        // OPTIONAL: Improve readability of test names in reports
        systemProperty("cucumber.junit-platform.naming-strategy", "long")
        // OPTIONAL: Don't show Cucumber ads
        systemProperty("cucumber.publish.quiet", "true")
        // OPTIONAL: Force test execution even if they are up-to-date according to Gradle or use "gradle test --rerun"
        outputs.upToDateWhen { false }
    }
}

java {
    // OPTIONAL: Use Java 17 toolchain, adjust according to your needs or remove entirely
    // see https://docs.gradle.org/current/userguide/toolchains.html
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
        vendor.set(JvmVendorSpec.ADOPTIUM)
    }
    // OPTIONAL: Force compile classpath versions for all dependencies, remove if undesired
    // see https://docs.gradle.org/current/userguide/resolution_strategy_tuning.html#resolution_consistency
    consistentResolution {
        useCompileClasspathVersions()
    }
}

// OPTIONAL: Lock all dependencies since we are using dynamic version ranges
// see https://docs.gradle.org/current/userguide/dependency_locking.html
dependencyLocking {
    lockAllConfigurations()
}

// OPTIONAL: In order to show that none of the commonly used suspects for test execution are used, JUnit 4 and JUnit 5
//           engines are excludes for all configurations. In case you are planning on running regular JUnit 4/5 tests
//           along your Cucumber features/rules/examples/scenarios, either remove this entire block or just remove the
//           engine that you want to use to run your tests.
configurations {
    all {
        // OPTIONAL: Exclude JUnit 4
        exclude(group = "junit", module = "junit")
        // OPTIONAL: Exclude JUnit 5 vintage engine
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
        // OPTIONAL: Exclude JUnit 5 jupiter engine
        exclude(group = "org.junit.jupiter", module = "junit-jupiter-engine")
    }
}

// OPTIONAL: Make sure that we are always using the ALL distro of Gradle for better IDE integration
tasks.named<Wrapper>("wrapper") {
    distributionType = Wrapper.DistributionType.ALL
}
