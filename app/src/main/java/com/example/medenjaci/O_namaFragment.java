package com.example.medenjaci;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;


/**
 * A simple {@link Fragment} subclass.
 */
public class O_namaFragment extends Fragment {


    public O_namaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v  = inflater.inflate(R.layout.fragment_o_nama, container, false);

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
                                navController.navigate(R.id.action_o_namaFragment_to_pocetnaFragment);
                                return true;
                            case R.id.item_2:
                                return true;
                            case R.id.item_3:
                                navController= Navigation.findNavController(view);
                                navController.navigate(R.id.action_o_namaFragment_to_kontaktFragment);
                                return true;
                            case R.id.item_4:
                                navController= Navigation.findNavController(view);
                                navController.navigate(R.id.action_o_namaFragment_to_prijavaFragment);
                                return true;
                            case R.id.item_5:
                                navController= Navigation.findNavController(view);
                                navController.navigate(R.id.action_o_namaFragment_to_registracijaFragment);
                                return true;
                            default:
                                return false;
                        }
                    }
                });
            }
        });

        return v;
    }

}
