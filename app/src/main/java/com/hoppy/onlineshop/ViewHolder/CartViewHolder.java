package com.hoppy.onlineshop.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hoppy.onlineshop.Interface.ItemClickListner;
import com.hoppy.onlineshop.R;

public class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView txtCartProductName, txtCartProductPrice, txtCartProductQuantity;
    private ItemClickListner itemClickListner;


    public CartViewHolder(@NonNull View itemView) {
        super(itemView);

        txtCartProductName = itemView.findViewById(R.id.cart_product_name);
        txtCartProductPrice = itemView.findViewById(R.id.cart_product_price);
        txtCartProductQuantity = itemView.findViewById(R.id.cart_product_quantity);

    }

    @Override
    public void onClick(View view)
    {
        itemClickListner.onClick(view, getAdapterPosition(), false);
    }

    public void setItemClickListner(ItemClickListner itemClickListner)
    {
        this.itemClickListner = itemClickListner;
    }
}
