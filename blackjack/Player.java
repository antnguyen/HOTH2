package an.blackjack;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.*;

public class Player implements Serializable
{
	String name;
	int cash;
	int bet;
	Vector<Card> hand;
	private int mData;

	public Player() {
		name = "Human";
		cash = 1000;
		bet = 0;
	}

	public Player(String aName, int the_cash) {
		name = aName;
		cash = the_cash;
		bet = 0;
	}

	public void clear() {
		hand.clear();
	}
    
    public void setName(String aName) {
        name = aName;
    }
    
    public String getName() {
        return name;
    }

	public void setCash(int a_cash)
	{
		cash = a_cash;
	}

	public void setBet(int a_bet)
	{
		bet = a_bet;
	}

	public int getCash()
	{
		return cash;
	}

	public int getBet()
	{
		return bet;
	}

	public void hit(Card c)
	{
		hand.addElement(c);
	}

	public int total_hand()
	{
		int count = 0;
		for (int i = 0; i < hand.size(); i++)
		{
			Card c = hand.get(i);
			count = count + c.get_value();
		}
		return count;
	}
    
    public int manyCards(){
        return hand.size();
    }


};