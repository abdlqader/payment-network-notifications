package com.example.Notifications.Notification;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Table
public class Notification {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private long id;
    @Column(unique = true, nullable = false)
    private String code;
    @Column(name = "title", length = 255, nullable = false)
    private String title;
    @Lob
    @Column(name = "description", length = 512, nullable = false)
    private String description;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private NotificationType type;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;

    enum NotificationType {
        MAN, DI, PISI;
    }

    public Notification() {
    }
}
