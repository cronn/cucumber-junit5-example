plugins {
  java
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(15))
        vendor.set(JvmVendorSpec.ADOPTOPENJDK)
    }
    consistentResolution {
        useCompileClasspathVersions()
    }
}

dependencies {
  testImplementation("org.junit.jupiter:junit-jupiter-api:latest.release") {
	  because("we want to use JUnit 5 assertions")
  }
  testImplementation("io.cucumber:cucumber-java:latest.release") {
	  because("we want to use Cucumber JVM")
  }
  testImplementation("io.cucumber:cucumber-junit-platform-engine:latest.release") {
	  because("we want to use Cucumber with JUnit 5")
  }
  testImplementation("io.cucumber:cucumber-picocontainer:latest.release") {
	  because("we want to use dependency injection in our Cucumber tests")
  }
}

dependencyLocking {
    lockAllConfigurations()
}

tasks {
    test {
        ignoreFailures = true
        systemProperties(project.gradle.startParameter.systemPropertiesArgs)
        systemProperty("cucumber.execution.parallel.enabled", System.getProperty("test.parallel", "false"))
        systemProperty("cucumber.plugin", "json:build/reports/cucumber.json")
        systemProperty("cucumber.publish.quiet", "true")
        useJUnitPlatform {
            excludeTags("disabled")
        }
    }
}

configurations {
    all {
        exclude(group = "junit", module = "junit")
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

tasks.named<Wrapper>("wrapper") {
    distributionType = Wrapper.DistributionType.ALL
}
