import java.util.*;

//Write a Program DeckOfCards.java, to initialize deck of cards having suit
//		("Clubs", "Diamonds", "Hearts", "Spades") & Rank ("2", "3", "4", "5", "6", "7", "8",
//		"9", "10", "Jack", "Queen", "King", "Ace"). Shuffle the cards using Random
//		method and then distribute 9 Cards to 4 Players and Print the Cards received by
//		the 4 Players using 2D Array...Extend the above program to create a Player Object having Deck of Cards, and
//		having ability to Sort by Rank and maintain the cards in a Queue implemented
//		using Linked List. Do not use any Collection Library. Further the Players are also
//		arranged in Queue. Finally Print the Player and the Cards received by each
//		Player.

public class DeckOfCards{
	public static void main(String[] args){
		ArrayList<Player> queue=new ArrayList<>();
		Player p1= new Player();
		queue.add(p1);
		Player p2= new Player();
		queue.add(p2);
		Player p3= new Player();
		queue.add(p3);
		Player p4= new Player();
		queue.add(p4);

		for (int i=0;i<3;i++){
			p1.addCards();
			p2.addCards();
			p3.addCards();
			p4.addCards();
		}
		int i=1;
		for(Player p: queue){
			System.out.print("Player " +i+ " got : ");
			i++;
			p.printCards();
		}

		System.out.println();
		for (Player p: queue){
			p.sort();
		}
		i=1;
		for(Player p: queue){
			System.out.print("Player " + i+ " got : ");
			p.printCards();
			i++;
		}
	}
}
class Pair{
	String suit,rank;
	Pair(String s,String r){
		suit = s;
		rank = r;
	}
}
class Player{
	ArrayList<Pair> queue;
	String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
	String[] rank = {"2", "3", "4", "5", "6", "7", "8","9", "10", "Jack", "Queen", "King", "Ace"};
	Player(){
		queue = new ArrayList<>();
	}
	public void addCards(){
		int suitChosen = (int)Math.floor(Math.random()*10)%4;
		int rankChosen = (int)Math.floor(Math.random()*10)%13;
		queue.add(new Pair(suits[suitChosen],rank[rankChosen]));
	}
	public int getIndex(String s){
		for(int i=0;i<rank.length;i++){
			if(s.equals(rank[i])){
				return i;
			}
		}
		return -1;
	}
	public void sort(){
		Collections.sort(queue, new Comparator<Pair>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				return Integer.compare(getIndex(p1.rank),getIndex(p2.rank));
			}
		});
	}
	public void printCards(){
		for(Pair p: queue){
			System.out.print(p.rank+" of "+p.suit+" , ");
		}
		System.out.println();
	}
}