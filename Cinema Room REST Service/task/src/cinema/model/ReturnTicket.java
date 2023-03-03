package cinema.model;

import cinema.model.dto.TicketDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReturnTicket {
    @JsonProperty("returned_ticket")
    private TicketDTO returnTicket;
}
