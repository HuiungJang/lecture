package com.io.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

// UTF-8
public class FileController {
	public void basicFile() {
		// 파일 클래스를 이용해서 파일을 다뤄보자!
		
		File f = new File("test.txt");
		// default 생성자 없음. 항상 매개변수 있어야됨
		// text.txt라는 이름의 파일클래스의 객체생성
		// 실제 파일을 만든거는 아님.
		// 매개변수에 파일명을 작성하면 기본프로젝트의 경로가 default경로로 생성
		
		
		// 생성한 File객체를 이용해서 파일 생성하기
		try {
			f.createNewFile(); // 객체가 아닌 실제 파일을 생성하는 메소드
		}catch(IOException e ) {
			e.printStackTrace();
		}
		// 파일을 생성한다고 해도 프로젝트 트리에 바로 나오는게 아님
		// 새로고침해야됨 -> 프로젝트에 오른쪽 버튼 누르고 refresh
		
		// 프로젝트 경로가 아닌 다른 경로에 파일을 저장하기
		File f1 = new File("/Users/Jang/Desktop/test.txt");
		
		try {
			f1.createNewFile();
			// 정상적으로 생성되면 true 아니면 false 
			// if문으로 분기 가능.
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		// 프로젝트 내부에서 경로찾기
		System.out.println(FileController.class.getResource("").getPath());
		// 절대 경로 (default 경로)
	
		String path = FileController.class.getResource("/").getPath();
		// 프로젝트의 절대경로를 가져옴
		path = path.substring(0,path.lastIndexOf("bin"));
		// 문자열을 잘라서 원하는 주소와 경로를 찾을 수 있음.
		// 0번 인덱스부터 bin 앞까지 잘라서 path에 저장.
		System.out.println(path);
		
		File f2 = new File(path+"/pathTest.txt");
		// bin파일 안에 생김.
		
		try {
			if(f2.createNewFile()) {
				System.out.println("pathTest.txt 파일 생성완료");
			}else {
				System.out.println("pathTest.txt 파일 생성실패");
			}
			// 정상적으로 생성되면 true 아니면 false 
			// if문으로 분기 가능.
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		// 디렉토리 생성하기
		// File객체를 이용하면 디렉토리를 생성할 수 있다.
		// mkdir() / mkdirs()  -> 폴더생성
		// mkdir() : 한번에 자식폴더 한개만 생성
		// mkdirs() : 한번에 여러 자식폴더 생성
		
		File dir = new File(path+"/"+"data/a/b/c");
		// 실제 있는 폴더에서 1개만 추가로 더 생성
		// 2개 이상 생성하면 오류는 안나지만 생성안됨
		
		dir.mkdir();
		// 정상적으로 생성되면 true 아니면 false 
		// if문으로 분기 가능.
		
		File dirs = new File(path+"/"+"data/a/b/c");
		dirs.mkdirs();
		
		// 지우기(파일, 폴더)
		// delete() 파일을 지움
		File deleteFile = new File(path+"test.txt");
		deleteFile.delete();

		File delDir = new File(path + "data/a/b");
		// 폴더를 지울때
		// 가장 하위 폴더부터 하나하나 지워야함
		// ex) data/a/b/c 있으면
		// delete() -> data 불가능 
		// data/a/b/c 부터 하나씩 다 지워야함
		// data/a/b
		// data/a
		// data 
		// 제거 완
		
		System.out.println(delDir.delete());
	}
	
	// 프로젝트에 bs폴더를 만들고 bs.txt 파일을 저장해보자.
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
	// File객체를 이용해서 파일에 대한 정보를 출력해보자.
	public void fileInfo() {
		String path = FileController.class.getResource("/").getPath();
		path = path.substring(0,path.lastIndexOf("bin"));
		File f = new File(path+"bs","bs.txt");
		File dir = new File (path+"bs");
		System.out.println( f.isDirectory() );
		// 디렉토리니? (파일이니?) -> false -> f는 bs.txt파일임
		
		System.out.println(dir.isDirectory());
		// 디렉토리니? ->true ->"bs"폴더임
		
		if(f.isFile()){// f가 파일이니? -> txt 파일임
			System.out.println(f.canExecute()); 
			// 실행 파일이니? -> ㅖ
			System.out.println(f.canRead());
			// 파일 읽어올수 있니? -> ㅖ
			System.out.println(f.canWrite());
			// 수정가능하니? -> ㅖ
			System.out.println(f.getName());
			// 파일 이름이 뭐야? -> bs.txt
			System.out.println(f.getParent());
			// 부모가 누구니? -> 상위폴더가 뭐니?
			System.out.println(f.getParent());
			// 자신의 경로
			File parentFile = f.getParentFile();
			// 부모는 파일객체로 반환
			System.out.println(parentFile.getName());
			
			System.out.println(f.isHidden());
			// 숨김파일이니? 
			System.out.println(f.lastModified());
			System.out.println(new Date(f.lastModified()) );
			Date modifyt = new Date(f.lastModified());
			String m = new SimpleDateFormat("yyyy년 MM월 dd일 hh:mm:ss ").format(modifyt);
			System.out.println(m);
			
			System.out.println(f.length());
			// 파일의 크기
			
			f.exists();
			f = new File("/Users/Jang/Desktop/bs.txt");
			// 파일이 있니?
			if(f.exists()) {
				System.out.println("파일있니?");
			}else {
				System.out.println("파일 없어!");
				
				try { // 없으면 만들어야지
					f.createNewFile();
				}catch(IOException e) { // Exception도 잡고
					e.printStackTrace(); // 어디서 Exception나는지도 확인하고
				}
				
			}
		}
		// 폴더 전체 내용 가져오기
		File rootDir = new File("/Users/Jang");
		String[] files = rootDir.list();
		// 폴더에 있는 모든 파일 목록을 출력
		
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
