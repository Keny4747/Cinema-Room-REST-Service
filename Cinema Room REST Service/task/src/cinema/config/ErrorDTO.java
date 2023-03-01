package cinema.config;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDTO {
    private String error;

}
