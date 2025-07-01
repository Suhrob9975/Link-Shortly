package uz.pdp.linkshortly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.linkshortly.entity.UrlMapping;
import uz.pdp.linkshortly.repository.UrlMappingRepository;

import java.util.Optional;
import java.util.Random;

@Service
public class UrlService {

    @Autowired
    private UrlMappingRepository repository;

    public UrlMapping createShortUrl(String originalUrl) {
        try {
            UrlMapping mapping = new UrlMapping();
            mapping.setOriginalUrl(originalUrl);
            mapping.setShortCode(generateRandomCode(6));
            return repository.save(mapping);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    private String generateRandomCode(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random rnd = new Random();
        String code;

        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                sb.append(chars.charAt(rnd.nextInt(chars.length())));
            }
            code = sb.toString();
        } while (repository.findByShortCode(code).isPresent());

        return code;
    }


    public Optional<UrlMapping> getOriginalUrl(String shortCode) {
        return repository.findByShortCode(shortCode);
    }



}
