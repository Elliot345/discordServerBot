import com.sun.management.OperatingSystemMXBean;

import java.io.File;
import java.lang.management.ManagementFactory;

import javax.swing.filechooser.*;

public class systemResources {
    OperatingSystemMXBean osBean;
    File root;

    public systemResources() {
        osBean = ManagementFactory.getPlatformMXBean(
                OperatingSystemMXBean.class
        );

        root = FileSystemView.getFileSystemView().getRoots()[0];
    }

    // system resource info
    public double getCpuUsage() {
        return osBean.getCpuLoad() * 100;
    }

    public double getPhysicalMemoryUsed() {
        return convertBytesToGigabytes(osBean.getTotalPhysicalMemorySize() - osBean.getFreePhysicalMemorySize());
    }
    public double getPhysicalMemory() {
        return convertBytesToGigabytes(osBean.getTotalMemorySize());
    }

    public double getDiskSize() {
        return convertBytesToGigabytes(root.getTotalSpace());
    }
    public double getDiskUsed() {
        return getDiskSize() - convertBytesToGigabytes(root.getFreeSpace());
    }

    // system resources
    public double convertBytesToGigabytes(long bytes) {
        return bytes / (1024 * 1024 * 1024);
    }
}
