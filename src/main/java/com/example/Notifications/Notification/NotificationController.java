package com.example.Notifications.Notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="notification")
public class NotificationController {
    private final NotificationRepository notificationRepo;
    @Autowired
    public NotificationController(NotificationRepository notification){this.notificationRepo = notification;}
    @GetMapping("/list")
    public List<Notification> getNotification(){
        return notificationRepo.findAll();
    }
}
