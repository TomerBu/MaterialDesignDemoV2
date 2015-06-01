package demos.ness.com.materialdesigndemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class FragmentThree extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView rv = (RecyclerView) inflater.inflate(
                R.layout.fragment_three, container, false);
        setupRecyclerView(rv);
        return rv;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        List<String> data = Arrays.asList(getResources().getStringArray(R.array.arr));
        recyclerView.setAdapter(new MyRecycleViewAdapter(data));
    }


    public static class MyRecycleViewAdapter
            extends RecyclerView.Adapter<MyRecycleViewAdapter.ViewHolder> {

        /**
         * The ViewHolder Class
         */
        public static class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final ImageView mImageView;
            public final TextView mTextView;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mImageView = (ImageView) view.findViewById(R.id.avatar);
                mTextView = (TextView) view.findViewById(R.id.text1);
            }
        }

        /**
         * Private Data members: data.
         */
        private List<String> mValues;


        /**
         * Constructor for MyRecycleViewAdapter
         */
        public MyRecycleViewAdapter(List<String> items) {
            mValues = items;
        }


        /*
        data size
         */
        @Override
        public int getItemCount() {
            return mValues.size();
        }

        /*
         * inflate the View
         */
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item, parent, false);
            view.setBackgroundColor(0xffaaaaaa);
            return new ViewHolder(view);
        }

        /*
        Bind the view
         */
        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mTextView.setText(mValues.get(position));
            holder.mImageView.setImageResource(R.mipmap.ic_launcher);
            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, MainActivity.class);
                    context.startActivity(intent);
                }
            });
        }


    }
}