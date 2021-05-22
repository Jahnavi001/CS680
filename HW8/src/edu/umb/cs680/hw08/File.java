package edu.umb.cs680.hw08;

import java.time.LocalDateTime;

public class File extends FSElement {
	
	public File(Directory main, String name, int size, LocalDateTime createdTime) {
		super(main, name, size, createdTime);
		main.appendChild(this);
	}

	public boolean isDirectory() {
		return false;
	}
	
	public boolean isFile() {
		return true;
	}
	
	public boolean isLink() {
		return false;
	}
}
