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

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AzuriranjeFragment extends Fragment {


    public AzuriranjeFragment() {
        // Required empty public constructor
    }

    MyViewModel myViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_azuriranje, container, false);
        myViewModel = ViewModelProviders.of(getActivity()).get(MyViewModel.class);

        /*************************Popup meni za neregistrovanog*************************************/
        ImageView menuPopup = v.findViewById(R.id.menuButton);
        menuPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                PopupMenu popup = new PopupMenu(getContext(), view);
                MenuInflater inflater = popup.getMenuInflater();
                inflater.inflate(R.menu.menu_options_user, popup.getMenu());
                popup.show();
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.pocetna:
                                NavController navController= Navigation.findNavController(view);
                                navController.navigate(R.id.action_azuriranjeFragment_to_pocetnaKupacFragment);
                                return true;
                            case R.id.azuriraj:
                                return true;
                            case R.id.korpa:
                                navController= Navigation.findNavController(view);
                                navController.navigate(R.id.action_azuriranjeFragment_to_korpaFragment);
                                return true;
                            case R.id.odjava:
                                navController= Navigation.findNavController(view);
                                navController.navigate(R.id.action_azuriranjeFragment_to_prijavaFragment);
                                return true;
                            default:
                                return false;
                        }
                    }
                });
            }
        });


        /****************************Dohvatanje iz modela i pakovanje u polja************************/
        final EditText name = v.findViewById(R.id.nameEdit1);
        final EditText surname = v.findViewById(R.id.surnameEdit1);
        final EditText address = v.findViewById(R.id.addressEdit1);
        final EditText phone = v.findViewById(R.id.phoneEdit1);
        final EditText username = v.findViewById(R.id.usernameRegEdit1);
        final EditText password1 = v.findViewById(R.id.passwordRegEdit1);
        final EditText password2 = v.findViewById(R.id.passwordReg2Edit1);

        Button regButton = v.findViewById(R.id.updateButton);

        final TextView errorText = v.findViewById(R.id.errorRegText);
        TextView backText = v.findViewById(R.id.backRegText);

        User loggedUser = myViewModel.getLoggedUser();

        name.setText(loggedUser.getName());
        surname.setText(loggedUser.getSurname());
        address.setText(loggedUser.getAddress());
        phone.setText(loggedUser.getPhone());
        username.setText(loggedUser.getUsername());
        password1.setText(loggedUser.getPassword());
        password2.setText(loggedUser.getPassword());



        /*******************************************************************************************/

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                errorText.setVisibility(View.INVISIBLE);
                if (!name.getText().toString().equals("")&&!surname.getText().toString().equals("")&&!address.getText().toString().equals("")&&
                        !phone.getText().toString().equals("")&&!username.getText().toString().equals("")&&!password1.getText().toString().equals("")
                        &&!password2.getText().toString().equals("")){
                    if (password1.getText().toString().equals(password2.getText().toString())){
                        User newUser = new User(name.getText().toString(),surname.getText().toString(),phone.getText().toString(),address.getText().toString(),username.getText().toString(),password1.getText().toString());
                        /***********************************promena lista i postavljanje novog ulogovanog*****************/
                        myViewModel.setLoggedUser(newUser);
                        ArrayList<User> list = new ArrayList<>();
                        ArrayList<User> users = new ArrayList<>();
                        users = myViewModel.getUsers().getValue();
                        for (User u: users) {
                            if (!newUser.getUsername().equals(u.getUsername())){
                                list.add(u);
                            }
                        }
                        list.add(newUser);
                        myViewModel.setAllUsers(list);

                        NavController navController= Navigation.findNavController(view);
                        navController.navigate(R.id.action_azuriranjeFragment_to_pocetnaKupacFragment);
                    }
                    else{
                        errorText.setVisibility(View.VISIBLE);
                    }
                }
                else{
                    errorText.setVisibility(View.VISIBLE);
                }
            }
        });


        backText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController= Navigation.findNavController(view);
                navController.navigate(R.id.action_azuriranjeFragment_to_pocetnaKupacFragment);
            }
        });

        return v;
    }

}
