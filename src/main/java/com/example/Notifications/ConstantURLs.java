package com.example.Notifications;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class ConstantURLs {
    //NOTIFICATION URLS
    public static final String BASE_URL = "http://localhost:8080";
    public static final String NOTIFICATION_URL = "notification";
    public static final String NOTIFICATION_ID_PATH_VARIABLE = NOTIFICATION_URL +"/{id}";
    public static final String NOTIFICATION_LIST = NOTIFICATION_URL +"/list";

    //FEEDBACK URLS
    public static final String NOTIFICATION_FEEDBACK_URL = "feedback";

    public static final String ISSUER_FEEDBACK_URL = NOTIFICATION_FEEDBACK_URL + "/issuer";
    public static final String ISSUER_FEEDBACK_ID_URL = ISSUER_FEEDBACK_URL + "/{id}";

    public static final String ACQUIRER_FEEDBACK_URL = NOTIFICATION_FEEDBACK_URL + "/acquirer";
    public static final String ACQUIRER_FEEDBACK_ID_URL = ACQUIRER_FEEDBACK_URL + "/{id}";

    public static final String SWITCH_FEEDBACK_URL = NOTIFICATION_FEEDBACK_URL + "/switch";
    public static final String SWITCH_FEEDBACK_ID_URL = SWITCH_FEEDBACK_URL + "/{id}";

    public static final String POS_FEEDBACK_URL = NOTIFICATION_FEEDBACK_URL + "/pos";
    public static final String POS_FEEDBACK_ID_URL = POS_FEEDBACK_URL + "/{id}";

    public static final String XCS_FEEDBACK_URL = NOTIFICATION_FEEDBACK_URL + "/xcs";
    public static final String XCS_FEEDBACK_ID_URL = XCS_FEEDBACK_URL + "/{id}";


}
