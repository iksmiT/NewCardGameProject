package timski_ensicaen.newcardgameproject;

import android.graphics.Bitmap;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PlayActivity extends AppCompatActivity {
    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        Button pickCardButton = (Button) findViewById(R.id.pick_card_button);
        pickCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag == 0) {
                    ImageView cardImage = (ImageView) findViewById(R.id.image_card_view_1);
                    cardImage.setImageResource(R.drawable.ace_of_diamonds_w720);
                    flag = 1;
                }
                else {
                    ImageView cardImage = (ImageView) findViewById(R.id.image_card_view_1);
                    cardImage.setImageResource(R.drawable.ace_of_clubs_w720);
                    flag = 0;
                }
            }
        });
    }
}

