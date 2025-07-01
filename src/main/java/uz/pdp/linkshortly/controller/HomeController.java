package uz.pdp.linkshortly.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by: suhrob
 */

@Controller
public class HomeController {

    @GetMapping("/")
    public String root() {
        return "forward:/index.html";
    }

    @GetMapping("/api/")
    public String apiHome() {

        return "forward:/index.html";

    }
}
