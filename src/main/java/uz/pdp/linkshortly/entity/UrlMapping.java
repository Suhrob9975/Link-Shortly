package uz.pdp.linkshortly.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Created by: suhrob
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UrlMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String originalUrl;

    @Column(unique = true)
    private String shortCode;

    @Column(nullable = false)
    private Integer clickCount = 0;
}
