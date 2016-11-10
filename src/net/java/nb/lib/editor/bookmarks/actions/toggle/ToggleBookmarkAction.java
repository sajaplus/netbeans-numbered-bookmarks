/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.java.nb.lib.editor.bookmarks.actions.toggle;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JEditorPane;
import javax.swing.text.Caret;
import javax.swing.text.JTextComponent;
import net.java.nb.lib.editor.bookmarks.api.BookmarkList;
import net.java.nb.lib.editor.bookmarks.spi.BookmarkListFactory;
import org.openide.cookies.EditorCookie;
import org.openide.util.ContextAwareAction;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;
import org.openide.util.Utilities;

/**
 *
 * @author Dell
 */
public abstract class ToggleBookmarkAction extends AbstractAction implements ContextAwareAction {

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
    protected final JTextComponent component;

    public ToggleBookmarkAction() {
        this(null, "");
    }

    public ToggleBookmarkAction(JTextComponent component, String action) {
        super(NbBundle.getMessage(ToggleBookmarkAction.class, action));
        putValue(SHORT_DESCRIPTION, getValue(NAME));
        putValue("noIconInMenu", Boolean.TRUE); // NOI18N

        this.component = component;
    }

    
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

    protected static void actionPerformed(JTextComponent target, String tag,String annotation) {
        if (target != null) {
            if (org.netbeans.editor.Utilities.getEditorUI(target).isGlyphGutterVisible()) {
                Caret caret = target.getCaret();
                BookmarkList bookmarkList = BookmarkListFactory.getBookMarkListInstance();
//                bookmarkList.toggleLineBookmark(caret.getDot());
                EditorCookie ec = Utilities.actionsGlobalContext().lookup(EditorCookie.class);
                bookmarkList.toggleLineBookmark(caret.getDot(), tag, annotation, target, ec);

            } else { // Glyph gutter not visible -> just beep

                target.getToolkit().beep();
            }
        }
    }

    public static final class ToggleBookmarkAction0 extends ToggleBookmarkAction {

        public ToggleBookmarkAction0() {
            this(null, TAG_NAME_0);
        }

        private ToggleBookmarkAction0(JTextComponent jtc, String action) {
            super(jtc, action);
        }

        public Action createContextAwareInstance(Lookup actionContext) {
            JTextComponent jtc = findComponent(actionContext);
            return new ToggleBookmarkAction0(jtc, TAG_NAME_0);
        }

        public void actionPerformed(ActionEvent arg0) {

            if (component != null) {
                // cloned action with context
                actionPerformed(component, TAG_NAME_0,"bookmark-0");
            } else {
                // global action, will have to find the current component
                JTextComponent jtc = findComponent(Utilities.actionsGlobalContext());
                if (jtc != null) {
                    actionPerformed(jtc, TAG_NAME_0,"bookmark-0");
                }
            }
        }
    }

    public static final class ToggleBookmarkAction1 extends ToggleBookmarkAction {

        public ToggleBookmarkAction1() {
            this(null, TAG_NAME_1);
        }

        private ToggleBookmarkAction1(JTextComponent jtc, String action) {
            super(jtc, action);
        }

        public Action createContextAwareInstance(Lookup actionContext) {
            JTextComponent jtc = findComponent(actionContext);
            return new ToggleBookmarkAction1(jtc, TAG_NAME_1);
        }

        public void actionPerformed(ActionEvent arg0) {

            if (component != null) {
                // cloned action with context
                actionPerformed(component, TAG_NAME_1,"bookmark-1");
            } else {
                // global action, will have to find the current component
                JTextComponent jtc = findComponent(Utilities.actionsGlobalContext());
                if (jtc != null) {
                    actionPerformed(jtc, TAG_NAME_1,"bookmark-1");
                }
            }
        }
    }

    public static final class ToggleBookmarkAction2 extends ToggleBookmarkAction {

        public ToggleBookmarkAction2() {
            this(null, TAG_NAME_2);
        }

        private ToggleBookmarkAction2(JTextComponent jtc, String action) {
            super(jtc, action);
        }

        public Action createContextAwareInstance(Lookup actionContext) {
            JTextComponent jtc = findComponent(actionContext);
            return new ToggleBookmarkAction2(jtc, TAG_NAME_2);
        }


        public void actionPerformed(ActionEvent arg0) {

            if (component != null) {
                // cloned action with context
                actionPerformed(component, TAG_NAME_2,"bookmark-2");
            } else {
                // global action, will have to find the current component
                JTextComponent jtc = findComponent(Utilities.actionsGlobalContext());
                if (jtc != null) {
                    actionPerformed(jtc, TAG_NAME_2,"bookmark-2");
                }
            }
        }
    }

    public static final class ToggleBookmarkAction3 extends ToggleBookmarkAction {

        public ToggleBookmarkAction3() {
            this(null, TAG_NAME_3);
        }

        private ToggleBookmarkAction3(JTextComponent jtc, String action) {
            super(jtc, action);
        }

        public Action createContextAwareInstance(Lookup actionContext) {
            JTextComponent jtc = findComponent(actionContext);
            return new ToggleBookmarkAction3(jtc, TAG_NAME_3);
        }


        public void actionPerformed(ActionEvent arg0) {

            if (component != null) {
                // cloned action with context
                actionPerformed(component, TAG_NAME_3,"bookmark-3");
            } else {
                // global action, will have to find the current component
                JTextComponent jtc = findComponent(Utilities.actionsGlobalContext());
                if (jtc != null) {
                    actionPerformed(jtc, TAG_NAME_3,"bookmark-3");
                }
            }
        }
    }

    public static final class ToggleBookmarkAction4 extends ToggleBookmarkAction {

        public ToggleBookmarkAction4() {
            this(null, TAG_NAME_4);
        }

        private ToggleBookmarkAction4(JTextComponent jtc, String action) {
            super(jtc, action);
        }

        public Action createContextAwareInstance(Lookup actionContext) {
            JTextComponent jtc = findComponent(actionContext);
            return new ToggleBookmarkAction4(jtc, TAG_NAME_4);
        }


        public void actionPerformed(ActionEvent arg0) {

            if (component != null) {
                // cloned action with context
                actionPerformed(component, TAG_NAME_4,"bookmark-4");
            } else {
                // global action, will have to find the current component
                JTextComponent jtc = findComponent(Utilities.actionsGlobalContext());
                if (jtc != null) {
                    actionPerformed(jtc, TAG_NAME_4,"bookmark-4");
                }
            }
        }
    }

    public static final class ToggleBookmarkAction5 extends ToggleBookmarkAction {

        public ToggleBookmarkAction5() {
            this(null, TAG_NAME_5);
        }

        private ToggleBookmarkAction5(JTextComponent jtc, String action) {
            super(jtc, action);
        }

        public Action createContextAwareInstance(Lookup actionContext) {
            JTextComponent jtc = findComponent(actionContext);
            return new ToggleBookmarkAction5(jtc, TAG_NAME_5);
        }

        public void actionPerformed(ActionEvent arg0) {

            if (component != null) {
                // cloned action with context
                actionPerformed(component, TAG_NAME_5,"bookmark-5");
            } else {
                // global action, will have to find the current component
                JTextComponent jtc = findComponent(Utilities.actionsGlobalContext());
                if (jtc != null) {
                    actionPerformed(jtc, TAG_NAME_5,"bookmark-5");
                }
            }
        }
    }

    public static final class ToggleBookmarkAction6 extends ToggleBookmarkAction {

        public ToggleBookmarkAction6() {
            this(null, TAG_NAME_6);
        }

        private ToggleBookmarkAction6(JTextComponent jtc, String action) {
            super(jtc, action);
        }

        public Action createContextAwareInstance(Lookup actionContext) {
            JTextComponent jtc = findComponent(actionContext);
            return new ToggleBookmarkAction6(jtc, TAG_NAME_6);
        }

        public void actionPerformed(ActionEvent arg0) {

            if (component != null) {
                // cloned action with context
                actionPerformed(component, TAG_NAME_6,"bookmark-6");
            } else {
                // global action, will have to find the current component
                JTextComponent jtc = findComponent(Utilities.actionsGlobalContext());
                if (jtc != null) {
                    actionPerformed(jtc, TAG_NAME_6,"bookmark-6");
                }
            }
        }
    }

    public static final class ToggleBookmarkAction7 extends ToggleBookmarkAction {

        public ToggleBookmarkAction7() {
            this(null, TAG_NAME_7);
        }

        private ToggleBookmarkAction7(JTextComponent jtc, String action) {
            super(jtc, action);
        }

        public Action createContextAwareInstance(Lookup actionContext) {
            JTextComponent jtc = findComponent(actionContext);
            return new ToggleBookmarkAction7(jtc, TAG_NAME_7);
        }

        public void actionPerformed(ActionEvent arg0) {

            if (component != null) {
                // cloned action with context
                actionPerformed(component, TAG_NAME_7,"bookmark-7");
            } else {
                // global action, will have to find the current component
                JTextComponent jtc = findComponent(Utilities.actionsGlobalContext());
                if (jtc != null) {
                    actionPerformed(jtc, TAG_NAME_7,"bookmark-7");
                }
            }
        }
    }

    public static final class ToggleBookmarkAction8 extends ToggleBookmarkAction {

        public ToggleBookmarkAction8() {
            this(null, TAG_NAME_8);
        }

        private ToggleBookmarkAction8(JTextComponent jtc, String action) {
            super(jtc, action);
        }

        public Action createContextAwareInstance(Lookup actionContext) {
            JTextComponent jtc = findComponent(actionContext);
            return new ToggleBookmarkAction8(jtc, TAG_NAME_8);
        }

        public void actionPerformed(ActionEvent arg0) {

            if (component != null) {
                // cloned action with context
                actionPerformed(component, TAG_NAME_8,"bookmark-8");
            } else {
                // global action, will have to find the current component
                JTextComponent jtc = findComponent(Utilities.actionsGlobalContext());
                if (jtc != null) {
                    actionPerformed(jtc, TAG_NAME_8,"bookmark-8");
                }
            }
        }
    }

    public static final class ToggleBookmarkAction9 extends ToggleBookmarkAction {

        public ToggleBookmarkAction9() {
            this(null, TAG_NAME_9);
        }

        private ToggleBookmarkAction9(JTextComponent jtc, String action) {
            super(jtc, action);
        }

        public Action createContextAwareInstance(Lookup actionContext) {
            JTextComponent jtc = findComponent(actionContext);
            return new ToggleBookmarkAction9(jtc, TAG_NAME_9);
        }

        public void actionPerformed(ActionEvent arg0) {

            if (component != null) {
                // cloned action with context
                actionPerformed(component, TAG_NAME_9,"bookmark-9");
            } else {
                // global action, will have to find the current component
                JTextComponent jtc = findComponent(Utilities.actionsGlobalContext());
                if (jtc != null) {
                    actionPerformed(jtc, TAG_NAME_9,"bookmark-9");
                }
            }
        }
    }
}
