package com.helloword.gsonObject.responseProtocol;

import com.helloword.gsonObject.GlobalDetails;

public class GetMessageResponseProtocol extends GlobalResponseProtocol {
    
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
        public void setTitle(String string) {
            this.title = string;
        }
        
        public String getContent() {
            return content;
        }
        public void setContent(String string) {
            this.content = string;
        }
    }
}
