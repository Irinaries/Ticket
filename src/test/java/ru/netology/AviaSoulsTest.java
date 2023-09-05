package ru.netology;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.AviaSouls;
import ru.netology.Ticket;

import java.util.Comparator;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("Munchen", "Astana", 2000, 29, 31);
    Ticket ticket2 = new Ticket("Berlin", "Astana", 600, 3, 5);
    Ticket ticket3 = new Ticket("Nurnberg", "Astana", 2000, 29, 30);
    Ticket ticket4 = new Ticket("Berlin", "Astana", 900, 26, 28);
    Ticket ticket5 = new Ticket("Berlin", "Astana", 1200, 19, 25);


    @Test
    public void compareIfMore() {
        AviaSouls avia = new AviaSouls();

        avia.add(ticket1);
        avia.add(ticket2);

        int expected = 1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareIfLess() {
        AviaSouls avia = new AviaSouls();

        avia.add(ticket1);
        avia.add(ticket3);

        int expected = 0;
        int actual = ticket1.compareTo(ticket3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareIfEqual() {
        AviaSouls avia = new AviaSouls();

        avia.add(ticket2);
        avia.add(ticket4);

        int expected = -1;
        int actual = ticket2.compareTo(ticket4);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void sortByPrice() {
        AviaSouls avia = new AviaSouls();

        avia.add(ticket2);
        avia.add(ticket4);
        avia.add(ticket5);


        Ticket[] expected = { ticket2, ticket4, ticket5};
        Ticket[] actual = avia.search("Berlin","Astana");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void findTicket() {
        AviaSouls avia = new AviaSouls();

        avia.add(ticket4);

        Ticket[] expected = { ticket4 };
        Ticket[] actual = avia.search("Berlin", "Astana");


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortFlightTime() {
        AviaSouls avia = new AviaSouls();
        Comparator<Ticket> comparator = new TicketTimeComparator();

        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);


        Ticket[] expected = { ticket2, ticket4, ticket5 };
        Ticket[] actual = avia.searchAndSortBy("Berlin", "Astana", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
