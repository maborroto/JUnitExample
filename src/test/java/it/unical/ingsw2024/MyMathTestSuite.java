package it.unical.ingsw2024;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ParameterizedMathTest.class, MyMathTest.class})
@SuiteDisplayName("Test Suite per MyMath")
public class MyMathTestSuite {

}
