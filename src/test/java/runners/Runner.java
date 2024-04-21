package runners;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.ConfigurationParameters;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@ConfigurationParameters({
        @ConfigurationParameter(
                key = Constants.GLUE_PROPERTY_NAME,
                value = "stepdefinitions"
        ),
        @ConfigurationParameter(
                key = Constants.FEATURES_PROPERTY_NAME,
                value = "src/test/resources/features"
        ),
        @ConfigurationParameter(
                key = Constants.PLUGIN_PROPERTY_NAME,
                value = "pretty,json:target/cucumber-report.json,html:target/cucumber-report.html"
        ),
        @ConfigurationParameter(
                key = Constants.EXECUTION_DRY_RUN_PROPERTY_NAME,
                value = "false"
        ),
})
public class Runner {
}
