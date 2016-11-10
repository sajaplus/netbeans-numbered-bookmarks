/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.java.nb.lib.editor.bookmarks.spi;

import net.java.nb.lib.editor.bookmarks.api.BookmarkList;
import org.openide.util.Lookup;

/**
 *
 * @author Dell
 */
public class BookmarkListFactory {

    private BookmarkListFactory() {
    }
    private static BookmarkList bookmarkList;
    private static BookmarkManager mgr;

    public static BookmarkList getBookMarkListInstance() {

        if (bookmarkList == null) {
            mgr = getBookmarkManagerFactory().createBookmarkManager(null);
            bookmarkList = new BookmarkList(mgr);
        }
        return bookmarkList;
    }

    private static BookmarkManagerFactory getBookmarkManagerFactory() {
        BookmarkManagerFactory bookmarkManagerFactory = null;
        if (bookmarkManagerFactory == null) {
            bookmarkManagerFactory = Lookup.getDefault().lookup(BookmarkManagerFactory.class);
            assert (bookmarkManagerFactory != null) : "No BookmarkManagerFactory available"; // NOI18N
        }
        return bookmarkManagerFactory;
    }
}
