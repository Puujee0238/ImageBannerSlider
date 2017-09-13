package com.playoffstudio.imagebannerslider;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.RemoteBanner;
import ss.com.bannerslider.events.OnBannerClickListener;
import ss.com.bannerslider.views.BannerSlider;

public class BannerImageSlider extends AppCompatActivity {



    public final List<Item> itemList = new ArrayList<>();

    @Bind(R.id.banner_slider1)
    BannerSlider bannerSlider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_image_slider);

        ButterKnife.bind(this);
        jsonCall();


    }



    public void jsonCall(){
        JsonArrayRequest movieReq = new JsonArrayRequest("http://banglahdnatok.com/change.txt",
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("", response.toString());



                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                Item song = new Item();
                                song.setName(obj.getString("name"));
                                song.setLink(obj.getString("link"));

                                itemList.add(song);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                        startSlider();

                        // notifying list adapter about data changes
                        // so that it renders the list view with updated data

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("", "Error: " + error.getMessage());


            }
        });
        movieReq.setShouldCache(false);
        //AppController.getInstance().getRequestQueue().getCache().remove(SonConstant.songs);
        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(movieReq);
    }



    public void startSlider(){
        Toast.makeText(BannerImageSlider.this, ""+itemList.size(), Toast.LENGTH_SHORT).show();
        BannerSlider bannerSlider = (BannerSlider) findViewById(R.id.banner_slider1);
        List<Banner> banners=new ArrayList<>();

        for (int i=0; i<itemList.size();i++){

            Item item = itemList.get(i);

            banners.add(new RemoteBanner(item.getLink()));
        }
        bannerSlider.setBanners(banners);


        bannerSlider.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void onClick(int position) {
                Item item = itemList.get(position);
                Toast.makeText(BannerImageSlider.this, "Banner with position "+item.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
