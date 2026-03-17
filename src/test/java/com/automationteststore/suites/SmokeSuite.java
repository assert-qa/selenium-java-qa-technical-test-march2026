package com.automationteststore.suites;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

/**
 * Smoke Test Suite – runs only @Tag("smoke") tests.
 *
 * Execute:
 *   mvn clean test -Psmoke-suite
 *
 * Then generate Allure report:
 *   mvn allure:report
 */
@Suite
@SuiteDisplayName("Smoke Test Suite")
@SelectPackages("com.automationteststore.tests")
@IncludeTags("smoke")
public class SmokeSuite {
}

