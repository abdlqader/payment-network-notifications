package com.example.Notifications.Pdf;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Table
@Data
@NoArgsConstructor
public class Pdf {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String link;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate createdAt;
    @UpdateTimestamp
    private LocalDate updatedAt;

    public Pdf(String link) {
        this.link = link;
    }
}
