package com.example.lap8.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;
import java.util.Date;

@Entity
@Table(name = "NhanVien")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class NhanVien {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uniqueidentifier")
    private UUID id;

    private String ma;
    private String ten;
    private String tenDem;
    private String ho;
    private String gioiTinh;

    @Temporal(TemporalType.DATE)
    private Date ngaySinh;

    private String diaChi;
    private String sdt;
    private String matKhau;
    private Integer trangThai;

    @ManyToOne
    @JoinColumn(name = "IdCH")
    private CuaHang cuaHang;

    @ManyToOne
    @JoinColumn(name = "IdCV")
    private ChucVu chucVu;
}