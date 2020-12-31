package co.il.androidapp.dialog;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.textfield.TextInputEditText;

import co.il.androidapp.R;
import co.il.androidapp.model.ChoreModel;

public class DialogEventMainAc extends DialogFragment{

    private TextInputEditText nameEdit;
    private TextInputEditText detailsEdit;
    private Button saveBtn;
    private Button cancelBtn;
    private int position;
    private onSaveInterface callBack;


    public interface onSaveInterface{
        void onSave(String tag,String name,String details);
    }

    public DialogEventMainAc(Activity activity) {
        super();
        callBack = (onSaveInterface) activity ;
    }


    public static DialogEventMainAc newInstance(int position,Activity activity) {

        DialogEventMainAc frag = new DialogEventMainAc(activity);
        Bundle args = new Bundle();
        args.putInt("title", position);
        frag.setArguments(args);
        return frag;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        position = getArguments().getInt("title");


        switch (position){
            case 1:
                return inflater.inflate(R.layout.pop_fragment_chore,container);
            case 2:
                return inflater.inflate(R.layout.pop_fragment_participant,container);
            default:
                return inflater.inflate(R.layout.pop_fragment_chore,container);
        }



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //get field from view
        nameEdit=  view.findViewById(R.id.AddNewPName);
        detailsEdit =  view.findViewById(R.id.AddNewQuantity);
        saveBtn = view.findViewById(R.id.SaveNewChore);

        cancelBtn = view.findViewById(R.id.CancelNewChore);

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEdit.getText().toString();
                String details = detailsEdit.getText().toString();
                callBack.onSave("Chore",name,details);
                dismiss();
            }
        });
        //Fetch arguments from bundle and set title

        //nameEdit.setText(position + "");
        //getDialog().setTitle(position + "");

        //show soft keyboard automatically and request focus to field
        nameEdit.requestFocus();
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

    }

    @Override
    public void onResume() {
        super.onResume();
        Window window = getDialog().getWindow();
        Point size = new Point();

        Display display = window.getWindowManager().getDefaultDisplay();
        display.getSize(size);

        int width = size.x;

        window.setLayout((int) (width * 0.75), WindowManager.LayoutParams.WRAP_CONTENT);
        window.setGravity(Gravity.CENTER);
    }
}
