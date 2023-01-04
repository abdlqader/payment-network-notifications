package com.example.Notifications.Notification;

import com.example.Notifications.Markers.OnCreate;
import com.example.Notifications.Markers.OnUpdate;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping(path = "notification")
public class NotificationController {
    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notification) {
        this.notificationService = notification;
    }

    @GetMapping("/{id}")
    public NotificationRequest getNotification(@PathVariable @Min(1) int id) {
        return this.notificationService.getNotification(id);
    }

    @GetMapping("/list")
    public List<Notification> getNotifications() {
        return List.of(new Notification());
    }

    @Validated(OnCreate.class)
    @PostMapping("")
    public NotificationRequest createNotification(@Valid @RequestBody NotificationRequest payload) {
        return this.notificationService.createNotification(payload);
    }
    @Validated(OnUpdate.class)
    @PutMapping("")
    public NotificationRequest updateNotification(@Valid @RequestBody NotificationRequest payload) {
        return this.notificationService.updateNotification(payload);
    }

    @DeleteMapping("/{id}")
    public boolean deleteNotification(@PathVariable @Min(1) long id) {
        return this.notificationService.deleteNotification(id);
    }

}