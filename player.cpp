#include <iostream>
#include <string>
#include <vector>
#include <cstdlib>
#include <ctime>
#include "blackjack.cpp"

using namespace std;

class player
{
	string name;
	double cash;
	double bet;
	vector<card> hand;

	public:
	player(double the_cash)
	{
		cash = the_cash;
		bet = 0;
	}

	void clear()
	{
		while (!hand.empty())
		{
			hand.pop_back();
		}
	}

	void set_cash(double a_cash)
	{
		cash = a_cash;
	}

	void set_bet(double a_bet)
	{
		bet = a_bet;
	}

	double get_cash()
	{
		return cash;
	}

	double get_bet()
	{
		return bet;
	}

	void hit(card c)
	{
		hand.push_back(c);
	}

	int total_hand()
	{
		int count = 0;
		for (int i = 0; i < hand.size(); i++)
		{
			card c = hand[i];
			count = count + c.get_value();
		}
		return count;
	}
};

int main()
{
	player me(1000), dealer(0);
	deck my_deck;
	
	cout << "New game? (Y/N) ";
	string a;
	cin >> a;
	while (a == "Y")
	{
		cout << "You have " << me.get_cash() << endl << "How much do you want to bet? ";
		double bet;
		cin >> bet;
		me.set_bet(bet);
		my_deck.shuffle();
		card c = my_deck.deal_card();
		cout << "Your first card is ";
		c.print();
		me.hit(c);

		c = my_deck.deal_card();
		cout << "Dealer showing: ";
		c.print();
		dealer.hit(c);

		c = my_deck.deal_card();
		cout << "Your second card is ";
		c.print();
		me.hit(c);

		c = my_deck.deal_card();
		dealer.hit(c);

		card dealer_hold_card = c;

		string answer;
		cout << "more cards? ";
		cin >> answer;
		while (answer == "yes")
		{
			//get more cards
			c = my_deck.deal_card();
			cout << "Your next card is ";
			c.print();
			me.hit(c);
			cout << "more cards? ";
			cin >> answer;
		}
		cout << "Dealer showing: ";
		dealer_hold_card.print();
		while (dealer.total_hand() < 17)
		{
			//get more cards
			c = my_deck.deal_card();
			dealer.hit(c);
			cout << "Dealer showing: ";
			c.print();
		}
		if (me.total_hand() <= 21)
		{
			if (me.total_hand() == dealer.total_hand())
				cout << "Noob" << endl;
			else if (me.total_hand() < dealer.total_hand() && dealer.total_hand() <= 21)
			{
				me.set_cash(me.get_cash() - me.get_bet());
				cout << "You lost!" << endl << "You have " << me.get_cash() << endl;
			}
			else
			{
				me.set_cash(me.get_cash() + me.get_bet());
				cout << "You win!" << endl << "You have " << me.get_cash() << endl;
			}
		}
		else
		{
			me.set_cash(me.get_cash() - me.get_bet());
			cout << "You lost!" << endl << "You have " << me.get_cash() << endl;
		}
		//clear the hands
		me.clear();
		dealer.clear();
		cout << "New game? (Y/N) ";
		cin >> a;
	}
    return 0;
}

/* Output:
New game? (Y/N) Y
You have 1000
How much do you want to bet? 10
Your first card is eight of hearts
Dealer showing: seven of hearts
Your second card is Queen of hearts
more cards? no
Dealer showing: Queen of diamonds
You win!
You have 1010
New game? (Y/N) Y
You have 1010
How much do you want to bet? 50
Your first card is Queen of diamonds
Dealer showing: ten of diamonds
Your second card is Ace of hearts
more cards? no
Dealer showing: two of diamonds
Dealer showing: ten of spades
You win!
You have 1060
New game? (Y/N) N
Press any key to continue . . .
*/