package com.example.Notifications.Notification;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "notification")
public class NotificationController {
    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notification) {
        this.notificationService = notification;
    }

    @GetMapping("/{notificationId}")
    public Notification getNotification(@PathVariable(value="notificationId") int notificationId) {
        System.out.println(notificationId);
        return new Notification();
    }

    @GetMapping("/list")
    public List<Notification> getNotifications() {
        return List.of(new Notification());
    }

    @PostMapping("")
    public Notification createNotification(@Valid @RequestBody Notification payload) {
        return this.notificationService.createOrUpdateNotification(payload);
    }
    //TODO: if id is not available, Unique Constrain error will be thrown. this should be handled properly or a new notification will be created
    @PutMapping("")
    public Notification updateNotification(@Valid @RequestBody Notification payload) {
        return this.notificationService.createOrUpdateNotification(payload);
    }

    @DeleteMapping("/{id}")
    public boolean deleteNotification(@PathVariable @Min(1) long id) {
        return this.notificationService.deleteNotification(id);
    }
}