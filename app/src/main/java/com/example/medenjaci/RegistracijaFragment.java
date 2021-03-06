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

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegistracijaFragment extends Fragment {


    public RegistracijaFragment() {
        // Required empty public constructor
    }

    MyViewModel myViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_registracija, container, false);

        myViewModel = ViewModelProviders.of(getActivity()).get(MyViewModel.class);

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
                                navController.navigate(R.id.action_registracijaFragment_to_pocetnaFragment);
                                return true;
                            case R.id.item_2:
                                navController= Navigation.findNavController(view);
                                navController.navigate(R.id.action_registracijaFragment_to_o_namaFragment);
                                return true;
                            case R.id.item_3:
                                navController= Navigation.findNavController(view);
                                navController.navigate(R.id.action_registracijaFragment_to_kontaktFragment);
                                return true;
                            case R.id.item_4:
                                navController= Navigation.findNavController(view);
                                navController.navigate(R.id.action_registracijaFragment_to_prijavaFragment);
                                return true;
                            case R.id.item_5:
                                return true;
                            default:
                                return false;
                        }
                    }
                });
            }
        });


        /**************************************Obrada dugmica*******************************************/

        final EditText name = v.findViewById(R.id.nameEdit);
        final EditText surname = v.findViewById(R.id.surnameEdit);
        final EditText address = v.findViewById(R.id.addressEdit);
        final EditText phone = v.findViewById(R.id.phoneEdit);
        final EditText username = v.findViewById(R.id.usernameRegEdit);
        final EditText password1 = v.findViewById(R.id.passwordRegEdit);
        final EditText password2 = v.findViewById(R.id.passwordReg2Edit);

        Button regButton = v.findViewById(R.id.registrationButton);

        final TextView errorText = v.findViewById(R.id.errorRegText);
        TextView backText = v.findViewById(R.id.backRegText);


        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                errorText.setVisibility(View.INVISIBLE);
                if (!name.getText().toString().equals("")&&!surname.getText().toString().equals("")&&!address.getText().toString().equals("")&&
                        !phone.getText().toString().equals("")&&!username.getText().toString().equals("")&&!password1.getText().toString().equals("")
                        &&!password2.getText().toString().equals("")){
                    if (password1.getText().toString().equals(password2.getText().toString())){
                        User newUser = new User(name.getText().toString(),surname.getText().toString(),phone.getText().toString(),address.getText().toString(),username.getText().toString(),password1.getText().toString());
                        myViewModel.addUser(newUser);
                        myViewModel.setLoggedUser(newUser);
                        NavController navController= Navigation.findNavController(view);
                        navController.navigate(R.id.action_registracijaFragment_to_pocetnaKupacFragment);
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
                navController.navigate(R.id.action_registracijaFragment_to_pocetnaFragment);
            }
        });


        return v;
    }




}
