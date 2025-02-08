package kz.wishify.dto;

import java.time.Instant;
import java.util.UUID;

public record WishDto(
        UUID id,
        String title,
        String description,
        Boolean isPurchased,
        String username,
        Double price,
        Instant targetDate,
        String imageUrl,
        String productUrl,
        Instant createdAt
) {}