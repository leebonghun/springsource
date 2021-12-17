package com.example.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity(name="tbl_boards")
public class BoardEntity {
   
   @Id
   @GeneratedValue(strategy= GenerationType.SEQUENCE)
   private Long bno;
   private String title;
   private String writer;
   private String content;
   
   @CreationTimestamp
   private LocalDateTime regdate;
   @UpdateTimestamp
   private LocalDateTime updatedate;
}