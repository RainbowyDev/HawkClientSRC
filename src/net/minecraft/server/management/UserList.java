package net.minecraft.server.management;

import org.apache.logging.log4j.*;
import java.lang.reflect.*;
import com.google.common.base.*;
import com.google.common.io.*;
import org.apache.commons.io.*;
import java.util.*;
import java.io.*;
import com.google.common.collect.*;
import com.google.gson.*;

public class UserList
{
    private final /* synthetic */ Map values;
    protected static final /* synthetic */ Logger logger;
    protected final /* synthetic */ Gson gson;
    private /* synthetic */ boolean lanServer;
    private final /* synthetic */ File saveFile;
    
    protected String getObjectKey(final Object llllllllllllllIllllIIlIIllIlllII) {
        return llllllllllllllIllllIIlIIllIlllII.toString();
    }
    
    protected boolean hasEntry(final Object llllllllllllllIllllIIlIIllIllIII) {
        return this.values.containsKey(this.getObjectKey(llllllllllllllIllllIIlIIllIllIII));
    }
    
    static {
        __OBFID = "CL_00001876";
        logger = LogManager.getLogger();
        saveFileFormat = new ParameterizedType() {
            @Override
            public Type[] getActualTypeArguments() {
                return new Type[] { UserListEntry.class };
            }
            
            @Override
            public Type getRawType() {
                return List.class;
            }
            
            static {
                __OBFID = "CL_00001875";
            }
            
            @Override
            public Type getOwnerType() {
                return null;
            }
        };
    }
    
    private void removeExpired() {
        final ArrayList llllllllllllllIllllIIlIIllIlIIII = Lists.newArrayList();
        for (final UserListEntry llllllllllllllIllllIIlIIllIIlllI : this.values.values()) {
            if (llllllllllllllIllllIIlIIllIIlllI.hasBanExpired()) {
                llllllllllllllIllllIIlIIllIlIIII.add(llllllllllllllIllllIIlIIllIIlllI.getValue());
            }
        }
        for (final Object llllllllllllllIllllIIlIIllIIllIl : llllllllllllllIllllIIlIIllIlIIII) {
            this.values.remove(llllllllllllllIllllIIlIIllIIllIl);
        }
    }
    
    public UserListEntry getEntry(final Object llllllllllllllIllllIIlIIlllIllII) {
        this.removeExpired();
        return this.values.get(this.getObjectKey(llllllllllllllIllllIIlIIlllIllII));
    }
    
    public void writeChanges() throws IOException {
        final Collection llllllllllllllIllllIIlIIlIlllIll = this.values.values();
        final String llllllllllllllIllllIIlIIlIlllIlI = this.gson.toJson((Object)llllllllllllllIllllIIlIIlIlllIll);
        BufferedWriter llllllllllllllIllllIIlIIlIlllIIl = null;
        try {
            llllllllllllllIllllIIlIIlIlllIIl = Files.newWriter(this.saveFile, Charsets.UTF_8);
            llllllllllllllIllllIIlIIlIlllIIl.write(llllllllllllllIllllIIlIIlIlllIlI);
        }
        finally {
            IOUtils.closeQuietly((Writer)llllllllllllllIllllIIlIIlIlllIIl);
        }
        IOUtils.closeQuietly((Writer)llllllllllllllIllllIIlIIlIlllIIl);
    }
    
    public String[] getKeys() {
        return (String[])this.values.keySet().toArray(new String[this.values.size()]);
    }
    
    protected Map getValues() {
        return this.values;
    }
    
    public boolean isLanServer() {
        return this.lanServer;
    }
    
    public void setLanServer(final boolean llllllllllllllIllllIIlIIllllllIl) {
        this.lanServer = llllllllllllllIllllIIlIIllllllIl;
    }
    
    protected UserListEntry createEntry(final JsonObject llllllllllllllIllllIIlIIllIIIllI) {
        return new UserListEntry(null, llllllllllllllIllllIIlIIllIIIllI);
    }
    
    public void removeEntry(final Object llllllllllllllIllllIIlIIlllIIlll) {
        this.values.remove(this.getObjectKey(llllllllllllllIllllIIlIIlllIIlll));
        try {
            this.writeChanges();
        }
        catch (IOException llllllllllllllIllllIIlIIlllIIllI) {
            UserList.logger.warn("Could not save the list after removing a user.", (Throwable)llllllllllllllIllllIIlIIlllIIllI);
        }
    }
    
    public UserList(final File llllllllllllllIllllIIlIlIIIIlIII) {
        this.values = Maps.newHashMap();
        this.lanServer = true;
        this.saveFile = llllllllllllllIllllIIlIlIIIIlIII;
        final GsonBuilder llllllllllllllIllllIIlIlIIIIIlll = new GsonBuilder().setPrettyPrinting();
        llllllllllllllIllllIIlIlIIIIIlll.registerTypeHierarchyAdapter((Class)UserListEntry.class, (Object)new Serializer(null));
        this.gson = llllllllllllllIllllIIlIlIIIIIlll.create();
    }
    
    public void addEntry(final UserListEntry llllllllllllllIllllIIlIIllllIIll) {
        this.values.put(this.getObjectKey(llllllllllllllIllllIIlIIllllIIll.getValue()), llllllllllllllIllllIIlIIllllIIll);
        try {
            this.writeChanges();
        }
        catch (IOException llllllllllllllIllllIIlIIllllIlIl) {
            UserList.logger.warn("Could not save the list after adding a user.", (Throwable)llllllllllllllIllllIIlIIllllIlIl);
        }
    }
    
    class Serializer implements JsonSerializer, JsonDeserializer
    {
        private Serializer() {
        }
        
        Serializer(final UserList llllllllllllllIIllIIIIIIlIlIIIll, final Object llllllllllllllIIllIIIIIIlIlIIlIl) {
            this(llllllllllllllIIllIIIIIIlIlIIIll);
        }
        
        static {
            __OBFID = "CL_00001874";
        }
        
        public JsonElement serializeEntry(final UserListEntry llllllllllllllIIllIIIIIIllIlIIII, final Type llllllllllllllIIllIIIIIIllIlIIll, final JsonSerializationContext llllllllllllllIIllIIIIIIllIlIIlI) {
            final JsonObject llllllllllllllIIllIIIIIIllIlIIIl = new JsonObject();
            llllllllllllllIIllIIIIIIllIlIIII.onSerialization(llllllllllllllIIllIIIIIIllIlIIIl);
            return (JsonElement)llllllllllllllIIllIIIIIIllIlIIIl;
        }
        
        public Object deserialize(final JsonElement llllllllllllllIIllIIIIIIlIlIlIll, final Type llllllllllllllIIllIIIIIIlIlIlllI, final JsonDeserializationContext llllllllllllllIIllIIIIIIlIlIlIIl) {
            return this.deserializeEntry(llllllllllllllIIllIIIIIIlIlIlIll, llllllllllllllIIllIIIIIIlIlIlllI, llllllllllllllIIllIIIIIIlIlIlIIl);
        }
        
        public UserListEntry deserializeEntry(final JsonElement llllllllllllllIIllIIIIIIllIIIIll, final Type llllllllllllllIIllIIIIIIllIIlIII, final JsonDeserializationContext llllllllllllllIIllIIIIIIllIIIlll) {
            if (llllllllllllllIIllIIIIIIllIIIIll.isJsonObject()) {
                final JsonObject llllllllllllllIIllIIIIIIllIIIllI = llllllllllllllIIllIIIIIIllIIIIll.getAsJsonObject();
                final UserListEntry llllllllllllllIIllIIIIIIllIIIlIl = UserList.this.createEntry(llllllllllllllIIllIIIIIIllIIIllI);
                return llllllllllllllIIllIIIIIIllIIIlIl;
            }
            return null;
        }
        
        public JsonElement serialize(final Object llllllllllllllIIllIIIIIIlIlllIll, final Type llllllllllllllIIllIIIIIIlIllIllI, final JsonSerializationContext llllllllllllllIIllIIIIIIlIlllIIl) {
            return this.serializeEntry((UserListEntry)llllllllllllllIIllIIIIIIlIlllIll, llllllllllllllIIllIIIIIIlIllIllI, llllllllllllllIIllIIIIIIlIlllIIl);
        }
    }
}
