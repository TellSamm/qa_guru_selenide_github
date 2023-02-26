import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SoftAssertionsGitHubTest {
    String expectedCode = "@ExtendWith({SoftAssertsExtension.class})\n" +
            "class Tests {\n" +
            "  @Test\n" +
            "  void test() {\n" +
            "    Configuration.assertionMode = SOFT;\n" +
            "    open(\"page.html\");\n" +
            "\n" +
            "    $(\"#first\").should(visible).click();\n" +
            "    $(\"#second\").should(visible).click();\n" +
            "  }\n" +
            "}";
    @BeforeAll
    static void openPracticeForm() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        open("https://github.com/selenide/selenide");
        System.out.println("*Start test info!*");

    }

    @Test
    void codeSearchJunit5() {
        $("#wiki-tab").click();
        $("button[class$='mx-auto']").scrollTo().click();
        $("span[class^=T] a[href$='SoftAssertions']").shouldHave(text("SoftAssertions")).click();
        $("#user-content-3-using-junit5-extend-test-class").ancestor("h4").scrollTo().shouldHave(text("3. Using JUnit5 extend test class:"));
        String actualCode = $("#user-content-3-using-junit5-extend-test-class").ancestor("h4").sibling(0).scrollTo().getText();

        Assertions.assertEquals(expectedCode, actualCode);
    }


}
