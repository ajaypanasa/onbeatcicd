package com.qa.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","summary","html:target/cucumber"}
        ,features = {"src/test/resources"}
        ,glue = {"src/test/java/com/qa/stepdef"}
        ,snippets = CAMELCASE
        ,dryRun=true
        ,monochrome=true
//        ,strict=true
//            ,tags = {"@foo and not @bar"}
)

public class MyRunnerTest {

}
