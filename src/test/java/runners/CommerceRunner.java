package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import java.awt.*;
@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\resource\\Features\\Customer.feature", glue = "stepdefination",
dryRun = false,
        monochrome = true,
        plugin = {"pretty",
        "html:Report.html"})
public class CommerceRunner {
}
