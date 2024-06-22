package oak.bruno.challenge.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductDTO(@NotBlank String name,
                         @NotBlank String info,
                         @NotNull @Positive Integer price_in_cents,
                         @NotNull Boolean available) {
}
