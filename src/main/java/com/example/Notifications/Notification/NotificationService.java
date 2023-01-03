package com.example.Notifications.Notification;

import com.example.Notifications.Exceptions.DataIntegrityException;
import com.example.Notifications.Exceptions.DataNotFoundException;
import com.example.Notifications.Notification.version.NotificationVersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private NotificationRepository notificationRepo;
    private NotificationVersionRepository repo;

    @Autowired
    public NotificationService(NotificationRepository notificationRepo, NotificationVersionRepository repo) {
        this.notificationRepo = notificationRepo;
        this.repo = repo;
    }
    public Notification createOrUpdateNotification(Notification payload) throws DataIntegrityViolationException{
        try {
            return this.notificationRepo.save(payload);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityException();
        }
    }
    public boolean deleteNotification(long id) throws EmptyResultDataAccessException {
        try {
            this.notificationRepo.deleteById(id);
            return true;
        }catch (EmptyResultDataAccessException e){
            throw new DataNotFoundException();
        }
    }
}
