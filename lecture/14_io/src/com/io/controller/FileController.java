package com.io.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

// UTF-8
public class FileController {
	public void basicFile() {
		// ���� Ŭ������ �̿��ؼ� ������ �ٷﺸ��!
		
		File f = new File("test.txt");
		// default ������ ����. �׻� �Ű����� �־�ߵ�
		// text.txt��� �̸��� ����Ŭ������ ��ü����
		// ���� ������ ����Ŵ� �ƴ�.
		// �Ű������� ���ϸ��� �ۼ��ϸ� �⺻������Ʈ�� ��ΰ� default��η� ����
		
		
		// ������ File��ü�� �̿��ؼ� ���� �����ϱ�
		try {
			f.createNewFile(); // ��ü�� �ƴ� ���� ������ �����ϴ� �޼ҵ�
		}catch(IOException e ) {
			e.printStackTrace();
		}
		// ������ �����Ѵٰ� �ص� ������Ʈ Ʈ���� �ٷ� �����°� �ƴ�
		// ���ΰ�ħ�ؾߵ� -> ������Ʈ�� ������ ��ư ������ refresh
		
		// ������Ʈ ��ΰ� �ƴ� �ٸ� ��ο� ������ �����ϱ�
		File f1 = new File("/Users/Jang/Desktop/test.txt");
		
		try {
			f1.createNewFile();
			// ���������� �����Ǹ� true �ƴϸ� false 
			// if������ �б� ����.
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		// ������Ʈ ���ο��� ���ã��
		System.out.println(FileController.class.getResource("").getPath());
		// ���� ��� (default ���)
	
		String path = FileController.class.getResource("/").getPath();
		// ������Ʈ�� �����θ� ������
		path = path.substring(0,path.lastIndexOf("bin"));
		// ���ڿ��� �߶� ���ϴ� �ּҿ� ��θ� ã�� �� ����.
		// 0�� �ε������� bin �ձ��� �߶� path�� ����.
		System.out.println(path);
		
		File f2 = new File(path+"/pathTest.txt");
		// bin���� �ȿ� ����.
		
		try {
			if(f2.createNewFile()) {
				System.out.println("pathTest.txt ���� �����Ϸ�");
			}else {
				System.out.println("pathTest.txt ���� ��������");
			}
			// ���������� �����Ǹ� true �ƴϸ� false 
			// if������ �б� ����.
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		// ���丮 �����ϱ�
		// File��ü�� �̿��ϸ� ���丮�� ������ �� �ִ�.
		// mkdir() / mkdirs()  -> ��������
		// mkdir() : �ѹ��� �ڽ����� �Ѱ��� ����
		// mkdirs() : �ѹ��� ���� �ڽ����� ����
		
		File dir = new File(path+"/"+"data/a/b/c");
		// ���� �ִ� �������� 1���� �߰��� �� ����
		// 2�� �̻� �����ϸ� ������ �ȳ����� �����ȵ�
		
		dir.mkdir();
		// ���������� �����Ǹ� true �ƴϸ� false 
		// if������ �б� ����.
		
		File dirs = new File(path+"/"+"data/a/b/c");
		dirs.mkdirs();
		
		// �����(����, ����)
		// delete() ������ ����
		File deleteFile = new File(path+"test.txt");
		deleteFile.delete();

		File delDir = new File(path + "data/a/b");
		// ������ ���ﶧ
		// ���� ���� �������� �ϳ��ϳ� ��������
		// ex) data/a/b/c ������
		// delete() -> data �Ұ��� 
		// data/a/b/c ���� �ϳ��� �� ��������
		// data/a/b
		// data/a
		// data 
		// ���� ��
		
		System.out.println(delDir.delete());
	}
	
	// ������Ʈ�� bs������ ����� bs.txt ������ �����غ���.
	public void fileTest() {
		
		String path = FileController.class.getResource("/").getPath();
		path = path.substring(0,path.lastIndexOf("bin"));
		File dir = new File(path+"bs");
		
		File n = new File(path+"bs","bs.txt");
		
		if(dir.mkdirs()) {
			try {
				n.createNewFile();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	// File��ü�� �̿��ؼ� ���Ͽ� ���� ������ ����غ���.
	public void fileInfo() {
		String path = FileController.class.getResource("/").getPath();
		path = path.substring(0,path.lastIndexOf("bin"));
		File f = new File(path+"bs","bs.txt");
		File dir = new File (path+"bs");
		System.out.println( f.isDirectory() );
		// ���丮��? (�����̴�?) -> false -> f�� bs.txt������
		
		System.out.println(dir.isDirectory());
		// ���丮��? ->true ->"bs"������
		
		if(f.isFile()){// f�� �����̴�? -> txt ������
			System.out.println(f.canExecute()); 
			// ���� �����̴�? -> ��
			System.out.println(f.canRead());
			// ���� �о�ü� �ִ�? -> ��
			System.out.println(f.canWrite());
			// ���������ϴ�? -> ��
			System.out.println(f.getName());
			// ���� �̸��� ����? -> bs.txt
			System.out.println(f.getParent());
			// �θ� ������? -> ���������� ����?
			System.out.println(f.getParent());
			// �ڽ��� ���
			File parentFile = f.getParentFile();
			// �θ�� ���ϰ�ü�� ��ȯ
			System.out.println(parentFile.getName());
			
			System.out.println(f.isHidden());
			// ���������̴�? 
			System.out.println(f.lastModified());
			System.out.println(new Date(f.lastModified()) );
			Date modifyt = new Date(f.lastModified());
			String m = new SimpleDateFormat("yyyy�� MM�� dd�� hh:mm:ss ").format(modifyt);
			System.out.println(m);
			
			System.out.println(f.length());
			// ������ ũ��
			
			f.exists();
			f = new File("/Users/Jang/Desktop/bs.txt");
			// ������ �ִ�?
			if(f.exists()) {
				System.out.println("�����ִ�?");
			}else {
				System.out.println("���� ����!");
				
				try { // ������ ��������
					f.createNewFile();
				}catch(IOException e) { // Exception�� ���
					e.printStackTrace(); // ��� Exception�������� Ȯ���ϰ�
				}
				
			}
		}
		// ���� ��ü ���� ��������
		File rootDir = new File("/Users/Jang");
		String[] files = rootDir.list();
		// ������ �ִ� ��� ���� ����� ���
		
		for(String file : files) {
			File tmp = new File(rootDir.getAbsolutePath(),file);
			if(tmp.isFile()) System.out.println(file);		
		}
		
		File[] fileList = rootDir.listFiles();
		for(File t : fileList) {
			if(t.isDirectory()) {
				System.out.println(t.getName());
			}
		}
		
		
		
	}
	
}
