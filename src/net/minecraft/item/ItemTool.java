package net.minecraft.item;

import java.util.*;
import net.minecraft.block.*;
import net.minecraft.creativetab.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import com.google.common.collect.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;

public class ItemTool extends Item
{
    private /* synthetic */ float damageVsEntity;
    protected /* synthetic */ float efficiencyOnProperMaterial;
    protected /* synthetic */ ToolMaterial toolMaterial;
    private /* synthetic */ Set effectiveBlocksTool;
    
    @Override
    public float getStrVsBlock(final ItemStack lllllllllllllllIlllllIlIIlIllIII, final Block lllllllllllllllIlllllIlIIlIlIlll) {
        return this.effectiveBlocksTool.contains(lllllllllllllllIlllllIlIIlIlIlll) ? this.efficiencyOnProperMaterial : 1.0f;
    }
    
    protected ItemTool(final float lllllllllllllllIlllllIlIIlIllllI, final ToolMaterial lllllllllllllllIlllllIlIIlIlllIl, final Set lllllllllllllllIlllllIlIIlIlllII) {
        this.efficiencyOnProperMaterial = 4.0f;
        this.toolMaterial = lllllllllllllllIlllllIlIIlIlllIl;
        this.effectiveBlocksTool = lllllllllllllllIlllllIlIIlIlllII;
        this.maxStackSize = 1;
        this.setMaxDamage(lllllllllllllllIlllllIlIIlIlllIl.getMaxUses());
        this.efficiencyOnProperMaterial = lllllllllllllllIlllllIlIIlIlllIl.getEfficiencyOnProperMaterial();
        this.damageVsEntity = lllllllllllllllIlllllIlIIlIllllI + lllllllllllllllIlllllIlIIlIlllIl.getDamageVsEntity();
        this.setCreativeTab(CreativeTabs.tabTools);
    }
    
    @Override
    public boolean hitEntity(final ItemStack lllllllllllllllIlllllIlIIlIlIIIl, final EntityLivingBase lllllllllllllllIlllllIlIIlIlIIII, final EntityLivingBase lllllllllllllllIlllllIlIIlIIllIl) {
        lllllllllllllllIlllllIlIIlIlIIIl.damageItem(2, lllllllllllllllIlllllIlIIlIIllIl);
        return true;
    }
    
    @Override
    public boolean isFull3D() {
        return true;
    }
    
    @Override
    public int getItemEnchantability() {
        return this.toolMaterial.getEnchantability();
    }
    
    @Override
    public boolean onBlockDestroyed(final ItemStack lllllllllllllllIlllllIlIIlIIIIIl, final World lllllllllllllllIlllllIlIIlIIIIII, final Block lllllllllllllllIlllllIlIIIllllll, final BlockPos lllllllllllllllIlllllIlIIlIIIIll, final EntityLivingBase lllllllllllllllIlllllIlIIlIIIIlI) {
        if (lllllllllllllllIlllllIlIIIllllll.getBlockHardness(lllllllllllllllIlllllIlIIlIIIIII, lllllllllllllllIlllllIlIIlIIIIll) != 0.0) {
            lllllllllllllllIlllllIlIIlIIIIIl.damageItem(1, lllllllllllllllIlllllIlIIlIIIIlI);
        }
        return true;
    }
    
    static {
        __OBFID = "CL_00000019";
    }
    
    public String getToolMaterialName() {
        return this.toolMaterial.toString();
    }
    
    @Override
    public boolean getIsRepairable(final ItemStack lllllllllllllllIlllllIlIIIlIlllI, final ItemStack lllllllllllllllIlllllIlIIIlIlIlI) {
        return this.toolMaterial.getBaseItemForRepair() == lllllllllllllllIlllllIlIIIlIlIlI.getItem() || super.getIsRepairable(lllllllllllllllIlllllIlIIIlIlllI, lllllllllllllllIlllllIlIIIlIlIlI);
    }
    
    public ToolMaterial getToolMaterial() {
        return this.toolMaterial;
    }
    
    @Override
    public Multimap getItemAttributeModifiers() {
        final Multimap lllllllllllllllIlllllIlIIIlIIllI = super.getItemAttributeModifiers();
        lllllllllllllllIlllllIlIIIlIIllI.put((Object)SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), (Object)new AttributeModifier(ItemTool.itemModifierUUID, "Tool modifier", this.damageVsEntity, 0));
        return lllllllllllllllIlllllIlIIIlIIllI;
    }
}
