package com.example.medenjaci;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder> {
    private ArrayList<Item> mDataset;
    public final Korpa1Fragment f;
    public MyViewModel myViewModel;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView nameProduct;
        public TextView priceProduct;
        public TextView quantityProduct;
        public TextView bill;
        public ImageView productImage;
        public LinearLayout parentLayout;
        public MyViewHolder(View v) {
            super(v);
            nameProduct=v.findViewById(R.id.recyclerViewNameProduct1);
            priceProduct=v.findViewById(R.id.recyclerViewPriceProduct1);
            quantityProduct=v.findViewById(R.id.recyclerViewQuantity1);
            bill=v.findViewById(R.id.recyclerViewBill1);

            productImage=v.findViewById(R.id.recyclerViewImage1);
            parentLayout=v.findViewById(R.id.parent1);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter2(ArrayList<Item> myDataset, Korpa1Fragment f) {
        mDataset = myDataset;
        this.f=f;
        myViewModel = ViewModelProviders.of(f.getActivity()).get(MyViewModel.class);
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter2.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item2, parent, false);

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

        holder.productImage.setImageResource(mDataset.get(position).getImage());
        holder.nameProduct.setText(mDataset.get(position).getName());
        holder.priceProduct.setText(mDataset.get(position).getPrice());
        holder.quantityProduct.setText(mDataset.get(position).getQuantity());
        holder.bill.setText(mDataset.get(position).getBill());






    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
