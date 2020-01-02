package com.example.practicewater;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView month;
    private Button result;
    private Switch sw;
    boolean isNext=false;
    private String title;
    private double outcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        month =findViewById(R.id.month);
        result = findViewById(R.id.summit);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        sw=findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    isNext=isChecked;
                    TextView tv =findViewById(R.id.type);
                    tv.setText(isNext?getString(R.string.every_other_month):getString(R.string.monthly));
            }
        });
        Button button=findViewById(R.id.summit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title="";
                if(isNext==false){
                float monthn=Float.parseFloat(month.getText().toString());
                outcome=0;
                if(monthn>=1&&monthn<=10){
                    outcome=monthn*7.35f;
                }else if (monthn >= 11 && monthn <= 30) {
                    outcome = (monthn * 9.45f) - 21;
                }else if (monthn >= 31 && monthn <= 50) {
                    outcome = (monthn * 11.55f) - 84;
                }else if (monthn >= 51) {
                    outcome = (monthn * 12.075f) - 110.25f;
                }
                Intent intent =new Intent(MainActivity.this,Result2Activity.class);
                intent.putExtra(getString(R.string.fee),outcome);
                startActivity(intent);
                }
                if (isNext) {
                    float nextn = Float.parseFloat(month.getText().toString());
                    if (nextn >= 1 && nextn <= 20) {
                        outcome = nextn * 7.35f;
                    } else if (nextn >= 21 && nextn <= 60) {
                        outcome = nextn * 9.45f - 42;
                    } else if (nextn >= 61 && nextn <= 100) {
                        outcome = nextn * 11.55f - 168;
                    } else {
                        outcome = nextn * 12.075f - 220.5f;
                    }
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("隔月抄表")
                            .setMessage("費用" + outcome)
                            .setPositiveButton("ok", null)
                            .show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
