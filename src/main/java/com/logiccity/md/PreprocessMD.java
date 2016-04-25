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
		for (File file : findAllPremdFiles()) {
			String cnt = new String(Files.readAllBytes(file.toPath())), result = "";
			int pos;
			while ((pos = cnt.indexOf("<<include[")) != -1) {
				result += cnt.substring(0, pos);
				int ePos = cnt.indexOf("]>>", pos);
				String fn = cnt.substring(pos + 10, ePos);
				if (fn.equals("_TOC_")) {
					String tocCnt = new String(Files.readAllBytes(
						new File(file.getParent(), file.getName()+".toc").toPath()));
					pos = tocCnt.indexOf("Created by [gh-md-toc]");
					if (pos != -1) {
						tocCnt = tocCnt.substring(0, pos).trim();
					}
					result += tocCnt;
				} else {
					result += new String(Files.readAllBytes(
							new File(file.getParent(), fn).toPath()));
				}
				cnt = cnt.substring(ePos + 3);
			}
			result += cnt;
			Files.write(new File(file.getParent(), file.getName().replace(".pre.md", ".md")).toPath(), 
					result.getBytes());
		}
	}
	static List<File> findAllPremdFiles() {
		return findFilesDeep(new File("."), new FileFilter() {
			@Override
			public boolean accept(File file) {
				return file.isDirectory() || file.getName().toLowerCase().endsWith(".pre.md");
			}
		});
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
