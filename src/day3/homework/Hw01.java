package day3.homework;

import java.util.Random;

public class Hw01 {
    public static void main(String[] args) {
        int player = 3;
        Random r = new Random();
        Suit s = new Suit();
        Number n = new Number();

        String [] displays = { "spades", "hearts", "diamonds", "clubs"};
        int [] numvers = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        int indexDisplays = r.nextInt(4);
        int indexNumber = r.nextInt(13);
        Card [] []cd = new Card[player][2];//3 * 2 //카드 만듬
        for (int i = 0; i < player; i++) {
            for (int j = 0; j < 2; j++) {
                s.display = displays[indexDisplays];
                s.order = indexDisplays + 1;
                n.value = indexNumber + 1;
                Card c = new Card(s,n);
                cd[i][j] = c;
            }
        }
        int [] playerCardType = new int[player];
        int [] playerScore = new int[player];
        Card [] playerMax = new Card[player];
        for (int i = 0; i < player; i++) {

            playerCardType[i] = Math.max(cd[i][0].getSuit().order, cd[i][1].getSuit().order);

            playerScore[i] = Math.max(cd[i][0].getNumber().value, cd[i][1].getNumber().value);
            if(playerCardType[i] == cd[i][0].getSuit().order)
            {
                Card c;
                if(playerScore[i] == cd[i][0].getNumber().value)
                {
                    c = new Card(cd[i][0].getSuit(), cd[i][0].getNumber());
                }
               else {
                    c = new Card(cd[i][1].getSuit(), cd[i][1].getNumber());
                }
                playerMax[i] = c;
            }else {
                Card c;
                if(playerScore[i] == cd[i][1].getNumber().value)
                {
                    c = new Card(cd[i][1].getSuit(), cd[i][1].getNumber());
                }
                else {
                    c = new Card(cd[i][0].getSuit(), cd[i][0].getNumber());
                }
                playerMax[i] = c;
            }
        }//카드뽑기
        int temp = playerMax[0].getNumber().value;
        int winIndex = -1;
        for (int i = 0; i < player; i++) {
            if (playerMax[i].getNumber().value >= temp) {
                temp = playerMax[i].getNumber().value;
                System.out.println(temp);
                winIndex = i;
            }

        }
        System.out.println(winIndex);
    }
}
// spades, hearts, diamonds, clubs
class Suit {
    String display;
    int order;
}
// Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King.
// 1 2 3 ... 11 12 13
class Number {
    int value;
}

class Card {
    private Suit suit;
    private Number number;

    public Card(Suit suit, Number number) {
        this.suit = suit;
        this.number = number;
    }

    public static Card joker() {
        Suit s = new Suit();
        s.display ="joker";
        s.order = 50;
        Number n = new Number();
        n.value = 1000;
        Card c = new Card(s,n);
        return c;//최강값 줌
    }
    public Suit getSuit (){
        return suit;
    }
    public Number getNumber(){
        return number;
    }
}