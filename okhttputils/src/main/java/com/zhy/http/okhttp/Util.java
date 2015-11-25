package com.zhy.http.okhttp;

/**
 * Created by cy on 2015/11/24.
 */
public class Util {
    public static boolean containIP (String url) {
        String temp=url.split("/")[2];
        String host=temp.contains(":")?temp.split("\\:")[0]:temp;
//        System.out.println(host);

        try {
            if ( host == null || host.isEmpty() ) {
                return false;
            }

            String[] parts = host.split( "\\." );
            if ( parts.length != 4 ) {
                return false;
            }

            for ( String s : parts ) {
                int i = Integer.parseInt( s );
                if ( (i < 0) || (i > 255) ) {
                    return false;
                }
            }
            if ( host.endsWith(".") ) {
                return false;
            }

            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
