package net.minecraft.client.settings;

import net.minecraft.util.*;
import com.google.common.collect.*;
import java.util.*;
import net.minecraft.client.resources.*;

public class KeyBinding implements Comparable
{
    private static final /* synthetic */ Set keybindSet;
    private final /* synthetic */ String keyDescription;
    public /* synthetic */ boolean pressed;
    private final /* synthetic */ String keyCategory;
    private final /* synthetic */ int keyCodeDefault;
    private static final /* synthetic */ List keybindArray;
    private static final /* synthetic */ IntHashMap hash;
    private /* synthetic */ int keyCode;
    private /* synthetic */ int pressTime;
    
    static {
        __OBFID = "CL_00000628";
        keybindArray = Lists.newArrayList();
        hash = new IntHashMap();
        keybindSet = Sets.newHashSet();
    }
    
    public static void resetKeyBindingArrayAndHash() {
        KeyBinding.hash.clearMap();
        for (final KeyBinding lllllllllllllllIIlllllIlIllIIIlI : KeyBinding.keybindArray) {
            KeyBinding.hash.addKey(lllllllllllllllIIlllllIlIllIIIlI.keyCode, lllllllllllllllIIlllllIlIllIIIlI);
        }
    }
    
    public int getKeyCode() {
        return this.keyCode;
    }
    
    public int compareTo(final KeyBinding lllllllllllllllIIlllllIlIIllIlII) {
        int lllllllllllllllIIlllllIlIIllIIll = I18n.format(this.keyCategory, new Object[0]).compareTo(I18n.format(lllllllllllllllIIlllllIlIIllIlII.keyCategory, new Object[0]));
        if (lllllllllllllllIIlllllIlIIllIIll == 0) {
            lllllllllllllllIIlllllIlIIllIIll = I18n.format(this.keyDescription, new Object[0]).compareTo(I18n.format(lllllllllllllllIIlllllIlIIllIlII.keyDescription, new Object[0]));
        }
        return lllllllllllllllIIlllllIlIIllIIll;
    }
    
    public boolean isPressed() {
        if (this.pressTime == 0) {
            return false;
        }
        --this.pressTime;
        return true;
    }
    
    public String getKeyDescription() {
        return this.keyDescription;
    }
    
    public KeyBinding(final String lllllllllllllllIIlllllIlIlIllIlI, final int lllllllllllllllIIlllllIlIlIlIlIl, final String lllllllllllllllIIlllllIlIlIlIlII) {
        this.keyDescription = lllllllllllllllIIlllllIlIlIllIlI;
        this.keyCode = lllllllllllllllIIlllllIlIlIlIlIl;
        this.keyCodeDefault = lllllllllllllllIIlllllIlIlIlIlIl;
        this.keyCategory = lllllllllllllllIIlllllIlIlIlIlII;
        KeyBinding.keybindArray.add(this);
        KeyBinding.hash.addKey(lllllllllllllllIIlllllIlIlIlIlIl, this);
        KeyBinding.keybindSet.add(lllllllllllllllIIlllllIlIlIlIlII);
    }
    
    public static void onTick(final int lllllllllllllllIIlllllIlIllllIII) {
        if (lllllllllllllllIIlllllIlIllllIII != 0) {
            final KeyBinding lllllllllllllllIIlllllIlIlllIlll = (KeyBinding)KeyBinding.hash.lookup(lllllllllllllllIIlllllIlIllllIII);
            if (lllllllllllllllIIlllllIlIlllIlll != null) {
                final KeyBinding keyBinding = lllllllllllllllIIlllllIlIlllIlll;
                ++keyBinding.pressTime;
            }
        }
    }
    
    public static Set getKeybinds() {
        return KeyBinding.keybindSet;
    }
    
    public void setKeyCode(final int lllllllllllllllIIlllllIlIIlllIIl) {
        this.keyCode = lllllllllllllllIIlllllIlIIlllIIl;
    }
    
    @Override
    public int compareTo(final Object lllllllllllllllIIlllllIlIIlIllII) {
        return this.compareTo((KeyBinding)lllllllllllllllIIlllllIlIIlIllII);
    }
    
    public boolean getIsKeyPressed() {
        return this.pressed;
    }
    
    private void unpressKey() {
        this.pressTime = 0;
        this.pressed = false;
    }
    
    public int getKeyCodeDefault() {
        return this.keyCodeDefault;
    }
    
    public static void setKeyBindState(final int lllllllllllllllIIlllllIlIlllIIIl, final boolean lllllllllllllllIIlllllIlIllIllIl) {
        if (lllllllllllllllIIlllllIlIlllIIIl != 0) {
            final KeyBinding lllllllllllllllIIlllllIlIllIllll = (KeyBinding)KeyBinding.hash.lookup(lllllllllllllllIIlllllIlIlllIIIl);
            if (lllllllllllllllIIlllllIlIllIllll != null) {
                lllllllllllllllIIlllllIlIllIllll.pressed = lllllllllllllllIIlllllIlIllIllIl;
            }
        }
    }
    
    public static void unPressAllKeys() {
        for (final KeyBinding lllllllllllllllIIlllllIlIllIlIII : KeyBinding.keybindArray) {
            lllllllllllllllIIlllllIlIllIlIII.unpressKey();
        }
    }
    
    public String getKeyCategory() {
        return this.keyCategory;
    }
}
