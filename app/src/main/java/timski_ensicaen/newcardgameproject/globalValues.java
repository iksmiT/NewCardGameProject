package timski_ensicaen.newcardgameproject;

public class globalValues {

    public static final int customHeight = 96 * 2;
    public static final int customWidth = 72 * 2;
    public static final int Min = 1;
    public static final int Max = 52;

    public static int rndFunction(int min, int max) {
        return min+(int)(Math.random()*((max-min)+1));
    }


}
