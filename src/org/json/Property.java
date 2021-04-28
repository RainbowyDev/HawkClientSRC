package org.json;

import java.util.*;

public class Property
{
    public static JSONObject toJSONObject(final Properties llllllllllllllIIIIIIlIIIlllIlIll) throws JSONException {
        final JSONObject llllllllllllllIIIIIIlIIIlllIlIlI = new JSONObject();
        if (llllllllllllllIIIIIIlIIIlllIlIll != null && !llllllllllllllIIIIIIlIIIlllIlIll.isEmpty()) {
            final Enumeration<?> llllllllllllllIIIIIIlIIIlllIllII = llllllllllllllIIIIIIlIIIlllIlIll.propertyNames();
            while (llllllllllllllIIIIIIlIIIlllIllII.hasMoreElements()) {
                final String llllllllllllllIIIIIIlIIIlllIllIl = (String)llllllllllllllIIIIIIlIIIlllIllII.nextElement();
                llllllllllllllIIIIIIlIIIlllIlIlI.put(llllllllllllllIIIIIIlIIIlllIllIl, llllllllllllllIIIIIIlIIIlllIlIll.getProperty(llllllllllllllIIIIIIlIIIlllIllIl));
            }
        }
        return llllllllllllllIIIIIIlIIIlllIlIlI;
    }
    
    public static Properties toProperties(final JSONObject llllllllllllllIIIIIIlIIIllIlllII) throws JSONException {
        final Properties llllllllllllllIIIIIIlIIIllIlllIl = new Properties();
        if (llllllllllllllIIIIIIlIIIllIlllII != null) {
            for (final String llllllllllllllIIIIIIlIIIllIlllll : llllllllllllllIIIIIIlIIIllIlllII.keySet()) {
                final Object llllllllllllllIIIIIIlIIIlllIIIII = llllllllllllllIIIIIIlIIIllIlllII.opt(llllllllllllllIIIIIIlIIIllIlllll);
                if (!JSONObject.NULL.equals(llllllllllllllIIIIIIlIIIlllIIIII)) {
                    ((Hashtable<String, String>)llllllllllllllIIIIIIlIIIllIlllIl).put(llllllllllllllIIIIIIlIIIllIlllll, llllllllllllllIIIIIIlIIIlllIIIII.toString());
                }
            }
        }
        return llllllllllllllIIIIIIlIIIllIlllIl;
    }
}
