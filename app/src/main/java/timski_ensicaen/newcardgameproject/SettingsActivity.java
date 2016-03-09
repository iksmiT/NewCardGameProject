package timski_ensicaen.newcardgameproject;

import java.util.Locale;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import android.widget.Spinner;
import android.widget.Toast;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.AdapterView.OnItemSelectedListener;




public class SettingsActivity extends AppCompatActivity {

    Locale myLocale;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Spinner spinnerctrl = (Spinner) findViewById(R.id.spinner_language);
        spinnerctrl.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                if (pos == 1) {

                    Toast.makeText(parent.getContext(),
                            R.string.fr_select, Toast.LENGTH_SHORT)
                            .show();
                    setLocale("fr");
                } else if (pos == 2) {

                    Toast.makeText(parent.getContext(),
                            R.string.en_select, Toast.LENGTH_SHORT)
                            .show();
                    setLocale("en");
                }
            }

            public void onNothingSelected(AdapterView<?> parent){
                setLocale("en");
            }
        });


        super.onStart();
    }

    public void setLocale(String lang) {

        myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        finish();
        startActivity(getIntent());
    }
}
