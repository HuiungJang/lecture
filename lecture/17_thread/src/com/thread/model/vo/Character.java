package com.thread.model.vo;

public class Character {
    private int hp;
    private int attack;
    private String name;

    public Character() {
    }

    public Character(int hp, int attack, String name) {
        this.hp = hp;
        this.attack = attack;
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
