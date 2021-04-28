package optifine;

import net.minecraft.client.model.*;
import net.minecraft.client.entity.*;

public class PlayerConfiguration
{
    private /* synthetic */ PlayerItemModel[] playerItemModels;
    private /* synthetic */ boolean initialized;
    
    public PlayerConfiguration() {
        this.playerItemModels = new PlayerItemModel[0];
        this.initialized = false;
    }
    
    public void addPlayerItemModel(final PlayerItemModel lllllllllllllllIIllIIlIllllllIIl) {
        this.playerItemModels = (PlayerItemModel[])Config.addObjectToArray(this.playerItemModels, lllllllllllllllIIllIIlIllllllIIl);
    }
    
    public void setInitialized(final boolean lllllllllllllllIIllIIllIIIIIIIlI) {
        this.initialized = lllllllllllllllIIllIIllIIIIIIIlI;
    }
    
    public void renderPlayerItems(final ModelBiped lllllllllllllllIIllIIllIIIIlIlll, final AbstractClientPlayer lllllllllllllllIIllIIllIIIIIllll, final float lllllllllllllllIIllIIllIIIIIlllI, final float lllllllllllllllIIllIIllIIIIIllIl) {
        if (this.initialized) {
            for (int lllllllllllllllIIllIIllIIIIlIIll = 0; lllllllllllllllIIllIIllIIIIlIIll < this.playerItemModels.length; ++lllllllllllllllIIllIIllIIIIlIIll) {
                final PlayerItemModel lllllllllllllllIIllIIllIIIIlIIlI = this.playerItemModels[lllllllllllllllIIllIIllIIIIlIIll];
                lllllllllllllllIIllIIllIIIIlIIlI.render(lllllllllllllllIIllIIllIIIIlIlll, lllllllllllllllIIllIIllIIIIIllll, lllllllllllllllIIllIIllIIIIIlllI, lllllllllllllllIIllIIllIIIIIllIl);
            }
        }
    }
    
    public boolean isInitialized() {
        return this.initialized;
    }
    
    public PlayerItemModel[] getPlayerItemModels() {
        return this.playerItemModels;
    }
}
