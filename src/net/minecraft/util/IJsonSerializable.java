package net.minecraft.util;

import com.google.gson.*;

public interface IJsonSerializable
{
    JsonElement getSerializableElement();
    
    void func_152753_a(final JsonElement p0);
}
