/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.java.nb.lib.editor.bookmarks.actions.go;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JEditorPane;
import javax.swing.text.JTextComponent;
import net.java.nb.lib.editor.bookmarks.api.Bookmark;
import net.java.nb.lib.editor.bookmarks.api.BookmarkList;
import net.java.nb.lib.editor.bookmarks.spi.BookmarkListFactory;
import org.openide.cookies.EditorCookie;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;
import org.openide.util.Utilities;

/**
 *
 * @author Dell
 */
public abstract class GoToBookmarkAction extends AbstractAction {

    private static final String ACTION_NAME_0 = "goto-bookmark-0";
    private static final String ACTION_NAME_1 = "goto-bookmark-1";
    private static final String ACTION_NAME_2 = "goto-bookmark-2";
    private static final String ACTION_NAME_3 = "goto-bookmark-3";
    private static final String ACTION_NAME_4 = "goto-bookmark-4";
    private static final String ACTION_NAME_5 = "goto-bookmark-5";
    private static final String ACTION_NAME_6 = "goto-bookmark-6";
    private static final String ACTION_NAME_7 = "goto-bookmark-7";
    private static final String ACTION_NAME_8 = "goto-bookmark-8";
    private static final String ACTION_NAME_9 = "goto-bookmark-9";

    private static final String TAG_NAME_0 = "bookmark-toggle-0";
    private static final String TAG_NAME_1 = "bookmark-toggle-1";
    private static final String TAG_NAME_2 = "bookmark-toggle-2";
    private static final String TAG_NAME_3 = "bookmark-toggle-3";
    private static final String TAG_NAME_4 = "bookmark-toggle-4";
    private static final String TAG_NAME_5 = "bookmark-toggle-5";
    private static final String TAG_NAME_6 = "bookmark-toggle-6";
    private static final String TAG_NAME_7 = "bookmark-toggle-7";
    private static final String TAG_NAME_8 = "bookmark-toggle-8";
    private static final String TAG_NAME_9 = "bookmark-toggle-9";
    
    private final JTextComponent component;

    public GoToBookmarkAction() {
        this(null,"");
    }

    public GoToBookmarkAction(JTextComponent component,String actionName) {
        super(NbBundle.getMessage(GoToBookmarkAction.class, actionName));
        putValue(SHORT_DESCRIPTION, getValue(NAME));
        putValue("noIconInMenu", Boolean.TRUE); // NOI18N

        this.component = component;
    }

//    public void actionPerformed(ActionEvent arg0) {
//    }
    @Override
    public boolean isEnabled() {
        if (component != null) {
            return true;
        } else {
            JTextComponent jtc = findComponent(Utilities.actionsGlobalContext());
            return jtc != null;
        }
    }

    private static JTextComponent findComponent(Lookup lookup) {
        EditorCookie ec = lookup.lookup(EditorCookie.class);
        if (ec != null) {
            JEditorPane panes[] = ec.getOpenedPanes();
            if (panes != null && panes.length > 0) {
                return panes[0];
            }
        }
        return null;
    }

    private static void goToBookmark(String tag) {
        BookmarkList bl = BookmarkListFactory.getBookMarkListInstance();
        Bookmark b = bl.findBookmarkByTag(tag);
        try{
        if (b != null) {
            int offset = b.getCaret();            
            BookmarkListFactory.getBookMarkListInstance().checkOffsetInDocument(
                    offset, b.getImplementation().getTarget().getDocument());
            b.getImplementation().getEditorCookie().open();
            b.getImplementation().getTarget().getCaret().setDot(b.getCaret());
        }
        }catch(java.lang.IndexOutOfBoundsException e){}
    }

    public static final class GoToBookmarkAction0 extends GoToBookmarkAction {

        public GoToBookmarkAction0() {
            super(null, ACTION_NAME_0);
        }

        public void actionPerformed(ActionEvent e) {
            goToBookmark(TAG_NAME_0);
        }
    }
    public static final class GoToBookmarkAction1 extends GoToBookmarkAction {

        public GoToBookmarkAction1() {
            super(null, ACTION_NAME_1);
        }

        public void actionPerformed(ActionEvent e) {
            goToBookmark(TAG_NAME_1);
        }
    }
    public static final class GoToBookmarkAction2 extends GoToBookmarkAction {

        public GoToBookmarkAction2() {
            super(null, ACTION_NAME_2);
        }

        public void actionPerformed(ActionEvent e) {
            goToBookmark(TAG_NAME_2);
        }
    }
    public static final class GoToBookmarkAction3 extends GoToBookmarkAction {

        public GoToBookmarkAction3() {
            super(null, ACTION_NAME_3);
        }

        public void actionPerformed(ActionEvent e) {
            goToBookmark(TAG_NAME_3);
        }
    }
    public static final class GoToBookmarkAction4 extends GoToBookmarkAction {

        public GoToBookmarkAction4() {
            super(null, ACTION_NAME_4);
        }

        public void actionPerformed(ActionEvent e) {
            goToBookmark(TAG_NAME_4);
        }
    }
    public static final class GoToBookmarkAction5 extends GoToBookmarkAction {

        public GoToBookmarkAction5() {
            super(null, ACTION_NAME_5);
        }

        public void actionPerformed(ActionEvent e) {
            goToBookmark(TAG_NAME_5);
        }
    }
    public static final class GoToBookmarkAction6 extends GoToBookmarkAction {

        public GoToBookmarkAction6() {
            super(null, ACTION_NAME_6);
        }

        public void actionPerformed(ActionEvent e) {
            goToBookmark(TAG_NAME_6);
        }
    }
    public static final class GoToBookmarkAction7 extends GoToBookmarkAction {

        public GoToBookmarkAction7() {
            super(null, ACTION_NAME_7);
        }

        public void actionPerformed(ActionEvent e) {
            goToBookmark(TAG_NAME_7);
        }
    }
    public static final class GoToBookmarkAction8 extends GoToBookmarkAction {

        public GoToBookmarkAction8() {
            super(null, ACTION_NAME_8);
        }

        public void actionPerformed(ActionEvent e) {
            goToBookmark(TAG_NAME_8);
        }
    }
    public static final class GoToBookmarkAction9 extends GoToBookmarkAction {

        public GoToBookmarkAction9() {
            super(null, ACTION_NAME_9);
        }

       public void actionPerformed(ActionEvent e) {
            goToBookmark(TAG_NAME_9);
        }
    }
}
