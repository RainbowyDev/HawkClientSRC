package optifine;

import net.minecraft.client.renderer.block.model.*;
import net.minecraft.client.resources.model.*;
import java.util.*;
import net.minecraft.util.*;

public class SmartLeaves
{
    private static /* synthetic */ IBakedModel modelLeavesDoubleBirch;
    private static /* synthetic */ IBakedModel modelLeavesCullBirch;
    private static /* synthetic */ IBakedModel modelLeavesDoubleAcacia;
    private static /* synthetic */ IBakedModel modelLeavesDoubleJungle;
    private static /* synthetic */ IBakedModel modelLeavesCullJungle;
    private static /* synthetic */ IBakedModel modelLeavesDoubleSpruce;
    private static /* synthetic */ List generalQuadsCullSpruce;
    private static /* synthetic */ IBakedModel modelLeavesCullDarkOak;
    private static /* synthetic */ List generalQuadsCullBirch;
    private static /* synthetic */ IBakedModel modelLeavesCullSpruce;
    private static /* synthetic */ List generalQuadsCullOak;
    private static /* synthetic */ List generalQuadsCullJungle;
    private static /* synthetic */ List generalQuadsCullAcacia;
    private static /* synthetic */ List generalQuadsCullDarkOak;
    private static /* synthetic */ IBakedModel modelLeavesCullOak;
    private static /* synthetic */ IBakedModel modelLeavesCullAcacia;
    private static /* synthetic */ IBakedModel modelLeavesDoubleOak;
    private static /* synthetic */ IBakedModel modelLeavesDoubleDarkOak;
    
    static {
        SmartLeaves.modelLeavesCullAcacia = null;
        SmartLeaves.modelLeavesCullBirch = null;
        SmartLeaves.modelLeavesCullDarkOak = null;
        SmartLeaves.modelLeavesCullJungle = null;
        SmartLeaves.modelLeavesCullOak = null;
        SmartLeaves.modelLeavesCullSpruce = null;
        SmartLeaves.generalQuadsCullAcacia = null;
        SmartLeaves.generalQuadsCullBirch = null;
        SmartLeaves.generalQuadsCullDarkOak = null;
        SmartLeaves.generalQuadsCullJungle = null;
        SmartLeaves.generalQuadsCullOak = null;
        SmartLeaves.generalQuadsCullSpruce = null;
        SmartLeaves.modelLeavesDoubleAcacia = null;
        SmartLeaves.modelLeavesDoubleBirch = null;
        SmartLeaves.modelLeavesDoubleDarkOak = null;
        SmartLeaves.modelLeavesDoubleJungle = null;
        SmartLeaves.modelLeavesDoubleOak = null;
        SmartLeaves.modelLeavesDoubleSpruce = null;
    }
    
    public static void updateLeavesModels() {
        final ArrayList llIIlIllIlIllll = new ArrayList();
        SmartLeaves.modelLeavesCullAcacia = getModelCull("acacia", llIIlIllIlIllll);
        SmartLeaves.modelLeavesCullBirch = getModelCull("birch", llIIlIllIlIllll);
        SmartLeaves.modelLeavesCullDarkOak = getModelCull("dark_oak", llIIlIllIlIllll);
        SmartLeaves.modelLeavesCullJungle = getModelCull("jungle", llIIlIllIlIllll);
        SmartLeaves.modelLeavesCullOak = getModelCull("oak", llIIlIllIlIllll);
        SmartLeaves.modelLeavesCullSpruce = getModelCull("spruce", llIIlIllIlIllll);
        SmartLeaves.generalQuadsCullAcacia = getGeneralQuadsSafe(SmartLeaves.modelLeavesCullAcacia);
        SmartLeaves.generalQuadsCullBirch = getGeneralQuadsSafe(SmartLeaves.modelLeavesCullBirch);
        SmartLeaves.generalQuadsCullDarkOak = getGeneralQuadsSafe(SmartLeaves.modelLeavesCullDarkOak);
        SmartLeaves.generalQuadsCullJungle = getGeneralQuadsSafe(SmartLeaves.modelLeavesCullJungle);
        SmartLeaves.generalQuadsCullOak = getGeneralQuadsSafe(SmartLeaves.modelLeavesCullOak);
        SmartLeaves.generalQuadsCullSpruce = getGeneralQuadsSafe(SmartLeaves.modelLeavesCullSpruce);
        SmartLeaves.modelLeavesDoubleAcacia = getModelDoubleFace(SmartLeaves.modelLeavesCullAcacia);
        SmartLeaves.modelLeavesDoubleBirch = getModelDoubleFace(SmartLeaves.modelLeavesCullBirch);
        SmartLeaves.modelLeavesDoubleDarkOak = getModelDoubleFace(SmartLeaves.modelLeavesCullDarkOak);
        SmartLeaves.modelLeavesDoubleJungle = getModelDoubleFace(SmartLeaves.modelLeavesCullJungle);
        SmartLeaves.modelLeavesDoubleOak = getModelDoubleFace(SmartLeaves.modelLeavesCullOak);
        SmartLeaves.modelLeavesDoubleSpruce = getModelDoubleFace(SmartLeaves.modelLeavesCullSpruce);
        if (llIIlIllIlIllll.size() > 0) {
            Config.dbg(String.valueOf(new StringBuilder("Enable face culling: ").append(Config.arrayToString(llIIlIllIlIllll.toArray()))));
        }
    }
    
    private static List getGeneralQuadsSafe(final IBakedModel llIIlIllIlIllII) {
        return (llIIlIllIlIllII == null) ? null : llIIlIllIlIllII.func_177550_a();
    }
    
    public static IBakedModel getLeavesModel(final IBakedModel llIIlIllIllIIlI) {
        if (!Config.isTreesSmart()) {
            return llIIlIllIllIIlI;
        }
        final List llIIlIllIllIIll = llIIlIllIllIIlI.func_177550_a();
        return (llIIlIllIllIIll == SmartLeaves.generalQuadsCullAcacia) ? SmartLeaves.modelLeavesDoubleAcacia : ((llIIlIllIllIIll == SmartLeaves.generalQuadsCullBirch) ? SmartLeaves.modelLeavesDoubleBirch : ((llIIlIllIllIIll == SmartLeaves.generalQuadsCullDarkOak) ? SmartLeaves.modelLeavesDoubleDarkOak : ((llIIlIllIllIIll == SmartLeaves.generalQuadsCullJungle) ? SmartLeaves.modelLeavesDoubleJungle : ((llIIlIllIllIIll == SmartLeaves.generalQuadsCullOak) ? SmartLeaves.modelLeavesDoubleOak : ((llIIlIllIllIIll == SmartLeaves.generalQuadsCullSpruce) ? SmartLeaves.modelLeavesDoubleSpruce : llIIlIllIllIIlI)))));
    }
    
    static IBakedModel getModelCull(final String llIIlIllIIlIlII, final List llIIlIllIIlIIll) {
        final ModelManager llIIlIllIIlllIl = Config.getModelManager();
        if (llIIlIllIIlllIl == null) {
            return null;
        }
        final ResourceLocation llIIlIllIIlllII = new ResourceLocation(String.valueOf(new StringBuilder("blockstates/").append(llIIlIllIIlIlII).append("_leaves.json")));
        if (Config.getDefiningResourcePack(llIIlIllIIlllII) != Config.getDefaultResourcePack()) {
            return null;
        }
        final ResourceLocation llIIlIllIIllIll = new ResourceLocation(String.valueOf(new StringBuilder("models/block/").append(llIIlIllIIlIlII).append("_leaves.json")));
        if (Config.getDefiningResourcePack(llIIlIllIIllIll) != Config.getDefaultResourcePack()) {
            return null;
        }
        final ModelResourceLocation llIIlIllIIllIlI = new ModelResourceLocation(String.valueOf(new StringBuilder(String.valueOf(llIIlIllIIlIlII)).append("_leaves")), "normal");
        final IBakedModel llIIlIllIIllIIl = llIIlIllIIlllIl.getModel(llIIlIllIIllIlI);
        if (llIIlIllIIllIIl == null || llIIlIllIIllIIl == llIIlIllIIlllIl.getMissingModel()) {
            return null;
        }
        final List llIIlIllIIllIII = llIIlIllIIllIIl.func_177550_a();
        if (llIIlIllIIllIII.size() == 0) {
            return llIIlIllIIllIIl;
        }
        if (llIIlIllIIllIII.size() != 6) {
            return null;
        }
        for (final BakedQuad llIIlIllIIlIllI : llIIlIllIIllIII) {
            final List llIIlIllIIlIlIl = llIIlIllIIllIIl.func_177551_a(llIIlIllIIlIllI.getFace());
            if (llIIlIllIIlIlIl.size() > 0) {
                return null;
            }
            llIIlIllIIlIlIl.add(llIIlIllIIlIllI);
        }
        llIIlIllIIllIII.clear();
        llIIlIllIIlIIll.add(String.valueOf(new StringBuilder(String.valueOf(llIIlIllIIlIlII)).append("_leaves")));
        return llIIlIllIIllIIl;
    }
    
    private static IBakedModel getModelDoubleFace(final IBakedModel llIIlIlIlllllIl) {
        if (llIIlIlIlllllIl == null) {
            return null;
        }
        if (llIIlIlIlllllIl.func_177550_a().size() > 0) {
            Config.warn(String.valueOf(new StringBuilder("SmartLeaves: Model is not cube, general quads: ").append(llIIlIlIlllllIl.func_177550_a().size()).append(", model: ").append(llIIlIlIlllllIl)));
            return llIIlIlIlllllIl;
        }
        final EnumFacing[] llIIlIlIlllllII = EnumFacing.VALUES;
        for (int llIIlIlIllllIll = 0; llIIlIlIllllIll < llIIlIlIlllllII.length; ++llIIlIlIllllIll) {
            final EnumFacing llIIlIlIllllIlI = llIIlIlIlllllII[llIIlIlIllllIll];
            final List llIIlIlIllllIIl = llIIlIlIlllllIl.func_177551_a(llIIlIlIllllIlI);
            if (llIIlIlIllllIIl.size() != 1) {
                Config.warn(String.valueOf(new StringBuilder("SmartLeaves: Model is not cube, side: ").append(llIIlIlIllllIlI).append(", quads: ").append(llIIlIlIllllIIl.size()).append(", model: ").append(llIIlIlIlllllIl)));
                return llIIlIlIlllllIl;
            }
        }
        final IBakedModel llIIlIlIllllIII = ModelUtils.duplicateModel(llIIlIlIlllllIl);
        final List[] llIIlIlIlllIlll = new List[llIIlIlIlllllII.length];
        for (int llIIlIlIlllIllI = 0; llIIlIlIlllIllI < llIIlIlIlllllII.length; ++llIIlIlIlllIllI) {
            final EnumFacing llIIlIlIlllIlIl = llIIlIlIlllllII[llIIlIlIlllIllI];
            final List llIIlIlIlllIlII = llIIlIlIllllIII.func_177551_a(llIIlIlIlllIlIl);
            final BakedQuad llIIlIlIlllIIll = llIIlIlIlllIlII.get(0);
            final BakedQuad llIIlIlIlllIIlI = new BakedQuad(llIIlIlIlllIIll.func_178209_a().clone(), llIIlIlIlllIIll.func_178211_c(), llIIlIlIlllIIll.getFace(), llIIlIlIlllIIll.getSprite());
            final int[] llIIlIlIlllIIIl = llIIlIlIlllIIlI.func_178209_a();
            final int[] llIIlIlIlllIIII = llIIlIlIlllIIIl.clone();
            final int llIIlIlIllIllll = llIIlIlIlllIIIl.length / 4;
            System.arraycopy(llIIlIlIlllIIIl, 0 * llIIlIlIllIllll, llIIlIlIlllIIII, 3 * llIIlIlIllIllll, llIIlIlIllIllll);
            System.arraycopy(llIIlIlIlllIIIl, 1 * llIIlIlIllIllll, llIIlIlIlllIIII, 2 * llIIlIlIllIllll, llIIlIlIllIllll);
            System.arraycopy(llIIlIlIlllIIIl, 2 * llIIlIlIllIllll, llIIlIlIlllIIII, 1 * llIIlIlIllIllll, llIIlIlIllIllll);
            System.arraycopy(llIIlIlIlllIIIl, 3 * llIIlIlIllIllll, llIIlIlIlllIIII, 0 * llIIlIlIllIllll, llIIlIlIllIllll);
            System.arraycopy(llIIlIlIlllIIII, 0, llIIlIlIlllIIIl, 0, llIIlIlIlllIIII.length);
            llIIlIlIlllIlII.add(llIIlIlIlllIIlI);
        }
        return llIIlIlIllllIII;
    }
}
