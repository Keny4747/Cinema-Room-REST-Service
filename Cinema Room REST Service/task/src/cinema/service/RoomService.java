package cinema.service;

import cinema.model.Seat;

import java.util.ArrayList;
import java.util.List;

public class RoomService {
    private final List<Seat> seats;
    public final Integer TOTALCOLUMNS = 9;
    public final Integer TOTALROWS = 9;

    public RoomService() {
        this.seats = new ArrayList<>();
    }

    public Seat purchaseSeat(Seat seat) {
        seats.add(seat);
        return seat;
    }

    public List<Seat> findAll() {
        showSeats();
        return seats;
    }
    public void findSeat(Integer row, Integer column){

    }

    void showSeats() {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //<=3 porque estamos agregando el i+1
                Integer price = i <= 3 ? 10 : 8;
                this.seats.add(new Seat(i + 1, j + 1, price));
            }
        }
    }

}
