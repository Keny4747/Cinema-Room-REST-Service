package cinema.controller;

import cinema.model.Room;
import cinema.model.Seat;
import cinema.service.RoomService;
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
    Seat purchase(@RequestBody Seat seat){
        return service.purchaseSeat(seat);
    }


}
