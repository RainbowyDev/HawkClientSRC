package net.minecraft.util;

import org.apache.logging.log4j.*;
import com.google.common.collect.*;
import org.apache.commons.lang3.*;
import java.util.*;

public class RegistrySimple implements IRegistry
{
    protected final /* synthetic */ Map registryObjects;
    private static final /* synthetic */ Logger logger;
    
    public RegistrySimple() {
        this.registryObjects = this.createUnderlyingMap();
    }
    
    public Set getKeys() {
        return Collections.unmodifiableSet(this.registryObjects.keySet());
    }
    
    static {
        __OBFID = "CL_00001210";
        logger = LogManager.getLogger();
    }
    
    protected Map createUnderlyingMap() {
        return Maps.newHashMap();
    }
    
    @Override
    public void putObject(final Object lllllllllllllllIlIIlIlIIllIlIlII, final Object lllllllllllllllIlIIlIlIIllIlIIll) {
        Validate.notNull(lllllllllllllllIlIIlIlIIllIlIlII);
        Validate.notNull(lllllllllllllllIlIIlIlIIllIlIIll);
        if (this.registryObjects.containsKey(lllllllllllllllIlIIlIlIIllIlIlII)) {
            RegistrySimple.logger.debug(String.valueOf(new StringBuilder("Adding duplicate key '").append(lllllllllllllllIlIIlIlIIllIlIlII).append("' to registry")));
        }
        this.registryObjects.put(lllllllllllllllIlIIlIlIIllIlIlII, lllllllllllllllIlIIlIlIIllIlIIll);
    }
    
    public boolean containsKey(final Object lllllllllllllllIlIIlIlIIllIIIlll) {
        return this.registryObjects.containsKey(lllllllllllllllIlIIlIlIIllIIIlll);
    }
    
    @Override
    public Iterator iterator() {
        return this.registryObjects.values().iterator();
    }
    
    @Override
    public Object getObject(final Object lllllllllllllllIlIIlIlIIllIllIll) {
        return this.registryObjects.get(lllllllllllllllIlIIlIlIIllIllIll);
    }
}
