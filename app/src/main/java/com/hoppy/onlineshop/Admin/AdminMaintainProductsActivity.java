package com.hoppy.onlineshop.Admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hoppy.onlineshop.R;
import com.hoppy.onlineshop.Sellers.SellerProductCategoryActivity;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class AdminMaintainProductsActivity extends AppCompatActivity {

    private Button applyChangesBtn, deleteBtn;
    private EditText name, price, description;
    private ImageView imageView;

    private String productID = "";
    private DatabaseReference productsRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_maintain_products);

        productID = getIntent().getStringExtra("pid");
        if (productID != null) {

            productsRef = FirebaseDatabase.getInstance().getReference().child("Products").child(productID);
        }


        deleteBtn = findViewById(R.id.delete_product_btn);
        applyChangesBtn = findViewById(R.id.apply_changes_btn);
        name = findViewById(R.id.prod_name_maintain);
        price = findViewById(R.id.prod_price_maintain);
        description = findViewById(R.id.prod_description_maintain);
        imageView = findViewById(R.id.prod_image_maintain);

        displaySpecificProductInfo();

        applyChangesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyChanges();

            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteThisProduct();
            }
        });
    }

    private void deleteThisProduct() {

        productsRef.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Intent intent = new Intent(AdminMaintainProductsActivity.this, AdminProductCategoryActivity.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(AdminMaintainProductsActivity.this, "Tha Product Is Deleted Successfully.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void applyChanges() {
        String pName = name.getText().toString();
        String pPrice = price.getText().toString();
        String pDescription = description.getText().toString();

        if (pName.equals("")) {
            Toast.makeText(this, "Write Down Product Name.", Toast.LENGTH_SHORT).show();
        } else if (pPrice.equals("")) {
            Toast.makeText(this, "Write Down Product Price.", Toast.LENGTH_SHORT).show();
        } else if (pDescription.equals("")) {
            Toast.makeText(this, "Write Down Product Description.", Toast.LENGTH_SHORT).show();
        } else {
            HashMap<String, Object> productMap = new HashMap<>();
            productMap.put("pid", productID);
            productMap.put("description", pDescription);
            productMap.put("price", pPrice);
            productMap.put("pname", pName);

            productsRef.updateChildren(productMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {

                        Toast.makeText(AdminMaintainProductsActivity.this, "Changes applied Successfully.", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(AdminMaintainProductsActivity.this, AdminProductCategoryActivity.class);
                        startActivity(intent);
                    }
                }
            });

        }
    }

    private void displaySpecificProductInfo() {
        if (productID != null) {

            productsRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        String pName = dataSnapshot.child("pname").getValue().toString();
                        String pPrice = dataSnapshot.child("price").getValue().toString();
                        String pDescription = dataSnapshot.child("description").getValue().toString();
                        String pImage = dataSnapshot.child("image").getValue().toString();

                        name.setText(pName);
                        price.setText(pPrice);
                        description.setText(pDescription);
                        Picasso.get().load(pImage).into(imageView);

                    }

                }


                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }
}
