package com.hanbit.board.controller;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import com.hanbit.board.domain.BoardBean;
import com.hanbit.board.service.BoardService;
import com.hanbit.board.serviceImpl.BoardServiceImpl;

public class BoardController {
	public static void main(String[] args) {
		BoardBean board=null;
		BoardService service=new BoardServiceImpl();
		BoardBean[] someBoards=null;
		int seq=0;
		while(true){
		switch(JOptionPane.showInputDialog("0.exit 1.create 2.readAll 3.update 4.delete 5.find")){
		case "0":
			return;
		case "1":
			board=new BoardBean();
			String[] arr=JOptionPane.showInputDialog("title/writer/content").split("/");
			seq++;
			board.setSeq(seq);
			board.setTitle(arr[0]);
			board.setWriter(arr[1]);
			board.setContent(arr[2]);
			GregorianCalendar gc=new GregorianCalendar();
			SimpleDateFormat format=new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
			String regdate=format.format(gc.getTime());
			board.setRegdate(regdate);
			service.writeBoard(board);
			break;
		case "2":
			JOptionPane.showMessageDialog(null, service.getAllList());
			break;
		case "3":
			board=new BoardBean();
			board.setSeq(Integer.parseInt(JOptionPane.showInputDialog("업데이트하고자 하는 글의 번호를 입력해주세요")));
			board.setContent(JOptionPane.showInputDialog("새로운 글 내용을 입력해주세요"));
			service.updateBoard(board);
			break;
		case "4":
			service.deleteBoard(Integer.parseInt(JOptionPane.showInputDialog("지우고자 하는 글의 번호를 입력해주세요")));
			break;
		case "5":
			board=new BoardBean();
			String input=JOptionPane.showInputDialog("1.글번호로 검색 2.글쓴이로 검색");
			if(input.equals("1")){
				board.setSeq(Integer.parseInt(JOptionPane.showInputDialog("찾으시는 글번호를 입력해주세요")));
				board.setWriter("");
			}else{
				board.setSeq(0);
				board.setWriter(JOptionPane.showInputDialog("찾으시는 글의 글쓴이를 입력해주세요"));
			}
			someBoards=service.find(board);
			String SomeList="";
			for(int i=0;i<someBoards.length;i++){
				SomeList+=someBoards[i].toString();
			}
			JOptionPane.showMessageDialog(null, SomeList);
			break;
		default :
			break;
			}
		}
	}
}
