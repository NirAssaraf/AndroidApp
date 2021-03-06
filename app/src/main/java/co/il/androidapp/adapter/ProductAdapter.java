package co.il.androidapp.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import co.il.androidapp.R;
import co.il.androidapp.model.Product;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>
{

    private Activity activity;
    private List<Product> productList;
    private OnItemClickListener listener;

    public ProductAdapter() {

    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public ProductAdapter(Activity activity, List<Product> productList) {
        this.activity = activity;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_row,parent,false);
        ProductAdapter.ViewHolder holder =new ProductAdapter.ViewHolder(view);
        holder.listener=listener;
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Product product = productList.get(position);
        holder.bindData(product,position);

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public OnItemClickListener listener;
        TextView productName;
        TextView productQuantity;
        int position;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            productName = itemView.findViewById(R.id.Product_Name);
            productQuantity = itemView.findViewById(R.id.product_quantity);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(position);
                }
            });
        }

        public void bindData(Product product, int position)
        {
            this.productName.setText(product.productName);
            this.productQuantity.setText(product.productQuantity);
            this.position=position;

        }
    }
}
