package net.minecraft.util;

import org.apache.logging.log4j.*;
import javax.crypto.spec.*;
import java.io.*;
import java.security.*;
import java.security.spec.*;
import javax.crypto.*;

public class CryptManager
{
    private static final /* synthetic */ Logger field_180198_a;
    
    private static Cipher createTheCipherInstance(final int llllllllllllllllIIIlIIllllllIlll, final String llllllllllllllllIIIlIIllllllIllI, final Key llllllllllllllllIIIlIIllllllllII) {
        try {
            final Cipher llllllllllllllllIIIlIIlllllllIll = Cipher.getInstance(llllllllllllllllIIIlIIllllllIllI);
            llllllllllllllllIIIlIIlllllllIll.init(llllllllllllllllIIIlIIllllllIlll, llllllllllllllllIIIlIIllllllllII);
            return llllllllllllllllIIIlIIlllllllIll;
        }
        catch (InvalidKeyException llllllllllllllllIIIlIIlllllllIlI) {
            llllllllllllllllIIIlIIlllllllIlI.printStackTrace();
        }
        catch (NoSuchAlgorithmException llllllllllllllllIIIlIIlllllllIIl) {
            llllllllllllllllIIIlIIlllllllIIl.printStackTrace();
        }
        catch (NoSuchPaddingException llllllllllllllllIIIlIIlllllllIII) {
            llllllllllllllllIIIlIIlllllllIII.printStackTrace();
        }
        CryptManager.field_180198_a.error("Cipher creation failed!");
        return null;
    }
    
    static {
        __OBFID = "CL_00001483";
        field_180198_a = LogManager.getLogger();
    }
    
    public static byte[] decryptData(final Key llllllllllllllllIIIlIlIIIIIlIIIl, final byte[] llllllllllllllllIIIlIlIIIIIlIIII) {
        return cipherOperation(2, llllllllllllllllIIIlIlIIIIIlIIIl, llllllllllllllllIIIlIlIIIIIlIIII);
    }
    
    public static Cipher func_151229_a(final int llllllllllllllllIIIlIIlllllIllII, final Key llllllllllllllllIIIlIIlllllIllll) {
        try {
            final Cipher llllllllllllllllIIIlIIlllllIlllI = Cipher.getInstance("AES/CFB8/NoPadding");
            llllllllllllllllIIIlIIlllllIlllI.init(llllllllllllllllIIIlIIlllllIllII, llllllllllllllllIIIlIIlllllIllll, new IvParameterSpec(llllllllllllllllIIIlIIlllllIllll.getEncoded()));
            return llllllllllllllllIIIlIIlllllIlllI;
        }
        catch (GeneralSecurityException llllllllllllllllIIIlIIlllllIllIl) {
            throw new RuntimeException(llllllllllllllllIIIlIIlllllIllIl);
        }
    }
    
    public static byte[] encryptData(final Key llllllllllllllllIIIlIlIIIIIllIIl, final byte[] llllllllllllllllIIIlIlIIIIIlIllI) {
        return cipherOperation(1, llllllllllllllllIIIlIlIIIIIllIIl, llllllllllllllllIIIlIlIIIIIlIllI);
    }
    
    public static SecretKey createNewSharedKey() {
        try {
            final KeyGenerator llllllllllllllllIIIlIlIIIlIlIIll = KeyGenerator.getInstance("AES");
            llllllllllllllllIIIlIlIIIlIlIIll.init(128);
            return llllllllllllllllIIIlIlIIIlIlIIll.generateKey();
        }
        catch (NoSuchAlgorithmException llllllllllllllllIIIlIlIIIlIlIIlI) {
            throw new Error(llllllllllllllllIIIlIlIIIlIlIIlI);
        }
    }
    
    public static SecretKey decryptSharedKey(final PrivateKey llllllllllllllllIIIlIlIIIIIlllIl, final byte[] llllllllllllllllIIIlIlIIIIIllllI) {
        return new SecretKeySpec(decryptData(llllllllllllllllIIIlIlIIIIIlllIl, llllllllllllllllIIIlIlIIIIIllllI), "AES");
    }
    
    private static byte[] digestOperation(final String llllllllllllllllIIIlIlIIIIllIIIl, final byte[]... llllllllllllllllIIIlIlIIIIlllIII) {
        try {
            final MessageDigest llllllllllllllllIIIlIlIIIIllIlll = MessageDigest.getInstance(llllllllllllllllIIIlIlIIIIllIIIl);
            final byte[][] llllllllllllllllIIIlIlIIIIllIllI = llllllllllllllllIIIlIlIIIIlllIII;
            for (int llllllllllllllllIIIlIlIIIIllIlIl = llllllllllllllllIIIlIlIIIIlllIII.length, llllllllllllllllIIIlIlIIIIllIlII = 0; llllllllllllllllIIIlIlIIIIllIlII < llllllllllllllllIIIlIlIIIIllIlIl; ++llllllllllllllllIIIlIlIIIIllIlII) {
                final byte[] llllllllllllllllIIIlIlIIIIllIIll = llllllllllllllllIIIlIlIIIIllIllI[llllllllllllllllIIIlIlIIIIllIlII];
                llllllllllllllllIIIlIlIIIIllIlll.update(llllllllllllllllIIIlIlIIIIllIIll);
            }
            return llllllllllllllllIIIlIlIIIIllIlll.digest();
        }
        catch (NoSuchAlgorithmException llllllllllllllllIIIlIlIIIIllIIlI) {
            llllllllllllllllIIIlIlIIIIllIIlI.printStackTrace();
            return null;
        }
    }
    
    public static KeyPair generateKeyPair() {
        try {
            final KeyPairGenerator llllllllllllllllIIIlIlIIIlIIllll = KeyPairGenerator.getInstance("RSA");
            llllllllllllllllIIIlIlIIIlIIllll.initialize(1024);
            return llllllllllllllllIIIlIlIIIlIIllll.generateKeyPair();
        }
        catch (NoSuchAlgorithmException llllllllllllllllIIIlIlIIIlIIlllI) {
            llllllllllllllllIIIlIlIIIlIIlllI.printStackTrace();
            CryptManager.field_180198_a.error("Key pair generation failed!");
            return null;
        }
    }
    
    public static byte[] getServerIdHash(final String llllllllllllllllIIIlIlIIIlIIIlII, final PublicKey llllllllllllllllIIIlIlIIIlIIIIll, final SecretKey llllllllllllllllIIIlIlIIIlIIIIlI) {
        try {
            return digestOperation("SHA-1", new byte[][] { llllllllllllllllIIIlIlIIIlIIIlII.getBytes("ISO_8859_1"), llllllllllllllllIIIlIlIIIlIIIIlI.getEncoded(), llllllllllllllllIIIlIlIIIlIIIIll.getEncoded() });
        }
        catch (UnsupportedEncodingException llllllllllllllllIIIlIlIIIlIIIlIl) {
            llllllllllllllllIIIlIlIIIlIIIlIl.printStackTrace();
            return null;
        }
    }
    
    public static PublicKey decodePublicKey(final byte[] llllllllllllllllIIIlIlIIIIlIIlII) {
        try {
            final X509EncodedKeySpec llllllllllllllllIIIlIlIIIIlIIllI = new X509EncodedKeySpec(llllllllllllllllIIIlIlIIIIlIIlII);
            final KeyFactory llllllllllllllllIIIlIlIIIIlIIlIl = KeyFactory.getInstance("RSA");
            return llllllllllllllllIIIlIlIIIIlIIlIl.generatePublic(llllllllllllllllIIIlIlIIIIlIIllI);
        }
        catch (NoSuchAlgorithmException llllllllllllllllIIIlIlIIIIlIIIll) {}
        catch (InvalidKeySpecException ex) {}
        CryptManager.field_180198_a.error("Public key reconstitute failed!");
        return null;
    }
    
    private static byte[] cipherOperation(final int llllllllllllllllIIIlIlIIIIIIIllI, final Key llllllllllllllllIIIlIlIIIIIIlIlI, final byte[] llllllllllllllllIIIlIlIIIIIIlIIl) {
        try {
            return createTheCipherInstance(llllllllllllllllIIIlIlIIIIIIIllI, llllllllllllllllIIIlIlIIIIIIlIlI.getAlgorithm(), llllllllllllllllIIIlIlIIIIIIlIlI).doFinal(llllllllllllllllIIIlIlIIIIIIlIIl);
        }
        catch (IllegalBlockSizeException llllllllllllllllIIIlIlIIIIIIlIII) {
            llllllllllllllllIIIlIlIIIIIIlIII.printStackTrace();
        }
        catch (BadPaddingException llllllllllllllllIIIlIlIIIIIIIlll) {
            llllllllllllllllIIIlIlIIIIIIIlll.printStackTrace();
        }
        CryptManager.field_180198_a.error("Cipher data failed!");
        return null;
    }
}
