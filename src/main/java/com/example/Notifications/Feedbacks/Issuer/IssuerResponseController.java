package com.example.Notifications.Feedbacks.Issuer;

import com.example.Notifications.ConstantURLs;
import com.example.Notifications.Feedbacks.Feedback;
import com.example.Notifications.Feedbacks.FeedbackRequest;
import com.example.Notifications.Feedbacks.FeedbackService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping(ConstantURLs.ISSUER_FEEDBACK_URL)
@AllArgsConstructor
public class IssuerResponseController {
    private FeedbackService service;
    @GetMapping(ConstantURLs.ISSUER_FEEDBACK_ID_URL)
    public Feedback getIssuerFeedback(@PathVariable long id){
        return this.service.getResponse(id);
    }

    @PostMapping
    public Feedback createIssuerFeedback(@RequestBody FeedbackRequest feedback){
        return this.service.createResponse(feedback , Feedback.Teams.Issuer);
    }

    @PutMapping
    public Feedback updateIssuerFeedback(@RequestBody FeedbackRequest feedback){
        return this.service.updateResponse(feedback, Feedback.Teams.Issuer);
    }

    @DeleteMapping(ConstantURLs.ISSUER_FEEDBACK_ID_URL)
    public boolean deletedIssuerFeedback(@PathVariable long id){
        return this.service.deleteResponse(id);
    }
}
