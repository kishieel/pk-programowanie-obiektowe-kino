package pl.edu.pk.student.carrots.cinema.repositories;

import pl.edu.pk.student.carrots.cinema.models.Ticket;
import pl.edu.pk.student.carrots.cinema.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TicketRepository {
    static TicketRepository instance = null;
    private final List<Ticket> tickets = new ArrayList<>();

    public static TicketRepository getInstance() {
        if (instance == null) instance = new TicketRepository();
        return instance;
    }

    public void add(Ticket ticket) {
        tickets.add(ticket);
    }

    public List<Ticket> findByLoginOfUser(String login) {
        return tickets.stream().filter(ticket -> ticket.loginOfUser().equals(login)).collect(Collectors.toList());
    }
}
