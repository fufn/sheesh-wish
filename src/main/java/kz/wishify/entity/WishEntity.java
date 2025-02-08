package kz.wishify.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.UUID;

@Data
@Entity
@Table(name = "wish")
public class WishEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private Boolean isPurchased = Boolean.FALSE;

    @Column
    private String username;

    @Column
    private Double price;

    @Column
    private Instant targetDate;

    @Column
    private String imageUrl;

    @Column
    private String productUrl;

    @Column
    @CreationTimestamp
    private Instant createdAt;
}
