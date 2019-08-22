/**
 * 
 */
package com.test.runner;

import org.junit.runner.RunWith;		
import cucumber.api.CucumberOptions;		
import cucumber.api.junit.Cucumber;

/**
 * @author deepa
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(features="Features", glue={"StepDefinition"})
public class Runner {

}
