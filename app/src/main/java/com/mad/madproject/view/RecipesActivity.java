package com.mad.madproject.view;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mad.madproject.R;

public class RecipesActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);
        mRecyclerView = (RecyclerView)findViewById(R.id.reclyView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
       // mAdapter = new MyAdapter();
        mRecyclerView.setAdapter(mAdapter);

//        result = getIntent().getExtras().getString("Recipe");
        TextView textview = (TextView)findViewById(R.id.resultTV);
//         textview.setText(result);

    }
    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        public static class MyViewHolder extends RecyclerView.ViewHolder {

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
            }
        }
    }
        @NonNull
        @Override
        public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder myViewHolder, int i) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }
