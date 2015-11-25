package com.zhy.sample_okhttp;

import android.app.Application;

import com.zhy.http.okhttp.OkHttpClientManager;

import org.apache.http.conn.ssl.X509HostnameVerifier;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.security.cert.X509Certificate;

import okio.Buffer;

/**
 * Created by zhy on 15/8/25.
 */
public class MyApplication extends Application
{
    private String CER_12306 = "-----BEGIN CERTIFICATE-----\n" +
            "MIICmjCCAgOgAwIBAgIIbyZr5/jKH6QwDQYJKoZIhvcNAQEFBQAwRzELMAkGA1UEBhMCQ04xKTAn\n" +
            "BgNVBAoTIFNpbm9yYWlsIENlcnRpZmljYXRpb24gQXV0aG9yaXR5MQ0wCwYDVQQDEwRTUkNBMB4X\n" +
            "DTA5MDUyNTA2NTYwMFoXDTI5MDUyMDA2NTYwMFowRzELMAkGA1UEBhMCQ04xKTAnBgNVBAoTIFNp\n" +
            "bm9yYWlsIENlcnRpZmljYXRpb24gQXV0aG9yaXR5MQ0wCwYDVQQDEwRTUkNBMIGfMA0GCSqGSIb3\n" +
            "DQEBAQUAA4GNADCBiQKBgQDMpbNeb34p0GvLkZ6t72/OOba4mX2K/eZRWFfnuk8e5jKDH+9BgCb2\n" +
            "9bSotqPqTbxXWPxIOz8EjyUO3bfR5pQ8ovNTOlks2rS5BdMhoi4sUjCKi5ELiqtyww/XgY5iFqv6\n" +
            "D4Pw9QvOUcdRVSbPWo1DwMmH75It6pk/rARIFHEjWwIDAQABo4GOMIGLMB8GA1UdIwQYMBaAFHle\n" +
            "tne34lKDQ+3HUYhMY4UsAENYMAwGA1UdEwQFMAMBAf8wLgYDVR0fBCcwJTAjoCGgH4YdaHR0cDov\n" +
            "LzE5Mi4xNjguOS4xNDkvY3JsMS5jcmwwCwYDVR0PBAQDAgH+MB0GA1UdDgQWBBR5XrZ3t+JSg0Pt\n" +
            "x1GITGOFLABDWDANBgkqhkiG9w0BAQUFAAOBgQDGrAm2U/of1LbOnG2bnnQtgcVaBXiVJF8LKPaV\n" +
            "23XQ96HU8xfgSZMJS6U00WHAI7zp0q208RSUft9wDq9ee///VOhzR6Tebg9QfyPSohkBrhXQenvQ\n" +
            "og555S+C3eJAAVeNCTeMS3N/M5hzBRJAoffn3qoYdAO1Q8bTguOi+2849A==\n" +
            "-----END CERTIFICATE-----";
    private String CER_TEST="-----BEGIN CERTIFICATE-----\n" +
            "MIICcTCCAdoCCQC01YXqTV/YaTANBgkqhkiG9w0BAQsFADB9MQswCQYDVQQGEwJD\n" +
            "TjERMA8GA1UECAwITGlhb05pbmcxDzANBgNVBAcMBkRhTGlhbjENMAsGA1UECgwE\n" +
            "Sm95ZTEMMAoGA1UECwwDVEVDMQ0wCwYDVQQDDARUZXN0MR4wHAYJKoZIhvcNAQkB\n" +
            "Fg9iaW5nQGdvb29rdS5jb20wHhcNMTUwNjI1MDk0NjQwWhcNMTYwNjI0MDk0NjQw\n" +
            "WjB9MQswCQYDVQQGEwJDTjERMA8GA1UECAwITGlhb05pbmcxDzANBgNVBAcMBkRh\n" +
            "TGlhbjENMAsGA1UECgwESm95ZTEMMAoGA1UECwwDVEVDMQ0wCwYDVQQDDARUZXN0\n" +
            "MR4wHAYJKoZIhvcNAQkBFg9iaW5nQGdvb29rdS5jb20wgZ8wDQYJKoZIhvcNAQEB\n" +
            "BQADgY0AMIGJAoGBAKz8NwIn4l+MC/ShiPQz8Zxy2MnYOlJH/clqIVpeaTm5krBH\n" +
            "OnBSeTJStcRFCQj2DTWDzwVJPT6128RDSy/ZdSEoHJCeR76YbhQnU0gGQARPEjRY\n" +
            "2eASh6+CT/qkELIz/erz0/+disSamkSn5xZuyQ46ouTPvBjAh+ApFOPNBtiTAgMB\n" +
            "AAEwDQYJKoZIhvcNAQELBQADgYEAJUJunR4qjgbVbYUEWEMpqrVsB+RenZzPYNvE\n" +
            "g9D+BHk5GW2jhLn21CdPqwpDY6x8SRTLroN8SuRHT8z8KEpAqzjtx1stRRUY/q7t\n" +
            "h7OOTKON4ok4qbC2k8xvRECVO3VkiJ0aIceg2DfPaWSVFbtxMTaNvPeaVF5jC7QR\n" +
            "GMDu2WQ=\n" +
            "-----END CERTIFICATE-----";

    @Override
    public void onCreate()
    {
        super.onCreate();
/*        OkHttpClientManager.getInstance().setCertificates(new InputStream[]{
                new Buffer()
                        .writeUtf8(CER_TEST)
                        .inputStream()});*/
        OkHttpClientManager.getInstance().setCertificate(getApplicationContext(),"server.crt");

/*        try
        {
            OkHttpClientManager.getInstance()
                    .setCertificates(
//                            getAssets().open("aaa.cer"),
                            getAssets().open("server.crt"));
        } catch (Exception e)
        {
            e.printStackTrace();
        }*/
    }
}
