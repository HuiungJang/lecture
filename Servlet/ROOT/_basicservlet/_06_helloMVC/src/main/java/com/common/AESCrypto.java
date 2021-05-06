package com.common;

// 양방향 암호화를 지원하는 클래스
// 양방향 암호화처리 클래스느 기본 java api에서 제공하고 있다.
// javax.crypto , javax.security 패키지에 구성되어있음

import javax.crypto.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

// AES 방식
// key 관리가 중요함 Key는 프로젝트에서 한개만 있어야함
public class AESCrypto {
    private static SecretKey key; // 암호화 처리를 위한 키
    private String path; // 파일로 저장된 암호화키의 위치
    // 암호화된 키는 파일로 저장해서 관리한다.

    public AESCrypto() {
        // class 가 인스턴스화(생성) 될때 기본 설정을 해줘야한다.
        // 1. key파일이 있으면 key 파일에서 SecretKey 객체를 불러오고
        // 없으면 생성해서 파일로 저장
        this.path = AESCrypto.class.getResource("/").getPath();
        this.path=this.path.substring(0,this.path.indexOf("classes"));
        System.out.println(path);

        File f = new File(this.path+"/HU.hu");
        // key를 저장하고 있는 파일 이름이 HU.hu -> SecreteKey 객체가 저장되어있음
        if(f.exists()){
            // key를 저장하고 있는 파일이 있으면
            try{
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
                this.key = (SecretKey)ois.readObject();

                ois.close();
            }catch (IOException | ClassNotFoundException e){
                e.printStackTrace();
            }
        }else{
            // 없으면 SecreteKey 객체를 생성해준다.
            if(key == null){
                getGenerator(); // key 값을 생성하는 메소드
            }
        }
    } // 생성자 닫기

    private void getGenerator(){
        // SecreteKey 생성하는 메소드
        SecureRandom ser = new SecureRandom();

        // key를 생성해주는 클래스
        KeyGenerator keygen = null;
        try{
            // 키 생성을 위한 기본값 세팅하기
            // 적용할 알고리즘 선택 (AES -> 1개 키 생성, RSA -> 2개 키 생성(공개키, 개인키) )
            keygen= KeyGenerator.getInstance("AES");
            // 키값 생성 초기화

            keygen.init(128,ser);
            // key를 몇비트로 할껀지, sort 값을 넣는다

            this.key = keygen.generateKey(); // 키 생성

        }catch(NoSuchAlgorithmException e ){
            e.printStackTrace();
        }
        // 생성된 키 객체를 정해진 경로에 파일로 저장한다.
        File f = new File(this.path+"/HU.hu");
        try{
            ObjectOutputStream oss= new ObjectOutputStream(new FileOutputStream(f));
            oss.writeObject(this.key);

            oss.flush();
            oss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 암호화 처리하기
    public static String encrypt(String str)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException {
        // key를 가지고 암호화 처리하는 클래스가 있음
        // Cipher
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE,AESCrypto.key);

        // 매개변수로 넘어온 값 암호화 처리하기
        // 매개변수에서 넘어온 값을 바이트화
        byte[] encrypt = str.getBytes(Charset.forName("utf-8"));
        // 암호화
        byte[] result = cipher.doFinal(encrypt);
        // 다시 String 형태로 변환
        String resultValue= Base64.getEncoder().encodeToString(result);

        return resultValue;
    }

    // 복호화 처리하기
    public static String decrypt(String encryptedStr)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException {
        // key를 가지고 복호화 처리하는 클래스가 있음
        // Cipher
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE,AESCrypto.key);

        // String을 디코딩하기
        byte[] decodeStr=Base64.getDecoder().decode(encryptedStr.getBytes(Charset.forName("utf-8")));
        // 매개변수로 넘어온 값 복호화하기
        byte[] oriVal = cipher.doFinal(decodeStr);

        return new String(oriVal);
    }
}
