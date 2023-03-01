package cinema.model;

import lombok.Data;

@Data
public class Seat {
    private Integer row;
    private Integer Column;
    private Integer price;

    public Seat(Integer row, Integer column) {
        this.row = row;
        Column = column;
    }
}
