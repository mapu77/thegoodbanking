package edu.thoughtworks.thegoodbanking;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Test;

import java.io.IOException;

public class TransferAcceptanceTest {
    @Test
    public void shouldNotAllowTransfersToTheSameAccountAsSource() throws IOException {
        WebClient webClient = new WebClient();
        HtmlPage htmlPage = webClient.getPage("http://localhost:8080");
    }
}
