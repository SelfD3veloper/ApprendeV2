package com.cbedoy.apprende.widgets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.cbedoy.apprende.R;

/**
 * Created by Carlos on 25/10/2014.
 */
public class NavigationBar
{
    private INavigationBarDelegate navigationBarDelegate;
    private ImageView actionBack;

    public void initWithView(View view){
        if(view != null){
            actionBack = (ImageView) view.findViewById(R.id.acion_back);
            actionBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(navigationBarDelegate != null)
                        navigationBarDelegate.showPreviewViewController();
                }
            });
        }
    }

    public void setNavigationBarDelegate(INavigationBarDelegate navigationBarDelegate) {
        this.navigationBarDelegate = navigationBarDelegate;
    }

    public interface  INavigationBarDelegate{
        public void showPreviewViewController();
    }
}
