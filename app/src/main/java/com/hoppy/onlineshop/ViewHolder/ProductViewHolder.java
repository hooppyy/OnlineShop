package com.hoppy.onlineshop.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hoppy.onlineshop.Interface.ItemClickListner;
import com.hoppy.onlineshop.R;

public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public TextView txtProductName,txtProductDescription,txtProductPrice;
    public ImageView imageView;
    public ItemClickListner listener;

    public ProductViewHolder(@NonNull View itemView)
    {
        super(itemView);

        imageView = (ImageView) itemView.findViewById(R.id.prod_image);
        txtProductName = (TextView) itemView.findViewById(R.id.prod_name);
        txtProductDescription = (TextView) itemView.findViewById(R.id.prod_description);
        txtProductPrice=(TextView) itemView.findViewById(R.id.prod_price);

    }

    public void setItemClickListener (ItemClickListner listener)
    {
        this.listener=listener;
    }

    @Override
    public void onClick(View v)
    {
        listener.onClick(v ,getAdapterPosition() ,false);
    }
}
