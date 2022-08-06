package yongs.temp.inf;

import java.nio.file.Path;

public interface FileExporter {
	public Path export(String fileName, String fileContent);
}
