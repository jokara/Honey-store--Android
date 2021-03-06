package com.example.medenjaci;


import android.media.Image;
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
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetaljiFragment extends Fragment {


    public DetaljiFragment() {
        // Required empty public constructor
    }

    MyViewModel myViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detalji, container, false);
        myViewModel = ViewModelProviders.of(getActivity()).get(MyViewModel.class);
        /*************************Popup meni za registrovanog*************************************/
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
                                navController.navigate(R.id.action_detaljiFragment_to_pocetnaKupacFragment);
                                return true;
                            case R.id.azuriraj:
                                navController= Navigation.findNavController(view);
                                navController.navigate(R.id.action_detaljiFragment_to_azuriranjeFragment);
                                return true;
                            case R.id.korpa:
                                navController= Navigation.findNavController(view);
                                navController.navigate(R.id.action_detaljiFragment_to_korpaFragment);
                                return true;
                            case R.id.odjava:
                                navController= Navigation.findNavController(view);
                                navController.navigate(R.id.action_detaljiFragment_to_prijavaFragment);
                                return true;
                            default:
                                return false;
                        }
                    }
                });
            }
        });

        /*****************************Dugmici za navigaciju****************************************/
        ImageView homeLogo = v.findViewById(R.id.homeButton);
        ImageView userLogo = v.findViewById(R.id.userButton);
        ImageView cartLogo = v.findViewById(R.id.cartButton);
        ImageView logoutLogo = v.findViewById(R.id.logoutButton);


        homeLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController= Navigation.findNavController(view);
                navController.navigate(R.id.action_detaljiFragment_to_pocetnaKupacFragment);
            }
        });

        userLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController= Navigation.findNavController(view);
                navController.navigate(R.id.action_pocetnaKupacFragment_to_azuriranjeFragment);
            }
        });

        cartLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController= Navigation.findNavController(view);
                navController.navigate(R.id.action_pocetnaKupacFragment_to_korpaFragment);
            }
        });

        logoutLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController= Navigation.findNavController(view);
                navController.navigate(R.id.action_pocetnaKupacFragment_to_prijavaFragment);
            }
        });



        /***********************************Postavljanje proizvoda*********************************/


        ImageView detailsImage = v.findViewById(R.id.detailsImage);
        ImageView detailsPlus = v.findViewById(R.id.detailsPlus);
        ImageView detailsMinus = v.findViewById(R.id.detailsMinus);

        TextView detailsName = v.findViewById(R.id.detailsName);
        TextView detailsPrice = v.findViewById(R.id.detailsPrice);
        TextView detailsDescription = v.findViewById(R.id.detailsDescription);
        final TextView detailsQ = v.findViewById(R.id.detailsQ);

        Button detailsButton = v.findViewById(R.id.detailsAddToCart);


        detailsImage.setImageResource(myViewModel.imageProduct.getValue().intValue());
        detailsName.setText(myViewModel.nameProduct.getValue());
        detailsPrice.setText(myViewModel.priceProduct.getValue());
        detailsDescription.setText(myViewModel.descriptionProduct.getValue());

        detailsPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number = Integer.parseInt(detailsQ.getText().toString());
                number++;
                detailsQ.setText(String.valueOf(number));
            }
        });

        detailsMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number = Integer.parseInt(detailsQ.getText().toString());
                if (number>0) number--;
                detailsQ.setText(String.valueOf(number));
            }
        });


        detailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Proizvod je dodat u korpu!",Toast.LENGTH_SHORT).show();
                NavController navController= Navigation.findNavController(view);
                navController.navigate(R.id.action_detaljiFragment_to_pocetnaKupacFragment);
            }
        });




        return v;
    }

}
