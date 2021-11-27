import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory
                .getOperatingSystemMXBean();
//        long usedMemory = ((osmxb.getTotalPhysicalMemorySize() - osmxb.getFreePhysicalMemorySize()));
//        long bb = osmxb.getTotalPhysicalMemorySize();
        DecimalFormat df   = new DecimalFormat("######0.00");
        double usedMemory = ((osmxb.getTotalPhysicalMemorySize() - osmxb.getFreePhysicalMemorySize())
                / Long.valueOf(osmxb.getTotalPhysicalMemorySize()).doubleValue() * 100
        );

        System.out.println(df.format(usedMemory));

    }
}
