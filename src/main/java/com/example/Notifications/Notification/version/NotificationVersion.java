package com.example.Notifications.Notification.version;

import com.example.Notifications.Notification.Notification;
import com.example.Notifications.Pdf.Pdf;
import jakarta.persistence.*;
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
    @ManyToOne
    @PrimaryKeyJoinColumn
    private Notification notification;
    private int version = 1;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pdf_id", referencedColumnName = "id")
    private Pdf pdf;
    private Date publishedAt;
    private Date effectiveAt;
    @Enumerated(EnumType.STRING)
    private ActionTypes action;
    @Enumerated(EnumType.STRING)
    private StatusTypes status;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
    enum ActionTypes {
        New, Notified, Study, Ongoing, Completed, NA
    }
    enum StatusTypes{
        Planned, Warned, Delayed, Applied
    }

    public NotificationVersion() {
    }
}
