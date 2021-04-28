package optifine;

import net.minecraft.world.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.client.resources.model.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.resources.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import java.util.*;
import java.io.*;
import net.minecraft.block.*;
import net.minecraft.world.biome.*;

public class ConnectedTextures
{
    private static /* synthetic */ TextureAtlasSprite emptySprite;
    private static final /* synthetic */ int[] ctmIndexes;
    public static final /* synthetic */ IBlockState AIR_DEFAULT_STATE;
    private static /* synthetic */ ConnectedProperties[][] blockProperties;
    private static /* synthetic */ boolean multipass;
    private static /* synthetic */ Map[] spriteQuadMaps;
    private static /* synthetic */ ConnectedProperties[][] tileProperties;
    
    private static int fixSideByAxis(final int llllllllllllllIIIlllllllIlIllIII, final int llllllllllllllIIIlllllllIlIlIlll) {
        switch (llllllllllllllIIIlllllllIlIlIlll) {
            case 0: {
                return llllllllllllllIIIlllllllIlIllIII;
            }
            case 1: {
                switch (llllllllllllllIIIlllllllIlIllIII) {
                    case 0: {
                        return 2;
                    }
                    case 1: {
                        return 3;
                    }
                    case 2: {
                        return 1;
                    }
                    case 3: {
                        return 0;
                    }
                    default: {
                        return llllllllllllllIIIlllllllIlIllIII;
                    }
                }
                break;
            }
            case 2: {
                switch (llllllllllllllIIIlllllllIlIllIII) {
                    case 0: {
                        return 4;
                    }
                    case 1: {
                        return 5;
                    }
                    default: {
                        return llllllllllllllIIIlllllllIlIllIII;
                    }
                    case 4: {
                        return 1;
                    }
                    case 5: {
                        return 0;
                    }
                }
                break;
            }
            default: {
                return llllllllllllllIIIlllllllIlIllIII;
            }
        }
    }
    
    private static TextureAtlasSprite getConnectedTextureMultiPass(final IBlockAccess llllllllllllllIIlIIIIIIIIIIlIIIl, final IBlockState llllllllllllllIIlIIIIIIIIIIlIIII, final BlockPos llllllllllllllIIlIIIIIIIIIIIlllI, final EnumFacing llllllllllllllIIlIIIIIIIIIIlllII, final TextureAtlasSprite llllllllllllllIIlIIIIIIIIIIllIll, final RenderEnv llllllllllllllIIlIIIIIIIIIIIlIII) {
        final TextureAtlasSprite llllllllllllllIIlIIIIIIIIIIllIII = getConnectedTextureSingle(llllllllllllllIIlIIIIIIIIIIlIIIl, llllllllllllllIIlIIIIIIIIIIlIIII, llllllllllllllIIlIIIIIIIIIIIlllI, llllllllllllllIIlIIIIIIIIIIlllII, llllllllllllllIIlIIIIIIIIIIllIll, true, llllllllllllllIIlIIIIIIIIIIIlIII);
        if (!ConnectedTextures.multipass) {
            return llllllllllllllIIlIIIIIIIIIIllIII;
        }
        if (llllllllllllllIIlIIIIIIIIIIllIII == llllllllllllllIIlIIIIIIIIIIllIll) {
            return llllllllllllllIIlIIIIIIIIIIllIII;
        }
        TextureAtlasSprite llllllllllllllIIlIIIIIIIIIIlIllI = llllllllllllllIIlIIIIIIIIIIllIII;
        for (int llllllllllllllIIlIIIIIIIIIIlIlII = 0; llllllllllllllIIlIIIIIIIIIIlIlII < 3; ++llllllllllllllIIlIIIIIIIIIIlIlII) {
            final TextureAtlasSprite llllllllllllllIIlIIIIIIIIIIlIIlI = getConnectedTextureSingle(llllllllllllllIIlIIIIIIIIIIlIIIl, llllllllllllllIIlIIIIIIIIIIlIIII, llllllllllllllIIlIIIIIIIIIIIlllI, llllllllllllllIIlIIIIIIIIIIlllII, llllllllllllllIIlIIIIIIIIIIlIllI, false, llllllllllllllIIlIIIIIIIIIIIlIII);
            if (llllllllllllllIIlIIIIIIIIIIlIIlI == llllllllllllllIIlIIIIIIIIIIlIllI) {
                break;
            }
            llllllllllllllIIlIIIIIIIIIIlIllI = llllllllllllllIIlIIIIIIIIIIlIIlI;
        }
        return llllllllllllllIIlIIIIIIIIIIlIllI;
    }
    
    private static TextureAtlasSprite getConnectedTextureFixed(final ConnectedProperties llllllllllllllIIIlllllllIIlIlllI) {
        return llllllllllllllIIIlllllllIIlIlllI.tileIcons[0];
    }
    
    private static TextureAtlasSprite getConnectedTextureHorizontal(final ConnectedProperties llllllllllllllIIIllllllIIlIIlIll, final IBlockAccess llllllllllllllIIIllllllIIlIllIIl, final IBlockState llllllllllllllIIIllllllIIlIllIII, final BlockPos llllllllllllllIIIllllllIIlIIlIII, final int llllllllllllllIIIllllllIIlIlIllI, final int llllllllllllllIIIllllllIIlIIIllI, final TextureAtlasSprite llllllllllllllIIIllllllIIlIlIlII, final int llllllllllllllIIIllllllIIlIIIlII) {
        boolean llllllllllllllIIIllllllIIlIlIIlI = false;
        boolean llllllllllllllIIIllllllIIlIlIIIl = false;
        Label_0634: {
            switch (llllllllllllllIIIllllllIIlIlIllI) {
                case 0: {
                    switch (llllllllllllllIIIllllllIIlIIIllI) {
                        case 0:
                        case 1: {
                            return null;
                        }
                        case 2: {
                            llllllllllllllIIIllllllIIlIlIIlI = isNeighbour(llllllllllllllIIIllllllIIlIIlIll, llllllllllllllIIIllllllIIlIllIIl, llllllllllllllIIIllllllIIlIllIII, llllllllllllllIIIllllllIIlIIlIII.offsetEast(), llllllllllllllIIIllllllIIlIIIllI, llllllllllllllIIIllllllIIlIlIlII, llllllllllllllIIIllllllIIlIIIlII);
                            llllllllllllllIIIllllllIIlIlIIIl = isNeighbour(llllllllllllllIIIllllllIIlIIlIll, llllllllllllllIIIllllllIIlIllIIl, llllllllllllllIIIllllllIIlIllIII, llllllllllllllIIIllllllIIlIIlIII.offsetWest(), llllllllllllllIIIllllllIIlIIIllI, llllllllllllllIIIllllllIIlIlIlII, llllllllllllllIIIllllllIIlIIIlII);
                            break;
                        }
                        case 3: {
                            llllllllllllllIIIllllllIIlIlIIlI = isNeighbour(llllllllllllllIIIllllllIIlIIlIll, llllllllllllllIIIllllllIIlIllIIl, llllllllllllllIIIllllllIIlIllIII, llllllllllllllIIIllllllIIlIIlIII.offsetWest(), llllllllllllllIIIllllllIIlIIIllI, llllllllllllllIIIllllllIIlIlIlII, llllllllllllllIIIllllllIIlIIIlII);
                            llllllllllllllIIIllllllIIlIlIIIl = isNeighbour(llllllllllllllIIIllllllIIlIIlIll, llllllllllllllIIIllllllIIlIllIIl, llllllllllllllIIIllllllIIlIllIII, llllllllllllllIIIllllllIIlIIlIII.offsetEast(), llllllllllllllIIIllllllIIlIIIllI, llllllllllllllIIIllllllIIlIlIlII, llllllllllllllIIIllllllIIlIIIlII);
                            break;
                        }
                        case 4: {
                            llllllllllllllIIIllllllIIlIlIIlI = isNeighbour(llllllllllllllIIIllllllIIlIIlIll, llllllllllllllIIIllllllIIlIllIIl, llllllllllllllIIIllllllIIlIllIII, llllllllllllllIIIllllllIIlIIlIII.offsetNorth(), llllllllllllllIIIllllllIIlIIIllI, llllllllllllllIIIllllllIIlIlIlII, llllllllllllllIIIllllllIIlIIIlII);
                            llllllllllllllIIIllllllIIlIlIIIl = isNeighbour(llllllllllllllIIIllllllIIlIIlIll, llllllllllllllIIIllllllIIlIllIIl, llllllllllllllIIIllllllIIlIllIII, llllllllllllllIIIllllllIIlIIlIII.offsetSouth(), llllllllllllllIIIllllllIIlIIIllI, llllllllllllllIIIllllllIIlIlIlII, llllllllllllllIIIllllllIIlIIIlII);
                            break;
                        }
                        case 5: {
                            llllllllllllllIIIllllllIIlIlIIlI = isNeighbour(llllllllllllllIIIllllllIIlIIlIll, llllllllllllllIIIllllllIIlIllIIl, llllllllllllllIIIllllllIIlIllIII, llllllllllllllIIIllllllIIlIIlIII.offsetSouth(), llllllllllllllIIIllllllIIlIIIllI, llllllllllllllIIIllllllIIlIlIlII, llllllllllllllIIIllllllIIlIIIlII);
                            llllllllllllllIIIllllllIIlIlIIIl = isNeighbour(llllllllllllllIIIllllllIIlIIlIll, llllllllllllllIIIllllllIIlIllIIl, llllllllllllllIIIllllllIIlIllIII, llllllllllllllIIIllllllIIlIIlIII.offsetNorth(), llllllllllllllIIIllllllIIlIIIllI, llllllllllllllIIIllllllIIlIlIlII, llllllllllllllIIIllllllIIlIIIlII);
                            break;
                        }
                    }
                    break;
                }
                case 1: {
                    switch (llllllllllllllIIIllllllIIlIIIllI) {
                        case 0: {
                            llllllllllllllIIIllllllIIlIlIIlI = isNeighbour(llllllllllllllIIIllllllIIlIIlIll, llllllllllllllIIIllllllIIlIllIIl, llllllllllllllIIIllllllIIlIllIII, llllllllllllllIIIllllllIIlIIlIII.offsetWest(), llllllllllllllIIIllllllIIlIIIllI, llllllllllllllIIIllllllIIlIlIlII, llllllllllllllIIIllllllIIlIIIlII);
                            llllllllllllllIIIllllllIIlIlIIIl = isNeighbour(llllllllllllllIIIllllllIIlIIlIll, llllllllllllllIIIllllllIIlIllIIl, llllllllllllllIIIllllllIIlIllIII, llllllllllllllIIIllllllIIlIIlIII.offsetEast(), llllllllllllllIIIllllllIIlIIIllI, llllllllllllllIIIllllllIIlIlIlII, llllllllllllllIIIllllllIIlIIIlII);
                            break;
                        }
                        case 1: {
                            llllllllllllllIIIllllllIIlIlIIlI = isNeighbour(llllllllllllllIIIllllllIIlIIlIll, llllllllllllllIIIllllllIIlIllIIl, llllllllllllllIIIllllllIIlIllIII, llllllllllllllIIIllllllIIlIIlIII.offsetWest(), llllllllllllllIIIllllllIIlIIIllI, llllllllllllllIIIllllllIIlIlIlII, llllllllllllllIIIllllllIIlIIIlII);
                            llllllllllllllIIIllllllIIlIlIIIl = isNeighbour(llllllllllllllIIIllllllIIlIIlIll, llllllllllllllIIIllllllIIlIllIIl, llllllllllllllIIIllllllIIlIllIII, llllllllllllllIIIllllllIIlIIlIII.offsetEast(), llllllllllllllIIIllllllIIlIIIllI, llllllllllllllIIIllllllIIlIlIlII, llllllllllllllIIIllllllIIlIIIlII);
                            break;
                        }
                        case 2:
                        case 3: {
                            return null;
                        }
                        case 4: {
                            llllllllllllllIIIllllllIIlIlIIlI = isNeighbour(llllllllllllllIIIllllllIIlIIlIll, llllllllllllllIIIllllllIIlIllIIl, llllllllllllllIIIllllllIIlIllIII, llllllllllllllIIIllllllIIlIIlIII.offsetDown(), llllllllllllllIIIllllllIIlIIIllI, llllllllllllllIIIllllllIIlIlIlII, llllllllllllllIIIllllllIIlIIIlII);
                            llllllllllllllIIIllllllIIlIlIIIl = isNeighbour(llllllllllllllIIIllllllIIlIIlIll, llllllllllllllIIIllllllIIlIllIIl, llllllllllllllIIIllllllIIlIllIII, llllllllllllllIIIllllllIIlIIlIII.offsetUp(), llllllllllllllIIIllllllIIlIIIllI, llllllllllllllIIIllllllIIlIlIlII, llllllllllllllIIIllllllIIlIIIlII);
                            break;
                        }
                        case 5: {
                            llllllllllllllIIIllllllIIlIlIIlI = isNeighbour(llllllllllllllIIIllllllIIlIIlIll, llllllllllllllIIIllllllIIlIllIIl, llllllllllllllIIIllllllIIlIllIII, llllllllllllllIIIllllllIIlIIlIII.offsetUp(), llllllllllllllIIIllllllIIlIIIllI, llllllllllllllIIIllllllIIlIlIlII, llllllllllllllIIIllllllIIlIIIlII);
                            llllllllllllllIIIllllllIIlIlIIIl = isNeighbour(llllllllllllllIIIllllllIIlIIlIll, llllllllllllllIIIllllllIIlIllIIl, llllllllllllllIIIllllllIIlIllIII, llllllllllllllIIIllllllIIlIIlIII.offsetDown(), llllllllllllllIIIllllllIIlIIIllI, llllllllllllllIIIllllllIIlIlIlII, llllllllllllllIIIllllllIIlIIIlII);
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    switch (llllllllllllllIIIllllllIIlIIIllI) {
                        case 0: {
                            llllllllllllllIIIllllllIIlIlIIlI = isNeighbour(llllllllllllllIIIllllllIIlIIlIll, llllllllllllllIIIllllllIIlIllIIl, llllllllllllllIIIllllllIIlIllIII, llllllllllllllIIIllllllIIlIIlIII.offsetNorth(), llllllllllllllIIIllllllIIlIIIllI, llllllllllllllIIIllllllIIlIlIlII, llllllllllllllIIIllllllIIlIIIlII);
                            llllllllllllllIIIllllllIIlIlIIIl = isNeighbour(llllllllllllllIIIllllllIIlIIlIll, llllllllllllllIIIllllllIIlIllIIl, llllllllllllllIIIllllllIIlIllIII, llllllllllllllIIIllllllIIlIIlIII.offsetSouth(), llllllllllllllIIIllllllIIlIIIllI, llllllllllllllIIIllllllIIlIlIlII, llllllllllllllIIIllllllIIlIIIlII);
                            break Label_0634;
                        }
                        case 1: {
                            llllllllllllllIIIllllllIIlIlIIlI = isNeighbour(llllllllllllllIIIllllllIIlIIlIll, llllllllllllllIIIllllllIIlIllIIl, llllllllllllllIIIllllllIIlIllIII, llllllllllllllIIIllllllIIlIIlIII.offsetNorth(), llllllllllllllIIIllllllIIlIIIllI, llllllllllllllIIIllllllIIlIlIlII, llllllllllllllIIIllllllIIlIIIlII);
                            llllllllllllllIIIllllllIIlIlIIIl = isNeighbour(llllllllllllllIIIllllllIIlIIlIll, llllllllllllllIIIllllllIIlIllIIl, llllllllllllllIIIllllllIIlIllIII, llllllllllllllIIIllllllIIlIIlIII.offsetSouth(), llllllllllllllIIIllllllIIlIIIllI, llllllllllllllIIIllllllIIlIlIlII, llllllllllllllIIIllllllIIlIIIlII);
                            break Label_0634;
                        }
                        case 2: {
                            llllllllllllllIIIllllllIIlIlIIlI = isNeighbour(llllllllllllllIIIllllllIIlIIlIll, llllllllllllllIIIllllllIIlIllIIl, llllllllllllllIIIllllllIIlIllIII, llllllllllllllIIIllllllIIlIIlIII.offsetDown(), llllllllllllllIIIllllllIIlIIIllI, llllllllllllllIIIllllllIIlIlIlII, llllllllllllllIIIllllllIIlIIIlII);
                            llllllllllllllIIIllllllIIlIlIIIl = isNeighbour(llllllllllllllIIIllllllIIlIIlIll, llllllllllllllIIIllllllIIlIllIIl, llllllllllllllIIIllllllIIlIllIII, llllllllllllllIIIllllllIIlIIlIII.offsetUp(), llllllllllllllIIIllllllIIlIIIllI, llllllllllllllIIIllllllIIlIlIlII, llllllllllllllIIIllllllIIlIIIlII);
                            break Label_0634;
                        }
                        case 3: {
                            llllllllllllllIIIllllllIIlIlIIlI = isNeighbour(llllllllllllllIIIllllllIIlIIlIll, llllllllllllllIIIllllllIIlIllIIl, llllllllllllllIIIllllllIIlIllIII, llllllllllllllIIIllllllIIlIIlIII.offsetUp(), llllllllllllllIIIllllllIIlIIIllI, llllllllllllllIIIllllllIIlIlIlII, llllllllllllllIIIllllllIIlIIIlII);
                            llllllllllllllIIIllllllIIlIlIIIl = isNeighbour(llllllllllllllIIIllllllIIlIIlIll, llllllllllllllIIIllllllIIlIllIIl, llllllllllllllIIIllllllIIlIllIII, llllllllllllllIIIllllllIIlIIlIII.offsetDown(), llllllllllllllIIIllllllIIlIIIllI, llllllllllllllIIIllllllIIlIlIlII, llllllllllllllIIIllllllIIlIIIlII);
                            break Label_0634;
                        }
                        case 4:
                        case 5: {
                            return null;
                        }
                    }
                    break;
                }
            }
        }
        final boolean llllllllllllllIIIllllllIIlIlIIII = true;
        byte llllllllllllllIIIllllllIIlIIllII = 0;
        if (llllllllllllllIIIllllllIIlIlIIlI) {
            if (llllllllllllllIIIllllllIIlIlIIIl) {
                final byte llllllllllllllIIIllllllIIlIIllll = 1;
            }
            else {
                final byte llllllllllllllIIIllllllIIlIIlllI = 2;
            }
        }
        else if (llllllllllllllIIIllllllIIlIlIIIl) {
            final byte llllllllllllllIIIllllllIIlIIllIl = 0;
        }
        else {
            llllllllllllllIIIllllllIIlIIllII = 3;
        }
        return llllllllllllllIIIllllllIIlIIlIll.tileIcons[llllllllllllllIIIllllllIIlIIllII];
    }
    
    private static TextureAtlasSprite getNeighbourIcon(final IBlockAccess llllllllllllllIIIllllllIIlllIIII, final BlockPos llllllllllllllIIIllllllIIllllIlI, IBlockState llllllllllllllIIIllllllIIllIlllI, final int llllllllllllllIIIllllllIIllllIII) {
        llllllllllllllIIIllllllIIllIlllI = (char)((IBlockState)llllllllllllllIIIllllllIIllIlllI).getBlock().getActualState((IBlockState)llllllllllllllIIIllllllIIllIlllI, llllllllllllllIIIllllllIIlllIIII, llllllllllllllIIIllllllIIllllIlI);
        final IBakedModel llllllllllllllIIIllllllIIlllIlll = Minecraft.getMinecraft().getBlockRendererDispatcher().func_175023_a().func_178125_b((IBlockState)llllllllllllllIIIllllllIIllIlllI);
        if (llllllllllllllIIIllllllIIlllIlll == null) {
            return null;
        }
        final EnumFacing llllllllllllllIIIllllllIIlllIllI = getFacing(llllllllllllllIIIllllllIIllllIII);
        final List llllllllllllllIIIllllllIIlllIlIl = llllllllllllllIIIllllllIIlllIlll.func_177551_a(llllllllllllllIIIllllllIIlllIllI);
        if (llllllllllllllIIIllllllIIlllIlIl.size() > 0) {
            final BakedQuad llllllllllllllIIIllllllIIlllIlII = llllllllllllllIIIllllllIIlllIlIl.get(0);
            return llllllllllllllIIIllllllIIlllIlII.getSprite();
        }
        final List llllllllllllllIIIllllllIIlllIIll = llllllllllllllIIIllllllIIlllIlll.func_177550_a();
        for (int llllllllllllllIIIllllllIIlllIIlI = 0; llllllllllllllIIIllllllIIlllIIlI < llllllllllllllIIIllllllIIlllIIll.size(); ++llllllllllllllIIIllllllIIlllIIlI) {
            final BakedQuad llllllllllllllIIIllllllIIlllIIIl = llllllllllllllIIIllllllIIlllIIll.get(llllllllllllllIIIllllllIIlllIIlI);
            if (llllllllllllllIIIllllllIIlllIIIl.getFace() == llllllllllllllIIIllllllIIlllIllI) {
                return llllllllllllllIIIllllllIIlllIIIl.getSprite();
            }
        }
        return null;
    }
    
    public static TextureAtlasSprite getCtmTexture(final ConnectedProperties llllllllllllllIIIlllllIlIIIIIIII, final int llllllllllllllIIIlllllIIllllllll, final TextureAtlasSprite llllllllllllllIIIlllllIIlllllllI) {
        if (llllllllllllllIIIlllllIlIIIIIIII.method != 1) {
            return llllllllllllllIIIlllllIIlllllllI;
        }
        if (llllllllllllllIIIlllllIIllllllll >= 0 && llllllllllllllIIIlllllIIllllllll < ConnectedTextures.ctmIndexes.length) {
            final int llllllllllllllIIIlllllIlIIIIIIlI = ConnectedTextures.ctmIndexes[llllllllllllllIIIlllllIIllllllll];
            final TextureAtlasSprite[] llllllllllllllIIIlllllIlIIIIIIIl = llllllllllllllIIIlllllIlIIIIIIII.tileIcons;
            return (llllllllllllllIIIlllllIlIIIIIIlI >= 0 && llllllllllllllIIIlllllIlIIIIIIlI < llllllllllllllIIIlllllIlIIIIIIIl.length) ? llllllllllllllIIIlllllIlIIIIIIIl[llllllllllllllIIIlllllIlIIIIIIlI] : llllllllllllllIIIlllllIIlllllllI;
        }
        return llllllllllllllIIIlllllIIlllllllI;
    }
    
    private static TextureAtlasSprite getConnectedTextureHorizontalVertical(final ConnectedProperties llllllllllllllIIIllllllIIIIIllIl, final IBlockAccess llllllllllllllIIIllllllIIIIIIIIl, final IBlockState llllllllllllllIIIllllllIIIIIlIll, final BlockPos llllllllllllllIIIlllllIlllllllll, final int llllllllllllllIIIlllllIllllllllI, final int llllllllllllllIIIlllllIlllllllIl, final TextureAtlasSprite llllllllllllllIIIllllllIIIIIIlll, final int llllllllllllllIIIlllllIllllllIll) {
        final TextureAtlasSprite[] llllllllllllllIIIllllllIIIIIIlIl = llllllllllllllIIIllllllIIIIIllIl.tileIcons;
        final TextureAtlasSprite llllllllllllllIIIllllllIIIIIIlII = getConnectedTextureHorizontal(llllllllllllllIIIllllllIIIIIllIl, llllllllllllllIIIllllllIIIIIIIIl, llllllllllllllIIIllllllIIIIIlIll, llllllllllllllIIIlllllIlllllllll, llllllllllllllIIIlllllIllllllllI, llllllllllllllIIIlllllIlllllllIl, llllllllllllllIIIllllllIIIIIIlll, llllllllllllllIIIlllllIllllllIll);
        if (llllllllllllllIIIllllllIIIIIIlII != null && llllllllllllllIIIllllllIIIIIIlII != llllllllllllllIIIllllllIIIIIIlll && llllllllllllllIIIllllllIIIIIIlII != llllllllllllllIIIllllllIIIIIIlIl[3]) {
            return llllllllllllllIIIllllllIIIIIIlII;
        }
        final TextureAtlasSprite llllllllllllllIIIllllllIIIIIIIll = getConnectedTextureVertical(llllllllllllllIIIllllllIIIIIllIl, llllllllllllllIIIllllllIIIIIIIIl, llllllllllllllIIIllllllIIIIIlIll, llllllllllllllIIIlllllIlllllllll, llllllllllllllIIIlllllIllllllllI, llllllllllllllIIIlllllIlllllllIl, llllllllllllllIIIllllllIIIIIIlll, llllllllllllllIIIlllllIllllllIll);
        return (llllllllllllllIIIllllllIIIIIIIll == llllllllllllllIIIllllllIIIIIIlIl[0]) ? llllllllllllllIIIllllllIIIIIIlIl[4] : ((llllllllllllllIIIllllllIIIIIIIll == llllllllllllllIIIllllllIIIIIIlIl[1]) ? llllllllllllllIIIllllllIIIIIIlIl[5] : ((llllllllllllllIIIllllllIIIIIIIll == llllllllllllllIIIllllllIIIIIIlIl[2]) ? llllllllllllllIIIllllllIIIIIIlIl[6] : llllllllllllllIIIllllllIIIIIIIll));
    }
    
    public static int getPaneTextureIndex(final boolean llllllllllllllIIIlllllIlIIIlIlII, final boolean llllllllllllllIIIlllllIlIIIlIlll, final boolean llllllllllllllIIIlllllIlIIIlIllI, final boolean llllllllllllllIIIlllllIlIIIlIlIl) {
        return (llllllllllllllIIIlllllIlIIIlIlll && llllllllllllllIIIlllllIlIIIlIlII) ? (llllllllllllllIIIlllllIlIIIlIllI ? (llllllllllllllIIIlllllIlIIIlIlIl ? 34 : 50) : (llllllllllllllIIIlllllIlIIIlIlIl ? 18 : 2)) : ((llllllllllllllIIIlllllIlIIIlIlll && !llllllllllllllIIIlllllIlIIIlIlII) ? (llllllllllllllIIIlllllIlIIIlIllI ? (llllllllllllllIIIlllllIlIIIlIlIl ? 35 : 51) : (llllllllllllllIIIlllllIlIIIlIlIl ? 19 : 3)) : ((!llllllllllllllIIIlllllIlIIIlIlll && llllllllllllllIIIlllllIlIIIlIlII) ? (llllllllllllllIIIlllllIlIIIlIllI ? (llllllllllllllIIIlllllIlIIIlIlIl ? 33 : 49) : (llllllllllllllIIIlllllIlIIIlIlIl ? 17 : 1)) : (llllllllllllllIIIlllllIlIIIlIllI ? (llllllllllllllIIIlllllIlIIIlIlIl ? 32 : 48) : (llllllllllllllIIIlllllIlIIIlIlIl ? 16 : 0))));
    }
    
    public static void updateIcons(final TextureMap llllllllllllllIIIlllllIllIllIlll) {
        ConnectedTextures.blockProperties = null;
        ConnectedTextures.tileProperties = null;
        ConnectedTextures.spriteQuadMaps = null;
        if (Config.isConnectedTextures()) {
            final IResourcePack[] llllllllllllllIIIlllllIllIllIllI = Config.getResourcePacks();
            for (int llllllllllllllIIIlllllIllIllIlIl = llllllllllllllIIIlllllIllIllIllI.length - 1; llllllllllllllIIIlllllIllIllIlIl >= 0; --llllllllllllllIIIlllllIllIllIlIl) {
                final IResourcePack llllllllllllllIIIlllllIllIllIlII = llllllllllllllIIIlllllIllIllIllI[llllllllllllllIIIlllllIllIllIlIl];
                updateIcons(llllllllllllllIIIlllllIllIllIlll, llllllllllllllIIIlllllIllIllIlII);
            }
            updateIcons(llllllllllllllIIIlllllIllIllIlll, Config.getDefaultResourcePack());
            final ResourceLocation llllllllllllllIIIlllllIllIllIIll = new ResourceLocation("mcpatcher/ctm/default/empty");
            ConnectedTextures.emptySprite = llllllllllllllIIIlllllIllIllIlll.func_174942_a(llllllllllllllIIIlllllIllIllIIll);
            ConnectedTextures.spriteQuadMaps = new Map[llllllllllllllIIIlllllIllIllIlll.getCountRegisteredSprites() + 1];
            if (ConnectedTextures.blockProperties.length <= 0) {
                ConnectedTextures.blockProperties = null;
            }
            if (ConnectedTextures.tileProperties.length <= 0) {
                ConnectedTextures.tileProperties = null;
            }
        }
    }
    
    private static TextureAtlasSprite getConnectedTextureRepeat(final ConnectedProperties llllllllllllllIIIlllllllIIlIIlII, final BlockPos llllllllllllllIIIlllllllIIIllIlI, final int llllllllllllllIIIlllllllIIlIIIlI) {
        if (llllllllllllllIIIlllllllIIlIIlII.tileIcons.length == 1) {
            return llllllllllllllIIIlllllllIIlIIlII.tileIcons[0];
        }
        final int llllllllllllllIIIlllllllIIlIIIIl = llllllllllllllIIIlllllllIIIllIlI.getX();
        final int llllllllllllllIIIlllllllIIlIIIII = llllllllllllllIIIlllllllIIIllIlI.getY();
        final int llllllllllllllIIIlllllllIIIlllll = llllllllllllllIIIlllllllIIIllIlI.getZ();
        int llllllllllllllIIIlllllllIIIllllI = 0;
        int llllllllllllllIIIlllllllIIIlllIl = 0;
        switch (llllllllllllllIIIlllllllIIlIIIlI) {
            case 0: {
                llllllllllllllIIIlllllllIIIllllI = llllllllllllllIIIlllllllIIlIIIIl;
                llllllllllllllIIIlllllllIIIlllIl = llllllllllllllIIIlllllllIIIlllll;
                break;
            }
            case 1: {
                llllllllllllllIIIlllllllIIIllllI = llllllllllllllIIIlllllllIIlIIIIl;
                llllllllllllllIIIlllllllIIIlllIl = llllllllllllllIIIlllllllIIIlllll;
                break;
            }
            case 2: {
                llllllllllllllIIIlllllllIIIllllI = -llllllllllllllIIIlllllllIIlIIIIl - 1;
                llllllllllllllIIIlllllllIIIlllIl = -llllllllllllllIIIlllllllIIlIIIII;
                break;
            }
            case 3: {
                llllllllllllllIIIlllllllIIIllllI = llllllllllllllIIIlllllllIIlIIIIl;
                llllllllllllllIIIlllllllIIIlllIl = -llllllllllllllIIIlllllllIIlIIIII;
                break;
            }
            case 4: {
                llllllllllllllIIIlllllllIIIllllI = llllllllllllllIIIlllllllIIIlllll;
                llllllllllllllIIIlllllllIIIlllIl = -llllllllllllllIIIlllllllIIlIIIII;
                break;
            }
            case 5: {
                llllllllllllllIIIlllllllIIIllllI = -llllllllllllllIIIlllllllIIIlllll - 1;
                llllllllllllllIIIlllllllIIIlllIl = -llllllllllllllIIIlllllllIIlIIIII;
                break;
            }
        }
        llllllllllllllIIIlllllllIIIllllI %= llllllllllllllIIIlllllllIIlIIlII.width;
        llllllllllllllIIIlllllllIIIlllIl %= llllllllllllllIIIlllllllIIlIIlII.height;
        if (llllllllllllllIIIlllllllIIIllllI < 0) {
            llllllllllllllIIIlllllllIIIllllI += llllllllllllllIIIlllllllIIlIIlII.width;
        }
        if (llllllllllllllIIIlllllllIIIlllIl < 0) {
            llllllllllllllIIIlllllllIIIlllIl += llllllllllllllIIIlllllllIIlIIlII.height;
        }
        final int llllllllllllllIIIlllllllIIIlllII = llllllllllllllIIIlllllllIIIlllIl * llllllllllllllIIIlllllllIIlIIlII.width + llllllllllllllIIIlllllllIIIllllI;
        return llllllllllllllIIIlllllllIIlIIlII.tileIcons[llllllllllllllIIIlllllllIIIlllII];
    }
    
    private static int getQuartzAxis(final int llllllllllllllIIIlllllllIlIIlllI, final int llllllllllllllIIIlllllllIlIIllII) {
        switch (llllllllllllllIIIlllllllIlIIllII) {
            case 3: {
                return 2;
            }
            case 4: {
                return 1;
            }
            default: {
                return 0;
            }
        }
    }
    
    private static boolean detectMultipass() {
        final ArrayList llllllllllllllIIIlllllIlIlllIIll = new ArrayList();
        for (int llllllllllllllIIIlllllIlIlllIIlI = 0; llllllllllllllIIIlllllIlIlllIIlI < ConnectedTextures.tileProperties.length; ++llllllllllllllIIIlllllIlIlllIIlI) {
            final ConnectedProperties[] llllllllllllllIIIlllllIlIlllIIIl = ConnectedTextures.tileProperties[llllllllllllllIIIlllllIlIlllIIlI];
            if (llllllllllllllIIIlllllIlIlllIIIl != null) {
                llllllllllllllIIIlllllIlIlllIIll.addAll(Arrays.asList(llllllllllllllIIIlllllIlIlllIIIl));
            }
        }
        for (int llllllllllllllIIIlllllIlIlllIIlI = 0; llllllllllllllIIIlllllIlIlllIIlI < ConnectedTextures.blockProperties.length; ++llllllllllllllIIIlllllIlIlllIIlI) {
            final ConnectedProperties[] llllllllllllllIIIlllllIlIlllIIII = ConnectedTextures.blockProperties[llllllllllllllIIIlllllIlIlllIIlI];
            if (llllllllllllllIIIlllllIlIlllIIII != null) {
                llllllllllllllIIIlllllIlIlllIIll.addAll(Arrays.asList(llllllllllllllIIIlllllIlIlllIIII));
            }
        }
        final ConnectedProperties[] llllllllllllllIIIlllllIlIllIllll = llllllllllllllIIIlllllIlIlllIIll.toArray(new ConnectedProperties[llllllllllllllIIIlllllIlIlllIIll.size()]);
        final HashSet llllllllllllllIIIlllllIlIllIlllI = new HashSet();
        final HashSet llllllllllllllIIIlllllIlIllIllIl = new HashSet();
        for (int llllllllllllllIIIlllllIlIllIllII = 0; llllllllllllllIIIlllllIlIllIllII < llllllllllllllIIIlllllIlIllIllll.length; ++llllllllllllllIIIlllllIlIllIllII) {
            final ConnectedProperties llllllllllllllIIIlllllIlIllIlIll = llllllllllllllIIIlllllIlIllIllll[llllllllllllllIIIlllllIlIllIllII];
            if (llllllllllllllIIIlllllIlIllIlIll.matchTileIcons != null) {
                llllllllllllllIIIlllllIlIllIlllI.addAll(Arrays.asList(llllllllllllllIIIlllllIlIllIlIll.matchTileIcons));
            }
            if (llllllllllllllIIIlllllIlIllIlIll.tileIcons != null) {
                llllllllllllllIIIlllllIlIllIllIl.addAll(Arrays.asList(llllllllllllllIIIlllllIlIllIlIll.tileIcons));
            }
        }
        llllllllllllllIIIlllllIlIllIlllI.retainAll(llllllllllllllIIIlllllIlIllIllIl);
        return !llllllllllllllIIIlllllIlIllIlllI.isEmpty();
    }
    
    private static ConnectedProperties[][] propertyListToArray(final List llllllllllllllIIIlllllIlIlIlllIl) {
        final ConnectedProperties[][] llllllllllllllIIIlllllIlIlIlllII = new ConnectedProperties[llllllllllllllIIIlllllIlIlIlllIl.size()][];
        for (int llllllllllllllIIIlllllIlIlIllIll = 0; llllllllllllllIIIlllllIlIlIllIll < llllllllllllllIIIlllllIlIlIlllIl.size(); ++llllllllllllllIIIlllllIlIlIllIll) {
            final List llllllllllllllIIIlllllIlIlIllIlI = llllllllllllllIIIlllllIlIlIlllIl.get(llllllllllllllIIIlllllIlIlIllIll);
            if (llllllllllllllIIIlllllIlIlIllIlI != null) {
                final ConnectedProperties[] llllllllllllllIIIlllllIlIlIllIIl = llllllllllllllIIIlllllIlIlIllIlI.toArray(new ConnectedProperties[llllllllllllllIIIlllllIlIlIllIlI.size()]);
                llllllllllllllIIIlllllIlIlIlllII[llllllllllllllIIIlllllIlIlIllIll] = llllllllllllllIIIlllllIlIlIllIIl;
            }
        }
        return llllllllllllllIIIlllllIlIlIlllII;
    }
    
    private static TextureAtlasSprite getConnectedTextureVerticalHorizontal(final ConnectedProperties llllllllllllllIIIlllllIllllIllII, final IBlockAccess llllllllllllllIIIlllllIllllIlIll, final IBlockState llllllllllllllIIIlllllIlllIlllll, final BlockPos llllllllllllllIIIlllllIllllIlIIl, final int llllllllllllllIIIlllllIllllIlIII, final int llllllllllllllIIIlllllIlllIlllII, final TextureAtlasSprite llllllllllllllIIIlllllIlllIllIll, final int llllllllllllllIIIlllllIllllIIlIl) {
        final TextureAtlasSprite[] llllllllllllllIIIlllllIllllIIlII = llllllllllllllIIIlllllIllllIllII.tileIcons;
        final TextureAtlasSprite llllllllllllllIIIlllllIllllIIIll = getConnectedTextureVertical(llllllllllllllIIIlllllIllllIllII, llllllllllllllIIIlllllIllllIlIll, llllllllllllllIIIlllllIlllIlllll, llllllllllllllIIIlllllIllllIlIIl, llllllllllllllIIIlllllIllllIlIII, llllllllllllllIIIlllllIlllIlllII, llllllllllllllIIIlllllIlllIllIll, llllllllllllllIIIlllllIllllIIlIl);
        if (llllllllllllllIIIlllllIllllIIIll != null && llllllllllllllIIIlllllIllllIIIll != llllllllllllllIIIlllllIlllIllIll && llllllllllllllIIIlllllIllllIIIll != llllllllllllllIIIlllllIllllIIlII[3]) {
            return llllllllllllllIIIlllllIllllIIIll;
        }
        final TextureAtlasSprite llllllllllllllIIIlllllIllllIIIlI = getConnectedTextureHorizontal(llllllllllllllIIIlllllIllllIllII, llllllllllllllIIIlllllIllllIlIll, llllllllllllllIIIlllllIlllIlllll, llllllllllllllIIIlllllIllllIlIIl, llllllllllllllIIIlllllIllllIlIII, llllllllllllllIIIlllllIlllIlllII, llllllllllllllIIIlllllIlllIllIll, llllllllllllllIIIlllllIllllIIlIl);
        return (llllllllllllllIIIlllllIllllIIIlI == llllllllllllllIIIlllllIllllIIlII[0]) ? llllllllllllllIIIlllllIllllIIlII[4] : ((llllllllllllllIIIlllllIllllIIIlI == llllllllllllllIIIlllllIllllIIlII[1]) ? llllllllllllllIIIlllllIllllIIlII[5] : ((llllllllllllllIIIlllllIllllIIIlI == llllllllllllllIIIlllllIllllIIlII[2]) ? llllllllllllllIIIlllllIllllIIlII[6] : llllllllllllllIIIlllllIllllIIIlI));
    }
    
    public static int getSide(final EnumFacing llllllllllllllIIIllllllllIIlIlII) {
        if (llllllllllllllIIIllllllllIIlIlII == null) {
            return -1;
        }
        switch (NamelessClass379831726.$SwitchMap$net$minecraft$util$EnumFacing[llllllllllllllIIIllllllllIIlIlII.ordinal()]) {
            case 1: {
                return 0;
            }
            case 2: {
                return 1;
            }
            case 3: {
                return 5;
            }
            case 4: {
                return 4;
            }
            case 5: {
                return 2;
            }
            case 6: {
                return 3;
            }
            default: {
                return -1;
            }
        }
    }
    
    private static BakedQuad getQuad(final TextureAtlasSprite llllllllllllllIIlIIIIIIIIllIIIll, final Block llllllllllllllIIlIIIIIIIIllIlIIl, final IBlockState llllllllllllllIIlIIIIIIIIllIlIII, final BakedQuad llllllllllllllIIlIIIIIIIIllIIIlI) {
        if (ConnectedTextures.spriteQuadMaps == null) {
            return llllllllllllllIIlIIIIIIIIllIIIlI;
        }
        final int llllllllllllllIIlIIIIIIIIllIIllI = llllllllllllllIIlIIIIIIIIllIIIll.getIndexInMap();
        if (llllllllllllllIIlIIIIIIIIllIIllI >= 0 && llllllllllllllIIlIIIIIIIIllIIllI < ConnectedTextures.spriteQuadMaps.length) {
            Object llllllllllllllIIlIIIIIIIIllIIlIl = ConnectedTextures.spriteQuadMaps[llllllllllllllIIlIIIIIIIIllIIllI];
            if (llllllllllllllIIlIIIIIIIIllIIlIl == null) {
                llllllllllllllIIlIIIIIIIIllIIlIl = new IdentityHashMap(1);
                ConnectedTextures.spriteQuadMaps[llllllllllllllIIlIIIIIIIIllIIllI] = (Map)llllllllllllllIIlIIIIIIIIllIIlIl;
            }
            BakedQuad llllllllllllllIIlIIIIIIIIllIIlII = ((Map)llllllllllllllIIlIIIIIIIIllIIlIl).get(llllllllllllllIIlIIIIIIIIllIIIlI);
            if (llllllllllllllIIlIIIIIIIIllIIlII == null) {
                llllllllllllllIIlIIIIIIIIllIIlII = makeSpriteQuad(llllllllllllllIIlIIIIIIIIllIIIlI, llllllllllllllIIlIIIIIIIIllIIIll);
                ((Map)llllllllllllllIIlIIIIIIIIllIIlIl).put(llllllllllllllIIlIIIIIIIIllIIIlI, llllllllllllllIIlIIIIIIIIllIIlII);
            }
            return llllllllllllllIIlIIIIIIIIllIIlII;
        }
        return llllllllllllllIIlIIIIIIIIllIIIlI;
    }
    
    private static TextureAtlasSprite getConnectedTextureTop(final ConnectedProperties llllllllllllllIIIlllllIlllIIllIl, final IBlockAccess llllllllllllllIIIlllllIlllIIIIll, final IBlockState llllllllllllllIIIlllllIlllIIIIlI, final BlockPos llllllllllllllIIIlllllIlllIIIIIl, final int llllllllllllllIIIlllllIlllIIlIIl, final int llllllllllllllIIIlllllIllIllllll, final TextureAtlasSprite llllllllllllllIIIlllllIllIlllllI, final int llllllllllllllIIIlllllIllIllllIl) {
        boolean llllllllllllllIIIlllllIlllIIIlIl = false;
        switch (llllllllllllllIIIlllllIlllIIlIIl) {
            case 0: {
                if (llllllllllllllIIIlllllIllIllllll == 1 || llllllllllllllIIIlllllIllIllllll == 0) {
                    return null;
                }
                llllllllllllllIIIlllllIlllIIIlIl = isNeighbour(llllllllllllllIIIlllllIlllIIllIl, llllllllllllllIIIlllllIlllIIIIll, llllllllllllllIIIlllllIlllIIIIlI, llllllllllllllIIIlllllIlllIIIIIl.offsetUp(), llllllllllllllIIIlllllIllIllllll, llllllllllllllIIIlllllIllIlllllI, llllllllllllllIIIlllllIllIllllIl);
                break;
            }
            case 1: {
                if (llllllllllllllIIIlllllIllIllllll == 3 || llllllllllllllIIIlllllIllIllllll == 2) {
                    return null;
                }
                llllllllllllllIIIlllllIlllIIIlIl = isNeighbour(llllllllllllllIIIlllllIlllIIllIl, llllllllllllllIIIlllllIlllIIIIll, llllllllllllllIIIlllllIlllIIIIlI, llllllllllllllIIIlllllIlllIIIIIl.offsetSouth(), llllllllllllllIIIlllllIllIllllll, llllllllllllllIIIlllllIllIlllllI, llllllllllllllIIIlllllIllIllllIl);
                break;
            }
            case 2: {
                if (llllllllllllllIIIlllllIllIllllll == 5 || llllllllllllllIIIlllllIllIllllll == 4) {
                    return null;
                }
                llllllllllllllIIIlllllIlllIIIlIl = isNeighbour(llllllllllllllIIIlllllIlllIIllIl, llllllllllllllIIIlllllIlllIIIIll, llllllllllllllIIIlllllIlllIIIIlI, llllllllllllllIIIlllllIlllIIIIIl.offsetEast(), llllllllllllllIIIlllllIllIllllll, llllllllllllllIIIlllllIllIlllllI, llllllllllllllIIIlllllIllIllllIl);
                break;
            }
        }
        return llllllllllllllIIIlllllIlllIIIlIl ? llllllllllllllIIIlllllIlllIIllIl.tileIcons[0] : null;
    }
    
    public static int getReversePaneTextureIndex(final int llllllllllllllIIIlllllIlIIIIlllI) {
        final int llllllllllllllIIIlllllIlIIIIllIl = llllllllllllllIIIlllllIlIIIIlllI % 16;
        return (llllllllllllllIIIlllllIlIIIIllIl == 1) ? (llllllllllllllIIIlllllIlIIIIlllI + 2) : ((llllllllllllllIIIlllllIlIIIIllIl == 3) ? (llllllllllllllIIIlllllIlIIIIlllI - 2) : llllllllllllllIIIlllllIlIIIIlllI);
    }
    
    private static TextureAtlasSprite getConnectedTextureRandom(final ConnectedProperties llllllllllllllIIIlllllllIlIIIIlI, final BlockPos llllllllllllllIIIlllllllIlIIIIIl, final int llllllllllllllIIIlllllllIIllIlll) {
        if (llllllllllllllIIIlllllllIlIIIIlI.tileIcons.length == 1) {
            return llllllllllllllIIIlllllllIlIIIIlI.tileIcons[0];
        }
        final int llllllllllllllIIIlllllllIIllllll = llllllllllllllIIIlllllllIIllIlll / llllllllllllllIIIlllllllIlIIIIlI.symmetry * llllllllllllllIIIlllllllIlIIIIlI.symmetry;
        final int llllllllllllllIIIlllllllIIlllllI = Config.getRandom(llllllllllllllIIIlllllllIlIIIIIl, llllllllllllllIIIlllllllIIllllll) & Integer.MAX_VALUE;
        int llllllllllllllIIIlllllllIIllllIl = 0;
        if (llllllllllllllIIIlllllllIlIIIIlI.weights == null) {
            llllllllllllllIIIlllllllIIllllIl = llllllllllllllIIIlllllllIIlllllI % llllllllllllllIIIlllllllIlIIIIlI.tileIcons.length;
        }
        else {
            final int llllllllllllllIIIlllllllIIllllII = llllllllllllllIIIlllllllIIlllllI % llllllllllllllIIIlllllllIlIIIIlI.sumAllWeights;
            final int[] llllllllllllllIIIlllllllIIlllIll = llllllllllllllIIIlllllllIlIIIIlI.sumWeights;
            for (int llllllllllllllIIIlllllllIIlllIlI = 0; llllllllllllllIIIlllllllIIlllIlI < llllllllllllllIIIlllllllIIlllIll.length; ++llllllllllllllIIIlllllllIIlllIlI) {
                if (llllllllllllllIIIlllllllIIllllII < llllllllllllllIIIlllllllIIlllIll[llllllllllllllIIIlllllllIIlllIlI]) {
                    llllllllllllllIIIlllllllIIllllIl = llllllllllllllIIIlllllllIIlllIlI;
                    break;
                }
            }
        }
        return llllllllllllllIIIlllllllIlIIIIlI.tileIcons[llllllllllllllIIIlllllllIIllllIl];
    }
    
    public static TextureAtlasSprite getConnectedTextureSingle(final IBlockAccess llllllllllllllIIIllllllllIllIllI, final IBlockState llllllllllllllIIIlllllllllIlIlll, final BlockPos llllllllllllllIIIlllllllllIlIlIl, final EnumFacing llllllllllllllIIIlllllllllIlIlII, final TextureAtlasSprite llllllllllllllIIIllllllllIllIIIl, final boolean llllllllllllllIIIlllllllllIlIIII, final RenderEnv llllllllllllllIIIlllllllllIIlllI) {
        final Block llllllllllllllIIIlllllllllIIllII = llllllllllllllIIIlllllllllIlIlll.getBlock();
        if (!(llllllllllllllIIIlllllllllIlIlll instanceof BlockStateBase)) {
            return llllllllllllllIIIllllllllIllIIIl;
        }
        final BlockStateBase llllllllllllllIIIlllllllllIIlIlI = (BlockStateBase)llllllllllllllIIIlllllllllIlIlll;
        if (ConnectedTextures.tileProperties != null) {
            final int llllllllllllllIIIlllllllllIIlIII = llllllllllllllIIIllllllllIllIIIl.getIndexInMap();
            if (llllllllllllllIIIlllllllllIIlIII >= 0 && llllllllllllllIIIlllllllllIIlIII < ConnectedTextures.tileProperties.length) {
                final ConnectedProperties[] llllllllllllllIIIlllllllllIIIIII = ConnectedTextures.tileProperties[llllllllllllllIIIlllllllllIIlIII];
                if (llllllllllllllIIIlllllllllIIIIII != null) {
                    final int llllllllllllllIIIllllllllIlllllI = getSide(llllllllllllllIIIlllllllllIlIlII);
                    for (int llllllllllllllIIIllllllllIllllII = 0; llllllllllllllIIIllllllllIllllII < llllllllllllllIIIlllllllllIIIIII.length; ++llllllllllllllIIIllllllllIllllII) {
                        final ConnectedProperties llllllllllllllIIIllllllllIlllIlI = llllllllllllllIIIlllllllllIIIIII[llllllllllllllIIIllllllllIllllII];
                        if (llllllllllllllIIIllllllllIlllIlI != null && llllllllllllllIIIllllllllIlllIlI.matchesBlockId(llllllllllllllIIIlllllllllIIlIlI.getBlockId())) {
                            final TextureAtlasSprite llllllllllllllIIIllllllllIlllIII = getConnectedTexture(llllllllllllllIIIllllllllIlllIlI, llllllllllllllIIIllllllllIllIllI, llllllllllllllIIIlllllllllIIlIlI, llllllllllllllIIIlllllllllIlIlIl, llllllllllllllIIIllllllllIlllllI, llllllllllllllIIIllllllllIllIIIl, llllllllllllllIIIlllllllllIIlllI);
                            if (llllllllllllllIIIllllllllIlllIII != null) {
                                return llllllllllllllIIIllllllllIlllIII;
                            }
                        }
                    }
                }
            }
        }
        if (ConnectedTextures.blockProperties != null && llllllllllllllIIIlllllllllIlIIII) {
            final int llllllllllllllIIIlllllllllIIIIIl = llllllllllllllIIIlllllllllIIlllI.getBlockId();
            if (llllllllllllllIIIlllllllllIIIIIl >= 0 && llllllllllllllIIIlllllllllIIIIIl < ConnectedTextures.blockProperties.length) {
                final ConnectedProperties[] llllllllllllllIIIllllllllIllllll = ConnectedTextures.blockProperties[llllllllllllllIIIlllllllllIIIIIl];
                if (llllllllllllllIIIllllllllIllllll != null) {
                    final int llllllllllllllIIIllllllllIllllIl = getSide(llllllllllllllIIIlllllllllIlIlII);
                    for (int llllllllllllllIIIllllllllIlllIll = 0; llllllllllllllIIIllllllllIlllIll < llllllllllllllIIIllllllllIllllll.length; ++llllllllllllllIIIllllllllIlllIll) {
                        final ConnectedProperties llllllllllllllIIIllllllllIlllIIl = llllllllllllllIIIllllllllIllllll[llllllllllllllIIIllllllllIlllIll];
                        if (llllllllllllllIIIllllllllIlllIIl != null && llllllllllllllIIIllllllllIlllIIl.matchesIcon(llllllllllllllIIIllllllllIllIIIl)) {
                            final TextureAtlasSprite llllllllllllllIIIllllllllIllIlll = getConnectedTexture(llllllllllllllIIIllllllllIlllIIl, llllllllllllllIIIllllllllIllIllI, llllllllllllllIIIlllllllllIIlIlI, llllllllllllllIIIlllllllllIlIlIl, llllllllllllllIIIllllllllIllllIl, llllllllllllllIIIllllllllIllIIIl, llllllllllllllIIIlllllllllIIlllI);
                            if (llllllllllllllIIIllllllllIllIlll != null) {
                                return llllllllllllllIIIllllllllIllIlll;
                            }
                        }
                    }
                }
            }
        }
        return llllllllllllllIIIllllllllIllIIIl;
    }
    
    private static int getWoodAxis(final int llllllllllllllIIIlllllllIlIlIlII, final int llllllllllllllIIIlllllllIlIlIIIl) {
        final int llllllllllllllIIIlllllllIlIlIIlI = (llllllllllllllIIIlllllllIlIlIIIl & 0xC) >> 2;
        switch (llllllllllllllIIIlllllllIlIlIIlI) {
            case 1: {
                return 2;
            }
            case 2: {
                return 1;
            }
            default: {
                return 0;
            }
        }
    }
    
    private static List makePropertyList(final ConnectedProperties[][] llllllllllllllIIIlllllIllIIIIIII) {
        final ArrayList llllllllllllllIIIlllllIllIIIIlII = new ArrayList();
        if (llllllllllllllIIIlllllIllIIIIIII != null) {
            for (int llllllllllllllIIIlllllIllIIIIIll = 0; llllllllllllllIIIlllllIllIIIIIll < llllllllllllllIIIlllllIllIIIIIII.length; ++llllllllllllllIIIlllllIllIIIIIll) {
                final ConnectedProperties[] llllllllllllllIIIlllllIllIIIIIlI = llllllllllllllIIIlllllIllIIIIIII[llllllllllllllIIIlllllIllIIIIIll];
                ArrayList llllllllllllllIIIlllllIllIIIIIIl = null;
                if (llllllllllllllIIIlllllIllIIIIIlI != null) {
                    llllllllllllllIIIlllllIllIIIIIIl = new ArrayList((Collection<? extends E>)Arrays.asList(llllllllllllllIIIlllllIllIIIIIlI));
                }
                llllllllllllllIIIlllllIllIIIIlII.add(llllllllllllllIIIlllllIllIIIIIIl);
            }
        }
        return llllllllllllllIIIlllllIllIIIIlII;
    }
    
    private static void fixVertex(final int[] llllllllllllllIIlIIIIIIIIlIIIlII, final int llllllllllllllIIlIIIIIIIIIlllIIl, final TextureAtlasSprite llllllllllllllIIlIIIIIIIIlIIIIlI, final TextureAtlasSprite llllllllllllllIIlIIIIIIIIIllIlll) {
        final int llllllllllllllIIlIIIIIIIIlIIIIII = llllllllllllllIIlIIIIIIIIlIIIlII.length / 4;
        final int llllllllllllllIIlIIIIIIIIIllllll = llllllllllllllIIlIIIIIIIIlIIIIII * llllllllllllllIIlIIIIIIIIIlllIIl;
        final float llllllllllllllIIlIIIIIIIIIlllllI = Float.intBitsToFloat(llllllllllllllIIlIIIIIIIIlIIIlII[llllllllllllllIIlIIIIIIIIIllllll + 4]);
        final float llllllllllllllIIlIIIIIIIIIllllIl = Float.intBitsToFloat(llllllllllllllIIlIIIIIIIIlIIIlII[llllllllllllllIIlIIIIIIIIIllllll + 4 + 1]);
        final double llllllllllllllIIlIIIIIIIIIllllII = llllllllllllllIIlIIIIIIIIlIIIIlI.getSpriteU16(llllllllllllllIIlIIIIIIIIIlllllI);
        final double llllllllllllllIIlIIIIIIIIIlllIll = llllllllllllllIIlIIIIIIIIlIIIIlI.getSpriteV16(llllllllllllllIIlIIIIIIIIIllllIl);
        llllllllllllllIIlIIIIIIIIlIIIlII[llllllllllllllIIlIIIIIIIIIllllll + 4] = Float.floatToRawIntBits(llllllllllllllIIlIIIIIIIIIllIlll.getInterpolatedU(llllllllllllllIIlIIIIIIIIIllllII));
        llllllllllllllIIlIIIIIIIIlIIIlII[llllllllllllllIIlIIIIIIIIIllllll + 4 + 1] = Float.floatToRawIntBits(llllllllllllllIIlIIIIIIIIIllIlll.getInterpolatedV(llllllllllllllIIlIIIIIIIIIlllIll));
    }
    
    private static void addToTileList(final ConnectedProperties llllllllllllllIIIlllllIlIlIIlIIl, final List llllllllllllllIIIlllllIlIlIIlIII) {
        if (llllllllllllllIIIlllllIlIlIIlIIl.matchTileIcons != null) {
            for (int llllllllllllllIIIlllllIlIlIIllII = 0; llllllllllllllIIIlllllIlIlIIllII < llllllllllllllIIIlllllIlIlIIlIIl.matchTileIcons.length; ++llllllllllllllIIIlllllIlIlIIllII) {
                final TextureAtlasSprite llllllllllllllIIIlllllIlIlIIlIll = llllllllllllllIIIlllllIlIlIIlIIl.matchTileIcons[llllllllllllllIIIlllllIlIlIIllII];
                if (!(llllllllllllllIIIlllllIlIlIIlIll instanceof TextureAtlasSprite)) {
                    Config.warn(String.valueOf(new StringBuilder("TextureAtlasSprite is not TextureAtlasSprite: ").append(llllllllllllllIIIlllllIlIlIIlIll).append(", name: ").append(llllllllllllllIIIlllllIlIlIIlIll.getIconName())));
                }
                else {
                    final int llllllllllllllIIIlllllIlIlIIlIlI = llllllllllllllIIIlllllIlIlIIlIll.getIndexInMap();
                    if (llllllllllllllIIIlllllIlIlIIlIlI < 0) {
                        Config.warn(String.valueOf(new StringBuilder("Invalid tile ID: ").append(llllllllllllllIIIlllllIlIlIIlIlI).append(", icon: ").append(llllllllllllllIIIlllllIlIlIIlIll.getIconName())));
                    }
                    else {
                        addToList(llllllllllllllIIIlllllIlIlIIlIIl, llllllllllllllIIIlllllIlIlIIlIII, llllllllllllllIIIlllllIlIlIIlIlI);
                    }
                }
            }
        }
    }
    
    private static boolean isNeighbour(final ConnectedProperties llllllllllllllIIIllllllIlIIIllIl, final IBlockAccess llllllllllllllIIIllllllIlIIIllII, final IBlockState llllllllllllllIIIllllllIlIIIlIll, final BlockPos llllllllllllllIIIllllllIlIIIlIlI, final int llllllllllllllIIIllllllIlIIIlIIl, final TextureAtlasSprite llllllllllllllIIIllllllIlIIIlIII, final int llllllllllllllIIIllllllIlIIlIIII) {
        final IBlockState llllllllllllllIIIllllllIlIIIllll = llllllllllllllIIIllllllIlIIIllII.getBlockState(llllllllllllllIIIllllllIlIIIlIlI);
        if (llllllllllllllIIIllllllIlIIIlIll == llllllllllllllIIIllllllIlIIIllll) {
            return true;
        }
        if (llllllllllllllIIIllllllIlIIIllIl.connect != 2) {
            return llllllllllllllIIIllllllIlIIIllIl.connect == 3 && llllllllllllllIIIllllllIlIIIllll != null && llllllllllllllIIIllllllIlIIIllll != ConnectedTextures.AIR_DEFAULT_STATE && llllllllllllllIIIllllllIlIIIllll.getBlock().getMaterial() == llllllllllllllIIIllllllIlIIIlIll.getBlock().getMaterial();
        }
        if (llllllllllllllIIIllllllIlIIIllll == null) {
            return false;
        }
        if (llllllllllllllIIIllllllIlIIIllll == ConnectedTextures.AIR_DEFAULT_STATE) {
            return false;
        }
        final TextureAtlasSprite llllllllllllllIIIllllllIlIIIlllI = getNeighbourIcon(llllllllllllllIIIllllllIlIIIllII, llllllllllllllIIIllllllIlIIIlIlI, llllllllllllllIIIllllllIlIIIllll, llllllllllllllIIIllllllIlIIIlIIl);
        return llllllllllllllIIIllllllIlIIIlllI == llllllllllllllIIIllllllIlIIIlIII;
    }
    
    private static void addToBlockList(final ConnectedProperties llllllllllllllIIIlllllIlIIllllII, final List llllllllllllllIIIlllllIlIIlllIll) {
        if (llllllllllllllIIIlllllIlIIllllII.matchBlocks != null) {
            for (int llllllllllllllIIIlllllIlIIlllllI = 0; llllllllllllllIIIlllllIlIIlllllI < llllllllllllllIIIlllllIlIIllllII.matchBlocks.length; ++llllllllllllllIIIlllllIlIIlllllI) {
                final int llllllllllllllIIIlllllIlIIllllIl = llllllllllllllIIIlllllIlIIllllII.matchBlocks[llllllllllllllIIIlllllIlIIlllllI].getBlockId();
                if (llllllllllllllIIIlllllIlIIllllIl < 0) {
                    Config.warn(String.valueOf(new StringBuilder("Invalid block ID: ").append(llllllllllllllIIIlllllIlIIllllIl)));
                }
                else {
                    addToList(llllllllllllllIIIlllllIlIIllllII, llllllllllllllIIIlllllIlIIlllIll, llllllllllllllIIIlllllIlIIllllIl);
                }
            }
        }
    }
    
    private static String[] getDefaultCtmPaths() {
        final ArrayList llllllllllllllIIIlllllIlIIlIIlll = new ArrayList();
        final String llllllllllllllIIIlllllIlIIlIIllI = "mcpatcher/ctm/default/";
        if (Config.isFromDefaultResourcePack(new ResourceLocation("textures/blocks/glass.png"))) {
            llllllllllllllIIIlllllIlIIlIIlll.add(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIlllllIlIIlIIllI)).append("glass.properties")));
            llllllllllllllIIIlllllIlIIlIIlll.add(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIlllllIlIIlIIllI)).append("glasspane.properties")));
        }
        if (Config.isFromDefaultResourcePack(new ResourceLocation("textures/blocks/bookshelf.png"))) {
            llllllllllllllIIIlllllIlIIlIIlll.add(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIlllllIlIIlIIllI)).append("bookshelf.properties")));
        }
        if (Config.isFromDefaultResourcePack(new ResourceLocation("textures/blocks/sandstone_normal.png"))) {
            llllllllllllllIIIlllllIlIIlIIlll.add(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIlllllIlIIlIIllI)).append("sandstone.properties")));
        }
        final String[] llllllllllllllIIIlllllIlIIlIIlIl = { "white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "silver", "cyan", "purple", "blue", "brown", "green", "red", "black" };
        for (int llllllllllllllIIIlllllIlIIlIIlII = 0; llllllllllllllIIIlllllIlIIlIIlII < llllllllllllllIIIlllllIlIIlIIlIl.length; ++llllllllllllllIIIlllllIlIIlIIlII) {
            final String llllllllllllllIIIlllllIlIIlIIIll = llllllllllllllIIIlllllIlIIlIIlIl[llllllllllllllIIIlllllIlIIlIIlII];
            if (Config.isFromDefaultResourcePack(new ResourceLocation(String.valueOf(new StringBuilder("textures/blocks/glass_").append(llllllllllllllIIIlllllIlIIlIIIll).append(".png"))))) {
                llllllllllllllIIIlllllIlIIlIIlll.add(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIlllllIlIIlIIllI)).append(llllllllllllllIIIlllllIlIIlIIlII).append("_glass_").append(llllllllllllllIIIlllllIlIIlIIIll).append("/glass_").append(llllllllllllllIIIlllllIlIIlIIIll).append(".properties")));
                llllllllllllllIIIlllllIlIIlIIlll.add(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIlllllIlIIlIIllI)).append(llllllllllllllIIIlllllIlIIlIIlII).append("_glass_").append(llllllllllllllIIIlllllIlIIlIIIll).append("/glass_pane_").append(llllllllllllllIIIlllllIlIIlIIIll).append(".properties")));
            }
        }
        final String[] llllllllllllllIIIlllllIlIIlIIIlI = llllllllllllllIIIlllllIlIIlIIlll.toArray(new String[llllllllllllllIIIlllllIlIIlIIlll.size()]);
        return llllllllllllllIIIlllllIlIIlIIIlI;
    }
    
    private static EnumFacing getFacing(final int llllllllllllllIIIllllllllIIIllIl) {
        switch (llllllllllllllIIIllllllllIIIllIl) {
            case 0: {
                return EnumFacing.DOWN;
            }
            case 1: {
                return EnumFacing.UP;
            }
            case 2: {
                return EnumFacing.NORTH;
            }
            case 3: {
                return EnumFacing.SOUTH;
            }
            case 4: {
                return EnumFacing.WEST;
            }
            case 5: {
                return EnumFacing.EAST;
            }
            default: {
                return EnumFacing.UP;
            }
        }
    }
    
    public static synchronized BakedQuad getConnectedTexture(final IBlockAccess llllllllllllllIIlIIIIIIIlIIIIIlI, final IBlockState llllllllllllllIIlIIIIIIIIlllIlll, final BlockPos llllllllllllllIIlIIIIIIIIlllIllI, final BakedQuad llllllllllllllIIlIIIIIIIIlllIlIl, final RenderEnv llllllllllllllIIlIIIIIIIIllllllI) {
        final TextureAtlasSprite llllllllllllllIIlIIIIIIIIlllllIl = llllllllllllllIIlIIIIIIIIlllIlIl.getSprite();
        if (llllllllllllllIIlIIIIIIIIlllllIl == null) {
            return llllllllllllllIIlIIIIIIIIlllIlIl;
        }
        final Block llllllllllllllIIlIIIIIIIIlllllII = llllllllllllllIIlIIIIIIIIlllIlll.getBlock();
        final EnumFacing llllllllllllllIIlIIIIIIIIllllIll = llllllllllllllIIlIIIIIIIIlllIlIl.getFace();
        if (llllllllllllllIIlIIIIIIIIlllllII instanceof BlockPane && llllllllllllllIIlIIIIIIIIlllllIl.getIconName().startsWith("minecraft:blocks/glass_pane_top")) {
            final IBlockState llllllllllllllIIlIIIIIIIIllllIlI = llllllllllllllIIlIIIIIIIlIIIIIlI.getBlockState(llllllllllllllIIlIIIIIIIIlllIllI.offset(llllllllllllllIIlIIIIIIIIlllIlIl.getFace()));
            if (llllllllllllllIIlIIIIIIIIllllIlI == llllllllllllllIIlIIIIIIIIlllIlll) {
                return getQuad(ConnectedTextures.emptySprite, llllllllllllllIIlIIIIIIIIlllllII, llllllllllllllIIlIIIIIIIIlllIlll, llllllllllllllIIlIIIIIIIIlllIlIl);
            }
        }
        final TextureAtlasSprite llllllllllllllIIlIIIIIIIIllllIIl = getConnectedTextureMultiPass(llllllllllllllIIlIIIIIIIlIIIIIlI, llllllllllllllIIlIIIIIIIIlllIlll, llllllllllllllIIlIIIIIIIIlllIllI, llllllllllllllIIlIIIIIIIIllllIll, llllllllllllllIIlIIIIIIIIlllllIl, llllllllllllllIIlIIIIIIIIllllllI);
        return (llllllllllllllIIlIIIIIIIIllllIIl == llllllllllllllIIlIIIIIIIIlllllIl) ? llllllllllllllIIlIIIIIIIIlllIlIl : getQuad(llllllllllllllIIlIIIIIIIIllllIIl, llllllllllllllIIlIIIIIIIIlllllII, llllllllllllllIIlIIIIIIIIlllIlll, llllllllllllllIIlIIIIIIIIlllIlIl);
    }
    
    private static TextureAtlasSprite getConnectedTextureVertical(final ConnectedProperties llllllllllllllIIIllllllIIIlIIlII, final IBlockAccess llllllllllllllIIIllllllIIIllIIlI, final IBlockState llllllllllllllIIIllllllIIIllIIIl, final BlockPos llllllllllllllIIIllllllIIIllIIII, final int llllllllllllllIIIllllllIIIlIllll, final int llllllllllllllIIIllllllIIIIlllll, final TextureAtlasSprite llllllllllllllIIIllllllIIIIllllI, final int llllllllllllllIIIllllllIIIlIllII) {
        boolean llllllllllllllIIIllllllIIIlIlIll = false;
        boolean llllllllllllllIIIllllllIIIlIlIlI = false;
        switch (llllllllllllllIIIllllllIIIlIllll) {
            case 0: {
                if (llllllllllllllIIIllllllIIIIlllll == 1 || llllllllllllllIIIllllllIIIIlllll == 0) {
                    return null;
                }
                llllllllllllllIIIllllllIIIlIlIll = isNeighbour(llllllllllllllIIIllllllIIIlIIlII, llllllllllllllIIIllllllIIIllIIlI, llllllllllllllIIIllllllIIIllIIIl, llllllllllllllIIIllllllIIIllIIII.offsetDown(), llllllllllllllIIIllllllIIIIlllll, llllllllllllllIIIllllllIIIIllllI, llllllllllllllIIIllllllIIIlIllII);
                llllllllllllllIIIllllllIIIlIlIlI = isNeighbour(llllllllllllllIIIllllllIIIlIIlII, llllllllllllllIIIllllllIIIllIIlI, llllllllllllllIIIllllllIIIllIIIl, llllllllllllllIIIllllllIIIllIIII.offsetUp(), llllllllllllllIIIllllllIIIIlllll, llllllllllllllIIIllllllIIIIllllI, llllllllllllllIIIllllllIIIlIllII);
                break;
            }
            case 1: {
                if (llllllllllllllIIIllllllIIIIlllll == 3 || llllllllllllllIIIllllllIIIIlllll == 2) {
                    return null;
                }
                llllllllllllllIIIllllllIIIlIlIll = isNeighbour(llllllllllllllIIIllllllIIIlIIlII, llllllllllllllIIIllllllIIIllIIlI, llllllllllllllIIIllllllIIIllIIIl, llllllllllllllIIIllllllIIIllIIII.offsetSouth(), llllllllllllllIIIllllllIIIIlllll, llllllllllllllIIIllllllIIIIllllI, llllllllllllllIIIllllllIIIlIllII);
                llllllllllllllIIIllllllIIIlIlIlI = isNeighbour(llllllllllllllIIIllllllIIIlIIlII, llllllllllllllIIIllllllIIIllIIlI, llllllllllllllIIIllllllIIIllIIIl, llllllllllllllIIIllllllIIIllIIII.offsetNorth(), llllllllllllllIIIllllllIIIIlllll, llllllllllllllIIIllllllIIIIllllI, llllllllllllllIIIllllllIIIlIllII);
                break;
            }
            case 2: {
                if (llllllllllllllIIIllllllIIIIlllll == 5 || llllllllllllllIIIllllllIIIIlllll == 4) {
                    return null;
                }
                llllllllllllllIIIllllllIIIlIlIll = isNeighbour(llllllllllllllIIIllllllIIIlIIlII, llllllllllllllIIIllllllIIIllIIlI, llllllllllllllIIIllllllIIIllIIIl, llllllllllllllIIIllllllIIIllIIII.offsetWest(), llllllllllllllIIIllllllIIIIlllll, llllllllllllllIIIllllllIIIIllllI, llllllllllllllIIIllllllIIIlIllII);
                llllllllllllllIIIllllllIIIlIlIlI = isNeighbour(llllllllllllllIIIllllllIIIlIIlII, llllllllllllllIIIllllllIIIllIIlI, llllllllllllllIIIllllllIIIllIIIl, llllllllllllllIIIllllllIIIllIIII.offsetEast(), llllllllllllllIIIllllllIIIIlllll, llllllllllllllIIIllllllIIIIllllI, llllllllllllllIIIllllllIIIlIllII);
                break;
            }
        }
        final boolean llllllllllllllIIIllllllIIIlIlIIl = true;
        byte llllllllllllllIIIllllllIIIlIIlIl = 0;
        if (llllllllllllllIIIllllllIIIlIlIll) {
            if (llllllllllllllIIIllllllIIIlIlIlI) {
                final byte llllllllllllllIIIllllllIIIlIlIII = 1;
            }
            else {
                final byte llllllllllllllIIIllllllIIIlIIlll = 2;
            }
        }
        else if (llllllllllllllIIIllllllIIIlIlIlI) {
            final byte llllllllllllllIIIllllllIIIlIIllI = 0;
        }
        else {
            llllllllllllllIIIllllllIIIlIIlIl = 3;
        }
        return llllllllllllllIIIllllllIIIlIIlII.tileIcons[llllllllllllllIIIllllllIIIlIIlIl];
    }
    
    private static TextureAtlasSprite getConnectedTextureCtm(final ConnectedProperties llllllllllllllIIIllllllIlIlIlIII, final IBlockAccess llllllllllllllIIIllllllIlIlIIlll, final IBlockState llllllllllllllIIIllllllIlIlIIllI, final BlockPos llllllllllllllIIIllllllIlIlIIlIl, final int llllllllllllllIIIllllllIlIlIllll, final int llllllllllllllIIIllllllIlIlIlllI, final TextureAtlasSprite llllllllllllllIIIllllllIlIlIllIl, final int llllllllllllllIIIllllllIlIlIIIlI, final RenderEnv llllllllllllllIIIllllllIlIlIlIll) {
        final boolean[] llllllllllllllIIIllllllIlIlIlIlI = llllllllllllllIIIllllllIlIlIlIll.getBorderFlags();
        switch (llllllllllllllIIIllllllIlIlIlllI) {
            case 0: {
                llllllllllllllIIIllllllIlIlIlIlI[0] = isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetWest(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                llllllllllllllIIIllllllIlIlIlIlI[1] = isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetEast(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                llllllllllllllIIIllllllIlIlIlIlI[2] = isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetNorth(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                llllllllllllllIIIllllllIlIlIlIlI[3] = isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetSouth(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                break;
            }
            case 1: {
                llllllllllllllIIIllllllIlIlIlIlI[0] = isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetWest(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                llllllllllllllIIIllllllIlIlIlIlI[1] = isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetEast(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                llllllllllllllIIIllllllIlIlIlIlI[2] = isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetSouth(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                llllllllllllllIIIllllllIlIlIlIlI[3] = isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetNorth(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                break;
            }
            case 2: {
                llllllllllllllIIIllllllIlIlIlIlI[0] = isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetEast(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                llllllllllllllIIIllllllIlIlIlIlI[1] = isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetWest(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                llllllllllllllIIIllllllIlIlIlIlI[2] = isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetDown(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                llllllllllllllIIIllllllIlIlIlIlI[3] = isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetUp(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                break;
            }
            case 3: {
                llllllllllllllIIIllllllIlIlIlIlI[0] = isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetWest(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                llllllllllllllIIIllllllIlIlIlIlI[1] = isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetEast(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                llllllllllllllIIIllllllIlIlIlIlI[2] = isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetDown(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                llllllllllllllIIIllllllIlIlIlIlI[3] = isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetUp(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                break;
            }
            case 4: {
                llllllllllllllIIIllllllIlIlIlIlI[0] = isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetNorth(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                llllllllllllllIIIllllllIlIlIlIlI[1] = isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetSouth(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                llllllllllllllIIIllllllIlIlIlIlI[2] = isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetDown(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                llllllllllllllIIIllllllIlIlIlIlI[3] = isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetUp(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                break;
            }
            case 5: {
                llllllllllllllIIIllllllIlIlIlIlI[0] = isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetSouth(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                llllllllllllllIIIllllllIlIlIlIlI[1] = isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetNorth(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                llllllllllllllIIIllllllIlIlIlIlI[2] = isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetDown(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                llllllllllllllIIIllllllIlIlIlIlI[3] = isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetUp(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                break;
            }
        }
        byte llllllllllllllIIIllllllIlIlIlIIl = 0;
        if (llllllllllllllIIIllllllIlIlIlIlI[0] & !llllllllllllllIIIllllllIlIlIlIlI[1] & !llllllllllllllIIIllllllIlIlIlIlI[2] & !llllllllllllllIIIllllllIlIlIlIlI[3]) {
            llllllllllllllIIIllllllIlIlIlIIl = 3;
        }
        else if (!llllllllllllllIIIllllllIlIlIlIlI[0] & llllllllllllllIIIllllllIlIlIlIlI[1] & !llllllllllllllIIIllllllIlIlIlIlI[2] & !llllllllllllllIIIllllllIlIlIlIlI[3]) {
            llllllllllllllIIIllllllIlIlIlIIl = 1;
        }
        else if (!llllllllllllllIIIllllllIlIlIlIlI[0] & !llllllllllllllIIIllllllIlIlIlIlI[1] & llllllllllllllIIIllllllIlIlIlIlI[2] & !llllllllllllllIIIllllllIlIlIlIlI[3]) {
            llllllllllllllIIIllllllIlIlIlIIl = 12;
        }
        else if (!llllllllllllllIIIllllllIlIlIlIlI[0] & !llllllllllllllIIIllllllIlIlIlIlI[1] & !llllllllllllllIIIllllllIlIlIlIlI[2] & llllllllllllllIIIllllllIlIlIlIlI[3]) {
            llllllllllllllIIIllllllIlIlIlIIl = 36;
        }
        else if (llllllllllllllIIIllllllIlIlIlIlI[0] & llllllllllllllIIIllllllIlIlIlIlI[1] & !llllllllllllllIIIllllllIlIlIlIlI[2] & !llllllllllllllIIIllllllIlIlIlIlI[3]) {
            llllllllllllllIIIllllllIlIlIlIIl = 2;
        }
        else if (!llllllllllllllIIIllllllIlIlIlIlI[0] & !llllllllllllllIIIllllllIlIlIlIlI[1] & llllllllllllllIIIllllllIlIlIlIlI[2] & llllllllllllllIIIllllllIlIlIlIlI[3]) {
            llllllllllllllIIIllllllIlIlIlIIl = 24;
        }
        else if (llllllllllllllIIIllllllIlIlIlIlI[0] & !llllllllllllllIIIllllllIlIlIlIlI[1] & llllllllllllllIIIllllllIlIlIlIlI[2] & !llllllllllllllIIIllllllIlIlIlIlI[3]) {
            llllllllllllllIIIllllllIlIlIlIIl = 15;
        }
        else if (llllllllllllllIIIllllllIlIlIlIlI[0] & !llllllllllllllIIIllllllIlIlIlIlI[1] & !llllllllllllllIIIllllllIlIlIlIlI[2] & llllllllllllllIIIllllllIlIlIlIlI[3]) {
            llllllllllllllIIIllllllIlIlIlIIl = 39;
        }
        else if (!llllllllllllllIIIllllllIlIlIlIlI[0] & llllllllllllllIIIllllllIlIlIlIlI[1] & llllllllllllllIIIllllllIlIlIlIlI[2] & !llllllllllllllIIIllllllIlIlIlIlI[3]) {
            llllllllllllllIIIllllllIlIlIlIIl = 13;
        }
        else if (!llllllllllllllIIIllllllIlIlIlIlI[0] & llllllllllllllIIIllllllIlIlIlIlI[1] & !llllllllllllllIIIllllllIlIlIlIlI[2] & llllllllllllllIIIllllllIlIlIlIlI[3]) {
            llllllllllllllIIIllllllIlIlIlIIl = 37;
        }
        else if (!llllllllllllllIIIllllllIlIlIlIlI[0] & llllllllllllllIIIllllllIlIlIlIlI[1] & llllllllllllllIIIllllllIlIlIlIlI[2] & llllllllllllllIIIllllllIlIlIlIlI[3]) {
            llllllllllllllIIIllllllIlIlIlIIl = 25;
        }
        else if (llllllllllllllIIIllllllIlIlIlIlI[0] & !llllllllllllllIIIllllllIlIlIlIlI[1] & llllllllllllllIIIllllllIlIlIlIlI[2] & llllllllllllllIIIllllllIlIlIlIlI[3]) {
            llllllllllllllIIIllllllIlIlIlIIl = 27;
        }
        else if (llllllllllllllIIIllllllIlIlIlIlI[0] & llllllllllllllIIIllllllIlIlIlIlI[1] & !llllllllllllllIIIllllllIlIlIlIlI[2] & llllllllllllllIIIllllllIlIlIlIlI[3]) {
            llllllllllllllIIIllllllIlIlIlIIl = 38;
        }
        else if (llllllllllllllIIIllllllIlIlIlIlI[0] & llllllllllllllIIIllllllIlIlIlIlI[1] & llllllllllllllIIIllllllIlIlIlIlI[2] & !llllllllllllllIIIllllllIlIlIlIlI[3]) {
            llllllllllllllIIIllllllIlIlIlIIl = 14;
        }
        else if (llllllllllllllIIIllllllIlIlIlIlI[0] & llllllllllllllIIIllllllIlIlIlIlI[1] & llllllllllllllIIIllllllIlIlIlIlI[2] & llllllllllllllIIIllllllIlIlIlIlI[3]) {
            llllllllllllllIIIllllllIlIlIlIIl = 26;
        }
        if (llllllllllllllIIIllllllIlIlIlIIl == 0) {
            return llllllllllllllIIIllllllIlIlIlIII.tileIcons[llllllllllllllIIIllllllIlIlIlIIl];
        }
        if (!Config.isConnectedTexturesFancy()) {
            return llllllllllllllIIIllllllIlIlIlIII.tileIcons[llllllllllllllIIIllllllIlIlIlIIl];
        }
        switch (llllllllllllllIIIllllllIlIlIlllI) {
            case 0: {
                llllllllllllllIIIllllllIlIlIlIlI[0] = !isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetEast().offsetNorth(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                llllllllllllllIIIllllllIlIlIlIlI[1] = !isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetWest().offsetNorth(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                llllllllllllllIIIllllllIlIlIlIlI[2] = !isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetEast().offsetSouth(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                llllllllllllllIIIllllllIlIlIlIlI[3] = !isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetWest().offsetSouth(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                break;
            }
            case 1: {
                llllllllllllllIIIllllllIlIlIlIlI[0] = !isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetEast().offsetSouth(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                llllllllllllllIIIllllllIlIlIlIlI[1] = !isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetWest().offsetSouth(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                llllllllllllllIIIllllllIlIlIlIlI[2] = !isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetEast().offsetNorth(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                llllllllllllllIIIllllllIlIlIlIlI[3] = !isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetWest().offsetNorth(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                break;
            }
            case 2: {
                llllllllllllllIIIllllllIlIlIlIlI[0] = !isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetWest().offsetDown(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                llllllllllllllIIIllllllIlIlIlIlI[1] = !isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetEast().offsetDown(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                llllllllllllllIIIllllllIlIlIlIlI[2] = !isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetWest().offsetUp(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                llllllllllllllIIIllllllIlIlIlIlI[3] = !isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetEast().offsetUp(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                break;
            }
            case 3: {
                llllllllllllllIIIllllllIlIlIlIlI[0] = !isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetEast().offsetDown(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                llllllllllllllIIIllllllIlIlIlIlI[1] = !isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetWest().offsetDown(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                llllllllllllllIIIllllllIlIlIlIlI[2] = !isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetEast().offsetUp(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                llllllllllllllIIIllllllIlIlIlIlI[3] = !isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetWest().offsetUp(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                break;
            }
            case 4: {
                llllllllllllllIIIllllllIlIlIlIlI[0] = !isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetDown().offsetSouth(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                llllllllllllllIIIllllllIlIlIlIlI[1] = !isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetDown().offsetNorth(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                llllllllllllllIIIllllllIlIlIlIlI[2] = !isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetUp().offsetSouth(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                llllllllllllllIIIllllllIlIlIlIlI[3] = !isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetUp().offsetNorth(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                break;
            }
            case 5: {
                llllllllllllllIIIllllllIlIlIlIlI[0] = !isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetDown().offsetNorth(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                llllllllllllllIIIllllllIlIlIlIlI[1] = !isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetDown().offsetSouth(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                llllllllllllllIIIllllllIlIlIlIlI[2] = !isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetUp().offsetNorth(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                llllllllllllllIIIllllllIlIlIlIlI[3] = !isNeighbour(llllllllllllllIIIllllllIlIlIlIII, llllllllllllllIIIllllllIlIlIIlll, llllllllllllllIIIllllllIlIlIIllI, llllllllllllllIIIllllllIlIlIIlIl.offsetUp().offsetSouth(), llllllllllllllIIIllllllIlIlIlllI, llllllllllllllIIIllllllIlIlIllIl, llllllllllllllIIIllllllIlIlIIIlI);
                break;
            }
        }
        if (llllllllllllllIIIllllllIlIlIlIIl == 13 && llllllllllllllIIIllllllIlIlIlIlI[0]) {
            llllllllllllllIIIllllllIlIlIlIIl = 4;
        }
        else if (llllllllllllllIIIllllllIlIlIlIIl == 15 && llllllllllllllIIIllllllIlIlIlIlI[1]) {
            llllllllllllllIIIllllllIlIlIlIIl = 5;
        }
        else if (llllllllllllllIIIllllllIlIlIlIIl == 37 && llllllllllllllIIIllllllIlIlIlIlI[2]) {
            llllllllllllllIIIllllllIlIlIlIIl = 16;
        }
        else if (llllllllllllllIIIllllllIlIlIlIIl == 39 && llllllllllllllIIIllllllIlIlIlIlI[3]) {
            llllllllllllllIIIllllllIlIlIlIIl = 17;
        }
        else if (llllllllllllllIIIllllllIlIlIlIIl == 14 && llllllllllllllIIIllllllIlIlIlIlI[0] && llllllllllllllIIIllllllIlIlIlIlI[1]) {
            llllllllllllllIIIllllllIlIlIlIIl = 7;
        }
        else if (llllllllllllllIIIllllllIlIlIlIIl == 25 && llllllllllllllIIIllllllIlIlIlIlI[0] && llllllllllllllIIIllllllIlIlIlIlI[2]) {
            llllllllllllllIIIllllllIlIlIlIIl = 6;
        }
        else if (llllllllllllllIIIllllllIlIlIlIIl == 27 && llllllllllllllIIIllllllIlIlIlIlI[3] && llllllllllllllIIIllllllIlIlIlIlI[1]) {
            llllllllllllllIIIllllllIlIlIlIIl = 19;
        }
        else if (llllllllllllllIIIllllllIlIlIlIIl == 38 && llllllllllllllIIIllllllIlIlIlIlI[3] && llllllllllllllIIIllllllIlIlIlIlI[2]) {
            llllllllllllllIIIllllllIlIlIlIIl = 18;
        }
        else if (llllllllllllllIIIllllllIlIlIlIIl == 14 && !llllllllllllllIIIllllllIlIlIlIlI[0] && llllllllllllllIIIllllllIlIlIlIlI[1]) {
            llllllllllllllIIIllllllIlIlIlIIl = 31;
        }
        else if (llllllllllllllIIIllllllIlIlIlIIl == 25 && llllllllllllllIIIllllllIlIlIlIlI[0] && !llllllllllllllIIIllllllIlIlIlIlI[2]) {
            llllllllllllllIIIllllllIlIlIlIIl = 30;
        }
        else if (llllllllllllllIIIllllllIlIlIlIIl == 27 && !llllllllllllllIIIllllllIlIlIlIlI[3] && llllllllllllllIIIllllllIlIlIlIlI[1]) {
            llllllllllllllIIIllllllIlIlIlIIl = 41;
        }
        else if (llllllllllllllIIIllllllIlIlIlIIl == 38 && llllllllllllllIIIllllllIlIlIlIlI[3] && !llllllllllllllIIIllllllIlIlIlIlI[2]) {
            llllllllllllllIIIllllllIlIlIlIIl = 40;
        }
        else if (llllllllllllllIIIllllllIlIlIlIIl == 14 && llllllllllllllIIIllllllIlIlIlIlI[0] && !llllllllllllllIIIllllllIlIlIlIlI[1]) {
            llllllllllllllIIIllllllIlIlIlIIl = 29;
        }
        else if (llllllllllllllIIIllllllIlIlIlIIl == 25 && !llllllllllllllIIIllllllIlIlIlIlI[0] && llllllllllllllIIIllllllIlIlIlIlI[2]) {
            llllllllllllllIIIllllllIlIlIlIIl = 28;
        }
        else if (llllllllllllllIIIllllllIlIlIlIIl == 27 && llllllllllllllIIIllllllIlIlIlIlI[3] && !llllllllllllllIIIllllllIlIlIlIlI[1]) {
            llllllllllllllIIIllllllIlIlIlIIl = 43;
        }
        else if (llllllllllllllIIIllllllIlIlIlIIl == 38 && !llllllllllllllIIIllllllIlIlIlIlI[3] && llllllllllllllIIIllllllIlIlIlIlI[2]) {
            llllllllllllllIIIllllllIlIlIlIIl = 42;
        }
        else if (llllllllllllllIIIllllllIlIlIlIIl == 26 && llllllllllllllIIIllllllIlIlIlIlI[0] && llllllllllllllIIIllllllIlIlIlIlI[1] && llllllllllllllIIIllllllIlIlIlIlI[2] && llllllllllllllIIIllllllIlIlIlIlI[3]) {
            llllllllllllllIIIllllllIlIlIlIIl = 46;
        }
        else if (llllllllllllllIIIllllllIlIlIlIIl == 26 && !llllllllllllllIIIllllllIlIlIlIlI[0] && llllllllllllllIIIllllllIlIlIlIlI[1] && llllllllllllllIIIllllllIlIlIlIlI[2] && llllllllllllllIIIllllllIlIlIlIlI[3]) {
            llllllllllllllIIIllllllIlIlIlIIl = 9;
        }
        else if (llllllllllllllIIIllllllIlIlIlIIl == 26 && llllllllllllllIIIllllllIlIlIlIlI[0] && !llllllllllllllIIIllllllIlIlIlIlI[1] && llllllllllllllIIIllllllIlIlIlIlI[2] && llllllllllllllIIIllllllIlIlIlIlI[3]) {
            llllllllllllllIIIllllllIlIlIlIIl = 21;
        }
        else if (llllllllllllllIIIllllllIlIlIlIIl == 26 && llllllllllllllIIIllllllIlIlIlIlI[0] && llllllllllllllIIIllllllIlIlIlIlI[1] && !llllllllllllllIIIllllllIlIlIlIlI[2] && llllllllllllllIIIllllllIlIlIlIlI[3]) {
            llllllllllllllIIIllllllIlIlIlIIl = 8;
        }
        else if (llllllllllllllIIIllllllIlIlIlIIl == 26 && llllllllllllllIIIllllllIlIlIlIlI[0] && llllllllllllllIIIllllllIlIlIlIlI[1] && llllllllllllllIIIllllllIlIlIlIlI[2] && !llllllllllllllIIIllllllIlIlIlIlI[3]) {
            llllllllllllllIIIllllllIlIlIlIIl = 20;
        }
        else if (llllllllllllllIIIllllllIlIlIlIIl == 26 && llllllllllllllIIIllllllIlIlIlIlI[0] && llllllllllllllIIIllllllIlIlIlIlI[1] && !llllllllllllllIIIllllllIlIlIlIlI[2] && !llllllllllllllIIIllllllIlIlIlIlI[3]) {
            llllllllllllllIIIllllllIlIlIlIIl = 11;
        }
        else if (llllllllllllllIIIllllllIlIlIlIIl == 26 && !llllllllllllllIIIllllllIlIlIlIlI[0] && !llllllllllllllIIIllllllIlIlIlIlI[1] && llllllllllllllIIIllllllIlIlIlIlI[2] && llllllllllllllIIIllllllIlIlIlIlI[3]) {
            llllllllllllllIIIllllllIlIlIlIIl = 22;
        }
        else if (llllllllllllllIIIllllllIlIlIlIIl == 26 && !llllllllllllllIIIllllllIlIlIlIlI[0] && llllllllllllllIIIllllllIlIlIlIlI[1] && !llllllllllllllIIIllllllIlIlIlIlI[2] && llllllllllllllIIIllllllIlIlIlIlI[3]) {
            llllllllllllllIIIllllllIlIlIlIIl = 23;
        }
        else if (llllllllllllllIIIllllllIlIlIlIIl == 26 && llllllllllllllIIIllllllIlIlIlIlI[0] && !llllllllllllllIIIllllllIlIlIlIlI[1] && llllllllllllllIIIllllllIlIlIlIlI[2] && !llllllllllllllIIIllllllIlIlIlIlI[3]) {
            llllllllllllllIIIllllllIlIlIlIIl = 10;
        }
        else if (llllllllllllllIIIllllllIlIlIlIIl == 26 && llllllllllllllIIIllllllIlIlIlIlI[0] && !llllllllllllllIIIllllllIlIlIlIlI[1] && !llllllllllllllIIIllllllIlIlIlIlI[2] && llllllllllllllIIIllllllIlIlIlIlI[3]) {
            llllllllllllllIIIllllllIlIlIlIIl = 34;
        }
        else if (llllllllllllllIIIllllllIlIlIlIIl == 26 && !llllllllllllllIIIllllllIlIlIlIlI[0] && llllllllllllllIIIllllllIlIlIlIlI[1] && llllllllllllllIIIllllllIlIlIlIlI[2] && !llllllllllllllIIIllllllIlIlIlIlI[3]) {
            llllllllllllllIIIllllllIlIlIlIIl = 35;
        }
        else if (llllllllllllllIIIllllllIlIlIlIIl == 26 && llllllllllllllIIIllllllIlIlIlIlI[0] && !llllllllllllllIIIllllllIlIlIlIlI[1] && !llllllllllllllIIIllllllIlIlIlIlI[2] && !llllllllllllllIIIllllllIlIlIlIlI[3]) {
            llllllllllllllIIIllllllIlIlIlIIl = 32;
        }
        else if (llllllllllllllIIIllllllIlIlIlIIl == 26 && !llllllllllllllIIIllllllIlIlIlIlI[0] && llllllllllllllIIIllllllIlIlIlIlI[1] && !llllllllllllllIIIllllllIlIlIlIlI[2] && !llllllllllllllIIIllllllIlIlIlIlI[3]) {
            llllllllllllllIIIllllllIlIlIlIIl = 33;
        }
        else if (llllllllllllllIIIllllllIlIlIlIIl == 26 && !llllllllllllllIIIllllllIlIlIlIlI[0] && !llllllllllllllIIIllllllIlIlIlIlI[1] && llllllllllllllIIIllllllIlIlIlIlI[2] && !llllllllllllllIIIllllllIlIlIlIlI[3]) {
            llllllllllllllIIIllllllIlIlIlIIl = 44;
        }
        else if (llllllllllllllIIIllllllIlIlIlIIl == 26 && !llllllllllllllIIIllllllIlIlIlIlI[0] && !llllllllllllllIIIllllllIlIlIlIlI[1] && !llllllllllllllIIIllllllIlIlIlIlI[2] && llllllllllllllIIIllllllIlIlIlIlI[3]) {
            llllllllllllllIIIllllllIlIlIlIIl = 45;
        }
        return llllllllllllllIIIllllllIlIlIlIII.tileIcons[llllllllllllllIIIllllllIlIlIlIIl];
    }
    
    static {
        X_NEG_WEST = 4;
        Z_NEG_NORTH = 2;
        Y_NEG_DOWN = 0;
        X_POS_EAST = 5;
        Z_AXIS = 1;
        Y_POS_UP = 1;
        X_AXIS = 2;
        Z_POS_SOUTH = 3;
        Y_AXIS = 0;
        ConnectedTextures.spriteQuadMaps = null;
        ConnectedTextures.blockProperties = null;
        ConnectedTextures.tileProperties = null;
        ConnectedTextures.multipass = false;
        propSuffixes = new String[] { "", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
        ctmIndexes = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 0, 0, 0, 0, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 0, 0, 0, 0, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 0, 0, 0, 0, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 0, 0, 0, 0, 0 };
        AIR_DEFAULT_STATE = Blocks.air.getDefaultState();
        ConnectedTextures.emptySprite = null;
    }
    
    public static void updateIcons(final TextureMap llllllllllllllIIIlllllIllIlIIIlI, final IResourcePack llllllllllllllIIIlllllIllIlIIIIl) {
        final String[] llllllllllllllIIIlllllIllIlIIIII = ResUtils.collectFiles(llllllllllllllIIIlllllIllIlIIIIl, "mcpatcher/ctm/", ".properties", getDefaultCtmPaths());
        Arrays.sort(llllllllllllllIIIlllllIllIlIIIII);
        final List llllllllllllllIIIlllllIllIIlllll = makePropertyList(ConnectedTextures.tileProperties);
        final List llllllllllllllIIIlllllIllIIllllI = makePropertyList(ConnectedTextures.blockProperties);
        for (int llllllllllllllIIIlllllIllIIlllIl = 0; llllllllllllllIIIlllllIllIIlllIl < llllllllllllllIIIlllllIllIlIIIII.length; ++llllllllllllllIIIlllllIllIIlllIl) {
            final String llllllllllllllIIIlllllIllIIlllII = llllllllllllllIIIlllllIllIlIIIII[llllllllllllllIIIlllllIllIIlllIl];
            Config.dbg(String.valueOf(new StringBuilder("ConnectedTextures: ").append(llllllllllllllIIIlllllIllIIlllII)));
            try {
                final ResourceLocation llllllllllllllIIIlllllIllIIllIll = new ResourceLocation(llllllllllllllIIIlllllIllIIlllII);
                final InputStream llllllllllllllIIIlllllIllIIllIlI = llllllllllllllIIIlllllIllIlIIIIl.getInputStream(llllllllllllllIIIlllllIllIIllIll);
                if (llllllllllllllIIIlllllIllIIllIlI == null) {
                    Config.warn(String.valueOf(new StringBuilder("ConnectedTextures file not found: ").append(llllllllllllllIIIlllllIllIIlllII)));
                }
                else {
                    final Properties llllllllllllllIIIlllllIllIIllIIl = new Properties();
                    llllllllllllllIIIlllllIllIIllIIl.load(llllllllllllllIIIlllllIllIIllIlI);
                    final ConnectedProperties llllllllllllllIIIlllllIllIIllIII = new ConnectedProperties(llllllllllllllIIIlllllIllIIllIIl, llllllllllllllIIIlllllIllIIlllII);
                    if (llllllllllllllIIIlllllIllIIllIII.isValid(llllllllllllllIIIlllllIllIIlllII)) {
                        llllllllllllllIIIlllllIllIIllIII.updateIcons(llllllllllllllIIIlllllIllIlIIIlI);
                        addToTileList(llllllllllllllIIIlllllIllIIllIII, llllllllllllllIIIlllllIllIIlllll);
                        addToBlockList(llllllllllllllIIIlllllIllIIllIII, llllllllllllllIIIlllllIllIIllllI);
                    }
                }
            }
            catch (FileNotFoundException llllllllllllllIIIlllllIllIIlIlll) {
                Config.warn(String.valueOf(new StringBuilder("ConnectedTextures file not found: ").append(llllllllllllllIIIlllllIllIIlllII)));
            }
            catch (Exception llllllllllllllIIIlllllIllIIlIllI) {
                llllllllllllllIIIlllllIllIIlIllI.printStackTrace();
            }
        }
        ConnectedTextures.blockProperties = propertyListToArray(llllllllllllllIIIlllllIllIIllllI);
        ConnectedTextures.tileProperties = propertyListToArray(llllllllllllllIIIlllllIllIIlllll);
        ConnectedTextures.multipass = detectMultipass();
        Config.dbg(String.valueOf(new StringBuilder("Multipass connected textures: ").append(ConnectedTextures.multipass)));
    }
    
    private static void updateIconEmpty(final TextureMap llllllllllllllIIIlllllIllIlIlllI) {
    }
    
    private static TextureAtlasSprite getConnectedTexture(final ConnectedProperties llllllllllllllIIIlllllllIlllIlll, final IBlockAccess llllllllllllllIIIlllllllIlllIllI, final BlockStateBase llllllllllllllIIIlllllllIllIIlll, final BlockPos llllllllllllllIIIlllllllIllIIllI, final int llllllllllllllIIIlllllllIllIIlIl, final TextureAtlasSprite llllllllllllllIIIlllllllIlllIIlI, final RenderEnv llllllllllllllIIIlllllllIllIIIll) {
        int llllllllllllllIIIlllllllIlllIIII = 0;
        int llllllllllllllIIIlllllllIllIlllI;
        final int llllllllllllllIIIlllllllIllIllll = llllllllllllllIIIlllllllIllIlllI = llllllllllllllIIIlllllllIllIIlll.getMetadata();
        final Block llllllllllllllIIIlllllllIllIllIl = llllllllllllllIIIlllllllIllIIlll.getBlock();
        if (llllllllllllllIIIlllllllIllIllIl instanceof BlockRotatedPillar) {
            llllllllllllllIIIlllllllIlllIIII = getWoodAxis(llllllllllllllIIIlllllllIllIIlIl, llllllllllllllIIIlllllllIllIllll);
            if (llllllllllllllIIIlllllllIlllIlll.getMetadataMax() <= 3) {
                llllllllllllllIIIlllllllIllIlllI = (llllllllllllllIIIlllllllIllIllll & 0x3);
            }
        }
        if (llllllllllllllIIIlllllllIllIllIl instanceof BlockQuartz) {
            llllllllllllllIIIlllllllIlllIIII = getQuartzAxis(llllllllllllllIIIlllllllIllIIlIl, llllllllllllllIIIlllllllIllIllll);
            if (llllllllllllllIIIlllllllIlllIlll.getMetadataMax() <= 2 && llllllllllllllIIIlllllllIllIlllI > 2) {
                llllllllllllllIIIlllllllIllIlllI = 2;
            }
        }
        if (!llllllllllllllIIIlllllllIlllIlll.matchesBlock(llllllllllllllIIIlllllllIllIIlll.getBlockId(), llllllllllllllIIIlllllllIllIlllI)) {
            return null;
        }
        if (llllllllllllllIIIlllllllIllIIlIl >= 0 && llllllllllllllIIIlllllllIlllIlll.faces != 63) {
            int llllllllllllllIIIlllllllIllIllII = llllllllllllllIIIlllllllIllIIlIl;
            if (llllllllllllllIIIlllllllIlllIIII != 0) {
                llllllllllllllIIIlllllllIllIllII = fixSideByAxis(llllllllllllllIIIlllllllIllIIlIl, llllllllllllllIIIlllllllIlllIIII);
            }
            if ((1 << llllllllllllllIIIlllllllIllIllII & llllllllllllllIIIlllllllIlllIlll.faces) == 0x0) {
                return null;
            }
        }
        final int llllllllllllllIIIlllllllIllIlIll = llllllllllllllIIIlllllllIllIIllI.getY();
        if (llllllllllllllIIIlllllllIllIlIll < llllllllllllllIIIlllllllIlllIlll.minHeight || llllllllllllllIIIlllllllIllIlIll > llllllllllllllIIIlllllllIlllIlll.maxHeight) {
            return null;
        }
        if (llllllllllllllIIIlllllllIlllIlll.biomes != null) {
            final BiomeGenBase llllllllllllllIIIlllllllIllIlIlI = llllllllllllllIIIlllllllIlllIllI.getBiomeGenForCoords(llllllllllllllIIIlllllllIllIIllI);
            if (!llllllllllllllIIIlllllllIlllIlll.matchesBiome(llllllllllllllIIIlllllllIllIlIlI)) {
                return null;
            }
        }
        switch (llllllllllllllIIIlllllllIlllIlll.method) {
            case 1: {
                return getConnectedTextureCtm(llllllllllllllIIIlllllllIlllIlll, llllllllllllllIIIlllllllIlllIllI, llllllllllllllIIIlllllllIllIIlll, llllllllllllllIIIlllllllIllIIllI, llllllllllllllIIIlllllllIlllIIII, llllllllllllllIIIlllllllIllIIlIl, llllllllllllllIIIlllllllIlllIIlI, llllllllllllllIIIlllllllIllIllll, llllllllllllllIIIlllllllIllIIIll);
            }
            case 2: {
                return getConnectedTextureHorizontal(llllllllllllllIIIlllllllIlllIlll, llllllllllllllIIIlllllllIlllIllI, llllllllllllllIIIlllllllIllIIlll, llllllllllllllIIIlllllllIllIIllI, llllllllllllllIIIlllllllIlllIIII, llllllllllllllIIIlllllllIllIIlIl, llllllllllllllIIIlllllllIlllIIlI, llllllllllllllIIIlllllllIllIllll);
            }
            case 3: {
                return getConnectedTextureTop(llllllllllllllIIIlllllllIlllIlll, llllllllllllllIIIlllllllIlllIllI, llllllllllllllIIIlllllllIllIIlll, llllllllllllllIIIlllllllIllIIllI, llllllllllllllIIIlllllllIlllIIII, llllllllllllllIIIlllllllIllIIlIl, llllllllllllllIIIlllllllIlllIIlI, llllllllllllllIIIlllllllIllIllll);
            }
            case 4: {
                return getConnectedTextureRandom(llllllllllllllIIIlllllllIlllIlll, llllllllllllllIIIlllllllIllIIllI, llllllllllllllIIIlllllllIllIIlIl);
            }
            case 5: {
                return getConnectedTextureRepeat(llllllllllllllIIIlllllllIlllIlll, llllllllllllllIIIlllllllIllIIllI, llllllllllllllIIIlllllllIllIIlIl);
            }
            case 6: {
                return getConnectedTextureVertical(llllllllllllllIIIlllllllIlllIlll, llllllllllllllIIIlllllllIlllIllI, llllllllllllllIIIlllllllIllIIlll, llllllllllllllIIIlllllllIllIIllI, llllllllllllllIIIlllllllIlllIIII, llllllllllllllIIIlllllllIllIIlIl, llllllllllllllIIIlllllllIlllIIlI, llllllllllllllIIIlllllllIllIllll);
            }
            case 7: {
                return getConnectedTextureFixed(llllllllllllllIIIlllllllIlllIlll);
            }
            case 8: {
                return getConnectedTextureHorizontalVertical(llllllllllllllIIIlllllllIlllIlll, llllllllllllllIIIlllllllIlllIllI, llllllllllllllIIIlllllllIllIIlll, llllllllllllllIIIlllllllIllIIllI, llllllllllllllIIIlllllllIlllIIII, llllllllllllllIIIlllllllIllIIlIl, llllllllllllllIIIlllllllIlllIIlI, llllllllllllllIIIlllllllIllIllll);
            }
            case 9: {
                return getConnectedTextureVerticalHorizontal(llllllllllllllIIIlllllllIlllIlll, llllllllllllllIIIlllllllIlllIllI, llllllllllllllIIIlllllllIllIIlll, llllllllllllllIIIlllllllIllIIllI, llllllllllllllIIIlllllllIlllIIII, llllllllllllllIIIlllllllIllIIlIl, llllllllllllllIIIlllllllIlllIIlI, llllllllllllllIIIlllllllIllIllll);
            }
            default: {
                return null;
            }
        }
    }
    
    private static void addToList(final ConnectedProperties llllllllllllllIIIlllllIlIIllIlII, final List llllllllllllllIIIlllllIlIIllIIll, final int llllllllllllllIIIlllllIlIIllIIlI) {
        while (llllllllllllllIIIlllllIlIIllIIlI >= llllllllllllllIIIlllllIlIIllIIll.size()) {
            llllllllllllllIIIlllllIlIIllIIll.add(null);
        }
        Object llllllllllllllIIIlllllIlIIllIIIl = llllllllllllllIIIlllllIlIIllIIll.get(llllllllllllllIIIlllllIlIIllIIlI);
        if (llllllllllllllIIIlllllIlIIllIIIl == null) {
            llllllllllllllIIIlllllIlIIllIIIl = new ArrayList();
            llllllllllllllIIIlllllIlIIllIIll.set(llllllllllllllIIIlllllIlIIllIIlI, llllllllllllllIIIlllllIlIIllIIIl);
        }
        ((List)llllllllllllllIIIlllllIlIIllIIIl).add(llllllllllllllIIIlllllIlIIllIlII);
    }
    
    private static BakedQuad makeSpriteQuad(final BakedQuad llllllllllllllIIlIIIIIIIIlIllIIl, final TextureAtlasSprite llllllllllllllIIlIIIIIIIIlIlIIlI) {
        final int[] llllllllllllllIIlIIIIIIIIlIlIlll = llllllllllllllIIlIIIIIIIIlIllIIl.func_178209_a().clone();
        final TextureAtlasSprite llllllllllllllIIlIIIIIIIIlIlIllI = llllllllllllllIIlIIIIIIIIlIllIIl.getSprite();
        for (int llllllllllllllIIlIIIIIIIIlIlIlIl = 0; llllllllllllllIIlIIIIIIIIlIlIlIl < 4; ++llllllllllllllIIlIIIIIIIIlIlIlIl) {
            fixVertex(llllllllllllllIIlIIIIIIIIlIlIlll, llllllllllllllIIlIIIIIIIIlIlIlIl, llllllllllllllIIlIIIIIIIIlIlIllI, llllllllllllllIIlIIIIIIIIlIlIIlI);
        }
        final BakedQuad llllllllllllllIIlIIIIIIIIlIlIlII = new BakedQuad(llllllllllllllIIlIIIIIIIIlIlIlll, llllllllllllllIIlIIIIIIIIlIllIIl.func_178211_c(), llllllllllllllIIlIIIIIIIIlIllIIl.getFace(), llllllllllllllIIlIIIIIIIIlIlIIlI);
        return llllllllllllllIIlIIIIIIIIlIlIlII;
    }
    
    static class NamelessClass379831726
    {
        static final /* synthetic */ int[] $SwitchMap$net$minecraft$util$EnumFacing;
        
        static {
            $SwitchMap$net$minecraft$util$EnumFacing = new int[EnumFacing.values().length];
            try {
                NamelessClass379831726.$SwitchMap$net$minecraft$util$EnumFacing[EnumFacing.DOWN.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                NamelessClass379831726.$SwitchMap$net$minecraft$util$EnumFacing[EnumFacing.UP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                NamelessClass379831726.$SwitchMap$net$minecraft$util$EnumFacing[EnumFacing.EAST.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                NamelessClass379831726.$SwitchMap$net$minecraft$util$EnumFacing[EnumFacing.WEST.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                NamelessClass379831726.$SwitchMap$net$minecraft$util$EnumFacing[EnumFacing.NORTH.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                NamelessClass379831726.$SwitchMap$net$minecraft$util$EnumFacing[EnumFacing.SOUTH.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
        }
    }
}
