package co.il.androidapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class LoginFragment extends Fragment {

    public LoginFragment() {
        // Required empty public constructor

    }

    Button signUpBtn;
    Button connectBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_login, container, false);

        signUpBtn=view.findViewById(R.id.LoginPage_signUpBtn);
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_LoginTo_SignUp);
                //Toast.makeText(getContext(),"Clicked",Toast.LENGTH_SHORT).show();
            }
        });
        connectBtn=view.findViewById(R.id.LoginPage_connectButton);
        connectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.actionLoginFragment_ToEventUserList);
            }
        });

        return view;
    }
}