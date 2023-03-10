package cinema.service;

import cinema.model.Seat;
import cinema.model.dto.SeatDTO;
import cinema.model.dto.TicketDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RoomService {
    private final List<Seat> seats;
    public final Integer TOTALCOLUMNS = 9;
    public final Integer TOTALROWS = 9;

    public RoomService() {
        this.seats =initFillAvailableSeats();
    }



    public List<Seat> findAll() {
        return seats;
    }
    public void deleteSeat(Seat seat){
        seats.remove(seat);
    }
    public void addSeat(TicketDTO ticketDTO){
        Seat seat = new ModelMapper().map(ticketDTO,Seat.class);
        seats.add(seat);
    }

    List<Seat> initFillAvailableSeats() {
        List<Seat> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //<=3 porque estamos agregando el i+1
                Integer price = i <= 3 ? 10 : 8;
                list.add(new Seat(i + 1, j + 1, price));
            }
        }
        return list;
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
