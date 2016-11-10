/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.java.nb.modules.editor.bookmarks.option;

import org.netbeans.spi.options.AdvancedOption;
import org.netbeans.spi.options.OptionsPanelController;
import org.openide.util.NbBundle;

public final class BookmarksAdvancedOption extends AdvancedOption {

    public String getDisplayName() {
        return NbBundle.getMessage(BookmarksAdvancedOption.class, "AdvancedOption_DisplayName_Bookmarks");
    }

    public String getTooltip() {
        return NbBundle.getMessage(BookmarksAdvancedOption.class, "AdvancedOption_Tooltip_Bookmarks");
    }

    public OptionsPanelController create() {
        return new BookmarksOptionsPanelController();
    }
}
