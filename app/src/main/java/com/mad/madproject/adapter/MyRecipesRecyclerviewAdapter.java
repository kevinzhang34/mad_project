package com.mad.madproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mad.madproject.R;
import com.mad.madproject.model.Recipe;
import com.mad.madproject.util.Convertor;
import com.mad.madproject.view.DetailActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * custom recyclerview adapter
 */
public class MyRecipesRecyclerviewAdapter extends RecyclerView.Adapter<MyRecipesRecyclerviewAdapter.MyViewHolder> {

    private Recipe[] mRecipes;
    private Context mContext;

    /**
     * this class holds one view that is waited to be recycled.
     */
    public class MyViewHolder extends RecyclerView.ViewHolder{

        View mView;
        TextView mTextView;
        ImageView mImageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            mTextView = (TextView) mView.findViewById(R.id.item_tv);
            mImageView =(ImageView) mView.findViewById(R.id.image_Imv);
        }
    }

    public MyRecipesRecyclerviewAdapter(List<Recipe> recipes, Context context) {
        this.mRecipes = Convertor.convertListToArray(recipes);
        this. mContext = context;
    }

    /**
     * this will create a new view, which in this case, is a list.
     * @param viewGroup
     * @param i
     * @return
     */
    @NonNull
    @Override
    public MyRecipesRecyclerviewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.item, viewGroup,false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    /**
     * set the text after the view is created, also change the text when recycled.
     * @param myViewHolder
     * @param i
     */
    @Override
    public void onBindViewHolder(@NonNull MyRecipesRecyclerviewAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.mTextView.setText(mRecipes[i].getmTitle());
        Picasso.get().load(mRecipes[i].getmImageURL()).into(myViewHolder.mImageView);
        final int ipassed = i;
        myViewHolder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra("id", mRecipes[ipassed].getRecipeId());
                mContext.startActivity(intent);
            }
        });
    }

    /**
     * the the length of the data set for boundary detection.
     * @return
     */
    @Override
    public int getItemCount() {
        return mRecipes.length;
    }
}
