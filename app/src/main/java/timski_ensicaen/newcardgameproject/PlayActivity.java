package timski_ensicaen.newcardgameproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayActivity extends AppCompatActivity {
    int cnt = 1;
    CardDeck mCardDeck = new CardDeck();
    Round mRound = new Round();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        TextView playerOneText = (TextView) findViewById(R.id.text_one);
        TextView playerTwoText = (TextView) findViewById(R.id.text_two);

        changeTextDisplayed(playerOneText, playerTwoText, mRound);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Button pickDeckButtonOne = (Button) findViewById(R.id.pick_from_one);
        pickDeckButtonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView cardImage = (ImageView) findViewById(R.id.image_view_one);
                CardEntity pickedCard = mCardDeck.pickCardEntity();
                if (pickedCard != null) {
                    displayCardEntity(cardImage, pickedCard.getId(), globalValues.customWidth, globalValues.customHeight);
                }
            }
        });

        Button pickDeckButtonTwo = (Button) findViewById(R.id.pick_from_two);
        pickDeckButtonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView cardImage = (ImageView) findViewById(R.id.image_view_two);
                CardEntity pickedCard = mCardDeck.pickCardEntity();
                if (pickedCard != null) {
                    displayCardEntity(cardImage, pickedCard.getId(), globalValues.customWidth, globalValues.customHeight);
                }
            }
        });

        Button pickDiscardButton = (Button) findViewById(R.id.pick_from_discard);
        pickDiscardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView cardImage = (ImageView) findViewById(R.id.image_view_discard);
                CardEntity pickedCard = mCardDeck.pickCardEntityFromDiscard();
                if (pickedCard != null) {
                    displayCardEntity(cardImage, pickedCard.getId(), globalValues.customWidth, globalValues.customHeight);
                }
            }
        });


        Button switchTurnButton = (Button) findViewById(R.id.next_turn_button);
        switchTurnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView playerOneText = (TextView) findViewById(R.id.text_one);
                TextView playerTwoText = (TextView) findViewById(R.id.text_two);
                mRound.changeTurn();
                changeTextDisplayed(playerOneText, playerTwoText, mRound);

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

    public void changeTextDisplayed(TextView mTextView1, TextView mTextView2, Round round)  {
        if (round.getTurn() == Round.PLAYER_ONE_TURN ) {
            mTextView1.setText("PLAYER ONE TURN !!!");
            mTextView2.setText("");
        }
        else {
            mTextView2.setText("PLAYER TWO TURN !!!");
            mTextView1.setText("");
        }
    }


    public void displayCardEntity(ImageView imageView, int i, int customWidth, int customHeight) {
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
