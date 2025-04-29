package org.suzano.rest.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports/index.html", "json:target/cucumber-reports/cucumber.json"},
        features = "src/test/resources/features",
        glue = "org.suzano.rest.steps",
        monochrome = true,
        tags = "@regressive"
)

@RunWith(Cucumber.class)
public class Runners {
}