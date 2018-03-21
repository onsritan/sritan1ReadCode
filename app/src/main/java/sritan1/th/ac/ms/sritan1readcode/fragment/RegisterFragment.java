package sritan1.th.ac.ms.sritan1readcode.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sritan1.th.ac.ms.sritan1readcode.MainActivity;
import sritan1.th.ac.ms.sritan1readcode.R;

/**
 * Created by asus on 3/21/2018.
 */

public class RegisterFragment extends Fragment{

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



//        Create Toolbar
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

    } // Main Method


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        return view;
    }
} //Main Class

