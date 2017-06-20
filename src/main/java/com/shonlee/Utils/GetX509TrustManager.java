package com.shonlee.Utils;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Created by ShonLee on 2017/6/12.
 */
public class GetX509TrustManager implements X509TrustManager {
    //检车客服端证书
    @Override
    public void checkClientTrusted(X509Certificate[] chain , String authType)
            throws CertificateException {

    }

    //检查服务器端证书
    @Override
    public void checkServerTrusted(X509Certificate[] chain , String authType)
            throws CertificateException {

    }

    //返回受信任的X509证书
    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}
