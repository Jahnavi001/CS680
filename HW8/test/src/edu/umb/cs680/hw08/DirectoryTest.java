package edu.umb.cs680.hw08;

/*import static org.junit.Assert.assertEquals;*/
/*
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;*/

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class DirectoryTest {
	
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
    Link x = new Link(home, "x", 0, localTime, applications);
	Link y = new Link(code, "y", 0, localTime, b);


	private String[] dirToStringArray(Directory d) {
		String parentName = null;
		Directory parent = d.getParent();
		if (parent != null) {
			parentName = parent.getName();
		}
		String[] dirInfo = { Boolean.toString(d.isDirectory()), d.getName(), Integer.toString(d.getSize()),
				d.getCreationTime().toString(),parentName,
				Integer.toString(d.getTotalSize()), Integer.toString(d.countChildren()) };
		return dirInfo;
	}
	
	@Test
	void verifyDirectory() {
		assertTrue(root.isDirectory());
		assertTrue(home.isDirectory());
		assertTrue(applications.isDirectory());
		assertTrue(code.isDirectory());
		assertFalse(a.isDirectory());
		assertFalse(b.isDirectory());
		assertFalse(c.isDirectory());
		assertFalse(d.isDirectory());
		assertFalse(e.isDirectory());
		assertFalse(f.isDirectory());	
	}

	
	@Test
	void verifyFiles() {
		assertTrue(a.isFile());
		assertTrue(c.isFile());
		assertTrue(b.isFile());
		assertTrue(d.isFile());
		assertTrue(e.isFile());
		assertTrue(f.isFile());
	}
	
	@Test
	void verifyFilesByDirectory() {
		assertSame("a", applications.getFiles().get(0).getName());
		assertSame("b", applications.getFiles().get(1).getName());
		assertSame("c", home.getFiles().get(0).getName());
		assertSame("d", home.getFiles().get(1).getName());
		assertSame("e", code.getFiles().get(0).getName());
		assertSame("f", code.getFiles().get(1).getName());
	}
	

	@Test
	void verifyCount() {
		assertEquals(2, root.countChildren());
		assertEquals(2, applications.countChildren());
		assertEquals(4, home.countChildren());
		assertEquals(3, code.countChildren());
	}
	
	
	@Test
	void verifySize() {
		assertEquals(125, root.getTotalSize());
		assertEquals(100, home.getTotalSize());
		assertEquals(25, applications.getTotalSize());
		assertEquals(30, code.getTotalSize());
	}
	
	@Test
	public void verifyGetChildren() {
		assertEquals(applications, root.getChildren().get(0));
		assertEquals(home, root.getChildren().get(1));
		assertEquals(code,home.getChildren().get(0));
	}

	@Test
	void verifySubDirectories() {
		assertSame("applications",root.getSubDirectories().get(0).getName());
		assertSame("home", root.getSubDirectories().get(1).getName());
		assertSame("code",home.getSubDirectories().get(0).getName());
	}

	@Test
	public void verifyDirectoryEqualityRoot() {
		String[] expected = { "true", "root", "0", localTime.toString(), null, "125","2" };
		Directory actual = root;
		assertArrayEquals(expected, dirToStringArray(actual));
	}

	@Test
	public void verifyDirectoryEqualityHome() {
		String[] expected = { "true", "home", "0", localTime.toString(),"root", "100", "4"};
		Directory actual = home;
		assertArrayEquals(expected, dirToStringArray(actual));
	}

	@Test
	public void verifyDirectoryEqualityApplications() {
		String[] expected = { "true", "applications", "0", localTime.toString(), "root","25", "2"};
		Directory actual = applications;
		assertArrayEquals(expected, dirToStringArray(actual));
	}

	@Test
	public void verifyDirectoryEqualityCode() {
		String[] expected = { "true", "code", "0", localTime.toString(), "home","30","3"};
		Directory actual = code;
		assertArrayEquals(expected, dirToStringArray(actual));
		
	}

}
