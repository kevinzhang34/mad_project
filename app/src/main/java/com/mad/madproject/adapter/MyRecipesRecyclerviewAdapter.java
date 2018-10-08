package com.mad.madproject.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mad.madproject.R;
import com.mad.madproject.model.Recipe;
import com.mad.madproject.util.Convertor;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * custom recyclerview adapter
 */
public class MyRecipesRecyclerviewAdapter extends RecyclerView.Adapter<MyRecipesRecyclerviewAdapter.MyViewHolder> implements View.OnClickListener{

    private Recipe[] mRecipes;
    private OnItemClickListener mClickListener;

    @Override
    public void onClick(View v) {
        mClickListener.onItemClick(v,0);
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mClickListener = onItemClickListener;
    }

    /**
     * this class holds one view that is waited to be recycled.
     */
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        View mView;
        TextView mTextView;
        ImageView mImageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            mTextView = (TextView) mView.findViewById(R.id.item_tv);
            mImageView =(ImageView) mView.findViewById(R.id.image_Imv);
        }


        @Override
        public void onClick(View view) {
            mClickListener.onItemClick(view,getPosition());
        }
    }

    public MyRecipesRecyclerviewAdapter(List<Recipe> recipes) {
        this.mRecipes = Convertor.convertListToArray(recipes);
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
