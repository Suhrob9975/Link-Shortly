package uz.pdp.linkshortly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.linkshortly.entity.UrlMapping;

import java.util.Optional;

/**
 * Created by: suhrob
 */

public interface UrlMappingRepository extends JpaRepository<UrlMapping, Long> {
    Optional<UrlMapping> findByShortCode(String shortCode);
}
