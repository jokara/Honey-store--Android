package com.example.medenjaci;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class KorpaFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    MyViewModel myViewModel;
    ArrayList<Item> listOfItems= new ArrayList<>();

    public KorpaFragment() {
        Item item1 = new Item("Livadski med","800 din",R.drawable.livadski1,"Livadski med je odličan med koji se može koristiti za svakodnevnu upotrebu. Napravljen od mešavine raznovrsnog livadskog cveća i deteline doprinosi savršenom ukusu za Vaše jelo. Ovaj med takođe sadrži polen koji kada se jede svakodnevno u manjim količinama pomaže povećanju imuniteta organizma.");
        Item item2 = new Item("Livadski med","550 din",R.drawable.livadski2,"Livadski med je odličan med koji se može koristiti za svakodnevnu upotrebu. Napravljen od mešavine raznovrsnog livadskog cveća i deteline doprinosi savršenom ukusu za Vaše jelo. Ovaj med takođe sadrži polen koji kada se jede svakodnevno u manjim količinama pomaže povećanju imuniteta organizma.");
        Item item3 = new Item("Bagremov med","900 din",R.drawable.bagremov1,"Bagremov med je odličan med koji se može koristiti za svakodnevnu upotrebu. Napravljen od mešavine raznovrsnog livadskog cveća i deteline doprinosi savršenom ukusu za Vaše jelo. Ovaj med takođe sadrži polen koji kada se jede svakodnevno u manjim količinama pomaže povećanju imuniteta organizma.");
        Item item4 = new Item("Bagremov med","600 din",R.drawable.bagremov2,"Bagremov med je odličan med koji se može koristiti za svakodnevnu upotrebu. Napravljen od mešavine raznovrsnog livadskog cveća i deteline doprinosi savršenom ukusu za Vaše jelo. Ovaj med takođe sadrži polen koji kada se jede svakodnevno u manjim količinama pomaže povećanju imuniteta organizma.");
        Item item5 = new Item("Propolis","700 din",R.drawable.propolis,"Propolis je najdragoceniji pčelinji proizvod koji se smatra jednim od onih mudrih lekova prirode. Preparati sa propolisom predstavljaju prvu liniju odbrane u borbi protiv svih vrsta virusa i bakterija. Propolis jača odbrambenu sposobnost organizma i imunitet.");
        Item item6 = new Item("Polen i mlec","599 din",R.drawable.polen,"Matični mleč je sekret alotrofnih žlezda mladih pčela-radilica koji služi za iskranu matica i matičnih larvi. On je biološki aktivan proizvod pčelarstva, koji se odlikuje celim nizom lekovitih svojstava i široko se primenjuje u medicini, kozmetici i industriji hrane. ");

        //Log.d("IDVREDNOST",String.valueOf(item1.getImage()));
        //Log.d("IDVREDNOST",String.valueOf(item2.getImage()));
        //Log.d("IDVREDNOST",String.valueOf(item3.getImage()));
        //Log.d("IDVREDNOST",String.valueOf(item4.getImage()));
        item1.setBill("Cena za plaćanje: 1600 din");
        item1.setQuantity("2");
        listOfItems.add(item1);
        item4.setBill("Cena za plaćanje: 1800 din");
        item4.setQuantity("3");
        listOfItems.add(item4);
        item5.setBill("Cena za plaćanje: 700 din");
        item5.setQuantity("1");
        listOfItems.add(item5);
        item6.setBill("Cena za plaćanje: 1198 din");
        item6.setQuantity("2");
        listOfItems.add(item6);

        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_korpa, container, false);
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
                                navController.navigate(R.id.action_korpaFragment_to_pocetnaKupacFragment);
                                return true;
                            case R.id.azuriraj:
                                navController= Navigation.findNavController(view);
                                navController.navigate(R.id.action_korpaFragment_to_azuriranjeFragment);
                                return true;
                            case R.id.korpa:
                                return true;
                            case R.id.odjava:
                                navController= Navigation.findNavController(view);
                                navController.navigate(R.id.action_korpaFragment_to_prijavaFragment);
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
                navController.navigate(R.id.action_korpaFragment_to_pocetnaKupacFragment);
            }
        });

        userLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController= Navigation.findNavController(view);
                navController.navigate(R.id.action_korpaFragment_to_azuriranjeFragment);
            }
        });

        cartLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        logoutLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController= Navigation.findNavController(view);
                navController.navigate(R.id.action_korpaFragment_to_prijavaFragment);
            }
        });




        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view1);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter1(listOfItems,this);
        recyclerView.setAdapter(mAdapter);


        Button naruci = v.findViewById(R.id.korpaNaruci);
        naruci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController= Navigation.findNavController(view);
                navController.navigate(R.id.action_korpaFragment_to_korpa1Fragment);
            }
        });




        return v;
    }

}
