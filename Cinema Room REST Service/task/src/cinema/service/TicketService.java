package cinema.service;

import cinema.model.Seat;
import cinema.model.Ticket;
import cinema.model.Token;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TicketService {

    List<Ticket> tickets;

    public TicketService() {
        this.tickets = new ArrayList<>();
    }

    public Ticket addticket(Seat seat) {
        Ticket ticket = new Ticket(generateUUID(), seat);
        tickets.add(ticket);
        return ticket;
    }

    public Ticket findTicket(Token token) {
        return tickets.stream()
                .filter(x -> x.getToken().equals(token.getToken()))
                .findFirst()
                .orElse(null);
    }
    public void removeTicket(Ticket ticket){
        tickets.remove(ticket);
    }
    public List<Ticket> findAll(){
        return tickets;
    }

    public String generateUUID() {
        return UUID.randomUUID().toString();
    }
}
