package ink.moku.util;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;
import java.text.DecimalFormat;

public class OS2String {
    public String getOS(){
        return System.getProperty("os.name")+","+System.getProperty("os.version")+","+System.getProperty("os.arch");
    }
    public String getRAM(){
        OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory
                .getOperatingSystemMXBean();
        DecimalFormat df   = new DecimalFormat("######0.00");
        double usedMemory = ((osmxb.getTotalPhysicalMemorySize() - osmxb.getFreePhysicalMemorySize())
                / Long.valueOf(osmxb.getTotalPhysicalMemorySize()).doubleValue() * 100
        );
        return df.format(usedMemory);
    }
}
