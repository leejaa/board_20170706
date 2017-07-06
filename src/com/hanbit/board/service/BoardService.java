package com.hanbit.board.service;

import com.hanbit.board.domain.BoardBean;

public interface BoardService {
	public void writeBoard(BoardBean board);
	public BoardBean[] readBoard(BoardBean board);
	public void updateBoard(BoardBean board);
	public void deleteBoard(int seq);
	public BoardBean getOneBoard(int seq);
	public String getAllList();
	public BoardBean[] find(BoardBean board);
}
