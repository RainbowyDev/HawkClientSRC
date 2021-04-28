package net.minecraft.client.renderer;

import org.lwjgl.opengl.*;
import org.lwjgl.util.glu.*;
import java.nio.*;

public class GLAllocation
{
    public static synchronized ByteBuffer createDirectByteBuffer(final int llllllllllllllIIllIIlIlIlllIIIII) {
        return ByteBuffer.allocateDirect(llllllllllllllIIllIIlIlIlllIIIII).order(ByteOrder.nativeOrder());
    }
    
    public static FloatBuffer createDirectFloatBuffer(final int llllllllllllllIIllIIlIlIllIllIlI) {
        return createDirectByteBuffer(llllllllllllllIIllIIlIlIllIllIlI << 2).asFloatBuffer();
    }
    
    public static synchronized void func_178874_a(final int llllllllllllllIIllIIlIlIlllIlIII, final int llllllllllllllIIllIIlIlIlllIIlll) {
        GL11.glDeleteLists(llllllllllllllIIllIIlIlIlllIlIII, llllllllllllllIIllIIlIlIlllIIlll);
    }
    
    public static synchronized int generateDisplayLists(final int llllllllllllllIIllIIlIlIllllIIlI) {
        final int llllllllllllllIIllIIlIlIllllIIIl = GL11.glGenLists(llllllllllllllIIllIIlIlIllllIIlI);
        if (llllllllllllllIIllIIlIlIllllIIIl == 0) {
            final int llllllllllllllIIllIIlIlIllllIIII = GL11.glGetError();
            String llllllllllllllIIllIIlIlIlllIllll = "No error code reported";
            if (llllllllllllllIIllIIlIlIllllIIII != 0) {
                llllllllllllllIIllIIlIlIlllIllll = GLU.gluErrorString(llllllllllllllIIllIIlIlIllllIIII);
            }
            throw new IllegalStateException(String.valueOf(new StringBuilder("glGenLists returned an ID of 0 for a count of ").append(llllllllllllllIIllIIlIlIllllIIlI).append(", GL error (").append(llllllllllllllIIllIIlIlIllllIIII).append("): ").append(llllllllllllllIIllIIlIlIlllIllll)));
        }
        return llllllllllllllIIllIIlIlIllllIIIl;
    }
    
    static {
        __OBFID = "CL_00000630";
    }
    
    public static synchronized void deleteDisplayLists(final int llllllllllllllIIllIIlIlIlllIIIlI) {
        GL11.glDeleteLists(llllllllllllllIIllIIlIlIlllIIIlI, 1);
    }
    
    public static IntBuffer createDirectIntBuffer(final int llllllllllllllIIllIIlIlIllIlllII) {
        return createDirectByteBuffer(llllllllllllllIIllIIlIlIllIlllII << 2).asIntBuffer();
    }
}
