package com.zhy.http.okhttp.request;

import java.util.Map;

/**
 * Created by cy on 2015/11/24.
 */
public class OKHttpRequestIPUrl extends OkHttpGetRequest{
    protected OKHttpRequestIPUrl(String url, Object tag, Map<String, String> params, Map<String, String> headers) {
        super(url, tag, params, headers);
    }

}
