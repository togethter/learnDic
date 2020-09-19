package it.cast.web.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
public class DownLoadUtils {
    public static String getFileName(String agent,String filename) throws UnsupportedEncodingException {

//        MSIE
//        Firefox
        if (agent.contains("MSIE")){
            filename = URLEncoder.encode("utf-8");
            filename = filename.replace("+"," ");
        } else if (agent.contains("Firefox")){
//            Base64.Encoder encoder = new Base64.Encoder();
//            filename = "=?utf-8?B?" + base64Encoder.encode(filename.getBytes("utf-8")) + "?=";

        } else {
            filename = URLEncoder.encode(filename,"utf-8");
        }
        return filename;

    }
}
