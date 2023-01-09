package com.example.Notifications.Feedbacks;

import com.example.Notifications.Markers.OnCreate;
import com.example.Notifications.Markers.OnUpdate;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jdk.jfr.BooleanFlag;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class FeedbackRequest {
    @Min(value = 0, groups = OnCreate.class)
    @Max(value = 0, groups = OnCreate.class)
    @Min(value = 1, groups = OnUpdate.class)
    private long id;
    @Min(1)
    private long notificationVersionId;
    @NotNull
    @BooleanFlag
    private boolean related;
    private LocalDate dueDate;
    private String comment;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public FeedbackRequest(Feedback response){
        this.id = response.getId();
        this.notificationVersionId = response.getNotificationVersion().getId();
        this.related = response.isRelated();
        this.dueDate = response.getDueDate();
        this.comment = response.getComment();
        this.createdAt = response.getCreatedAt();
        this.updatedAt = response.getCreatedAt();
    }
}
