package timski_ensicaen.newcardgameproject;

import android.util.Log;

import java.util.Collections;
import java.util.Vector;


public class CardDeck {
    private Vector<CardEntity> avail_deck= new Vector<>(globalValues.Max,1);
    private Vector<CardEntity> unavail_deck =  new Vector<>(0,1);
    private Vector<CardEntity> player_one_deck =  new Vector<>(0,1);
    private Vector<CardEntity> player_two_deck =  new Vector<>(0,1);
    private int cnt;

    public CardDeck() {
        for (int i=0;i<globalValues.Max; i++) {
                avail_deck.addElement(new CardEntity(i+1));
        }
        cnt = globalValues.Max;
        Collections.shuffle(avail_deck);
        for (int i=0;i<globalValues.Max/4; i++) {
            this.player_one_deck.addElement(new CardEntity(i+1));
        }
        for (int j=0;j<globalValues.Max/4; j++) {
            this.player_two_deck.addElement(new CardEntity(j+1+globalValues.Max/2));
        }
        //Collections.shuffle(player_one_deck);
        //Collections.shuffle(player_two_deck);
        player_one_deck.add(0, new CardEntity(1));
        player_two_deck.add(0, new CardEntity(2));
        player_one_deck.add(1, new CardEntity(1));
        player_two_deck.add(1, new CardEntity(2));
    }
    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public Vector<CardEntity> getAvail_deck() {
        return avail_deck;
    }

    public Vector<CardEntity> getPlayer_one_deck() {
        return player_one_deck;
    }

    public Vector<CardEntity> getPlayer_two_deck() {
        return player_two_deck;
    }

    public CardEntity pickCardEntity() {
        if (this.avail_deck.size() > 0) {
            //int rnd = globalValues.rndFunction(globalValues.Min, this.avail_deck.size()) - 1;
            //CardEntity tmpCard = avail_deck.get(rnd);
            CardEntity tmpCard = avail_deck.lastElement();
            //this.unavail_deck.addElement(this.avail_deck.remove(rnd));
            this.unavail_deck.addElement(this.avail_deck.remove(avail_deck.size()-1));
            return tmpCard;
        }
        else return null;
    }

    public CardEntity pickRandomCardEntity() {
        if (this.avail_deck.size() > 0) {
            //int rnd = globalValues.rndFunction(globalValues.Min, this.avail_deck.size()) - 1;
            //CardEntity tmpCard = avail_deck.get(rnd);
            CardEntity tmpCard = avail_deck.lastElement();
            //this.unavail_deck.addElement(this.avail_deck.remove(rnd));
            this.unavail_deck.addElement(this.avail_deck.remove(avail_deck.size()-1));
            return tmpCard;
        }
        else return null;
    }

    public CardEntity pickCardEntity(Vector<CardEntity> cardDeck) {
        if (cardDeck.size() > 0) {
            CardEntity tmpCard = cardDeck.lastElement();
            this.unavail_deck.addElement(cardDeck.remove(cardDeck.size()-1));
            return tmpCard;
        }
        else return null;
    }

    public void pickCardEntityFromDiscard() {
        if (this.unavail_deck.size() > 0) {
            //int rnd = globalValues.rndFunction(globalValues.Min, this.unavail_deck.size()) - 1;
            CardEntity tmpCard = unavail_deck.lastElement();
            this.avail_deck.insertElementAt(this.unavail_deck.remove(unavail_deck.size() - 1), 0);
        }
    }

    public CardEntity pickCardEntityFromDiscard(int i) {
        while (this.unavail_deck.size() > 0) {
            if (i == Round.PLAYER_ONE_WINS) {
                this.player_one_deck.insertElementAt(this.unavail_deck.remove(0), 0);
            }
            else if (i == Round.PLAYER_TWO_WINS) {
                this.player_two_deck.insertElementAt(this.unavail_deck.remove(0), 0);
            }
        }
        return null;
    }
}

