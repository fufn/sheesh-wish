package kz.wishify.dto;

import java.util.UUID;

public record WishDto(
        UUID id,
        String title,
        String description,
        String username
) {
}