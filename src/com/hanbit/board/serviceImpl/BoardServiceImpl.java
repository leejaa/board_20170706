package com.hanbit.board.serviceImpl;

import java.util.Arrays;

import com.hanbit.board.domain.BoardBean;
import com.hanbit.board.service.BoardService;

public class BoardServiceImpl implements BoardService{
	int count;
	BoardBean[] boards;
	BoardBean board;
	public BoardServiceImpl(){
		count=0;
		board=new BoardBean();
		boards=new BoardBean[count+1];
	}
	@Override
	public void writeBoard(BoardBean board) {
		boards[count]=board;
		count++;
		boards=Arrays.copyOf(boards, count+1);
	}
	@Override
	public BoardBean[] readBoard(BoardBean board) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBoard(BoardBean board) {
		this.board=getOneBoard(board.getSeq());
		this.board.setContent(board.getContent());
	}

	@Override
	public void deleteBoard(int seq) {
		for(int i=0;i<count;i++){
			if(seq==boards[i].getSeq()){
				boards[i]=boards[count-1];
				boards[count-1]=null;
				break;
			}
		}
		count--;
		boards=Arrays.copyOf(boards, count);
	}

	@Override
	public BoardBean getOneBoard(int seq) {
		board=new BoardBean();
		for(int i=0;i<count;i++){
			if(seq==boards[i].getSeq()){
				board=boards[i];
			}
		}
		return board;
	}

	@Override
	public String getAllList() {
		String AllList="";
			AllList+=String.format("글번호/제목/글쓴이/내용/날짜\n");
		for(int i=0;i<count;i++){
			AllList+=String.format("%d/%s/%s/%s/%s\n",boards[i].getSeq(),boards[i].getTitle(),boards[i].getWriter(),
					boards[i].getContent(),boards[i].getRegdate());
		}
		return AllList;
	}
	@Override
	public BoardBean[] find(BoardBean board) {
		int cnt=0;
		for(int i=0;i<count;i++){
			if(board.getSeq()==boards[i].getSeq()||board.getWriter().equals(boards[i].getWriter())){
				cnt++;
			}
		}
		
		BoardBean[] SomeBoards=new BoardBean[cnt];
		int j=0;
		for(int i=0;i<count;i++){
			if(board.getSeq()==boards[i].getSeq()||board.getWriter().equals(boards[i].getWriter())){
				SomeBoards[j]=boards[i];
				j++;
			}
			if(j==cnt){
				break;
			}
		}
		return SomeBoards;
	}
}
