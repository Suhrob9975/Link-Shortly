package uz.pdp.linkshortly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.linkshortly.entity.UrlMapping;
import uz.pdp.linkshortly.service.UrlService;

import java.net.InetAddress;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping("/shorten")
    public String shorten(@RequestBody Map<String, String> body) throws Exception {
        String url = body.get("url");
        if (url == null || url.trim().isEmpty()) {
            return "URL bo‘sh bo‘lishi mumkin emas!";
        }
        UrlMapping mapping = urlService.createShortUrl(url);


//        return "http://localhost:8080/r/" + mapping.getShortCode();

        String host = InetAddress.getLocalHost().getHostAddress();

        return "http://" + host + ":8080/r/" + mapping.getShortCode();
    }
}
