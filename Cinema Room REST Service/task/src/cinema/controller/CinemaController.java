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

        room.setAvailableSeats(service.findAll());
        room.setTotalColumns(service.TOTALCOLUMNS);
        room.setTotalRows(service.TOTALROWS);
        return room;
    }

    @PostMapping("/purchase")
    Seat purchase(@RequestBody SeatDTO seatDTO){

       Seat seat = new ModelMapper().map(seatDTO,Seat.class);
        return service.purchaseSeat(seat);
    }


}
