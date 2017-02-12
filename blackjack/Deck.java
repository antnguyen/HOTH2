package an.blackjack;

/**
 * Created by Leon on 2/11/2017.
 */

import java.util.Random;

public class Deck {
    private Card[] a_deck = new Card[52];
    private int top;

    private void swap(int i, int j)
    {
        Card temp = a_deck[i];
        a_deck[i] = a_deck[j];
        a_deck[j] = temp;
    }

    public Deck()
    {
        String[] ranks = {"Ace", "King", "Queen",
                "Jack", "ten", "nine", "eight", "seven",
                "six", "five", "four", "three", "two"};

        String[] suits = {"spades", "hearts", "diamonds", "clubs"};

        int[] values = {11, 10, 10, 10, 10, 9, 8, 7, 6, 5, 4, 3, 2};

        for (int i = 0; i < 52; i++)
        {
            a_deck[i] = new Card(ranks[i%13], suits[i%4], values[i%13]);
        }
        top = 0;
    }

    public Card deal_card()
    {
        return a_deck[top++];
    }

    public void shuffle()
    {
        Random rand = new Random();
        // shuffle 100+ times
        int n = rand.nextInt(100) + 100;
        for (int i = 0; i < n; i++ )
        {
            // choose two random cards
            int number1 = rand.nextInt(52);
            int number2 = rand.nextInt(52);
            swap(number1, number2);
        }
    }
}
