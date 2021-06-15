package com.mybatis.model.vo;

import lombok.*;

import java.sql.Date;

//@AllArgsConstructor
//@NoArgsConstructor
//// 아래 4개 포함된게 @Data
//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
//
// 보통 아래 2개를 넣음

@Data // getter, setter, 기본 생성자, toString, hashCode, equals 오버라이딩처리
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    private int studentNo;
    private String studentName;
    private String studentTel;
    private String studentEmail;
    private String studentAddr;
    private Date regDate;
}
