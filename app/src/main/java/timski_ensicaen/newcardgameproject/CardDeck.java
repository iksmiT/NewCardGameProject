package timski_ensicaen.newcardgameproject;

import android.util.Log;

import java.util.Collections;
import java.util.Vector;


public class CardDeck {
    private Vector<CardEntity> avail_deck= new Vector<>(globalValues.Max,1);
    private Vector<CardEntity> unavail_deck =  new Vector<>(0,1);
    private Vector<CardEntity> player_one_deck =  new Vector<>(0,1);
    private Vector<CardEntity> player_two_deck =  new Vector<>(0,1);

    public CardDeck() {
        for (int i=0;i<globalValues.Max; i++) {
                avail_deck.addElement(new CardEntity(i+1));
        }
        Collections.shuffle(avail_deck);
        for (int i=0;i<globalValues.Max/2; i++) {
            this.player_one_deck.addElement(new CardEntity(i+1));
        }
        for (int j=0;j<globalValues.Max/2; j++) {
            this.player_two_deck.addElement(new CardEntity(j+1+globalValues.Max/2));
        }
        Collections.shuffle(player_one_deck);
        Collections.shuffle(player_two_deck);
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

    public CardEntity pickCardEntity(Vector<CardEntity> cardDeck) {
        if (cardDeck.size() > 0) {
            CardEntity tmpCard = cardDeck.lastElement();
            this.unavail_deck.addElement(cardDeck.remove(cardDeck.size()-1));
            return tmpCard;
        }
        else return null;
    }
}

