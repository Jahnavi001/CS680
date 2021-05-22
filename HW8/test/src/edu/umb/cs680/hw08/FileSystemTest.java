package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;



import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class FileSystemTest {
    LocalDateTime localTime = LocalDateTime.now();
	Directory root = new Directory(null, "root", 0, localTime);
	
	private String[] dirtoStringArray(Directory d) {
		String[] dirInfo = { null, d.getName(), Integer.toString(d.getSize()), d.getCreationTime().toString() };
		return dirInfo;
	}
	
	@Test
	void verifySameFile() {
		FileSystem fileOne = FileSystem.getFileSystem();
		FileSystem fileTwo = FileSystem.getFileSystem();
		assertSame(fileOne, fileTwo);
	}

	@Test
	void verifyDirectory() {
		String[] expected = { null, "root", "0", localTime.toString() };
		Directory actual = root;
		assertArrayEquals(expected, dirtoStringArray(actual));
	}

}
