Feature: Awesome Feature

  @awesome
  Scenario: You can re-use existing steps
    Given something exists
    When something is executed
    Then some result will be calculated

  @awesome
  Scenario: and even change the leading keyword
    * something exists
    * something is executed
    * some result will be calculated

  @awesome @failure
  Scenario: Failures should be made visible in a human readable report
    * something exists
    * something is executed
    * no result can be calculated
