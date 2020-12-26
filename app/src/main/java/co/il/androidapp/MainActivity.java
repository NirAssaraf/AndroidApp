package co.il.androidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.io.Serializable;

import co.il.androidapp.model.Event;


public class MainActivity extends AppCompatActivity implements EventListFragment.eventInterface {

    NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        navController = Navigation.findNavController(this, R.id.mainActivityNavHost);
        NavigationUI.setupActionBarWithNavController(this,navController);
    }


    @Override
    public void onItemClickEvent(Event event) {
        Intent intent = new Intent(getBaseContext(), EventMainActivity.class);
        intent.putExtra("TheEvent",  event);
        startActivity(intent);
    }
}