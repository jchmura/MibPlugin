package pl.jakubchmura.snmp.mib.util.oid;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SnmpOid implements Comparable<SnmpOid> {

    private static final Pattern PATTERN = Pattern.compile("\\.?(\\d+)");

    @NotNull
    private final long[] oid;

    public SnmpOid(@NotNull long[] oid) {
        this.oid = oid;
    }

    @Nullable
    public static SnmpOid parse(@NotNull String text) {
        Matcher matcher = PATTERN.matcher(text);
        List<Long> oids = new LinkedList<>();
        while (matcher.find()) {
            String group = matcher.group(1);
            oids.add(Long.parseLong(group));
        }
        if (!oids.isEmpty()) {
            return new SnmpOid(oids.stream().mapToLong(i -> i).toArray());
        }
        return null;
    }

    @Nullable
    public SnmpOid getParent() {
        if (oid.length == 1) {
            return null;
        }
        return new SnmpOid(Arrays.copyOf(oid, oid.length - 1));
    }

    private SnmpOid createChild(long index) {
        int newLength = oid.length + 1;
        long[] child = Arrays.copyOf(oid, newLength);
        child[newLength - 1] = index;
        return new SnmpOid(child);
    }

    public SnmpOid createChild(long... indices) {
        SnmpOid child = this;
        for (long index : indices) {
            child = child.createChild(index);
        }
        return child;
    }

    public int getDepth() {
        return oid.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SnmpOid snmpOid = (SnmpOid) o;

        return Arrays.equals(oid, snmpOid.oid);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(oid);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(oid.length * 2);
        for (long anOid : oid) {
            builder.append(".").append(anOid);
        }
        return builder.toString();
    }

    @Override
    public int compareTo(@NotNull SnmpOid o) {
        int length = Math.min(oid.length, o.oid.length);
        for (int i = 0; i < length; i++) {
            long o1 = oid[i];
            long o2 = o.oid[i];
            if (o1 != o2) {
                return (int) (o1 - o2);
            }
        }
        return oid.length - o.oid.length;
    }
}
