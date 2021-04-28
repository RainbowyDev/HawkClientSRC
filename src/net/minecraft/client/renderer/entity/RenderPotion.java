package net.minecraft.client.renderer.entity;

import net.minecraft.init.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;

public class RenderPotion extends RenderSnowball
{
    public RenderPotion(final RenderManager llllllllllllllIIlIIIlIIlllIlIIll, final RenderItem llllllllllllllIIlIIIlIIlllIIllll) {
        super(llllllllllllllIIlIIIlIIlllIlIIll, Items.potionitem, llllllllllllllIIlIIIlIIlllIIllll);
    }
    
    public ItemStack func_177085_a(final EntityPotion llllllllllllllIIlIIIlIIlllIIlIll) {
        return new ItemStack(this.field_177084_a, 1, llllllllllllllIIlIIIlIIlllIIlIll.getPotionDamage());
    }
    
    static {
        __OBFID = "CL_00002430";
    }
    
    @Override
    public ItemStack func_177082_d(final Entity llllllllllllllIIlIIIlIIlllIIIIll) {
        return this.func_177085_a((EntityPotion)llllllllllllllIIlIIIlIIlllIIIIll);
    }
}
