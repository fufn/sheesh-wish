package kz.wishify.dto;

import java.util.UUID;

public record WishDto(
        UUID id,
        String name,
        String description,
        String userName
) {
}