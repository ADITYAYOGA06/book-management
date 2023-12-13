package com.example.book.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "book")
public class Book {

    @Id
    @Column(name="id_buku")
    private String idBuku;
    @Column(name="judul")
    private String judul;
    @Column(name="penulis")
    private String penulis;
    @Column(name="penerbit")
    private String penerbit;
}
