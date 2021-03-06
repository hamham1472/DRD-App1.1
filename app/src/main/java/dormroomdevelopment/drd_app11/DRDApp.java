package dormroomdevelopment.drd_app11;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class DRDApp extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Profile profile = new Profile();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drdapp);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        EditText editText = (EditText) findViewById(R.id.user_weight);
        profile.setWeight(Integer.parseInt(editText.getText().toString()));

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


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_drinks) {
            // Handle the camera action
            Intent i= new Intent(DRDApp.this,drink_info.class);
            startActivity(i);
        } else if (id == R.id.nav_pong) {
            EditText editText = (EditText) findViewById(R.id.user_weight);
            profile.setWeight(Integer.parseInt(editText.getText().toString()));
                        Intent i = new Intent(DRDApp.this, Profile.class);
                        i.putExtra("gender", profile.getGender());
                        i.putExtra("weight", profile.getWeight());
                        startActivity(i);
                }else if (id == R.id.nav_profile) {
                    EditText editText = (EditText) findViewById(R.id.user_weight);
                    profile.setWeight(Integer.parseInt(editText.getText().toString()));
            RadioGroup radioGroup=(RadioGroup) findViewById(R.id.RG1);
                    switch (radioGroup.getCheckedRadioButtonId()) {
                        case R.id.radioButton:
                            profile.setGender(0);
                            break;
                        case R.id.radioButton2:
                            profile.setGender(1);
                            break;
                    }
                    Intent i = new Intent(DRDApp.this, Profile.class);
                    i.putExtra("gender", profile.getGender());
                    i.putExtra("weight", profile.getWeight());
                    startActivity(i);

                }

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }

        }