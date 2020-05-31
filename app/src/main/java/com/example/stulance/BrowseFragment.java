package com.example.stulance;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BrowseFragment extends Fragment {

//Browse Fragmentindeki kategoriler için imageleri diziye atıp listview'de scroll özelliği ile listeletiyoruz.

    ListView mListview;
    int[] column1= {R.drawable.websites,
            R.drawable.desing,
            R.drawable.engineering,
            R.drawable.business,
            R.drawable.mobile_phones,
            R.drawable.local_jobs,
            R.drawable.other,
                     };

    int[] column2= {R.drawable.writing,
            R.drawable.data_entry,
            R.drawable.sales,
            R.drawable.product_sourcing,
            R.drawable.translation,
            R.drawable.freight,

    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v= inflater.inflate(R.layout.fragment_browse, container, false);

        mListview=v.findViewById(R.id.lvBrowse);
        BrowseAdaptor browseAdaptor=new BrowseAdaptor();
        mListview.setAdapter(browseAdaptor);
                return v;
    }
    class BrowseAdaptor extends BaseAdapter{

        @Override
        public int getCount() {
            return column1.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

         View view=getLayoutInflater().inflate(R.layout.browse_layout,null);
            ImageView mImageView=(ImageView) view.findViewById(R.id.imageFirst);
            ImageView mImageView2=(ImageView) view.findViewById(R.id.imageSecond);
            mImageView.setImageResource(column1[position]);
            mImageView2.setImageResource(column2[position]);

                  return view;
        }
    }
}
