package com.example.medenjaci;


import android.content.Intent;
import android.net.Uri;
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
public class KontaktFragment extends Fragment {


    public KontaktFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_kontakt, container, false);
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
                                navController.navigate(R.id.action_kontaktFragment_to_pocetnaFragment);
                                return true;
                            case R.id.item_2:
                                navController= Navigation.findNavController(view);
                                navController.navigate(R.id.action_kontaktFragment_to_o_namaFragment);
                                return true;
                            case R.id.item_3:
                                return true;
                            case R.id.item_4:
                                navController= Navigation.findNavController(view);
                                navController.navigate(R.id.action_kontaktFragment_to_prijavaFragment);
                                return true;
                            case R.id.item_5:
                                navController= Navigation.findNavController(view);
                                navController.navigate(R.id.action_kontaktFragment_to_registracijaFragment);
                                return true;
                            default:
                                return false;
                        }
                    }
                });
            }
        });


        /******************************linkovanje sa ikonicama*************************************/
        ImageView facebookLogo = v.findViewById(R.id.facebookLogo);
        ImageView instagramLogo = v.findViewById(R.id.instagramLogo);
        ImageView gmailLogo = v.findViewById(R.id.gmailLogo);


        facebookLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com"));
                startActivity(browserIntent);
            }
        });

        instagramLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com"));
                startActivity(browserIntent);
            }
        });

        gmailLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gmail.com"));
                startActivity(browserIntent);
            }
        });


        return v;
    }

}
