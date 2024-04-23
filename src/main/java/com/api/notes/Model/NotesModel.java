package com.api.notes.Model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "DATA_NOTES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UUID;

    @Column(length = 255)
    private String noteBody;

    @Column(length = 100)
    private String Title;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    // Method to set creation date automatically
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updateAt = LocalDateTime.now();
    }
}