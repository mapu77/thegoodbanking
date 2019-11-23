package edu.thoughtworks.thegoodbanking;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TransferAcceptanceTest {
    @Test
    public void shouldNotAllowTransfersToTheSameAccountAsSource() throws IOException {
        WebClient webClient = new WebClient();
        HtmlPage htmlPage = webClient.getPage("http://localhost:8080");
        assertEquals("The Good Banking", htmlPage.getTitleText());

        HtmlInput sourceAccountInputField = (HtmlInput) htmlPage.getElementById("source-account");
        sourceAccountInputField.type("ES7921000813610123456789");

        HtmlInput destinationAccountInputField = (HtmlInput) htmlPage.getElementById("destination-account");
        destinationAccountInputField.type("ES7921000813610123456789");
    }
}
