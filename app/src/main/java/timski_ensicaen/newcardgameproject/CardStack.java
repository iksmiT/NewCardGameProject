package timski_ensicaen.newcardgameproject;

import android.content.Context;

/**
 * Created by Timothy Vongsana on 05/03/2016.
 */
public class CardStack {
    private CardEntity[] stack;

    public CardStack(Context base) {
        for (int i = 1;i<52; i++) stack[i] = new CardEntity(base, i);
    }
}
