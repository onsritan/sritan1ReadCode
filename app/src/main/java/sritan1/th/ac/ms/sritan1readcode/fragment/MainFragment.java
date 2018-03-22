package sritan1.th.ac.ms.sritan1readcode.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import sritan1.th.ac.ms.sritan1readcode.R;
import sritan1.th.ac.ms.sritan1readcode.utility.GetAllUser;
import sritan1.th.ac.ms.sritan1readcode.utility.MyAlert;
import sritan1.th.ac.ms.sritan1readcode.utility.MyConstant;

/**
 * Created by asus on 3/20/2018.
 */

public class MainFragment extends Fragment{

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

// Register Controller
        registerController();


//        Login Controller
        loginController();


    } //Main Method

    private void loginController() {
        Button button = getView().findViewById(R.id.btnLogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText userEditText = getView().findViewById(R.id.edtUser);
                EditText passwordEditText = getView().findViewById(R.id.edtPassword);

                String userSting = userEditText.getText().toString().trim();
                String passwordSting = passwordEditText.getText().toString().trim();

                if (userSting.isEmpty()|| passwordSting.isEmpty())  {
//                    Have Space
                    MyAlert myAlert = new MyAlert(getActivity());
                    myAlert.myDialog(getString(R.string.have_space),
                            getString(R.string.message_have_space));

                } else {
//                    No Space
                    try {

                        MyConstant myConstant = new MyConstant();
                        GetAllUser getAllUser = new GetAllUser(getActivity());
                        getAllUser.execute(myConstant.getUrlGetAllUserString());

                        String jsonString = getAllUser.get();
                        Log.d("22MarchV1", "JSON ==> " + jsonString);

                        String[] columnUserString = myConstant.getLoginStrings();
                        String[] loginStrings = new String[columnUserString.length];
                        Boolean statusBool = true;

                        JSONArray jsonArray = new JSONArray(jsonString);

                        for (int i=0; i<jsonArray.length(); i+=1) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            if (userSting.equals(jsonObject.getString(columnUserString[2]))) {
                                statusBool = false;
                                for (int i1=0; i1<columnUserString.length; i1+=1) {
                                    loginStrings[i1] = jsonObject.getString(columnUserString[i1]);
                                    Log.d("22MachV1", "loginSting[" + i1 + "] ==>" + loginStrings[i1]);
                                }

                            } // if

                        } // for


                        if (statusBool) {
//                            User Fale
                            MyAlert myAlert = new MyAlert(getActivity());
                            myAlert.myDialog("User False",
                                    "No This User in mySQL");
                        } else if (passwordSting.equals(loginStrings[3])) {
//                            Password True
                            Toast.makeText(getActivity(),"Welcome" + loginStrings[1],
                                    Toast.LENGTH_SHORT).show();

                        } else {
//                          Password False
                            MyAlert myAlert = new MyAlert(getActivity());
                            myAlert.myDialog("Password False",
                                    "Please Try Again Password False");


                        }


                    } catch (Exception e) {
                        e.printStackTrace();
                    }



                } // if


            } // onClick

        });


    }

    private void registerController() {
        TextView textView = getView().findViewById(R.id.txtRegister);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Replace Fragment
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentMainFragment, new RegisterFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main,container,false);

        return view;
    }
}  // Main Class

