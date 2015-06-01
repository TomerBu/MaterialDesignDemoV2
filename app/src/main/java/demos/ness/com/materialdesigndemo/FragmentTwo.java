package demos.ness.com.materialdesigndemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class FragmentTwo extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(
                R.layout.fragment_two, container, false);
        setupListView(v);

        return v;
    }

    private void setupListView(View v) {
        ListView lv = (ListView) v.findViewById(R.id.listView);
        List<String> data = Arrays.asList(getResources().getStringArray(R.array.arr));
        lv.setAdapter(new MyListViewAdapter(data, lv.getContext()));
    }


    public static class MyListViewAdapter extends BaseAdapter {


        private final Context context;
        /**
         * Private Data members: data.
         */
        private List<String> data;


        /**
         * Constructor for MyRecycleViewAdapter
         */
        public MyListViewAdapter(List<String> data, Context context) {
            this.data = data;
            this.context = context;
        }


        /*
        data size
         */
        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null)
                convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            String item = data.get(position);
            TextView tvItem = (TextView)convertView.findViewById(R.id.text1);
            tvItem.setText(item);
            ImageView ivImage = (ImageView) convertView.findViewById(R.id.avatar);
            ivImage.setImageResource(R.mipmap.ic_launcher);
            convertView.setBackgroundColor(0xFFaaaaaa);
            return convertView;
        }
    }
}