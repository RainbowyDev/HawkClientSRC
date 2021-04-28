package optifine;

import net.minecraft.item.*;
import net.minecraft.util.*;
import java.util.*;
import java.io.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;

public class ReflectorForge
{
    public static boolean isItemDamaged(final ItemStack lllllllllllllllllIlIlllIlIIIlllI) {
        return Reflector.ForgeItem_showDurabilityBar.exists() ? Reflector.callBoolean(lllllllllllllllllIlIlllIlIIIlllI.getItem(), Reflector.ForgeItem_showDurabilityBar, lllllllllllllllllIlIlllIlIIIlllI) : lllllllllllllllllIlIlllIlIIIlllI.isItemDamaged();
    }
    
    public static void FMLClientHandler_trackBrokenTexture(final ResourceLocation lllllllllllllllllIlIlllIlIllIIll, final String lllllllllllllllllIlIlllIlIllIlIl) {
        if (!Reflector.FMLClientHandler_trackBrokenTexture.exists()) {
            final Object lllllllllllllllllIlIlllIlIllIlII = Reflector.call(Reflector.FMLClientHandler_instance, new Object[0]);
            Reflector.call(lllllllllllllllllIlIlllIlIllIlII, Reflector.FMLClientHandler_trackBrokenTexture, lllllllllllllllllIlIlllIlIllIIll, lllllllllllllllllIlIlllIlIllIlIl);
        }
    }
    
    public static void putLaunchBlackboard(final String lllllllllllllllllIlIlllIlIlIIlll, final Object lllllllllllllllllIlIlllIlIlIIllI) {
        final Map lllllllllllllllllIlIlllIlIlIIlIl = (Map)Reflector.getFieldValue(Reflector.Launch_blackboard);
        if (lllllllllllllllllIlIlllIlIlIIlIl != null) {
            lllllllllllllllllIlIlllIlIlIIlIl.put(lllllllllllllllllIlIlllIlIlIIlll, lllllllllllllllllIlIlllIlIlIIllI);
        }
    }
    
    public static InputStream getOptiFineResourceStream(String lllllllllllllllllIlIlllIlIIllIIl) {
        if (!Reflector.OptiFineClassTransformer_instance.exists()) {
            return null;
        }
        final Object lllllllllllllllllIlIlllIlIIlllII = Reflector.getFieldValue(Reflector.OptiFineClassTransformer_instance);
        if (lllllllllllllllllIlIlllIlIIlllII == null) {
            return null;
        }
        if (lllllllllllllllllIlIlllIlIIllIIl.startsWith("/")) {
            lllllllllllllllllIlIlllIlIIllIIl = lllllllllllllllllIlIlllIlIIllIIl.substring(1);
        }
        final byte[] lllllllllllllllllIlIlllIlIIllIll = (byte[])Reflector.call(lllllllllllllllllIlIlllIlIIlllII, Reflector.OptiFineClassTransformer_getOptiFineResource, lllllllllllllllllIlIlllIlIIllIIl);
        if (lllllllllllllllllIlIlllIlIIllIll == null) {
            return null;
        }
        final ByteArrayInputStream lllllllllllllllllIlIlllIlIIllIlI = new ByteArrayInputStream(lllllllllllllllllIlIlllIlIIllIll);
        return lllllllllllllllllIlIlllIlIIllIlI;
    }
    
    public static void FMLClientHandler_trackMissingTexture(final ResourceLocation lllllllllllllllllIlIlllIlIlIllII) {
        if (!Reflector.FMLClientHandler_trackMissingTexture.exists()) {
            final Object lllllllllllllllllIlIlllIlIlIllIl = Reflector.call(Reflector.FMLClientHandler_instance, new Object[0]);
            Reflector.call(lllllllllllllllllIlIlllIlIlIllIl, Reflector.FMLClientHandler_trackMissingTexture, lllllllllllllllllIlIlllIlIlIllII);
        }
    }
    
    public static boolean blockHasTileEntity(final IBlockState lllllllllllllllllIlIlllIlIIlIIIl) {
        final Block lllllllllllllllllIlIlllIlIIlIIlI = lllllllllllllllllIlIlllIlIIlIIIl.getBlock();
        return Reflector.ForgeBlock_hasTileEntity.exists() ? Reflector.callBoolean(lllllllllllllllllIlIlllIlIIlIIlI, Reflector.ForgeBlock_hasTileEntity, lllllllllllllllllIlIlllIlIIlIIIl) : lllllllllllllllllIlIlllIlIIlIIlI.hasTileEntity();
    }
}
