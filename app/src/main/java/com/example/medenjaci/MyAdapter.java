package com.example.medenjaci;

import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<Item> mDataset;
    public final PocetnaKupacFragment f;
    public MyViewModel myViewModel;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public Button button;
        public TextView nameProduct;
        public TextView priceProduct;
        public ImageView image;
        public LinearLayout parentLayout;
        public MyViewHolder(View v) {
            super(v);
            button=v.findViewById(R.id.recyclerViewButton);
            nameProduct=v.findViewById(R.id.recyclerViewNameProduct);
            priceProduct=v.findViewById(R.id.recyclerViewPriceProduct);
            image=v.findViewById(R.id.recyclerViewImage);
            parentLayout=v.findViewById(R.id.parent);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<Item> myDataset, PocetnaKupacFragment f) {
        mDataset = myDataset;
        this.f=f;
        myViewModel = ViewModelProviders.of(f.getActivity()).get(MyViewModel.class);
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        //holder.button.setText(mDataset.get(position));
        //Log.d("MOJI TAGOVI",String.valueOf(R.drawable.livadski1));
        //Log.d("MOJI TAGOVI",String.valueOf(mDataset.get(position).getImage()));

        holder.image.setImageResource(mDataset.get(position).getImage());
        holder.nameProduct.setText(mDataset.get(position).getName());
        holder.priceProduct.setText(mDataset.get(position).getPrice());

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**ovde u zavisnosti od proizvoda se prikazuje odgovarajuca stranica**/
                for (Item i : mDataset) {
                    Log.d("MOJI TAGOVI",holder.priceProduct.getText().toString());
                    Log.d("MOJI TAGOVI",i.getName());
                    if (i.getPrice().equals(holder.priceProduct.getText().toString())){
                        myViewModel.mySetNameProduct(i.getName());
                        myViewModel.mySetPriceProduct(i.getPrice());
                        myViewModel.mySetDescriptionProduct(i.getDescription());
                        myViewModel.mySetImageProduct(i.getImage());
                        NavController navController = Navigation.findNavController(view);
                        navController.navigate(R.id.action_pocetnaKupacFragment_to_detaljiFragment);
                        //myViewModel.setToggle("novo");

                    }

                }



            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
