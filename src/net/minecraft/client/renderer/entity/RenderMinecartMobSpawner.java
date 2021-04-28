package net.minecraft.client.renderer.entity;

import net.minecraft.entity.ai.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.item.*;
import net.minecraft.init.*;
import net.minecraft.client.renderer.tileentity.*;

public class RenderMinecartMobSpawner extends RenderMinecart
{
    public RenderMinecartMobSpawner(final RenderManager lllllllllllllllIIIllllllIIlIlIlI) {
        super(lllllllllllllllIIIllllllIIlIlIlI);
    }
    
    static {
        __OBFID = "CL_00001014";
    }
    
    protected void func_177081_a(final EntityMinecartMobSpawner lllllllllllllllIIIllllllIIlIIlII, final float lllllllllllllllIIIllllllIIlIIIll, final IBlockState lllllllllllllllIIIllllllIIlIIIlI) {
        super.func_180560_a(lllllllllllllllIIIllllllIIlIIlII, lllllllllllllllIIIllllllIIlIIIll, lllllllllllllllIIIllllllIIlIIIlI);
        if (lllllllllllllllIIIllllllIIlIIIlI.getBlock() == Blocks.mob_spawner) {
            TileEntityMobSpawnerRenderer.func_147517_a(lllllllllllllllIIIllllllIIlIIlII.func_98039_d(), lllllllllllllllIIIllllllIIlIIlII.posX, lllllllllllllllIIIllllllIIlIIlII.posY, lllllllllllllllIIIllllllIIlIIlII.posZ, lllllllllllllllIIIllllllIIlIIIll);
        }
    }
    
    @Override
    protected void func_180560_a(final EntityMinecart lllllllllllllllIIIllllllIIIllIII, final float lllllllllllllllIIIllllllIIIlIIll, final IBlockState lllllllllllllllIIIllllllIIIlIllI) {
        this.func_177081_a((EntityMinecartMobSpawner)lllllllllllllllIIIllllllIIIllIII, lllllllllllllllIIIllllllIIIlIIll, lllllllllllllllIIIllllllIIIlIllI);
    }
}
