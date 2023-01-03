package com.example.Notifications.Notification;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table
public class Notification {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private long id;
    @NotNull(message = "Notification code is required")
    @Column(unique = true, nullable = false)
    private String code;
    @NotNull(message = "Notification title is required")
    @Column(name = "title", length = 255, nullable = false)
    private String title;
    @NotNull(message = "Notification description is required")
    @Lob
    @Column(name = "description", length = 512, nullable = false)
    private String description;
    @NotNull(message = "Notification type is required")
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private NotificationType type;
    @CreationTimestamp
    @Column(updatable = false)
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;

    enum NotificationType {
        MAN, DI, PISI;
    }

    public Notification() {
    }

    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public NotificationType getType() {
        return type;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
}