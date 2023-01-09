package com.example.Notifications.Feedbacks;

import com.example.Notifications.Markers.OnCreate;
import com.example.Notifications.Markers.OnUpdate;
import com.example.Notifications.Notification.version.NotificationVersion;
import com.example.Notifications.Notification.version.NotificationVersionRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@AllArgsConstructor
@Validated
public class FeedbackService {
    private FeedbackRepository feedbackRepo;
    private NotificationVersionRepository notificationVersionRepo;
    @Validated(OnCreate.class)
    public Feedback createResponse(@Valid FeedbackRequest payload, Feedback.Teams team){
        Feedback feedback = new Feedback(payload);
        feedback.setTeam(team);
        NotificationVersion version = this.getNotificationVersionEntity(payload.getNotificationVersionId());
        feedback.setNotificationVersion(version);
        return this.feedbackRepo.save(feedback);
    }
    @Validated(OnUpdate.class)
    public Feedback updateResponse(@Valid FeedbackRequest payload, Feedback.Teams team){
        Feedback feedback = new Feedback(payload);
        feedback.setTeam(team);
        NotificationVersion version = this.getNotificationVersionEntity(payload.getNotificationVersionId());
        feedback.setNotificationVersion(version);
        return this.feedbackRepo.save(feedback);
    }
    public Feedback getResponse(@Min(1) long id){
        return this.feedbackRepo.findById(id).get();
    }
    public boolean deleteResponse(@Min(1) long id){
        Feedback feedback = this.feedbackRepo.findById(id).get();
        this.feedbackRepo.delete(feedback);
        return true;
    }
    private NotificationVersion getNotificationVersionEntity(long id){
        Optional<NotificationVersion> notificationVersion = this.notificationVersionRepo.findById(id);
        if (!notificationVersion.isPresent()) {
            throw new RuntimeException("Notification not found");
        }
        return notificationVersion.get();
    }
}
