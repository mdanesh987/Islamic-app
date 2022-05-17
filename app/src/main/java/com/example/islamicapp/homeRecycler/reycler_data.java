package com.example.islamicapp.homeRecycler;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class reycler_data  {
    private int leading;
    String title,subtitle;

    public reycler_data(int leading, String title, String subtitle) {
        this.leading = leading;
        this.title = title;
        this.subtitle = subtitle;
    }

    public int getLeading() {
        return leading;
    }

    public void setLeading(int leading) {
        this.leading = leading;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
