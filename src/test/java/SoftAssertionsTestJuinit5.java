import com.codeborne.selenide.Configuration;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SoftAssertionsTestJuinit5 {
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
        open("https://github.com/search?q=selenide");
        System.out.println("*Start test info!*");

    }


    @Test
    void codeSearchJunit5() {
        $("div.f4.text-normal a[href='/selenide/selenide']").click();
        $("#wiki-tab").click();
        $(".f6.Link--muted.js-wiki-more-pages-link.btn-link.mx-auto").scrollTo().click();
        $("a[href='/selenide/selenide/wiki/SoftAssertions']").shouldHave(text("SoftAssertions")).click();
        $("#user-content-3-using-junit5-extend-test-class").ancestor("h4").scrollTo().shouldHave(text("3. Using JUnit5 extend test class:"));
        String actualCode = $("#user-content-3-using-junit5-extend-test-class").ancestor("h4").sibling(0).scrollTo().getText();

        Assertions.assertEquals(expectedCode, actualCode);
    }


}
