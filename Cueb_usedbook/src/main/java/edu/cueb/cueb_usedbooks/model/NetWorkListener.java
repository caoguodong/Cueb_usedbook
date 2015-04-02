package edu.cueb.cueb_usedbooks.model;

import java.util.List;

/**
 * Created by caoguodong on 15/4/2.
 */
public interface NetWorkListener<T> {

    public void onResult(List<T> res);

    public void onError(int errorType,String error);
}
