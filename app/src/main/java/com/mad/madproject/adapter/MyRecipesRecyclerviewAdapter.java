package com.mad.madproject.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mad.madproject.R;
import com.mad.madproject.model.Recipe;
import com.mad.madproject.util.Convertor;

import java.util.List;

/**
 * custom recyclerview adapter
 */
public class MyRecipesRecyclerviewAdapter extends RecyclerView.Adapter<MyRecipesRecyclerviewAdapter.MyViewHolder> {

    private Recipe[] mRecipes;

    /**
     * this class holds one view that is waited to be recycled.
     */
    public class MyViewHolder extends RecyclerView.ViewHolder {

        View mView;
        TextView mTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            mTextView = (TextView) mView.findViewById(R.id.item_tv);
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
        Log.d("recipe's title: ", mRecipes[i].getmTitle());
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
