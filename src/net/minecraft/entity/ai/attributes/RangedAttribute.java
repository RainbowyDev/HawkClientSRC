package net.minecraft.entity.ai.attributes;

public class RangedAttribute extends BaseAttribute
{
    private /* synthetic */ String description;
    private final /* synthetic */ double maximumValue;
    private final /* synthetic */ double minimumValue;
    
    @Override
    public double clampValue(final double lIIIlIllllIIIl) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_0         /* lIIIlIllllIIII */
        //     2: getfield        net/minecraft/entity/ai/attributes/RangedAttribute.minimumValue:D
        //     5: aload_0         /* lIIIlIllllIIII */
        //     6: getfield        net/minecraft/entity/ai/attributes/RangedAttribute.maximumValue:D
        //     9: invokestatic    net/minecraft/util/MathHelper.clamp_double:(DDD)D
        //    12: dstore_1        /* lIIIlIlllIlllI */
        //    13: dload_1         /* lIIIlIlllIlllI */
        //    14: dreturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.ArrayIndexOutOfBoundsException: -1
        //     at java.util.ArrayList.elementData(Unknown Source)
        //     at java.util.ArrayList.get(Unknown Source)
        //     at com.strobel.assembler.ir.StackMappingVisitor.getStackValue(StackMappingVisitor.java:68)
        //     at com.strobel.decompiler.ast.AstBuilder.createModifiedStack(AstBuilder.java:2578)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2032)
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
    
    public RangedAttribute(final IAttribute lIIIllIIIIlIlI, final String lIIIllIIIIIIll, final double lIIIllIIIIIIlI, final double lIIIllIIIIIlll, final double lIIIllIIIIIIII) {
        super(lIIIllIIIIlIlI, lIIIllIIIIIIll, lIIIllIIIIIIlI);
        this.minimumValue = lIIIllIIIIIlll;
        this.maximumValue = lIIIllIIIIIIII;
        if (lIIIllIIIIIlll > lIIIllIIIIIIII) {
            throw new IllegalArgumentException("Minimum value cannot be bigger than maximum value!");
        }
        if (lIIIllIIIIIIlI < lIIIllIIIIIlll) {
            throw new IllegalArgumentException("Default value cannot be lower than minimum value!");
        }
        if (lIIIllIIIIIIlI > lIIIllIIIIIIII) {
            throw new IllegalArgumentException("Default value cannot be bigger than maximum value!");
        }
    }
    
    public RangedAttribute setDescription(final String lIIIlIllllllII) {
        this.description = lIIIlIllllllII;
        return this;
    }
    
    static {
        __OBFID = "CL_00001568";
    }
    
    public String getDescription() {
        return this.description;
    }
}
