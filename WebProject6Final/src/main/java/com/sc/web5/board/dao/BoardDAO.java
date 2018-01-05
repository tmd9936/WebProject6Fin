package com.sc.web5.board.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sc.web5.board.vo.Board;

@Repository
public class BoardDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAO.class);
	
	public int insertBoard(Board board){
		logger.info("보드 넣기 시작");
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		int result = 0;
		
		try {
			result = mapper.insertBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		logger.info("보드 넣기 종료");
		return result;
	}
	
	public ArrayList<Board> selectBoardAll(){
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		ArrayList<Board> list = null;
		
		try {
			list = mapper.selectBoardAll();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return list;
	}
	
	public Board selectBoard(int boardnum){
		logger.info("보드읽기 시작");
		
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		Board board = null;
		
		try {
			board = mapper.selectBoard(boardnum);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		logger.info("보드읽기 종료");
		return board;
	}
	
	public int updateHits(int boardnum){
		logger.info("조회수 증가 시작");
		
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		int result = 0;
		
		try {
			result = mapper.updateHits(boardnum);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		logger.info("조회수 증가 종료");
		return result;
	}
	
	public int deleteBoard(Board board){
		logger.info("삭제 dao 시작");
		
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		int result = 0;
		
		try {
			result = mapper.deleteBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		logger.info("삭제 dao 종료");
		return result;
	}
	
	public int updateBoard(Board board){
		logger.info("수정 dao 시작");
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		int result = 0;
		try {
			result = mapper.updateBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		logger.info("수정 dao 종료");
		return result;
	}
}















