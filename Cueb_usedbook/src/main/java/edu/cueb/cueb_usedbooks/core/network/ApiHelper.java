package edu.cueb.cueb_usedbooks.core.network;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by caoguodong on 2015/3/12.
 */
public class ApiHelper {

    public static final  String ROOTURL = "10.0.17.8/";
    //前缀
    public static final String GETUPLOADTOKEN = "getuploadtoken";


    //字段


    //
    public String getUrl(String key,HashMap<String,String> params){
        StringBuffer sb = new StringBuffer(0);
        sb.append(ROOTURL);
        sb.append(key+".php");
        if (params.size() <=0){
            return sb.toString();
        }
        Set<String> keySet =  params.keySet();
        Iterator<String> iterator = keySet.iterator();
        int i = 0;
        while (iterator.hasNext()){
            if (i==0){
                sb.append("?");
            }else {
                sb.append("&");
            }
            String mapKey = iterator.next();
            sb.append(mapKey+"="+params.get(mapKey));
            i++;
        }
        return sb.toString();
    }
}
