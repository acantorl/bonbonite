package com.bonbonite.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", "junit:target/junit-reports/TEST-cucumber.xml"},
        features = "src/test/resources/features/login_user.feature",
        glue = "com.bonbonite.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class LogInUserRunner {
}