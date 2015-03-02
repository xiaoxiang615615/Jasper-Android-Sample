package com.jasper.jjfilebrowser;

import java.io.File;


public class JJFile {

	private File file;
	
	public JJFile(File file)
	{
		this.file = file;
	}
	
	public File getFile() {
		return file;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return file.getName()!=null?file.getName():"";
	}
	

}
