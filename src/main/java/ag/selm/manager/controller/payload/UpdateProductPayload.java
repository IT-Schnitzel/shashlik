package ag.selm.manager.controller.payload;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateProductPayload(
        @NotNull(message = "{catalogue.products.create.errors.title_size_is_null}")
        @Size(min =  3, max = 30, message = "{catalogue.products.create.errors.title_size_is_invalid}")
        String title,
        @Size(max = 500, message = "{catalogue.products.create.errors.details_size_is_invalid}")
        String details){

}
