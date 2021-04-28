package net.minecraftforge.client.model;

import net.minecraft.util.*;
import javax.vecmath.*;

public interface ITransformation
{
    int rotate(final EnumFacing p0, final int p1);
    
    EnumFacing rotate(final EnumFacing p0);
    
    Matrix4f getMatrix();
}
