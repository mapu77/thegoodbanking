package edu.thoughtworks.thegoodbanking;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ApiController {
    @GetMapping("/")
    @ResponseBody
    public String welcome() {
        return "Hello World!";
    }
}
