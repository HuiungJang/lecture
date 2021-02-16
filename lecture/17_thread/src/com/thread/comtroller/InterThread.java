package com.thread.comtroller;

// Runnable 인터페이스를 구현해서 적용하는 방법
public class InterThread implements Runnable{

   @Override
   public void run(){
        for(int i=0; i<50; i++){
            System.out.println(i+ " : 인터쓰레드");
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
   }

}
