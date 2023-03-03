package cinema.model.dto;

import lombok.Data;

@Data
public class TicketDTO {
    private int row;
    private int column;
    private int price;
}
