package cinema.service;

import cinema.model.Seat;
import cinema.model.Statics;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StaticService {
    final List<Seat> initSeats;
    RoomService roomService;
    TicketService ticketService;
    final Statics statics;
    public StaticService(Statics statics,RoomService roomService,TicketService ticketService) {
        this.statics = statics;
        this.roomService = roomService;
        this.ticketService = ticketService;
        this.initSeats = roomService.findAll();
    }

    public void processData(){
        currentIncome();
        numberAvailableSeats();
        numberPurchasedTickets();
    }
    public void currentIncome(){
       int ticketAvailable= roomService.findAll()
                .stream()
                .mapToInt(Seat::getPrice)
                .sum();
        int soldTickets= initSeats
                .stream()
                .mapToInt(Seat::getPrice)
                .sum();

        this.statics.setCurrentIncome(ticketAvailable-soldTickets);
    }
    public void numberAvailableSeats(){
     this.statics.setAvailableSeats( roomService.findAll().size());
    }
    public void numberPurchasedTickets(){
        this.statics.setPurchasedTickets( ticketService.findAll().size());
    }
    public Statics getStatics(){
        processData();
        return  statics;
    }
}
