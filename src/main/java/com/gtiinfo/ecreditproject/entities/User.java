package com.gtiinfo.ecreditproject.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int CIN;
    private String email;
    private String password;
    private Date dateNais;
    private String nom;
    private String prenom;
    private String tel;

}
