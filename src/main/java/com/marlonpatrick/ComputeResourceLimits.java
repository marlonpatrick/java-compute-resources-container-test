package com.marlonpatrick;

import java.lang.management.ManagementFactory;
import java.math.BigDecimal;
import java.math.RoundingMode;

import com.sun.management.OperatingSystemMXBean;

@SuppressWarnings("restriction")
public class ComputeResourceLimits {

	public static void main(String[] args) {
				
		StringBuilder result = new StringBuilder();

        OperatingSystemMXBean operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

		Runtime runtime = Runtime.getRuntime();
		
		result.append("Runtime.getRuntime().availableProcessors(): ");
		result.append(runtime.availableProcessors());

		result.append("\n\nOperatingSystemMXBean.getAvailableProcessors(): ");
		result.append(operatingSystemMXBean.getAvailableProcessors());

		result.append("\n\nOperatingSystemMXBean.getTotalPhysicalMemorySize(): ");
		result.append(formatByteToKilo(operatingSystemMXBean.getTotalPhysicalMemorySize()));
		result.append(" | ");
		result.append(formatByteToMega(operatingSystemMXBean.getTotalPhysicalMemorySize()));
		result.append(" | ");
		result.append(formatByteToGiga(operatingSystemMXBean.getTotalPhysicalMemorySize()));

		result.append("\n\nOperatingSystemMXBean.getFreePhysicalMemorySize(): ");
		result.append(formatByteToKilo(operatingSystemMXBean.getFreePhysicalMemorySize()));
		result.append(" | ");
		result.append(formatByteToMega(operatingSystemMXBean.getFreePhysicalMemorySize()));
		result.append(" | ");
		result.append(formatByteToGiga(operatingSystemMXBean.getFreePhysicalMemorySize()));
        
		result.append("\n\nRuntime.getRuntime().maxMemory() (-Xmx): ");
		result.append(formatByteToKilo(runtime.maxMemory()));
		result.append(" | ");
		result.append(formatByteToMega(runtime.maxMemory()));
		result.append(" | ");
		result.append(formatByteToGiga(runtime.maxMemory()));

		result.append("\n\nRuntime.getRuntime().totalMemory() (allocated memory): ");
		result.append(formatByteToKilo(runtime.totalMemory()));
		result.append(" | ");
		result.append(formatByteToMega(runtime.totalMemory()));
		result.append(" | ");
		result.append(formatByteToGiga(runtime.totalMemory()));

		result.append("\n\nOperatingSystemMXBean.getCommittedVirtualMemorySize(): ");
		result.append(formatByteToKilo(operatingSystemMXBean.getCommittedVirtualMemorySize()));
		result.append(" | ");
		result.append(formatByteToMega(operatingSystemMXBean.getCommittedVirtualMemorySize()));
		result.append(" | ");
		result.append(formatByteToGiga(operatingSystemMXBean.getCommittedVirtualMemorySize()));

		result.append("\n\nRuntime.getRuntime().freeMemory() (allocated free memory): ");
		result.append(formatByteToKilo(runtime.freeMemory()));
		result.append(" | ");
		result.append(formatByteToMega(runtime.freeMemory()));
		result.append(" | ");
		result.append(formatByteToGiga(runtime.freeMemory()));

		result.append("\n\ntotalMemory() - freeMemory() (used memory): ");
		result.append(formatByteToKilo(runtime.totalMemory() - runtime.freeMemory()));
		result.append(" | ");
		result.append(formatByteToMega(runtime.totalMemory() - runtime.freeMemory()));
		result.append(" | ");
		result.append(formatByteToGiga(runtime.totalMemory() - runtime.freeMemory()));

		result.append("\n\nOperatingSystemMXBean.getTotalSwapSpaceSize(): ");
		result.append(formatByteToKilo(operatingSystemMXBean.getTotalSwapSpaceSize()));
		result.append(" | ");
		result.append(formatByteToMega(operatingSystemMXBean.getTotalSwapSpaceSize()));
		result.append(" | ");
		result.append(formatByteToGiga(operatingSystemMXBean.getTotalSwapSpaceSize()));
		
		result.append("\n\nOperatingSystemMXBean.getFreeSwapSpaceSize(): ");
		result.append(formatByteToKilo(operatingSystemMXBean.getFreeSwapSpaceSize()));
		result.append(" | ");
		result.append(formatByteToMega(operatingSystemMXBean.getFreeSwapSpaceSize()));
		result.append(" | ");
		result.append(formatByteToGiga(operatingSystemMXBean.getFreeSwapSpaceSize()));

		System.out.println(result);
	}
		
	private static String formatByteToKilo(Long bytes) {
		return BigDecimal.valueOf(bytes / 1024.0).setScale(2, RoundingMode.HALF_DOWN) + " KB";
	}

	private static String formatByteToMega(Long bytes) {
		return BigDecimal.valueOf(bytes / 1024.0 / 1024.0).setScale(2, RoundingMode.HALF_DOWN) + " MB";
	}

	private static String formatByteToGiga(Long bytes) {
		return BigDecimal.valueOf(bytes / 1024.0 / 1024.0 / 1024.0).setScale(2, RoundingMode.HALF_DOWN) + " GB";
	}
}
