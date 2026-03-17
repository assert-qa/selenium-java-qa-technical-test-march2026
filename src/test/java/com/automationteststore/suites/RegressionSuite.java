package com.automationteststore.suites;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

/**
 * Regression Test Suite – runs only @Tag("regression") tests.
 *
 * Execute:
 *   mvn clean test -Pregression-suite
 *
 * Then generate Allure report:
 *   mvn allure:report
 */
@Suite
@SuiteDisplayName("Regression Test Suite")
@SelectPackages("com.automationteststore.tests")
@IncludeTags("regression")
public class RegressionSuite {
}

