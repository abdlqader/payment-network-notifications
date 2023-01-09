package com.example.Notifications.Notification;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table
@Data
@NoArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private long id;
    @Column(unique = true, nullable = false)
    private String code;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private NotificationNetwork network;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private NotificationType type;
    @CreationTimestamp
    @Column(updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime updatedAt;

    public enum NotificationType {
        MAN, DI, PISI;
    }
    public enum NotificationNetwork {
        MC, VISA, JCB, EBC
    }

    public Notification(String code, NotificationNetwork network, NotificationType type) {
        this.code = code;
        this.network = network;
        this.type = type;
    }

    public Notification(long id, String code, NotificationNetwork network, NotificationType type) {
        this.id = id;
        this.code = code;
        this.network = network;
        this.type = type;
    }
}