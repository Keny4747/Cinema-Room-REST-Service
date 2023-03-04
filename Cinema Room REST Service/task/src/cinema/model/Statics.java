package cinema.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Statics {
    
    @JsonProperty("current_income")
    private Integer currentIncome;

    @JsonProperty("number_of_available_seats")
    private Integer availableSeats;

    @JsonProperty("number_of_purchased_tickets")
    private Integer purchasedTickets;

}
