package org.json;

import java.util.*;
import java.io.*;

public class XMLTokener extends JSONTokener
{
    public static final /* synthetic */ HashMap<String, Character> entity;
    
    public Object nextToken() throws JSONException {
        char lllllllllllllllllIIllIlIIIllIIII;
        do {
            lllllllllllllllllIIllIlIIIllIIII = this.next();
        } while (Character.isWhitespace(lllllllllllllllllIIllIlIIIllIIII));
        switch (lllllllllllllllllIIllIlIIIllIIII) {
            case '\0': {
                throw this.syntaxError("Misshaped element");
            }
            case '<': {
                throw this.syntaxError("Misplaced '<'");
            }
            case '>': {
                return XML.GT;
            }
            case '/': {
                return XML.SLASH;
            }
            case '=': {
                return XML.EQ;
            }
            case '!': {
                return XML.BANG;
            }
            case '?': {
                return XML.QUEST;
            }
            case '\"':
            case '\'': {
                final char lllllllllllllllllIIllIlIIIlIllll = lllllllllllllllllIIllIlIIIllIIII;
                final StringBuilder lllllllllllllllllIIllIlIIIlIlllI = new StringBuilder();
                while (true) {
                    lllllllllllllllllIIllIlIIIllIIII = this.next();
                    if (lllllllllllllllllIIllIlIIIllIIII == '\0') {
                        throw this.syntaxError("Unterminated string");
                    }
                    if (lllllllllllllllllIIllIlIIIllIIII == lllllllllllllllllIIllIlIIIlIllll) {
                        return String.valueOf(lllllllllllllllllIIllIlIIIlIlllI);
                    }
                    if (lllllllllllllllllIIllIlIIIllIIII == '&') {
                        lllllllllllllllllIIllIlIIIlIlllI.append(this.nextEntity(lllllllllllllllllIIllIlIIIllIIII));
                    }
                    else {
                        lllllllllllllllllIIllIlIIIlIlllI.append(lllllllllllllllllIIllIlIIIllIIII);
                    }
                }
                break;
            }
            default: {
                final StringBuilder lllllllllllllllllIIllIlIIIlIllIl = new StringBuilder();
                while (true) {
                    lllllllllllllllllIIllIlIIIlIllIl.append(lllllllllllllllllIIllIlIIIllIIII);
                    lllllllllllllllllIIllIlIIIllIIII = this.next();
                    if (Character.isWhitespace(lllllllllllllllllIIllIlIIIllIIII)) {
                        return String.valueOf(lllllllllllllllllIIllIlIIIlIllIl);
                    }
                    switch (lllllllllllllllllIIllIlIIIllIIII) {
                        case '\0': {
                            return String.valueOf(lllllllllllllllllIIllIlIIIlIllIl);
                        }
                        case '!':
                        case '/':
                        case '=':
                        case '>':
                        case '?':
                        case '[':
                        case ']': {
                            this.back();
                            return String.valueOf(lllllllllllllllllIIllIlIIIlIllIl);
                        }
                        case '\"':
                        case '\'':
                        case '<': {
                            throw this.syntaxError("Bad character in a name");
                        }
                        default: {
                            continue;
                        }
                    }
                }
                break;
            }
        }
    }
    
    public XMLTokener(final String lllllllllllllllllIIllIlIIllIlIIl) {
        super(lllllllllllllllllIIllIlIIllIlIIl);
    }
    
    public XMLTokener(final Reader lllllllllllllllllIIllIlIIllIllll) {
        super(lllllllllllllllllIIllIlIIllIllll);
    }
    
    static String unescapeEntity(final String lllllllllllllllllIIllIlIIlIIIIlI) {
        if (lllllllllllllllllIIllIlIIlIIIIlI == null || lllllllllllllllllIIllIlIIlIIIIlI.isEmpty()) {
            return "";
        }
        if (lllllllllllllllllIIllIlIIlIIIIlI.charAt(0) == '#') {
            int lllllllllllllllllIIllIlIIlIIIIll = 0;
            if (lllllllllllllllllIIllIlIIlIIIIlI.charAt(1) == 'x') {
                final int lllllllllllllllllIIllIlIIlIIIlII = Integer.parseInt(lllllllllllllllllIIllIlIIlIIIIlI.substring(2), 16);
            }
            else {
                lllllllllllllllllIIllIlIIlIIIIll = Integer.parseInt(lllllllllllllllllIIllIlIIlIIIIlI.substring(1));
            }
            return new String(new int[] { lllllllllllllllllIIllIlIIlIIIIll }, 0, 1);
        }
        final Character lllllllllllllllllIIllIlIIlIIIIIl = XMLTokener.entity.get(lllllllllllllllllIIllIlIIlIIIIlI);
        if (lllllllllllllllllIIllIlIIlIIIIIl == null) {
            return String.valueOf(new StringBuilder().append('&').append(lllllllllllllllllIIllIlIIlIIIIlI).append(';'));
        }
        return lllllllllllllllllIIllIlIIlIIIIIl.toString();
    }
    
    public Object nextMeta() throws JSONException {
        char lllllllllllllllllIIllIlIIIlllIlI;
        do {
            lllllllllllllllllIIllIlIIIlllIlI = this.next();
        } while (Character.isWhitespace(lllllllllllllllllIIllIlIIIlllIlI));
        switch (lllllllllllllllllIIllIlIIIlllIlI) {
            case '\0': {
                throw this.syntaxError("Misshaped meta tag");
            }
            case '<': {
                return XML.LT;
            }
            case '>': {
                return XML.GT;
            }
            case '/': {
                return XML.SLASH;
            }
            case '=': {
                return XML.EQ;
            }
            case '!': {
                return XML.BANG;
            }
            case '?': {
                return XML.QUEST;
            }
            case '\"':
            case '\'': {
                final char lllllllllllllllllIIllIlIIIlllIIl = lllllllllllllllllIIllIlIIIlllIlI;
                do {
                    lllllllllllllllllIIllIlIIIlllIlI = this.next();
                    if (lllllllllllllllllIIllIlIIIlllIlI == '\0') {
                        throw this.syntaxError("Unterminated string");
                    }
                } while (lllllllllllllllllIIllIlIIIlllIlI != lllllllllllllllllIIllIlIIIlllIIl);
                return Boolean.TRUE;
            }
            default: {
                while (true) {
                    lllllllllllllllllIIllIlIIIlllIlI = this.next();
                    if (Character.isWhitespace(lllllllllllllllllIIllIlIIIlllIlI)) {
                        return Boolean.TRUE;
                    }
                    switch (lllllllllllllllllIIllIlIIIlllIlI) {
                        case '\0': {
                            throw this.syntaxError("Unterminated string");
                        }
                        case '!':
                        case '\"':
                        case '\'':
                        case '/':
                        case '<':
                        case '=':
                        case '>':
                        case '?': {
                            this.back();
                            return Boolean.TRUE;
                        }
                        default: {
                            continue;
                        }
                    }
                }
                break;
            }
        }
    }
    
    static {
        (entity = new HashMap<String, Character>(8)).put("amp", XML.AMP);
        XMLTokener.entity.put("apos", XML.APOS);
        XMLTokener.entity.put("gt", XML.GT);
        XMLTokener.entity.put("lt", XML.LT);
        XMLTokener.entity.put("quot", XML.QUOT);
    }
    
    public Object nextContent() throws JSONException {
        char lllllllllllllllllIIllIlIIlIlIllI;
        do {
            lllllllllllllllllIIllIlIIlIlIllI = this.next();
        } while (Character.isWhitespace(lllllllllllllllllIIllIlIIlIlIllI));
        if (lllllllllllllllllIIllIlIIlIlIllI == '\0') {
            return null;
        }
        if (lllllllllllllllllIIllIlIIlIlIllI == '<') {
            return XML.LT;
        }
        final StringBuilder lllllllllllllllllIIllIlIIlIlIlIl = new StringBuilder();
        while (lllllllllllllllllIIllIlIIlIlIllI != '\0') {
            if (lllllllllllllllllIIllIlIIlIlIllI == '<') {
                this.back();
                return String.valueOf(lllllllllllllllllIIllIlIIlIlIlIl).trim();
            }
            if (lllllllllllllllllIIllIlIIlIlIllI == '&') {
                lllllllllllllllllIIllIlIIlIlIlIl.append(this.nextEntity(lllllllllllllllllIIllIlIIlIlIllI));
            }
            else {
                lllllllllllllllllIIllIlIIlIlIlIl.append(lllllllllllllllllIIllIlIIlIlIllI);
            }
            lllllllllllllllllIIllIlIIlIlIllI = this.next();
        }
        return String.valueOf(lllllllllllllllllIIllIlIIlIlIlIl).trim();
    }
    
    public void skipPast(final String lllllllllllllllllIIllIlIIIIlIlII) {
        int lllllllllllllllllIIllIlIIIIllIII = 0;
        final int lllllllllllllllllIIllIlIIIIlIlll = lllllllllllllllllIIllIlIIIIlIlII.length();
        final char[] lllllllllllllllllIIllIlIIIIlIllI = new char[lllllllllllllllllIIllIlIIIIlIlll];
        for (int lllllllllllllllllIIllIlIIIIllIlI = 0; lllllllllllllllllIIllIlIIIIllIlI < lllllllllllllllllIIllIlIIIIlIlll; ++lllllllllllllllllIIllIlIIIIllIlI) {
            final char lllllllllllllllllIIllIlIIIIlllll = this.next();
            if (lllllllllllllllllIIllIlIIIIlllll == '\0') {
                return;
            }
            lllllllllllllllllIIllIlIIIIlIllI[lllllllllllllllllIIllIlIIIIllIlI] = lllllllllllllllllIIllIlIIIIlllll;
        }
        while (true) {
            int lllllllllllllllllIIllIlIIIIllIIl = lllllllllllllllllIIllIlIIIIllIII;
            boolean lllllllllllllllllIIllIlIIIIlllII = true;
            for (int lllllllllllllllllIIllIlIIIIllIlI = 0; lllllllllllllllllIIllIlIIIIllIlI < lllllllllllllllllIIllIlIIIIlIlll; ++lllllllllllllllllIIllIlIIIIllIlI) {
                if (lllllllllllllllllIIllIlIIIIlIllI[lllllllllllllllllIIllIlIIIIllIIl] != lllllllllllllllllIIllIlIIIIlIlII.charAt(lllllllllllllllllIIllIlIIIIllIlI)) {
                    lllllllllllllllllIIllIlIIIIlllII = false;
                    break;
                }
                if (++lllllllllllllllllIIllIlIIIIllIIl >= lllllllllllllllllIIllIlIIIIlIlll) {
                    lllllllllllllllllIIllIlIIIIllIIl -= lllllllllllllllllIIllIlIIIIlIlll;
                }
            }
            if (lllllllllllllllllIIllIlIIIIlllII) {
                return;
            }
            final char lllllllllllllllllIIllIlIIIIllIll = this.next();
            if (lllllllllllllllllIIllIlIIIIllIll == '\0') {
                return;
            }
            lllllllllllllllllIIllIlIIIIlIllI[lllllllllllllllllIIllIlIIIIllIII] = lllllllllllllllllIIllIlIIIIllIll;
            if (++lllllllllllllllllIIllIlIIIIllIII < lllllllllllllllllIIllIlIIIIlIlll) {
                continue;
            }
            lllllllllllllllllIIllIlIIIIllIII -= lllllllllllllllllIIllIlIIIIlIlll;
        }
    }
    
    public String nextCDATA() throws JSONException {
        final StringBuilder lllllllllllllllllIIllIlIIlIlllll = new StringBuilder();
        while (this.more()) {
            final char lllllllllllllllllIIllIlIIllIIIlI = this.next();
            lllllllllllllllllIIllIlIIlIlllll.append(lllllllllllllllllIIllIlIIllIIIlI);
            final int lllllllllllllllllIIllIlIIllIIIIl = lllllllllllllllllIIllIlIIlIlllll.length() - 3;
            if (lllllllllllllllllIIllIlIIllIIIIl >= 0 && lllllllllllllllllIIllIlIIlIlllll.charAt(lllllllllllllllllIIllIlIIllIIIIl) == ']' && lllllllllllllllllIIllIlIIlIlllll.charAt(lllllllllllllllllIIllIlIIllIIIIl + 1) == ']' && lllllllllllllllllIIllIlIIlIlllll.charAt(lllllllllllllllllIIllIlIIllIIIIl + 2) == '>') {
                lllllllllllllllllIIllIlIIlIlllll.setLength(lllllllllllllllllIIllIlIIllIIIIl);
                return String.valueOf(lllllllllllllllllIIllIlIIlIlllll);
            }
        }
        throw this.syntaxError("Unclosed CDATA");
    }
    
    public Object nextEntity(final char lllllllllllllllllIIllIlIIlIIllII) throws JSONException {
        final StringBuilder lllllllllllllllllIIllIlIIlIIlIll = new StringBuilder();
        char lllllllllllllllllIIllIlIIlIIlllI;
        while (true) {
            lllllllllllllllllIIllIlIIlIIlllI = this.next();
            if (!Character.isLetterOrDigit(lllllllllllllllllIIllIlIIlIIlllI) && lllllllllllllllllIIllIlIIlIIlllI != '#') {
                break;
            }
            lllllllllllllllllIIllIlIIlIIlIll.append(Character.toLowerCase(lllllllllllllllllIIllIlIIlIIlllI));
        }
        if (lllllllllllllllllIIllIlIIlIIlllI == ';') {
            final String lllllllllllllllllIIllIlIIlIIlIlI = String.valueOf(lllllllllllllllllIIllIlIIlIIlIll);
            return unescapeEntity(lllllllllllllllllIIllIlIIlIIlIlI);
        }
        throw this.syntaxError(String.valueOf(new StringBuilder().append("Missing ';' in XML entity: &").append((Object)lllllllllllllllllIIllIlIIlIIlIll)));
    }
}
