package com.equifax.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report.html","json:target/cucumber.json"},
        features = "src/test/resources/features",
        glue="com/equifax/step_definitions",
        tags = "@wip"
)


public class CukesRunner {
}
