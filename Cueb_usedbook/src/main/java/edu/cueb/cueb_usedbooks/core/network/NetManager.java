package edu.cueb.cueb_usedbooks.core.network;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by caoguodong on 2015/3/12.
 */
public class NetManager {

    private RequestQueue mQueue;
    private Context context;
    private NetManager(){
        mQueue = Volley.newRequestQueue(context);
    }

    public static class Holder{
        public static NetManager InstantHolder = new NetManager();
    }

    public NetManager getInstance(){
        return Holder.InstantHolder;
    }

    public void init(Context context){
        this.context = context;
    }

    public void checkBookInfo(){

    }

}
