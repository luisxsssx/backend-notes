package com.api.notes.Model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DATA_NOTES")
public class NotesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long UUID;

    @Column(length = 255)
    String noteBody;

    @Column(length = 100)
    String Title;

    @Column(name = "created_at")
    LocalDateTime createdAt;

    @Column(name = "update_at")
    LocalDateTime updateAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public UserModel user;

    // Method to set creation date automatically
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}