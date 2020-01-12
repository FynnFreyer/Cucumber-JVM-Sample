package BlankCuke;

import io.cucumber.java.After;
import io.cucumber.java.de.Dann;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

public class SchrittDefinition {
    private final WebDriver driver = new FirefoxDriver();

    @Given("die Seite {string} wurde geöffnet")
    public void öffneSeite(String site) {
        driver.get(site);
    }

    @When("ich auf das Element {string} klicke")
    public void klickeDasElement(String id) {
        WebElement link = driver.findElement(By.id(id));
        link.click();
    }

    @Then("sollte der Titel der Seite {string} lauten")
    public void derTitelSollSein(String erwarteterTitel) {
        String wirklicherTitel = driver.getTitle();
        assertEquals(erwarteterTitel, wirklicherTitel);
    }

    @Dann("sollte das Ergebnis {int} sein")
    public void sollteDasErgebnisSein(int ergebnis) {
        String erwartet = Integer.toString(ergebnis);
        String gelesen = driver.findElement(By.id("result")).getText();
        assertEquals(erwartet, gelesen);
    }


    @After()
    public void tearDown() {
        driver.quit();
    }

}
