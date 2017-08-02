package pl.jakubchmura.snmp.mib.commenter;

import com.intellij.lang.Commenter;
import org.jetbrains.annotations.Nullable;

public class SmiCommenter implements Commenter {

    private static final String COMMENT = "--";

    @Nullable
    @Override
    public String getLineCommentPrefix() {
        return COMMENT;
    }

    @Nullable
    @Override
    public String getBlockCommentPrefix() {
        return null;
    }

    @Nullable
    @Override
    public String getBlockCommentSuffix() {
        return null;
    }

    @Nullable
    @Override
    public String getCommentedBlockCommentPrefix() {
        return null;
    }

    @Nullable
    @Override
    public String getCommentedBlockCommentSuffix() {
        return null;
    }
}
