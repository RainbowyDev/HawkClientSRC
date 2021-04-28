package net.minecraft.client.gui;

import net.minecraft.entity.player.*;
import java.io.*;
import net.minecraft.init.*;
import io.netty.buffer.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import net.minecraft.nbt.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;
import net.minecraft.client.resources.*;
import net.minecraft.item.*;
import com.google.gson.*;
import com.google.common.collect.*;
import org.lwjgl.input.*;
import org.apache.logging.log4j.*;
import net.minecraft.event.*;
import java.util.*;
import net.minecraft.client.*;

public class GuiScreenBook extends GuiScreen
{
    private final /* synthetic */ boolean bookIsUnsigned;
    private /* synthetic */ List field_175386_A;
    private final /* synthetic */ ItemStack bookObj;
    private /* synthetic */ GuiButton buttonSign;
    private /* synthetic */ int bookImageHeight;
    private /* synthetic */ NBTTagList bookPages;
    private /* synthetic */ int bookImageWidth;
    private /* synthetic */ GuiButton buttonFinalize;
    private /* synthetic */ int currPage;
    private static final /* synthetic */ ResourceLocation bookGuiTextures;
    private /* synthetic */ int field_175387_B;
    private /* synthetic */ GuiButton buttonCancel;
    private /* synthetic */ NextPageButton buttonPreviousPage;
    private /* synthetic */ int bookTotalPages;
    private final /* synthetic */ EntityPlayer editingPlayer;
    private /* synthetic */ boolean bookIsModified;
    private /* synthetic */ NextPageButton buttonNextPage;
    private /* synthetic */ String bookTitle;
    private /* synthetic */ int updateCount;
    private /* synthetic */ GuiButton buttonDone;
    private /* synthetic */ boolean bookGettingSigned;
    
    @Override
    protected void keyTyped(final char lllllllllIlIl, final int lllllllllIIIl) throws IOException {
        super.keyTyped(lllllllllIlIl, lllllllllIIIl);
        if (this.bookIsUnsigned) {
            if (this.bookGettingSigned) {
                this.keyTypedInTitle(lllllllllIlIl, lllllllllIIIl);
            }
            else {
                this.keyTypedInBook(lllllllllIlIl, lllllllllIIIl);
            }
        }
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllll) throws IOException {
        if (lllllllllllll.enabled) {
            if (lllllllllllll.id == 0) {
                this.mc.displayGuiScreen(null);
                this.sendBookToServer(false);
            }
            else if (lllllllllllll.id == 3 && this.bookIsUnsigned) {
                this.bookGettingSigned = true;
            }
            else if (lllllllllllll.id == 1) {
                if (this.currPage < this.bookTotalPages - 1) {
                    ++this.currPage;
                }
                else if (this.bookIsUnsigned) {
                    this.addNewPage();
                    if (this.currPage < this.bookTotalPages - 1) {
                        ++this.currPage;
                    }
                }
            }
            else if (lllllllllllll.id == 2) {
                if (this.currPage > 0) {
                    --this.currPage;
                }
            }
            else if (lllllllllllll.id == 5 && this.bookGettingSigned) {
                this.sendBookToServer(true);
                this.mc.displayGuiScreen(null);
            }
            else if (lllllllllllll.id == 4 && this.bookGettingSigned) {
                this.bookGettingSigned = false;
            }
            this.updateButtons();
        }
    }
    
    private void sendBookToServer(final boolean lIIIIIIIIIIlll) throws IOException {
        if (this.bookIsUnsigned && this.bookIsModified && this.bookPages != null) {
            while (this.bookPages.tagCount() > 1) {
                final String lIIIIIIIIIllll = this.bookPages.getStringTagAt(this.bookPages.tagCount() - 1);
                if (lIIIIIIIIIllll.length() != 0) {
                    break;
                }
                this.bookPages.removeTag(this.bookPages.tagCount() - 1);
            }
            if (this.bookObj.hasTagCompound()) {
                final NBTTagCompound lIIIIIIIIIllIl = this.bookObj.getTagCompound();
                lIIIIIIIIIllIl.setTag("pages", this.bookPages);
            }
            else {
                this.bookObj.setTagInfo("pages", this.bookPages);
            }
            String lIIIIIIIIIlllI = "MC|BEdit";
            if (lIIIIIIIIIIlll) {
                lIIIIIIIIIlllI = "MC|BSign";
                this.bookObj.setTagInfo("author", new NBTTagString(this.editingPlayer.getName()));
                this.bookObj.setTagInfo("title", new NBTTagString(this.bookTitle.trim()));
                for (int lIIIIIIIIIllII = 0; lIIIIIIIIIllII < this.bookPages.tagCount(); ++lIIIIIIIIIllII) {
                    String lIIIIIIIIIlIll = this.bookPages.getStringTagAt(lIIIIIIIIIllII);
                    final ChatComponentText lIIIIIIIIIlIlI = new ChatComponentText(lIIIIIIIIIlIll);
                    lIIIIIIIIIlIll = IChatComponent.Serializer.componentToJson(lIIIIIIIIIlIlI);
                    this.bookPages.set(lIIIIIIIIIllII, new NBTTagString(lIIIIIIIIIlIll));
                }
                this.bookObj.setItem(Items.written_book);
            }
            final PacketBuffer lIIIIIIIIIlIIl = new PacketBuffer(Unpooled.buffer());
            lIIIIIIIIIlIIl.writeItemStackToBuffer(this.bookObj);
            this.mc.getNetHandler().addToSendQueue(new C17PacketCustomPayload(lIIIIIIIIIlllI, lIIIIIIIIIlIIl));
        }
    }
    
    private String pageGetCurrent() {
        return (this.bookPages != null && this.currPage >= 0 && this.currPage < this.bookPages.tagCount()) ? this.bookPages.getStringTagAt(this.currPage) : "";
    }
    
    private void addNewPage() {
        if (this.bookPages != null && this.bookPages.tagCount() < 50) {
            this.bookPages.appendTag(new NBTTagString(""));
            ++this.bookTotalPages;
            this.bookIsModified = true;
        }
    }
    
    private void keyTypedInBook(final char llllllllIlIll, final int llllllllIlIlI) {
        if (GuiScreen.func_175279_e(llllllllIlIlI)) {
            this.pageInsertIntoCurrent(GuiScreen.getClipboardString());
        }
        else {
            switch (llllllllIlIlI) {
                case 14: {
                    final String llllllllIlIIl = this.pageGetCurrent();
                    if (llllllllIlIIl.length() > 0) {
                        this.pageSetCurrent(llllllllIlIIl.substring(0, llllllllIlIIl.length() - 1));
                    }
                }
                case 28:
                case 156: {
                    this.pageInsertIntoCurrent("\n");
                }
                default: {
                    if (ChatAllowedCharacters.isAllowedCharacter(llllllllIlIll)) {
                        this.pageInsertIntoCurrent(Character.toString(llllllllIlIll));
                        break;
                    }
                    break;
                }
            }
        }
    }
    
    @Override
    public void drawScreen(final int llllllIIllllI, final int llllllIIlllIl, final float llllllIIlllII) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiScreenBook.bookGuiTextures);
        final int llllllIllIIlI = (this.width - this.bookImageWidth) / 2;
        final byte llllllIllIIIl = 2;
        this.drawTexturedModalRect(llllllIllIIlI, llllllIllIIIl, 0, 0, this.bookImageWidth, this.bookImageHeight);
        if (this.bookGettingSigned) {
            String llllllIllIIII = this.bookTitle;
            if (this.bookIsUnsigned) {
                if (this.updateCount / 6 % 2 == 0) {
                    llllllIllIIII = String.valueOf(new StringBuilder(String.valueOf(llllllIllIIII)).append(EnumChatFormatting.BLACK).append("_"));
                }
                else {
                    llllllIllIIII = String.valueOf(new StringBuilder(String.valueOf(llllllIllIIII)).append(EnumChatFormatting.GRAY).append("_"));
                }
            }
            final String llllllIlIlllI = I18n.format("book.editTitle", new Object[0]);
            final int llllllIlIllII = this.fontRendererObj.getStringWidth(llllllIlIlllI);
            this.fontRendererObj.drawString(llllllIlIlllI, llllllIllIIlI + 36 + (116 - llllllIlIllII) / 2, llllllIllIIIl + 16 + 16, 0);
            final int llllllIlIlIlI = this.fontRendererObj.getStringWidth(llllllIllIIII);
            this.fontRendererObj.drawString(llllllIllIIII, llllllIllIIlI + 36 + (116 - llllllIlIlIlI) / 2, llllllIllIIIl + 48, 0);
            final String llllllIlIlIII = I18n.format("book.byAuthor", this.editingPlayer.getName());
            final int llllllIlIIlll = this.fontRendererObj.getStringWidth(llllllIlIlIII);
            this.fontRendererObj.drawString(String.valueOf(new StringBuilder().append(EnumChatFormatting.DARK_GRAY).append(llllllIlIlIII)), llllllIllIIlI + 36 + (116 - llllllIlIIlll) / 2, llllllIllIIIl + 48 + 10, 0);
            final String llllllIlIIllI = I18n.format("book.finalizeWarning", new Object[0]);
            this.fontRendererObj.drawSplitString(llllllIlIIllI, llllllIllIIlI + 36, llllllIllIIIl + 80, 116, 0);
        }
        else {
            final String llllllIlIllll = I18n.format("book.pageIndicator", this.currPage + 1, this.bookTotalPages);
            String llllllIlIllIl = "";
            if (this.bookPages != null && this.currPage >= 0 && this.currPage < this.bookPages.tagCount()) {
                llllllIlIllIl = this.bookPages.getStringTagAt(this.currPage);
            }
            if (this.bookIsUnsigned) {
                if (this.fontRendererObj.getBidiFlag()) {
                    llllllIlIllIl = String.valueOf(new StringBuilder(String.valueOf(llllllIlIllIl)).append("_"));
                }
                else if (this.updateCount / 6 % 2 == 0) {
                    llllllIlIllIl = String.valueOf(new StringBuilder(String.valueOf(llllllIlIllIl)).append(EnumChatFormatting.BLACK).append("_"));
                }
                else {
                    llllllIlIllIl = String.valueOf(new StringBuilder(String.valueOf(llllllIlIllIl)).append(EnumChatFormatting.GRAY).append("_"));
                }
            }
            else if (this.field_175387_B != this.currPage) {
                if (ItemEditableBook.validBookTagContents(this.bookObj.getTagCompound())) {
                    try {
                        final IChatComponent llllllIlIIlIl = IChatComponent.Serializer.jsonToComponent(llllllIlIllIl);
                        this.field_175386_A = ((llllllIlIIlIl != null) ? GuiUtilRenderComponents.func_178908_a(llllllIlIIlIl, 116, this.fontRendererObj, true, true) : null);
                    }
                    catch (JsonParseException llllllIlIIlII) {
                        this.field_175386_A = null;
                    }
                }
                else {
                    final ChatComponentText llllllIlIIIll = new ChatComponentText(String.valueOf(new StringBuilder(String.valueOf(EnumChatFormatting.DARK_RED.toString())).append("* Invalid book tag *")));
                    this.field_175386_A = Lists.newArrayList((Iterable)llllllIlIIIll);
                }
                this.field_175387_B = this.currPage;
            }
            final int llllllIlIlIll = this.fontRendererObj.getStringWidth(llllllIlIllll);
            this.fontRendererObj.drawString(llllllIlIllll, llllllIllIIlI - llllllIlIlIll + this.bookImageWidth - 44, llllllIllIIIl + 16, 0);
            if (this.field_175386_A == null) {
                this.fontRendererObj.drawSplitString(llllllIlIllIl, llllllIllIIlI + 36, llllllIllIIIl + 16 + 16, 116, 0);
            }
            else {
                for (int llllllIlIlIIl = Math.min(128 / this.fontRendererObj.FONT_HEIGHT, this.field_175386_A.size()), llllllIlIIIlI = 0; llllllIlIIIlI < llllllIlIlIIl; ++llllllIlIIIlI) {
                    final IChatComponent llllllIlIIIIl = this.field_175386_A.get(llllllIlIIIlI);
                    this.fontRendererObj.drawString(llllllIlIIIIl.getUnformattedText(), llllllIllIIlI + 36, llllllIllIIIl + 16 + 16 + llllllIlIIIlI * this.fontRendererObj.FONT_HEIGHT, 0);
                }
                final IChatComponent llllllIlIIIII = this.func_175385_b(llllllIIllllI, llllllIIlllIl);
                if (llllllIlIIIII != null) {
                    this.func_175272_a(llllllIlIIIII, llllllIIllllI, llllllIIlllIl);
                }
            }
        }
        super.drawScreen(llllllIIllllI, llllllIIlllIl, llllllIIlllII);
    }
    
    @Override
    public void initGui() {
        this.buttonList.clear();
        Keyboard.enableRepeatEvents(true);
        if (this.bookIsUnsigned) {
            final List buttonList = this.buttonList;
            final GuiButton buttonSign = new GuiButton(3, this.width / 2 - 100, 4 + this.bookImageHeight, 98, 20, I18n.format("book.signButton", new Object[0]));
            this.buttonSign = buttonSign;
            buttonList.add(buttonSign);
            final List buttonList2 = this.buttonList;
            final GuiButton buttonDone = new GuiButton(0, this.width / 2 + 2, 4 + this.bookImageHeight, 98, 20, I18n.format("gui.done", new Object[0]));
            this.buttonDone = buttonDone;
            buttonList2.add(buttonDone);
            final List buttonList3 = this.buttonList;
            final GuiButton buttonFinalize = new GuiButton(5, this.width / 2 - 100, 4 + this.bookImageHeight, 98, 20, I18n.format("book.finalizeButton", new Object[0]));
            this.buttonFinalize = buttonFinalize;
            buttonList3.add(buttonFinalize);
            final List buttonList4 = this.buttonList;
            final GuiButton buttonCancel = new GuiButton(4, this.width / 2 + 2, 4 + this.bookImageHeight, 98, 20, I18n.format("gui.cancel", new Object[0]));
            this.buttonCancel = buttonCancel;
            buttonList4.add(buttonCancel);
        }
        else {
            final List buttonList5 = this.buttonList;
            final GuiButton buttonDone2 = new GuiButton(0, this.width / 2 - 100, 4 + this.bookImageHeight, 200, 20, I18n.format("gui.done", new Object[0]));
            this.buttonDone = buttonDone2;
            buttonList5.add(buttonDone2);
        }
        final int lIIIIIIIlIIIII = (this.width - this.bookImageWidth) / 2;
        final byte lIIIIIIIIlllll = 2;
        final List buttonList6 = this.buttonList;
        final NextPageButton buttonNextPage = new NextPageButton(1, lIIIIIIIlIIIII + 120, lIIIIIIIIlllll + 154, true);
        this.buttonNextPage = buttonNextPage;
        buttonList6.add(buttonNextPage);
        final List buttonList7 = this.buttonList;
        final NextPageButton buttonPreviousPage = new NextPageButton(2, lIIIIIIIlIIIII + 38, lIIIIIIIIlllll + 154, false);
        this.buttonPreviousPage = buttonPreviousPage;
        buttonList7.add(buttonPreviousPage);
        this.updateButtons();
    }
    
    public GuiScreenBook(final EntityPlayer lIIIIIIIlIlIll, final ItemStack lIIIIIIIlIlIlI, final boolean lIIIIIIIlIlIIl) {
        this.bookImageWidth = 192;
        this.bookImageHeight = 192;
        this.bookTotalPages = 1;
        this.bookTitle = "";
        this.field_175387_B = -1;
        this.editingPlayer = lIIIIIIIlIlIll;
        this.bookObj = lIIIIIIIlIlIlI;
        this.bookIsUnsigned = lIIIIIIIlIlIIl;
        if (lIIIIIIIlIlIlI.hasTagCompound()) {
            final NBTTagCompound lIIIIIIIlIllIl = lIIIIIIIlIlIlI.getTagCompound();
            this.bookPages = lIIIIIIIlIllIl.getTagList("pages", 8);
            if (this.bookPages != null) {
                this.bookPages = (NBTTagList)this.bookPages.copy();
                this.bookTotalPages = this.bookPages.tagCount();
                if (this.bookTotalPages < 1) {
                    this.bookTotalPages = 1;
                }
            }
        }
        if (this.bookPages == null && lIIIIIIIlIlIIl) {
            this.bookPages = new NBTTagList();
            this.bookPages.appendTag(new NBTTagString(""));
            this.bookTotalPages = 1;
        }
    }
    
    @Override
    public void updateScreen() {
        super.updateScreen();
        ++this.updateCount;
    }
    
    private void keyTypedInTitle(final char lllllllIlllIl, final int lllllllIlllll) throws IOException {
        switch (lllllllIlllll) {
            case 14: {
                if (!this.bookTitle.isEmpty()) {
                    this.bookTitle = this.bookTitle.substring(0, this.bookTitle.length() - 1);
                    this.updateButtons();
                }
            }
            case 28:
            case 156: {
                if (!this.bookTitle.isEmpty()) {
                    this.sendBookToServer(true);
                    this.mc.displayGuiScreen(null);
                }
            }
            default: {
                if (this.bookTitle.length() < 16 && ChatAllowedCharacters.isAllowedCharacter(lllllllIlllIl)) {
                    this.bookTitle = String.valueOf(new StringBuilder(String.valueOf(this.bookTitle)).append(Character.toString(lllllllIlllIl)));
                    this.updateButtons();
                    this.bookIsModified = true;
                }
            }
        }
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }
    
    static {
        __OBFID = "CL_00000744";
        logger = LogManager.getLogger();
        bookGuiTextures = new ResourceLocation("textures/gui/book.png");
    }
    
    @Override
    protected void mouseClicked(final int llllllIIIllII, final int llllllIIIlIll, final int llllllIIIlIlI) throws IOException {
        if (llllllIIIlIlI == 0) {
            final IChatComponent llllllIIIlIIl = this.func_175385_b(llllllIIIllII, llllllIIIlIll);
            if (this.func_175276_a(llllllIIIlIIl)) {
                return;
            }
        }
        super.mouseClicked(llllllIIIllII, llllllIIIlIll, llllllIIIlIlI);
    }
    
    private void pageSetCurrent(final String lllllllIlIlIl) {
        if (this.bookPages != null && this.currPage >= 0 && this.currPage < this.bookPages.tagCount()) {
            this.bookPages.set(this.currPage, new NBTTagString(lllllllIlIlIl));
            this.bookIsModified = true;
        }
    }
    
    private void updateButtons() {
        this.buttonNextPage.visible = (!this.bookGettingSigned && (this.currPage < this.bookTotalPages - 1 || this.bookIsUnsigned));
        this.buttonPreviousPage.visible = (!this.bookGettingSigned && this.currPage > 0);
        this.buttonDone.visible = (!this.bookIsUnsigned || !this.bookGettingSigned);
        if (this.bookIsUnsigned) {
            this.buttonSign.visible = !this.bookGettingSigned;
            this.buttonCancel.visible = this.bookGettingSigned;
            this.buttonFinalize.visible = this.bookGettingSigned;
            this.buttonFinalize.enabled = (this.bookTitle.trim().length() > 0);
        }
    }
    
    @Override
    protected boolean func_175276_a(final IChatComponent lllllIlllllIl) {
        final ClickEvent lllllIlllllII = (lllllIlllllIl == null) ? null : lllllIlllllIl.getChatStyle().getChatClickEvent();
        if (lllllIlllllII == null) {
            return false;
        }
        if (lllllIlllllII.getAction() == ClickEvent.Action.CHANGE_PAGE) {
            final String lllllIllllIll = lllllIlllllII.getValue();
            try {
                final int lllllIllllIlI = Integer.parseInt(lllllIllllIll) - 1;
                if (lllllIllllIlI >= 0 && lllllIllllIlI < this.bookTotalPages && lllllIllllIlI != this.currPage) {
                    this.currPage = lllllIllllIlI;
                    this.updateButtons();
                    return true;
                }
            }
            catch (Throwable t) {}
            return false;
        }
        final boolean lllllIllllIIl = super.func_175276_a(lllllIlllllIl);
        if (lllllIllllIIl && lllllIlllllII.getAction() == ClickEvent.Action.RUN_COMMAND) {
            this.mc.displayGuiScreen(null);
        }
        return lllllIllllIIl;
    }
    
    public IChatComponent func_175385_b(final int lllllIlIlllII, final int lllllIlIllIll) {
        if (this.field_175386_A == null) {
            return null;
        }
        final int lllllIllIIlIl = lllllIlIlllII - (this.width - this.bookImageWidth) / 2 - 36;
        final int lllllIllIIlII = lllllIlIllIll - 2 - 16 - 16;
        if (lllllIllIIlIl < 0 || lllllIllIIlII < 0) {
            return null;
        }
        final int lllllIllIIIll = Math.min(128 / this.fontRendererObj.FONT_HEIGHT, this.field_175386_A.size());
        if (lllllIllIIlIl <= 116 && lllllIllIIlII < this.mc.fontRendererObj.FONT_HEIGHT * lllllIllIIIll + lllllIllIIIll) {
            final int lllllIllIIIlI = lllllIllIIlII / this.mc.fontRendererObj.FONT_HEIGHT;
            if (lllllIllIIIlI >= 0 && lllllIllIIIlI < this.field_175386_A.size()) {
                final IChatComponent lllllIllIIIIl = this.field_175386_A.get(lllllIllIIIlI);
                int lllllIllIIIII = 0;
                for (final IChatComponent lllllIlIllllI : lllllIllIIIIl) {
                    if (lllllIlIllllI instanceof ChatComponentText) {
                        lllllIllIIIII += this.mc.fontRendererObj.getStringWidth(((ChatComponentText)lllllIlIllllI).getChatComponentText_TextValue());
                        if (lllllIllIIIII > lllllIllIIlIl) {
                            return lllllIlIllllI;
                        }
                        continue;
                    }
                }
            }
            return null;
        }
        return null;
    }
    
    private void pageInsertIntoCurrent(final String lllllllIIllII) {
        final String lllllllIIlIll = this.pageGetCurrent();
        final String lllllllIIlIlI = String.valueOf(new StringBuilder(String.valueOf(lllllllIIlIll)).append(lllllllIIllII));
        final int lllllllIIlIIl = this.fontRendererObj.splitStringWidth(String.valueOf(new StringBuilder(String.valueOf(lllllllIIlIlI)).append(EnumChatFormatting.BLACK).append("_")), 118);
        if (lllllllIIlIIl <= 128 && lllllllIIlIlI.length() < 256) {
            this.pageSetCurrent(lllllllIIlIlI);
        }
    }
    
    static class NextPageButton extends GuiButton
    {
        private final /* synthetic */ boolean field_146151_o;
        
        @Override
        public void drawButton(final Minecraft llllllllllllllllIllIIlllIIlllllI, final int llllllllllllllllIllIIlllIlIIIlII, final int llllllllllllllllIllIIlllIIllllII) {
            if (this.visible) {
                final boolean llllllllllllllllIllIIlllIlIIIIlI = llllllllllllllllIllIIlllIlIIIlII >= this.xPosition && llllllllllllllllIllIIlllIIllllII >= this.yPosition && llllllllllllllllIllIIlllIlIIIlII < this.xPosition + this.width && llllllllllllllllIllIIlllIIllllII < this.yPosition + this.height;
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                llllllllllllllllIllIIlllIIlllllI.getTextureManager().bindTexture(GuiScreenBook.bookGuiTextures);
                int llllllllllllllllIllIIlllIlIIIIIl = 0;
                int llllllllllllllllIllIIlllIlIIIIII = 192;
                if (llllllllllllllllIllIIlllIlIIIIlI) {
                    llllllllllllllllIllIIlllIlIIIIIl += 23;
                }
                if (!this.field_146151_o) {
                    llllllllllllllllIllIIlllIlIIIIII += 13;
                }
                this.drawTexturedModalRect(this.xPosition, this.yPosition, llllllllllllllllIllIIlllIlIIIIIl, llllllllllllllllIllIIlllIlIIIIII, 23, 13);
            }
        }
        
        static {
            __OBFID = "CL_00000745";
        }
        
        public NextPageButton(final int llllllllllllllllIllIIlllIlIlIIIl, final int llllllllllllllllIllIIlllIlIlIlIl, final int llllllllllllllllIllIIlllIlIIllll, final boolean llllllllllllllllIllIIlllIlIIlllI) {
            super(llllllllllllllllIllIIlllIlIlIIIl, llllllllllllllllIllIIlllIlIlIlIl, llllllllllllllllIllIIlllIlIIllll, 23, 13, "");
            this.field_146151_o = llllllllllllllllIllIIlllIlIIlllI;
        }
    }
}
