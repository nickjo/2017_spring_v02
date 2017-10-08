package com.framework.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.collections.map.HashedMap;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by nick on 17. 5. 12.
 */
public class StrUtil {

    /**
     * JSONObject 를 Map 로 변환하는 메서드<br>
     * 내부 JSONObject, JSONArray 재귀 변환
     * @param json 변환 대상 JSONObject
     * @return 변환된 Map
     */
    public static Map<String, Object> jsonObjToMap(JSONObject json){
        Map<String, Object> result = new HashMap<String, Object>();

        @SuppressWarnings("unchecked")
        Iterator<String> keys = json.keys();
        while (keys.hasNext()){
            String key = keys.next();
            Object value = json.get(key);

            if(value instanceof JSONObject){
                result.put(key, jsonObjToMap((JSONObject)value));
            }
            else if (value instanceof JSONArray){
                result.put(key, jsonArrToList((JSONArray)value));
            }
            else{
                result.put(key, value);
            }
        }

        return result;
    }

    /**
     * JSONArray 를 List 로 변환하는 메서드<br>
     * 내부 JSONObject, JSONArray 재귀 변환
     * @param json 변환 대상 JSONArray
     * @return 변환된 List
     */
    public static List<Object> jsonArrToList(JSONArray json){
        List<Object> result = new ArrayList<Object>();

        @SuppressWarnings("unchecked")
        Iterator<Object> iter = json.iterator();
        while (iter.hasNext()){
            Object value = iter.next();

            if (value instanceof JSONObject){
                result.add(jsonObjToMap((JSONObject)value));
            }
            else if (value instanceof JSONArray){
                result.add(jsonArrToList((JSONArray)value));
            }
            else{
                result.add(value);
            }
        }

        return result;
    }
}