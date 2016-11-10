/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 1997-2007 Sun Microsystems, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Sun designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Sun in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * Contributor(s):
 *
 * The Original Software is NetBeans. The Initial Developer of the Original
 * Software is Sun Microsystems, Inc. Portions Copyright 1997-2006 Sun
 * Microsystems, Inc. All Rights Reserved.
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 */
package net.java.nb.lib.editor.bookmarks.api;

import java.util.HashMap;
import java.util.Map;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.JTextComponent;
import net.java.nb.lib.editor.bookmarks.spi.BookmarkImplementation;
import net.java.nb.lib.editor.bookmarks.spi.BookmarkManager;
//import net.java.nb.lib.editor.bookmarks.spi.ButtonManager;
import org.openide.cookies.EditorCookie;

/**
 * Services around document bookmarks.
 *
 * @author Miloslav Metelka
 * @version 1.00
 */
public final class BookmarkList {

    /**
     * Manager of the bookmarks.
     */
    private BookmarkManager manager;
//    private List bookmarks;
    private Map<String, Bookmark> bookmarks;
  
    public BookmarkList(BookmarkManager manager) {
//        this.bookmarks = new ArrayList();
        this.bookmarks = new HashMap<String, Bookmark>();
        this.manager = manager;
    }

    public Bookmark findBookmarkByTag(String tag) {
        return bookmarks.get(tag);
    }

    /**
     * Total count of bookmarks managed by this bookmark list.
     *
     * @return &gt;=0 total count of bookmarks.
     */
    public int getBookmarkCount() {
        return bookmarks.size();
    }

    /**
     * Create bookmark if it did not exist before at the line containing
     * the given offset.
     * <br>
     * Drop the existing bookmark if it was already present for the line
     * containing the given offset.
     *
     * @param offset offset on a line in the document for which the presence of bookmark
     *  should be checked. The bookmarks are checked in a line-wise way.
     * @return bookmark that was either created or removed by the operation.
     *  Calling {@link Bookmark#isValid()} determines whether the returned
     *  bookmark was added or removed by the operation.
     *  <br>
     *  <code>null</code> is returned if the offset is above the end of document.
     */
    public Bookmark toggleLineBookmark(int offset, String tag, String type, JTextComponent target, EditorCookie ec) {
        Document doc = target.getDocument();
        checkOffsetInDocument(offset, doc);
        Element lineRoot = doc.getDefaultRootElement();
        Bookmark bookmark = null;
        bookmark = findBookmarkByTag(tag);
        boolean b1 = (bookmark != null);
        boolean b2 = false;
        boolean b3 = false;
        if (b1) {
            b2 = (bookmark.getImplementation().getEditorCookie().equals(ec));
            b3 = bookmark.getCaret() == target.getCaretPosition();
        }
        if (b1 && b2 && b3) {
            removeBookmarkAtTag(tag);
        } else {
            BookmarkImplementation bi = manager.createBookmarkImplementation(offset, type, target, ec);
            bookmark = addBookmark(bi, tag, type);
            bookmark.setCaret(target.getCaretPosition());
        }
        return bookmark;
    }

    private Bookmark removeBookmarkAtTag(String tag) {
        Bookmark bookmark = findBookmarkByTag(tag);
        if (bookmark != null) {
            bookmarks.remove(tag);
            bookmark.release();
        }
        return bookmark;

    }

    private Bookmark addBookmark(BookmarkImplementation impl, String tag, String type) {
        impl.setTag(tag, type);
        Bookmark bookmark = new Bookmark(this, impl);
        Bookmark b = ifBookmarkExistRelease(bookmark);
        if (b != null) {
            bookmarks.remove(b);
        }
        bookmarks.put(tag, bookmark);
        return bookmark;
    }

    private Bookmark ifBookmarkExistRelease(Bookmark bookmark) {
        Bookmark b = findBookmarkByTag(bookmark.getImplementation().getTag());
        if (b != null) {
            b.release();
        }
        return b;
    }

    private void checkOffsetNonNegative(int offset) {
        if (offset < 0) {
            throw new IndexOutOfBoundsException("offset=" + offset + " < 0"); // NOI18N

        }
    }

    public void checkOffsetInDocument(int offset, Document doc) {
        checkOffsetNonNegative(offset);
        int docLen = doc.getLength();
        if (offset > docLen) {
            throw new IndexOutOfBoundsException("offset=" + offset // NOI18N
                    + " > doc.getLength()=" + docLen); // NOI18N

        }
    }

    public String toString() {
        return "Bookmarks: " + bookmarks; // NOI18N

    }
}

