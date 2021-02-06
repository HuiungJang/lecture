package com.io.run;

import com.io.controller.FileController;
import com.io.controller.FileIOController;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		FileController fc = new FileController();
		
//		fc.basicFile();
//		
//		fc.fileTest();
//		
//		fc.fileInfo();
		FileIOController fio = new FileIOController();
//		fio.saveFile();
//		fio.loadFile();
//		fio.saveStrFile();
		fio.loadStrFile();
	}

}
