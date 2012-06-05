package org.talend.mdm;

public class TestCase {
	private int id;
	private Result result;
	private String note;
	private String comment;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public enum Result {
		p,f,b;
	}
}
