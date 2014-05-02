package com.helloword.domain;


/**
 * 题库标识
 * @author bone-lee
 *
 */
public enum QuestionLibType{
    CET4("1"), CET6("3"), GRE("5"),IELTS("7"),TOEFL("9");
    private String typeID;

    private QuestionLibType(String typeID) {
        this.typeID=typeID;
    }

    @Override
    public String toString() {
        return typeID;
    } 
    
    public int getTypeID() {
        return Integer.parseInt(typeID);
    } 
}
