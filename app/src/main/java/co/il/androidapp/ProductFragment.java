package co.il.androidapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.il.androidapp.adapter.ChoreAdapter;
import co.il.androidapp.adapter.ProductAdapter;
import co.il.androidapp.model.ProductModel;


public class ProductFragment extends Fragment {


    RecyclerView rv;
    ProductAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_product, container, false);
        rv=view.findViewById(R.id.product_RecyclerView);
        rv.hasFixedSize();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rv.setLayoutManager(layoutManager);

        adapter = new ProductAdapter(getActivity(), ProductModel.instance.getAllProductList());
        rv.setAdapter(adapter);

        return view;
    }

    public void updateData(){

        adapter.notifyDataSetChanged();
    }
}