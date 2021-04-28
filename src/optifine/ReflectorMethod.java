package optifine;

import java.lang.reflect.*;

public class ReflectorMethod
{
    private /* synthetic */ boolean checked;
    private /* synthetic */ Method targetMethod;
    private /* synthetic */ String targetMethodName;
    private /* synthetic */ ReflectorClass reflectorClass;
    private /* synthetic */ Class[] targetMethodParameterTypes;
    
    public Class getReturnType() {
        final Method llllllllllllllIIIllIlIIIIllIIIlI = this.getTargetMethod();
        return (llllllllllllllIIIllIlIIIIllIIIlI == null) ? null : llllllllllllllIIIllIlIIIIllIIIlI.getReturnType();
    }
    
    public ReflectorMethod(final ReflectorClass llllllllllllllIIIllIlIIIlIIlIlll, final String llllllllllllllIIIllIlIIIlIIllIIl) {
        this(llllllllllllllIIIllIlIIIlIIlIlll, llllllllllllllIIIllIlIIIlIIllIIl, null, false);
    }
    
    public ReflectorMethod(final ReflectorClass llllllllllllllIIIllIlIIIlIIIllII, final String llllllllllllllIIIllIlIIIlIIIlIll, final Class[] llllllllllllllIIIllIlIIIlIIIlllI) {
        this(llllllllllllllIIIllIlIIIlIIIllII, llllllllllllllIIIllIlIIIlIIIlIll, llllllllllllllIIIllIlIIIlIIIlllI, false);
    }
    
    public Method getTargetMethod() {
        if (this.checked) {
            return this.targetMethod;
        }
        this.checked = true;
        final Class llllllllllllllIIIllIlIIIIlllIIlI = this.reflectorClass.getTargetClass();
        if (llllllllllllllIIIllIlIIIIlllIIlI == null) {
            return null;
        }
        try {
            if (this.targetMethodParameterTypes == null) {
                final Method[] llllllllllllllIIIllIlIIIIlllIIIl = Reflector.getMethods(llllllllllllllIIIllIlIIIIlllIIlI, this.targetMethodName);
                if (llllllllllllllIIIllIlIIIIlllIIIl.length <= 0) {
                    Config.log(String.valueOf(new StringBuilder("(Reflector) Method not present: ").append(llllllllllllllIIIllIlIIIIlllIIlI.getName()).append(".").append(this.targetMethodName)));
                    return null;
                }
                if (llllllllllllllIIIllIlIIIIlllIIIl.length > 1) {
                    Config.warn(String.valueOf(new StringBuilder("(Reflector) More than one method found: ").append(llllllllllllllIIIllIlIIIIlllIIlI.getName()).append(".").append(this.targetMethodName)));
                    for (int llllllllllllllIIIllIlIIIIlllIIII = 0; llllllllllllllIIIllIlIIIIlllIIII < llllllllllllllIIIllIlIIIIlllIIIl.length; ++llllllllllllllIIIllIlIIIIlllIIII) {
                        final Method llllllllllllllIIIllIlIIIIllIllll = llllllllllllllIIIllIlIIIIlllIIIl[llllllllllllllIIIllIlIIIIlllIIII];
                        Config.warn(String.valueOf(new StringBuilder("(Reflector)  - ").append(llllllllllllllIIIllIlIIIIllIllll)));
                    }
                    return null;
                }
                this.targetMethod = llllllllllllllIIIllIlIIIIlllIIIl[0];
            }
            else {
                this.targetMethod = Reflector.getMethod(llllllllllllllIIIllIlIIIIlllIIlI, this.targetMethodName, this.targetMethodParameterTypes);
            }
            if (this.targetMethod == null) {
                Config.log(String.valueOf(new StringBuilder("(Reflector) Method not present: ").append(llllllllllllllIIIllIlIIIIlllIIlI.getName()).append(".").append(this.targetMethodName)));
                return null;
            }
            this.targetMethod.setAccessible(true);
            return this.targetMethod;
        }
        catch (Throwable llllllllllllllIIIllIlIIIIllIlllI) {
            llllllllllllllIIIllIlIIIIllIlllI.printStackTrace();
            return null;
        }
    }
    
    public void deactivate() {
        this.checked = true;
        this.targetMethod = null;
    }
    
    public boolean exists() {
        return this.checked ? (this.targetMethod != null) : (this.getTargetMethod() != null);
    }
    
    public ReflectorMethod(final ReflectorClass llllllllllllllIIIllIlIIIIlllllIl, final String llllllllllllllIIIllIlIIIIlllllII, final Class[] llllllllllllllIIIllIlIIIlIIIIIII, final boolean llllllllllllllIIIllIlIIIIllllIlI) {
        this.reflectorClass = null;
        this.targetMethodName = null;
        this.targetMethodParameterTypes = null;
        this.checked = false;
        this.targetMethod = null;
        this.reflectorClass = llllllllllllllIIIllIlIIIIlllllIl;
        this.targetMethodName = llllllllllllllIIIllIlIIIIlllllII;
        this.targetMethodParameterTypes = llllllllllllllIIIllIlIIIlIIIIIII;
        if (!llllllllllllllIIIllIlIIIIllllIlI) {
            final String llllllllllllllIIIllIlIIIIllllIIl = (String)this.getTargetMethod();
        }
    }
}
