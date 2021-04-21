package cc.momas.badworddiff;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class FileUtil {

	// 输出到文件
	public String writeToFile(String destFileName, String sql) throws IOException {
		final Path file = new File(destFileName).toPath();
		// 如果不存在则创建
		if (Files.notExists(file)) {
			Files.createDirectories(file.getParent());
			Files.createFile(file);
		}
		// 写入文件
		Files.write(file, sql.getBytes(StandardCharsets.UTF_8));
		return file.toAbsolutePath().toString();
	}

	public Set<Key> readExcel(InputStream oldFileInputStream) throws IOException {
		Workbook workbook = WorkbookFactory.create(oldFileInputStream);
		Sheet sheet = workbook.getSheetAt(0);
		Set<Key> set = new HashSet<>(6000);
		for (int i = 3; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j <= row.getLastCellNum(); j = j + 2) {
				Cell cell = row.getCell(j);
				if (cell != null && cell.getStringCellValue() != null && !cell.getStringCellValue().trim().equals("")) {
					Key key = new Key();
					key.setCreated(new Date());
					key.setType(j / 6);
					key.setWord(cell.getStringCellValue());
					key.setWordType(j % 6);
					set.add(key);
				}
			}
		}
		return set;
	}
}
