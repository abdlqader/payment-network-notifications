package com.example.Notifications.Feedbacks.XCS;

import com.example.Notifications.ConstantURLs;
import com.example.Notifications.Feedbacks.Feedback;
import com.example.Notifications.Feedbacks.FeedbackRequest;
import com.example.Notifications.Feedbacks.FeedbackService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping(ConstantURLs.XCS_FEEDBACK_URL)
@AllArgsConstructor
public class XcsResponseController {
    private FeedbackService service;
    @GetMapping(ConstantURLs.XCS_FEEDBACK_ID_URL)
    public Feedback getXcsFeedback(@PathVariable long id){
        return this.service.getResponse(id);
    }

    @PostMapping
    public Feedback createXcsFeedback(@RequestBody FeedbackRequest feedback){
        return this.service.createResponse(feedback, Feedback.Teams.Xcs);
    }

    @PutMapping
    public Feedback updateXcsFeedback(@RequestBody FeedbackRequest feedback){
        return this.service.updateResponse(feedback, Feedback.Teams.Xcs);
    }

    @DeleteMapping(ConstantURLs.XCS_FEEDBACK_ID_URL)
    public boolean deletedXcsFeedback(@PathVariable long id){
        return this.service.deleteResponse(id);
    }
}
