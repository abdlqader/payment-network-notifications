package com.example.Notifications.Notification.version;

import com.example.Notifications.Notification.Notification;
import com.example.Notifications.Notification.NotificationRequest;
import com.example.Notifications.Pdf.Pdf;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Table
public class NotificationVersion {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Notification notification;
    //TODO: version should be auto incremented based on notification entity.
    private int version = 1;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pdf_id", referencedColumnName = "id")
    private Pdf pdf;
    @Column(nullable = false)
    private Date publishedAt;
    private Date effectiveAt;
    @Enumerated(EnumType.STRING)
    private NotificationAction action;
    @Enumerated(EnumType.STRING)
    private NotificationStatus status;
    @Column(name = "title", length = 255, nullable = false)
    private String title;
    @Lob
    @Column(name = "description", length = 512, nullable = false)
    private String description;
    @CreationTimestamp
    @Column(updatable = false)
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
    public enum NotificationAction {
        New, Notified, Study, Ongoing, Completed, NA
    }
    public enum NotificationStatus{
        Planned, Warned, Delayed, Applied
    }

    public NotificationVersion() {}

    public NotificationVersion(Date publishedAt, NotificationAction action, String title, String description) {
        this.publishedAt = publishedAt;
        this.action = action;
        this.title = title;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Pdf getPdf() {
        return pdf;
    }

    public void setPdf(Pdf pdf) {
        this.pdf = pdf;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Date getEffectiveAt() {
        return effectiveAt;
    }

    public void setEffectiveAt(Date effectiveAt) {
        this.effectiveAt = effectiveAt;
    }

    public NotificationAction getAction() {
        return action;
    }

    public void setAction(NotificationAction action) {
        this.action = action;
    }

    public NotificationStatus getStatus() {
        return status;
    }

    public void setStatus(NotificationStatus status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public NotificationVersion updatingValues(NotificationRequest payload){
        this.setTitle(payload.getTitle());
        this.setDescription(payload.getDescription());
        this.setEffectiveAt(payload.getEffectiveAt());
        this.setPublishedAt(payload.getPublishedAt());
        this.setStatus(payload.getStatus());
        this.setAction(payload.getAction());
        return this;
    }
}
