package net.minecraft.util;

public interface IProgressUpdate
{
    void setLoadingProgress(final int p0);
    
    void displayLoadingString(final String p0);
    
    void resetProgressAndMessage(final String p0);
    
    void displaySavingString(final String p0);
    
    void setDoneWorking();
}
