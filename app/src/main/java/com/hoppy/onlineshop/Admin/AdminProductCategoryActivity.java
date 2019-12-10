package com.hoppy.onlineshop.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.hoppy.onlineshop.R;
import com.hoppy.onlineshop.Sellers.SellerAddNewProductActivity;
import com.hoppy.onlineshop.Sellers.SellerProductCategoryActivity;

public class AdminProductCategoryActivity extends AppCompatActivity {

    public ImageView tShirts, sportTShirts, femaleDresses, sweathers;
    public ImageView glasses, hatsCaps, walletsBagsPurses, shoes;
    public ImageView headPhonesHandFree, laptops, watches, mobilePhones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_product_category);

        tShirts = (ImageView) findViewById(R.id.t_shirts_id);
        sportTShirts = (ImageView) findViewById(R.id.sports_t_shirts_id);
        femaleDresses = (ImageView) findViewById(R.id.female_dresses_id);
        sweathers = (ImageView) findViewById(R.id.sweather_id);

        glasses = (ImageView) findViewById(R.id.glasses_id);
        hatsCaps = (ImageView) findViewById(R.id.hats_caps__id);
        walletsBagsPurses = (ImageView) findViewById(R.id.purses_bags_wallets_id);
        shoes = (ImageView) findViewById(R.id.shoes_id);

        headPhonesHandFree = (ImageView) findViewById(R.id.headphones_handfree__id);
        laptops = (ImageView) findViewById(R.id.laptop_pc_id);
        watches = (ImageView) findViewById(R.id.watches_id);
        mobilePhones = (ImageView) findViewById(R.id.mobilephones_id);

        tShirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent =new Intent(AdminProductCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "tShirts");
                startActivity(intent);
            }
        });
        sportTShirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent =new Intent(AdminProductCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "sportTShirts");
                startActivity(intent);
            }
        });
        femaleDresses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent =new Intent(AdminProductCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "femaleDresses");
                startActivity(intent);
            }
        });
        sweathers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent =new Intent(AdminProductCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "sweathers");
                startActivity(intent);
            }
        });
        glasses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent =new Intent(AdminProductCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "glasses");
                startActivity(intent);
            }
        });
        hatsCaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent =new Intent(AdminProductCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "hatsCaps");
                startActivity(intent);
            }
        });
        walletsBagsPurses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent =new Intent(AdminProductCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "walletsBagsPurses");
                startActivity(intent);
            }
        });
        shoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent =new Intent(AdminProductCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "shoes");
                startActivity(intent);
            }
        });
        headPhonesHandFree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent =new Intent(AdminProductCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "headPhonesHandFree");
                startActivity(intent);
            }
        });
        laptops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent =new Intent(AdminProductCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "laptops");
                startActivity(intent);
            }
        });
        watches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent =new Intent(AdminProductCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "watches");
                startActivity(intent);
            }
        });
        mobilePhones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent =new Intent(AdminProductCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "mobilePhones");
                startActivity(intent);
            }
        });
    }
}

