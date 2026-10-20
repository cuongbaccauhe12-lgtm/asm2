package com.example.lap8.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "CuaHang")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class CuaHang {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uniqueidentifier")
    private UUID id;

    private String ma;
    private String ten;
    private String diaChi;
    private String thanhPho;
    private String quocGia;
}