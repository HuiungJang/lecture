package com.thread.run;

import com.thread.comtroller.CharacterRun;
import com.thread.model.vo.Character;

public class CharacterMain {
    public static void main(String[] args) {

        CharacterRun sang = new CharacterRun(new Character(50,1,"김상현"));
        CharacterRun kim = new CharacterRun(new Character(30,2,"김태희"));
        CharacterRun yoo = new CharacterRun(new Character(1000,1,"유병승"));

        sang.start();
        kim.start();
        yoo.start();


    }
}
