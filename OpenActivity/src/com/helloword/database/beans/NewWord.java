package com.helloword.database.beans;

public class NewWord {
	public int word_id;
	public String word_content;
	public String word_meaning;
	public int word_type;
	
	
	
	public NewWord() {
	}
	
	
	
	public NewWord(int word_id, String word_content, String word_meaning,
			int word_type) {
		this.word_id = word_id;
		this.word_content = word_content;
		this.word_meaning = word_meaning;
		this.word_type = word_type;
	}



	public int getWord_id() {
		return word_id;
	}
	public void setWord_id(int word_id) {
		this.word_id = word_id;
	}
	public String getWord_content() {
		return word_content;
	}
	public void setWord_content(String word_content) {
		this.word_content = word_content;
	}
	public String getWord_meaning() {
		return word_meaning;
	}
	public void setWord_meaning(String word_meaning) {
		this.word_meaning = word_meaning;
	}
	public int getWord_type() {
		return word_type;
	}
	public void setWord_type(int word_type) {
		this.word_type = word_type;
	}
}
