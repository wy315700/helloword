package gsonObject;

public class GlobalProtocol {
    private String request = null;
    private String sessionID = null;
    private String result = null;
    

    public String getRequest() {
    	return request;
    }
    public void setRequest(String string) {
        this.request = string;
    }

    public String getResult() {
        return result;
    }
    public void setResult(String string) {
        this.result = string;
    }

    public String getSessionID() {
        return sessionID;
    }
    public void setSessionID(String string) {
        this.sessionID = string;
    }
}