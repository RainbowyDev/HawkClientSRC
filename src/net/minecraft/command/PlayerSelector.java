package net.minecraft.command;

import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import java.util.regex.*;
import com.google.common.base.*;
import net.minecraft.server.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.scoreboard.*;
import com.google.common.collect.*;
import java.util.*;

public class PlayerSelector
{
    private static final /* synthetic */ Pattern intListPattern;
    private static final /* synthetic */ Pattern keyValueListPattern;
    private static final /* synthetic */ Pattern tokenPattern;
    private static final /* synthetic */ Set field_179666_d;
    
    private static List func_179658_a(List llllllllllllllIlIIIIIlIIIIIlIIII, final Map llllllllllllllIlIIIIIlIIIIIlIlll, final ICommandSender llllllllllllllIlIIIIIlIIIIIIlllI, final Class llllllllllllllIlIIIIIlIIIIIlIlIl, final String llllllllllllllIlIIIIIlIIIIIIllII, final BlockPos llllllllllllllIlIIIIIlIIIIIlIIll) {
        final int llllllllllllllIlIIIIIlIIIIIlIIlI = func_179653_a(llllllllllllllIlIIIIIlIIIIIlIlll, "c", (!llllllllllllllIlIIIIIlIIIIIIllII.equals("a") && !llllllllllllllIlIIIIIlIIIIIIllII.equals("e")) ? 1 : 0);
        if (!llllllllllllllIlIIIIIlIIIIIIllII.equals("p") && !llllllllllllllIlIIIIIlIIIIIIllII.equals("a") && !llllllllllllllIlIIIIIlIIIIIIllII.equals("e")) {
            if (llllllllllllllIlIIIIIlIIIIIIllII.equals("r")) {
                Collections.shuffle(llllllllllllllIlIIIIIlIIIIIlIIII);
            }
        }
        else if (llllllllllllllIlIIIIIlIIIIIlIIll != null) {
            Collections.sort((List<Object>)llllllllllllllIlIIIIIlIIIIIlIIII, new Comparator() {
                static {
                    __OBFID = "CL_00002359";
                }
                
                public int func_179611_a(final Entity llllllllllllllIlIllllIIllIIllIII, final Entity llllllllllllllIlIllllIIllIIlIlll) {
                    return ComparisonChain.start().compare(llllllllllllllIlIllllIIllIIllIII.getDistanceSq(llllllllllllllIlIIIIIlIIIIIlIIll), llllllllllllllIlIllllIIllIIlIlll.getDistanceSq(llllllllllllllIlIIIIIlIIIIIlIIll)).result();
                }
                
                @Override
                public int compare(final Object llllllllllllllIlIllllIIllIIIllII, final Object llllllllllllllIlIllllIIllIIIlllI) {
                    return this.func_179611_a((Entity)llllllllllllllIlIllllIIllIIIllII, (Entity)llllllllllllllIlIllllIIllIIIlllI);
                }
            });
        }
        final Entity llllllllllllllIlIIIIIlIIIIIlIIIl = llllllllllllllIlIIIIIlIIIIIIlllI.getCommandSenderEntity();
        if (llllllllllllllIlIIIIIlIIIIIlIIIl != null && llllllllllllllIlIIIIIlIIIIIlIlIl.isAssignableFrom(llllllllllllllIlIIIIIlIIIIIlIIIl.getClass()) && llllllllllllllIlIIIIIlIIIIIlIIlI == 1 && llllllllllllllIlIIIIIlIIIIIlIIII.contains(llllllllllllllIlIIIIIlIIIIIlIIIl) && !"r".equals(llllllllllllllIlIIIIIlIIIIIIllII)) {
            llllllllllllllIlIIIIIlIIIIIlIIII = (List<T>)Lists.newArrayList((Object[])new Entity[] { llllllllllllllIlIIIIIlIIIIIlIIIl });
        }
        if (llllllllllllllIlIIIIIlIIIIIlIIlI != 0) {
            if (llllllllllllllIlIIIIIlIIIIIlIIlI < 0) {
                Collections.reverse(llllllllllllllIlIIIIIlIIIIIlIIII);
            }
            llllllllllllllIlIIIIIlIIIIIlIIII = llllllllllllllIlIIIIIlIIIIIlIIII.subList(0, Math.min(Math.abs(llllllllllllllIlIIIIIlIIIIIlIIlI), llllllllllllllIlIIIIIlIIIIIlIIII.size()));
        }
        return llllllllllllllIlIIIIIlIIIIIlIIII;
    }
    
    private static AxisAlignedBB func_179661_a(final BlockPos llllllllllllllIlIIIIIIlllllIlIII, final int llllllllllllllIlIIIIIIlllllIIlll, final int llllllllllllllIlIIIIIIlllllllIIl, final int llllllllllllllIlIIIIIIlllllIIlII) {
        final boolean llllllllllllllIlIIIIIIllllllIllI = llllllllllllllIlIIIIIIlllllIIlll < 0;
        final boolean llllllllllllllIlIIIIIIllllllIlIl = llllllllllllllIlIIIIIIlllllllIIl < 0;
        final boolean llllllllllllllIlIIIIIIllllllIIll = llllllllllllllIlIIIIIIlllllIIlII < 0;
        final int llllllllllllllIlIIIIIIllllllIIlI = llllllllllllllIlIIIIIIlllllIlIII.getX() + (llllllllllllllIlIIIIIIllllllIllI ? llllllllllllllIlIIIIIIlllllIIlll : 0);
        final int llllllllllllllIlIIIIIIllllllIIII = llllllllllllllIlIIIIIIlllllIlIII.getY() + (llllllllllllllIlIIIIIIllllllIlIl ? llllllllllllllIlIIIIIIlllllllIIl : 0);
        final int llllllllllllllIlIIIIIIlllllIlllI = llllllllllllllIlIIIIIIlllllIlIII.getZ() + (llllllllllllllIlIIIIIIllllllIIll ? llllllllllllllIlIIIIIIlllllIIlII : 0);
        final int llllllllllllllIlIIIIIIlllllIllII = llllllllllllllIlIIIIIIlllllIlIII.getX() + (llllllllllllllIlIIIIIIllllllIllI ? 0 : llllllllllllllIlIIIIIIlllllIIlll) + 1;
        final int llllllllllllllIlIIIIIIlllllIlIlI = llllllllllllllIlIIIIIIlllllIlIII.getY() + (llllllllllllllIlIIIIIIllllllIlIl ? 0 : llllllllllllllIlIIIIIIlllllllIIl) + 1;
        final int llllllllllllllIlIIIIIIlllllIlIIl = llllllllllllllIlIIIIIIlllllIlIII.getZ() + (llllllllllllllIlIIIIIIllllllIIll ? 0 : llllllllllllllIlIIIIIIlllllIIlII) + 1;
        return new AxisAlignedBB(llllllllllllllIlIIIIIIllllllIIlI, llllllllllllllIlIIIIIIllllllIIII, llllllllllllllIlIIIIIIlllllIlllI, llllllllllllllIlIIIIIIlllllIllII, llllllllllllllIlIIIIIIlllllIlIlI, llllllllllllllIlIIIIIIlllllIlIIl);
    }
    
    static {
        __OBFID = "CL_00000086";
        tokenPattern = Pattern.compile("^@([pare])(?:\\[([\\w=,!-]*)\\])?$");
        intListPattern = Pattern.compile("\\G([-!]?[\\w-]*)(?:$|,)");
        keyValueListPattern = Pattern.compile("\\G(\\w+)=([-!]?[\\w-]*)(?:$|,)");
        field_179666_d = Sets.newHashSet((Object[])new String[] { "x", "y", "z", "dx", "dy", "dz", "rm", "r" });
    }
    
    private static List func_179663_a(final Map llllllllllllllIlIIIIIlIIllIIIlll, final String llllllllllllllIlIIIIIlIIllIIIllI) {
        final ArrayList llllllllllllllIlIIIIIlIIllIIllIl = Lists.newArrayList();
        String llllllllllllllIlIIIIIlIIllIIllII = func_179651_b(llllllllllllllIlIIIIIlIIllIIIlll, "type");
        final boolean llllllllllllllIlIIIIIlIIllIIlIll = llllllllllllllIlIIIIIlIIllIIllII != null && llllllllllllllIlIIIIIlIIllIIllII.startsWith("!");
        if (llllllllllllllIlIIIIIlIIllIIlIll) {
            llllllllllllllIlIIIIIlIIllIIllII = llllllllllllllIlIIIIIlIIllIIllII.substring(1);
        }
        final boolean llllllllllllllIlIIIIIlIIllIIlIlI = !llllllllllllllIlIIIIIlIIllIIIllI.equals("e");
        final boolean llllllllllllllIlIIIIIlIIllIIlIIl = llllllllllllllIlIIIIIlIIllIIIllI.equals("r") && llllllllllllllIlIIIIIlIIllIIllII != null;
        if ((llllllllllllllIlIIIIIlIIllIIllII == null || !llllllllllllllIlIIIIIlIIllIIIllI.equals("e")) && !llllllllllllllIlIIIIIlIIllIIlIIl) {
            if (llllllllllllllIlIIIIIlIIllIIlIlI) {
                llllllllllllllIlIIIIIlIIllIIllIl.add(new Predicate() {
                    public boolean apply(final Object llllllllllllllllllIlIllIlIIIIllI) {
                        return this.func_179624_a((Entity)llllllllllllllllllIlIllIlIIIIllI);
                    }
                    
                    static {
                        __OBFID = "CL_00002358";
                    }
                    
                    public boolean func_179624_a(final Entity llllllllllllllllllIlIllIlIIIllIl) {
                        return llllllllllllllllllIlIllIlIIIllIl instanceof EntityPlayer;
                    }
                });
            }
        }
        else {
            final String llllllllllllllIlIIIIIlIIllIIlIII = llllllllllllllIlIIIIIlIIllIIllII;
            llllllllllllllIlIIIIIlIIllIIllIl.add(new Predicate() {
                static {
                    __OBFID = "CL_00002362";
                }
                
                public boolean apply(final Object llllllllllllllIlIIlllIlIlllIIlIl) {
                    return this.func_179613_a((Entity)llllllllllllllIlIIlllIlIlllIIlIl);
                }
                
                public boolean func_179613_a(final Entity llllllllllllllIlIIlllIlIlllIlIIl) {
                    return EntityList.func_180123_a(llllllllllllllIlIIlllIlIlllIlIIl, llllllllllllllIlIIIIIlIIllIIlIII) ^ llllllllllllllIlIIIIIlIIllIIlIll;
                }
            });
        }
        return llllllllllllllIlIIIIIlIIllIIllIl;
    }
    
    public static boolean hasArguments(final String llllllllllllllIlIIIIIIllIllIlIIl) {
        return PlayerSelector.tokenPattern.matcher(llllllllllllllIlIIIIIIllIllIlIIl).matches();
    }
    
    private static List func_179647_f(final Map llllllllllllllIlIIIIIlIIlIIIllIl) {
        final ArrayList llllllllllllllIlIIIIIlIIlIIIllII = Lists.newArrayList();
        String llllllllllllllIlIIIIIlIIlIIIlIll = func_179651_b(llllllllllllllIlIIIIIlIIlIIIllIl, "name");
        final boolean llllllllllllllIlIIIIIlIIlIIIlIlI = llllllllllllllIlIIIIIlIIlIIIlIll != null && llllllllllllllIlIIIIIlIIlIIIlIll.startsWith("!");
        if (llllllllllllllIlIIIIIlIIlIIIlIlI) {
            llllllllllllllIlIIIIIlIIlIIIlIll = llllllllllllllIlIIIIIlIIlIIIlIll.substring(1);
        }
        if (llllllllllllllIlIIIIIlIIlIIIlIll != null) {
            final String llllllllllllllIlIIIIIlIIlIIIlIIl = llllllllllllllIlIIIIIlIIlIIIlIll;
            llllllllllllllIlIIIIIlIIlIIIllII.add(new Predicate() {
                public boolean func_179600_a(final Entity lllllllllllllllIIIlIIlIlIIIlllll) {
                    return lllllllllllllllIIIlIIlIlIIIlllll.getName().equals(llllllllllllllIlIIIIIlIIlIIIlIIl) ^ llllllllllllllIlIIIIIlIIlIIIlIlI;
                }
                
                public boolean apply(final Object lllllllllllllllIIIlIIlIlIIIllIIl) {
                    return this.func_179600_a((Entity)lllllllllllllllIIIlIIlIlIIIllIIl);
                }
                
                static {
                    __OBFID = "CL_00002353";
                }
            });
        }
        return llllllllllllllIlIIIIIlIIlIIIllII;
    }
    
    private static String func_179651_b(final Map llllllllllllllIlIIIIIIlllIIllIII, final String llllllllllllllIlIIIIIIlllIIllIIl) {
        return llllllllllllllIlIIIIIIlllIIllIII.get(llllllllllllllIlIIIIIIlllIIllIIl);
    }
    
    private static List func_179662_g(final Map llllllllllllllIlIIIIIlIIIllIlIlI) {
        final ArrayList llllllllllllllIlIIIIIlIIIllIlIIl = Lists.newArrayList();
        if (llllllllllllllIlIIIIIlIIIllIlIlI.containsKey("rym") || llllllllllllllIlIIIIIlIIIllIlIlI.containsKey("ry")) {
            final int llllllllllllllIlIIIIIlIIIllIlIII = func_179650_a(func_179653_a(llllllllllllllIlIIIIIlIIIllIlIlI, "rym", 0));
            final int llllllllllllllIlIIIIIlIIIllIIlll = func_179650_a(func_179653_a(llllllllllllllIlIIIIIlIIIllIlIlI, "ry", 359));
            llllllllllllllIlIIIIIlIIIllIlIIl.add(new Predicate() {
                public boolean apply(final Object llllllllllllllIIllIIlIIIIllIIlII) {
                    return this.func_179591_a((Entity)llllllllllllllIIllIIlIIIIllIIlII);
                }
                
                public boolean func_179591_a(final Entity llllllllllllllIIllIIlIIIIllIlIIl) {
                    final int llllllllllllllIIllIIlIIIIllIlIll = PlayerSelector.func_179650_a((int)Math.floor(llllllllllllllIIllIIlIIIIllIlIIl.rotationYaw));
                    return (llllllllllllllIlIIIIIlIIIllIlIII > llllllllllllllIlIIIIIlIIIllIIlll) ? (llllllllllllllIIllIIlIIIIllIlIll >= llllllllllllllIlIIIIIlIIIllIlIII || llllllllllllllIIllIIlIIIIllIlIll <= llllllllllllllIlIIIIIlIIIllIIlll) : (llllllllllllllIIllIIlIIIIllIlIll >= llllllllllllllIlIIIIIlIIIllIlIII && llllllllllllllIIllIIlIIIIllIlIll <= llllllllllllllIlIIIIIlIIIllIIlll);
                }
                
                static {
                    __OBFID = "CL_00002351";
                }
            });
        }
        if (llllllllllllllIlIIIIIlIIIllIlIlI.containsKey("rxm") || llllllllllllllIlIIIIIlIIIllIlIlI.containsKey("rx")) {
            final int llllllllllllllIlIIIIIlIIIllIIllI = func_179650_a(func_179653_a(llllllllllllllIlIIIIIlIIIllIlIlI, "rxm", 0));
            final int llllllllllllllIlIIIIIlIIIllIIlIl = func_179650_a(func_179653_a(llllllllllllllIlIIIIIlIIIllIlIlI, "rx", 359));
            llllllllllllllIlIIIIIlIIIllIlIIl.add(new Predicate() {
                static {
                    __OBFID = "CL_00002361";
                }
                
                public boolean apply(final Object llllllllllllllIllllIllIllIlIIIlI) {
                    return this.func_179616_a((Entity)llllllllllllllIllllIllIllIlIIIlI);
                }
                
                public boolean func_179616_a(final Entity llllllllllllllIllllIllIllIlIIlll) {
                    final int llllllllllllllIllllIllIllIlIlIIl = PlayerSelector.func_179650_a((int)Math.floor(llllllllllllllIllllIllIllIlIIlll.rotationPitch));
                    return (llllllllllllllIlIIIIIlIIIllIIllI > llllllllllllllIlIIIIIlIIIllIIlIl) ? (llllllllllllllIllllIllIllIlIlIIl >= llllllllllllllIlIIIIIlIIIllIIllI || llllllllllllllIllllIllIllIlIlIIl <= llllllllllllllIlIIIIIlIIIllIIlIl) : (llllllllllllllIllllIllIllIlIlIIl >= llllllllllllllIlIIIIIlIIIllIIllI && llllllllllllllIllllIllIllIlIlIIl <= llllllllllllllIlIIIIIlIIIllIIlIl);
                }
            });
        }
        return llllllllllllllIlIIIIIlIIIllIlIIl;
    }
    
    private static boolean func_179655_b(final ICommandSender llllllllllllllIlIIIIIlIIllIllIll, final Map llllllllllllllIlIIIIIlIIllIllIlI) {
        String llllllllllllllIlIIIIIlIIllIlllIl = func_179651_b(llllllllllllllIlIIIIIlIIllIllIlI, "type");
        llllllllllllllIlIIIIIlIIllIlllIl = ((llllllllllllllIlIIIIIlIIllIlllIl != null && llllllllllllllIlIIIIIlIIllIlllIl.startsWith("!")) ? llllllllllllllIlIIIIIlIIllIlllIl.substring(1) : llllllllllllllIlIIIIIlIIllIlllIl);
        if (llllllllllllllIlIIIIIlIIllIlllIl != null && !EntityList.func_180125_b(llllllllllllllIlIIIIIlIIllIlllIl)) {
            final ChatComponentTranslation llllllllllllllIlIIIIIlIIllIlllII = new ChatComponentTranslation("commands.generic.entity.invalidType", new Object[] { llllllllllllllIlIIIIIlIIllIlllIl });
            llllllllllllllIlIIIIIlIIllIlllII.getChatStyle().setColor(EnumChatFormatting.RED);
            llllllllllllllIlIIIIIlIIllIllIll.addChatMessage(llllllllllllllIlIIIIIlIIllIlllII);
            return false;
        }
        return true;
    }
    
    private static List func_179649_c(final Map llllllllllllllIlIIIIIlIIlIllIIII) {
        final ArrayList llllllllllllllIlIIIIIlIIlIlIllll = Lists.newArrayList();
        final int llllllllllllllIlIIIIIlIIlIlIlllI = func_179653_a(llllllllllllllIlIIIIIlIIlIllIIII, "m", WorldSettings.GameType.NOT_SET.getID());
        if (llllllllllllllIlIIIIIlIIlIlIlllI != WorldSettings.GameType.NOT_SET.getID()) {
            llllllllllllllIlIIIIIlIIlIlIllll.add(new Predicate() {
                public boolean func_179619_a(final Entity llllllllllllllIlIlIllIllIIIIIIll) {
                    if (!(llllllllllllllIlIlIllIllIIIIIIll instanceof EntityPlayerMP)) {
                        return false;
                    }
                    final EntityPlayerMP llllllllllllllIlIlIllIllIIIIIlIl = (EntityPlayerMP)llllllllllllllIlIlIllIllIIIIIIll;
                    return llllllllllllllIlIlIllIllIIIIIlIl.theItemInWorldManager.getGameType().getID() == llllllllllllllIlIIIIIlIIlIlIlllI;
                }
                
                public boolean apply(final Object llllllllllllllIlIlIllIlIlllllllI) {
                    return this.func_179619_a((Entity)llllllllllllllIlIlIllIlIlllllllI);
                }
                
                static {
                    __OBFID = "CL_00002356";
                }
            });
        }
        return llllllllllllllIlIIIIIlIIlIlIllll;
    }
    
    private static int func_179653_a(final Map llllllllllllllIlIIIIIIlllIlIIIlI, final String llllllllllllllIlIIIIIIlllIlIIlII, final int llllllllllllllIlIIIIIIlllIIllllI) {
        return llllllllllllllIlIIIIIIlllIlIIIlI.containsKey(llllllllllllllIlIIIIIIlllIlIIlII) ? MathHelper.parseIntWithDefault(llllllllllllllIlIIIIIIlllIlIIIlI.get(llllllllllllllIlIIIIIIlllIlIIlII), llllllllllllllIlIIIIIIlllIIllllI) : llllllllllllllIlIIIIIIlllIIllllI;
    }
    
    public static Entity func_179652_a(final ICommandSender llllllllllllllIlIIIIIlIlIIlIlIlI, final String llllllllllllllIlIIIIIlIlIIlIlIIl, final Class llllllllllllllIlIIIIIlIlIIlIlIII) {
        final List llllllllllllllIlIIIIIlIlIIlIIlll = func_179656_b(llllllllllllllIlIIIIIlIlIIlIlIlI, llllllllllllllIlIIIIIlIlIIlIlIIl, llllllllllllllIlIIIIIlIlIIlIlIII);
        return (llllllllllllllIlIIIIIlIlIIlIIlll.size() == 1) ? llllllllllllllIlIIIIIlIlIIlIIlll.get(0) : null;
    }
    
    private static boolean func_179665_h(final Map llllllllllllllIlIIIIIIlllIllIlll) {
        for (final String llllllllllllllIlIIIIIIlllIllIlIl : PlayerSelector.field_179666_d) {
            if (llllllllllllllIlIIIIIIlllIllIlll.containsKey(llllllllllllllIlIIIIIIlllIllIlIl)) {
                return true;
            }
        }
        return false;
    }
    
    public static List func_179656_b(final ICommandSender llllllllllllllIlIIIIIlIlIIIIIlII, final String llllllllllllllIlIIIIIlIlIIIIIIll, final Class llllllllllllllIlIIIIIlIlIIIIIIlI) {
        final Matcher llllllllllllllIlIIIIIlIlIIIIIIIl = PlayerSelector.tokenPattern.matcher(llllllllllllllIlIIIIIlIlIIIIIIll);
        if (!llllllllllllllIlIIIIIlIlIIIIIIIl.matches() || !llllllllllllllIlIIIIIlIlIIIIIlII.canCommandSenderUseCommand(1, "@")) {
            return Collections.emptyList();
        }
        final Map llllllllllllllIlIIIIIlIlIIIIIIII = getArgumentMap(llllllllllllllIlIIIIIlIlIIIIIIIl.group(2));
        if (!func_179655_b(llllllllllllllIlIIIIIlIlIIIIIlII, llllllllllllllIlIIIIIlIlIIIIIIII)) {
            return Collections.emptyList();
        }
        final String llllllllllllllIlIIIIIlIIllllllll = llllllllllllllIlIIIIIlIlIIIIIIIl.group(1);
        final BlockPos llllllllllllllIlIIIIIlIIlllllllI = func_179664_b(llllllllllllllIlIIIIIlIlIIIIIIII, llllllllllllllIlIIIIIlIlIIIIIlII.getPosition());
        final List llllllllllllllIlIIIIIlIIllllllIl = func_179654_a(llllllllllllllIlIIIIIlIlIIIIIlII, llllllllllllllIlIIIIIlIlIIIIIIII);
        final ArrayList llllllllllllllIlIIIIIlIIllllllII = Lists.newArrayList();
        for (final World llllllllllllllIlIIIIIlIIlllllIlI : llllllllllllllIlIIIIIlIIllllllIl) {
            if (llllllllllllllIlIIIIIlIIlllllIlI != null) {
                final ArrayList llllllllllllllIlIIIIIlIIlllllIIl = Lists.newArrayList();
                llllllllllllllIlIIIIIlIIlllllIIl.addAll(func_179663_a(llllllllllllllIlIIIIIlIlIIIIIIII, llllllllllllllIlIIIIIlIIllllllll));
                llllllllllllllIlIIIIIlIIlllllIIl.addAll(func_179648_b(llllllllllllllIlIIIIIlIlIIIIIIII));
                llllllllllllllIlIIIIIlIIlllllIIl.addAll(func_179649_c(llllllllllllllIlIIIIIlIlIIIIIIII));
                llllllllllllllIlIIIIIlIIlllllIIl.addAll(func_179659_d(llllllllllllllIlIIIIIlIlIIIIIIII));
                llllllllllllllIlIIIIIlIIlllllIIl.addAll(func_179657_e(llllllllllllllIlIIIIIlIlIIIIIIII));
                llllllllllllllIlIIIIIlIIlllllIIl.addAll(func_179647_f(llllllllllllllIlIIIIIlIlIIIIIIII));
                llllllllllllllIlIIIIIlIIlllllIIl.addAll(func_180698_a(llllllllllllllIlIIIIIlIlIIIIIIII, llllllllllllllIlIIIIIlIIlllllllI));
                llllllllllllllIlIIIIIlIIlllllIIl.addAll(func_179662_g(llllllllllllllIlIIIIIlIlIIIIIIII));
                llllllllllllllIlIIIIIlIIllllllII.addAll(func_179660_a(llllllllllllllIlIIIIIlIlIIIIIIII, llllllllllllllIlIIIIIlIlIIIIIIlI, llllllllllllllIlIIIIIlIIlllllIIl, llllllllllllllIlIIIIIlIIllllllll, llllllllllllllIlIIIIIlIIlllllIlI, llllllllllllllIlIIIIIlIIlllllllI));
            }
        }
        return func_179658_a(llllllllllllllIlIIIIIlIIllllllII, llllllllllllllIlIIIIIlIlIIIIIIII, llllllllllllllIlIIIIIlIlIIIIIlII, llllllllllllllIlIIIIIlIlIIIIIIlI, llllllllllllllIlIIIIIlIIllllllll, llllllllllllllIlIIIIIlIIlllllllI);
    }
    
    private static List func_179648_b(final Map llllllllllllllIlIIIIIlIIlIlllIll) {
        final ArrayList llllllllllllllIlIIIIIlIIlIlllIlI = Lists.newArrayList();
        final int llllllllllllllIlIIIIIlIIlIlllIIl = func_179653_a(llllllllllllllIlIIIIIlIIlIlllIll, "lm", -1);
        final int llllllllllllllIlIIIIIlIIlIlllIII = func_179653_a(llllllllllllllIlIIIIIlIIlIlllIll, "l", -1);
        if (llllllllllllllIlIIIIIlIIlIlllIIl > -1 || llllllllllllllIlIIIIIlIIlIlllIII > -1) {
            llllllllllllllIlIIIIIlIIlIlllIlI.add(new Predicate() {
                public boolean func_179625_a(final Entity llllllllllllllllIllIIIlIllIIlIlI) {
                    if (!(llllllllllllllllIllIIIlIllIIlIlI instanceof EntityPlayerMP)) {
                        return false;
                    }
                    final EntityPlayerMP llllllllllllllllIllIIIlIllIIlIIl = (EntityPlayerMP)llllllllllllllllIllIIIlIllIIlIlI;
                    return (llllllllllllllIlIIIIIlIIlIlllIIl <= -1 || llllllllllllllllIllIIIlIllIIlIIl.experienceLevel >= llllllllllllllIlIIIIIlIIlIlllIIl) && (llllllllllllllIlIIIIIlIIlIlllIII <= -1 || llllllllllllllllIllIIIlIllIIlIIl.experienceLevel <= llllllllllllllIlIIIIIlIIlIlllIII);
                }
                
                public boolean apply(final Object llllllllllllllllIllIIIlIllIIIIlI) {
                    return this.func_179625_a((Entity)llllllllllllllllIllIIIlIllIIIIlI);
                }
                
                static {
                    __OBFID = "CL_00002357";
                }
            });
        }
        return llllllllllllllIlIIIIIlIIlIlllIlI;
    }
    
    private static BlockPos func_179664_b(final Map llllllllllllllIlIIIIIIllllIIIlll, final BlockPos llllllllllllllIlIIIIIIllllIIIIIl) {
        return new BlockPos(func_179653_a(llllllllllllllIlIIIIIIllllIIIlll, "x", llllllllllllllIlIIIIIIllllIIIIIl.getX()), func_179653_a(llllllllllllllIlIIIIIIllllIIIlll, "y", llllllllllllllIlIIIIIIllllIIIIIl.getY()), func_179653_a(llllllllllllllIlIIIIIIllllIIIlll, "z", llllllllllllllIlIIIIIIllllIIIIIl.getZ()));
    }
    
    public static int func_179650_a(int llllllllllllllIlIIIIIIllllIlIIIl) {
        llllllllllllllIlIIIIIIllllIlIIIl %= (byte)360;
        if (llllllllllllllIlIIIIIIllllIlIIIl >= 160) {
            llllllllllllllIlIIIIIIllllIlIIIl -= 360;
        }
        if (llllllllllllllIlIIIIIIllllIlIIIl < 0) {
            llllllllllllllIlIIIIIIllllIlIIIl += 360;
        }
        return llllllllllllllIlIIIIIIllllIlIIIl;
    }
    
    private static List func_179660_a(final Map llllllllllllllIlIIIIIlIIIIllIlIl, final Class llllllllllllllIlIIIIIlIIIlIIlIlI, final List llllllllllllllIlIIIIIlIIIlIIlIIl, final String llllllllllllllIlIIIIIlIIIIllIIlI, final World llllllllllllllIlIIIIIlIIIIllIIIl, final BlockPos llllllllllllllIlIIIIIlIIIlIIIllI) {
        final ArrayList llllllllllllllIlIIIIIlIIIlIIIlIl = Lists.newArrayList();
        String llllllllllllllIlIIIIIlIIIlIIIlII = func_179651_b(llllllllllllllIlIIIIIlIIIIllIlIl, "type");
        llllllllllllllIlIIIIIlIIIlIIIlII = ((llllllllllllllIlIIIIIlIIIlIIIlII != null && llllllllllllllIlIIIIIlIIIlIIIlII.startsWith("!")) ? llllllllllllllIlIIIIIlIIIlIIIlII.substring(1) : llllllllllllllIlIIIIIlIIIlIIIlII);
        final boolean llllllllllllllIlIIIIIlIIIlIIIIll = !llllllllllllllIlIIIIIlIIIIllIIlI.equals("e");
        final boolean llllllllllllllIlIIIIIlIIIlIIIIlI = llllllllllllllIlIIIIIlIIIIllIIlI.equals("r") && llllllllllllllIlIIIIIlIIIlIIIlII != null;
        final int llllllllllllllIlIIIIIlIIIlIIIIIl = func_179653_a(llllllllllllllIlIIIIIlIIIIllIlIl, "dx", 0);
        final int llllllllllllllIlIIIIIlIIIlIIIIII = func_179653_a(llllllllllllllIlIIIIIlIIIIllIlIl, "dy", 0);
        final int llllllllllllllIlIIIIIlIIIIllllll = func_179653_a(llllllllllllllIlIIIIIlIIIIllIlIl, "dz", 0);
        final int llllllllllllllIlIIIIIlIIIIlllllI = func_179653_a(llllllllllllllIlIIIIIlIIIIllIlIl, "r", -1);
        final Predicate llllllllllllllIlIIIIIlIIIIllllIl = Predicates.and((Iterable)llllllllllllllIlIIIIIlIIIlIIlIIl);
        final Predicate llllllllllllllIlIIIIIlIIIIllllII = Predicates.and(IEntitySelector.selectAnything, llllllllllllllIlIIIIIlIIIIllllIl);
        if (llllllllllllllIlIIIIIlIIIlIIIllI != null) {
            final int llllllllllllllIlIIIIIlIIIIlllIll = llllllllllllllIlIIIIIlIIIIllIIIl.playerEntities.size();
            final int llllllllllllllIlIIIIIlIIIIlllIlI = llllllllllllllIlIIIIIlIIIIllIIIl.loadedEntityList.size();
            final boolean llllllllllllllIlIIIIIlIIIIlllIIl = llllllllllllllIlIIIIIlIIIIlllIll < llllllllllllllIlIIIIIlIIIIlllIlI / 16;
            if (!llllllllllllllIlIIIIIlIIIIllIlIl.containsKey("dx") && !llllllllllllllIlIIIIIlIIIIllIlIl.containsKey("dy") && !llllllllllllllIlIIIIIlIIIIllIlIl.containsKey("dz")) {
                if (llllllllllllllIlIIIIIlIIIIlllllI >= 0) {
                    final AxisAlignedBB llllllllllllllIlIIIIIlIIIIlllIII = new AxisAlignedBB(llllllllllllllIlIIIIIlIIIlIIIllI.getX() - llllllllllllllIlIIIIIlIIIIlllllI, llllllllllllllIlIIIIIlIIIlIIIllI.getY() - llllllllllllllIlIIIIIlIIIIlllllI, llllllllllllllIlIIIIIlIIIlIIIllI.getZ() - llllllllllllllIlIIIIIlIIIIlllllI, llllllllllllllIlIIIIIlIIIlIIIllI.getX() + llllllllllllllIlIIIIIlIIIIlllllI + 1, llllllllllllllIlIIIIIlIIIlIIIllI.getY() + llllllllllllllIlIIIIIlIIIIlllllI + 1, llllllllllllllIlIIIIIlIIIlIIIllI.getZ() + llllllllllllllIlIIIIIlIIIIlllllI + 1);
                    if (llllllllllllllIlIIIIIlIIIlIIIIll && llllllllllllllIlIIIIIlIIIIlllIIl && !llllllllllllllIlIIIIIlIIIlIIIIlI) {
                        llllllllllllllIlIIIIIlIIIlIIIlIl.addAll(llllllllllllllIlIIIIIlIIIIllIIIl.func_175661_b(llllllllllllllIlIIIIIlIIIlIIlIlI, llllllllllllllIlIIIIIlIIIIllllII));
                    }
                    else {
                        llllllllllllllIlIIIIIlIIIlIIIlIl.addAll(llllllllllllllIlIIIIIlIIIIllIIIl.func_175647_a(llllllllllllllIlIIIIIlIIIlIIlIlI, llllllllllllllIlIIIIIlIIIIlllIII, llllllllllllllIlIIIIIlIIIIllllII));
                    }
                }
                else if (llllllllllllllIlIIIIIlIIIIllIIlI.equals("a")) {
                    llllllllllllllIlIIIIIlIIIlIIIlIl.addAll(llllllllllllllIlIIIIIlIIIIllIIIl.func_175661_b(llllllllllllllIlIIIIIlIIIlIIlIlI, llllllllllllllIlIIIIIlIIIIllllIl));
                }
                else if (!llllllllllllllIlIIIIIlIIIIllIIlI.equals("p") && (!llllllllllllllIlIIIIIlIIIIllIIlI.equals("r") || llllllllllllllIlIIIIIlIIIlIIIIlI)) {
                    llllllllllllllIlIIIIIlIIIlIIIlIl.addAll(llllllllllllllIlIIIIIlIIIIllIIIl.func_175644_a(llllllllllllllIlIIIIIlIIIlIIlIlI, llllllllllllllIlIIIIIlIIIIllllII));
                }
                else {
                    llllllllllllllIlIIIIIlIIIlIIIlIl.addAll(llllllllllllllIlIIIIIlIIIIllIIIl.func_175661_b(llllllllllllllIlIIIIIlIIIlIIlIlI, llllllllllllllIlIIIIIlIIIIllllII));
                }
            }
            else {
                final AxisAlignedBB llllllllllllllIlIIIIIlIIIIllIlll = func_179661_a(llllllllllllllIlIIIIIlIIIlIIIllI, llllllllllllllIlIIIIIlIIIlIIIIIl, llllllllllllllIlIIIIIlIIIlIIIIII, llllllllllllllIlIIIIIlIIIIllllll);
                if (llllllllllllllIlIIIIIlIIIlIIIIll && llllllllllllllIlIIIIIlIIIIlllIIl && !llllllllllllllIlIIIIIlIIIlIIIIlI) {
                    final Predicate llllllllllllllIlIIIIIlIIIIllIllI = (Predicate)new Predicate() {
                        static {
                            __OBFID = "CL_00002360";
                        }
                        
                        public boolean apply(final Object lllIllIlIIlIlI) {
                            return this.func_179609_a((Entity)lllIllIlIIlIlI);
                        }
                        
                        public boolean func_179609_a(final Entity lllIllIlIlIIII) {
                            return lllIllIlIlIIII.posX >= llllllllllllllIlIIIIIlIIIIllIlll.minX && lllIllIlIlIIII.posY >= llllllllllllllIlIIIIIlIIIIllIlll.minY && lllIllIlIlIIII.posZ >= llllllllllllllIlIIIIIlIIIIllIlll.minZ && (lllIllIlIlIIII.posX < llllllllllllllIlIIIIIlIIIIllIlll.maxX && lllIllIlIlIIII.posY < llllllllllllllIlIIIIIlIIIIllIlll.maxY && lllIllIlIlIIII.posZ < llllllllllllllIlIIIIIlIIIIllIlll.maxZ);
                        }
                    };
                    llllllllllllllIlIIIIIlIIIlIIIlIl.addAll(llllllllllllllIlIIIIIlIIIIllIIIl.func_175661_b(llllllllllllllIlIIIIIlIIIlIIlIlI, Predicates.and(llllllllllllllIlIIIIIlIIIIllllII, llllllllllllllIlIIIIIlIIIIllIllI)));
                }
                else {
                    llllllllllllllIlIIIIIlIIIlIIIlIl.addAll(llllllllllllllIlIIIIIlIIIIllIIIl.func_175647_a(llllllllllllllIlIIIIIlIIIlIIlIlI, llllllllllllllIlIIIIIlIIIIllIlll, llllllllllllllIlIIIIIlIIIIllllII));
                }
            }
        }
        else if (llllllllllllllIlIIIIIlIIIIllIIlI.equals("a")) {
            llllllllllllllIlIIIIIlIIIlIIIlIl.addAll(llllllllllllllIlIIIIIlIIIIllIIIl.func_175661_b(llllllllllllllIlIIIIIlIIIlIIlIlI, llllllllllllllIlIIIIIlIIIIllllIl));
        }
        else if (!llllllllllllllIlIIIIIlIIIIllIIlI.equals("p") && (!llllllllllllllIlIIIIIlIIIIllIIlI.equals("r") || llllllllllllllIlIIIIIlIIIlIIIIlI)) {
            llllllllllllllIlIIIIIlIIIlIIIlIl.addAll(llllllllllllllIlIIIIIlIIIIllIIIl.func_175644_a(llllllllllllllIlIIIIIlIIIlIIlIlI, llllllllllllllIlIIIIIlIIIIllllII));
        }
        else {
            llllllllllllllIlIIIIIlIIIlIIIlIl.addAll(llllllllllllllIlIIIIIlIIIIllIIIl.func_175661_b(llllllllllllllIlIIIIIlIIIlIIlIlI, llllllllllllllIlIIIIIlIIIIllllII));
        }
        return llllllllllllllIlIIIIIlIIIlIIIlIl;
    }
    
    private static List func_179654_a(final ICommandSender llllllllllllllIlIIIIIlIIlllIIllI, final Map llllllllllllllIlIIIIIlIIlllIlIII) {
        final ArrayList llllllllllllllIlIIIIIlIIlllIIlll = Lists.newArrayList();
        if (func_179665_h(llllllllllllllIlIIIIIlIIlllIlIII)) {
            llllllllllllllIlIIIIIlIIlllIIlll.add(llllllllllllllIlIIIIIlIIlllIIllI.getEntityWorld());
        }
        else {
            Collections.addAll(llllllllllllllIlIIIIIlIIlllIIlll, MinecraftServer.getServer().worldServers);
        }
        return llllllllllllllIlIIIIIlIIlllIIlll;
    }
    
    public static boolean matchesMultiplePlayers(final String llllllllllllllIlIIIIIIllIlllIlII) {
        final Matcher llllllllllllllIlIIIIIIllIlllIIll = PlayerSelector.tokenPattern.matcher(llllllllllllllIlIIIIIIllIlllIlII);
        if (!llllllllllllllIlIIIIIIllIlllIIll.matches()) {
            return false;
        }
        final Map llllllllllllllIlIIIIIIllIlllIIlI = getArgumentMap(llllllllllllllIlIIIIIIllIlllIIll.group(2));
        final String llllllllllllllIlIIIIIIllIlllIIIl = llllllllllllllIlIIIIIIllIlllIIll.group(1);
        final int llllllllllllllIlIIIIIIllIlllIIII = (!"a".equals(llllllllllllllIlIIIIIIllIlllIIIl) && !"e".equals(llllllllllllllIlIIIIIIllIlllIIIl)) ? 1 : 0;
        return func_179653_a(llllllllllllllIlIIIIIIllIlllIIlI, "c", llllllllllllllIlIIIIIIllIlllIIII) != 1;
    }
    
    private static List func_179657_e(final Map llllllllllllllIlIIIIIlIIlIIllIII) {
        final ArrayList llllllllllllllIlIIIIIlIIlIIlIlll = Lists.newArrayList();
        final Map llllllllllllllIlIIIIIlIIlIIlIllI = func_96560_a(llllllllllllllIlIIIIIlIIlIIllIII);
        if (llllllllllllllIlIIIIIlIIlIIlIllI != null && llllllllllllllIlIIIIIlIIlIIlIllI.size() > 0) {
            llllllllllllllIlIIIIIlIIlIIlIlll.add(new Predicate() {
                static {
                    __OBFID = "CL_00002354";
                }
                
                public boolean apply(final Object llllllllllllllllllIIIIIlIIlIIIIl) {
                    return this.func_179603_a((Entity)llllllllllllllllllIIIIIlIIlIIIIl);
                }
                
                public boolean func_179603_a(final Entity llllllllllllllllllIIIIIlIIlllIIl) {
                    final Scoreboard llllllllllllllllllIIIIIlIIlllIII = MinecraftServer.getServer().worldServerForDimension(0).getScoreboard();
                    for (final Map.Entry llllllllllllllllllIIIIIlIIllIllI : llllllllllllllIlIIIIIlIIlIIlIllI.entrySet()) {
                        String llllllllllllllllllIIIIIlIIllIIll = llllllllllllllllllIIIIIlIIllIllI.getKey();
                        boolean llllllllllllllllllIIIIIlIIllIlIl = false;
                        if (llllllllllllllllllIIIIIlIIllIIll.endsWith("_min") && llllllllllllllllllIIIIIlIIllIIll.length() > 4) {
                            llllllllllllllllllIIIIIlIIllIlIl = true;
                            llllllllllllllllllIIIIIlIIllIIll = llllllllllllllllllIIIIIlIIllIIll.substring(0, llllllllllllllllllIIIIIlIIllIIll.length() - 4);
                        }
                        final ScoreObjective llllllllllllllllllIIIIIlIIllIIlI = llllllllllllllllllIIIIIlIIlllIII.getObjective(llllllllllllllllllIIIIIlIIllIIll);
                        if (llllllllllllllllllIIIIIlIIllIIlI == null) {
                            return false;
                        }
                        final String llllllllllllllllllIIIIIlIIllIIIl = (llllllllllllllllllIIIIIlIIlllIIl instanceof EntityPlayerMP) ? llllllllllllllllllIIIIIlIIlllIIl.getName() : llllllllllllllllllIIIIIlIIlllIIl.getUniqueID().toString();
                        if (!llllllllllllllllllIIIIIlIIlllIII.func_178819_b(llllllllllllllllllIIIIIlIIllIIIl, llllllllllllllllllIIIIIlIIllIIlI)) {
                            return false;
                        }
                        final Score llllllllllllllllllIIIIIlIIllIIII = llllllllllllllllllIIIIIlIIlllIII.getValueFromObjective(llllllllllllllllllIIIIIlIIllIIIl, llllllllllllllllllIIIIIlIIllIIlI);
                        final int llllllllllllllllllIIIIIlIIllIlII = llllllllllllllllllIIIIIlIIllIIII.getScorePoints();
                        if (llllllllllllllllllIIIIIlIIllIlII < llllllllllllllllllIIIIIlIIllIllI.getValue() && llllllllllllllllllIIIIIlIIllIlIl) {
                            return false;
                        }
                        if (llllllllllllllllllIIIIIlIIllIlII > llllllllllllllllllIIIIIlIIllIllI.getValue() && !llllllllllllllllllIIIIIlIIllIlIl) {
                            return false;
                        }
                    }
                    return true;
                }
            });
        }
        return llllllllllllllIlIIIIIlIIlIIlIlll;
    }
    
    private static List func_180698_a(final Map llllllllllllllIlIIIIIlIIIlllllII, final BlockPos llllllllllllllIlIIIIIlIIIlllIlII) {
        final ArrayList llllllllllllllIlIIIIIlIIIllllIlI = Lists.newArrayList();
        final int llllllllllllllIlIIIIIlIIIllllIIl = func_179653_a(llllllllllllllIlIIIIIlIIIlllllII, "rm", -1);
        final int llllllllllllllIlIIIIIlIIIllllIII = func_179653_a(llllllllllllllIlIIIIIlIIIlllllII, "r", -1);
        if (llllllllllllllIlIIIIIlIIIlllIlII != null && (llllllllllllllIlIIIIIlIIIllllIIl >= 0 || llllllllllllllIlIIIIIlIIIllllIII >= 0)) {
            final int llllllllllllllIlIIIIIlIIIlllIlll = llllllllllllllIlIIIIIlIIIllllIIl * llllllllllllllIlIIIIIlIIIllllIIl;
            final int llllllllllllllIlIIIIIlIIIlllIllI = llllllllllllllIlIIIIIlIIIllllIII * llllllllllllllIlIIIIIlIIIllllIII;
            llllllllllllllIlIIIIIlIIIllllIlI.add(new Predicate() {
                static {
                    __OBFID = "CL_00002352";
                }
                
                public boolean apply(final Object lllllllllllllllllIllIlIIIIIlllII) {
                    return this.func_179594_a((Entity)lllllllllllllllllIllIlIIIIIlllII);
                }
                
                public boolean func_179594_a(final Entity lllllllllllllllllIllIlIIIIlIIlII) {
                    final int lllllllllllllllllIllIlIIIIlIIIll = (int)lllllllllllllllllIllIlIIIIlIIlII.func_174831_c(llllllllllllllIlIIIIIlIIIlllIlII);
                    return (llllllllllllllIlIIIIIlIIIllllIIl < 0 || lllllllllllllllllIllIlIIIIlIIIll >= llllllllllllllIlIIIIIlIIIlllIlll) && (llllllllllllllIlIIIIIlIIIllllIII < 0 || lllllllllllllllllIllIlIIIIlIIIll <= llllllllllllllIlIIIIIlIIIlllIllI);
                }
            });
        }
        return llllllllllllllIlIIIIIlIIIllllIlI;
    }
    
    private static List func_179659_d(final Map llllllllllllllIlIIIIIlIIlIlIIlIl) {
        final ArrayList llllllllllllllIlIIIIIlIIlIlIIlII = Lists.newArrayList();
        String llllllllllllllIlIIIIIlIIlIlIIIll = func_179651_b(llllllllllllllIlIIIIIlIIlIlIIlIl, "team");
        final boolean llllllllllllllIlIIIIIlIIlIlIIIlI = llllllllllllllIlIIIIIlIIlIlIIIll != null && llllllllllllllIlIIIIIlIIlIlIIIll.startsWith("!");
        if (llllllllllllllIlIIIIIlIIlIlIIIlI) {
            llllllllllllllIlIIIIIlIIlIlIIIll = llllllllllllllIlIIIIIlIIlIlIIIll.substring(1);
        }
        if (llllllllllllllIlIIIIIlIIlIlIIIll != null) {
            final String llllllllllllllIlIIIIIlIIlIlIIIIl = llllllllllllllIlIIIIIlIIlIlIIIll;
            llllllllllllllIlIIIIIlIIlIlIIlII.add(new Predicate() {
                public boolean apply(final Object llllllllllllllIlIlIIIlIIllllllIl) {
                    return this.func_179621_a((Entity)llllllllllllllIlIlIIIlIIllllllIl);
                }
                
                static {
                    __OBFID = "CL_00002355";
                }
                
                public boolean func_179621_a(final Entity llllllllllllllIlIlIIIlIlIIIIlIll) {
                    if (!(llllllllllllllIlIlIIIlIlIIIIlIll instanceof EntityLivingBase)) {
                        return false;
                    }
                    final EntityLivingBase llllllllllllllIlIlIIIlIlIIIIlIlI = (EntityLivingBase)llllllllllllllIlIlIIIlIlIIIIlIll;
                    final Team llllllllllllllIlIlIIIlIlIIIIlIIl = llllllllllllllIlIlIIIlIlIIIIlIlI.getTeam();
                    final String llllllllllllllIlIlIIIlIlIIIIlIII = (llllllllllllllIlIlIIIlIlIIIIlIIl == null) ? "" : llllllllllllllIlIlIIIlIlIIIIlIIl.getRegisteredName();
                    return llllllllllllllIlIlIIIlIlIIIIlIII.equals(llllllllllllllIlIIIIIlIIlIlIIIIl) ^ llllllllllllllIlIIIIIlIIlIlIIIlI;
                }
            });
        }
        return llllllllllllllIlIIIIIlIIlIlIIlII;
    }
    
    private static Map getArgumentMap(final String llllllllllllllIlIIIIIIllIlIllIlI) {
        final HashMap llllllllllllllIlIIIIIIllIllIIIII = Maps.newHashMap();
        if (llllllllllllllIlIIIIIIllIlIllIlI == null) {
            return llllllllllllllIlIIIIIIllIllIIIII;
        }
        int llllllllllllllIlIIIIIIllIlIlllll = 0;
        int llllllllllllllIlIIIIIIllIlIllllI = -1;
        final Matcher llllllllllllllIlIIIIIIllIlIlllIl = PlayerSelector.intListPattern.matcher(llllllllllllllIlIIIIIIllIlIllIlI);
        while (llllllllllllllIlIIIIIIllIlIlllIl.find()) {
            String llllllllllllllIlIIIIIIllIlIlllII = null;
            switch (llllllllllllllIlIIIIIIllIlIlllll++) {
                case 0: {
                    llllllllllllllIlIIIIIIllIlIlllII = "x";
                    break;
                }
                case 1: {
                    llllllllllllllIlIIIIIIllIlIlllII = "y";
                    break;
                }
                case 2: {
                    llllllllllllllIlIIIIIIllIlIlllII = "z";
                    break;
                }
                case 3: {
                    llllllllllllllIlIIIIIIllIlIlllII = "r";
                    break;
                }
            }
            if (llllllllllllllIlIIIIIIllIlIlllII != null && llllllllllllllIlIIIIIIllIlIlllIl.group(1).length() > 0) {
                llllllllllllllIlIIIIIIllIllIIIII.put(llllllllllllllIlIIIIIIllIlIlllII, llllllllllllllIlIIIIIIllIlIlllIl.group(1));
            }
            llllllllllllllIlIIIIIIllIlIllllI = llllllllllllllIlIIIIIIllIlIlllIl.end();
        }
        if (llllllllllllllIlIIIIIIllIlIllllI < llllllllllllllIlIIIIIIllIlIllIlI.length()) {
            final Matcher llllllllllllllIlIIIIIIllIlIllIll = PlayerSelector.keyValueListPattern.matcher((llllllllllllllIlIIIIIIllIlIllllI == -1) ? llllllllllllllIlIIIIIIllIlIllIlI : llllllllllllllIlIIIIIIllIlIllIlI.substring(llllllllllllllIlIIIIIIllIlIllllI));
            while (llllllllllllllIlIIIIIIllIlIllIll.find()) {
                llllllllllllllIlIIIIIIllIllIIIII.put(llllllllllllllIlIIIIIIllIlIllIll.group(1), llllllllllllllIlIIIIIIllIlIllIll.group(2));
            }
        }
        return llllllllllllllIlIIIIIIllIllIIIII;
    }
    
    public static EntityPlayerMP matchOnePlayer(final ICommandSender llllllllllllllIlIIIIIlIlIIllIIII, final String llllllllllllllIlIIIIIlIlIIlIllll) {
        return (EntityPlayerMP)func_179652_a(llllllllllllllIlIIIIIlIlIIllIIII, llllllllllllllIlIIIIIlIlIIlIllll, EntityPlayerMP.class);
    }
    
    public static IChatComponent func_150869_b(final ICommandSender llllllllllllllIlIIIIIlIlIIIlllII, final String llllllllllllllIlIIIIIlIlIIIllIll) {
        final List llllllllllllllIlIIIIIlIlIIIllIlI = func_179656_b(llllllllllllllIlIIIIIlIlIIIlllII, llllllllllllllIlIIIIIlIlIIIllIll, Entity.class);
        if (llllllllllllllIlIIIIIlIlIIIllIlI.isEmpty()) {
            return null;
        }
        final ArrayList llllllllllllllIlIIIIIlIlIIIllIIl = Lists.newArrayList();
        for (final Entity llllllllllllllIlIIIIIlIlIIIlIlll : llllllllllllllIlIIIIIlIlIIIllIlI) {
            llllllllllllllIlIIIIIlIlIIIllIIl.add(llllllllllllllIlIIIIIlIlIIIlIlll.getDisplayName());
        }
        return CommandBase.join(llllllllllllllIlIIIIIlIlIIIllIIl);
    }
    
    public static Map func_96560_a(final Map llllllllllllllIlIIIIIIlllIIIIIIl) {
        final HashMap llllllllllllllIlIIIIIIlllIIIIlII = Maps.newHashMap();
        for (final String llllllllllllllIlIIIIIIlllIIIIIlI : llllllllllllllIlIIIIIIlllIIIIIIl.keySet()) {
            if (llllllllllllllIlIIIIIIlllIIIIIlI.startsWith("score_") && llllllllllllllIlIIIIIIlllIIIIIlI.length() > "score_".length()) {
                llllllllllllllIlIIIIIIlllIIIIlII.put(llllllllllllllIlIIIIIIlllIIIIIlI.substring("score_".length()), MathHelper.parseIntWithDefault(llllllllllllllIlIIIIIIlllIIIIIIl.get(llllllllllllllIlIIIIIIlllIIIIIlI), 1));
            }
        }
        return llllllllllllllIlIIIIIIlllIIIIlII;
    }
}
