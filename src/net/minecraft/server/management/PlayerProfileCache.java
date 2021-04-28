package net.minecraft.server.management;

import java.text.*;
import net.minecraft.server.*;
import com.mojang.authlib.*;
import net.minecraft.entity.player.*;
import com.google.common.collect.*;
import java.lang.reflect.*;
import java.util.*;
import com.google.common.base.*;
import com.google.common.io.*;
import org.apache.commons.io.*;
import java.io.*;
import com.google.gson.*;

public class PlayerProfileCache
{
    private final /* synthetic */ Map field_152662_d;
    private static final /* synthetic */ ParameterizedType field_152666_h;
    public static final /* synthetic */ SimpleDateFormat dateFormat;
    protected final /* synthetic */ Gson gson;
    private final /* synthetic */ File usercacheFile;
    private final /* synthetic */ LinkedList field_152663_e;
    private final /* synthetic */ MinecraftServer field_152664_f;
    private final /* synthetic */ Map field_152661_c;
    
    public void func_152649_a(final GameProfile lllllllllllllllIllIIIIIlIIIIlIII) {
        this.func_152651_a(lllllllllllllllIllIIIIIlIIIIlIII, null);
    }
    
    public PlayerProfileCache(final MinecraftServer lllllllllllllllIllIIIIIlIIlIIllI, final File lllllllllllllllIllIIIIIlIIlIIIIl) {
        this.field_152661_c = Maps.newHashMap();
        this.field_152662_d = Maps.newHashMap();
        this.field_152663_e = Lists.newLinkedList();
        this.field_152664_f = lllllllllllllllIllIIIIIlIIlIIllI;
        this.usercacheFile = lllllllllllllllIllIIIIIlIIlIIIIl;
        final GsonBuilder lllllllllllllllIllIIIIIlIIlIIlII = new GsonBuilder();
        lllllllllllllllIllIIIIIlIIlIIlII.registerTypeHierarchyAdapter((Class)ProfileEntry.class, (Object)new Serializer(null));
        this.gson = lllllllllllllllIllIIIIIlIIlIIlII.create();
        this.func_152657_b();
    }
    
    public String[] func_152654_a() {
        final ArrayList lllllllllllllllIllIIIIIIllIllllI = Lists.newArrayList((Iterable)this.field_152661_c.keySet());
        return lllllllllllllllIllIIIIIIllIllllI.toArray(new String[lllllllllllllllIllIIIIIIllIllllI.size()]);
    }
    
    private static GameProfile func_152650_a(final MinecraftServer lllllllllllllllIllIIIIIlIIIllIIl, final String lllllllllllllllIllIIIIIlIIIllIII) {
        final GameProfile[] lllllllllllllllIllIIIIIlIIIlIlll = { null };
        final ProfileLookupCallback lllllllllllllllIllIIIIIlIIIlIllI = (ProfileLookupCallback)new ProfileLookupCallback() {
            public void onProfileLookupSucceeded(final GameProfile lllllllllllllllIlIllllIIIlIlllII) {
                lllllllllllllllIllIIIIIlIIIlIlll[0] = lllllllllllllllIlIllllIIIlIlllII;
            }
            
            static {
                __OBFID = "CL_00001887";
            }
            
            public void onProfileLookupFailed(final GameProfile lllllllllllllllIlIllllIIIlIllIIl, final Exception lllllllllllllllIlIllllIIIlIllIII) {
                lllllllllllllllIllIIIIIlIIIlIlll[0] = null;
            }
        };
        lllllllllllllllIllIIIIIlIIIllIIl.getGameProfileRepository().findProfilesByNames(new String[] { lllllllllllllllIllIIIIIlIIIllIII }, Agent.MINECRAFT, lllllllllllllllIllIIIIIlIIIlIllI);
        if (!lllllllllllllllIllIIIIIlIIIllIIl.isServerInOnlineMode() && lllllllllllllllIllIIIIIlIIIlIlll[0] == null) {
            final UUID lllllllllllllllIllIIIIIlIIIlIlIl = EntityPlayer.getUUID(new GameProfile((UUID)null, lllllllllllllllIllIIIIIlIIIllIII));
            final GameProfile lllllllllllllllIllIIIIIlIIIlIlII = new GameProfile(lllllllllllllllIllIIIIIlIIIlIlIl, lllllllllllllllIllIIIIIlIIIllIII);
            lllllllllllllllIllIIIIIlIIIlIllI.onProfileLookupSucceeded(lllllllllllllllIllIIIIIlIIIlIlII);
        }
        return lllllllllllllllIllIIIIIlIIIlIlll[0];
    }
    
    private List func_152656_a(final int lllllllllllllllIllIIIIIIlIlIIIIl) {
        final ArrayList lllllllllllllllIllIIIIIIlIlIIIII = Lists.newArrayList();
        final ArrayList lllllllllllllllIllIIIIIIlIIlllll = Lists.newArrayList(Iterators.limit((Iterator)this.field_152663_e.iterator(), lllllllllllllllIllIIIIIIlIlIIIIl));
        for (final GameProfile lllllllllllllllIllIIIIIIlIIlllIl : lllllllllllllllIllIIIIIIlIIlllll) {
            final ProfileEntry lllllllllllllllIllIIIIIIlIIlllII = this.func_152653_b(lllllllllllllllIllIIIIIIlIIlllIl.getId());
            if (lllllllllllllllIllIIIIIIlIIlllII != null) {
                lllllllllllllllIllIIIIIIlIlIIIII.add(lllllllllllllllIllIIIIIIlIIlllII);
            }
        }
        return lllllllllllllllIllIIIIIIlIlIIIII;
    }
    
    public GameProfile getGameProfileForUsername(final String lllllllllllllllIllIIIIIIlllIlIll) {
        final String lllllllllllllllIllIIIIIIlllIlIlI = lllllllllllllllIllIIIIIIlllIlIll.toLowerCase(Locale.ROOT);
        ProfileEntry lllllllllllllllIllIIIIIIlllIlIIl = this.field_152661_c.get(lllllllllllllllIllIIIIIIlllIlIlI);
        if (lllllllllllllllIllIIIIIIlllIlIIl != null && new Date().getTime() >= lllllllllllllllIllIIIIIIlllIlIIl.field_152673_c.getTime()) {
            this.field_152662_d.remove(lllllllllllllllIllIIIIIIlllIlIIl.func_152668_a().getId());
            this.field_152661_c.remove(lllllllllllllllIllIIIIIIlllIlIIl.func_152668_a().getName().toLowerCase(Locale.ROOT));
            this.field_152663_e.remove(lllllllllllllllIllIIIIIIlllIlIIl.func_152668_a());
            lllllllllllllllIllIIIIIIlllIlIIl = null;
        }
        if (lllllllllllllllIllIIIIIIlllIlIIl != null) {
            final GameProfile lllllllllllllllIllIIIIIIlllIlIII = lllllllllllllllIllIIIIIIlllIlIIl.func_152668_a();
            this.field_152663_e.remove(lllllllllllllllIllIIIIIIlllIlIII);
            this.field_152663_e.addFirst(lllllllllllllllIllIIIIIIlllIlIII);
        }
        else {
            final GameProfile lllllllllllllllIllIIIIIIlllIIlll = func_152650_a(this.field_152664_f, lllllllllllllllIllIIIIIIlllIlIlI);
            if (lllllllllllllllIllIIIIIIlllIIlll != null) {
                this.func_152649_a(lllllllllllllllIllIIIIIIlllIIlll);
                lllllllllllllllIllIIIIIIlllIlIIl = this.field_152661_c.get(lllllllllllllllIllIIIIIIlllIlIlI);
            }
        }
        this.func_152658_c();
        return (lllllllllllllllIllIIIIIIlllIlIIl == null) ? null : lllllllllllllllIllIIIIIIlllIlIIl.func_152668_a();
    }
    
    private ProfileEntry func_152653_b(final UUID lllllllllllllllIllIIIIIIllIIlIIl) {
        final ProfileEntry lllllllllllllllIllIIIIIIllIIllII = this.field_152662_d.get(lllllllllllllllIllIIIIIIllIIlIIl);
        if (lllllllllllllllIllIIIIIIllIIllII != null) {
            final GameProfile lllllllllllllllIllIIIIIIllIIlIll = lllllllllllllllIllIIIIIIllIIllII.func_152668_a();
            this.field_152663_e.remove(lllllllllllllllIllIIIIIIllIIlIll);
            this.field_152663_e.addFirst(lllllllllllllllIllIIIIIIllIIlIll);
        }
        return lllllllllllllllIllIIIIIIllIIllII;
    }
    
    public GameProfile func_152652_a(final UUID lllllllllllllllIllIIIIIIllIlIlII) {
        final ProfileEntry lllllllllllllllIllIIIIIIllIlIllI = this.field_152662_d.get(lllllllllllllllIllIIIIIIllIlIlII);
        return (lllllllllllllllIllIIIIIIllIlIllI == null) ? null : lllllllllllllllIllIIIIIIllIlIllI.func_152668_a();
    }
    
    static {
        __OBFID = "CL_00001888";
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
        field_152666_h = new ParameterizedType() {
            @Override
            public Type getOwnerType() {
                return null;
            }
            
            @Override
            public Type[] getActualTypeArguments() {
                return new Type[] { ProfileEntry.class };
            }
            
            @Override
            public Type getRawType() {
                return List.class;
            }
            
            static {
                __OBFID = "CL_00001886";
            }
        };
    }
    
    private void func_152651_a(final GameProfile lllllllllllllllIllIIIIIIllllllll, Date lllllllllllllllIllIIIIIIllllIllI) {
        final UUID lllllllllllllllIllIIIIIIllllllIl = lllllllllllllllIllIIIIIIllllllll.getId();
        if (lllllllllllllllIllIIIIIIllllIllI == null) {
            final Calendar lllllllllllllllIllIIIIIIllllllII = Calendar.getInstance();
            lllllllllllllllIllIIIIIIllllllII.setTime(new Date());
            lllllllllllllllIllIIIIIIllllllII.add(2, 1);
            lllllllllllllllIllIIIIIIllllIllI = lllllllllllllllIllIIIIIIllllllII.getTime();
        }
        final String lllllllllllllllIllIIIIIIlllllIll = lllllllllllllllIllIIIIIIllllllll.getName().toLowerCase(Locale.ROOT);
        final ProfileEntry lllllllllllllllIllIIIIIIlllllIlI = new ProfileEntry(lllllllllllllllIllIIIIIIllllllll, (Date)lllllllllllllllIllIIIIIIllllIllI, null);
        if (this.field_152662_d.containsKey(lllllllllllllllIllIIIIIIllllllIl)) {
            final ProfileEntry lllllllllllllllIllIIIIIIlllllIIl = this.field_152662_d.get(lllllllllllllllIllIIIIIIllllllIl);
            this.field_152661_c.remove(lllllllllllllllIllIIIIIIlllllIIl.func_152668_a().getName().toLowerCase(Locale.ROOT));
            this.field_152661_c.put(lllllllllllllllIllIIIIIIllllllll.getName().toLowerCase(Locale.ROOT), lllllllllllllllIllIIIIIIlllllIlI);
            this.field_152663_e.remove(lllllllllllllllIllIIIIIIllllllll);
        }
        else {
            this.field_152662_d.put(lllllllllllllllIllIIIIIIllllllIl, lllllllllllllllIllIIIIIIlllllIlI);
            this.field_152661_c.put(lllllllllllllllIllIIIIIIlllllIll, lllllllllllllllIllIIIIIIlllllIlI);
        }
        this.field_152663_e.addFirst(lllllllllllllllIllIIIIIIllllllll);
    }
    
    public void func_152657_b() {
        List lllllllllllllllIllIIIIIIllIIIIII = null;
        BufferedReader lllllllllllllllIllIIIIIIlIllllll = null;
        Label_0055: {
            try {
                lllllllllllllllIllIIIIIIlIllllll = Files.newReader(this.usercacheFile, Charsets.UTF_8);
                lllllllllllllllIllIIIIIIllIIIIII = (List)this.gson.fromJson((Reader)lllllllllllllllIllIIIIIIlIllllll, (Type)PlayerProfileCache.field_152666_h);
                break Label_0055;
            }
            catch (FileNotFoundException ex) {}
            finally {
                IOUtils.closeQuietly((Reader)lllllllllllllllIllIIIIIIlIllllll);
            }
            return;
        }
        if (lllllllllllllllIllIIIIIIllIIIIII != null) {
            this.field_152661_c.clear();
            this.field_152662_d.clear();
            this.field_152663_e.clear();
            lllllllllllllllIllIIIIIIllIIIIII = Lists.reverse(lllllllllllllllIllIIIIIIllIIIIII);
            for (final ProfileEntry lllllllllllllllIllIIIIIIlIllllIl : lllllllllllllllIllIIIIIIllIIIIII) {
                if (lllllllllllllllIllIIIIIIlIllllIl != null) {
                    this.func_152651_a(lllllllllllllllIllIIIIIIlIllllIl.func_152668_a(), lllllllllllllllIllIIIIIIlIllllIl.func_152670_b());
                }
            }
        }
    }
    
    public void func_152658_c() {
        final String lllllllllllllllIllIIIIIIlIllIIIl = this.gson.toJson((Object)this.func_152656_a(1000));
        BufferedWriter lllllllllllllllIllIIIIIIlIllIIII = null;
        try {
            lllllllllllllllIllIIIIIIlIllIIII = Files.newWriter(this.usercacheFile, Charsets.UTF_8);
            lllllllllllllllIllIIIIIIlIllIIII.write(lllllllllllllllIllIIIIIIlIllIIIl);
        }
        catch (FileNotFoundException lllllllllllllllIllIIIIIIlIlIllll) {}
        catch (IOException lllllllllllllllIllIIIIIIlIlIlIll) {}
        finally {
            IOUtils.closeQuietly((Writer)lllllllllllllllIllIIIIIIlIllIIII);
        }
    }
    
    class ProfileEntry
    {
        private final /* synthetic */ Date field_152673_c;
        private final /* synthetic */ GameProfile field_152672_b;
        
        static {
            __OBFID = "CL_00001885";
        }
        
        public Date func_152670_b() {
            return this.field_152673_c;
        }
        
        public GameProfile func_152668_a() {
            return this.field_152672_b;
        }
        
        ProfileEntry(final PlayerProfileCache llllllllllllllllIlIIllllIllIIllI, final GameProfile llllllllllllllllIlIIllllIllIlIlI, final Date llllllllllllllllIlIIllllIllIlIIl, final Object llllllllllllllllIlIIllllIllIlIII) {
            this(llllllllllllllllIlIIllllIllIIllI, llllllllllllllllIlIIllllIllIlIlI, llllllllllllllllIlIIllllIllIlIIl);
        }
        
        private ProfileEntry(final GameProfile llllllllllllllllIlIIllllIllllIll, final Date llllllllllllllllIlIIllllIllllIlI) {
            this.field_152672_b = llllllllllllllllIlIIllllIllllIll;
            this.field_152673_c = llllllllllllllllIlIIllllIllllIlI;
        }
    }
    
    class Serializer implements JsonSerializer, JsonDeserializer
    {
        public JsonElement serialize(final Object llllllllllllllIIlIIlIlllIlIlIIIl, final Type llllllllllllllIIlIIlIlllIlIlIIII, final JsonSerializationContext llllllllllllllIIlIIlIlllIlIIllll) {
            return this.func_152676_a((ProfileEntry)llllllllllllllIIlIIlIlllIlIlIIIl, llllllllllllllIIlIIlIlllIlIlIIII, llllllllllllllIIlIIlIlllIlIIllll);
        }
        
        public ProfileEntry func_152675_a(final JsonElement llllllllllllllIIlIIlIlllIlllIIII, final Type llllllllllllllIIlIIlIlllIllIllll, final JsonDeserializationContext llllllllllllllIIlIIlIlllIllIlllI) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: invokevirtual   com/google/gson/JsonElement.isJsonObject:()Z
            //     4: ifeq            156
            //     7: aload_1         /* llllllllllllllIIlIIlIlllIllIIIII */
            //     8: invokevirtual   com/google/gson/JsonElement.getAsJsonObject:()Lcom/google/gson/JsonObject;
            //    11: astore          llllllllllllllIIlIIlIlllIllIllIl
            //    13: aload           llllllllllllllIIlIIlIlllIllIllIl
            //    15: ldc             "name"
            //    17: invokevirtual   com/google/gson/JsonObject.get:(Ljava/lang/String;)Lcom/google/gson/JsonElement;
            //    20: astore          llllllllllllllIIlIIlIlllIllIllII
            //    22: aload           llllllllllllllIIlIIlIlllIllIllIl
            //    24: ldc             "uuid"
            //    26: invokevirtual   com/google/gson/JsonObject.get:(Ljava/lang/String;)Lcom/google/gson/JsonElement;
            //    29: astore          llllllllllllllIIlIIlIlllIllIlIll
            //    31: aload           llllllllllllllIIlIIlIlllIllIllIl
            //    33: ldc             "expiresOn"
            //    35: invokevirtual   com/google/gson/JsonObject.get:(Ljava/lang/String;)Lcom/google/gson/JsonElement;
            //    38: astore          llllllllllllllIIlIIlIlllIllIlIlI
            //    40: aload           llllllllllllllIIlIIlIlllIllIllII
            //    42: ifnull          154
            //    45: aload           llllllllllllllIIlIIlIlllIllIlIll
            //    47: ifnull          154
            //    50: aload           llllllllllllllIIlIIlIlllIllIlIll
            //    52: invokevirtual   com/google/gson/JsonElement.getAsString:()Ljava/lang/String;
            //    55: astore          llllllllllllllIIlIIlIlllIllIlIIl
            //    57: aload           llllllllllllllIIlIIlIlllIllIllII
            //    59: invokevirtual   com/google/gson/JsonElement.getAsString:()Ljava/lang/String;
            //    62: astore          llllllllllllllIIlIIlIlllIllIlIII
            //    64: aconst_null    
            //    65: astore          llllllllllllllIIlIIlIlllIllIIlll
            //    67: aload           llllllllllllllIIlIIlIlllIllIlIlI
            //    69: ifnull          93
            //    72: getstatic       net/minecraft/server/management/PlayerProfileCache.dateFormat:Ljava/text/SimpleDateFormat;
            //    75: aload           llllllllllllllIIlIIlIlllIllIlIlI
            //    77: invokevirtual   com/google/gson/JsonElement.getAsString:()Ljava/lang/String;
            //    80: invokevirtual   java/text/SimpleDateFormat.parse:(Ljava/lang/String;)Ljava/util/Date;
            //    83: astore          llllllllllllllIIlIIlIlllIllIIlll
            //    85: goto            93
            //    88: astore          llllllllllllllIIlIIlIlllIllIIllI
            //    90: aconst_null    
            //    91: astore          llllllllllllllIIlIIlIlllIllIIlll
            //    93: aload           llllllllllllllIIlIIlIlllIllIlIII
            //    95: ifnull          152
            //    98: aload           llllllllllllllIIlIIlIlllIllIlIIl
            //   100: ifnull          152
            //   103: aload           llllllllllllllIIlIIlIlllIllIlIIl
            //   105: invokestatic    java/util/UUID.fromString:(Ljava/lang/String;)Ljava/util/UUID;
            //   108: astore          llllllllllllllIIlIIlIlllIllIIlIl
            //   110: goto            117
            //   113: astore          llllllllllllllIIlIIlIlllIllIIIll
            //   115: aconst_null    
            //   116: areturn        
            //   117: new             Lnet/minecraft/server/management/PlayerProfileCache$ProfileEntry;
            //   120: dup            
            //   121: aload_0         /* llllllllllllllIIlIIlIlllIllIIIIl */
            //   122: getfield        net/minecraft/server/management/PlayerProfileCache$Serializer.this$0:Lnet/minecraft/server/management/PlayerProfileCache;
            //   125: dup            
            //   126: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
            //   129: pop            
            //   130: new             Lcom/mojang/authlib/GameProfile;
            //   133: dup            
            //   134: aload           llllllllllllllIIlIIlIlllIllIIlII
            //   136: aload           llllllllllllllIIlIIlIlllIllIlIII
            //   138: invokespecial   com/mojang/authlib/GameProfile.<init>:(Ljava/util/UUID;Ljava/lang/String;)V
            //   141: aload           llllllllllllllIIlIIlIlllIllIIlll
            //   143: aconst_null    
            //   144: invokespecial   net/minecraft/server/management/PlayerProfileCache$ProfileEntry.<init>:(Lnet/minecraft/server/management/PlayerProfileCache;Lcom/mojang/authlib/GameProfile;Ljava/util/Date;Ljava/lang/Object;)V
            //   147: astore          llllllllllllllIIlIIlIlllIllIIIlI
            //   149: aload           llllllllllllllIIlIIlIlllIllIIIlI
            //   151: areturn        
            //   152: aconst_null    
            //   153: areturn        
            //   154: aconst_null    
            //   155: areturn        
            //   156: aconst_null    
            //   157: areturn        
            //    StackMapTable: 00 07 FF 00 58 00 0B 07 00 02 07 00 30 07 00 8F 07 00 91 07 00 3C 07 00 30 07 00 30 07 00 30 07 00 93 07 00 93 07 00 95 00 01 07 00 2C 04 53 07 00 2E FC 00 03 07 00 54 FA 00 22 F8 00 01 FF 00 01 00 04 07 00 02 07 00 30 07 00 8F 07 00 91 00 00
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                      
            //  -----  -----  -----  -----  --------------------------
            //  72     85     88     93     Ljava/text/ParseException;
            //  103    110    113    117    Ljava/lang/Throwable;
            // 
            // The error that occurred was:
            // 
            // java.lang.NullPointerException
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
        
        public Object deserialize(final JsonElement llllllllllllllIIlIIlIlllIlIIIIIl, final Type llllllllllllllIIlIIlIlllIlIIIIII, final JsonDeserializationContext llllllllllllllIIlIIlIlllIIllllll) {
            return this.func_152675_a(llllllllllllllIIlIIlIlllIlIIIIIl, llllllllllllllIIlIIlIlllIlIIIIII, llllllllllllllIIlIIlIlllIIllllll);
        }
        
        static {
            __OBFID = "CL_00001884";
        }
        
        private Serializer() {
        }
        
        public JsonElement func_152676_a(final ProfileEntry llllllllllllllIIlIIlIlllIlllllll, final Type llllllllllllllIIlIIlIllllIIIIIll, final JsonSerializationContext llllllllllllllIIlIIlIllllIIIIIlI) {
            final JsonObject llllllllllllllIIlIIlIllllIIIIIIl = new JsonObject();
            llllllllllllllIIlIIlIllllIIIIIIl.addProperty("name", llllllllllllllIIlIIlIlllIlllllll.func_152668_a().getName());
            final UUID llllllllllllllIIlIIlIllllIIIIIII = llllllllllllllIIlIIlIlllIlllllll.func_152668_a().getId();
            llllllllllllllIIlIIlIllllIIIIIIl.addProperty("uuid", (llllllllllllllIIlIIlIllllIIIIIII == null) ? "" : llllllllllllllIIlIIlIllllIIIIIII.toString());
            llllllllllllllIIlIIlIllllIIIIIIl.addProperty("expiresOn", PlayerProfileCache.dateFormat.format(llllllllllllllIIlIIlIlllIlllllll.func_152670_b()));
            return (JsonElement)llllllllllllllIIlIIlIllllIIIIIIl;
        }
        
        Serializer(final PlayerProfileCache llllllllllllllIIlIIlIlllIIlllIIl, final Object llllllllllllllIIlIIlIlllIIlllIll) {
            this(llllllllllllllIIlIIlIlllIIlllIIl);
        }
    }
}
