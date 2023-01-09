package com.example.Notifications.Feedbacks.Acquirer;

import com.example.Notifications.ConstantURLs;
import com.example.Notifications.Feedbacks.Feedback;
import com.example.Notifications.Feedbacks.FeedbackRequest;
import com.example.Notifications.Feedbacks.FeedbackService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping(ConstantURLs.ACQUIRER_FEEDBACK_URL)
@AllArgsConstructor
public class AcquirerResponseController {
    private FeedbackService service;
    @GetMapping(ConstantURLs.ACQUIRER_FEEDBACK_ID_URL)
    public Feedback getAcquirerFeedback(@PathVariable long id){
        return this.service.getResponse(id);
    }

    @PostMapping
    public Feedback createAcquirerFeedback(@RequestBody FeedbackRequest feedback){
        return this.service.createResponse(feedback, Feedback.Teams.Acquirer);
    }

    @PutMapping
    public Feedback updateAcquirerFeedback(@RequestBody FeedbackRequest feedback){
        return this.service.updateResponse(feedback, Feedback.Teams.Acquirer);
    }

    @DeleteMapping(ConstantURLs.ACQUIRER_FEEDBACK_ID_URL)
    public boolean deletedAcquirerFeedback(@PathVariable long id){
        return this.service.deleteResponse(id);
    }
}
