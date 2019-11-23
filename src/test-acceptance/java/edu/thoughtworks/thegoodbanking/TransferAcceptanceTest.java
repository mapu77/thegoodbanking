package edu.thoughtworks.thegoodbanking;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlNumberInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
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

        fillSourceAccountDetails(htmlPage, "ES7921000813610123456789");
        fillDestinationAccountDetails(htmlPage, "ES7921000813610123456789");
        filAmountDetails(htmlPage, "100,00");
        clickTransfer(htmlPage);

    }

    private void clickTransfer(HtmlPage htmlPage) throws IOException {
        HtmlForm form = htmlPage.getFormByName("transfer");
        form.click();
    }

    private void filAmountDetails(HtmlPage htmlPage, String fieldValue) throws IOException {
        fillNumberField(htmlPage, "amount", fieldValue);
    }

    private void fillDestinationAccountDetails(HtmlPage htmlPage, String fieldValue) throws IOException {
        fillTextField(htmlPage, "destination-account", fieldValue);
    }

    private void fillSourceAccountDetails(HtmlPage htmlPage, String fieldValue) throws IOException {
        fillTextField(htmlPage, "source-account", fieldValue);
    }

    private void fillTextField(HtmlPage htmlPage, String fieldName, String fieldValue) throws IOException {
        HtmlTextInput textInputField = (HtmlTextInput) htmlPage.getElementById(fieldName);
        textInputField.type(fieldValue);
    }

    private void fillNumberField(HtmlPage htmlPage, String fieldName, String fieldValue) throws IOException {
        HtmlNumberInput numberInputField = (HtmlNumberInput) htmlPage.getElementById(fieldName);
        numberInputField.type(fieldValue);
    }
}
