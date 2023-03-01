package cinema.controller;

import cinema.model.Room;
import cinema.model.Seat;
import cinema.model.dto.SeatDTO;
import cinema.service.RoomService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;


@RestController
public class CinemaController {

    Room room = new Room();
    RoomService service = new RoomService();
    @GetMapping("/seats")
    Room getSeats(){
        /*
        List<Seat> seats= new ArrayList<>();
        for(int i = 0; i<9; i++){
            for(int j=0; j<9; j++){
                seats.add(new Seat(i+1,j+1));
            }
        }*/
        room.setAvailableSeats(service.findAll());
        room.setTotalColumns(9);
        room.setTotalRows(9);
        return room;
    }

    @PostMapping("/purchase")
    Seat purchase(@RequestBody SeatDTO seatDTO){

       Seat seat = new ModelMapper().map(seatDTO,Seat.class);
        return service.purchaseSeat(seat);
    }


}
