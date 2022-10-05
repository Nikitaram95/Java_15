package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketOffer;
import ru.netology.repository.TicketOfferRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketOfferManagerTest {

    private TicketOfferRepository repository = new TicketOfferRepository();
    TicketOfferManager manager = new TicketOfferManager(repository);
    private TicketOffer first = new TicketOffer(1, 1_820, "ALA", "KZO", 2);
    private TicketOffer second = new TicketOffer(2, 999, "ALA", "AGA", 60);
    private TicketOffer third = new TicketOffer(3, 2_500, "ALA", "LON", 55);
    private TicketOffer fourth = new TicketOffer(4, 999, "ALA", "AGA", 35);
    private TicketOffer fifth = new TicketOffer(5, 3_125, "ALA", "LON", 22);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
    }


    @Test
    public void shouldSearchLine() {
        TicketOffer[] expected = new TicketOffer[]{first};
        TicketOffer[] actual = manager.findAll("ALA", "KZO");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchLineAndSort() {
        TicketOffer[] expected = new TicketOffer[]{third, fifth};
        TicketOffer[] actual = manager.findAll("ALA", "LON");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchLineNotExist() {
        TicketOffer[] expected = new TicketOffer[]{};
        TicketOffer[] actual = manager.findAll("LON", "AGA");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchLineEqualsPrice() {
        TicketOffer[] expected = new TicketOffer[]{second, fourth};
        TicketOffer[] actual = manager.findAll("ALA", "AGA");

        assertArrayEquals(expected, actual);
    }

}