package optifine;

import java.lang.reflect.*;

public class ReflectorField
{
    private /* synthetic */ boolean checked;
    private /* synthetic */ Field targetField;
    private /* synthetic */ String targetFieldName;
    private /* synthetic */ ReflectorClass reflectorClass;
    
    public void setValue(final Object llllllllllllllIIIIIllllIIlIIlllI) {
        Reflector.setFieldValue(null, this, llllllllllllllIIIIIllllIIlIIlllI);
    }
    
    public boolean exists() {
        return this.checked ? (this.targetField != null) : (this.getTargetField() != null);
    }
    
    public ReflectorField(final ReflectorClass llllllllllllllIIIIIllllIIllIIIlI, final String llllllllllllllIIIIIllllIIllIIIIl) {
        this.reflectorClass = null;
        this.targetFieldName = null;
        this.checked = false;
        this.targetField = null;
        this.reflectorClass = llllllllllllllIIIIIllllIIllIIIlI;
        this.targetFieldName = llllllllllllllIIIIIllllIIllIIIIl;
        final Field llllllllllllllIIIIIllllIIllIIlII = this.getTargetField();
    }
    
    public Object getValue() {
        return Reflector.getFieldValue(null, this);
    }
    
    public Field getTargetField() {
        if (this.checked) {
            return this.targetField;
        }
        this.checked = true;
        final Class llllllllllllllIIIIIllllIIlIllIll = this.reflectorClass.getTargetClass();
        if (llllllllllllllIIIIIllllIIlIllIll == null) {
            return null;
        }
        try {
            this.targetField = llllllllllllllIIIIIllllIIlIllIll.getDeclaredField(this.targetFieldName);
            this.targetField.setAccessible(true);
        }
        catch (NoSuchFieldException llllllllllllllIIIIIllllIIlIllIlI) {
            Config.log(String.valueOf(new StringBuilder("(Reflector) Field not present: ").append(llllllllllllllIIIIIllllIIlIllIll.getName()).append(".").append(this.targetFieldName)));
        }
        catch (SecurityException llllllllllllllIIIIIllllIIlIllIIl) {
            llllllllllllllIIIIIllllIIlIllIIl.printStackTrace();
        }
        catch (Throwable llllllllllllllIIIIIllllIIlIllIII) {
            llllllllllllllIIIIIllllIIlIllIII.printStackTrace();
        }
        return this.targetField;
    }
}
