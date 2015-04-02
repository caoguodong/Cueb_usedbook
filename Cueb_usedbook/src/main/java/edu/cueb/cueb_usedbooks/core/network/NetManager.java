package edu.cueb.cueb_usedbooks.core.network;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import edu.cueb.cueb_usedbooks.model.NetRequestHolder;
import edu.cueb.cueb_usedbooks.model.NetWorkListener;
import edu.cueb.cueb_usedbooks.model.UBResquest;
import edu.cueb.cueb_usedbooks.model.classN.Book;

/**
 * Created by caoguodong on 2015/3/12.
 */
public class NetManager {

    private RequestQueue mQueue;
    private UBImageCache ubImageCache;
    private Context context;
    private NetManager(){
    }

    private static class Holder{
        public static NetManager InstantHolder = new NetManager();
    }

    public static NetManager getInstance(){
        return Holder.InstantHolder;
    }

    public void init(Context context){
        this.context = context;
        mQueue = Volley.newRequestQueue(context);
        ubImageCache = new UBImageCache(mQueue);
    }

    public void checkBookInfo(NetWorkListener<Book> holder ,String isbn){
        NetRequestHolder<Book> requestHolder = new NetRequestHolder<>(Book.class,holder);
        UBResquest ubResquest = new UBResquest(Request.Method.GET,ApiHelper.GETBOOKINFOURL+isbn,requestHolder.getListener(),requestHolder.getErrorListener());
        mQueue.add(ubResquest);
    }

    public UBImageCache getUbImageCache() {
        return ubImageCache;
    }

}
