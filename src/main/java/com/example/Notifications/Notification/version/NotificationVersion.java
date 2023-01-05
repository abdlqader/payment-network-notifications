package com.example.Notifications.Notification.version;

import com.example.Notifications.Notification.Notification;
import com.example.Notifications.Notification.NotificationRequest;
import com.example.Notifications.Pdf.Pdf;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Table
@Data
@NoArgsConstructor
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

    public NotificationVersion(Date publishedAt, NotificationAction action, String title, String description) {
        this.publishedAt = publishedAt;
        this.action = action;
        this.title = title;
        this.description = description;
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
