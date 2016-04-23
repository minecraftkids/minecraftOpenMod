package com.logiccity.md;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class PreprocessMD {
	public static void main(String [] argv) throws IOException {
		File root = new File(".");
		for (File file : findFilesDeep(root, new FileFilter() {
			@Override
			public boolean accept(File file) {
				return file.isDirectory() || file.getName().toLowerCase().endsWith(".premd");
			}
		})) {
			String cnt = new String(Files.readAllBytes(file.toPath())), result = "";
			int pos;
			while ((pos = cnt.indexOf("#include<<")) != -1) {
				result += cnt.substring(0, pos);
				int ePos = cnt.indexOf(">>", pos);
				result += new String(Files.readAllBytes(
						new File(file.getParent(), cnt.substring(pos + 10, ePos)).toPath()));
				cnt = cnt.substring(ePos + 2);
			}
			result += cnt;
			Files.write(new File(file.getParent(), file.getName().replace(".premd", ".md")).toPath(), 
					result.getBytes());
		}
	}
	
	private static List<File> findFilesDeep(File root, FileFilter ff) {
		List<File> listF = new ArrayList<File>();
		for (File file : root.listFiles(ff)) {
			if (file.isDirectory()) {
				listF.addAll(findFilesDeep(file, ff));
			} else {
				listF.add(file);
			}
		}
		return listF;
	}
}
