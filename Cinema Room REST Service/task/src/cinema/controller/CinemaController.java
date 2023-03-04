package cinema.controller;

import cinema.model.*;
import cinema.model.dto.SeatDTO;
import cinema.model.dto.TicketDTO;
import cinema.service.RoomService;
import cinema.service.StaticService;
import cinema.service.TicketService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
@RestController
public class CinemaController {

    Room room;
    final RoomService service;
    final TicketService ticketService;
    final StaticService staticService;

    public CinemaController(RoomService service, TicketService ticketService,Room room,StaticService staticService) {
        this.service = service;
        this.ticketService = ticketService;
        this.room = room;
        this.staticService = staticService;
    }

    @GetMapping("/seats")
    Room getSeats() {

        room.setAvailableSeats(service.findAll());
        room.setTotalColumns(service.TOTALCOLUMNS);
        room.setTotalRows(service.TOTALROWS);
        return room;
    }

    @PostMapping("/purchase")
    Ticket purchase(@RequestBody SeatDTO seatDTO) {
        Seat seat;
        Ticket ticket;
        if (service.validateIndex(seatDTO)) {
            throw new IndexOutOfBoundsException();
        }
        if (service.findAvailableSeat(seatDTO) == null) {
            throw new RuntimeException();
        } else {
            seat = service.findAvailableSeat(seatDTO);
            ticket = ticketService.addticket(seat);
            service.deleteSeat(seat);

        }

        return ticket;
    }

    @PostMapping("/return")
    ReturnTicket returnTicket(@RequestBody Token token) {
        Ticket ticket = ticketService.findTicket(token);

        if (ticket == null) {
            throw new ArrayIndexOutOfBoundsException();
        }

        TicketDTO ticketDTO = new ModelMapper().map(ticket.getTicket(),TicketDTO.class);
        ticketService.removeTicket(ticket);
        service.addSeat(ticketDTO);

        return new ReturnTicket(ticketDTO);
    }

    @GetMapping("/stats")
    Statics getStatics(){
        return staticService.getStatics();
    }
}
