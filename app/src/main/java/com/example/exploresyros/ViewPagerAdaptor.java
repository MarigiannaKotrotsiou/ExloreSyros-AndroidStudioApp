package com.example.exploresyros;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ViewPagerAdaptor extends PagerAdapter {

    Context context;

    //βάζω τα στοιχεία που θα έχει κάθε slide: εικόνα, τίτλος, περιγραφή
    int images[] = {

            R.drawable.welcome,
            R.drawable.discover1,
            R.drawable.discover2,
            R.drawable.enjoy
    };

    int headings[] = {

            R.string.heading1,
            R.string.heading2,
            R.string.heading3,
            R.string.heading4
    };

    int descriptions [] = {

            R.string.description1,
            R.string.description2,
            R.string.description3,
            R.string.description4
    };

    public ViewPagerAdaptor(Context context){

        this.context = context;
    }


    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //δηλώνω τα views που θα πέρνουν το περιεχόμενο, βάσει id
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_layout,container,false);

        ImageView slidetitleimage = (ImageView) view.findViewById(R.id.titleImage);
        TextView slideHeading = (TextView) view.findViewById(R.id.texttitle);
        TextView slideDescription = (TextView) view.findViewById(R.id.textdeccription);

        slidetitleimage.setImageResource(images[position]);
        slideHeading.setText(headings[position]);
        slideDescription.setText(descriptions[position]);

        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((LinearLayout)object);
    }
}
