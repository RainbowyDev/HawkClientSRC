package net.minecraftforge.client.model.pipeline;

import net.minecraft.client.renderer.vertex.*;
import net.minecraft.util.*;

public interface IVertexConsumer
{
    void setQuadTint(final int p0);
    
    VertexFormat getVertexFormat();
    
    void setQuadColored();
    
    void setQuadOrientation(final EnumFacing p0);
    
    void put(final int p0, final float... p1);
}
