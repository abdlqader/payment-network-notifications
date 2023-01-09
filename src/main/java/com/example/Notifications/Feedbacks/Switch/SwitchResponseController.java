package com.example.Notifications.Feedbacks.Switch;

import com.example.Notifications.ConstantURLs;
import com.example.Notifications.Feedbacks.Feedback;
import com.example.Notifications.Feedbacks.FeedbackRequest;
import com.example.Notifications.Feedbacks.FeedbackService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping(ConstantURLs.SWITCH_FEEDBACK_URL)
@AllArgsConstructor
public class SwitchResponseController {
    private FeedbackService service;
    @GetMapping(ConstantURLs.SWITCH_FEEDBACK_ID_URL)
    public Feedback getSwitchFeedback(@PathVariable long id){
        return this.service.getResponse(id);
    }

    @PostMapping
    public Feedback createSwitchFeedback(@RequestBody FeedbackRequest feedback){
        return this.service.createResponse(feedback, Feedback.Teams.Switch);
    }

    @PutMapping
    public Feedback updateSwitchFeedback(@RequestBody FeedbackRequest feedback){
        return this.service.updateResponse(feedback, Feedback.Teams.Switch);
    }

    @DeleteMapping(ConstantURLs.SWITCH_FEEDBACK_ID_URL)
    public boolean deletedSwitchFeedback(@PathVariable long id){
        return this.service.deleteResponse(id);
    }
}
