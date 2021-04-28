package optifine;

public class ReflectorClass
{
    private /* synthetic */ boolean checked;
    private /* synthetic */ Class targetClass;
    private /* synthetic */ String targetClassName;
    
    public String getTargetClassName() {
        return this.targetClassName;
    }
    
    public ReflectorClass(final String llllllllllllllIIIIlllIIIlIlllIll) {
        this(llllllllllllllIIIIlllIIIlIlllIll, false);
    }
    
    public ReflectorMethod makeMethod(final String llllllllllllllIIIIlllIIIlIIIIllI, final Class[] llllllllllllllIIIIlllIIIlIIIIlIl) {
        return new ReflectorMethod(this, llllllllllllllIIIIlllIIIlIIIIllI, llllllllllllllIIIIlllIIIlIIIIlIl);
    }
    
    public ReflectorMethod makeMethod(final String llllllllllllllIIIIlllIIIIlllllII, final Class[] llllllllllllllIIIIlllIIIIlllIlll, final boolean llllllllllllllIIIIlllIIIIlllIllI) {
        return new ReflectorMethod(this, llllllllllllllIIIIlllIIIIlllllII, llllllllllllllIIIIlllIIIIlllIlll, llllllllllllllIIIIlllIIIIlllIllI);
    }
    
    public boolean exists() {
        return this.getTargetClass() != null;
    }
    
    public ReflectorClass(final Class llllllllllllllIIIIlllIIIlIlIllII) {
        this.targetClassName = null;
        this.checked = false;
        this.targetClass = null;
        this.targetClass = llllllllllllllIIIIlllIIIlIlIllII;
        this.targetClassName = llllllllllllllIIIIlllIIIlIlIllII.getName();
        this.checked = true;
    }
    
    public boolean isInstance(final Object llllllllllllllIIIIlllIIIlIIlIlll) {
        return this.getTargetClass() != null && this.getTargetClass().isInstance(llllllllllllllIIIIlllIIIlIIlIlll);
    }
    
    public ReflectorClass(final String llllllllllllllIIIIlllIIIlIllIlIl, final boolean llllllllllllllIIIIlllIIIlIllIlII) {
        this.targetClassName = null;
        this.checked = false;
        this.targetClass = null;
        this.targetClassName = llllllllllllllIIIIlllIIIlIllIlIl;
        if (!llllllllllllllIIIIlllIIIlIllIlII) {
            final byte llllllllllllllIIIIlllIIIlIllIIII = (byte)this.getTargetClass();
        }
    }
    
    public ReflectorMethod makeMethod(final String llllllllllllllIIIIlllIIIlIIIllIl) {
        return new ReflectorMethod(this, llllllllllllllIIIIlllIIIlIIIllIl);
    }
    
    public Class getTargetClass() {
        if (this.checked) {
            return this.targetClass;
        }
        this.checked = true;
        try {
            this.targetClass = Class.forName(this.targetClassName);
        }
        catch (ClassNotFoundException llllllllllllllIIIIlllIIIlIlIIllI) {
            Config.log(String.valueOf(new StringBuilder("(Reflector) Class not present: ").append(this.targetClassName)));
        }
        catch (Throwable llllllllllllllIIIIlllIIIlIlIIlIl) {
            llllllllllllllIIIIlllIIIlIlIIlIl.printStackTrace();
        }
        return this.targetClass;
    }
    
    public ReflectorField makeField(final String llllllllllllllIIIIlllIIIlIIlIIll) {
        return new ReflectorField(this, llllllllllllllIIIIlllIIIlIIlIIll);
    }
}
