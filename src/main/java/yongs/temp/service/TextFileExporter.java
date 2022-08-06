package yongs.temp.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import yongs.temp.inf.FileExporter;

@Slf4j
@Service
public class TextFileExporter implements FileExporter {
	private static final String EXPORT_DIR = "C:\\Temp";

	@Override
	public Path export(String fileName, String fileContent) {
		Path filePath = Paths.get(EXPORT_DIR, fileName);
		try {
			Path exportedFilePath = Files.write(filePath, fileContent.getBytes(), StandardOpenOption.CREATE);
			return exportedFilePath;
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return null;
	}

}
