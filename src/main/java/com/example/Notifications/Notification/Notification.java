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
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;

    public enum NotificationType {
        MAN, DI, PISI;
    }
    public enum NotificationNetwork {
        MC, VISA, JCB, EBC
    }

    public Notification() {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public NotificationNetwork getNetwork() {
        return network;
    }

    public void setNetwork(NotificationNetwork network) {
        this.network = network;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}