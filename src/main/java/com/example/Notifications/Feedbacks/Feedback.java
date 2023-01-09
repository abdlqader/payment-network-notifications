package com.example.Notifications.Feedbacks;

import com.example.Notifications.Notification.version.NotificationVersion;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@Entity
@Table
public class Feedback {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "notification_version_id", referencedColumnName = "id")
    private NotificationVersion notificationVersion;
    @Column(nullable = false)
    private boolean related;
    private LocalDate dueDate;
    private String comment;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Teams team;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public enum Teams {
        Acquirer, Issuer, Pos, Switch, Xcs
    }

    public Feedback(FeedbackRequest payload){
        this.id = payload.getId();
        this.related = payload.isRelated();
        this.dueDate = payload.getDueDate();
        this.comment = payload.getComment();
    }
}
