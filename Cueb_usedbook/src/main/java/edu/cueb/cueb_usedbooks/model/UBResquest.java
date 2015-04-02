package edu.cueb.cueb_usedbooks.model;

import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by caoguodong on 15/3/30.
 */
public class UBResquest extends Request<JSONObject>{

    Response.Listener listener;

    public UBResquest(int method,String url, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(method,url,errorListener);
        this.listener = listener;
    }

    @Override
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse networkResponse) {

        String jsonStr = new String(networkResponse.data);
        try {
            JSONObject res = new JSONObject(jsonStr);
            return Response.success(res, HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (JSONException e) {
            return Response.error(new ParseError(e));
        }

    }

    @Override
    protected void deliverResponse(JSONObject jsonObject) {
        listener.onResponse(jsonObject);
    }
}
