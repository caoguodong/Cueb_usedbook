package edu.cueb.cueb_usedbooks.model;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caoguodong on 15/4/2.
 */
public class NetRequestHolder<T> {

    private NetWorkListener<T> netWorkListener;
    private Response.Listener<JSONObject> listener;
    private Response.ErrorListener errorListener;
    private List<T> res;
    private Class<T> aClass;
    private Gson gson;


    public NetRequestHolder(Class<T> aClass,NetWorkListener<T> netWorkListener){
        res = new ArrayList<T>();
        this.netWorkListener = netWorkListener;
        this.aClass = aClass;
        gson = new Gson();
        initListener();
        initErrorListener();
    }

    public Response.Listener<JSONObject> getListener(){
        return this.listener;
    }

    public Response.ErrorListener getErrorListener(){
        return this.errorListener;
    }

    public void initListener(){
        listener = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                T temp = gson.fromJson(jsonObject.toString(),aClass);
                res.add(temp);
                netWorkListener.onResult(res);
            }
        };
    }

    public void initErrorListener(){
        errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        };
    }
}
