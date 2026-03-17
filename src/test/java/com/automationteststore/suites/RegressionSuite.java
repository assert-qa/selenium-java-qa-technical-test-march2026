package com.automationteststore.suites;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Regression Test Suite")
@SelectPackages("com.automationteststore.tests")
@IncludeTags("regression")
public class RegressionSuite {
}

