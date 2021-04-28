package net.minecraft.entity.ai;

import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.block.state.pattern.*;
import net.minecraft.block.*;
import com.google.common.base.*;
import net.minecraft.block.properties.*;

public class EntityAIEatGrass extends EntityAIBase
{
    private /* synthetic */ World entityWorld;
    private static final /* synthetic */ Predicate field_179505_b;
    private /* synthetic */ EntityLiving grassEaterEntity;
    /* synthetic */ int eatingGrassTimer;
    
    @Override
    public void startExecuting() {
        this.eatingGrassTimer = 40;
        this.entityWorld.setEntityState(this.grassEaterEntity, (byte)10);
        this.grassEaterEntity.getNavigator().clearPathEntity();
    }
    
    @Override
    public boolean continueExecuting() {
        return this.eatingGrassTimer > 0;
    }
    
    @Override
    public boolean shouldExecute() {
        if (this.grassEaterEntity.getRNG().nextInt(this.grassEaterEntity.isChild() ? 50 : 1000) != 0) {
            return false;
        }
        final BlockPos llllllllllllllIIlIlllllIllIllIlI = new BlockPos(this.grassEaterEntity.posX, this.grassEaterEntity.posY, this.grassEaterEntity.posZ);
        return EntityAIEatGrass.field_179505_b.apply((Object)this.entityWorld.getBlockState(llllllllllllllIIlIlllllIllIllIlI)) || this.entityWorld.getBlockState(llllllllllllllIIlIlllllIllIllIlI.offsetDown()).getBlock() == Blocks.grass;
    }
    
    static {
        __OBFID = "CL_00001582";
        field_179505_b = (Predicate)BlockStateHelper.forBlock(Blocks.tallgrass).func_177637_a(BlockTallGrass.field_176497_a, Predicates.equalTo((Object)BlockTallGrass.EnumType.GRASS));
    }
    
    @Override
    public void updateTask() {
        this.eatingGrassTimer = Math.max(0, this.eatingGrassTimer - 1);
        if (this.eatingGrassTimer == 4) {
            final BlockPos llllllllllllllIIlIlllllIllIIIlll = new BlockPos(this.grassEaterEntity.posX, this.grassEaterEntity.posY, this.grassEaterEntity.posZ);
            if (EntityAIEatGrass.field_179505_b.apply((Object)this.entityWorld.getBlockState(llllllllllllllIIlIlllllIllIIIlll))) {
                if (this.entityWorld.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
                    this.entityWorld.destroyBlock(llllllllllllllIIlIlllllIllIIIlll, false);
                }
                this.grassEaterEntity.eatGrassBonus();
            }
            else {
                final BlockPos llllllllllllllIIlIlllllIllIIIllI = llllllllllllllIIlIlllllIllIIIlll.offsetDown();
                if (this.entityWorld.getBlockState(llllllllllllllIIlIlllllIllIIIllI).getBlock() == Blocks.grass) {
                    if (this.entityWorld.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
                        this.entityWorld.playAuxSFX(2001, llllllllllllllIIlIlllllIllIIIllI, Block.getIdFromBlock(Blocks.grass));
                        this.entityWorld.setBlockState(llllllllllllllIIlIlllllIllIIIllI, Blocks.dirt.getDefaultState(), 2);
                    }
                    this.grassEaterEntity.eatGrassBonus();
                }
            }
        }
    }
    
    @Override
    public void resetTask() {
        this.eatingGrassTimer = 0;
    }
    
    public EntityAIEatGrass(final EntityLiving llllllllllllllIIlIlllllIlllIIIII) {
        this.grassEaterEntity = llllllllllllllIIlIlllllIlllIIIII;
        this.entityWorld = llllllllllllllIIlIlllllIlllIIIII.worldObj;
        this.setMutexBits(7);
    }
    
    public int getEatingGrassTimer() {
        return this.eatingGrassTimer;
    }
}
