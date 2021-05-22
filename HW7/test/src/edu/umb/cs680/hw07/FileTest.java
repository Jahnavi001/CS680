package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class FileTest {
	LocalDateTime localTime = LocalDateTime.now();
    Directory root = new Directory(null, "root", 0, localTime);
    Directory applications = new Directory(root, "applications", 0, localTime);
    Directory home = new Directory(root, "home", 0, localTime);
    Directory code = new Directory(home, "code", 0, localTime);
    File a = new File(applications, "a", 5, localTime);
    File b = new File(applications, "b", 20, localTime);
    File c = new File(home, "c", 30, localTime);
    File d = new File(home, "d", 40, localTime);
    File e = new File(code, "e", 15, localTime);
    File f = new File(code, "f", 15, localTime);

	private String[] fileToStringArray(File f) {
		String[] fileInfo = { Boolean.toString(f.isDirectory()), f.getName(),f.getParent().getName(), Integer.toString(f.getSize()),
				f.getCreationTime().toString(), };
		return fileInfo;
	}

	@Test
	public void verifyFile() {
		assertTrue(a.isFile());
		assertTrue(b.isFile());
		assertTrue(c.isFile());
		assertTrue(d.isFile());
		assertTrue(e.isFile());
		assertTrue(f.isFile());
	}

	@Test
    public void verifyFileA() {
		String[] expected = { "false", "a", "applications","5", localTime.toString(),  };
		File actual = a;
		assertArrayEquals(expected, fileToStringArray(actual));
	}
	
	@Test
    public void verifyFileB() {
		String[] expected = { "false", "b","applications", "20", localTime.toString() };
		File actual = b;
		assertArrayEquals(expected, fileToStringArray(actual));
	}

	@Test
	public void verifyFileC() {
		String[] expected = { "false", "c","home", "30", localTime.toString()};
		File actual = c;
		assertArrayEquals(expected, fileToStringArray(actual));
	}
	
	@Test
	public void verifyFileD() {
		
		String[] expected = { "false", "d","home", "40", localTime.toString() };
		File actual = d;
		assertArrayEquals(expected, fileToStringArray(actual));
	}
	
	
	@Test
    public void verifyFileE() {
	
		String[] expected = { "false", "e","code", "15", localTime.toString() };
		File actual = e;
		assertArrayEquals(expected, fileToStringArray(actual));
	}
	
	@Test
	public void verifyFileF() {
		String[] expected = { "false", "f","code","15", localTime.toString()};
		File actual = f;
		assertArrayEquals(expected, fileToStringArray(actual));
	}
}