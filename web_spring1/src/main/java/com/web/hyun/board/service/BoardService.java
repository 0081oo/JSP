package com.web.hyun.board.service;

import java.util.*;

import com.web.hyun.board.dto.BoardDTO;
import com.web.hyun.board.dto.BoardSearchDTO;
import com.web.hyun.board.dto.BoardTypeDTO;

public interface BoardService {
	
	public boolean add(BoardDTO dto) throws Exception;
	public boolean update(BoardDTO dto) throws Exception;
	public boolean remove(BoardDTO dto) throws Exception;
	public List<BoardDTO> findAll() throws Exception;
	public BoardDTO findId(int id) throws Exception;
	public List<BoardDTO> findType(int btype) throws Exception;
	public List<BoardDTO> findTitle(String title) throws Exception;
	public List<BoardDTO> findAuthor(int aid) throws Exception;
	public List<BoardTypeDTO> getBoardTypes() throws Exception;
	public List<BoardDTO> findList(BoardSearchDTO search) throws Exception;
	public List<Map<String, String>> uploadfiles(int id) throws Exception;
}