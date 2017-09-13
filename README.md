# ImageBannerSlider
image banner sliding using json

# ShowCaseExammple
showcase example

<p align="center">
  <img src="https://raw.githubusercontent.com/paveltech/ImageBannerSlider/master/device-2017-09-13-204327.png" height="700" width="390"/>
</p>



# Json file 

[

	{
		"name": "Shout Out",
		"link": "http://blog.karachicorner.com/wp-content/uploads/2013/04/Bullet+to+the+Head+movie+posters.jpg"
	}, {
		"name": "UnStopAble",
		"link": "http://www.theshiznit.co.uk/media/NewsNov2010/sparks-unstoppable.jpg"
	}, {
		"name": "Rise Of the",
		"link": "https://blog.richmond.edu/heroes/files/2012/12/rise-of-the-guardians-2012-hollywood-movie-poster.jpg"
	}, {
		"name": "Luke Cage",
		"link": "https://s-media-cache-ak0.pinimg.com/originals/f5/43/70/f54370ba7e10ea0f4a6df5c07f2d69f0.jpg"
	}, {
		"name": "Adjust",
		"link": "http://media.new.mensxp.com/media/content/2016/Apr/ranveer-and-deepika-photoshopped-on-hollywood-movie-posters3-1460104322.jpg"
	}

]



# Java Code



```java

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

```


