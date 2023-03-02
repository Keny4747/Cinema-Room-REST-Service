package cinema.service;

import cinema.model.Seat;
import cinema.model.dto.SeatDTO;

import java.util.ArrayList;
import java.util.List;

public class RoomService {
    private final List<Seat> seats;
    public final Integer TOTALCOLUMNS = 9;
    public final Integer TOTALROWS = 9;

    public RoomService() {
        this.seats = new ArrayList<>();
        initFillAvailableSeats();
    }



    public List<Seat> findAll() {
        return seats;
    }
    public void deleteSeat(Seat seat){
        seats.remove(seat);
    }

    void initFillAvailableSeats() {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //<=3 porque estamos agregando el i+1
                Integer price = i <= 3 ? 10 : 8;
                this.seats.add(new Seat(i + 1, j + 1, price));
            }
        }
    }

    public Seat findAvailableSeat(SeatDTO seatDTO) {
        return   seats.stream()
                .filter(x -> x.getColumn().equals(seatDTO.getColumn()) && x.getRow().equals(seatDTO.getRow()))
                .findFirst()
                .orElse(null);
    }

    public boolean validateIndex(SeatDTO seatDTO) {
        return seatDTO.getColumn() > TOTALCOLUMNS
                || seatDTO.getColumn() < 0
                || seatDTO.getRow() > TOTALROWS
                || seatDTO.getRow() < 0;
    }
}
