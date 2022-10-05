package ru.netology.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketOffer implements Comparable<TicketOffer>{

    private int id;
    private int price;
    private String airportFrom;
    private String airportTo;
    private int flightTime;

    @Override
    public int compareTo(TicketOffer o) {
        return price - o.price;
    }
  }
