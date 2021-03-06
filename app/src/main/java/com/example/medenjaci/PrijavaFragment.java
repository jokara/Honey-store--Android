package com.example.medenjaci;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PrijavaFragment extends Fragment {


    public PrijavaFragment() {
        // Required empty public constructor
    }

    MyViewModel myViewModel;
    ArrayList<User> allUsers = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_prijava, container, false);

        myViewModel = ViewModelProviders.of(getActivity()).get(MyViewModel.class);
        allUsers = myViewModel.users.getValue();


        /*************************Popup meni za neregistrovanog*************************************/
        ImageView menuPopup = v.findViewById(R.id.menuButton);
        menuPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                PopupMenu popup = new PopupMenu(getContext(), view);
                MenuInflater inflater = popup.getMenuInflater();
                inflater.inflate(R.menu.menu_options, popup.getMenu());
                popup.show();
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.item_1:
                                NavController navController= Navigation.findNavController(view);
                                navController.navigate(R.id.action_prijavaFragment_to_pocetnaFragment);
                                return true;
                            case R.id.item_2:
                                navController= Navigation.findNavController(view);
                                navController.navigate(R.id.action_prijavaFragment_to_o_namaFragment);
                                return true;
                            case R.id.item_3:
                                navController= Navigation.findNavController(view);
                                navController.navigate(R.id.action_prijavaFragment_to_kontaktFragment);
                                return true;
                            case R.id.item_4:
                                return true;
                            case R.id.item_5:
                                navController= Navigation.findNavController(view);
                                navController.navigate(R.id.action_prijavaFragment_to_registracijaFragment);
                                return true;
                            default:
                                return false;
                        }
                    }
                });
            }
        });

        /***************************Obrada dugmica**************************************************/
        final EditText usernameEdit = v.findViewById(R.id.usernameEdit);
        final EditText passwordEdit = v.findViewById(R.id.passwordEdit);

        Button loginButton = v.findViewById(R.id.loginButton);
        Button registerButton = v.findViewById(R.id.registerButton);

        final TextView errorText = v.findViewById(R.id.errorText);
        TextView backText = v.findViewById(R.id.backText);

        /*************************Nazad na pocetnu*************************************************/
        backText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController= Navigation.findNavController(view);
                navController.navigate(R.id.action_prijavaFragment_to_pocetnaFragment);
            }
        });

        /************************Rutiranje na registraciju*****************************************/
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController= Navigation.findNavController(view);
                navController.navigate(R.id.action_prijavaFragment_to_registracijaFragment);
            }
        });

        /*********************************Logovanje na sistem***************************************/

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int flag = 1;
                errorText.setVisibility(View.INVISIBLE);
                if (!usernameEdit.getText().toString().equals("") && !passwordEdit.getText().toString().equals("")){
                    for (User u: allUsers) {
                        if ((u.getUsername().equals(usernameEdit.getText().toString())) && (u.getPassword().equals(passwordEdit.getText().toString()))){
                            flag=0;
                            myViewModel.setLoggedUser(u);
                            //Toast.makeText(getContext(),u.getName(),Toast.LENGTH_SHORT).show();
                            NavController navController= Navigation.findNavController(view);
                            navController.navigate(R.id.action_prijavaFragment_to_pocetnaKupacFragment);
                        }
                    }
                }
                if (flag==1){
                    errorText.setVisibility(View.VISIBLE);
                }
            }
        });




        return v;
    }

}
