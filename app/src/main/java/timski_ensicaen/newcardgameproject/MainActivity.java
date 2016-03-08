package timski_ensicaen.newcardgameproject;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    final int sdk = android.os.Build.VERSION.SDK_INT;
    int customHeight = 96*2;
    int customWidth = 72*2;
    boolean click = true;
    PopupWindow popUp;
    RelativeLayout mainLayout;
    ViewGroup.LayoutParams params;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    @Override
    protected void onStart() {
        super.onStart();

        mContext = this;
        mainLayout = (RelativeLayout) findViewById(R.id.main_relative_layout);
        Bitmap BackgroundBitmap = BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.background_ace, customWidth, customHeight);
        Drawable BackgroundDrawable = new BitmapDrawable(getResources(), BackgroundBitmap);
        Button rulesButton = (Button) findViewById(R.id.rules_button);
        popUp = new PopupWindow(this);

        if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            mainLayout.setBackgroundDrawable(BackgroundDrawable);
        } else {
            mainLayout.setBackgroundDrawable(BackgroundDrawable);
        }

        rulesButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new AlertDialog.Builder(mContext)
                        .setTitle("Delete entry")
                        .setMessage("Are you sure you want to delete this entry?")

                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // continue with delete
                            }
                        })
                        .show();
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

    public void playButton(View view) {
        Intent intent = new Intent(this, PlayActivity.class);
        startActivity(intent);
    }

    public void settingsButton(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}
