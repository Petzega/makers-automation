package com.makers.automation.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.makers.automation.stepsDefinitions"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE,
        plugin = {"pretty", "html:target/cucumber",
                "json:results/cucumber-reports/report.json"}
)
public class Runner {
}
