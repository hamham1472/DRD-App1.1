package dormroomdevelopment.drd_app11;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.ViewSwitcher;
import android.content.Intent;

public class DRDApp extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drdapp);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setProgress(0);




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drdapp, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public double amountToAdd(int gender, double weight) {
        // convert weight from lbs to grams
        weight = weight * 453.592;

        // Constant for Male/Female
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
                progressBar.setProgress(progressBar.getProgress()+100);
                break;
            case R.id.button2:
                progressBar.setProgress(progressBar.getProgress()+100);
                // do something else
                break;
            case R.id.button3:
                progressBar.setProgress(progressBar.getProgress()+100);
                // i'm lazy, do nothing
                break;
        }


    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_drinks) {
            // Handle the camera action
            Intent i= new Intent(DRDApp.this,Profile.class);
            startActivity(i);
        } else if (id == R.id.nav_pong) {
            Intent i= new Intent(DRDApp.this,Profile.class);
            startActivity(i);
        } else if (id == R.id.nav_profile) {
            Intent i= new Intent(DRDApp.this,Profile.class);
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}