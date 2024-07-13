package ag.selm.manager.controller.payload;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record NewProductPayload(
        @NotNull
        @Size(min =  3, max = 30)
        String title,
        @Size(max = 500)
        String details){

}
