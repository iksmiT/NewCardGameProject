package timski_ensicaen.newcardgameproject;

/**
 * Created by Timothy Vongsana on 05/03/2016.
 */

import android.content.Context;
import android.content.ContextWrapper;

public class CardEntity extends ContextWrapper {
    private int id;
    private boolean free = true;


    public CardEntity(Context base, int a, boolean bool) {
        super(base);
        this.id = a;
        this.free = bool;
    }

    public CardEntity(Context base, int a) {
        super(base);
        this.id = a;
        this.free = true;
    }
}
