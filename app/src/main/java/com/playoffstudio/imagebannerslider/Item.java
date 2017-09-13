package com.playoffstudio.imagebannerslider;

/**
 * Created by android on 9/13/2017.
 */

public class Item {

    public String name;
    public String link;

    public Item(){

    }

    public Item(String name , String link){
        this.name = name;
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public String getName() {
        return name;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setName(String name) {
        this.name = name;
    }
}
