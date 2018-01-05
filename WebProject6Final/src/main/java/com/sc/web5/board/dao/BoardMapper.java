package com.sc.web5.board.dao;

import java.util.ArrayList;

import com.sc.web5.board.vo.Board;

public interface BoardMapper {
	//보드 작성 <insert id="insertBoard" parameterType="board">
	public int insertBoard(Board board);
	
	//<select id="selectBoardAll" resultType="board">
	public ArrayList<Board> selectBoardAll();
	
	//하나 가져오기 <select id="selectBoard" resultType="board">
	public Board selectBoard(int boardnum);
	
	//조회수 증가 <update id="updateHits">
	public int updateHits(int boardnum);
	
	//<delete id="deleteBoard"> 삭제
	public int deleteBoard(Board board);
	
	//<update id="updateBoard" parameterType="board"> 보드 수정
	public int updateBoard(Board board);
}
