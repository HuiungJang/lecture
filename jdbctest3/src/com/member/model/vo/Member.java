package com.member.model.vo;

import java.io.Serializable;
import java.util.Objects;

public class Member implements Serializable {

    private static final long serialVersionUID = 8101521114912360449L;

    private String memberId;
    private String memberPwd;
    private String memberName;
    private String gender;
    private int age;
    private String email;
    private String phone;
    private String address;
    private String hobby;
    private String enrollDate;

    public Member() {
    }

    public Member(String memberId, String memberPwd, String memberName, String gender,
                  int age, String email, String phone, String address, String hobby, String enrollDate) {
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.memberName = memberName;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.hobby = hobby;
        this.enrollDate = enrollDate;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPwd() {
        return memberPwd;
    }

    public void setMemberPwd(String memberPwd) {
        this.memberPwd = memberPwd;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(String enrollDate) {
        this.enrollDate = enrollDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return age == member.age && Objects.equals(memberId, member.memberId) && Objects.equals(memberPwd, member.memberPwd) && Objects.equals(memberName, member.memberName) && Objects.equals(gender, member.gender) && Objects.equals(email, member.email) && Objects.equals(phone, member.phone) && Objects.equals(address, member.address) && Objects.equals(hobby, member.hobby) && Objects.equals(enrollDate, member.enrollDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, memberPwd, memberName, gender, age, email, phone, address, hobby, enrollDate);
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", memberPwd='" + memberPwd + '\'' +
                ", memberName='" + memberName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", hobby='" + hobby + '\'' +
                ", enrollDate='" + enrollDate + '\'' +
                '}';
    }
}
