package net.minecraft.client.renderer.chunk;

import java.util.concurrent.locks.*;
import net.minecraft.world.*;
import java.nio.*;
import net.minecraft.block.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.util.*;
import optifine.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.vertex.*;

public class RenderChunk
{
    private final /* synthetic */ int field_178596_j;
    private final /* synthetic */ ReentrantLock field_178598_h;
    private /* synthetic */ World field_178588_d;
    private /* synthetic */ boolean field_178593_n;
    private final /* synthetic */ ReentrantLock field_178587_g;
    private final /* synthetic */ VertexBuffer[] field_178594_l;
    private /* synthetic */ ChunkCompileTaskGenerator field_178599_i;
    private /* synthetic */ BlockPos[] positionOffsets16;
    private /* synthetic */ EnumWorldBlockLayer[] blockLayersSingle;
    private /* synthetic */ BlockPos field_178586_f;
    private final /* synthetic */ FloatBuffer field_178597_k;
    private /* synthetic */ boolean playerUpdate;
    private /* synthetic */ int field_178595_m;
    private final /* synthetic */ RenderGlobal field_178589_e;
    public /* synthetic */ CompiledChunk field_178590_b;
    private /* synthetic */ boolean fixBlockLayer;
    private static /* synthetic */ EnumWorldBlockLayer[] ENUM_WORLD_BLOCK_LAYERS;
    public /* synthetic */ AxisAlignedBB field_178591_c;
    private /* synthetic */ boolean isMipmaps;
    
    private EnumWorldBlockLayer fixBlockLayer(final Block lllllllllllllllIIlIllIlIlIllllII, final EnumWorldBlockLayer lllllllllllllllIIlIllIlIlIlllllI) {
        if (this.isMipmaps) {
            if (lllllllllllllllIIlIllIlIlIlllllI == EnumWorldBlockLayer.CUTOUT) {
                if (lllllllllllllllIIlIllIlIlIllllII instanceof BlockRedstoneWire) {
                    return lllllllllllllllIIlIllIlIlIlllllI;
                }
                if (lllllllllllllllIIlIllIlIlIllllII instanceof BlockCactus) {
                    return lllllllllllllllIIlIllIlIlIlllllI;
                }
                return EnumWorldBlockLayer.CUTOUT_MIPPED;
            }
        }
        else if (lllllllllllllllIIlIllIlIlIlllllI == EnumWorldBlockLayer.CUTOUT_MIPPED) {
            return EnumWorldBlockLayer.CUTOUT;
        }
        return lllllllllllllllIIlIllIlIlIlllllI;
    }
    
    public void func_178580_a(final CompiledChunk lllllllllllllllIIlIllIllIIIIIlIl) {
        this.field_178598_h.lock();
        try {
            this.field_178590_b = lllllllllllllllIIlIllIllIIIIIlIl;
        }
        finally {
            this.field_178598_h.unlock();
        }
        this.field_178598_h.unlock();
    }
    
    public void func_178581_b(final float lllllllllllllllIIlIllIlllIIIIllI, final float lllllllllllllllIIlIllIllIllIIllI, final float lllllllllllllllIIlIllIlllIIIIlII, final ChunkCompileTaskGenerator lllllllllllllllIIlIllIllIllIIlII) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   net/minecraft/client/renderer/chunk/CompiledChunk.<init>:()V
        //     7: astore          lllllllllllllllIIlIllIlllIIIIIlI
        //     9: iconst_1       
        //    10: istore          lllllllllllllllIIlIllIlllIIIIIIl
        //    12: aload_0         /* lllllllllllllllIIlIllIllIllIlIII */
        //    13: getfield        net/minecraft/client/renderer/chunk/RenderChunk.field_178586_f:Lnet/minecraft/util/BlockPos;
        //    16: astore          lllllllllllllllIIlIllIlllIIIIIII
        //    18: aload           lllllllllllllllIIlIllIlllIIIIIII
        //    20: bipush          15
        //    22: bipush          15
        //    24: bipush          15
        //    26: invokevirtual   net/minecraft/util/BlockPos.add:(III)Lnet/minecraft/util/BlockPos;
        //    29: astore          lllllllllllllllIIlIllIllIlllllll
        //    31: aload           lllllllllllllllIIlIllIlllIIIIIll
        //    33: invokevirtual   net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator.func_178540_f:()Ljava/util/concurrent/locks/ReentrantLock;
        //    36: invokevirtual   java/util/concurrent/locks/ReentrantLock.lock:()V
        //    39: aload           lllllllllllllllIIlIllIlllIIIIIll
        //    41: invokevirtual   net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator.func_178546_a:()Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Status;
        //    44: getstatic       net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Status.COMPILING:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Status;
        //    47: if_acmpeq       59
        //    50: aload           lllllllllllllllIIlIllIlllIIIIIll
        //    52: invokevirtual   net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator.func_178540_f:()Ljava/util/concurrent/locks/ReentrantLock;
        //    55: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    58: return         
        //    59: aload_0         /* lllllllllllllllIIlIllIllIllIlIII */
        //    60: getfield        net/minecraft/client/renderer/chunk/RenderChunk.field_178588_d:Lnet/minecraft/world/World;
        //    63: ifnull          163
        //    66: aload_0         /* lllllllllllllllIIlIllIllIllIlIII */
        //    67: aload_0         /* lllllllllllllllIIlIllIllIllIlIII */
        //    68: getfield        net/minecraft/client/renderer/chunk/RenderChunk.field_178588_d:Lnet/minecraft/world/World;
        //    71: aload           lllllllllllllllIIlIllIlllIIIIIII
        //    73: iconst_m1      
        //    74: iconst_m1      
        //    75: iconst_m1      
        //    76: invokevirtual   net/minecraft/util/BlockPos.add:(III)Lnet/minecraft/util/BlockPos;
        //    79: aload           lllllllllllllllIIlIllIllIlllllll
        //    81: iconst_1       
        //    82: iconst_1       
        //    83: iconst_1       
        //    84: invokevirtual   net/minecraft/util/BlockPos.add:(III)Lnet/minecraft/util/BlockPos;
        //    87: iconst_1       
        //    88: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.createRegionRenderCache:(Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;I)Lnet/minecraft/client/renderer/RegionRenderCache;
        //    91: astore          lllllllllllllllIIlIllIllIllllllI
        //    93: getstatic       optifine/Reflector.MinecraftForgeClient_onRebuildChunk:Loptifine/ReflectorMethod;
        //    96: invokevirtual   optifine/ReflectorMethod.exists:()Z
        //    99: ifeq            132
        //   102: getstatic       optifine/Reflector.MinecraftForgeClient_onRebuildChunk:Loptifine/ReflectorMethod;
        //   105: iconst_3       
        //   106: anewarray       Ljava/lang/Object;
        //   109: dup            
        //   110: iconst_0       
        //   111: aload_0         /* lllllllllllllllIIlIllIllIllIlIII */
        //   112: getfield        net/minecraft/client/renderer/chunk/RenderChunk.field_178588_d:Lnet/minecraft/world/World;
        //   115: aastore        
        //   116: dup            
        //   117: iconst_1       
        //   118: aload_0         /* lllllllllllllllIIlIllIllIllIlIII */
        //   119: getfield        net/minecraft/client/renderer/chunk/RenderChunk.field_178586_f:Lnet/minecraft/util/BlockPos;
        //   122: aastore        
        //   123: dup            
        //   124: iconst_2       
        //   125: aload           lllllllllllllllIIlIllIllIllllllI
        //   127: aastore        
        //   128: invokestatic    optifine/Reflector.call:(Loptifine/ReflectorMethod;[Ljava/lang/Object;)Ljava/lang/Object;
        //   131: pop            
        //   132: aload           lllllllllllllllIIlIllIlllIIIIIll
        //   134: aload           lllllllllllllllIIlIllIlllIIIIIlI
        //   136: invokevirtual   net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator.func_178543_a:(Lnet/minecraft/client/renderer/chunk/CompiledChunk;)V
        //   139: aload           lllllllllllllllIIlIllIlllIIIIIll
        //   141: invokevirtual   net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator.func_178540_f:()Ljava/util/concurrent/locks/ReentrantLock;
        //   144: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   147: goto            172
        //   150: astore          lllllllllllllllIIlIllIllIlIllllI
        //   152: aload           lllllllllllllllIIlIllIlllIIIIIll
        //   154: invokevirtual   net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator.func_178540_f:()Ljava/util/concurrent/locks/ReentrantLock;
        //   157: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   160: aload           lllllllllllllllIIlIllIllIlIllllI
        //   162: athrow         
        //   163: aload           lllllllllllllllIIlIllIlllIIIIIll
        //   165: invokevirtual   net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator.func_178540_f:()Ljava/util/concurrent/locks/ReentrantLock;
        //   168: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   171: return         
        //   172: new             Lnet/minecraft/client/renderer/chunk/VisGraph;
        //   175: dup            
        //   176: invokespecial   net/minecraft/client/renderer/chunk/VisGraph.<init>:()V
        //   179: astore          lllllllllllllllIIlIllIllIlllllII
        //   181: aload           lllllllllllllllIIlIllIllIlllllIl
        //   183: invokevirtual   net/minecraft/client/renderer/RegionRenderCache.extendedLevelsInChunkCache:()Z
        //   186: ifne            631
        //   189: getstatic       net/minecraft/client/renderer/chunk/RenderChunk.field_178592_a:I
        //   192: iconst_1       
        //   193: iadd           
        //   194: putstatic       net/minecraft/client/renderer/chunk/RenderChunk.field_178592_a:I
        //   197: aload           lllllllllllllllIIlIllIlllIIIIIII
        //   199: aload           lllllllllllllllIIlIllIllIlllllll
        //   201: invokestatic    optifine/BlockPosM.getAllInBoxMutable:(Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;)Ljava/lang/Iterable;
        //   204: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   209: astore          lllllllllllllllIIlIllIllIllllIll
        //   211: getstatic       optifine/Reflector.ForgeBlock_hasTileEntity:Loptifine/ReflectorMethod;
        //   214: invokevirtual   optifine/ReflectorMethod.exists:()Z
        //   217: istore          lllllllllllllllIIlIllIllIllllIlI
        //   219: getstatic       optifine/Reflector.ForgeBlock_canRenderInLayer:Loptifine/ReflectorMethod;
        //   222: invokevirtual   optifine/ReflectorMethod.exists:()Z
        //   225: istore          lllllllllllllllIIlIllIllIllllIIl
        //   227: getstatic       optifine/Reflector.ForgeHooksClient_setRenderLayer:Loptifine/ReflectorMethod;
        //   230: invokevirtual   optifine/ReflectorMethod.exists:()Z
        //   233: istore          lllllllllllllllIIlIllIllIllllIII
        //   235: goto            538
        //   238: aload           lllllllllllllllIIlIllIllIllllIll
        //   240: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   245: checkcast       Loptifine/BlockPosM;
        //   248: astore          lllllllllllllllIIlIllIllIlllIlll
        //   250: aload           lllllllllllllllIIlIllIllIlllllIl
        //   252: aload           lllllllllllllllIIlIllIllIlllIlll
        //   254: invokevirtual   net/minecraft/client/renderer/RegionRenderCache.getBlockState:(Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
        //   257: astore          lllllllllllllllIIlIllIllIlllIllI
        //   259: aload           lllllllllllllllIIlIllIllIlllIllI
        //   261: invokeinterface net/minecraft/block/state/IBlockState.getBlock:()Lnet/minecraft/block/Block;
        //   266: astore          lllllllllllllllIIlIllIllIlllIlIl
        //   268: aload           lllllllllllllllIIlIllIllIlllIlIl
        //   270: invokevirtual   net/minecraft/block/Block.isOpaqueCube:()Z
        //   273: ifeq            283
        //   276: aload           lllllllllllllllIIlIllIllIlllllII
        //   278: aload           lllllllllllllllIIlIllIllIlllIlll
        //   280: invokevirtual   net/minecraft/client/renderer/chunk/VisGraph.func_178606_a:(Lnet/minecraft/util/BlockPos;)V
        //   283: aload           lllllllllllllllIIlIllIllIlllIllI
        //   285: invokestatic    optifine/ReflectorForge.blockHasTileEntity:(Lnet/minecraft/block/state/IBlockState;)Z
        //   288: ifeq            330
        //   291: aload           lllllllllllllllIIlIllIllIlllllIl
        //   293: new             Lnet/minecraft/util/BlockPos;
        //   296: dup            
        //   297: aload           lllllllllllllllIIlIllIllIlllIlll
        //   299: invokespecial   net/minecraft/util/BlockPos.<init>:(Lnet/minecraft/util/Vec3i;)V
        //   302: invokevirtual   net/minecraft/client/renderer/RegionRenderCache.getTileEntity:(Lnet/minecraft/util/BlockPos;)Lnet/minecraft/tileentity/TileEntity;
        //   305: astore          lllllllllllllllIIlIllIllIlllIlII
        //   307: aload           lllllllllllllllIIlIllIllIlllIlII
        //   309: ifnull          330
        //   312: getstatic       net/minecraft/client/renderer/tileentity/TileEntityRendererDispatcher.instance:Lnet/minecraft/client/renderer/tileentity/TileEntityRendererDispatcher;
        //   315: aload           lllllllllllllllIIlIllIllIlllIlII
        //   317: invokevirtual   net/minecraft/client/renderer/tileentity/TileEntityRendererDispatcher.hasSpecialRenderer:(Lnet/minecraft/tileentity/TileEntity;)Z
        //   320: ifeq            330
        //   323: aload           lllllllllllllllIIlIllIlllIIIIIlI
        //   325: aload           lllllllllllllllIIlIllIllIlllIlII
        //   327: invokevirtual   net/minecraft/client/renderer/chunk/CompiledChunk.func_178490_a:(Lnet/minecraft/tileentity/TileEntity;)V
        //   330: iload           lllllllllllllllIIlIllIllIllllIIl
        //   332: ifeq            343
        //   335: getstatic       net/minecraft/client/renderer/chunk/RenderChunk.ENUM_WORLD_BLOCK_LAYERS:[Lnet/minecraft/util/EnumWorldBlockLayer;
        //   338: astore          lllllllllllllllIIlIllIllIlllIIll
        //   340: goto            358
        //   343: aload_0         /* lllllllllllllllIIlIllIllIllIlIII */
        //   344: getfield        net/minecraft/client/renderer/chunk/RenderChunk.blockLayersSingle:[Lnet/minecraft/util/EnumWorldBlockLayer;
        //   347: astore          lllllllllllllllIIlIllIllIlllIIlI
        //   349: aload           lllllllllllllllIIlIllIllIlllIIlI
        //   351: iconst_0       
        //   352: aload           lllllllllllllllIIlIllIllIlllIlIl
        //   354: invokevirtual   net/minecraft/block/Block.getBlockLayer:()Lnet/minecraft/util/EnumWorldBlockLayer;
        //   357: aastore        
        //   358: iconst_0       
        //   359: istore          lllllllllllllllIIlIllIllIlllIIIl
        //   361: goto            530
        //   364: aload           lllllllllllllllIIlIllIllIlllIIlI
        //   366: iload           lllllllllllllllIIlIllIllIlllIIIl
        //   368: aaload         
        //   369: astore          lllllllllllllllIIlIllIllIlllIIII
        //   371: iload           lllllllllllllllIIlIllIllIllllIIl
        //   373: ifeq            403
        //   376: aload           lllllllllllllllIIlIllIllIlllIlIl
        //   378: getstatic       optifine/Reflector.ForgeBlock_canRenderInLayer:Loptifine/ReflectorMethod;
        //   381: iconst_1       
        //   382: anewarray       Ljava/lang/Object;
        //   385: dup            
        //   386: iconst_0       
        //   387: aload           lllllllllllllllIIlIllIllIlllIIII
        //   389: aastore        
        //   390: invokestatic    optifine/Reflector.callBoolean:(Ljava/lang/Object;Loptifine/ReflectorMethod;[Ljava/lang/Object;)Z
        //   393: istore          lllllllllllllllIIlIllIllIllIllll
        //   395: iload           lllllllllllllllIIlIllIllIllIllll
        //   397: ifne            403
        //   400: goto            527
        //   403: iload           lllllllllllllllIIlIllIllIllllIII
        //   405: ifeq            423
        //   408: getstatic       optifine/Reflector.ForgeHooksClient_setRenderLayer:Loptifine/ReflectorMethod;
        //   411: iconst_1       
        //   412: anewarray       Ljava/lang/Object;
        //   415: dup            
        //   416: iconst_0       
        //   417: aload           lllllllllllllllIIlIllIllIlllIIII
        //   419: aastore        
        //   420: invokestatic    optifine/Reflector.callVoid:(Loptifine/ReflectorMethod;[Ljava/lang/Object;)V
        //   423: aload_0         /* lllllllllllllllIIlIllIllIllIlIII */
        //   424: getfield        net/minecraft/client/renderer/chunk/RenderChunk.fixBlockLayer:Z
        //   427: ifeq            440
        //   430: aload_0         /* lllllllllllllllIIlIllIllIllIlIII */
        //   431: aload           lllllllllllllllIIlIllIllIlllIlIl
        //   433: aload           lllllllllllllllIIlIllIllIlllIIII
        //   435: invokespecial   net/minecraft/client/renderer/chunk/RenderChunk.fixBlockLayer:(Lnet/minecraft/block/Block;Lnet/minecraft/util/EnumWorldBlockLayer;)Lnet/minecraft/util/EnumWorldBlockLayer;
        //   438: astore          lllllllllllllllIIlIllIllIlllIIII
        //   440: aload           lllllllllllllllIIlIllIllIlllIIII
        //   442: invokevirtual   net/minecraft/util/EnumWorldBlockLayer.ordinal:()I
        //   445: istore          lllllllllllllllIIlIllIllIllIlllI
        //   447: aload           lllllllllllllllIIlIllIllIlllIlIl
        //   449: invokevirtual   net/minecraft/block/Block.getRenderType:()I
        //   452: iconst_m1      
        //   453: if_icmpeq       527
        //   456: aload           lllllllllllllllIIlIllIlllIIIIIll
        //   458: invokevirtual   net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator.func_178545_d:()Lnet/minecraft/client/renderer/RegionRenderCacheBuilder;
        //   461: iload           lllllllllllllllIIlIllIllIllIlllI
        //   463: invokevirtual   net/minecraft/client/renderer/RegionRenderCacheBuilder.func_179039_a:(I)Lnet/minecraft/client/renderer/WorldRenderer;
        //   466: astore          lllllllllllllllIIlIllIllIllIllIl
        //   468: aload           lllllllllllllllIIlIllIllIllIllIl
        //   470: aload           lllllllllllllllIIlIllIllIlllIIII
        //   472: invokevirtual   net/minecraft/client/renderer/WorldRenderer.setBlockLayer:(Lnet/minecraft/util/EnumWorldBlockLayer;)V
        //   475: aload           lllllllllllllllIIlIllIlllIIIIIlI
        //   477: aload           lllllllllllllllIIlIllIllIlllIIII
        //   479: invokevirtual   net/minecraft/client/renderer/chunk/CompiledChunk.func_178492_d:(Lnet/minecraft/util/EnumWorldBlockLayer;)Z
        //   482: ifne            500
        //   485: aload           lllllllllllllllIIlIllIlllIIIIIlI
        //   487: aload           lllllllllllllllIIlIllIllIlllIIII
        //   489: invokevirtual   net/minecraft/client/renderer/chunk/CompiledChunk.func_178493_c:(Lnet/minecraft/util/EnumWorldBlockLayer;)V
        //   492: aload_0         /* lllllllllllllllIIlIllIllIllIlIII */
        //   493: aload           lllllllllllllllIIlIllIllIllIllIl
        //   495: aload           lllllllllllllllIIlIllIlllIIIIIII
        //   497: invokespecial   net/minecraft/client/renderer/chunk/RenderChunk.func_178573_a:(Lnet/minecraft/client/renderer/WorldRenderer;Lnet/minecraft/util/BlockPos;)V
        //   500: invokestatic    net/minecraft/client/Minecraft.getMinecraft:()Lnet/minecraft/client/Minecraft;
        //   503: invokevirtual   net/minecraft/client/Minecraft.getBlockRendererDispatcher:()Lnet/minecraft/client/renderer/BlockRendererDispatcher;
        //   506: aload           lllllllllllllllIIlIllIllIlllIllI
        //   508: aload           lllllllllllllllIIlIllIllIlllIlll
        //   510: aload           lllllllllllllllIIlIllIllIlllllIl
        //   512: aload           lllllllllllllllIIlIllIllIllIllIl
        //   514: invokevirtual   net/minecraft/client/renderer/BlockRendererDispatcher.func_175018_a:(Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/util/BlockPos;Lnet/minecraft/world/IBlockAccess;Lnet/minecraft/client/renderer/WorldRenderer;)Z
        //   517: ifeq            527
        //   520: aload           lllllllllllllllIIlIllIlllIIIIIlI
        //   522: aload           lllllllllllllllIIlIllIllIlllIIII
        //   524: invokevirtual   net/minecraft/client/renderer/chunk/CompiledChunk.func_178486_a:(Lnet/minecraft/util/EnumWorldBlockLayer;)V
        //   527: iinc            lllllllllllllllIIlIllIllIlllIIIl, 1
        //   530: iload           lllllllllllllllIIlIllIllIlllIIIl
        //   532: aload           lllllllllllllllIIlIllIllIlllIIlI
        //   534: arraylength    
        //   535: if_icmplt       364
        //   538: aload           lllllllllllllllIIlIllIllIllllIll
        //   540: invokeinterface java/util/Iterator.hasNext:()Z
        //   545: ifne            238
        //   548: getstatic       net/minecraft/client/renderer/chunk/RenderChunk.ENUM_WORLD_BLOCK_LAYERS:[Lnet/minecraft/util/EnumWorldBlockLayer;
        //   551: astore          lllllllllllllllIIlIllIllIllIllII
        //   553: aload           lllllllllllllllIIlIllIllIllIllII
        //   555: arraylength    
        //   556: istore          lllllllllllllllIIlIllIllIllIlIll
        //   558: iconst_0       
        //   559: istore          lllllllllllllllIIlIllIllIllIlIlI
        //   561: goto            624
        //   564: aload           lllllllllllllllIIlIllIllIllIllII
        //   566: iload           lllllllllllllllIIlIllIllIllIlIlI
        //   568: aaload         
        //   569: astore          lllllllllllllllIIlIllIllIllIlIIl
        //   571: aload           lllllllllllllllIIlIllIlllIIIIIlI
        //   573: aload           lllllllllllllllIIlIllIllIllIlIIl
        //   575: invokevirtual   net/minecraft/client/renderer/chunk/CompiledChunk.func_178492_d:(Lnet/minecraft/util/EnumWorldBlockLayer;)Z
        //   578: ifeq            621
        //   581: invokestatic    optifine/Config.isShaders:()Z
        //   584: ifeq            600
        //   587: aload           lllllllllllllllIIlIllIlllIIIIIll
        //   589: invokevirtual   net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator.func_178545_d:()Lnet/minecraft/client/renderer/RegionRenderCacheBuilder;
        //   592: aload           lllllllllllllllIIlIllIllIllIlIIl
        //   594: invokevirtual   net/minecraft/client/renderer/RegionRenderCacheBuilder.func_179038_a:(Lnet/minecraft/util/EnumWorldBlockLayer;)Lnet/minecraft/client/renderer/WorldRenderer;
        //   597: invokestatic    shadersmod/client/SVertexBuilder.calcNormalChunkLayer:(Lnet/minecraft/client/renderer/WorldRenderer;)V
        //   600: aload_0         /* lllllllllllllllIIlIllIllIllIlIII */
        //   601: aload           lllllllllllllllIIlIllIllIllIlIIl
        //   603: fload_1         /* lllllllllllllllIIlIllIllIllIIlll */
        //   604: fload_2         /* lllllllllllllllIIlIllIlllIIIIlIl */
        //   605: fload_3         /* lllllllllllllllIIlIllIllIllIIlIl */
        //   606: aload           lllllllllllllllIIlIllIlllIIIIIll
        //   608: invokevirtual   net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator.func_178545_d:()Lnet/minecraft/client/renderer/RegionRenderCacheBuilder;
        //   611: aload           lllllllllllllllIIlIllIllIllIlIIl
        //   613: invokevirtual   net/minecraft/client/renderer/RegionRenderCacheBuilder.func_179038_a:(Lnet/minecraft/util/EnumWorldBlockLayer;)Lnet/minecraft/client/renderer/WorldRenderer;
        //   616: aload           lllllllllllllllIIlIllIlllIIIIIlI
        //   618: invokespecial   net/minecraft/client/renderer/chunk/RenderChunk.func_178584_a:(Lnet/minecraft/util/EnumWorldBlockLayer;FFFLnet/minecraft/client/renderer/WorldRenderer;Lnet/minecraft/client/renderer/chunk/CompiledChunk;)V
        //   621: iinc            lllllllllllllllIIlIllIllIllIlIlI, 1
        //   624: iload           lllllllllllllllIIlIllIllIllIlIlI
        //   626: iload           lllllllllllllllIIlIllIllIllIlIll
        //   628: if_icmplt       564
        //   631: aload           lllllllllllllllIIlIllIlllIIIIIlI
        //   633: aload           lllllllllllllllIIlIllIllIlllllII
        //   635: invokevirtual   net/minecraft/client/renderer/chunk/VisGraph.func_178607_a:()Lnet/minecraft/client/renderer/chunk/SetVisibility;
        //   638: invokevirtual   net/minecraft/client/renderer/chunk/CompiledChunk.func_178488_a:(Lnet/minecraft/client/renderer/chunk/SetVisibility;)V
        //   641: return         
        //    StackMapTable: 00 17 FF 00 3B 00 09 07 00 02 02 02 02 07 00 08 07 00 69 01 07 00 70 07 00 70 00 00 FC 00 48 07 00 9E FF 00 11 00 09 07 00 02 02 02 02 07 00 08 07 00 69 01 07 00 70 07 00 70 00 01 07 00 65 0C FC 00 08 07 00 9E FF 00 41 00 0F 07 00 02 02 02 02 07 00 08 07 00 69 01 07 00 70 07 00 70 07 00 9E 07 00 9B 07 00 BA 01 01 01 00 00 FE 00 2C 07 00 A5 07 00 C4 07 00 CA 2E 0C FC 00 0E 07 01 93 FC 00 05 01 FC 00 26 07 00 39 13 10 FD 00 3B 01 07 00 10 FA 00 1A F9 00 02 FF 00 07 00 0F 07 00 02 02 02 02 07 00 08 07 00 69 01 07 00 70 07 00 70 07 00 9E 07 00 9B 07 00 BA 01 01 01 00 00 FE 00 19 07 01 93 01 01 FC 00 23 07 00 39 14 FA 00 02 FF 00 06 00 0B 07 00 02 02 02 02 07 00 08 07 00 69 01 07 00 70 07 00 70 07 00 9E 07 00 9B 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  39     50     150    163    Any
        //  59     139    150    163    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public void func_178570_a(final float lllllllllllllllIIlIllIlllIlIIlII, final float lllllllllllllllIIlIllIlllIlIIIll, final float lllllllllllllllIIlIllIlllIlIIIlI, final ChunkCompileTaskGenerator lllllllllllllllIIlIllIlllIlIIIIl) {
        final CompiledChunk lllllllllllllllIIlIllIlllIlIIlll = lllllllllllllllIIlIllIlllIlIIIIl.func_178544_c();
        if (lllllllllllllllIIlIllIlllIlIIlll.func_178487_c() != null && !lllllllllllllllIIlIllIlllIlIIlll.func_178491_b(EnumWorldBlockLayer.TRANSLUCENT)) {
            final WorldRenderer lllllllllllllllIIlIllIlllIlIIllI = lllllllllllllllIIlIllIlllIlIIIIl.func_178545_d().func_179038_a(EnumWorldBlockLayer.TRANSLUCENT);
            this.func_178573_a(lllllllllllllllIIlIllIlllIlIIllI, this.field_178586_f);
            lllllllllllllllIIlIllIlllIlIIllI.setVertexState(lllllllllllllllIIlIllIlllIlIIlll.func_178487_c());
            this.func_178584_a(EnumWorldBlockLayer.TRANSLUCENT, lllllllllllllllIIlIllIlllIlIIlII, lllllllllllllllIIlIllIlllIlIIIll, lllllllllllllllIIlIllIlllIlIIIlI, lllllllllllllllIIlIllIlllIlIIllI, lllllllllllllllIIlIllIlllIlIIlll);
        }
    }
    
    private void func_178584_a(final EnumWorldBlockLayer lllllllllllllllIIlIllIllIIlIIIll, final float lllllllllllllllIIlIllIllIIlIIIlI, final float lllllllllllllllIIlIllIllIIIllIll, final float lllllllllllllllIIlIllIllIIlIIIII, final WorldRenderer lllllllllllllllIIlIllIllIIIlllll, final CompiledChunk lllllllllllllllIIlIllIllIIIllIII) {
        if (lllllllllllllllIIlIllIllIIlIIIll == EnumWorldBlockLayer.TRANSLUCENT && !lllllllllllllllIIlIllIllIIIllIII.func_178491_b(lllllllllllllllIIlIllIllIIlIIIll)) {
            lllllllllllllllIIlIllIllIIIllIII.func_178494_a(lllllllllllllllIIlIllIllIIIlllll.getVertexState(lllllllllllllllIIlIllIllIIlIIIlI, lllllllllllllllIIlIllIllIIIllIll, lllllllllllllllIIlIllIllIIlIIIII));
        }
        lllllllllllllllIIlIllIllIIIlllll.draw();
    }
    
    public void func_178566_a() {
        this.func_178585_h();
        this.field_178588_d = null;
        for (int lllllllllllllllIIlIllIlIllllllIl = 0; lllllllllllllllIIlIllIlIllllllIl < EnumWorldBlockLayer.values().length; ++lllllllllllllllIIlIllIlIllllllIl) {
            if (this.field_178594_l[lllllllllllllllIIlIllIlIllllllIl] != null) {
                this.field_178594_l[lllllllllllllllIIlIllIlIllllllIl].func_177362_c();
            }
        }
    }
    
    public void func_178585_h() {
        this.func_178578_b();
        this.field_178590_b = CompiledChunk.field_178502_a;
    }
    
    public boolean func_178569_m() {
        return this.field_178593_n;
    }
    
    public boolean func_178577_a(final int lllllllllllllllIIlIllIllllIIIIll) {
        if (this.field_178595_m == lllllllllllllllIIlIllIllllIIIIll) {
            return false;
        }
        this.field_178595_m = lllllllllllllllIIlIllIllllIIIIll;
        return true;
    }
    
    public ReentrantLock func_178579_c() {
        return this.field_178587_g;
    }
    
    public ChunkCompileTaskGenerator func_178574_d() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        net/minecraft/client/renderer/chunk/RenderChunk.field_178587_g:Ljava/util/concurrent/locks/ReentrantLock;
        //     4: invokevirtual   java/util/concurrent/locks/ReentrantLock.lock:()V
        //     7: aload_0         /* lllllllllllllllIIlIllIllIlIIIIll */
        //     8: invokevirtual   net/minecraft/client/renderer/chunk/RenderChunk.func_178578_b:()V
        //    11: aload_0         /* lllllllllllllllIIlIllIllIlIIIIll */
        //    12: new             Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    15: dup            
        //    16: aload_0         /* lllllllllllllllIIlIllIllIlIIIIll */
        //    17: getstatic       net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Type.REBUILD_CHUNK:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Type;
        //    20: invokespecial   net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator.<init>:(Lnet/minecraft/client/renderer/chunk/RenderChunk;Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Type;)V
        //    23: putfield        net/minecraft/client/renderer/chunk/RenderChunk.field_178599_i:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    26: aload_0         /* lllllllllllllllIIlIllIllIlIIIIll */
        //    27: getfield        net/minecraft/client/renderer/chunk/RenderChunk.field_178599_i:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    30: astore_1        /* lllllllllllllllIIlIllIllIlIIIlIl */
        //    31: goto            44
        //    34: astore_2        /* lllllllllllllllIIlIllIllIlIIIIIl */
        //    35: aload_0         /* lllllllllllllllIIlIllIllIlIIIIll */
        //    36: getfield        net/minecraft/client/renderer/chunk/RenderChunk.field_178587_g:Ljava/util/concurrent/locks/ReentrantLock;
        //    39: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    42: aload_2         /* lllllllllllllllIIlIllIllIlIIIIIl */
        //    43: athrow         
        //    44: aload_0         /* lllllllllllllllIIlIllIllIlIIIIll */
        //    45: getfield        net/minecraft/client/renderer/chunk/RenderChunk.field_178587_g:Ljava/util/concurrent/locks/ReentrantLock;
        //    48: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    51: aload_1         /* lllllllllllllllIIlIllIllIlIIIlII */
        //    52: areturn        
        //    StackMapTable: 00 02 62 07 00 65 FC 00 09 07 00 08
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  7      34     34     44     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private boolean isWorldPlayerUpdate() {
        if (this.field_178588_d instanceof WorldClient) {
            final WorldClient lllllllllllllllIIlIllIlIllIlIllI = (WorldClient)this.field_178588_d;
            return lllllllllllllllIIlIllIlIllIlIllI.isPlayerUpdate();
        }
        return false;
    }
    
    public ChunkCompileTaskGenerator func_178582_e() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        net/minecraft/client/renderer/chunk/RenderChunk.field_178587_g:Ljava/util/concurrent/locks/ReentrantLock;
        //     4: invokevirtual   java/util/concurrent/locks/ReentrantLock.lock:()V
        //     7: aload_0         /* lllllllllllllllIIlIllIllIIllIllI */
        //     8: getfield        net/minecraft/client/renderer/chunk/RenderChunk.field_178599_i:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    11: ifnull          42
        //    14: aload_0         /* lllllllllllllllIIlIllIllIIllIllI */
        //    15: getfield        net/minecraft/client/renderer/chunk/RenderChunk.field_178599_i:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    18: invokevirtual   net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator.func_178546_a:()Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Status;
        //    21: getstatic       net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Status.PENDING:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Status;
        //    24: if_acmpne       42
        //    27: aconst_null    
        //    28: astore_2        /* lllllllllllllllIIlIllIllIIlllIII */
        //    29: aload_2         /* lllllllllllllllIIlIllIllIIlllIII */
        //    30: astore          lllllllllllllllIIlIllIllIIllIIlI
        //    32: aload_0         /* lllllllllllllllIIlIllIllIIllIllI */
        //    33: getfield        net/minecraft/client/renderer/chunk/RenderChunk.field_178587_g:Ljava/util/concurrent/locks/ReentrantLock;
        //    36: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    39: aload           lllllllllllllllIIlIllIllIIllIIlI
        //    41: areturn        
        //    42: aload_0         /* lllllllllllllllIIlIllIllIIllIllI */
        //    43: getfield        net/minecraft/client/renderer/chunk/RenderChunk.field_178599_i:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    46: ifnull          74
        //    49: aload_0         /* lllllllllllllllIIlIllIllIIllIllI */
        //    50: getfield        net/minecraft/client/renderer/chunk/RenderChunk.field_178599_i:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    53: invokevirtual   net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator.func_178546_a:()Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Status;
        //    56: getstatic       net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Status.DONE:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Status;
        //    59: if_acmpeq       74
        //    62: aload_0         /* lllllllllllllllIIlIllIllIIllIllI */
        //    63: getfield        net/minecraft/client/renderer/chunk/RenderChunk.field_178599_i:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    66: invokevirtual   net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator.func_178542_e:()V
        //    69: aload_0         /* lllllllllllllllIIlIllIllIIllIllI */
        //    70: aconst_null    
        //    71: putfield        net/minecraft/client/renderer/chunk/RenderChunk.field_178599_i:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    74: aload_0         /* lllllllllllllllIIlIllIllIIllIllI */
        //    75: new             Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    78: dup            
        //    79: aload_0         /* lllllllllllllllIIlIllIllIIllIllI */
        //    80: getstatic       net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Type.RESORT_TRANSPARENCY:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Type;
        //    83: invokespecial   net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator.<init>:(Lnet/minecraft/client/renderer/chunk/RenderChunk;Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Type;)V
        //    86: putfield        net/minecraft/client/renderer/chunk/RenderChunk.field_178599_i:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    89: aload_0         /* lllllllllllllllIIlIllIllIIllIllI */
        //    90: getfield        net/minecraft/client/renderer/chunk/RenderChunk.field_178599_i:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    93: aload_0         /* lllllllllllllllIIlIllIllIIllIllI */
        //    94: getfield        net/minecraft/client/renderer/chunk/RenderChunk.field_178590_b:Lnet/minecraft/client/renderer/chunk/CompiledChunk;
        //    97: invokevirtual   net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator.func_178543_a:(Lnet/minecraft/client/renderer/chunk/CompiledChunk;)V
        //   100: aload_0         /* lllllllllllllllIIlIllIllIIllIllI */
        //   101: getfield        net/minecraft/client/renderer/chunk/RenderChunk.field_178599_i:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //   104: astore_2        /* lllllllllllllllIIlIllIllIIllIlll */
        //   105: aload_2         /* lllllllllllllllIIlIllIllIIllIlll */
        //   106: astore_1        /* lllllllllllllllIIlIllIllIIlllIlI */
        //   107: goto            120
        //   110: astore_3        /* lllllllllllllllIIlIllIllIIllIIll */
        //   111: aload_0         /* lllllllllllllllIIlIllIllIIllIllI */
        //   112: getfield        net/minecraft/client/renderer/chunk/RenderChunk.field_178587_g:Ljava/util/concurrent/locks/ReentrantLock;
        //   115: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   118: aload_3         /* lllllllllllllllIIlIllIllIIllIIll */
        //   119: athrow         
        //   120: aload_0         /* lllllllllllllllIIlIllIllIIllIllI */
        //   121: getfield        net/minecraft/client/renderer/chunk/RenderChunk.field_178587_g:Ljava/util/concurrent/locks/ReentrantLock;
        //   124: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   127: aload_1         /* lllllllllllllllIIlIllIllIIlllIIl */
        //   128: areturn        
        //    StackMapTable: 00 04 2A 1F 63 07 00 65 FD 00 09 07 00 08 07 00 08
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  7      32     110    120    Any
        //  42     110    110    120    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public boolean func_178583_l() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        net/minecraft/client/renderer/chunk/RenderChunk.field_178587_g:Ljava/util/concurrent/locks/ReentrantLock;
        //     4: invokevirtual   java/util/concurrent/locks/ReentrantLock.lock:()V
        //     7: aload_0         /* lllllllllllllllIIlIllIlIllllIlII */
        //     8: getfield        net/minecraft/client/renderer/chunk/RenderChunk.field_178599_i:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    11: ifnull          31
        //    14: aload_0         /* lllllllllllllllIIlIllIlIllllIlII */
        //    15: getfield        net/minecraft/client/renderer/chunk/RenderChunk.field_178599_i:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator;
        //    18: invokevirtual   net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator.func_178546_a:()Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Status;
        //    21: getstatic       net/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Status.PENDING:Lnet/minecraft/client/renderer/chunk/ChunkCompileTaskGenerator$Status;
        //    24: if_acmpeq       31
        //    27: iconst_0       
        //    28: goto            32
        //    31: iconst_1       
        //    32: istore_1        /* lllllllllllllllIIlIllIlIllllIIII */
        //    33: goto            46
        //    36: astore_2        /* lllllllllllllllIIlIllIlIlllIllll */
        //    37: aload_0         /* lllllllllllllllIIlIllIlIllllIlII */
        //    38: getfield        net/minecraft/client/renderer/chunk/RenderChunk.field_178587_g:Ljava/util/concurrent/locks/ReentrantLock;
        //    41: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    44: aload_2         /* lllllllllllllllIIlIllIlIlllIllll */
        //    45: athrow         
        //    46: aload_0         /* lllllllllllllllIIlIllIlIllllIlII */
        //    47: getfield        net/minecraft/client/renderer/chunk/RenderChunk.field_178587_g:Ljava/util/concurrent/locks/ReentrantLock;
        //    50: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //    53: iload_1         /* lllllllllllllllIIlIllIlIllllIIlI */
        //    54: ireturn        
        //    StackMapTable: 00 04 1F 40 01 43 07 00 65 FC 00 09 01
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  7      36     36     46     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static {
        __OBFID = "CL_00002452";
        RenderChunk.ENUM_WORLD_BLOCK_LAYERS = EnumWorldBlockLayer.values();
    }
    
    public VertexBuffer func_178565_b(final int lllllllllllllllIIlIllIlllIllllIl) {
        return this.field_178594_l[lllllllllllllllIIlIllIlllIllllIl];
    }
    
    public void func_178575_a(final boolean lllllllllllllllIIlIllIlIlllIlIIl) {
        this.field_178593_n = lllllllllllllllIIlIllIlIlllIlIIl;
        if (this.field_178593_n) {
            if (this.isWorldPlayerUpdate()) {
                this.playerUpdate = true;
            }
        }
        else {
            this.playerUpdate = false;
        }
    }
    
    public CompiledChunk func_178571_g() {
        return this.field_178590_b;
    }
    
    protected RegionRenderCache createRegionRenderCache(final World lllllllllllllllIIlIllIlIllIIlIll, final BlockPos lllllllllllllllIIlIllIlIllIIlIlI, final BlockPos lllllllllllllllIIlIllIlIllIIIlIl, final int lllllllllllllllIIlIllIlIllIIIlII) {
        return new RegionRenderCache(lllllllllllllllIIlIllIlIllIIlIll, lllllllllllllllIIlIllIlIllIIlIlI, lllllllllllllllIIlIllIlIllIIIlIl, lllllllllllllllIIlIllIlIllIIIlII);
    }
    
    private void func_178567_n() {
        GlStateManager.pushMatrix();
        GlStateManager.loadIdentity();
        final float lllllllllllllllIIlIllIllIIIlIlII = 1.000001f;
        GlStateManager.translate(-8.0f, -8.0f, -8.0f);
        GlStateManager.scale(lllllllllllllllIIlIllIllIIIlIlII, lllllllllllllllIIlIllIllIIIlIlII, lllllllllllllllIIlIllIllIIIlIlII);
        GlStateManager.translate(8.0f, 8.0f, 8.0f);
        GlStateManager.getFloat(2982, this.field_178597_k);
        GlStateManager.popMatrix();
    }
    
    public BlockPos func_178568_j() {
        return this.field_178586_f;
    }
    
    public RenderChunk(final World lllllllllllllllIIlIllIllllIIllIl, final RenderGlobal lllllllllllllllIIlIllIllllIIllII, final BlockPos lllllllllllllllIIlIllIllllIlIIIl, final int lllllllllllllllIIlIllIllllIlIIII) {
        this.positionOffsets16 = new BlockPos[EnumFacing.VALUES.length];
        this.blockLayersSingle = new EnumWorldBlockLayer[1];
        this.isMipmaps = Config.isMipmaps();
        this.fixBlockLayer = !Reflector.BetterFoliageClient.exists();
        this.playerUpdate = false;
        this.field_178590_b = CompiledChunk.field_178502_a;
        this.field_178587_g = new ReentrantLock();
        this.field_178598_h = new ReentrantLock();
        this.field_178599_i = null;
        this.field_178597_k = GLAllocation.createDirectFloatBuffer(16);
        this.field_178594_l = new VertexBuffer[EnumWorldBlockLayer.values().length];
        this.field_178595_m = -1;
        this.field_178593_n = true;
        this.field_178588_d = lllllllllllllllIIlIllIllllIIllIl;
        this.field_178589_e = lllllllllllllllIIlIllIllllIIllII;
        this.field_178596_j = lllllllllllllllIIlIllIllllIlIIII;
        if (!lllllllllllllllIIlIllIllllIlIIIl.equals(this.func_178568_j())) {
            this.func_178576_a(lllllllllllllllIIlIllIllllIlIIIl);
        }
        if (OpenGlHelper.func_176075_f()) {
            for (int lllllllllllllllIIlIllIllllIIllll = 0; lllllllllllllllIIlIllIllllIIllll < EnumWorldBlockLayer.values().length; ++lllllllllllllllIIlIllIllllIIllll) {
                this.field_178594_l[lllllllllllllllIIlIllIllllIIllll] = new VertexBuffer(DefaultVertexFormats.field_176600_a);
            }
        }
    }
    
    public boolean isPlayerUpdate() {
        return this.playerUpdate;
    }
    
    protected void func_178578_b() {
        this.field_178587_g.lock();
        try {
            if (this.field_178599_i != null && this.field_178599_i.func_178546_a() != ChunkCompileTaskGenerator.Status.DONE) {
                this.field_178599_i.func_178542_e();
                this.field_178599_i = null;
            }
        }
        finally {
            this.field_178587_g.unlock();
        }
        this.field_178587_g.unlock();
    }
    
    public BlockPos getPositionOffset16(final EnumFacing lllllllllllllllIIlIllIlIlllIIIII) {
        final int lllllllllllllllIIlIllIlIllIlllll = lllllllllllllllIIlIllIlIlllIIIII.getIndex();
        BlockPos lllllllllllllllIIlIllIlIllIllllI = this.positionOffsets16[lllllllllllllllIIlIllIlIllIlllll];
        if (lllllllllllllllIIlIllIlIllIllllI == null) {
            lllllllllllllllIIlIllIlIllIllllI = this.func_178568_j().offset(lllllllllllllllIIlIllIlIlllIIIII, 16);
            this.positionOffsets16[lllllllllllllllIIlIllIlIllIlllll] = lllllllllllllllIIlIllIlIllIllllI;
        }
        return lllllllllllllllIIlIllIlIllIllllI;
    }
    
    private void func_178573_a(final WorldRenderer lllllllllllllllIIlIllIllIIlIlllI, final BlockPos lllllllllllllllIIlIllIllIIlIlIll) {
        lllllllllllllllIIlIllIllIIlIlllI.startDrawing(7);
        lllllllllllllllIIlIllIllIIlIlllI.setVertexFormat(DefaultVertexFormats.field_176600_a);
        lllllllllllllllIIlIllIllIIlIlllI.setTranslation(-lllllllllllllllIIlIllIllIIlIlIll.getX(), -lllllllllllllllIIlIllIllIIlIlIll.getY(), -lllllllllllllllIIlIllIllIIlIlIll.getZ());
    }
    
    public void func_178576_a(final BlockPos lllllllllllllllIIlIllIlllIllIlIl) {
        this.func_178585_h();
        this.field_178586_f = lllllllllllllllIIlIllIlllIllIlIl;
        this.field_178591_c = new AxisAlignedBB(lllllllllllllllIIlIllIlllIllIlIl, lllllllllllllllIIlIllIlllIllIlIl.add(16, 16, 16));
        this.func_178567_n();
        for (int lllllllllllllllIIlIllIlllIllIlll = 0; lllllllllllllllIIlIllIlllIllIlll < this.positionOffsets16.length; ++lllllllllllllllIIlIllIlllIllIlll) {
            this.positionOffsets16[lllllllllllllllIIlIllIlllIllIlll] = null;
        }
    }
    
    public void func_178572_f() {
        GlStateManager.multMatrix(this.field_178597_k);
    }
}
