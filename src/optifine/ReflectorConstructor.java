package optifine;

import java.lang.reflect.*;

public class ReflectorConstructor
{
    private /* synthetic */ Class[] parameterTypes;
    private /* synthetic */ Constructor targetConstructor;
    private /* synthetic */ boolean checked;
    private /* synthetic */ ReflectorClass reflectorClass;
    
    public Constructor getTargetConstructor() {
        if (this.checked) {
            return this.targetConstructor;
        }
        this.checked = true;
        final Class llllllllllllllIlIIlllIlIIllIIIIl = this.reflectorClass.getTargetClass();
        if (llllllllllllllIlIIlllIlIIllIIIIl == null) {
            return null;
        }
        try {
            this.targetConstructor = findConstructor(llllllllllllllIlIIlllIlIIllIIIIl, this.parameterTypes);
            if (this.targetConstructor == null) {
                Config.dbg(String.valueOf(new StringBuilder("(Reflector) Constructor not present: ").append(llllllllllllllIlIIlllIlIIllIIIIl.getName()).append(", params: ").append(Config.arrayToString(this.parameterTypes))));
            }
            if (this.targetConstructor != null) {
                this.targetConstructor.setAccessible(true);
            }
        }
        catch (Throwable llllllllllllllIlIIlllIlIIllIIIII) {
            llllllllllllllIlIIlllIlIIllIIIII.printStackTrace();
        }
        return this.targetConstructor;
    }
    
    public void deactivate() {
        this.checked = true;
        this.targetConstructor = null;
    }
    
    public boolean exists() {
        return this.checked ? (this.targetConstructor != null) : (this.getTargetConstructor() != null);
    }
    
    private static Constructor findConstructor(final Class llllllllllllllIlIIlllIlIIlIlIIII, final Class[] llllllllllllllIlIIlllIlIIlIlIlIl) {
        final Constructor[] llllllllllllllIlIIlllIlIIlIlIlII = llllllllllllllIlIIlllIlIIlIlIIII.getDeclaredConstructors();
        for (int llllllllllllllIlIIlllIlIIlIlIIll = 0; llllllllllllllIlIIlllIlIIlIlIIll < llllllllllllllIlIIlllIlIIlIlIlII.length; ++llllllllllllllIlIIlllIlIIlIlIIll) {
            final Constructor llllllllllllllIlIIlllIlIIlIlIIlI = llllllllllllllIlIIlllIlIIlIlIlII[llllllllllllllIlIIlllIlIIlIlIIll];
            final Class[] llllllllllllllIlIIlllIlIIlIlIIIl = llllllllllllllIlIIlllIlIIlIlIIlI.getParameterTypes();
            if (Reflector.matchesTypes(llllllllllllllIlIIlllIlIIlIlIlIl, llllllllllllllIlIIlllIlIIlIlIIIl)) {
                return llllllllllllllIlIIlllIlIIlIlIIlI;
            }
        }
        return null;
    }
    
    public ReflectorConstructor(final ReflectorClass llllllllllllllIlIIlllIlIIllIlIII, final Class[] llllllllllllllIlIIlllIlIIllIIlll) {
        this.reflectorClass = null;
        this.parameterTypes = null;
        this.checked = false;
        this.targetConstructor = null;
        this.reflectorClass = llllllllllllllIlIIlllIlIIllIlIII;
        this.parameterTypes = llllllllllllllIlIIlllIlIIllIIlll;
        final Constructor llllllllllllllIlIIlllIlIIllIlIlI = this.getTargetConstructor();
    }
}
