package com.example.lap8.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "ChucVu")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ChucVu {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uniqueidentifier")
    private UUID id;

    private String ma;
    private String ten;
}