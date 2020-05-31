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

public class PostJobFragment extends Fragment {
    //Browse Fragmentindeki kategoriler için imageleri diziye atıp listview'de scroll özelliği ile listeletiyoruz.

    ListView mListview;
    int[] column1= {R.drawable.pj_websites,
            R.drawable.pj_mobile,
            R.drawable.pj_art,
            R.drawable.pj_data,
            R.drawable.pj_sales,

    };

    int[] column2= {R.drawable.pj_writing,
            R.drawable.pj_software,
            R.drawable.pj_business,
            R.drawable.pj_local,
            R.drawable.pj_other,

    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_post_job, container, false);
        mListview=v.findViewById(R.id.lvPostJob);
        PostJobAdaptor browseAdaptor=new PostJobAdaptor();
        mListview.setAdapter(browseAdaptor);




        return v;
    }
         class PostJobAdaptor extends BaseAdapter{

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
                View view=getLayoutInflater().inflate(R.layout.post_job_layout,null);
                 ImageView mImageView=(ImageView) view.findViewById(R.id.imageFirst);
                 ImageView mImageView2=(ImageView) view.findViewById(R.id.imageSecond);
                 mImageView.setImageResource(column1[position]);
                 mImageView2.setImageResource(column2[position]);


                 return view;
             }
         }

}
