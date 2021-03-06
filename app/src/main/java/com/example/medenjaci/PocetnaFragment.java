package com.example.medenjaci;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class PocetnaFragment extends Fragment {


    public PocetnaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pocetna, container, false);
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
                                return true;
                            case R.id.item_2:
                                NavController navController= Navigation.findNavController(view);
                                navController.navigate(R.id.action_pocetnaFragment_to_o_namaFragment);
                                return true;
                            case R.id.item_3:
                                navController= Navigation.findNavController(view);
                                navController.navigate(R.id.action_pocetnaFragment_to_kontaktFragment);
                                return true;
                            case R.id.item_4:
                                navController= Navigation.findNavController(view);
                                navController.navigate(R.id.action_pocetnaFragment_to_prijavaFragment);
                                return true;
                            case R.id.item_5:
                                navController= Navigation.findNavController(view);
                                navController.navigate(R.id.action_pocetnaFragment_to_registracijaFragment);
                                return true;
                            default:
                                return false;
                        }
                    }
                });
            }
        });




        final int[] sampleImages = {R.drawable.sou1, R.drawable.sou2, R.drawable.sou3};

        ImageListener imageListener = new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(sampleImages[position]);
            }
        };

        CarouselView carouselView;
        carouselView = v.findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);






        return v;
    }



}
