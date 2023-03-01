package cinema.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Room {
    @JsonProperty("total_rows")
    private Integer totalRows;

    @JsonProperty("total_columns")
    private Integer totalColumns;

    @JsonProperty("available_seats")
    private List<Seat> availableSeats;

    public Room() {

    }

    public Integer getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }

    public Integer getTotalColumns() {
        return totalColumns;
    }

    public void setTotalColumns(Integer totalColumns) {
        this.totalColumns = totalColumns;
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(List<Seat> availableSeats) {
        this.availableSeats = availableSeats;
    }
}
