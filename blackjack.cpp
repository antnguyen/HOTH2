#include <iostream>
#include <string>
#include <random>
#include <ctime>

using namespace std;

class card
{
	string rank;
	string suit;
	int value;

	public:
	string get_rank()
	{ return rank;}

	string get_suit()
	{ return suit;}

	int get_value()
	{ return value;}

	void print()
	{ cout<<rank<<" of "<<suit<<endl;}

	card()
	{}

	card(string a_rank, string a_suit, int a_value)
	{
		rank = a_rank;
		suit = a_suit;
		value = a_value;
	}
};

class deck
{
	card a_deck[52];
	int top;

    void swap(int i, int j)
	{
		card temp = a_deck[i];
		a_deck[i] = a_deck[j];
		a_deck[j] = temp;
	}

    public:
	deck()
	{
		string ranks[13] = { "Ace", "King", "Queen", "Jack", "ten", "nine", "eight", "seven", "six", "five", "four", "three", "two" };
		string suits[4] = { "spades", "hearts", "diamonds", "clubs" };
		int values[13] = { 11, 10, 10, 10, 10, 9, 8, 7, 6, 5, 4, 3, 2 };

		for (int i = 0; i < 52; i++)
			a_deck[i] = card(ranks[i % 13], suits[i % 4], values[i % 13]);
		top = 0;
	}

	card deal_card()
	{
		return a_deck[top++];
	}

	void shuffle()
	{
		srand(time(0));
		int n = rand() % 100 + 100;
		for (int i = 0; i < n; i++)
		{
			int number1 = rand() % 52;
			int number2 = rand() % 52;
			swap(number1, number2);
		}
	}
};
