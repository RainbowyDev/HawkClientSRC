package org.json;

import java.io.*;

public class JSONStringer extends JSONWriter
{
    @Override
    public String toString() {
        return (this.mode == 'd') ? this.writer.toString() : null;
    }
    
    public JSONStringer() {
        super(new StringWriter());
    }
}
