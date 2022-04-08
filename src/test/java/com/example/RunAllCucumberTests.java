package com.example;

import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

/**
 * Use junit-platform-suite to tell both your IDE and Gradle where to find tests. The "features" folder in
 * src/test/resources contains all .feature files of this project. Note that the SelectClasspathResource annotation
 * can be repeated, thus allowing us to specify multiple locations for feature files.
 *
 * The "cucumber" engine inclusion is not strictly necessary since that is the only engine available in this project.
 * However, if you are planning on running regular JUnit5 tests in the same project, make sure to specify the engine
 * here.
 */
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
public class RunAllCucumberTests {
}
