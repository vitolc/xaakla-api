package com.vitulc.portfolio.app.dtos;

import jakarta.validation.constraints.NotBlank;

public record EmailDto(@NotBlank(message = "Email sender is required") String sender,
                       @NotBlank(message = "") String subject,
                       @NotBlank(message = "") String body) {
}
