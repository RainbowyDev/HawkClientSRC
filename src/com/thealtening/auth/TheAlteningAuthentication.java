package com.thealtening.auth;

import com.thealtening.auth.service.*;

public final class TheAlteningAuthentication
{
    private final /* synthetic */ ServiceSwitcher serviceSwitcher;
    private final /* synthetic */ SSLController sslController;
    private /* synthetic */ AlteningServiceType service;
    private static /* synthetic */ TheAlteningAuthentication instance;
    
    private static TheAlteningAuthentication withService(final AlteningServiceType lllllllllllllllllIllIIllllllIIlI) {
        if (TheAlteningAuthentication.instance == null) {
            TheAlteningAuthentication.instance = new TheAlteningAuthentication(lllllllllllllllllIllIIllllllIIlI);
        }
        else if (TheAlteningAuthentication.instance.getService() != lllllllllllllllllIllIIllllllIIlI) {
            TheAlteningAuthentication.instance.updateService(lllllllllllllllllIllIIllllllIIlI);
        }
        return TheAlteningAuthentication.instance;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$com$thealtening$auth$service$AlteningServiceType() {
        final int[] $switch_TABLE$com$thealtening$auth$service$AlteningServiceType = TheAlteningAuthentication.$SWITCH_TABLE$com$thealtening$auth$service$AlteningServiceType;
        if ($switch_TABLE$com$thealtening$auth$service$AlteningServiceType != null) {
            return $switch_TABLE$com$thealtening$auth$service$AlteningServiceType;
        }
        final short lllllllllllllllllIllIIlllllIllll = (Object)new int[AlteningServiceType.values().length];
        try {
            lllllllllllllllllIllIIlllllIllll[AlteningServiceType.MOJANG.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllllllIllIIlllllIllll[AlteningServiceType.THEALTENING.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        return TheAlteningAuthentication.$SWITCH_TABLE$com$thealtening$auth$service$AlteningServiceType = (int[])(Object)lllllllllllllllllIllIIlllllIllll;
    }
    
    private TheAlteningAuthentication(final AlteningServiceType lllllllllllllllllIllIIllllllllIl) {
        this.serviceSwitcher = new ServiceSwitcher();
        this.sslController = new SSLController();
        this.updateService(lllllllllllllllllIllIIllllllllIl);
    }
    
    public AlteningServiceType getService() {
        return this.service;
    }
    
    public static TheAlteningAuthentication mojang() {
        return withService(AlteningServiceType.MOJANG);
    }
    
    public static TheAlteningAuthentication theAltening() {
        return withService(AlteningServiceType.THEALTENING);
    }
    
    public void updateService(final AlteningServiceType lllllllllllllllllIllIIllllllIlll) {
        if (lllllllllllllllllIllIIllllllIlll == null || this.service == lllllllllllllllllIllIIllllllIlll) {
            return;
        }
        switch ($SWITCH_TABLE$com$thealtening$auth$service$AlteningServiceType()[lllllllllllllllllIllIIllllllIlll.ordinal()]) {
            case 1: {
                this.sslController.enableCertificateValidation();
                break;
            }
            case 2: {
                this.sslController.disableCertificateValidation();
                break;
            }
        }
        this.service = this.serviceSwitcher.switchToService(lllllllllllllllllIllIIllllllIlll);
    }
}
