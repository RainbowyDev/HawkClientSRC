package net.minecraft.world;

import net.minecraft.world.biome.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.world.chunk.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import com.google.common.collect.*;

public final class SpawnerAnimals
{
    private final /* synthetic */ Set eligibleChunksForSpawning;
    
    public static void performWorldGenSpawning(final World llllllllllllllIlIlIlllllllIlIIII, final BiomeGenBase llllllllllllllIlIlIlllllllIIllll, final int llllllllllllllIlIlIlllllllIIlllI, final int llllllllllllllIlIlIlllllllIIllIl, final int llllllllllllllIlIlIllllllllIIIlI, final int llllllllllllllIlIlIlllllllIIlIll, final Random llllllllllllllIlIlIlllllllIIlIlI) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getstatic       net/minecraft/entity/EnumCreatureType.CREATURE:Lnet/minecraft/entity/EnumCreatureType;
        //     4: invokevirtual   net/minecraft/world/biome/BiomeGenBase.getSpawnableList:(Lnet/minecraft/entity/EnumCreatureType;)Ljava/util/List;
        //     7: astore          llllllllllllllIlIlIlllllllIlllll
        //     9: aload           llllllllllllllIlIlIlllllllIlllll
        //    11: invokeinterface java/util/List.isEmpty:()Z
        //    16: ifne            394
        //    19: goto            381
        //    22: aload_0         /* llllllllllllllIlIlIllllllllIIllI */
        //    23: getfield        net/minecraft/world/World.rand:Ljava/util/Random;
        //    26: aload           llllllllllllllIlIlIlllllllIlllll
        //    28: invokestatic    net/minecraft/util/WeightedRandom.getRandomItem:(Ljava/util/Random;Ljava/util/Collection;)Lnet/minecraft/util/WeightedRandom$Item;
        //    31: checkcast       Lnet/minecraft/world/biome/BiomeGenBase$SpawnListEntry;
        //    34: astore          llllllllllllllIlIlIlllllllIllllI
        //    36: aload           llllllllllllllIlIlIlllllllIllllI
        //    38: getfield        net/minecraft/world/biome/BiomeGenBase$SpawnListEntry.minGroupCount:I
        //    41: aload           llllllllllllllIlIlIllllllllIIIII
        //    43: iconst_1       
        //    44: aload           llllllllllllllIlIlIlllllllIllllI
        //    46: getfield        net/minecraft/world/biome/BiomeGenBase$SpawnListEntry.maxGroupCount:I
        //    49: iadd           
        //    50: aload           llllllllllllllIlIlIlllllllIllllI
        //    52: getfield        net/minecraft/world/biome/BiomeGenBase$SpawnListEntry.minGroupCount:I
        //    55: isub           
        //    56: invokevirtual   java/util/Random.nextInt:(I)I
        //    59: iadd           
        //    60: istore          llllllllllllllIlIlIlllllllIlllIl
        //    62: aconst_null    
        //    63: astore          llllllllllllllIlIlIlllllllIlllII
        //    65: iload_2         /* llllllllllllllIlIlIllllllllIIlII */
        //    66: aload           llllllllllllllIlIlIllllllllIIIII
        //    68: iload           llllllllllllllIlIlIlllllllIIllII
        //    70: invokevirtual   java/util/Random.nextInt:(I)I
        //    73: iadd           
        //    74: istore          llllllllllllllIlIlIlllllllIllIll
        //    76: iload_3         /* llllllllllllllIlIlIllllllllIIIll */
        //    77: aload           llllllllllllllIlIlIllllllllIIIII
        //    79: iload           llllllllllllllIlIlIllllllllIIIIl
        //    81: invokevirtual   java/util/Random.nextInt:(I)I
        //    84: iadd           
        //    85: istore          llllllllllllllIlIlIlllllllIllIlI
        //    87: iload           llllllllllllllIlIlIlllllllIllIll
        //    89: istore          llllllllllllllIlIlIlllllllIllIIl
        //    91: iload           llllllllllllllIlIlIlllllllIllIlI
        //    93: istore          llllllllllllllIlIlIlllllllIllIII
        //    95: iconst_0       
        //    96: istore          llllllllllllllIlIlIlllllllIlIlll
        //    98: goto            374
        //   101: iconst_0       
        //   102: istore          llllllllllllllIlIlIlllllllIlIllI
        //   104: iconst_0       
        //   105: istore          llllllllllllllIlIlIlllllllIlIlIl
        //   107: goto            360
        //   110: aload_0         /* llllllllllllllIlIlIllllllllIIllI */
        //   111: new             Lnet/minecraft/util/BlockPos;
        //   114: dup            
        //   115: iload           llllllllllllllIlIlIlllllllIllIll
        //   117: iconst_0       
        //   118: iload           llllllllllllllIlIlIlllllllIllIlI
        //   120: invokespecial   net/minecraft/util/BlockPos.<init>:(III)V
        //   123: invokevirtual   net/minecraft/world/World.func_175672_r:(Lnet/minecraft/util/BlockPos;)Lnet/minecraft/util/BlockPos;
        //   126: astore          llllllllllllllIlIlIlllllllIlIlII
        //   128: getstatic       net/minecraft/entity/EntityLiving$SpawnPlacementType.ON_GROUND:Lnet/minecraft/entity/EntityLiving$SpawnPlacementType;
        //   131: aload_0         /* llllllllllllllIlIlIllllllllIIllI */
        //   132: aload           llllllllllllllIlIlIlllllllIlIlII
        //   134: invokestatic    net/minecraft/world/SpawnerAnimals.func_180267_a:(Lnet/minecraft/entity/EntityLiving$SpawnPlacementType;Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;)Z
        //   137: ifeq            252
        //   140: aload           llllllllllllllIlIlIlllllllIllllI
        //   142: getfield        net/minecraft/world/biome/BiomeGenBase$SpawnListEntry.entityClass:Ljava/lang/Class;
        //   145: iconst_1       
        //   146: anewarray       Ljava/lang/Class;
        //   149: dup            
        //   150: iconst_0       
        //   151: ldc             Lnet/minecraft/world/World;.class
        //   153: aastore        
        //   154: invokevirtual   java/lang/Class.getConstructor:([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
        //   157: iconst_1       
        //   158: anewarray       Ljava/lang/Object;
        //   161: dup            
        //   162: iconst_0       
        //   163: aload_0         /* llllllllllllllIlIlIllllllllIIllI */
        //   164: aastore        
        //   165: invokevirtual   java/lang/reflect/Constructor.newInstance:([Ljava/lang/Object;)Ljava/lang/Object;
        //   168: checkcast       Lnet/minecraft/entity/EntityLiving;
        //   171: astore          llllllllllllllIlIlIlllllllIlIIll
        //   173: goto            186
        //   176: astore          llllllllllllllIlIlIlllllllIlIIIl
        //   178: aload           llllllllllllllIlIlIlllllllIlIIIl
        //   180: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   183: goto            357
        //   186: aload           llllllllllllllIlIlIlllllllIlIIlI
        //   188: iload           llllllllllllllIlIlIlllllllIllIll
        //   190: i2f            
        //   191: ldc             0.5
        //   193: fadd           
        //   194: f2d            
        //   195: aload           llllllllllllllIlIlIlllllllIlIlII
        //   197: invokevirtual   net/minecraft/util/BlockPos.getY:()I
        //   200: i2d            
        //   201: iload           llllllllllllllIlIlIlllllllIllIlI
        //   203: i2f            
        //   204: ldc             0.5
        //   206: fadd           
        //   207: f2d            
        //   208: aload           llllllllllllllIlIlIllllllllIIIII
        //   210: invokevirtual   java/util/Random.nextFloat:()F
        //   213: ldc             360.0
        //   215: fmul           
        //   216: fconst_0       
        //   217: invokevirtual   net/minecraft/entity/EntityLiving.setLocationAndAngles:(DDDFF)V
        //   220: aload_0         /* llllllllllllllIlIlIllllllllIIllI */
        //   221: aload           llllllllllllllIlIlIlllllllIlIIlI
        //   223: invokevirtual   net/minecraft/world/World.spawnEntityInWorld:(Lnet/minecraft/entity/Entity;)Z
        //   226: pop            
        //   227: aload           llllllllllllllIlIlIlllllllIlIIlI
        //   229: aload_0         /* llllllllllllllIlIlIllllllllIIllI */
        //   230: new             Lnet/minecraft/util/BlockPos;
        //   233: dup            
        //   234: aload           llllllllllllllIlIlIlllllllIlIIlI
        //   236: invokespecial   net/minecraft/util/BlockPos.<init>:(Lnet/minecraft/entity/Entity;)V
        //   239: invokevirtual   net/minecraft/world/World.getDifficultyForLocation:(Lnet/minecraft/util/BlockPos;)Lnet/minecraft/world/DifficultyInstance;
        //   242: aload           llllllllllllllIlIlIlllllllIlllII
        //   244: invokevirtual   net/minecraft/entity/EntityLiving.func_180482_a:(Lnet/minecraft/world/DifficultyInstance;Lnet/minecraft/entity/IEntityLivingData;)Lnet/minecraft/entity/IEntityLivingData;
        //   247: astore          llllllllllllllIlIlIlllllllIlllII
        //   249: iconst_1       
        //   250: istore          llllllllllllllIlIlIlllllllIlIllI
        //   252: iload           llllllllllllllIlIlIlllllllIllIll
        //   254: aload           llllllllllllllIlIlIllllllllIIIII
        //   256: iconst_5       
        //   257: invokevirtual   java/util/Random.nextInt:(I)I
        //   260: aload           llllllllllllllIlIlIllllllllIIIII
        //   262: iconst_5       
        //   263: invokevirtual   java/util/Random.nextInt:(I)I
        //   266: isub           
        //   267: iadd           
        //   268: istore          llllllllllllllIlIlIlllllllIllIll
        //   270: iload           llllllllllllllIlIlIlllllllIllIlI
        //   272: aload           llllllllllllllIlIlIllllllllIIIII
        //   274: iconst_5       
        //   275: invokevirtual   java/util/Random.nextInt:(I)I
        //   278: aload           llllllllllllllIlIlIllllllllIIIII
        //   280: iconst_5       
        //   281: invokevirtual   java/util/Random.nextInt:(I)I
        //   284: isub           
        //   285: iadd           
        //   286: istore          llllllllllllllIlIlIlllllllIllIlI
        //   288: goto            327
        //   291: iload           llllllllllllllIlIlIlllllllIllIIl
        //   293: aload           llllllllllllllIlIlIllllllllIIIII
        //   295: iconst_5       
        //   296: invokevirtual   java/util/Random.nextInt:(I)I
        //   299: iadd           
        //   300: aload           llllllllllllllIlIlIllllllllIIIII
        //   302: iconst_5       
        //   303: invokevirtual   java/util/Random.nextInt:(I)I
        //   306: isub           
        //   307: istore          llllllllllllllIlIlIlllllllIllIll
        //   309: iload           llllllllllllllIlIlIlllllllIllIII
        //   311: aload           llllllllllllllIlIlIllllllllIIIII
        //   313: iconst_5       
        //   314: invokevirtual   java/util/Random.nextInt:(I)I
        //   317: iadd           
        //   318: aload           llllllllllllllIlIlIllllllllIIIII
        //   320: iconst_5       
        //   321: invokevirtual   java/util/Random.nextInt:(I)I
        //   324: isub           
        //   325: istore          llllllllllllllIlIlIlllllllIllIlI
        //   327: iload           llllllllllllllIlIlIlllllllIllIll
        //   329: iload_2         /* llllllllllllllIlIlIllllllllIIlII */
        //   330: if_icmplt       291
        //   333: iload           llllllllllllllIlIlIlllllllIllIll
        //   335: iload_2         /* llllllllllllllIlIlIllllllllIIlII */
        //   336: iload           llllllllllllllIlIlIlllllllIIllII
        //   338: iadd           
        //   339: if_icmpge       291
        //   342: iload           llllllllllllllIlIlIlllllllIllIlI
        //   344: iload_3         /* llllllllllllllIlIlIllllllllIIIll */
        //   345: if_icmplt       291
        //   348: iload           llllllllllllllIlIlIlllllllIllIlI
        //   350: iload_3         /* llllllllllllllIlIlIllllllllIIIll */
        //   351: iload           llllllllllllllIlIlIlllllllIIllII
        //   353: iadd           
        //   354: if_icmpge       291
        //   357: iinc            llllllllllllllIlIlIlllllllIlIlIl, 1
        //   360: iload           llllllllllllllIlIlIlllllllIlIllI
        //   362: ifne            371
        //   365: iload           llllllllllllllIlIlIlllllllIlIlIl
        //   367: iconst_4       
        //   368: if_icmplt       110
        //   371: iinc            llllllllllllllIlIlIlllllllIlIlll, 1
        //   374: iload           llllllllllllllIlIlIlllllllIlIlll
        //   376: iload           llllllllllllllIlIlIlllllllIlllIl
        //   378: if_icmplt       101
        //   381: aload           llllllllllllllIlIlIllllllllIIIII
        //   383: invokevirtual   java/util/Random.nextFloat:()F
        //   386: aload_1         /* llllllllllllllIlIlIllllllllIIlIl */
        //   387: invokevirtual   net/minecraft/world/biome/BiomeGenBase.getSpawningChance:()F
        //   390: fcmpg          
        //   391: iflt            22
        //   394: return         
        //    StackMapTable: 00 0E FC 00 16 07 00 29 FF 00 4E 00 10 07 00 2F 07 00 12 01 01 01 01 07 00 3F 07 00 29 07 00 10 01 07 00 C5 01 01 01 01 01 00 00 FD 00 08 01 01 FF 00 41 00 13 07 00 2F 07 00 12 01 01 01 01 07 00 3F 07 00 29 07 00 10 01 07 00 C5 01 01 01 01 01 01 01 07 00 45 00 01 07 00 1D FC 00 09 07 00 0D FA 00 41 26 23 1D FA 00 02 0A F9 00 02 FF 00 06 00 08 07 00 2F 07 00 12 01 01 01 01 07 00 3F 07 00 29 00 00 0C
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  140    173    176    186    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2895)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at us.deathmarine.luyten.FileSaver.doSaveJarDecompiled(FileSaver.java:192)
        //     at us.deathmarine.luyten.FileSaver.access$300(FileSaver.java:45)
        //     at us.deathmarine.luyten.FileSaver$4.run(FileSaver.java:112)
        //     at java.lang.Thread.run(Unknown Source)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    protected static BlockPos func_180621_a(final World llllllllllllllIlIllIIIIIIIIllIII, final int llllllllllllllIlIllIIIIIIIIlIlll, final int llllllllllllllIlIllIIIIIIIIllllI) {
        final Chunk llllllllllllllIlIllIIIIIIIIlllIl = llllllllllllllIlIllIIIIIIIIllIII.getChunkFromChunkCoords(llllllllllllllIlIllIIIIIIIIlIlll, llllllllllllllIlIllIIIIIIIIllllI);
        final int llllllllllllllIlIllIIIIIIIIlllII = llllllllllllllIlIllIIIIIIIIlIlll * 16 + llllllllllllllIlIllIIIIIIIIllIII.rand.nextInt(16);
        final int llllllllllllllIlIllIIIIIIIIllIll = llllllllllllllIlIllIIIIIIIIllllI * 16 + llllllllllllllIlIllIIIIIIIIllIII.rand.nextInt(16);
        final int llllllllllllllIlIllIIIIIIIIllIlI = MathHelper.func_154354_b(llllllllllllllIlIllIIIIIIIIlllIl.getHeight(new BlockPos(llllllllllllllIlIllIIIIIIIIlllII, 0, llllllllllllllIlIllIIIIIIIIllIll)) + 1, 16);
        final int llllllllllllllIlIllIIIIIIIIllIIl = llllllllllllllIlIllIIIIIIIIllIII.rand.nextInt((llllllllllllllIlIllIIIIIIIIllIlI > 0) ? llllllllllllllIlIllIIIIIIIIllIlI : (llllllllllllllIlIllIIIIIIIIlllIl.getTopFilledSegment() + 16 - 1));
        return new BlockPos(llllllllllllllIlIllIIIIIIIIlllII, llllllllllllllIlIllIIIIIIIIllIIl, llllllllllllllIlIllIIIIIIIIllIll);
    }
    
    static {
        __OBFID = "CL_00000152";
        field_180268_a = (int)Math.pow(17.0, 2.0);
    }
    
    public static boolean func_180267_a(final EntityLiving.SpawnPlacementType llllllllllllllIlIllIIIIIIIIIIIlI, final World llllllllllllllIlIllIIIIIIIIIIIIl, final BlockPos llllllllllllllIlIllIIIIIIIIIIIII) {
        if (!llllllllllllllIlIllIIIIIIIIIIIIl.getWorldBorder().contains(llllllllllllllIlIllIIIIIIIIIIIII)) {
            return false;
        }
        final Block llllllllllllllIlIllIIIIIIIIIIllI = llllllllllllllIlIllIIIIIIIIIIIIl.getBlockState(llllllllllllllIlIllIIIIIIIIIIIII).getBlock();
        if (llllllllllllllIlIllIIIIIIIIIIIlI == EntityLiving.SpawnPlacementType.IN_WATER) {
            return llllllllllllllIlIllIIIIIIIIIIllI.getMaterial().isLiquid() && llllllllllllllIlIllIIIIIIIIIIIIl.getBlockState(llllllllllllllIlIllIIIIIIIIIIIII.offsetDown()).getBlock().getMaterial().isLiquid() && !llllllllllllllIlIllIIIIIIIIIIIIl.getBlockState(llllllllllllllIlIllIIIIIIIIIIIII.offsetUp()).getBlock().isNormalCube();
        }
        final BlockPos llllllllllllllIlIllIIIIIIIIIIlIl = llllllllllllllIlIllIIIIIIIIIIIII.offsetDown();
        if (!World.doesBlockHaveSolidTopSurface(llllllllllllllIlIllIIIIIIIIIIIIl, llllllllllllllIlIllIIIIIIIIIIlIl)) {
            return false;
        }
        final Block llllllllllllllIlIllIIIIIIIIIIlII = llllllllllllllIlIllIIIIIIIIIIIIl.getBlockState(llllllllllllllIlIllIIIIIIIIIIlIl).getBlock();
        final boolean llllllllllllllIlIllIIIIIIIIIIIll = llllllllllllllIlIllIIIIIIIIIIlII != Blocks.bedrock && llllllllllllllIlIllIIIIIIIIIIlII != Blocks.barrier;
        return llllllllllllllIlIllIIIIIIIIIIIll && !llllllllllllllIlIllIIIIIIIIIIllI.isNormalCube() && !llllllllllllllIlIllIIIIIIIIIIllI.getMaterial().isLiquid() && !llllllllllllllIlIllIIIIIIIIIIIIl.getBlockState(llllllllllllllIlIllIIIIIIIIIIIII.offsetUp()).getBlock().isNormalCube();
    }
    
    public SpawnerAnimals() {
        this.eligibleChunksForSpawning = Sets.newHashSet();
    }
    
    public int findChunksForSpawning(final WorldServer llllllllllllllIlIllIIIIIIllllIII, final boolean llllllllllllllIlIllIIIIIIlIIlIlI, final boolean llllllllllllllIlIllIIIIIIlIIlIIl, final boolean llllllllllllllIlIllIIIIIIlIIlIII) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ifne            10
        //     4: iload_3         /* llllllllllllllIlIllIIIIIIlllIllI */
        //     5: ifne            10
        //     8: iconst_0       
        //     9: ireturn        
        //    10: aload_0         /* llllllllllllllIlIllIIIIIIllllIIl */
        //    11: getfield        net/minecraft/world/SpawnerAnimals.eligibleChunksForSpawning:Ljava/util/Set;
        //    14: invokeinterface java/util/Set.clear:()V
        //    19: iconst_0       
        //    20: istore          llllllllllllllIlIllIIIIIIlllIlII
        //    22: aload_1         /* llllllllllllllIlIllIIIIIIlIIlIll */
        //    23: getfield        net/minecraft/world/WorldServer.playerEntities:Ljava/util/List;
        //    26: invokeinterface java/util/List.iterator:()Ljava/util/Iterator;
        //    31: astore          llllllllllllllIlIllIIIIIIlllIIll
        //    33: goto            226
        //    36: aload           llllllllllllllIlIllIIIIIIlllIIll
        //    38: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    43: checkcast       Lnet/minecraft/entity/player/EntityPlayer;
        //    46: astore          llllllllllllllIlIllIIIIIIllIlllI
        //    48: aload           llllllllllllllIlIllIIIIIIllIlllI
        //    50: invokevirtual   net/minecraft/entity/player/EntityPlayer.func_175149_v:()Z
        //    53: ifne            226
        //    56: aload           llllllllllllllIlIllIIIIIIllIlllI
        //    58: getfield        net/minecraft/entity/player/EntityPlayer.posX:D
        //    61: ldc2_w          16.0
        //    64: ddiv           
        //    65: invokestatic    net/minecraft/util/MathHelper.floor_double:(D)I
        //    68: istore          llllllllllllllIlIllIIIIIIllIllIl
        //    70: aload           llllllllllllllIlIllIIIIIIllIlllI
        //    72: getfield        net/minecraft/entity/player/EntityPlayer.posZ:D
        //    75: ldc2_w          16.0
        //    78: ddiv           
        //    79: invokestatic    net/minecraft/util/MathHelper.floor_double:(D)I
        //    82: istore          llllllllllllllIlIllIIIIIIlllIIlI
        //    84: bipush          8
        //    86: istore          llllllllllllllIlIllIIIIIIllIllII
        //    88: iload           llllllllllllllIlIllIIIIIIllIllII
        //    90: ineg           
        //    91: istore          llllllllllllllIlIllIIIIIIllIlIll
        //    93: goto            219
        //    96: iload           llllllllllllllIlIllIIIIIIllIllII
        //    98: ineg           
        //    99: istore          llllllllllllllIlIllIIIIIIlllIIII
        //   101: goto            209
        //   104: iload           llllllllllllllIlIllIIIIIIllIlIll
        //   106: iload           llllllllllllllIlIllIIIIIIllIllII
        //   108: ineg           
        //   109: if_icmpeq       138
        //   112: iload           llllllllllllllIlIllIIIIIIllIlIll
        //   114: iload           llllllllllllllIlIllIIIIIIllIllII
        //   116: if_icmpeq       138
        //   119: iload           llllllllllllllIlIllIIIIIIlllIIII
        //   121: iload           llllllllllllllIlIllIIIIIIllIllII
        //   123: ineg           
        //   124: if_icmpeq       138
        //   127: iload           llllllllllllllIlIllIIIIIIlllIIII
        //   129: iload           llllllllllllllIlIllIIIIIIllIllII
        //   131: if_icmpeq       138
        //   134: iconst_0       
        //   135: goto            139
        //   138: iconst_1       
        //   139: istore          llllllllllllllIlIllIIIIIIllIlIlI
        //   141: new             Lnet/minecraft/world/ChunkCoordIntPair;
        //   144: dup            
        //   145: iload           llllllllllllllIlIllIIIIIIllIlIll
        //   147: iload           llllllllllllllIlIllIIIIIIllIllIl
        //   149: iadd           
        //   150: iload           llllllllllllllIlIllIIIIIIlllIIII
        //   152: iload           llllllllllllllIlIllIIIIIIlllIIlI
        //   154: iadd           
        //   155: invokespecial   net/minecraft/world/ChunkCoordIntPair.<init>:(II)V
        //   158: astore          llllllllllllllIlIllIIIIIIllIlIIl
        //   160: aload_0         /* llllllllllllllIlIllIIIIIIllllIIl */
        //   161: getfield        net/minecraft/world/SpawnerAnimals.eligibleChunksForSpawning:Ljava/util/Set;
        //   164: aload           llllllllllllllIlIllIIIIIIllIlIIl
        //   166: invokeinterface java/util/Set.contains:(Ljava/lang/Object;)Z
        //   171: ifne            206
        //   174: iinc            llllllllllllllIlIllIIIIIIlllIlII, 1
        //   177: iload           llllllllllllllIlIllIIIIIIllIlIlI
        //   179: ifne            206
        //   182: aload_1         /* llllllllllllllIlIllIIIIIIlIIlIll */
        //   183: invokevirtual   net/minecraft/world/WorldServer.getWorldBorder:()Lnet/minecraft/world/border/WorldBorder;
        //   186: aload           llllllllllllllIlIllIIIIIIllIlIIl
        //   188: invokevirtual   net/minecraft/world/border/WorldBorder.contains:(Lnet/minecraft/world/ChunkCoordIntPair;)Z
        //   191: ifeq            206
        //   194: aload_0         /* llllllllllllllIlIllIIIIIIllllIIl */
        //   195: getfield        net/minecraft/world/SpawnerAnimals.eligibleChunksForSpawning:Ljava/util/Set;
        //   198: aload           llllllllllllllIlIllIIIIIIllIlIIl
        //   200: invokeinterface java/util/Set.add:(Ljava/lang/Object;)Z
        //   205: pop            
        //   206: iinc            llllllllllllllIlIllIIIIIIlllIIII, 1
        //   209: iload           llllllllllllllIlIllIIIIIIlllIIII
        //   211: iload           llllllllllllllIlIllIIIIIIllIllII
        //   213: if_icmple       104
        //   216: iinc            llllllllllllllIlIllIIIIIIllIlIll, 1
        //   219: iload           llllllllllllllIlIllIIIIIIllIlIll
        //   221: iload           llllllllllllllIlIllIIIIIIllIllII
        //   223: if_icmple       96
        //   226: aload           llllllllllllllIlIllIIIIIIlllIIll
        //   228: invokeinterface java/util/Iterator.hasNext:()Z
        //   233: ifne            36
        //   236: iconst_0       
        //   237: istore          llllllllllllllIlIllIIIIIIllIlIII
        //   239: aload_1         /* llllllllllllllIlIllIIIIIIlIIlIll */
        //   240: invokevirtual   net/minecraft/world/WorldServer.getSpawnPoint:()Lnet/minecraft/util/BlockPos;
        //   243: astore          llllllllllllllIlIllIIIIIIllIIlll
        //   245: invokestatic    net/minecraft/entity/EnumCreatureType.values:()[Lnet/minecraft/entity/EnumCreatureType;
        //   248: astore          llllllllllllllIlIllIIIIIIllIIllI
        //   250: aload           llllllllllllllIlIllIIIIIIllIIllI
        //   252: arraylength    
        //   253: istore          llllllllllllllIlIllIIIIIIlllIIIl
        //   255: iconst_0       
        //   256: istore          llllllllllllllIlIllIIIIIIllIIlIl
        //   258: goto            830
        //   261: aload           llllllllllllllIlIllIIIIIIllIIllI
        //   263: iload           llllllllllllllIlIllIIIIIIllIIlIl
        //   265: aaload         
        //   266: astore          llllllllllllllIlIllIIIIIIllIIlII
        //   268: aload           llllllllllllllIlIllIIIIIIllIIlII
        //   270: invokevirtual   net/minecraft/entity/EnumCreatureType.getPeacefulCreature:()Z
        //   273: ifeq            280
        //   276: iload_3         /* llllllllllllllIlIllIIIIIIlllIllI */
        //   277: ifeq            827
        //   280: aload           llllllllllllllIlIllIIIIIIllIIlII
        //   282: invokevirtual   net/minecraft/entity/EnumCreatureType.getPeacefulCreature:()Z
        //   285: ifne            292
        //   288: iload_2         /* llllllllllllllIlIllIIIIIIlllIlll */
        //   289: ifeq            827
        //   292: aload           llllllllllllllIlIllIIIIIIllIIlII
        //   294: invokevirtual   net/minecraft/entity/EnumCreatureType.getAnimal:()Z
        //   297: ifeq            305
        //   300: iload           llllllllllllllIlIllIIIIIIlllIlIl
        //   302: ifeq            827
        //   305: aload_1         /* llllllllllllllIlIllIIIIIIlIIlIll */
        //   306: aload           llllllllllllllIlIllIIIIIIllIIlII
        //   308: invokevirtual   net/minecraft/entity/EnumCreatureType.getCreatureClass:()Ljava/lang/Class;
        //   311: invokevirtual   net/minecraft/world/WorldServer.countEntities:(Ljava/lang/Class;)I
        //   314: istore          llllllllllllllIlIllIIIIIIllIllll
        //   316: aload           llllllllllllllIlIllIIIIIIllIIlII
        //   318: invokevirtual   net/minecraft/entity/EnumCreatureType.getMaxNumberOfCreature:()I
        //   321: iload           llllllllllllllIlIllIIIIIIlllIlII
        //   323: imul           
        //   324: getstatic       net/minecraft/world/SpawnerAnimals.field_180268_a:I
        //   327: idiv           
        //   328: istore          llllllllllllllIlIllIIIIIIllIIIll
        //   330: iload           llllllllllllllIlIllIIIIIIllIllll
        //   332: iload           llllllllllllllIlIllIIIIIIllIIIll
        //   334: if_icmpgt       827
        //   337: aload_0         /* llllllllllllllIlIllIIIIIIllllIIl */
        //   338: getfield        net/minecraft/world/SpawnerAnimals.eligibleChunksForSpawning:Ljava/util/Set;
        //   341: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //   346: astore          llllllllllllllIlIllIIIIIIllIIIlI
        //   348: goto            817
        //   351: aload           llllllllllllllIlIllIIIIIIllIIIlI
        //   353: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   358: checkcast       Lnet/minecraft/world/ChunkCoordIntPair;
        //   361: astore          llllllllllllllIlIllIIIIIIllIIIIl
        //   363: aload_1         /* llllllllllllllIlIllIIIIIIlIIlIll */
        //   364: aload           llllllllllllllIlIllIIIIIIllIIIIl
        //   366: getfield        net/minecraft/world/ChunkCoordIntPair.chunkXPos:I
        //   369: aload           llllllllllllllIlIllIIIIIIllIIIIl
        //   371: getfield        net/minecraft/world/ChunkCoordIntPair.chunkZPos:I
        //   374: invokestatic    net/minecraft/world/SpawnerAnimals.func_180621_a:(Lnet/minecraft/world/World;II)Lnet/minecraft/util/BlockPos;
        //   377: astore          llllllllllllllIlIllIIIIIIllIIIII
        //   379: aload           llllllllllllllIlIllIIIIIIllIIIII
        //   381: invokevirtual   net/minecraft/util/BlockPos.getX:()I
        //   384: istore          llllllllllllllIlIllIIIIIIlIlllll
        //   386: aload           llllllllllllllIlIllIIIIIIllIIIII
        //   388: invokevirtual   net/minecraft/util/BlockPos.getY:()I
        //   391: istore          llllllllllllllIlIllIIIIIIlIllllI
        //   393: aload           llllllllllllllIlIllIIIIIIllIIIII
        //   395: invokevirtual   net/minecraft/util/BlockPos.getZ:()I
        //   398: istore          llllllllllllllIlIllIIIIIIlIlllIl
        //   400: aload_1         /* llllllllllllllIlIllIIIIIIlIIlIll */
        //   401: aload           llllllllllllllIlIllIIIIIIllIIIII
        //   403: invokevirtual   net/minecraft/world/WorldServer.getBlockState:(Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
        //   406: invokeinterface net/minecraft/block/state/IBlockState.getBlock:()Lnet/minecraft/block/Block;
        //   411: astore          llllllllllllllIlIllIIIIIIlIlllII
        //   413: aload           llllllllllllllIlIllIIIIIIlIlllII
        //   415: invokevirtual   net/minecraft/block/Block.isNormalCube:()Z
        //   418: ifne            817
        //   421: iconst_0       
        //   422: istore          llllllllllllllIlIllIIIIIIlIllIll
        //   424: iconst_0       
        //   425: istore          llllllllllllllIlIllIIIIIIlIllIlI
        //   427: goto            811
        //   430: iload           llllllllllllllIlIllIIIIIIlIlllll
        //   432: istore          llllllllllllllIlIllIIIIIIlIllIIl
        //   434: iload           llllllllllllllIlIllIIIIIIlIllllI
        //   436: istore          llllllllllllllIlIllIIIIIIlIllIII
        //   438: iload           llllllllllllllIlIllIIIIIIlIlllIl
        //   440: istore          llllllllllllllIlIllIIIIIIlIlIlll
        //   442: bipush          6
        //   444: istore          llllllllllllllIlIllIIIIIIlIlIllI
        //   446: aconst_null    
        //   447: astore          llllllllllllllIlIllIIIIIIlIlIlIl
        //   449: aconst_null    
        //   450: astore          llllllllllllllIlIllIIIIIIlIlIlII
        //   452: iconst_0       
        //   453: istore          llllllllllllllIlIllIIIIIIlIlIIll
        //   455: iload           llllllllllllllIlIllIIIIIIlIlIIll
        //   457: iconst_4       
        //   458: if_icmpge       808
        //   461: iload           llllllllllllllIlIllIIIIIIlIllIIl
        //   463: aload_1         /* llllllllllllllIlIllIIIIIIlIIlIll */
        //   464: getfield        net/minecraft/world/WorldServer.rand:Ljava/util/Random;
        //   467: iload           llllllllllllllIlIllIIIIIIlIlIllI
        //   469: invokevirtual   java/util/Random.nextInt:(I)I
        //   472: aload_1         /* llllllllllllllIlIllIIIIIIlIIlIll */
        //   473: getfield        net/minecraft/world/WorldServer.rand:Ljava/util/Random;
        //   476: iload           llllllllllllllIlIllIIIIIIlIlIllI
        //   478: invokevirtual   java/util/Random.nextInt:(I)I
        //   481: isub           
        //   482: iadd           
        //   483: istore          llllllllllllllIlIllIIIIIIlIllIIl
        //   485: iload           llllllllllllllIlIllIIIIIIlIllIII
        //   487: aload_1         /* llllllllllllllIlIllIIIIIIlIIlIll */
        //   488: getfield        net/minecraft/world/WorldServer.rand:Ljava/util/Random;
        //   491: iconst_1       
        //   492: invokevirtual   java/util/Random.nextInt:(I)I
        //   495: aload_1         /* llllllllllllllIlIllIIIIIIlIIlIll */
        //   496: getfield        net/minecraft/world/WorldServer.rand:Ljava/util/Random;
        //   499: iconst_1       
        //   500: invokevirtual   java/util/Random.nextInt:(I)I
        //   503: isub           
        //   504: iadd           
        //   505: istore          llllllllllllllIlIllIIIIIIlIllIII
        //   507: iload           llllllllllllllIlIllIIIIIIlIlIlll
        //   509: aload_1         /* llllllllllllllIlIllIIIIIIlIIlIll */
        //   510: getfield        net/minecraft/world/WorldServer.rand:Ljava/util/Random;
        //   513: iload           llllllllllllllIlIllIIIIIIlIlIllI
        //   515: invokevirtual   java/util/Random.nextInt:(I)I
        //   518: aload_1         /* llllllllllllllIlIllIIIIIIlIIlIll */
        //   519: getfield        net/minecraft/world/WorldServer.rand:Ljava/util/Random;
        //   522: iload           llllllllllllllIlIllIIIIIIlIlIllI
        //   524: invokevirtual   java/util/Random.nextInt:(I)I
        //   527: isub           
        //   528: iadd           
        //   529: istore          llllllllllllllIlIllIIIIIIlIlIlll
        //   531: new             Lnet/minecraft/util/BlockPos;
        //   534: dup            
        //   535: iload           llllllllllllllIlIllIIIIIIlIllIIl
        //   537: iload           llllllllllllllIlIllIIIIIIlIllIII
        //   539: iload           llllllllllllllIlIllIIIIIIlIlIlll
        //   541: invokespecial   net/minecraft/util/BlockPos.<init>:(III)V
        //   544: astore          llllllllllllllIlIllIIIIIIlIlIIlI
        //   546: iload           llllllllllllllIlIllIIIIIIlIllIIl
        //   548: i2f            
        //   549: ldc             0.5
        //   551: fadd           
        //   552: fstore          llllllllllllllIlIllIIIIIIlIlIIIl
        //   554: iload           llllllllllllllIlIllIIIIIIlIlIlll
        //   556: i2f            
        //   557: ldc             0.5
        //   559: fadd           
        //   560: fstore          llllllllllllllIlIllIIIIIIlIlIIII
        //   562: aload_1         /* llllllllllllllIlIllIIIIIIlIIlIll */
        //   563: fload           llllllllllllllIlIllIIIIIIlIlIIIl
        //   565: f2d            
        //   566: iload           llllllllllllllIlIllIIIIIIlIllIII
        //   568: i2d            
        //   569: fload           llllllllllllllIlIllIIIIIIlIlIIII
        //   571: f2d            
        //   572: ldc2_w          24.0
        //   575: invokevirtual   net/minecraft/world/WorldServer.func_175636_b:(DDDD)Z
        //   578: ifne            802
        //   581: aload           llllllllllllllIlIllIIIIIIllIIlll
        //   583: fload           llllllllllllllIlIllIIIIIIlIlIIIl
        //   585: f2d            
        //   586: iload           llllllllllllllIlIllIIIIIIlIllIII
        //   588: i2d            
        //   589: fload           llllllllllllllIlIllIIIIIIlIlIIII
        //   591: f2d            
        //   592: invokevirtual   net/minecraft/util/BlockPos.distanceSq:(DDD)D
        //   595: ldc2_w          576.0
        //   598: dcmpl          
        //   599: iflt            802
        //   602: aload           llllllllllllllIlIllIIIIIIlIlIlIl
        //   604: ifnonnull       625
        //   607: aload_1         /* llllllllllllllIlIllIIIIIIlIIlIll */
        //   608: aload           llllllllllllllIlIllIIIIIIllIIlII
        //   610: aload           llllllllllllllIlIllIIIIIIlIlIIlI
        //   612: invokevirtual   net/minecraft/world/WorldServer.func_175734_a:(Lnet/minecraft/entity/EnumCreatureType;Lnet/minecraft/util/BlockPos;)Lnet/minecraft/world/biome/BiomeGenBase$SpawnListEntry;
        //   615: astore          llllllllllllllIlIllIIIIIIlIlIlIl
        //   617: aload           llllllllllllllIlIllIIIIIIlIlIlIl
        //   619: ifnonnull       625
        //   622: goto            808
        //   625: aload_1         /* llllllllllllllIlIllIIIIIIlIIlIll */
        //   626: aload           llllllllllllllIlIllIIIIIIllIIlII
        //   628: aload           llllllllllllllIlIllIIIIIIlIlIlIl
        //   630: aload           llllllllllllllIlIllIIIIIIlIlIIlI
        //   632: invokevirtual   net/minecraft/world/WorldServer.func_175732_a:(Lnet/minecraft/entity/EnumCreatureType;Lnet/minecraft/world/biome/BiomeGenBase$SpawnListEntry;Lnet/minecraft/util/BlockPos;)Z
        //   635: ifeq            802
        //   638: aload           llllllllllllllIlIllIIIIIIlIlIlIl
        //   640: getfield        net/minecraft/world/biome/BiomeGenBase$SpawnListEntry.entityClass:Ljava/lang/Class;
        //   643: invokestatic    net/minecraft/entity/EntitySpawnPlacementRegistry.func_180109_a:(Ljava/lang/Class;)Lnet/minecraft/entity/EntityLiving$SpawnPlacementType;
        //   646: aload_1         /* llllllllllllllIlIllIIIIIIlIIlIll */
        //   647: aload           llllllllllllllIlIllIIIIIIlIlIIlI
        //   649: invokestatic    net/minecraft/world/SpawnerAnimals.func_180267_a:(Lnet/minecraft/entity/EntityLiving$SpawnPlacementType;Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;)Z
        //   652: ifeq            802
        //   655: aload           llllllllllllllIlIllIIIIIIlIlIlIl
        //   657: getfield        net/minecraft/world/biome/BiomeGenBase$SpawnListEntry.entityClass:Ljava/lang/Class;
        //   660: iconst_1       
        //   661: anewarray       Ljava/lang/Class;
        //   664: dup            
        //   665: iconst_0       
        //   666: ldc             Lnet/minecraft/world/World;.class
        //   668: aastore        
        //   669: invokevirtual   java/lang/Class.getConstructor:([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
        //   672: iconst_1       
        //   673: anewarray       Ljava/lang/Object;
        //   676: dup            
        //   677: iconst_0       
        //   678: aload_1         /* llllllllllllllIlIllIIIIIIlIIlIll */
        //   679: aastore        
        //   680: invokevirtual   java/lang/reflect/Constructor.newInstance:([Ljava/lang/Object;)Ljava/lang/Object;
        //   683: checkcast       Lnet/minecraft/entity/EntityLiving;
        //   686: astore          llllllllllllllIlIllIIIIIIlIIllll
        //   688: goto            701
        //   691: astore          llllllllllllllIlIllIIIIIIlIIllIl
        //   693: aload           llllllllllllllIlIllIIIIIIlIIllIl
        //   695: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   698: iload           llllllllllllllIlIllIIIIIIllIlIII
        //   700: ireturn        
        //   701: aload           llllllllllllllIlIllIIIIIIlIIlllI
        //   703: fload           llllllllllllllIlIllIIIIIIlIlIIIl
        //   705: f2d            
        //   706: iload           llllllllllllllIlIllIIIIIIlIllIII
        //   708: i2d            
        //   709: fload           llllllllllllllIlIllIIIIIIlIlIIII
        //   711: f2d            
        //   712: aload_1         /* llllllllllllllIlIllIIIIIIlIIlIll */
        //   713: getfield        net/minecraft/world/WorldServer.rand:Ljava/util/Random;
        //   716: invokevirtual   java/util/Random.nextFloat:()F
        //   719: ldc             360.0
        //   721: fmul           
        //   722: fconst_0       
        //   723: invokevirtual   net/minecraft/entity/EntityLiving.setLocationAndAngles:(DDDFF)V
        //   726: aload           llllllllllllllIlIllIIIIIIlIIlllI
        //   728: invokevirtual   net/minecraft/entity/EntityLiving.getCanSpawnHere:()Z
        //   731: ifeq            795
        //   734: aload           llllllllllllllIlIllIIIIIIlIIlllI
        //   736: invokevirtual   net/minecraft/entity/EntityLiving.handleLavaMovement:()Z
        //   739: ifeq            795
        //   742: aload           llllllllllllllIlIllIIIIIIlIIlllI
        //   744: aload_1         /* llllllllllllllIlIllIIIIIIlIIlIll */
        //   745: new             Lnet/minecraft/util/BlockPos;
        //   748: dup            
        //   749: aload           llllllllllllllIlIllIIIIIIlIIlllI
        //   751: invokespecial   net/minecraft/util/BlockPos.<init>:(Lnet/minecraft/entity/Entity;)V
        //   754: invokevirtual   net/minecraft/world/WorldServer.getDifficultyForLocation:(Lnet/minecraft/util/BlockPos;)Lnet/minecraft/world/DifficultyInstance;
        //   757: aload           llllllllllllllIlIllIIIIIIlIlIlII
        //   759: invokevirtual   net/minecraft/entity/EntityLiving.func_180482_a:(Lnet/minecraft/world/DifficultyInstance;Lnet/minecraft/entity/IEntityLivingData;)Lnet/minecraft/entity/IEntityLivingData;
        //   762: astore          llllllllllllllIlIllIIIIIIlIlIlII
        //   764: aload           llllllllllllllIlIllIIIIIIlIIlllI
        //   766: invokevirtual   net/minecraft/entity/EntityLiving.handleLavaMovement:()Z
        //   769: ifeq            782
        //   772: iinc            llllllllllllllIlIllIIIIIIlIllIll, 1
        //   775: aload_1         /* llllllllllllllIlIllIIIIIIlIIlIll */
        //   776: aload           llllllllllllllIlIllIIIIIIlIIlllI
        //   778: invokevirtual   net/minecraft/world/WorldServer.spawnEntityInWorld:(Lnet/minecraft/entity/Entity;)Z
        //   781: pop            
        //   782: iload           llllllllllllllIlIllIIIIIIlIllIll
        //   784: aload           llllllllllllllIlIllIIIIIIlIIlllI
        //   786: invokevirtual   net/minecraft/entity/EntityLiving.getMaxSpawnedInChunk:()I
        //   789: if_icmplt       795
        //   792: goto            817
        //   795: iload           llllllllllllllIlIllIIIIIIllIlIII
        //   797: iload           llllllllllllllIlIllIIIIIIlIllIll
        //   799: iadd           
        //   800: istore          llllllllllllllIlIllIIIIIIllIlIII
        //   802: iinc            llllllllllllllIlIllIIIIIIlIlIIll, 1
        //   805: goto            455
        //   808: iinc            llllllllllllllIlIllIIIIIIlIllIlI, 1
        //   811: iload           llllllllllllllIlIllIIIIIIlIllIlI
        //   813: iconst_3       
        //   814: if_icmplt       430
        //   817: aload           llllllllllllllIlIllIIIIIIllIIIlI
        //   819: invokeinterface java/util/Iterator.hasNext:()Z
        //   824: ifne            351
        //   827: iinc            llllllllllllllIlIllIIIIIIllIIlIl, 1
        //   830: iload           llllllllllllllIlIllIIIIIIllIIlIl
        //   832: iload           llllllllllllllIlIllIIIIIIlllIIIl
        //   834: if_icmplt       261
        //   837: iload           llllllllllllllIlIllIIIIIIllIlIII
        //   839: ireturn        
        //    StackMapTable: 00 1C 0A FD 00 19 01 07 01 62 FF 00 3B 00 0D 07 00 02 07 01 59 01 01 01 01 07 01 62 01 00 07 01 68 01 01 01 00 00 FF 00 07 00 0D 07 00 02 07 01 59 01 01 01 01 07 01 62 01 01 07 01 68 01 01 01 00 00 21 40 01 FD 00 42 01 07 01 79 F9 00 02 FF 00 09 00 0D 07 00 02 07 01 59 01 01 01 01 07 01 62 01 00 07 01 68 01 01 01 00 00 FF 00 06 00 07 07 00 02 07 01 59 01 01 01 01 07 01 62 00 00 FF 00 22 00 0D 07 00 02 07 01 59 01 01 01 01 07 01 62 01 00 01 07 00 45 07 02 2E 01 00 00 FC 00 12 07 00 1F 0B 0C FF 00 2D 00 10 07 00 02 07 01 59 01 01 01 01 07 01 62 01 01 01 07 00 45 07 02 2E 01 07 00 1F 01 07 01 62 00 00 FF 00 4E 00 18 07 00 02 07 01 59 01 01 01 01 07 01 62 01 01 01 07 00 45 07 02 2E 01 07 00 1F 01 07 01 62 07 01 79 07 00 45 01 01 01 07 01 15 01 01 00 00 FF 00 18 00 1F 07 00 02 07 01 59 01 01 01 01 07 01 62 01 01 01 07 00 45 07 02 2E 01 07 00 1F 01 07 01 62 07 01 79 07 00 45 01 01 01 07 01 15 01 01 01 01 01 01 07 00 10 07 00 C5 01 00 00 FE 00 A9 07 00 45 02 02 F7 00 41 07 00 1D FC 00 09 07 00 0D FB 00 50 0C FA 00 06 F8 00 05 FF 00 02 00 18 07 00 02 07 01 59 01 01 01 01 07 01 62 01 01 01 07 00 45 07 02 2E 01 07 00 1F 01 07 01 62 07 01 79 07 00 45 01 01 01 07 01 15 01 01 00 00 FF 00 05 00 10 07 00 02 07 01 59 01 01 01 01 07 01 62 01 01 01 07 00 45 07 02 2E 01 07 00 1F 01 07 01 62 00 00 FF 00 09 00 0E 07 00 02 07 01 59 01 01 01 01 07 01 62 01 00 01 07 00 45 07 02 2E 01 07 00 1F 00 00 FA 00 02
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  655    688    691    701    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
}
