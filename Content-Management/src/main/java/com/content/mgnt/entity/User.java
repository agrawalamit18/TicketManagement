package com.content.mgnt.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "CONTENT_USER")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long recId;

    private Integer loginId;
    private String fullName;
    private String emailId;
    private int active = 1;
}




















