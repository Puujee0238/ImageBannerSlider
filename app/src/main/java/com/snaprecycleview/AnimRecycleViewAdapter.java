package com.snaprecycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.florent37.materialleanback.MaterialLeanBack;
import com.playoffstudio.imagebannerslider.R;
import com.squareup.picasso.Picasso;

/**
 * Created by android on 9/21/2017.
 */

public class AnimRecycleViewAdapter extends MaterialLeanBack.Adapter<AnimRecycleViewAdapter.CustomViewHolder>{

    public String[] title;
    public String[] link;
    public Context context;


    public AnimRecycleViewAdapter(Context context , String[]title , String[]link){
        this.context = context;
        this.link = link;
        this.title = title;
    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int row) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_horizontal , viewGroup , false);
        CustomViewHolder customViewHolder = new CustomViewHolder(view);
        return customViewHolder;
    }



    @Override
    public int getLineCount() {
        return 1;
    }



    @Override
    public int getCellsCount(int row) {
        return link.length;
    }


    @Override
    public void onBindViewHolder(CustomViewHolder viewHolder, int i) {
        String titles = title[i];
        viewHolder.textTitle.setText(titles);
        String piclink = link[i];
        Picasso.with(context).load(piclink).into(viewHolder.imageView);

    }

    @Override
    public void onBindCustomView(RecyclerView.ViewHolder viewHolder, int row) {
        super.onBindCustomView(viewHolder, row);
    }

    public class CustomViewHolder  extends MaterialLeanBack.ViewHolder{

        private TextView textTitle;
        public ImageView imageView;

        public CustomViewHolder(View itemView) {
            super(itemView);
            this.textTitle = (TextView) itemView.findViewById(R.id.title);
            this.imageView = (ImageView) itemView.findViewById(R.id.image_view);
        }
    }
}
