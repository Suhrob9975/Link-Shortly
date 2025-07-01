package uz.pdp.linkshortly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.linkshortly.repository.UrlMappingRepository;

import java.net.URI;

/**
 * Created by: suhrob
 */

@RestController
public class RedirectController {

    @Autowired
    private UrlMappingRepository repository;

//    @GetMapping("/{shortCode}")

@GetMapping("/r/{shortCode}")
    public ResponseEntity<?> redirectToOriginal(@PathVariable String shortCode) {
        return repository.findByShortCode(shortCode)
                .map(urlMapping -> ResponseEntity
                        .status(302)
                        .location(URI.create(urlMapping.getOriginalUrl()))
                        .build())
                .orElse(ResponseEntity.notFound().build());
    }
}
