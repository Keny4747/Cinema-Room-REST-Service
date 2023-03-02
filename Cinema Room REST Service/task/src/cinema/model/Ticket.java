package cinema.model;

import cinema.model.dto.Token;
import lombok.Data;

@Data
public class Ticket {
    private Token token;
    private Seat ticket;

}
