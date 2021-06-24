package com.web.hyun.board.repository;

import java.util.*;

import com.web.hyun.board.dto.BoardDTO;
import com.web.hyun.board.dto.BoardSearchDTO;
import com.web.hyun.board.dto.BoardTypeDTO;

/**
 * 
 */
public interface BoardRepository {
	public BoardDTO select(BoardDTO dto) throws Exception;
	public List<BoardDTO> selectAll() throws Exception;
	public void selectType(int btype) throws Exception;
	public void selectAuthor(int aid) throws Exception;
	public void selectTitle(String title)  throws Exception;
	public List<BoardDTO> selectList(BoardDTO dto)  throws Exception;
	public List<BoardDTO> selectList(BoardSearchDTO search)  throws Exception;
	public boolean insert(BoardDTO dto)  throws Exception;
	public boolean update(BoardDTO dto)  throws Exception;
	public boolean delete(BoardDTO dto)  throws Exception;
	public List<BoardTypeDTO> selectBoardTypes() throws Exception;
	public List<Map<String, String>> uploadfiles(int id) throws Exception;
}