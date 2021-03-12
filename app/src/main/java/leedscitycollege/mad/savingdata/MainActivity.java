package leedscitycollege.mad.savingdata;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);


        // Restore preferences
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        boolean silent = settings.getBoolean("message", false);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.title);
        if (silent==true) {
            textView.setText("Hello");
        }else{
            textView.setText("Goodbye");
        }
       // setSilent(silent);
    }

        @Override
    protected void onStop(){
        super.onStop();

        // We need an Editor object to make preference changes.
        // All objects are from android.context.Context
            SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
            SharedPreferences.Editor editor = settings.edit();
            boolean silent = settings.getBoolean("message", false);
            if(silent==true) {
                editor.putBoolean("message", false);
            }else{
                editor.putBoolean("message", true);
            }

            // Commit the edits!
        editor.commit();
    }
}
