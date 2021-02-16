package com.thread.comtroller;
    // 기본스레드 적용하기
public class BasicThread extends Thread{

    // 1. Thread 객체를 상속
    // 2. Thread 객체의 run 메소드를 재정의(Overriding)
    @Override
    public void run(){
        // 스레드가 실행할 작업내용을 구현.
        for(int i =0; i<100; i++){
            try {
                System.out.println(i + " : 상속 스레드");
                sleep(100);// 스레드 실행을 잠시 지연시키는 메소드
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }

}
