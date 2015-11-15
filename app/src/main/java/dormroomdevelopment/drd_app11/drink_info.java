package dormroomdevelopment.drd_app11;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import components.map.Map1L;
public class drink_info extends Activity {

    private String[] drinks = {"Coors", "Bud" , "Miller" , "Natty"};
    private Map1L<String,String> map = new Map1L<>();
    private ListView listView;
    private void createMap(){
        map.add("Coors", "Coors has 4% alcohol content. It has this type of flavor and the company has this history");
        map.add("Bud", "Coors has 4% alcohol content. It has this type of flavor and the company has this history");
        map.add("Miller", "Coors has 4% alcohol content. It has this type of flavor and the company has this history");
        map.add("Natty", "Coors has 4% alcohol content. It has this type of flavor and the company has this history");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drink_info);
        createMap();
    }
    public void listClick(View v){
        Intent i= new Intent(drink_info.this,Profile.class);
        String key="";
        i.putExtra("key", key);
        i.putExtra("value", map.value(key));
        startActivity(i);
    }

    public void onItemClick(AdapterView<?> parent, View view,
                            int position, long id) {
        listView = (ListView) findViewById(R.id.list);

        // ListView Clicked item value
        String  key    = (String) listView.getItemAtPosition(position);

        Intent i= new Intent(drink_info.this,Profile.class);
        i.putExtra("key", key);
        i.putExtra("value", map.value(key));
        startActivity(i);

    }
}