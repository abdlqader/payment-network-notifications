package com.example.Notifications.Notification;

import com.example.Notifications.Markers.OnCreate;
import com.example.Notifications.Markers.OnUpdate;
import com.example.Notifications.Notification.version.NotificationVersion;
import com.example.Notifications.Pdf.Pdf;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
public class NotificationRequest {
    @Min(value = 0, groups = OnCreate.class)
    @Max(value = 0, groups = OnCreate.class)
    @Min(value = 1, groups = OnUpdate.class)
    private long id;
    @NotNull(message = "Notification code is required")
    private String code;
    @NotNull(message = "Notification network is required")
    private Notification.NotificationNetwork network;
    @NotNull(message = "Notification title is required")
    private String title;
    @NotNull(message = "Notification description is required")
    private String description;
    @NotNull(message = "Notification type is required")
    private Notification.NotificationType type;
    @NotNull(message = "Notification action is required")
    private NotificationVersion.NotificationAction action;
    private NotificationVersion.NotificationStatus status;
    @NotNull(message = "Notification link is required")
    private String link;
    @NotNull(message = "Notification effective date is required")
    private LocalDate effectiveAt;
    @NotNull(message = "Notification published date is required")
    private LocalDate publishedAt;
    public NotificationRequest(Notification notification,NotificationVersion version, Pdf pdf){
        this.setId(version.getId());
        this.setCode(notification.getCode());
        this.setNetwork(notification.getNetwork());
        this.setType(notification.getType());
        this.setAction(version.getAction());
        this.setTitle(version.getTitle());
        this.setDescription(version.getDescription());
        this.setEffectiveAt(version.getEffectiveAt());
        this.setPublishedAt(version.getPublishedAt());
        this.setStatus(version.getStatus());
        this.setLink(pdf.getLink());
    }
}