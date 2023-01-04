package com.example.Notifications.Notification;

import com.example.Notifications.Exceptions.DataIntegrityException;
import com.example.Notifications.Exceptions.DataNotFoundException;
import com.example.Notifications.Notification.version.NotificationVersion;
import com.example.Notifications.Notification.version.NotificationVersionRepository;
import com.example.Notifications.Pdf.Pdf;
import com.example.Notifications.Pdf.PdfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotificationService {
    private NotificationRepository notificationRepo;
    private NotificationVersionRepository notificationVersionRepo;
    private PdfRepository pdfRepo;

    @Autowired
    public NotificationService(NotificationRepository notificationRepo, NotificationVersionRepository notificationVersionRepo, PdfRepository pdfRepo) {
        this.notificationRepo = notificationRepo;
        this.notificationVersionRepo = notificationVersionRepo;
        this.pdfRepo = pdfRepo;
    }
    public NotificationRequest getNotification(long id){
        try {
            NotificationVersion notificationVersion = Optional.of(this.notificationVersionRepo.findById(id)).get().orElseThrow(IllegalArgumentException::new);
            NotificationRequest response = new NotificationRequest(notificationVersion.getNotification(),notificationVersion,notificationVersion.getPdf());
            return response;
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityException();
        }
    }
    public NotificationRequest createNotification(NotificationRequest payload) throws DataIntegrityViolationException{
        try {
            //notification creation
            Notification notification = new Notification(payload.getCode(), payload.getNetwork(),payload.getType());
            notification = this.notificationRepo.save(notification);
            //pdf creation
            Pdf pdf = new Pdf(payload.getLink());
            pdf = this.pdfRepo.save(pdf);
            //version creation
            NotificationVersion notificationVersion = new NotificationVersion();
            notificationVersion.updatingValues(payload);
            notificationVersion.setNotification(notification);
            notificationVersion.setPdf(pdf);
            notificationVersion = this.notificationVersionRepo.save(notificationVersion);
            payload.setId(notificationVersion.getId());
            return payload;
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityException();
        }
    }
    public NotificationRequest updateNotification(NotificationRequest payload) throws DataIntegrityViolationException{
        try {
            Optional<NotificationVersion> notificationVersion = this.notificationVersionRepo.findById(payload.getId());
            NotificationVersion notificationVersionUpdated = Optional.of(notificationVersion).get().orElseThrow(IllegalArgumentException::new);
            notificationVersionUpdated.updatingValues(payload);
            if(!notificationVersionUpdated.getPdf().getLink().equals(payload.getLink())) {
                notificationVersionUpdated.getPdf().setLink(payload.getLink());
                this.pdfRepo.save(notificationVersionUpdated.getPdf());
            }
            this.notificationVersionRepo.save(notificationVersionUpdated);
            return payload;
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
