package com.example.zoomtouchimageview;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.RecyclerView;
import com.ortiz.touchview.TouchImageView;

public class ContentViewHolder extends RecyclerView.ViewHolder {

    TouchImageView touchImageView;
    RelativeLayout root;

    public ContentViewHolder(View itemView) {
        super(itemView);

        root = itemView.findViewById(R.id.root);
        touchImageView = itemView.findViewById(R.id.touchImageView);

    }

    public void bindView(String model) {

        touchImageView.setImageResource(R.drawable.ic_launcher_background);
    }

    @SuppressLint("ClickableViewAccessibility")
    public void setOnClivkListener(String model, int position) {

        touchImageView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                // Disallow the touch request for parent scroll on touch of  child view
                if(touchImageView.isZoomed())
                    root.requestDisallowInterceptTouchEvent(true);
                else
                    root.requestDisallowInterceptTouchEvent(false);
                return false;
            }
        });
    }
}
