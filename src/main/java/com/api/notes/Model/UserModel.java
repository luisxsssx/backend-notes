package com.api.notes.Model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USER_DATA")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UUID;

    @Column(unique = true)
    private String Username;

    @Column(length = 50)
    private String FirstName;

    @Column(length = 50)
    private String LastName;

    @Column(length = 100)
    private String Email;

    private String Password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<NotesModel> notes;
}