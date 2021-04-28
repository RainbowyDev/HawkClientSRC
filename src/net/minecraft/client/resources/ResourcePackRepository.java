package net.minecraft.client.resources;

import java.util.concurrent.locks.*;
import com.google.common.hash.*;
import com.google.common.io.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import java.util.concurrent.*;
import com.google.common.util.concurrent.*;
import org.apache.logging.log4j.*;
import com.google.common.collect.*;
import java.util.*;
import net.minecraft.client.settings.*;
import java.awt.image.*;
import net.minecraft.client.resources.data.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.texture.*;
import java.io.*;
import org.apache.commons.io.*;

public class ResourcePackRepository
{
    private final /* synthetic */ File dirResourcepacks;
    public final /* synthetic */ IMetadataSerializer rprMetadataSerializer;
    private /* synthetic */ ListenableFuture field_177322_i;
    private final /* synthetic */ File field_148534_e;
    private static final /* synthetic */ FileFilter resourcePackFilter;
    private final /* synthetic */ ReentrantLock field_177321_h;
    private /* synthetic */ List repositoryEntries;
    private static final /* synthetic */ Logger field_177320_c;
    public final /* synthetic */ IResourcePack rprDefaultResourcePack;
    private /* synthetic */ IResourcePack field_148532_f;
    private /* synthetic */ List repositoryEntriesAll;
    
    public File getDirResourcepacks() {
        return this.dirResourcepacks;
    }
    
    public ListenableFuture func_180601_a(final String llllllllllllllIIIlIlllllIllIlIll, final String llllllllllllllIIIlIlllllIlIlllII) {
        String llllllllllllllIIIlIlllllIllIlIII = null;
        if (llllllllllllllIIIlIlllllIlIlllII.matches("^[a-f0-9]{40}$")) {
            final String llllllllllllllIIIlIlllllIllIlIIl = llllllllllllllIIIlIlllllIlIlllII;
        }
        else {
            llllllllllllllIIIlIlllllIllIlIII = llllllllllllllIIIlIlllllIllIlIll.substring(llllllllllllllIIIlIlllllIllIlIll.lastIndexOf("/") + 1);
            if (llllllllllllllIIIlIlllllIllIlIII.contains("?")) {
                llllllllllllllIIIlIlllllIllIlIII = llllllllllllllIIIlIlllllIllIlIII.substring(0, llllllllllllllIIIlIlllllIllIlIII.indexOf("?"));
            }
            if (!llllllllllllllIIIlIlllllIllIlIII.endsWith(".zip")) {
                return Futures.immediateFailedFuture((Throwable)new IllegalArgumentException("Invalid filename; must end in .zip"));
            }
            llllllllllllllIIIlIlllllIllIlIII = String.valueOf(new StringBuilder("legacy_").append(llllllllllllllIIIlIlllllIllIlIII.replaceAll("\\W", "")));
        }
        final File llllllllllllllIIIlIlllllIllIIlll = new File(this.field_148534_e, llllllllllllllIIIlIlllllIllIlIII);
        this.field_177321_h.lock();
        try {
            this.func_148529_f();
            if (llllllllllllllIIIlIlllllIllIIlll.exists() && llllllllllllllIIIlIlllllIlIlllII.length() == 40) {
                try {
                    final String llllllllllllllIIIlIlllllIllIIllI = Hashing.sha1().hashBytes(Files.toByteArray(llllllllllllllIIIlIlllllIllIIlll)).toString();
                    if (llllllllllllllIIIlIlllllIllIIllI.equals(llllllllllllllIIIlIlllllIlIlllII)) {
                        final double llllllllllllllIIIlIlllllIlIlIIll;
                        final ListenableFuture llllllllllllllIIIlIlllllIllIIlIl = (ListenableFuture)(llllllllllllllIIIlIlllllIlIlIIll = (double)this.func_177319_a(llllllllllllllIIIlIlllllIllIIlll));
                        return (ListenableFuture)llllllllllllllIIIlIlllllIlIlIIll;
                    }
                    ResourcePackRepository.field_177320_c.warn(String.valueOf(new StringBuilder("File ").append(llllllllllllllIIIlIlllllIllIIlll).append(" had wrong hash (expected ").append(llllllllllllllIIIlIlllllIlIlllII).append(", found ").append(llllllllllllllIIIlIlllllIllIIllI).append("). Deleting it.")));
                    FileUtils.deleteQuietly(llllllllllllllIIIlIlllllIllIIlll);
                }
                catch (IOException llllllllllllllIIIlIlllllIllIIlII) {
                    ResourcePackRepository.field_177320_c.warn(String.valueOf(new StringBuilder("File ").append(llllllllllllllIIIlIlllllIllIIlll).append(" couldn't be hashed. Deleting it.")), (Throwable)llllllllllllllIIIlIlllllIllIIlII);
                    FileUtils.deleteQuietly(llllllllllllllIIIlIlllllIllIIlll);
                }
            }
            final GuiScreenWorking llllllllllllllIIIlIlllllIllIIIll = new GuiScreenWorking();
            final Map llllllllllllllIIIlIlllllIllIIIlI = Minecraft.func_175596_ai();
            final Minecraft llllllllllllllIIIlIlllllIllIIIIl = Minecraft.getMinecraft();
            Futures.getUnchecked((Future)llllllllllllllIIIlIlllllIllIIIIl.addScheduledTask(new Runnable() {
                static {
                    __OBFID = "CL_00001089";
                }
                
                @Override
                public void run() {
                    llllllllllllllIIIlIlllllIllIIIIl.displayGuiScreen(llllllllllllllIIIlIlllllIllIIIll);
                }
            }));
            final SettableFuture llllllllllllllIIIlIlllllIllIIIII = SettableFuture.create();
            this.field_177322_i = HttpUtil.func_180192_a(llllllllllllllIIIlIlllllIllIIlll, llllllllllllllIIIlIlllllIllIlIll, llllllllllllllIIIlIlllllIllIIIlI, 52428800, llllllllllllllIIIlIlllllIllIIIll, llllllllllllllIIIlIlllllIllIIIIl.getProxy());
            Futures.addCallback(this.field_177322_i, (FutureCallback)new FutureCallback() {
                public void onSuccess(final Object llllllllllllllllllIIlllIllIIlIII) {
                    ResourcePackRepository.this.func_177319_a(llllllllllllllIIIlIlllllIllIIlll);
                    llllllllllllllIIIlIlllllIllIIIII.set((Object)null);
                }
                
                public void onFailure(final Throwable llllllllllllllllllIIlllIllIIIIIl) {
                    llllllllllllllIIIlIlllllIllIIIII.setException(llllllllllllllllllIIlllIllIIIIIl);
                }
                
                static {
                    __OBFID = "CL_00002394";
                }
            });
            double llllllllllllllIIIlIlllllIlIlIIll;
            final ListenableFuture llllllllllllllIIIlIlllllIlIlllll = (ListenableFuture)(llllllllllllllIIIlIlllllIlIlIIll = (double)this.field_177322_i);
            return (ListenableFuture)llllllllllllllIIIlIlllllIlIlIIll;
        }
        finally {
            this.field_177321_h.unlock();
        }
    }
    
    private void fixDirResourcepacks() {
        if (!this.dirResourcepacks.isDirectory() && (!this.dirResourcepacks.delete() || !this.dirResourcepacks.mkdirs())) {
            ResourcePackRepository.field_177320_c.debug(String.valueOf(new StringBuilder("Unable to create resourcepack folder: ").append(this.dirResourcepacks)));
        }
    }
    
    static {
        __OBFID = "CL_00001087";
        field_177320_c = LogManager.getLogger();
        resourcePackFilter = new FileFilter() {
            @Override
            public boolean accept(final File lllllllllllllllllIIlIllIIllIIIIl) {
                final boolean lllllllllllllllllIIlIllIIllIIIll = lllllllllllllllllIIlIllIIllIIIIl.isFile() && lllllllllllllllllIIlIllIIllIIIIl.getName().endsWith(".zip");
                final boolean lllllllllllllllllIIlIllIIllIIIlI = lllllllllllllllllIIlIllIIllIIIIl.isDirectory() && new File(lllllllllllllllllIIlIllIIllIIIIl, "pack.mcmeta").isFile();
                return lllllllllllllllllIIlIllIIllIIIll || lllllllllllllllllIIlIllIIllIIIlI;
            }
            
            static {
                __OBFID = "CL_00001088";
            }
        };
    }
    
    public List getRepositoryEntries() {
        return (List)ImmutableList.copyOf((Collection)this.repositoryEntries);
    }
    
    public IResourcePack getResourcePackInstance() {
        return this.field_148532_f;
    }
    
    public void updateRepositoryEntriesAll() {
        final ArrayList llllllllllllllIIIlIllllllIIlIlII = Lists.newArrayList();
        for (final File llllllllllllllIIIlIllllllIIlIIlI : this.getResourcePackFiles()) {
            final Entry llllllllllllllIIIlIllllllIIlIIIl = new Entry(llllllllllllllIIIlIllllllIIlIIlI, null);
            if (!this.repositoryEntriesAll.contains(llllllllllllllIIIlIllllllIIlIIIl)) {
                try {
                    llllllllllllllIIIlIllllllIIlIIIl.updateResourcePack();
                    llllllllllllllIIIlIllllllIIlIlII.add(llllllllllllllIIIlIllllllIIlIIIl);
                }
                catch (Exception llllllllllllllIIIlIllllllIIlIIII) {
                    llllllllllllllIIIlIllllllIIlIlII.remove(llllllllllllllIIIlIllllllIIlIIIl);
                }
            }
            else {
                final int llllllllllllllIIIlIllllllIIIllll = this.repositoryEntriesAll.indexOf(llllllllllllllIIIlIllllllIIlIIIl);
                if (llllllllllllllIIIlIllllllIIIllll <= -1 || llllllllllllllIIIlIllllllIIIllll >= this.repositoryEntriesAll.size()) {
                    continue;
                }
                llllllllllllllIIIlIllllllIIlIlII.add(this.repositoryEntriesAll.get(llllllllllllllIIIlIllllllIIIllll));
            }
        }
        this.repositoryEntriesAll.removeAll(llllllllllllllIIIlIllllllIIlIlII);
        for (final Entry llllllllllllllIIIlIllllllIIIlllI : this.repositoryEntriesAll) {
            llllllllllllllIIIlIllllllIIIlllI.closeResourcePack();
        }
        this.repositoryEntriesAll = llllllllllllllIIIlIllllllIIlIlII;
    }
    
    public ListenableFuture func_177319_a(final File llllllllllllllIIIlIlllllIlIIllll) {
        this.field_148532_f = new FileResourcePack(llllllllllllllIIIlIlllllIlIIllll);
        return Minecraft.getMinecraft().func_175603_A();
    }
    
    public void func_148527_a(final List llllllllllllllIIIlIlllllIllllllI) {
        this.repositoryEntries.clear();
        this.repositoryEntries.addAll(llllllllllllllIIIlIlllllIllllllI);
    }
    
    public void func_148529_f() {
        this.field_177321_h.lock();
        try {
            if (this.field_177322_i != null) {
                this.field_177322_i.cancel(true);
            }
            this.field_177322_i = null;
            this.field_148532_f = null;
        }
        finally {
            this.field_177321_h.unlock();
        }
        this.field_177321_h.unlock();
    }
    
    public List getRepositoryEntriesAll() {
        return (List)ImmutableList.copyOf((Collection)this.repositoryEntriesAll);
    }
    
    private List getResourcePackFiles() {
        return this.dirResourcepacks.isDirectory() ? Arrays.asList(this.dirResourcepacks.listFiles(ResourcePackRepository.resourcePackFilter)) : Collections.emptyList();
    }
    
    public ResourcePackRepository(final File llllllllllllllIIIlIllllllIllIlII, final File llllllllllllllIIIlIllllllIllIIll, final IResourcePack llllllllllllllIIIlIllllllIllIIlI, final IMetadataSerializer llllllllllllllIIIlIllllllIlIIlll, final GameSettings llllllllllllllIIIlIllllllIllIIII) {
        this.field_177321_h = new ReentrantLock();
        this.repositoryEntriesAll = Lists.newArrayList();
        this.repositoryEntries = Lists.newArrayList();
        this.dirResourcepacks = llllllllllllllIIIlIllllllIllIlII;
        this.field_148534_e = llllllllllllllIIIlIllllllIllIIll;
        this.rprDefaultResourcePack = llllllllllllllIIIlIllllllIllIIlI;
        this.rprMetadataSerializer = llllllllllllllIIIlIllllllIlIIlll;
        this.fixDirResourcepacks();
        this.updateRepositoryEntriesAll();
        for (final String llllllllllllllIIIlIllllllIlIlllI : llllllllllllllIIIlIllllllIllIIII.resourcePacks) {
            for (final Entry llllllllllllllIIIlIllllllIlIllII : this.repositoryEntriesAll) {
                if (llllllllllllllIIIlIllllllIlIllII.getResourcePackName().equals(llllllllllllllIIIlIllllllIlIlllI)) {
                    this.repositoryEntries.add(llllllllllllllIIIlIllllllIlIllII);
                    break;
                }
            }
        }
    }
    
    public class Entry
    {
        private /* synthetic */ BufferedImage texturePackIcon;
        private final /* synthetic */ File resourcePackFile;
        private /* synthetic */ ResourceLocation locationTexturePackIcon;
        private /* synthetic */ IResourcePack reResourcePack;
        private /* synthetic */ PackMetadataSection rePackMetadataSection;
        
        public void updateResourcePack() throws IOException {
            this.reResourcePack = (this.resourcePackFile.isDirectory() ? new FolderResourcePack(this.resourcePackFile) : new FileResourcePack(this.resourcePackFile));
            this.rePackMetadataSection = (PackMetadataSection)this.reResourcePack.getPackMetadata(ResourcePackRepository.this.rprMetadataSerializer, "pack");
            try {
                this.texturePackIcon = this.reResourcePack.getPackImage();
            }
            catch (IOException ex) {}
            if (this.texturePackIcon == null) {
                this.texturePackIcon = ResourcePackRepository.this.rprDefaultResourcePack.getPackImage();
            }
            this.closeResourcePack();
        }
        
        @Override
        public boolean equals(final Object lllllllllllllllIlIIIIllIlllIlIlI) {
            return this == lllllllllllllllIlIIIIllIlllIlIlI || (lllllllllllllllIlIIIIllIlllIlIlI instanceof Entry && this.toString().equals(lllllllllllllllIlIIIIllIlllIlIlI.toString()));
        }
        
        @Override
        public String toString() {
            return String.format("%s:%s:%d", this.resourcePackFile.getName(), this.resourcePackFile.isDirectory() ? "folder" : "zip", this.resourcePackFile.lastModified());
        }
        
        public String getTexturePackDescription() {
            return (this.rePackMetadataSection == null) ? String.valueOf(new StringBuilder().append(EnumChatFormatting.RED).append("Invalid pack.mcmeta (or missing 'pack' section)")) : this.rePackMetadataSection.func_152805_a().getFormattedText();
        }
        
        private Entry(final File lllllllllllllllIlIIIIlllIIIIlIII) {
            this.resourcePackFile = lllllllllllllllIlIIIIlllIIIIlIII;
        }
        
        Entry(final ResourcePackRepository lllllllllllllllIlIIIIllIllIllIlI, final File lllllllllllllllIlIIIIllIllIllIIl, final Object lllllllllllllllIlIIIIllIllIlllII) {
            this(lllllllllllllllIlIIIIllIllIllIlI, lllllllllllllllIlIIIIllIllIllIIl);
        }
        
        public void bindTexturePackIcon(final TextureManager lllllllllllllllIlIIIIllIlllllIlI) {
            if (this.locationTexturePackIcon == null) {
                this.locationTexturePackIcon = lllllllllllllllIlIIIIllIlllllIlI.getDynamicTextureLocation("texturepackicon", new DynamicTexture(this.texturePackIcon));
            }
            lllllllllllllllIlIIIIllIlllllIlI.bindTexture(this.locationTexturePackIcon);
        }
        
        static {
            __OBFID = "CL_00001090";
        }
        
        public String getResourcePackName() {
            return this.reResourcePack.getPackName();
        }
        
        public IResourcePack getResourcePack() {
            return this.reResourcePack;
        }
        
        public void closeResourcePack() {
            if (this.reResourcePack instanceof Closeable) {
                IOUtils.closeQuietly((Closeable)this.reResourcePack);
            }
        }
        
        @Override
        public int hashCode() {
            return this.toString().hashCode();
        }
    }
}
