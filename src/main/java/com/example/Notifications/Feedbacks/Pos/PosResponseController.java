package com.example.Notifications.Feedbacks.Pos;

import com.example.Notifications.ConstantURLs;
import com.example.Notifications.Feedbacks.Feedback;
import com.example.Notifications.Feedbacks.FeedbackRequest;
import com.example.Notifications.Feedbacks.FeedbackService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping(ConstantURLs.POS_FEEDBACK_URL)
@AllArgsConstructor
public class PosResponseController {
    private FeedbackService service;
    @GetMapping(ConstantURLs.POS_FEEDBACK_ID_URL)
    public Feedback getPosFeedback(@PathVariable long id){
        return this.service.getResponse(id);
    }

    @PostMapping
    public Feedback createPosFeedback(@RequestBody FeedbackRequest feedback){
        return this.service.createResponse(feedback, Feedback.Teams.Pos);
    }

    @PutMapping
    public Feedback updatePosFeedback(@RequestBody FeedbackRequest feedback){
        return this.service.updateResponse(feedback, Feedback.Teams.Pos);
    }

    @DeleteMapping(ConstantURLs.POS_FEEDBACK_ID_URL)
    public boolean deletedPosFeedback(@PathVariable long id){
        return this.service.deleteResponse(id);
    }
}
