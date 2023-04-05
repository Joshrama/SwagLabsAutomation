package StepDefinitions;
import io.cucumber.core.cli.Main;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",glue= {"StepDefinitions"},
monochrome=true,
plugin= {"pretty","html:target/HtmlReports"})
public class Runner {
	  public static void main(String[] args) throws Throwable {
	        Main.run(args, Thread.currentThread().getContextClassLoader());
	    }
	}