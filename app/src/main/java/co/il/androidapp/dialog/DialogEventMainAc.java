package co.il.androidapp.dialog;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import co.il.androidapp.R;

public class DialogEventMainAc extends DialogFragment{

    private EditText nameEdit;
    private EditText detailsEdit;
    private int position;
    public DialogEventMainAc() {
        super();

    }


    public static DialogEventMainAc newInstance(int position) {

        DialogEventMainAc frag = new DialogEventMainAc();
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
                return inflater.inflate(R.layout.pop_fragment_product,container);
            default:
                return inflater.inflate(R.layout.pop_fragment_chore,container);
        }

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //get field from view
        nameEdit=(EditText) view.findViewById(R.id.AddNewPName);

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
