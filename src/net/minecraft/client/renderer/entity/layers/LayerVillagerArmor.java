package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.*;

public class LayerVillagerArmor extends LayerBipedArmor
{
    @Override
    protected void func_177177_a() {
        this.field_177189_c = new ModelZombieVillager(0.5f, 0.0f, true);
        this.field_177186_d = new ModelZombieVillager(1.0f, 0.0f, true);
    }
    
    static {
        __OBFID = "CL_00002409";
    }
    
    public LayerVillagerArmor(final RendererLivingEntity llllllllllllllIIlIIlIllllIIllllI) {
        super(llllllllllllllIIlIIlIllllIIllllI);
    }
}
