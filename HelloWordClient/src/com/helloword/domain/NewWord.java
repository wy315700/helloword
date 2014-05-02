package com.helloword.domain;

public class NewWord {
	public int pro_id;
	public String pro_description;
	public String pro_ans_a;
	public String pro_ans_b;
	public String pro_ans_c;
	public String pro_ans_d;
	public int pro_point;
	public int pro_time;
	public int pro_type;
	
	
	public NewWord() {
	}
	

	public NewWord(String pro_description, String pro_ans_a,
			String pro_ans_b, String pro_ans_c, String pro_ans_d,
			int pro_point, int pro_time, int pro_type) {
		super();
		this.pro_description = pro_description;
		this.pro_ans_a = pro_ans_a;
		this.pro_ans_b = pro_ans_b;
		this.pro_ans_c = pro_ans_c;
		this.pro_ans_d = pro_ans_d;
		this.pro_point = pro_point;
		this.pro_time = pro_time;
		this.pro_type = pro_type;
	}

	public int getPro_id() {
		return pro_id;
	}

	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}

	public String getPro_description() {
		return pro_description;
	}

	public void setPro_description(String pro_description) {
		this.pro_description = pro_description;
	}

	public String getPro_ans_a() {
		return pro_ans_a;
	}

	public void setPro_ans_a(String pro_ans_a) {
		this.pro_ans_a = pro_ans_a;
	}

	public String getPro_ans_b() {
		return pro_ans_b;
	}

	public void setPro_ans_b(String pro_ans_b) {
		this.pro_ans_b = pro_ans_b;
	}

	public String getPro_ans_c() {
		return pro_ans_c;
	}

	public void setPro_ans_c(String pro_ans_c) {
		this.pro_ans_c = pro_ans_c;
	}

	public String getPro_ans_d() {
		return pro_ans_d;
	}

	public void setPro_ans_d(String pro_ans_d) {
		this.pro_ans_d = pro_ans_d;
	}

	public int getPro_point() {
		return pro_point;
	}

	public void setPro_point(int pro_point) {
		this.pro_point = pro_point;
	}

	public int getPro_time() {
		return pro_time;
	}

	public void setPro_time(int pro_time) {
		this.pro_time = pro_time;
	}

	public int getPro_type() {
		return pro_type;
	}

	public void setPro_type(int pro_type) {
		this.pro_type = pro_type;
	}


	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("word id:"+pro_id);
		sb.append(" description:"+pro_description);
		sb.append("==> A(ans):"+pro_ans_a);
		sb.append(" B:"+pro_ans_b);
		sb.append(" C:"+pro_ans_c);
		sb.append(" D:"+pro_ans_d);
		sb.append(" point:"+pro_point);
		sb.append(" time:"+pro_time);
		sb.append(" type:"+pro_type);
		sb.append("\n");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		return pro_description.hashCode();
	}
}
