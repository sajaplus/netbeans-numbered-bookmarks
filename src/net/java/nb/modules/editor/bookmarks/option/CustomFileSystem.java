/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.java.nb.modules.editor.bookmarks.option;

import java.net.MalformedURLException;
import java.net.URL;
import org.openide.filesystems.MultiFileSystem;
import org.openide.filesystems.XMLFileSystem;
import org.openide.util.Exceptions;
import org.xml.sax.SAXException;

/**
 *
 * @author Dell
 */
public class CustomFileSystem extends MultiFileSystem {

    private static CustomFileSystem INSTANCE;

    public CustomFileSystem() {
        INSTANCE = this;
    }

    private static void assignFileSystem(String url) {
        try {
            INSTANCE.setDelegates(new XMLFileSystem(new URL(url)));
        } catch (MalformedURLException ex) {
            Exceptions.printStackTrace(ex);
        } catch (SAXException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
    public static void enableDefaultBookmark(){
        assignFileSystem("nbresloc:/org/netbeans/modules/editor/bookmarks/resources/layer.xml");
    }
    public static void enableDefaultBookmarkOnly(){
        assignFileSystem("nbresloc:/net/java/nb/modules/editor/bookmarks/option/DefaultOnly.xml");
    }
    public static void enableNumberedBookmarkOnly(){
        assignFileSystem("nbresloc:/net/java/nb/modules/editor/bookmarks/option/NumberedOnly.xml");
    }
    public static void enableBoth(){
        assignFileSystem("nbresloc:/net/java/nb/modules/editor/bookmarks/option/Both.xml");
    }
}
