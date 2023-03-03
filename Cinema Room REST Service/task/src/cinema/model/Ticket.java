package cinema.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Ticket {
    private String token;
    private Seat ticket;

}
