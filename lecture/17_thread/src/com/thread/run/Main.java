package com.thread.run;

import com.thread.comtroller.BasicThread;
import com.thread.comtroller.InterThread;

public class Main {
    public static void main(String[] args) {
        // 스레드 실행하기
        // Thread 객체의 start()메소드를 호출하면됨
        BasicThread t = new BasicThread();

        t.start();
        t = new BasicThread();
        t.start();

        // 인터페이스구현 스레드 실행하기
        Thread t2 = new Thread(new InterThread());
        t2.start();

        // join()메소드 사용
        try {
            t2.join();
            // 끼어듦
            // 이 메소드가 끝날때까지 뒤의 문장은 대기

        }catch (InterruptedException e){
            e.printStackTrace();
        }

        for(int i = 0; i<100; i++){
            System.out.println(i + " : 메인스레드");
            try {
                Thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

        }


    }
}
