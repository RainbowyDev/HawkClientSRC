package net.minecraft.command;

import net.minecraft.entity.player.*;
import net.minecraft.server.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import com.google.common.primitives.*;
import com.google.common.base.*;
import com.google.common.collect.*;
import java.util.*;

public abstract class CommandBase implements ICommand
{
    private static /* synthetic */ IAdminCommand theAdmin;
    
    public static EntityPlayerMP getPlayer(final ICommandSender llllllllllllllIIIlllIlIIIlllIIlI, final String llllllllllllllIIIlllIlIIIllIlllI) throws PlayerNotFoundException {
        EntityPlayerMP llllllllllllllIIIlllIlIIIlllIIII = PlayerSelector.matchOnePlayer(llllllllllllllIIIlllIlIIIlllIIlI, llllllllllllllIIIlllIlIIIllIlllI);
        if (llllllllllllllIIIlllIlIIIlllIIII == null) {
            try {
                llllllllllllllIIIlllIlIIIlllIIII = MinecraftServer.getServer().getConfigurationManager().func_177451_a(UUID.fromString(llllllllllllllIIIlllIlIIIllIlllI));
            }
            catch (IllegalArgumentException ex) {}
        }
        if (llllllllllllllIIIlllIlIIIlllIIII == null) {
            llllllllllllllIIIlllIlIIIlllIIII = MinecraftServer.getServer().getConfigurationManager().getPlayerByUsername(llllllllllllllIIIlllIlIIIllIlllI);
        }
        if (llllllllllllllIIIlllIlIIIlllIIII == null) {
            throw new PlayerNotFoundException();
        }
        return llllllllllllllIIIlllIlIIIlllIIII;
    }
    
    public static List func_175771_a(final String[] llllllllllllllIIIlllIIlllIIIllll, final int llllllllllllllIIIlllIIlllIIlIlII, final BlockPos llllllllllllllIIIlllIIlllIIIllIl) {
        if (llllllllllllllIIIlllIIlllIIIllIl == null) {
            return null;
        }
        String llllllllllllllIIIlllIIlllIIlIIII = null;
        if (llllllllllllllIIIlllIIlllIIIllll.length - 1 == llllllllllllllIIIlllIIlllIIlIlII) {
            final String llllllllllllllIIIlllIIlllIIlIIlI = Integer.toString(llllllllllllllIIIlllIIlllIIIllIl.getX());
        }
        else if (llllllllllllllIIIlllIIlllIIIllll.length - 1 == llllllllllllllIIIlllIIlllIIlIlII + 1) {
            final String llllllllllllllIIIlllIIlllIIlIIIl = Integer.toString(llllllllllllllIIIlllIIlllIIIllIl.getY());
        }
        else {
            if (llllllllllllllIIIlllIIlllIIIllll.length - 1 != llllllllllllllIIIlllIIlllIIlIlII + 2) {
                return null;
            }
            llllllllllllllIIIlllIIlllIIlIIII = Integer.toString(llllllllllllllIIIlllIIlllIIIllIl.getZ());
        }
        return Lists.newArrayList((Object[])new String[] { llllllllllllllIIIlllIIlllIIlIIII });
    }
    
    public static List func_175763_c(final ICommandSender llllllllllllllIIIlllIlIIIlIlIIII, final String llllllllllllllIIIlllIlIIIlIIllll) throws EntityNotFoundException {
        return PlayerSelector.hasArguments(llllllllllllllIIIlllIlIIIlIIllll) ? PlayerSelector.func_179656_b(llllllllllllllIIIlllIlIIIlIlIIII, llllllllllllllIIIlllIlIIIlIIllll, Entity.class) : Lists.newArrayList((Object[])new Entity[] { func_175768_b(llllllllllllllIIIlllIlIIIlIlIIII, llllllllllllllIIIlllIlIIIlIIllll) });
    }
    
    public static double parseDouble(final String llllllllllllllIIIlllIlIIlIIIllII, final double llllllllllllllIIIlllIlIIlIIIlIIl) throws NumberInvalidException {
        return parseDouble(llllllllllllllIIIlllIlIIlIIIllII, llllllllllllllIIIlllIlIIlIIIlIIl, Double.MAX_VALUE);
    }
    
    public static Entity func_175768_b(final ICommandSender llllllllllllllIIIlllIlIIIllIlIIl, final String llllllllllllllIIIlllIlIIIllIlIII) throws EntityNotFoundException {
        return func_175759_a(llllllllllllllIIIlllIlIIIllIlIIl, llllllllllllllIIIlllIlIIIllIlIII, Entity.class);
    }
    
    @Override
    public int compareTo(final Object llllllllllllllIIIlllIIllIlIIIIlI) {
        return this.compareTo((ICommand)llllllllllllllIIIlllIIllIlIIIIlI);
    }
    
    public static boolean doesStringStartWith(final String llllllllllllllIIIlllIIlllIIIIlll, final String llllllllllllllIIIlllIIlllIIIlIII) {
        return llllllllllllllIIIlllIIlllIIIlIII.regionMatches(true, 0, llllllllllllllIIIlllIIlllIIIIlll, 0, llllllllllllllIIIlllIIlllIIIIlll.length());
    }
    
    public static void setAdminCommander(final IAdminCommand llllllllllllllIIIlllIIllIlIIllIl) {
        CommandBase.theAdmin = llllllllllllllIIIlllIIllIlIIllIl;
    }
    
    static {
        __OBFID = "CL_00001739";
    }
    
    public static void notifyOperators(final ICommandSender llllllllllllllIIIlllIIllIlIllIII, final ICommand llllllllllllllIIIlllIIllIlIlIlll, final int llllllllllllllIIIlllIIllIlIlIIIl, final String llllllllllllllIIIlllIIllIlIlIIII, final Object... llllllllllllllIIIlllIIllIlIlIlII) {
        if (CommandBase.theAdmin != null) {
            CommandBase.theAdmin.notifyOperators(llllllllllllllIIIlllIIllIlIllIII, llllllllllllllIIIlllIIllIlIlIlll, llllllllllllllIIIlllIIllIlIlIIIl, llllllllllllllIIIlllIIllIlIlIIII, llllllllllllllIIIlllIIllIlIlIlII);
        }
    }
    
    public static String func_175758_e(final ICommandSender llllllllllllllIIIlllIlIIIIlllIll, final String llllllllllllllIIIlllIlIIIIlllIlI) throws EntityNotFoundException {
        try {
            return getPlayer(llllllllllllllIIIlllIlIIIIlllIll, llllllllllllllIIIlllIlIIIIlllIlI).getName();
        }
        catch (PlayerNotFoundException llllllllllllllIIIlllIlIIIIllllIl) {
            try {
                return func_175768_b(llllllllllllllIIIlllIlIIIIlllIll, llllllllllllllIIIlllIlIIIIlllIlI).getUniqueID().toString();
            }
            catch (EntityNotFoundException llllllllllllllIIIlllIlIIIIllllII) {
                if (PlayerSelector.hasArguments(llllllllllllllIIIlllIlIIIIlllIlI)) {
                    throw llllllllllllllIIIlllIlIIIIllllII;
                }
                return llllllllllllllIIIlllIlIIIIlllIlI;
            }
        }
    }
    
    @Override
    public boolean isUsernameIndex(final String[] llllllllllllllIIIlllIIllIllIlIll, final int llllllllllllllIIIlllIIllIllIlIlI) {
        return false;
    }
    
    public static boolean parseBoolean(final String llllllllllllllIIIlllIlIIIllllIll) throws CommandException {
        if (llllllllllllllIIIlllIlIIIllllIll.equals("true") || llllllllllllllIIIlllIlIIIllllIll.equals("1")) {
            return true;
        }
        if (!llllllllllllllIIIlllIlIIIllllIll.equals("false") && !llllllllllllllIIIlllIlIIIllllIll.equals("0")) {
            throw new CommandException("commands.generic.boolean.invalid", new Object[] { llllllllllllllIIIlllIlIIIllllIll });
        }
        return false;
    }
    
    @Override
    public List getCommandAliases() {
        return Collections.emptyList();
    }
    
    @Override
    public boolean canCommandSenderUseCommand(final ICommandSender llllllllllllllIIIlllIlIIllIlIlIl) {
        return llllllllllllllIIIlllIlIIllIlIlIl.canCommandSenderUseCommand(this.getRequiredPermissionLevel(), this.getCommandName());
    }
    
    public static CoordinateArg func_175767_a(final double llllllllllllllIIIlllIIllllllIllI, String llllllllllllllIIIlllIIlllllIllIl, final int llllllllllllllIIIlllIIllllllIlII, final int llllllllllllllIIIlllIIllllllIIll, final boolean llllllllllllllIIIlllIIlllllIlIlI) throws NumberInvalidException {
        final boolean llllllllllllllIIIlllIIllllllIIIl = llllllllllllllIIIlllIIlllllIllIl.startsWith("~");
        if (llllllllllllllIIIlllIIllllllIIIl && Double.isNaN(llllllllllllllIIIlllIIllllllIllI)) {
            throw new NumberInvalidException("commands.generic.num.invalid", new Object[] { llllllllllllllIIIlllIIllllllIllI });
        }
        double llllllllllllllIIIlllIIllllllIIII = 0.0;
        if (!llllllllllllllIIIlllIIllllllIIIl || llllllllllllllIIIlllIIlllllIllIl.length() > 1) {
            final boolean llllllllllllllIIIlllIIlllllIllll = llllllllllllllIIIlllIIlllllIllIl.contains(".");
            if (llllllllllllllIIIlllIIllllllIIIl) {
                llllllllllllllIIIlllIIlllllIllIl = llllllllllllllIIIlllIIlllllIllIl.substring(1);
            }
            llllllllllllllIIIlllIIllllllIIII += parseDouble(llllllllllllllIIIlllIIlllllIllIl);
            if (!llllllllllllllIIIlllIIlllllIllll && !llllllllllllllIIIlllIIllllllIIIl && llllllllllllllIIIlllIIlllllIlIlI) {
                llllllllllllllIIIlllIIllllllIIII += 0.5;
            }
        }
        if (llllllllllllllIIIlllIIllllllIlII != 0 || llllllllllllllIIIlllIIllllllIIll != 0) {
            if (llllllllllllllIIIlllIIllllllIIII < llllllllllllllIIIlllIIllllllIlII) {
                throw new NumberInvalidException("commands.generic.double.tooSmall", new Object[] { llllllllllllllIIIlllIIllllllIIII, llllllllllllllIIIlllIIllllllIlII });
            }
            if (llllllllllllllIIIlllIIllllllIIII > llllllllllllllIIIlllIIllllllIIll) {
                throw new NumberInvalidException("commands.generic.double.tooBig", new Object[] { llllllllllllllIIIlllIIllllllIIII, llllllllllllllIIIlllIIllllllIIll });
            }
        }
        return new CoordinateArg(llllllllllllllIIIlllIIllllllIIII + (llllllllllllllIIIlllIIllllllIIIl ? llllllllllllllIIIlllIIllllllIllI : 0.0), llllllllllllllIIIlllIIllllllIIII, llllllllllllllIIIlllIIllllllIIIl);
    }
    
    public static Item getItemByText(final ICommandSender llllllllllllllIIIlllIIllllIIIIlI, final String llllllllllllllIIIlllIIlllIlllllI) throws NumberInvalidException {
        final ResourceLocation llllllllllllllIIIlllIIllllIIIIII = new ResourceLocation(llllllllllllllIIIlllIIlllIlllllI);
        final Item llllllllllllllIIIlllIIlllIllllll = (Item)Item.itemRegistry.getObject(llllllllllllllIIIlllIIllllIIIIII);
        if (llllllllllllllIIIlllIIlllIllllll == null) {
            throw new NumberInvalidException("commands.give.notFound", new Object[] { llllllllllllllIIIlllIIllllIIIIII });
        }
        return llllllllllllllIIIlllIIlllIllllll;
    }
    
    public static int parseInt(final String llllllllllllllIIIlllIlIIllIIIllI, final int llllllllllllllIIIlllIlIIllIIIIll) throws NumberInvalidException {
        return parseInt(llllllllllllllIIIlllIlIIllIIIllI, llllllllllllllIIIlllIlIIllIIIIll, Integer.MAX_VALUE);
    }
    
    public static EntityPlayerMP getCommandSenderAsPlayer(final ICommandSender llllllllllllllIIIlllIlIIIllllIII) throws PlayerNotFoundException {
        if (llllllllllllllIIIlllIlIIIllllIII instanceof EntityPlayerMP) {
            return (EntityPlayerMP)llllllllllllllIIIlllIlIIIllllIII;
        }
        throw new PlayerNotFoundException("You must specify which player you wish to perform this action on.", new Object[0]);
    }
    
    public static long parseLong(final String llllllllllllllIIIlllIlIIlIlIllII, final long llllllllllllllIIIlllIlIIlIlIIlll, final long llllllllllllllIIIlllIlIIlIlIlIlI) throws NumberInvalidException {
        final long llllllllllllllIIIlllIlIIlIlIlIIl = parseLong(llllllllllllllIIIlllIlIIlIlIllII);
        if (llllllllllllllIIIlllIlIIlIlIlIIl < llllllllllllllIIIlllIlIIlIlIIlll) {
            throw new NumberInvalidException("commands.generic.num.tooSmall", new Object[] { llllllllllllllIIIlllIlIIlIlIlIIl, llllllllllllllIIIlllIlIIlIlIIlll });
        }
        if (llllllllllllllIIIlllIlIIlIlIlIIl > llllllllllllllIIIlllIlIIlIlIlIlI) {
            throw new NumberInvalidException("commands.generic.num.tooBig", new Object[] { llllllllllllllIIIlllIlIIlIlIlIIl, llllllllllllllIIIlllIlIIlIlIlIlI });
        }
        return llllllllllllllIIIlllIlIIlIlIlIIl;
    }
    
    public static Block getBlockByText(final ICommandSender llllllllllllllIIIlllIIlllIlllIII, final String llllllllllllllIIIlllIIlllIllIlll) throws NumberInvalidException {
        final ResourceLocation llllllllllllllIIIlllIIlllIllIllI = new ResourceLocation(llllllllllllllIIIlllIIlllIllIlll);
        if (!Block.blockRegistry.containsKey(llllllllllllllIIIlllIIlllIllIllI)) {
            throw new NumberInvalidException("commands.give.notFound", new Object[] { llllllllllllllIIIlllIIlllIllIllI });
        }
        final Block llllllllllllllIIIlllIIlllIllIlIl = (Block)Block.blockRegistry.getObject(llllllllllllllIIIlllIIlllIllIllI);
        if (llllllllllllllIIIlllIIlllIllIlIl == null) {
            throw new NumberInvalidException("commands.give.notFound", new Object[] { llllllllllllllIIIlllIIlllIllIllI });
        }
        return llllllllllllllIIIlllIIlllIllIlIl;
    }
    
    public static CoordinateArg func_175770_a(final double llllllllllllllIIIlllIlIIIIIIIIIl, final String llllllllllllllIIIlllIlIIIIIIIIll, final boolean llllllllllllllIIIlllIlIIIIIIIIlI) throws NumberInvalidException {
        return func_175767_a(llllllllllllllIIIlllIlIIIIIIIIIl, llllllllllllllIIIlllIlIIIIIIIIll, -30000000, 30000000, llllllllllllllIIIlllIlIIIIIIIIlI);
    }
    
    public int getRequiredPermissionLevel() {
        return 4;
    }
    
    public static Entity func_175759_a(final ICommandSender llllllllllllllIIIlllIlIIIlIllIII, final String llllllllllllllIIIlllIlIIIlIllllI, final Class llllllllllllllIIIlllIlIIIlIlIllI) throws EntityNotFoundException {
        Object llllllllllllllIIIlllIlIIIlIlllII = PlayerSelector.func_179652_a(llllllllllllllIIIlllIlIIIlIllIII, llllllllllllllIIIlllIlIIIlIllllI, llllllllllllllIIIlllIlIIIlIlIllI);
        final MinecraftServer llllllllllllllIIIlllIlIIIlIllIll = MinecraftServer.getServer();
        if (llllllllllllllIIIlllIlIIIlIlllII == null) {
            llllllllllllllIIIlllIlIIIlIlllII = llllllllllllllIIIlllIlIIIlIllIll.getConfigurationManager().getPlayerByUsername(llllllllllllllIIIlllIlIIIlIllllI);
        }
        if (llllllllllllllIIIlllIlIIIlIlllII == null) {
            try {
                final UUID llllllllllllllIIIlllIlIIIlIllIlI = UUID.fromString(llllllllllllllIIIlllIlIIIlIllllI);
                llllllllllllllIIIlllIlIIIlIlllII = llllllllllllllIIIlllIlIIIlIllIll.getEntityFromUuid(llllllllllllllIIIlllIlIIIlIllIlI);
                if (llllllllllllllIIIlllIlIIIlIlllII == null) {
                    llllllllllllllIIIlllIlIIIlIlllII = llllllllllllllIIIlllIlIIIlIllIll.getConfigurationManager().func_177451_a(llllllllllllllIIIlllIlIIIlIllIlI);
                }
            }
            catch (IllegalArgumentException llllllllllllllIIIlllIlIIIlIllIIl) {
                throw new EntityNotFoundException("commands.generic.entity.invalidUuid", new Object[0]);
            }
        }
        if (llllllllllllllIIIlllIlIIIlIlllII != null && llllllllllllllIIIlllIlIIIlIlIllI.isAssignableFrom(llllllllllllllIIIlllIlIIIlIlllII.getClass())) {
            return (Entity)llllllllllllllIIIlllIlIIIlIlllII;
        }
        throw new EntityNotFoundException();
    }
    
    public static List getListOfStringsMatchingLastWord(final String[] llllllllllllllIIIlllIIlllIIIIIll, final String... llllllllllllllIIIlllIIlllIIIIIlI) {
        return func_175762_a(llllllllllllllIIIlllIIlllIIIIIll, Arrays.asList(llllllllllllllIIIlllIIlllIIIIIlI));
    }
    
    public static BlockPos func_175757_a(final ICommandSender llllllllllllllIIIlllIlIIlIIlllll, final String[] llllllllllllllIIIlllIlIIlIIllllI, final int llllllllllllllIIIlllIlIIlIIlllIl, final boolean llllllllllllllIIIlllIlIIlIIlllII) throws NumberInvalidException {
        final BlockPos llllllllllllllIIIlllIlIIlIIllIll = llllllllllllllIIIlllIlIIlIIlllll.getPosition();
        return new BlockPos(func_175769_b(llllllllllllllIIIlllIlIIlIIllIll.getX(), llllllllllllllIIIlllIlIIlIIllllI[llllllllllllllIIIlllIlIIlIIlllIl], -30000000, 30000000, llllllllllllllIIIlllIlIIlIIlllII), func_175769_b(llllllllllllllIIIlllIlIIlIIllIll.getY(), llllllllllllllIIIlllIlIIlIIllllI[llllllllllllllIIIlllIlIIlIIlllIl + 1], 0, 256, false), func_175769_b(llllllllllllllIIIlllIlIIlIIllIll.getZ(), llllllllllllllIIIlllIlIIlIIllllI[llllllllllllllIIIlllIlIIlIIlllIl + 2], -30000000, 30000000, llllllllllllllIIIlllIlIIlIIlllII));
    }
    
    public static int parseInt(final String llllllllllllllIIIlllIlIIlIlllllI, final int llllllllllllllIIIlllIlIIlIlllIIl, final int llllllllllllllIIIlllIlIIlIllllII) throws NumberInvalidException {
        final int llllllllllllllIIIlllIlIIlIlllIll = parseInt(llllllllllllllIIIlllIlIIlIlllllI);
        if (llllllllllllllIIIlllIlIIlIlllIll < llllllllllllllIIIlllIlIIlIlllIIl) {
            throw new NumberInvalidException("commands.generic.num.tooSmall", new Object[] { llllllllllllllIIIlllIlIIlIlllIll, llllllllllllllIIIlllIlIIlIlllIIl });
        }
        if (llllllllllllllIIIlllIlIIlIlllIll > llllllllllllllIIIlllIlIIlIllllII) {
            throw new NumberInvalidException("commands.generic.num.tooBig", new Object[] { llllllllllllllIIIlllIlIIlIlllIll, llllllllllllllIIIlllIlIIlIllllII });
        }
        return llllllllllllllIIIlllIlIIlIlllIll;
    }
    
    public static double func_175761_b(final double llllllllllllllIIIlllIIlllllIIIll, final String llllllllllllllIIIlllIIllllIlllll, final boolean llllllllllllllIIIlllIIlllllIIIIl) throws NumberInvalidException {
        return func_175769_b(llllllllllllllIIIlllIIlllllIIIll, llllllllllllllIIIlllIIllllIlllll, -30000000, 30000000, llllllllllllllIIIlllIIlllllIIIIl);
    }
    
    public static IChatComponent join(final List llllllllllllllIIIlllIIlllIIlllll) {
        final ChatComponentText llllllllllllllIIIlllIIlllIlIIIIl = new ChatComponentText("");
        for (int llllllllllllllIIIlllIIlllIlIIIII = 0; llllllllllllllIIIlllIIlllIlIIIII < llllllllllllllIIIlllIIlllIIlllll.size(); ++llllllllllllllIIIlllIIlllIlIIIII) {
            if (llllllllllllllIIIlllIIlllIlIIIII > 0) {
                if (llllllllllllllIIIlllIIlllIlIIIII == llllllllllllllIIIlllIIlllIIlllll.size() - 1) {
                    llllllllllllllIIIlllIIlllIlIIIIl.appendText(" and ");
                }
                else if (llllllllllllllIIIlllIIlllIlIIIII > 0) {
                    llllllllllllllIIIlllIIlllIlIIIIl.appendText(", ");
                }
            }
            llllllllllllllIIIlllIIlllIlIIIIl.appendSibling(llllllllllllllIIIlllIIlllIIlllll.get(llllllllllllllIIIlllIIlllIlIIIII));
        }
        return llllllllllllllIIIlllIIlllIlIIIIl;
    }
    
    public static double parseDouble(final String llllllllllllllIIIlllIlIIlIIIIIII, final double llllllllllllllIIIlllIlIIIlllllll, final double llllllllllllllIIIlllIlIIIllllllI) throws NumberInvalidException {
        final double llllllllllllllIIIlllIlIIlIIIIIIl = parseDouble(llllllllllllllIIIlllIlIIlIIIIIII);
        if (llllllllllllllIIIlllIlIIlIIIIIIl < llllllllllllllIIIlllIlIIIlllllll) {
            throw new NumberInvalidException("commands.generic.double.tooSmall", new Object[] { llllllllllllllIIIlllIlIIlIIIIIIl, llllllllllllllIIIlllIlIIIlllllll });
        }
        if (llllllllllllllIIIlllIlIIlIIIIIIl > llllllllllllllIIIlllIlIIIllllllI) {
            throw new NumberInvalidException("commands.generic.double.tooBig", new Object[] { llllllllllllllIIIlllIlIIlIIIIIIl, llllllllllllllIIIlllIlIIIllllllI });
        }
        return llllllllllllllIIIlllIlIIlIIIIIIl;
    }
    
    public static void notifyOperators(final ICommandSender llllllllllllllIIIlllIIllIllIIIIl, final ICommand llllllllllllllIIIlllIIllIllIIIII, final String llllllllllllllIIIlllIIllIllIIIll, final Object... llllllllllllllIIIlllIIllIlIllllI) {
        notifyOperators(llllllllllllllIIIlllIIllIllIIIIl, llllllllllllllIIIlllIIllIllIIIII, 0, llllllllllllllIIIlllIIllIllIIIll, llllllllllllllIIIlllIIllIlIllllI);
    }
    
    public static String func_180529_a(final String[] llllllllllllllIIIlllIlIIIIIlIIIl, final int llllllllllllllIIIlllIlIIIIIlIIII) {
        final StringBuilder llllllllllllllIIIlllIlIIIIIIllll = new StringBuilder();
        for (int llllllllllllllIIIlllIlIIIIIIlllI = llllllllllllllIIIlllIlIIIIIlIIII; llllllllllllllIIIlllIlIIIIIIlllI < llllllllllllllIIIlllIlIIIIIlIIIl.length; ++llllllllllllllIIIlllIlIIIIIIlllI) {
            if (llllllllllllllIIIlllIlIIIIIIlllI > llllllllllllllIIIlllIlIIIIIlIIII) {
                llllllllllllllIIIlllIlIIIIIIllll.append(" ");
            }
            final String llllllllllllllIIIlllIlIIIIIIllIl = llllllllllllllIIIlllIlIIIIIlIIIl[llllllllllllllIIIlllIlIIIIIIlllI];
            llllllllllllllIIIlllIlIIIIIIllll.append(llllllllllllllIIIlllIlIIIIIIllIl);
        }
        return String.valueOf(llllllllllllllIIIlllIlIIIIIIllll);
    }
    
    public static String joinNiceString(final Object[] llllllllllllllIIIlllIIlllIlIlIIl) {
        final StringBuilder llllllllllllllIIIlllIIlllIlIllII = new StringBuilder();
        for (int llllllllllllllIIIlllIIlllIlIlIll = 0; llllllllllllllIIIlllIIlllIlIlIll < llllllllllllllIIIlllIIlllIlIlIIl.length; ++llllllllllllllIIIlllIIlllIlIlIll) {
            final String llllllllllllllIIIlllIIlllIlIlIlI = llllllllllllllIIIlllIIlllIlIlIIl[llllllllllllllIIIlllIIlllIlIlIll].toString();
            if (llllllllllllllIIIlllIIlllIlIlIll > 0) {
                if (llllllllllllllIIIlllIIlllIlIlIll == llllllllllllllIIIlllIIlllIlIlIIl.length - 1) {
                    llllllllllllllIIIlllIIlllIlIllII.append(" and ");
                }
                else {
                    llllllllllllllIIIlllIIlllIlIllII.append(", ");
                }
            }
            llllllllllllllIIIlllIIlllIlIllII.append(llllllllllllllIIIlllIIlllIlIlIlI);
        }
        return String.valueOf(llllllllllllllIIIlllIIlllIlIllII);
    }
    
    public int compareTo(final ICommand llllllllllllllIIIlllIIllIlIIlIII) {
        return this.getCommandName().compareTo(llllllllllllllIIIlllIIllIlIIlIII.getCommandName());
    }
    
    public static long parseLong(final String llllllllllllllIIIlllIlIIlIllIlII) throws NumberInvalidException {
        try {
            return Long.parseLong(llllllllllllllIIIlllIlIIlIllIlII);
        }
        catch (NumberFormatException llllllllllllllIIIlllIlIIlIllIIll) {
            throw new NumberInvalidException("commands.generic.num.invalid", new Object[] { llllllllllllllIIIlllIlIIlIllIlII });
        }
    }
    
    public static double parseDouble(final String llllllllllllllIIIlllIlIIlIIlIIII) throws NumberInvalidException {
        try {
            final double llllllllllllllIIIlllIlIIlIIlIIlI = Double.parseDouble(llllllllllllllIIIlllIlIIlIIlIIII);
            if (!Doubles.isFinite(llllllllllllllIIIlllIlIIlIIlIIlI)) {
                throw new NumberInvalidException("commands.generic.num.invalid", new Object[] { llllllllllllllIIIlllIlIIlIIlIIII });
            }
            return llllllllllllllIIIlllIlIIlIIlIIlI;
        }
        catch (NumberFormatException llllllllllllllIIIlllIlIIlIIlIIIl) {
            throw new NumberInvalidException("commands.generic.num.invalid", new Object[] { llllllllllllllIIIlllIlIIlIIlIIII });
        }
    }
    
    public static double func_175769_b(final double llllllllllllllIIIlllIIllllIlIlIl, String llllllllllllllIIIlllIIllllIIllII, final int llllllllllllllIIIlllIIllllIIlIll, final int llllllllllllllIIIlllIIllllIlIIlI, final boolean llllllllllllllIIIlllIIllllIIlIIl) throws NumberInvalidException {
        final boolean llllllllllllllIIIlllIIllllIlIIII = llllllllllllllIIIlllIIllllIIllII.startsWith("~");
        if (llllllllllllllIIIlllIIllllIlIIII && Double.isNaN(llllllllllllllIIIlllIIllllIlIlIl)) {
            throw new NumberInvalidException("commands.generic.num.invalid", new Object[] { llllllllllllllIIIlllIIllllIlIlIl });
        }
        double llllllllllllllIIIlllIIllllIIllll = llllllllllllllIIIlllIIllllIlIIII ? llllllllllllllIIIlllIIllllIlIlIl : 0.0;
        if (!llllllllllllllIIIlllIIllllIlIIII || llllllllllllllIIIlllIIllllIIllII.length() > 1) {
            final boolean llllllllllllllIIIlllIIllllIIlllI = llllllllllllllIIIlllIIllllIIllII.contains(".");
            if (llllllllllllllIIIlllIIllllIlIIII) {
                llllllllllllllIIIlllIIllllIIllII = llllllllllllllIIIlllIIllllIIllII.substring(1);
            }
            llllllllllllllIIIlllIIllllIIllll += parseDouble(llllllllllllllIIIlllIIllllIIllII);
            if (!llllllllllllllIIIlllIIllllIIlllI && !llllllllllllllIIIlllIIllllIlIIII && llllllllllllllIIIlllIIllllIIlIIl) {
                llllllllllllllIIIlllIIllllIIllll += 0.5;
            }
        }
        if (llllllllllllllIIIlllIIllllIIlIll != 0 || llllllllllllllIIIlllIIllllIlIIlI != 0) {
            if (llllllllllllllIIIlllIIllllIIllll < llllllllllllllIIIlllIIllllIIlIll) {
                throw new NumberInvalidException("commands.generic.double.tooSmall", new Object[] { llllllllllllllIIIlllIIllllIIllll, llllllllllllllIIIlllIIllllIIlIll });
            }
            if (llllllllllllllIIIlllIIllllIIllll > llllllllllllllIIIlllIIllllIlIIlI) {
                throw new NumberInvalidException("commands.generic.double.tooBig", new Object[] { llllllllllllllIIIlllIIllllIIllll, llllllllllllllIIIlllIIllllIlIIlI });
            }
        }
        return llllllllllllllIIIlllIIllllIIllll;
    }
    
    public static String getPlayerName(final ICommandSender llllllllllllllIIIlllIlIIIlIIlIIl, final String llllllllllllllIIIlllIlIIIlIIlIII) throws PlayerNotFoundException {
        try {
            return getPlayer(llllllllllllllIIIlllIlIIIlIIlIIl, llllllllllllllIIIlllIlIIIlIIlIII).getName();
        }
        catch (PlayerNotFoundException llllllllllllllIIIlllIlIIIlIIIlll) {
            if (PlayerSelector.hasArguments(llllllllllllllIIIlllIlIIIlIIlIII)) {
                throw llllllllllllllIIIlllIlIIIlIIIlll;
            }
            return llllllllllllllIIIlllIlIIIlIIlIII;
        }
    }
    
    public static int parseInt(final String llllllllllllllIIIlllIlIIllIIlIlI) throws NumberInvalidException {
        try {
            return Integer.parseInt(llllllllllllllIIIlllIlIIllIIlIlI);
        }
        catch (NumberFormatException llllllllllllllIIIlllIlIIllIIlIll) {
            throw new NumberInvalidException("commands.generic.num.invalid", new Object[] { llllllllllllllIIIlllIlIIllIIlIlI });
        }
    }
    
    public static String joinNiceStringFromCollection(final Collection llllllllllllllIIIlllIIlllIIllIlI) {
        return joinNiceString(llllllllllllllIIIlllIIlllIIllIlI.toArray(new String[llllllllllllllIIIlllIIlllIIllIlI.size()]));
    }
    
    public static IChatComponent getChatComponentFromNthArg(final ICommandSender llllllllllllllIIIlllIlIIIIllIIIl, final String[] llllllllllllllIIIlllIlIIIIllIIll, final int llllllllllllllIIIlllIlIIIIlIllll) throws CommandException {
        return getChatComponentFromNthArg(llllllllllllllIIIlllIlIIIIllIIIl, llllllllllllllIIIlllIlIIIIllIIll, llllllllllllllIIIlllIlIIIIlIllll, false);
    }
    
    public static List func_175762_a(final String[] llllllllllllllIIIlllIIllIllllIIl, final Collection llllllllllllllIIIlllIIllIlllIIIl) {
        final String llllllllllllllIIIlllIIllIlllIlll = llllllllllllllIIIlllIIllIllllIIl[llllllllllllllIIIlllIIllIllllIIl.length - 1];
        final ArrayList llllllllllllllIIIlllIIllIlllIllI = Lists.newArrayList();
        if (!llllllllllllllIIIlllIIllIlllIIIl.isEmpty()) {
            for (final String llllllllllllllIIIlllIIllIlllIlII : Iterables.transform((Iterable)llllllllllllllIIIlllIIllIlllIIIl, Functions.toStringFunction())) {
                if (doesStringStartWith(llllllllllllllIIIlllIIllIlllIlll, llllllllllllllIIIlllIIllIlllIlII)) {
                    llllllllllllllIIIlllIIllIlllIllI.add(llllllllllllllIIIlllIIllIlllIlII);
                }
            }
            if (llllllllllllllIIIlllIIllIlllIllI.isEmpty()) {
                for (final Object llllllllllllllIIIlllIIllIlllIIll : llllllllllllllIIIlllIIllIlllIIIl) {
                    if (llllllllllllllIIIlllIIllIlllIIll instanceof ResourceLocation && doesStringStartWith(llllllllllllllIIIlllIIllIlllIlll, ((ResourceLocation)llllllllllllllIIIlllIIllIlllIIll).getResourcePath())) {
                        llllllllllllllIIIlllIIllIlllIllI.add(String.valueOf(llllllllllllllIIIlllIIllIlllIIll));
                    }
                }
            }
        }
        return llllllllllllllIIIlllIIllIlllIllI;
    }
    
    @Override
    public List addTabCompletionOptions(final ICommandSender llllllllllllllIIIlllIlIIllIlIIIl, final String[] llllllllllllllIIIlllIlIIllIlIIII, final BlockPos llllllllllllllIIIlllIlIIllIIllll) {
        return null;
    }
    
    public static IChatComponent getChatComponentFromNthArg(final ICommandSender llllllllllllllIIIlllIlIIIIIllllI, final String[] llllllllllllllIIIlllIlIIIIIlllIl, final int llllllllllllllIIIlllIlIIIIlIIlII, final boolean llllllllllllllIIIlllIlIIIIIllIll) throws PlayerNotFoundException {
        final ChatComponentText llllllllllllllIIIlllIlIIIIlIIIlI = new ChatComponentText("");
        for (int llllllllllllllIIIlllIlIIIIlIIIIl = llllllllllllllIIIlllIlIIIIlIIlII; llllllllllllllIIIlllIlIIIIlIIIIl < llllllllllllllIIIlllIlIIIIIlllIl.length; ++llllllllllllllIIIlllIlIIIIlIIIIl) {
            if (llllllllllllllIIIlllIlIIIIlIIIIl > llllllllllllllIIIlllIlIIIIlIIlII) {
                llllllllllllllIIIlllIlIIIIlIIIlI.appendText(" ");
            }
            Object llllllllllllllIIIlllIlIIIIlIIIII = new ChatComponentText(llllllllllllllIIIlllIlIIIIIlllIl[llllllllllllllIIIlllIlIIIIlIIIIl]);
            if (llllllllllllllIIIlllIlIIIIIllIll) {
                final IChatComponent llllllllllllllIIIlllIlIIIIIlllll = PlayerSelector.func_150869_b(llllllllllllllIIIlllIlIIIIIllllI, llllllllllllllIIIlllIlIIIIIlllIl[llllllllllllllIIIlllIlIIIIlIIIIl]);
                if (llllllllllllllIIIlllIlIIIIIlllll == null) {
                    if (PlayerSelector.hasArguments(llllllllllllllIIIlllIlIIIIIlllIl[llllllllllllllIIIlllIlIIIIlIIIIl])) {
                        throw new PlayerNotFoundException();
                    }
                }
                else {
                    llllllllllllllIIIlllIlIIIIlIIIII = llllllllllllllIIIlllIlIIIIIlllll;
                }
            }
            llllllllllllllIIIlllIlIIIIlIIIlI.appendSibling((IChatComponent)llllllllllllllIIIlllIlIIIIlIIIII);
        }
        return llllllllllllllIIIlllIlIIIIlIIIlI;
    }
    
    public static class CoordinateArg
    {
        private final /* synthetic */ double field_179633_a;
        private final /* synthetic */ boolean field_179632_c;
        private final /* synthetic */ double field_179631_b;
        
        static {
            __OBFID = "CL_00002365";
        }
        
        public boolean func_179630_c() {
            return this.field_179632_c;
        }
        
        public double func_179629_b() {
            return this.field_179631_b;
        }
        
        protected CoordinateArg(final double llllIIlIIlIlI, final double llllIIlIIllll, final boolean llllIIlIIllIl) {
            this.field_179633_a = llllIIlIIlIlI;
            this.field_179631_b = llllIIlIIllll;
            this.field_179632_c = llllIIlIIllIl;
        }
        
        public double func_179628_a() {
            return this.field_179633_a;
        }
    }
}
