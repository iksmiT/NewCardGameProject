package timski_ensicaen.newcardgameproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PlayActivity extends AppCompatActivity {
    int cnt = 1;
    int customHeight = 96*2;
    int customWidth = 72*2;
    int Min = 1;
    int Max = 52;
    //CardStack mCardStack = new CardStack();

    //CardEntity mCardEntity = new CardEntity(getBaseContext(), 1, true);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

    }

    @Override
    protected void onStart() {
        super.onStart();

        ImageView cardImage = (ImageView) findViewById(R.id.image_card_view_1);
        cardImage.setImageBitmap(
                BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.ace_of_spades_w720, customWidth, customHeight));

        ImageView randCardImage = (ImageView) findViewById(R.id.image_card_view_rand);
        randCardImage.setImageBitmap(
                BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.question_mark, customWidth, customHeight));

        Button pickCardButton = (Button) findViewById(R.id.pick_card_button);
        pickCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView cardImage = (ImageView) findViewById(R.id.image_card_view_1);
                int rndNbr = Min + (int)(Math.random() * ((Max - Min) + 1));
                displayCardEntity(cardImage, rndNbr, customWidth, customHeight);
            }
        });

        Button randCardButton = (Button) findViewById(R.id.rand_card_button);
        randCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView cardImage = (ImageView) findViewById(R.id.image_card_view_rand);
                Log.d("ON_CLICK_RAND", "onClick: ");
                displayCardEntity(cardImage, cnt, customWidth, customHeight);
                Log.d("SET_IMAGE", String.valueOf(cnt));
                cnt++;
                if (cnt > Max) cnt = 1;
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void displayCardEntity(ImageView imageView, int i, int customWidth, int customHeight) {
         Log.d("SWITCH", String.valueOf(i));
        switch (i) {
            case(1) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.ace_of_diamonds_w720, customWidth, customHeight));
                break;
            case(2) :
                imageView.setImageBitmap(BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.two_of_diamonds_w720, customWidth, customHeight));
                break;
            case(3) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.three_of_diamonds_w720, customWidth, customHeight));
                break;
            case(4) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.four_of_diamonds_w720, customWidth, customHeight));
                break;
            case(5) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.five_of_diamonds_w720, customWidth, customHeight));
                break;
            case(6) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.six_of_diamonds_w720, customWidth, customHeight));
                break;
            case(7) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.seven_of_diamonds_w720, customWidth, customHeight));
                break;
            case(8) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.eight_of_diamonds_w720, customWidth, customHeight));
                break;
            case(9) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.nine_of_diamonds_w720, customWidth, customHeight));
                break;
            case(10) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.ten_of_diamonds_w720, customWidth, customHeight));
                break;
            case(11) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.jack_of_diamonds_w720, customWidth, customHeight));
                break;
            case(12) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.queen_of_diamonds_w720, customWidth, customHeight));
                break;
            case(13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.king_of_diamonds_w720, customWidth, customHeight));
                break;
            case(1+13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.ace_of_spades_w720, customWidth, customHeight));
                break;
            case(2+13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.two_of_spades_w720, customWidth, customHeight));
                break;
            case(3+13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.three_of_spades_w720, customWidth, customHeight));
                break;
            case(4+13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.four_of_spades_w720, customWidth, customHeight));
                break;
            case(5+13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.five_of_spades_w720, customWidth, customHeight));
                break;
            case(6+13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.six_of_spades_w720, customWidth, customHeight));
                break;
            case(7+13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.seven_of_spades_w720, customWidth, customHeight));
                break;
            case(8+13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.eight_of_spades_w720, customWidth, customHeight));
                break;
            case(9+13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.nine_of_spades_w720, customWidth, customHeight));
                break;
            case(10+13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.ten_of_spades_w720, customWidth, customHeight));
                break;
            case(11+13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.jack_of_spades_w720, customWidth, customHeight));
                break;
            case(12+13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.queen_of_spades_w720, customWidth, customHeight));
                break;
            case(13+13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.king_of_spades_w720, customWidth, customHeight));
                break;
            case(1+2*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.ace_of_clubs_w720, customWidth, customHeight));
                break;
            case(2+2*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.two_of_clubs_w720, customWidth, customHeight));
                break;
            case(3+2*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.three_of_clubs_w720, customWidth, customHeight));
                break;
            case(4+2*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.four_of_clubs_w720, customWidth, customHeight));
                break;
            case(5+2*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.five_of_clubs_w720, customWidth, customHeight));
                break;
            case(6+2*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.six_of_clubs_w720, customWidth, customHeight));
                break;
            case(7+2*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.seven_of_clubs_w720, customWidth, customHeight));
                break;
            case(8+2*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.eight_of_clubs_w720, customWidth, customHeight));
                break;
            case(9+2*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.nine_of_clubs_w720, customWidth, customHeight));
                break;
            case(10+2*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.ten_of_clubs_w720, customWidth, customHeight));
                break;
            case(11+2*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.jack_of_clubs_w720, customWidth, customHeight));
                break;
            case(12+2*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.queen_of_clubs_w720, customWidth, customHeight));
                break;
            case(13+2*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.king_of_clubs_w720, customWidth, customHeight));
                break;
            case(1+3*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.ace_of_hearts_w720, customWidth, customHeight));
                break;
            case(2+3*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.two_of_hearts_w720, customWidth, customHeight));
                break;
            case(3+3*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.three_of_hearts_w720, customWidth, customHeight));
                break;
            case(4+3*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.four_of_hearts_w720, customWidth, customHeight));
                break;
            case(5+3*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.five_of_hearts_w720, customWidth, customHeight));
                break;
            case(6+3*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.six_of_hearts_w720, customWidth, customHeight));
                break;
            case(7+3*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.seven_of_hearts_w720, customWidth, customHeight));
                break;
            case(8+3*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.eight_of_hearts_w720, customWidth, customHeight));
                break;
            case(9+3*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.nine_of_hearts_w720, customWidth, customHeight));
                break;
            case(10+3*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.ten_of_hearts_w720, customWidth, customHeight));
                break;
            case(11+3*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.jack_of_hearts_w720, customWidth, customHeight));
                break;
            case(12+3*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.queen_of_hearts_w720, customWidth, customHeight));
                break;
            case(13+3*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.king_of_hearts_w720, customWidth, customHeight));
                break;
        }
    }
}
