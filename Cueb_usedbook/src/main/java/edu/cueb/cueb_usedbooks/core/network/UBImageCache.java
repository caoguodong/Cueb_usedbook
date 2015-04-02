package edu.cueb.cueb_usedbooks.core.network;

import android.graphics.Bitmap;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;

import java.lang.ref.SoftReference;

/**
 * Created by caoguodong on 15/4/2.
 */
public class UBImageCache extends ImageLoader {

//    private SoftReference<Bitmap> cache = new SoftReference<Bitmap>();

    private UBImageCache(RequestQueue queue, ImageCache imageCache) {
        super(queue, imageCache);
    }

    public UBImageCache(RequestQueue queue) {
        super(queue, new ImageCache() {
            @Override
            public Bitmap getBitmap(String s) {
                return null;
            }

            @Override
            public void putBitmap(String s, Bitmap bitmap) {

            }
        });
    }
}
