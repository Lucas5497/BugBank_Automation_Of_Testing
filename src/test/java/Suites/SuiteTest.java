package Suites;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import tests.TestesLogin;
import tests.TestesRegistrar;

@Suite
@SelectClasses({ TestesRegistrar.class, TestesLogin.class })
public class SuiteTest {
}