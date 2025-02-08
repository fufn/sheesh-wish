package kz.wishify.exception;

public record ErrorResponse(
        String code,
        String message
) {
}
