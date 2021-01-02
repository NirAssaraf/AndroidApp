package co.il.androidapp;


import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.EventLog;
import android.view.WindowManager;
import android.widget.Toast;

import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

import co.il.androidapp.ChoresFragment;
import co.il.androidapp.EventDetailsFragment;
import co.il.androidapp.ParticipantsFragment;
import co.il.androidapp.R;
import co.il.androidapp.dialog.DialogEventMainAc;
import co.il.androidapp.model.Chore;
import co.il.androidapp.model.ChoreModel;
import co.il.androidapp.model.Event;
import co.il.androidapp.model.Product;
import co.il.androidapp.model.ProductModel;


public class EventMainActivity extends AppCompatActivity implements DialogEventMainAc.onSaveInterface{

    private EventDetailsFragment fra1;
    private ProductFragment fra2;
    private ChoresFragment fra3;
    private ParticipantsFragment fra4;
    int fragmentIndex;
    Event event;


    NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException ignored){}

        event = (Event) getIntent().getSerializableExtra("TheEvent");
        Toast.makeText(this, event.getPosition()+"", Toast.LENGTH_LONG).show();


        setContentView(R.layout.evant_main_activitiy);


        fra1 = new EventDetailsFragment();
        fra2 = new ProductFragment();
        fra3 = new ChoresFragment();
        fra4 = new ParticipantsFragment();
        fragmentIndex=0;

        SpaceNavigationView spaceNavigationView= findViewById(R.id.space);
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);
        spaceNavigationView.showIconOnly();
        spaceNavigationView.setCentreButtonColor(ContextCompat.getColor(this, R.color.backNavColor));
        spaceNavigationView.setCentreButtonIcon(R.drawable.ic_add);
        spaceNavigationView.addSpaceItem(new SpaceItem("HOME", R.drawable.ic_home));
        spaceNavigationView.addSpaceItem(new SpaceItem("Products", R.drawable.ic_shop));
        spaceNavigationView.addSpaceItem(new SpaceItem("Chores", R.drawable.ic_check));
        spaceNavigationView.addSpaceItem(new SpaceItem("Users", R.drawable.ic_people));

        spaceNavigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                switch (fragmentIndex) {
                    case 0: {
                        //setFragment(fra2);
                        return;
                    }
                    case 1: {
                       //setFragment(fra3);
                        showEditDialog(2);
                        return;
                    }
                    case 2: {
                       // setFragment(fra4);
                        showEditDialog(1);
                        return;
                    }
                    case 3: {
                        //setFragment(fra1);


                        return;
                    }
                    default:

                }
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
                switch (itemIndex){
                    case 0: {
                        setFragment(fra1);
                        fragmentIndex=0;
                        return;
                    }
                    case 1: {
                        setFragment(fra2);
                        fragmentIndex=1;
                        return;
                    }
                    case 2: {
                        setFragment(fra3);
                        fragmentIndex=2;
                        return;
                    }
                    case 3: {
                        setFragment(fra4);
                        fragmentIndex=3;
                        return;
                    }
                    default: {
                        setFragment(fra1);
                        fragmentIndex=0;
                    }

                }

            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {
                switch (itemIndex){
                    case 0: {
                        setFragment(fra1);
                        fragmentIndex=0;
                        return;
                    }
                    case 1: {
                        setFragment(fra2);
                        fragmentIndex=1;
                        return;
                    }
                    case 2: {
                        setFragment(fra3);
                        fragmentIndex=2;
                        return;
                    }
                    case 3: {
                        setFragment(fra4);
                        fragmentIndex=3;
                        return;
                    }
                    default: {
                        setFragment(fra1);
                        fragmentIndex=0;
                    }

                }
            }
        });


    }

private void showEditDialog(int flag){

    FragmentManager fm =getSupportFragmentManager();
    DialogEventMainAc dialogEventMainAc = DialogEventMainAc.newInstance(flag,this);
    if (flag==1) {
        dialogEventMainAc.show(fm, "pop_fragment_chore");
        dialogEventMainAc.setTag("Chore");
    }
    else {
        dialogEventMainAc.show(fm, "pop_fragment_product");
        dialogEventMainAc.setTag("Product");
    }


}


    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout1,fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onSave(String tag, String name, String details) {

        switch(tag) {

            case "Chore":
                ChoreModel.instance.addChore(new Chore(name, details));
                return;
            case "Product":
                ProductModel.instance.addProduct(new Product(name,details));
        }

    }

    public void updateDataChoreFragment(ChoresFragment fragment)
    {
        if (fragment!=null){
            fragment.updateData();
        }

    }

}