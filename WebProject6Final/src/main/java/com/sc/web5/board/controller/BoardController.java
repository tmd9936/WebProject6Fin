package com.sc.web5.board.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sc.web5.board.dao.BoardDAO;
import com.sc.web5.board.vo.Board;


@Controller
@RequestMapping("board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardDAO dao;
	
	@RequestMapping(value="list",method=RequestMethod.GET)
	public String list(Model model){
		logger.info("글 목록 시작.");
		// TODO DB에서 목록을 가져와서 화면에 전달
		ArrayList<Board> list = dao.selectBoardAll();
		model.addAttribute("count", list.size());
		model.addAttribute("list", list);
		
		logger.info("글 목록 종료.");
		return "board/list";
	}
	
	@RequestMapping(value="writeForm", method=RequestMethod.GET)
	public String writeForm(){
		logger.info("글쓰기 폼 시작");
		
		
		logger.info("글쓰기 폼 종료");
		return "board/writeForm";
	}
	
	@RequestMapping(value="write", method=RequestMethod.POST)
	public String write(Board board){
		logger.info("글쓰기 시작");
		System.out.println(board);
		System.out.println(dao.insertBoard(board));
		
		logger.info("글쓰기 종료");
		return "redirect:list";
	}
	
	@RequestMapping(value="read", method=RequestMethod.GET)
	public String read(Model model, @ModelAttribute("boardnum") int boardnum){
		logger.info("보드 읽기 폼 시작");
		Board board = dao.selectBoard(boardnum);
		System.out.println("조회수 "+dao.updateHits(boardnum));
		model.addAttribute("board", board);
		
		
		logger.info("보드 읽기 폼 종료");
		return "board/readForm";
	}
	
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public String delete(int boardnum, HttpSession session){
		logger.info("삭제 함수 시작");
		String id = (String)session.getAttribute("id");
//		System.out.println(id);
//		System.out.println(boardnum);
		
		Board board = new Board();
		board.setBoardnum(boardnum);
		board.setId(id);
		System.out.println(dao.deleteBoard(board));
		
		logger.info("삭제 함수 종료");
		return "redirect:list";
		
	}
	
	@RequestMapping(value="updateForm",method=RequestMethod.GET)
	public String updateForm(int boardnum,Model model){
		logger.info("수정 폼 가기 시작");
		Board board = dao.selectBoard(boardnum);
		model.addAttribute("board", board);
		
		logger.info("수정 폼 가기 종료");
		return "board/updateForm";
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String update(Board board, Model model){
		logger.info("수정 시작");
		System.out.println(dao.updateBoard(board));
		
		model.addAttribute("boardnum",board.getBoardnum());
		logger.info("수정 종료");
		return "redirect:read";
	}
	
}
















