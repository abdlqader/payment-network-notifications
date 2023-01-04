package com.example.Notifications.Notification;

import com.example.Notifications.Markers.OnCreate;
import com.example.Notifications.Markers.OnUpdate;
import com.example.Notifications.Notification.version.NotificationVersion;
import com.example.Notifications.Pdf.Pdf;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

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
    private Date effectiveAt;
    @NotNull(message = "Notification published date is required")
    private Date publishedAt;

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

    public Notification.NotificationNetwork getNetwork() {
        return network;
    }

    public void setNetwork(Notification.NotificationNetwork network) {
        this.network = network;
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

    public Notification.NotificationType getType() {
        return type;
    }

    public void setType(Notification.NotificationType type) {
        this.type = type;
    }

    public NotificationVersion.NotificationAction getAction() {
        return action;
    }

    public void setAction(NotificationVersion.NotificationAction action) {
        this.action = action;
    }

    public NotificationVersion.NotificationStatus getStatus() {
        return status;
    }

    public void setStatus(NotificationVersion.NotificationStatus status) {
        this.status = status;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getEffectiveAt() {
        return effectiveAt;
    }

    public void setEffectiveAt(Date effectiveAt) {
        this.effectiveAt = effectiveAt;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }
    public NotificationRequest(){};
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