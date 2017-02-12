package com.example.leon.bang;

/**
 * Created by Leon on 2/11/2017.
 */

public class Card {
    private String rank;

    private String suit;
    private int value;

    public String get_rank()
    {
        return rank;
    }

    public String get_suit()
    {
        return suit;
    }

    public int get_value()
    {
        return value;
    }

    public void print()
    {
        // TODO
        // Need to be linked to GUI
        System.out.println(rank + " of " + suit + "\n");
    }

    public Card(String a_rank, String a_suit, int a_value)
    {
        rank = a_rank;
        suit = a_suit;
        value = a_value;
    }
}
