package TestRunner;

import org.junit.runner.RunWith;
//import cucumber.api.*;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions
(features="Feature",glue= {"StepDefinitions"},
monochrome=true,
plugin= {"pretty","html:target/HtmlReports"})
public class TestRun {

}
