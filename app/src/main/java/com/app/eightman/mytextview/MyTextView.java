package com.app.eightman.mytextview;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import com.app.eightman.mytextview.R.styleable;


public class MyTextView extends TextView {

    /*
     * Caches typefaces based on their file path and name, so that they don't have to be created
     * every time when they are referenced.
     */
    private static Map<String, Typeface> mTypefaces;

    public MyTextView(final Context context) {
        this(context, null);
    }

    public MyTextView(final Context context, final AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyTextView(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);
        if (mTypefaces == null) {
            mTypefaces = new HashMap<String, Typeface>();
        }


        if (this.isInEditMode()) {
            return;
        }

        final TypedArray array = context.obtainStyledAttributes(attrs, styleable.MyTextView);
        if (array != null) {
            String typefaceAssetPath = null;
            try {
                typefaceAssetPath = array.getString(styleable.MyTextView_customFont) + ".ttf";
                if (typefaceAssetPath != null) {
                    Typeface typeface = null;

                    if (mTypefaces.containsKey(typefaceAssetPath)) {
                        typeface = mTypefaces.get(typefaceAssetPath);
                    } else {
                        AssetManager assets = context.getAssets();
                        typeface = Typeface.createFromAsset(assets, typefaceAssetPath);
                        mTypefaces.put(typefaceAssetPath, typeface);
                    }

                    setTypeface(typeface);
                }
            } catch (Exception e) {

            }


            array.recycle();
        }
    }

}
