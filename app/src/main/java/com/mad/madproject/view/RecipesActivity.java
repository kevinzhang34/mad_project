package com.mad.madproject.view;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mad.madproject.R;
import com.mad.madproject.contract.RecipesContract;
import com.mad.madproject.model.Recipe;
import com.mad.madproject.util.Convertor;

import java.util.List;

public class RecipesActivity extends AppCompatActivity implements RecipesContract.View {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    /**
     * the life cycle method
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setAdapter(mAdapter);
        TextView textview = (TextView) findViewById(R.id.resultTV);
    }

    @Override
    public void showDetail() {

    }

    @Override
    public void setPresenter(RecipesContract.Presenter presenter) {

    }

    /**
     * custom recyclerview adapter
     */
    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        private Recipe[] mRecipes;

        /**
         * this class holds one view that is waited to be recycled.
         */
        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView mTextView;
            public MyViewHolder(@NonNull TextView itemView) {
                super(itemView);
                mTextView = itemView;
            }
        }

        public MyAdapter(List<Recipe> recipes) {
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
        public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            TextView v = (TextView) LayoutInflater.from(viewGroup.getContext()).
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
        public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder myViewHolder, int i) {
            myViewHolder.mTextView.setText(mRecipes[i].toString());
        }

        @Override
        public int getItemCount() {
            return mRecipes.length;
        }
    }
}
