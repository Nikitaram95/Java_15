package ru.netology.manager;


import ru.netology.domain.TicketOffer;
import ru.netology.repository.TicketOfferRepository;

import java.util.Arrays;

public class TicketOfferManager {
    private TicketOfferRepository repository;

    public TicketOfferManager() {
    }

    public TicketOfferManager(TicketOfferRepository repository) {
        this.repository = repository;
    }

    public void add(TicketOffer ticket) {
        repository.save(ticket);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public TicketOffer[] findAll(String from, String to) {
        TicketOffer[] result = new TicketOffer[0];

        for (TicketOffer ticket : repository.getAll()) {
            if (from.equals(ticket.getAirportFrom()) && to.equals(ticket.getAirportTo())) {

                TicketOffer[] tickets = new TicketOffer[result.length + 1];
                System.arraycopy(result, 0, tickets, 0, result.length);
                tickets[tickets.length - 1] = ticket;
                result = tickets;
            }
        }
        Arrays.sort(result);
        return result;
    }


}
