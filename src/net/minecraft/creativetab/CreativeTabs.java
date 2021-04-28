package net.minecraft.creativetab;

import net.minecraft.item.*;
import java.util.*;
import net.minecraft.enchantment.*;
import net.minecraft.init.*;
import net.minecraft.block.*;

public abstract class CreativeTabs
{
    public static final /* synthetic */ CreativeTabs[] creativeTabArray;
    private /* synthetic */ boolean drawTitle;
    private /* synthetic */ boolean hasScrollbar;
    private final /* synthetic */ String tabLabel;
    private /* synthetic */ String theTexture;
    private /* synthetic */ ItemStack iconItemStack;
    private final /* synthetic */ int tabIndex;
    private /* synthetic */ EnumEnchantmentType[] enchantmentTypes;
    
    public boolean drawInForegroundOfTab() {
        return this.drawTitle;
    }
    
    public int getIconItemDamage() {
        return 0;
    }
    
    public boolean hasRelevantEnchantmentType(final EnumEnchantmentType lllllllllllllllllIllIIllIIllllIl) {
        if (this.enchantmentTypes == null) {
            return false;
        }
        for (final EnumEnchantmentType lllllllllllllllllIllIIllIIlllIIl : this.enchantmentTypes) {
            if (lllllllllllllllllIllIIllIIlllIIl == lllllllllllllllllIllIIllIIllllIl) {
                return true;
            }
        }
        return false;
    }
    
    public EnumEnchantmentType[] getRelevantEnchantmentTypes() {
        return this.enchantmentTypes;
    }
    
    public CreativeTabs setRelevantEnchantmentTypes(final EnumEnchantmentType... lllllllllllllllllIllIIllIlIIIlll) {
        this.enchantmentTypes = lllllllllllllllllIllIIllIlIIIlll;
        return this;
    }
    
    public boolean shouldHidePlayerInventory() {
        return this.hasScrollbar;
    }
    
    public int getTabColumn() {
        return this.tabIndex % 6;
    }
    
    public CreativeTabs(final int lllllllllllllllllIllIIllIlllIlll, final String lllllllllllllllllIllIIllIllllIIl) {
        this.theTexture = "items.png";
        this.hasScrollbar = true;
        this.drawTitle = true;
        this.tabIndex = lllllllllllllllllIllIIllIlllIlll;
        this.tabLabel = lllllllllllllllllIllIIllIllllIIl;
        CreativeTabs.creativeTabArray[lllllllllllllllllIllIIllIlllIlll] = this;
    }
    
    public ItemStack getIconItemStack() {
        if (this.iconItemStack == null) {
            this.iconItemStack = new ItemStack(this.getTabIconItem(), 1, this.getIconItemDamage());
        }
        return this.iconItemStack;
    }
    
    public void displayAllReleventItems(final List lllllllllllllllllIllIIllIIlIlIIl) {
        for (final Item lllllllllllllllllIllIIllIIlIlIll : Item.itemRegistry) {
            if (lllllllllllllllllIllIIllIIlIlIll != null && lllllllllllllllllIllIIllIIlIlIll.getCreativeTab() == this) {
                lllllllllllllllllIllIIllIIlIlIll.getSubItems(lllllllllllllllllIllIIllIIlIlIll, this, lllllllllllllllllIllIIllIIlIlIIl);
            }
        }
        if (this.getRelevantEnchantmentTypes() != null) {
            this.addEnchantmentBooksToList(lllllllllllllllllIllIIllIIlIlIIl, this.getRelevantEnchantmentTypes());
        }
    }
    
    public CreativeTabs setNoScrollbar() {
        this.hasScrollbar = false;
        return this;
    }
    
    public String getTranslatedTabLabel() {
        return String.valueOf(new StringBuilder("itemGroup.").append(this.getTabLabel()));
    }
    
    public boolean isTabInFirstRow() {
        return this.tabIndex < 6;
    }
    
    public void addEnchantmentBooksToList(final List lllllllllllllllllIllIIllIIIlllIl, final EnumEnchantmentType... lllllllllllllllllIllIIllIIIlllII) {
        for (final Enchantment lllllllllllllllllIllIIllIIIllIII : Enchantment.enchantmentsList) {
            if (lllllllllllllllllIllIIllIIIllIII != null && lllllllllllllllllIllIIllIIIllIII.type != null) {
                boolean lllllllllllllllllIllIIllIIIlIlll = false;
                for (int lllllllllllllllllIllIIllIIIlIllI = 0; lllllllllllllllllIllIIllIIIlIllI < lllllllllllllllllIllIIllIIIlllII.length && !lllllllllllllllllIllIIllIIIlIlll; ++lllllllllllllllllIllIIllIIIlIllI) {
                    if (lllllllllllllllllIllIIllIIIllIII.type == lllllllllllllllllIllIIllIIIlllII[lllllllllllllllllIllIIllIIIlIllI]) {
                        lllllllllllllllllIllIIllIIIlIlll = true;
                    }
                }
                if (lllllllllllllllllIllIIllIIIlIlll) {
                    lllllllllllllllllIllIIllIIIlllIl.add(Items.enchanted_book.getEnchantedItemStack(new EnchantmentData(lllllllllllllllllIllIIllIIIllIII, lllllllllllllllllIllIIllIIIllIII.getMaxLevel())));
                }
            }
        }
    }
    
    public CreativeTabs setBackgroundImageName(final String lllllllllllllllllIllIIllIllIIIlI) {
        this.theTexture = lllllllllllllllllIllIIllIllIIIlI;
        return this;
    }
    
    public String getTabLabel() {
        return this.tabLabel;
    }
    
    static {
        __OBFID = "CL_00000005";
        creativeTabArray = new CreativeTabs[12];
        tabBlock = new CreativeTabs("buildingBlocks") {
            @Override
            public Item getTabIconItem() {
                return Item.getItemFromBlock(Blocks.brick_block);
            }
            
            static {
                __OBFID = "CL_00000006";
            }
        };
        tabDecorations = new CreativeTabs("decorations") {
            @Override
            public int getIconItemDamage() {
                return BlockDoublePlant.EnumPlantType.PAEONIA.func_176936_a();
            }
            
            @Override
            public Item getTabIconItem() {
                return Item.getItemFromBlock(Blocks.double_plant);
            }
            
            static {
                __OBFID = "CL_00000010";
            }
        };
        tabRedstone = new CreativeTabs("redstone") {
            static {
                __OBFID = "CL_00000011";
            }
            
            @Override
            public Item getTabIconItem() {
                return Items.redstone;
            }
        };
        tabTransport = new CreativeTabs("transportation") {
            static {
                __OBFID = "CL_00000012";
            }
            
            @Override
            public Item getTabIconItem() {
                return Item.getItemFromBlock(Blocks.golden_rail);
            }
        };
        tabMisc = new CreativeTabs("misc") {
            @Override
            public Item getTabIconItem() {
                return Items.lava_bucket;
            }
            
            static {
                __OBFID = "CL_00000014";
            }
        }.setRelevantEnchantmentTypes(EnumEnchantmentType.ALL);
        tabAllSearch = new CreativeTabs("search") {
            static {
                __OBFID = "CL_00000015";
            }
            
            @Override
            public Item getTabIconItem() {
                return Items.compass;
            }
        }.setBackgroundImageName("item_search.png");
        tabFood = new CreativeTabs("food") {
            @Override
            public Item getTabIconItem() {
                return Items.apple;
            }
            
            static {
                __OBFID = "CL_00000016";
            }
        };
        tabTools = new CreativeTabs("tools") {
            @Override
            public Item getTabIconItem() {
                return Items.iron_axe;
            }
            
            static {
                __OBFID = "CL_00000017";
            }
        }.setRelevantEnchantmentTypes(EnumEnchantmentType.DIGGER, EnumEnchantmentType.FISHING_ROD, EnumEnchantmentType.BREAKABLE);
        tabCombat = new CreativeTabs("combat") {
            @Override
            public Item getTabIconItem() {
                return Items.golden_sword;
            }
            
            static {
                __OBFID = "CL_00000018";
            }
        }.setRelevantEnchantmentTypes(EnumEnchantmentType.ARMOR, EnumEnchantmentType.ARMOR_FEET, EnumEnchantmentType.ARMOR_HEAD, EnumEnchantmentType.ARMOR_LEGS, EnumEnchantmentType.ARMOR_TORSO, EnumEnchantmentType.BOW, EnumEnchantmentType.WEAPON);
        tabBrewing = new CreativeTabs("brewing") {
            @Override
            public Item getTabIconItem() {
                return Items.potionitem;
            }
            
            static {
                __OBFID = "CL_00000007";
            }
        };
        tabMaterials = new CreativeTabs("materials") {
            static {
                __OBFID = "CL_00000008";
            }
            
            @Override
            public Item getTabIconItem() {
                return Items.stick;
            }
        };
        tabInventory = new CreativeTabs("inventory") {
            static {
                __OBFID = "CL_00000009";
            }
            
            @Override
            public Item getTabIconItem() {
                return Item.getItemFromBlock(Blocks.chest);
            }
        }.setBackgroundImageName("inventory.png").setNoScrollbar().setNoTitle();
    }
    
    public CreativeTabs setNoTitle() {
        this.drawTitle = false;
        return this;
    }
    
    public abstract Item getTabIconItem();
    
    public int getTabIndex() {
        return this.tabIndex;
    }
    
    public String getBackgroundImageName() {
        return this.theTexture;
    }
}
