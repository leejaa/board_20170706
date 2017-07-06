package com.hanbit.board.domain;

public class BoardBean {
	int seq;
	String title,writer,content,regdate;
	public void setSeq(int seq){
		this.seq=seq;
	}
	public int getSeq(){
		return seq;
	}
	public void setTitle(String title){
		this.title=title;
	}
	public String getTitle(){
		return title;
	}
	public void setWriter(String writer){
		this.writer=writer;
	}
	public String getWriter(){
		return writer;
	}
	public void setContent(String content){
		this.content=content;
	}
	public String getContent(){
		return content;
	}
	public void setRegdate(String regdate){
		this.regdate=regdate;
	}
	public String getRegdate(){
		return regdate;
	}
	public String toString(){
		String AllList="";
		AllList+=String.format("글번호/제목/글쓴이/내용/날짜\n");
		AllList+=String.format("%d/%s/%s/%s/%s\n",seq,title,writer,content,regdate);
	return AllList;
	}
}
