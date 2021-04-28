package net.minecraft.client.renderer;

import org.lwjgl.opengl.*;
import optifine.*;
import shadersmod.client.*;
import net.minecraft.client.renderer.vertex.*;
import java.nio.*;
import java.util.*;

public class WorldVertexBufferUploader
{
    public int draw(final WorldRenderer llllllllllllllllIllllIIlIIllIIlI, final int llllllllllllllllIllllIIlIIllIIIl) {
        if (llllllllllllllllIllllIIlIIllIIIl > 0) {
            final VertexFormat llllllllllllllllIllllIIlIIllIIII = llllllllllllllllIllllIIlIIllIIlI.func_178973_g();
            final int llllllllllllllllIllllIIlIIlIllll = llllllllllllllllIllllIIlIIllIIII.func_177338_f();
            final ByteBuffer llllllllllllllllIllllIIlIIlIlllI = llllllllllllllllIllllIIlIIllIIlI.func_178966_f();
            final List llllllllllllllllIllllIIlIIlIllIl = llllllllllllllllIllllIIlIIllIIII.func_177343_g();
            Iterator llllllllllllllllIllllIIlIIlIllII = llllllllllllllllIllllIIlIIlIllIl.iterator();
            final boolean llllllllllllllllIllllIIlIIlIlIll = Reflector.ForgeVertexFormatElementEnumUseage_preDraw.exists();
            final boolean llllllllllllllllIllllIIlIIlIlIlI = Reflector.ForgeVertexFormatElementEnumUseage_postDraw.exists();
            while (llllllllllllllllIllllIIlIIlIllII.hasNext()) {
                final VertexFormatElement llllllllllllllllIllllIIlIIlIlIIl = llllllllllllllllIllllIIlIIlIllII.next();
                final VertexFormatElement.EnumUseage llllllllllllllllIllllIIlIIlIIlll = llllllllllllllllIllllIIlIIlIlIIl.func_177375_c();
                if (llllllllllllllllIllllIIlIIlIlIll) {
                    Reflector.callVoid(llllllllllllllllIllllIIlIIlIIlll, Reflector.ForgeVertexFormatElementEnumUseage_preDraw, llllllllllllllllIllllIIlIIlIlIIl, llllllllllllllllIllllIIlIIlIllll, llllllllllllllllIllllIIlIIlIlllI);
                }
                else {
                    final int llllllllllllllllIllllIIlIIlIIlIl = llllllllllllllllIllllIIlIIlIlIIl.func_177367_b().func_177397_c();
                    final int llllllllllllllllIllllIIlIIlIIIll = llllllllllllllllIllllIIlIIlIlIIl.func_177369_e();
                    switch (SwitchEnumUseage.field_178958_a[llllllllllllllllIllllIIlIIlIIlll.ordinal()]) {
                        default: {
                            continue;
                        }
                        case 1: {
                            llllllllllllllllIllllIIlIIlIlllI.position(llllllllllllllllIllllIIlIIlIlIIl.func_177373_a());
                            GL11.glVertexPointer(llllllllllllllllIllllIIlIIlIlIIl.func_177370_d(), llllllllllllllllIllllIIlIIlIIlIl, llllllllllllllllIllllIIlIIlIllll, llllllllllllllllIllllIIlIIlIlllI);
                            GL11.glEnableClientState(32884);
                            continue;
                        }
                        case 2: {
                            llllllllllllllllIllllIIlIIlIlllI.position(llllllllllllllllIllllIIlIIlIlIIl.func_177373_a());
                            OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit + llllllllllllllllIllllIIlIIlIIIll);
                            GL11.glTexCoordPointer(llllllllllllllllIllllIIlIIlIlIIl.func_177370_d(), llllllllllllllllIllllIIlIIlIIlIl, llllllllllllllllIllllIIlIIlIllll, llllllllllllllllIllllIIlIIlIlllI);
                            GL11.glEnableClientState(32888);
                            OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit);
                            continue;
                        }
                        case 3: {
                            llllllllllllllllIllllIIlIIlIlllI.position(llllllllllllllllIllllIIlIIlIlIIl.func_177373_a());
                            GL11.glColorPointer(llllllllllllllllIllllIIlIIlIlIIl.func_177370_d(), llllllllllllllllIllllIIlIIlIIlIl, llllllllllllllllIllllIIlIIlIllll, llllllllllllllllIllllIIlIIlIlllI);
                            GL11.glEnableClientState(32886);
                            continue;
                        }
                        case 4: {
                            llllllllllllllllIllllIIlIIlIlllI.position(llllllllllllllllIllllIIlIIlIlIIl.func_177373_a());
                            GL11.glNormalPointer(llllllllllllllllIllllIIlIIlIIlIl, llllllllllllllllIllllIIlIIlIllll, llllllllllllllllIllllIIlIIlIlllI);
                            GL11.glEnableClientState(32885);
                            continue;
                        }
                    }
                }
            }
            if (llllllllllllllllIllllIIlIIllIIlI.isMultiTexture()) {
                llllllllllllllllIllllIIlIIllIIlI.drawMultiTexture();
            }
            else if (Config.isShaders()) {
                SVertexBuilder.drawArrays(llllllllllllllllIllllIIlIIllIIlI.getDrawMode(), 0, llllllllllllllllIllllIIlIIllIIlI.func_178989_h(), llllllllllllllllIllllIIlIIllIIlI);
            }
            else {
                GL11.glDrawArrays(llllllllllllllllIllllIIlIIllIIlI.getDrawMode(), 0, llllllllllllllllIllllIIlIIllIIlI.func_178989_h());
            }
            llllllllllllllllIllllIIlIIlIllII = llllllllllllllllIllllIIlIIlIllIl.iterator();
            while (llllllllllllllllIllllIIlIIlIllII.hasNext()) {
                final VertexFormatElement llllllllllllllllIllllIIlIIlIlIII = llllllllllllllllIllllIIlIIlIllII.next();
                final VertexFormatElement.EnumUseage llllllllllllllllIllllIIlIIlIIllI = llllllllllllllllIllllIIlIIlIlIII.func_177375_c();
                if (llllllllllllllllIllllIIlIIlIlIlI) {
                    Reflector.callVoid(llllllllllllllllIllllIIlIIlIIllI, Reflector.ForgeVertexFormatElementEnumUseage_postDraw, llllllllllllllllIllllIIlIIlIlIII, llllllllllllllllIllllIIlIIlIllll, llllllllllllllllIllllIIlIIlIlllI);
                }
                else {
                    final int llllllllllllllllIllllIIlIIlIIlII = llllllllllllllllIllllIIlIIlIlIII.func_177369_e();
                    switch (SwitchEnumUseage.field_178958_a[llllllllllllllllIllllIIlIIlIIllI.ordinal()]) {
                        default: {
                            continue;
                        }
                        case 1: {
                            GL11.glDisableClientState(32884);
                            continue;
                        }
                        case 2: {
                            OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit + llllllllllllllllIllllIIlIIlIIlII);
                            GL11.glDisableClientState(32888);
                            OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit);
                            continue;
                        }
                        case 3: {
                            GL11.glDisableClientState(32886);
                            GlStateManager.func_179117_G();
                            continue;
                        }
                        case 4: {
                            GL11.glDisableClientState(32885);
                            continue;
                        }
                    }
                }
            }
        }
        llllllllllllllllIllllIIlIIllIIlI.reset();
        return llllllllllllllllIllllIIlIIllIIIl;
    }
    
    static final class SwitchEnumUseage
    {
        static final /* synthetic */ int[] field_178958_a;
        
        static {
            field_178958_a = new int[VertexFormatElement.EnumUseage.values().length];
            try {
                SwitchEnumUseage.field_178958_a[VertexFormatElement.EnumUseage.POSITION.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                SwitchEnumUseage.field_178958_a[VertexFormatElement.EnumUseage.UV.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                SwitchEnumUseage.field_178958_a[VertexFormatElement.EnumUseage.COLOR.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                SwitchEnumUseage.field_178958_a[VertexFormatElement.EnumUseage.NORMAL.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
        }
    }
}
