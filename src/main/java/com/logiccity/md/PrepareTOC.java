package com.logiccity.md;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PrepareTOC {
	public static void main(String [] argv) throws IOException {
		FileWriter output = new FileWriter("tableOfContents.sh");
		output.write("#!/usr/bin/env bash\n\n");
		File root = new File(".");
		for (File file : PreprocessMD.findAllPremdFiles()) {
			String relPath = file.getName();
			while (!file.getParentFile().equals(root)) {
				file = file.getParentFile();
				relPath = file.getName() + "/" + relPath;
			}
			output.write("./doc/script/gh-md-toc " + relPath
					+ " &> " + relPath + ".toc\n");
		}
		output.close();
	}
}
