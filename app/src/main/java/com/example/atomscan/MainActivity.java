package com.example.atomscan;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Button scanBtn;
    private  DrawerLayout drawer;
    private  IntentResult intentResult;
    private boolean isClicked = false;

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch(menuItem.getItemId()){
            case R.id.prof:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ProfileFragment()).commit();
                break;
            case R.id.attend:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new AttendanceFragment()).commit();
                break;
            case R.id.about:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new AboutUsFragment()).commit();
                break;
            case R.id.qrscan:
               startActivity(new Intent(getApplicationContext(),MainActivity.class));
                break;
            case R.id.share:
                Toast.makeText(MainActivity.this,"Sharing...",Toast.LENGTH_LONG).show();
                break;
            case R.id.feed:
                Toast.makeText(MainActivity.this,"Getting FeedBack...",Toast.LENGTH_LONG).show();
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scanBtn = (Button) findViewById(R.id.scanBtn);
        scanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isClicked=true;
                IntentIntegrator intentIntegrator = new IntentIntegrator(MainActivity.this);
                intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
                intentIntegrator.setPrompt("Initiating Scan");
                intentIntegrator.setCameraId(0);
                intentIntegrator.setBeepEnabled(true);
                intentIntegrator.setBarcodeImageEnabled(true);
                intentIntegrator.setOrientationLocked(true);
                intentIntegrator.initiateScan();


            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.apptitle3);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        if(savedInstanceState == null){

           navigationView.setCheckedItem(R.id.qrscan);
       }


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

     intentResult = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);


            if(intentResult!=null && resultCode == RESULT_OK) {
                String scantxt = intentResult.getContents().trim();
                if (scantxt != null && !scantxt.isEmpty()) {
                    Toast.makeText(MainActivity.this, scantxt, Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(MainActivity.this, "Failed!!", Toast.LENGTH_LONG);
                }
            }
            else{
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }


    }
}
