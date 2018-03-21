package sritan1.th.ac.ms.sritan1readcode.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import sritan1.th.ac.ms.sritan1readcode.MainActivity;
import sritan1.th.ac.ms.sritan1readcode.R;
import sritan1.th.ac.ms.sritan1readcode.utility.MyAlert;

/**
 * Created by asus on 3/21/2018.
 */

public class RegisterFragment extends Fragment{

//  Exp
private  String nameString, userString, passwordString;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



//        Create Toolbar
        createToolbar();

//        Register Controller
        registerController();

    } // Main Method

    private void registerController() {
        Button button = getActivity().findViewById(R.id.btnRegister);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Get Value From EditText
                EditText nameEditText = getView().findViewById(R.id.edtNameame);
                EditText UserEditText = getView().findViewById(R.id.edtUser);
                EditText PasswordEdiText = getView().findViewById(R.id.edtPassword);



//                Change Editext to string

                nameString = nameEditText.getText().toString().trim();
                userString = UserEditText.getText().toString().trim();
                passwordString = PasswordEdiText.getText().toString().trim();

//                Check Space
                if (nameString.isEmpty() || userString.isEmpty() || passwordString.isEmpty()) {
//                   Have Space
                    MyAlert myAlert = new MyAlert(getActivity());
                    myAlert.myDialog("Have Space", "Please Fill All Blank");
                } else {
//                    No Space
                }


            }
        });
    }

    private void createToolbar() {
        Toolbar toolbar = getView().findViewById(R.id.toobarRegister);

        ((MainActivity)getActivity()).setSupportActionBar(toolbar);

//        Setup Title
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Register");

//  Show Navigator Icon
        ((MainActivity)getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        return view;
    }
} //Main Class

