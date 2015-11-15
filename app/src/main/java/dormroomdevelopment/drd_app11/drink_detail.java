package dormroomdevelopment.drd_app11;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import components.map.Map1L;

public class drink_detail extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drink_detail);


        Intent i = getIntent();
        String key = i.getStringExtra("key");
        String value = i.getStringExtra("value");

        TextView textView1 = (TextView) findViewById(R.id.textView1);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView1.setText(key);
        textView2.setText(value);
    }


}