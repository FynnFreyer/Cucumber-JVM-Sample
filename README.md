# [Cucumber JVM](https://cucumber.io/docs/cucumber/)

## Installation
füge folgendes in die `pom.xml` ein:

    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-java</artifactId>
        <version>${cucumber.version}</version>
        <scope>test</scope>
    </dependency>

    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-junit</artifactId>
        <version>${cucumber.version}</version>
        <scope>test</scope>
    </dependency>

Für JUnit 5 Support muss außerdem die JUnit Vintage Engine eingebunden werden:

    <dependency>
        <groupId>org.junit.vintage</groupId>
        <artifactId>junit-vintage-engine</artifactId>
        <version>${junit.jupiter.version}</version>
        <scope>test</scope>
    </dependency>

Die `${foo.bar}` Parts setzen natürlich gesetzte Properties voraus, ansonsten händisch durch gewünschte Versionen ersetzen.

## Nutzung

Definiere eine leere Klasse, in `src.test.java.${Projektname}` die den Cucumber JUnit runner nutzt:

    package com.example;

    import io.cucumber.junit.Cucumber;
    import io.cucumber.junit.CucumberOptions;
    import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions()
    public class RunCucumberTest {
    }


Die Funktionalität "Foo" wird in einem `foo.feature` File in `src.test.resources.${Projektname}` festgelegt, das ist der Part der von den Stakeholdern geschrieben wird.

`# language: de` am Anfang der Datei bedeutete das mit deutschen Schlagwörtern gearbeitet wird.

ein (deutscher) Feature File folgt dem Muster:

    Funktionalität: Titel
    Beschreibung des Features

    Szenario: Szenarientitel (optional)
        Angenommen x
        Wenn y
        Dann z

Um die Szenarien in Unittests zu übersetzen schreibt man sog. Schrittdefinitionen. Sollten in den gleichen Ordner wie der JUnit Runner.

Eine Schrittdefinition zu dem Beispielfeature könnte z.B. so aussehen:

public class SchrittDef {
    @Given("x")
    public void x() {
        //code goes here
    }

    @When("y")
    public void y() {
        //code goes here
    }

    @Then("z")
    public void z() {
        //code goes here
    }
}

es können natürlich auch Variablen verwendet werden, dabei sieht das entsprechende Szenario folgendermaßen aus:

    Szenario:
        Angenommen ich gehe zur Uni
        Dann ...

bzw. die Schrittdefinition:

    @Given("ich gehe zur {string}")
    public void gehtZurUni(String wohin) {
        assertEquals("Uni", wohin) //passed
    }



Assertions von JUnit können einfach genutzt werden, Annotationen funktionieren etwas [anders](https://cucumber.io/docs/cucumber/api/#hooks), aber ziemlich ähnlich.

## Reporting

Formatierung und andere Optionen können via `@CucumberOptions()` in der Runnerklasse eingestellt werden.

z.B. generiert `@CucumberOptions(plugin = {"pretty"})` schön eingefärbten Konsolenoutput

für HTML-Reports fügen wir `html:target/cucumber-reports` als Pluginoption hinzu
(legt die Reports unter `./target/cucumber-reports` ab) und
analog dazu für JSON `json:target/cucumber-reports/Cucumber.json`

XML kann mittels `junit:target/cucumber-reports/Cucumber.xml` generiert werden.

Für Eclipse interessant ist die `monochrome` Option, da das einfärben des Outputs in Eclipse häßliche Sonderzeichen produzieren kann.

Am Ende könnte es z.B. so aussehen:

    @CucumberOptions(
        plugin = {
            "pretty", 
            "html:target/cucumber-reports", 
            "json:target/cucumber-reports/Cucumber.json", 
            "junit:target/cucumber-reports/Cucumber.xml"}, 
        monochrome = true
    )


