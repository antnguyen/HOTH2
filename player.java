public class Player
{
	String name;
	double cash;
	double bet;
	Vector<card> hand;

	public Player(double the_cash)
	{
		cash = the_cash;
		bet = 0;
	}

	public void clear()
	{
		hand.clear();
	}
    
    public void setName(String aName) {
        name = aName;
    }
    
    public void getName() {
        return name;
    }

	public void setCash(double a_cash)
	{
		cash = a_cash;
	}

	public void setBet(double a_bet)
	{
		bet = a_bet;
	}

	public double getCash()
	{
		return cash;
	}

	public double getBet()
	{
		return bet;
	}

	public void hit(card c)
	{
		hand.addElement(c);
	}

	public int total_hand()
	{
		int count = 0;
		for (int i = 0; i < hand.size(); i++)
		{
			card c = hand.get(i);
			count = count + c.getValue();
		}
		return count;
	}
    
    public int manyCards(){
        return hand.size();
    }
};