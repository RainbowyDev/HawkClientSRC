package net.minecraft.item;

import net.minecraft.world.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import com.google.common.collect.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.entity.player.*;

public class ItemSword extends Item
{
    private final /* synthetic */ ToolMaterial repairMaterial;
    private /* synthetic */ float field_150934_a;
    
    @Override
    public boolean hitEntity(final ItemStack llllllllllllllllIIIllIIIllIIIlll, final EntityLivingBase llllllllllllllllIIIllIIIllIIlIIl, final EntityLivingBase llllllllllllllllIIIllIIIllIIIllI) {
        llllllllllllllllIIIllIIIllIIIlll.damageItem(1, llllllllllllllllIIIllIIIllIIIllI);
        return true;
    }
    
    @Override
    public boolean isFull3D() {
        return true;
    }
    
    @Override
    public boolean onBlockDestroyed(final ItemStack llllllllllllllllIIIllIIIlIllllll, final World llllllllllllllllIIIllIIIlIlllllI, final Block llllllllllllllllIIIllIIIlIlllIII, final BlockPos llllllllllllllllIIIllIIIlIllIlll, final EntityLivingBase llllllllllllllllIIIllIIIlIlllIll) {
        if (llllllllllllllllIIIllIIIlIlllIII.getBlockHardness(llllllllllllllllIIIllIIIlIlllllI, llllllllllllllllIIIllIIIlIllIlll) != 0.0) {
            llllllllllllllllIIIllIIIlIllllll.damageItem(2, llllllllllllllllIIIllIIIlIlllIll);
        }
        return true;
    }
    
    public String getToolMaterialName() {
        return this.repairMaterial.toString();
    }
    
    @Override
    public int getItemEnchantability() {
        return this.repairMaterial.getEnchantability();
    }
    
    @Override
    public Multimap getItemAttributeModifiers() {
        final Multimap llllllllllllllllIIIllIIIlIIlIIII = super.getItemAttributeModifiers();
        llllllllllllllllIIIllIIIlIIlIIII.put((Object)SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), (Object)new AttributeModifier(ItemSword.itemModifierUUID, "Weapon modifier", this.field_150934_a, 0));
        return llllllllllllllllIIIllIIIlIIlIIII;
    }
    
    @Override
    public EnumAction getItemUseAction(final ItemStack llllllllllllllllIIIllIIIlIllIIll) {
        return EnumAction.BLOCK;
    }
    
    @Override
    public float getStrVsBlock(final ItemStack llllllllllllllllIIIllIIIllIlIIlI, final Block llllllllllllllllIIIllIIIllIlIIIl) {
        if (llllllllllllllllIIIllIIIllIlIIIl == Blocks.web) {
            return 15.0f;
        }
        final Material llllllllllllllllIIIllIIIllIlIIII = llllllllllllllllIIIllIIIllIlIIIl.getMaterial();
        return (llllllllllllllllIIIllIIIllIlIIII != Material.plants && llllllllllllllllIIIllIIIllIlIIII != Material.vine && llllllllllllllllIIIllIIIllIlIIII != Material.coral && llllllllllllllllIIIllIIIllIlIIII != Material.leaves && llllllllllllllllIIIllIIIllIlIIII != Material.gourd) ? 1.0f : 1.5f;
    }
    
    public ItemSword(final ToolMaterial llllllllllllllllIIIllIIIllIllIll) {
        this.repairMaterial = llllllllllllllllIIIllIIIllIllIll;
        this.maxStackSize = 1;
        this.setMaxDamage(llllllllllllllllIIIllIIIllIllIll.getMaxUses());
        this.setCreativeTab(CreativeTabs.tabCombat);
        this.field_150934_a = 4.0f + llllllllllllllllIIIllIIIllIllIll.getDamageVsEntity();
    }
    
    @Override
    public boolean getIsRepairable(final ItemStack llllllllllllllllIIIllIIIlIIlIlIl, final ItemStack llllllllllllllllIIIllIIIlIIlIlII) {
        return this.repairMaterial.getBaseItemForRepair() == llllllllllllllllIIIllIIIlIIlIlII.getItem() || super.getIsRepairable(llllllllllllllllIIIllIIIlIIlIlIl, llllllllllllllllIIIllIIIlIIlIlII);
    }
    
    static {
        __OBFID = "CL_00000072";
    }
    
    @Override
    public ItemStack onItemRightClick(final ItemStack llllllllllllllllIIIllIIIlIlIlIII, final World llllllllllllllllIIIllIIIlIlIlIll, final EntityPlayer llllllllllllllllIIIllIIIlIlIIlll) {
        llllllllllllllllIIIllIIIlIlIIlll.setItemInUse(llllllllllllllllIIIllIIIlIlIlIII, this.getMaxItemUseDuration(llllllllllllllllIIIllIIIlIlIlIII));
        return llllllllllllllllIIIllIIIlIlIlIII;
    }
    
    @Override
    public int getMaxItemUseDuration(final ItemStack llllllllllllllllIIIllIIIlIllIIIl) {
        return 72000;
    }
    
    public float func_150931_i() {
        return this.repairMaterial.getDamageVsEntity();
    }
    
    @Override
    public boolean canHarvestBlock(final Block llllllllllllllllIIIllIIIlIlIIIll) {
        return llllllllllllllllIIIllIIIlIlIIIll == Blocks.web;
    }
}
