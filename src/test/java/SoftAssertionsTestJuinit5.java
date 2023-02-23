import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SoftAssertionsTestJuinit5 {

    @BeforeAll
    static void openPracticeForm(){
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        open("https://github.com/search?q=selenide");
        System.out.println("*Start test info!*");

    }


    @Test
    void codeSearchJunit5(){
        $("div.f4.text-normal a[href='/selenide/selenide']").click();
        $("#wiki-tab").click();
        $(".f6.Link--muted.js-wiki-more-pages-link.btn-link.mx-auto").scrollTo().click();
        $("a[href='/selenide/selenide/wiki/SoftAssertions']").shouldHave(text("SoftAssertions")).click();

    }






}
