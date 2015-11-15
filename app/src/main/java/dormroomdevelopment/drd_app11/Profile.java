package dormroomdevelopment.drd_app11;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by kyrne_000 on 11/14/2015.
 */
public class Profile extends Activity{
    private int gender = 1;
    private int weight = 80;
    private ProgressBar progressBar;

    public void setGender(View v){
        EditText weightEdit = (EditText) findViewById(R.id.user_weight);
        this.gender = Integer.parseInt(weightEdit.getText().toString());

    }

    public void setWeight(View v){
        EditText weightEdit = (EditText) findViewById(R.id.user_weight);
        this.weight = Integer.parseInt(weightEdit.getText().toString());
    }

    public void setGender(int gender){
        this.gender = gender;
    }

    public int getGender(){
        return this.gender;
    }


    public void setWeight(int weight){
        this.weight = weight;
    }

    public int getWeight(){
        return this.weight;
    }

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_layout);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setProgress(0);

            Intent i = getIntent();
        this.weight = i.getIntExtra("weight",this.weight);
        this.gender = i.getIntExtra("gender",this.gender);


    }
    public double amountToAdd(int gender, double weight) {
        // convert weight from lbs to grams
        weight = weight * 453.592;

        // Constant for Male or Female
        double A = 0.68;
        if (gender == 1) {
            A = .55;
        }

        // calc percent added to BAC
        double gramsAlc = 14;
        double bacPerDrink = gramsAlc / (weight * A) * 100;

        // percent added changed to points (out of 1000 max = .1%;

        return 10000 * bacPerDrink;
    }

    public void takeADrink(View v){
        switch (v.getId()) {
            case R.id.button:
                progressBar.setProgress(progressBar.getProgress()+(int)amountToAdd(this.getGender(), this.getWeight()));
                break;
            case R.id.button2:
                progressBar.setProgress(progressBar.getProgress()+(int)amountToAdd(this.getGender(), this.getWeight()));
                break;
            case R.id.button3:
                progressBar.setProgress(progressBar.getProgress()+(int)amountToAdd(this.getGender(), this.getWeight()));
                break;
        }
        String message;

        if(progressBar.getProgress()<500){
            message = "Good to keep going";
        } else if (progressBar.getProgress()<700){
            message = "Getting close to legal limit";
        } else if (progressBar.getProgress()<900){
            message = "About legal limit, consider stopping";
        }
        else{
            message = "You are probably drunk";
        }
        Toast myToast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG);
        myToast.show();


    }

}
