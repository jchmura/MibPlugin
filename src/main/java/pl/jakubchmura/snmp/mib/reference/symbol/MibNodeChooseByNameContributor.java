package pl.jakubchmura.snmp.mib.reference.symbol;

import org.jetbrains.annotations.Nullable;
import pl.jakubchmura.snmp.mib.MibFile;
import pl.jakubchmura.snmp.mib.psi.impl.OidSmiMibNodeMixin;
import pl.jakubchmura.snmp.mib.psi.impl.SmiMibNodeMixin;

import java.util.List;
import java.util.stream.Collectors;

public class MibNodeChooseByNameContributor extends AbstractChooseByNameContributor<SmiMibNodeMixin> {

    public MibNodeChooseByNameContributor(@Nullable MibFile mibFile) {
        super(mibFile);
    }

    @Override
    protected List<SmiMibNodeMixin> getDeclaredElementsFromFile(MibFile mibFile, boolean includeNumericalOids) {
        List<SmiMibNodeMixin> mibNodes = mibFile.getMibNodes();
        if (includeNumericalOids) {
            mibNodes.addAll(mibNodes.stream().map(OidSmiMibNodeMixin::new).collect(Collectors.toList()));
        }
        return mibNodes;
    }
}
