package cinema.service;

import cinema.model.Seat;

import java.util.ArrayList;
import java.util.List;

public class RoomService {
    private List<Seat> seats;

    public RoomService() {
        this.seats = new ArrayList<>();
    }

    public Seat purchaseSeat(Seat seat){
        seats.add(seat);
        return seat;
    }

    public List<Seat> findAll(){
        return seats;
    }

}
