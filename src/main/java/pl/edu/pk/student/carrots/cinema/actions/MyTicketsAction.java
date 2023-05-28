package pl.edu.pk.student.carrots.cinema.actions;

import pl.edu.pk.student.carrots.cinema.models.Movie;
import pl.edu.pk.student.carrots.cinema.models.Ticket;
import pl.edu.pk.student.carrots.cinema.repositories.TicketRepository;
import pl.edu.pk.student.carrots.cinema.utils.Auth;
import pl.edu.pk.student.carrots.cinema.utils.IO;

import java.util.List;

public class MyTicketsAction extends SelectableAction {
    private final TicketRepository ticketRepository = TicketRepository.getInstance();

    @Override
    public String getTitle() {
        return "Moje bility";
    }

    @Override
    public void doAction() {
        String login = Auth.getInstance().getCurrentUser().login();
        List<Ticket> tickets = ticketRepository.findByLoginOfUser(login);

        IO.println("Zakupiłeś bilety aby obejrzeć.");
        IO.list(tickets.stream().map(Ticket::titleOfMovie).toList());

        new UserHomeAction().doAction();
    }
}
