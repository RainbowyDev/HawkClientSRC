package com.thealtening.auth;

import java.security.cert.*;
import javax.net.ssl.*;
import java.security.*;

public final class SSLController
{
    private final /* synthetic */ SSLSocketFactory allTrustingFactory;
    private final /* synthetic */ SSLSocketFactory originalFactory;
    private final /* synthetic */ HostnameVerifier originalHostVerifier;
    private static final /* synthetic */ HostnameVerifier ALTENING_HOSTING_VERIFIER;
    private static final /* synthetic */ TrustManager[] ALL_TRUSTING_TRUST_MANAGER;
    
    public void disableCertificateValidation() {
        this.updateCertificateValidation(this.allTrustingFactory, SSLController.ALTENING_HOSTING_VERIFIER);
    }
    
    static {
        ALL_TRUSTING_TRUST_MANAGER = new TrustManager[] { new X509TrustManager() {
                @Override
                public void checkClientTrusted(final X509Certificate[] llllllllllllllllIlIIlllIIIllIIII, final String llllllllllllllllIlIIlllIIIlIllll) {
                }
                
                @Override
                public void checkServerTrusted(final X509Certificate[] llllllllllllllllIlIIlllIIIlIllIl, final String llllllllllllllllIlIIlllIIIlIllII) {
                }
                
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            } };
        ALTENING_HOSTING_VERIFIER = ((lllllllllllllllIlllllIIIIlIIllll, lllllllllllllllIlllllIIIIlIIlllI) -> lllllllllllllllIlllllIIIIlIIllll.equals("authserver.thealtening.com") || lllllllllllllllIlllllIIIIlIIllll.equals("sessionserver.thealtening.com"));
    }
    
    private void updateCertificateValidation(final SSLSocketFactory lllllllllllllllIlllllIIIIlIlIlII, final HostnameVerifier lllllllllllllllIlllllIIIIlIlIIIl) {
        HttpsURLConnection.setDefaultSSLSocketFactory(lllllllllllllllIlllllIIIIlIlIlII);
        HttpsURLConnection.setDefaultHostnameVerifier(lllllllllllllllIlllllIIIIlIlIIIl);
    }
    
    public SSLController() {
        SSLContext lllllllllllllllIlllllIIIIllIIIlI = null;
        try {
            lllllllllllllllIlllllIIIIllIIIlI = SSLContext.getInstance("SSL");
            lllllllllllllllIlllllIIIIllIIIlI.init(null, SSLController.ALL_TRUSTING_TRUST_MANAGER, new SecureRandom());
        }
        catch (NoSuchAlgorithmException | KeyManagementException ex2) {
            final GeneralSecurityException ex;
            final GeneralSecurityException lllllllllllllllIlllllIIIIllIIIIl = ex;
            lllllllllllllllIlllllIIIIllIIIIl.printStackTrace();
        }
        this.allTrustingFactory = lllllllllllllllIlllllIIIIllIIIlI.getSocketFactory();
        this.originalFactory = HttpsURLConnection.getDefaultSSLSocketFactory();
        this.originalHostVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
    }
    
    public void enableCertificateValidation() {
        this.updateCertificateValidation(this.originalFactory, this.originalHostVerifier);
    }
}
