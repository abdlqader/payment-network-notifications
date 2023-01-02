package com.example.Notifications.Pdf;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Table
public class Pdf {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String link;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;

    public Pdf() {
    }
}
