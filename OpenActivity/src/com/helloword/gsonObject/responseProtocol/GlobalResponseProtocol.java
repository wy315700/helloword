package com.helloword.gsonObject.responseProtocol;

import com.helloword.gsonObject.GlobalProtocol;

public class GlobalResponseProtocol extends GlobalProtocol {
    
    private String result = null;
    
    public String getResult() {
        return result;
    }
    public void setResult(String string) {
        this.result = string;
    }
    
}