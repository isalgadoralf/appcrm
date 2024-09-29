package soe.solid.appcrm.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/cliente.feature",
        glue = {"soe.solid.appcrm.steps"},
        snippets = CucumberOptions.SnippetType.UNDERSCORE)
public class RCliente {
}
