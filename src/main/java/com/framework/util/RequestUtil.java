package com.framework.util;

import net.sf.json.JSONObject;
import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder; 
import java.util.Map;
import java.util.HashMap;

/**
 * Created by nick on 17. 5. 12.
 */
public class RequestUtil {
 
    /*
    * request parameter converting to Map
    * */
    public static Map<String, Object> getParameterMap(HttpServletRequest request) throws Exception{
        Map<String, Object> result = new HashMap<String, Object>();

        @SuppressWarnings("unchecked")
        Map<String, String[]> requestMap = request.getParameterMap();

        for (String key : requestMap.keySet()){
            if (Constant.IN_DATA_JSON.equals(key)){
                String jsonStr = request.getParameter(Constant.IN_DATA_JSON);
                jsonStr = URLDecoder.decode(jsonStr, "UTF-8");
                jsonStr = jsonStr.replaceAll("\n", "\\\\n");
                JSONObject json = JSONObject.fromObject(jsonStr);

                result.putAll(StrUtil.jsonObjToMap(json));
                continue;
            }

            String[] params = (String[]) requestMap.get(key);
            if (params.length > 1){
                // 한글 인코딩(주소창 입력 형식, javascript encode 방식 호환)
                for (int i=0; i < params.length; i++){
                    params[i] = URLDecoder.decode(new String(params[i].getBytes("8859_1"), "EUC-KR"), "UTF-8");
                }

                result.put(key.replaceAll("[\\[\\]]", ""), params);
            }
            else {
                String param = URLDecoder.decode(new String(params[0].getBytes("8859_1"), "EUC-KR"), "UTF-8");
                result.put(key.replaceAll("[\\[\\]]", ""), param);
            }
        }

        return result;
    }
}
