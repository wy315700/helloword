package com.helloword.gsonObject.user;

import com.helloword.gsonObject.GlobalDetails;

public class GetMessageResponse extends GlobalResponse {
    
    private MessageDetails details;
    
    public MessageDetails getDetails() {
        return details;
    }
    public void setDetails(MessageDetails details) {
        this.details = details;
    }
    
    
    public class MessageDetails extends GlobalDetails {
        String title;
        String content;
        
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        
        public String getContent() {
            return content;
        }
        public void setContent(String content) {
            this.content = content;
        }
    }
}
