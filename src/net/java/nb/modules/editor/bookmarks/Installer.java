/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.java.nb.modules.editor.bookmarks;

import java.util.prefs.Preferences;
import org.openide.modules.ModuleInstall;
import org.openide.util.NbPreferences;
import net.java.nb.modules.editor.bookmarks.option.BookmarksPanel;
import net.java.nb.modules.editor.bookmarks.option.CustomFileSystem;
/**
 * Manages a module's lifecycle. Remember that an installer is optional and
 * often not needed at all.
 */
public class Installer extends ModuleInstall {


    @Override
    public void restored() {
        Preferences pref = NbPreferences.forModule(BookmarksPanel.class);
//        if(s.equalsIgnoreCase("default")){
//            CustomFileSystem.enableDefaultBookmarkOnly();
//        }else if(s.equalsIgnoreCase("numbered")){
            CustomFileSystem.enableDefaultBookmark();
            CustomFileSystem.enableNumberedBookmarkOnly();
//        }
    }

    /**
     * Called when all modules agreed with closing and the IDE will be closed.
     */
    public boolean closing() {
        // this used to be called from close(), but didn't save properly on JDK6,
        // no idea why, see #120880
        return super.closing();
    }

    /**
     * Called when module is uninstalled.
     */
    public void uninstalled() {
    }

}
