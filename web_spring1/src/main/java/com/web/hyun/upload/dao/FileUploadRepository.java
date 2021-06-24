package com.web.hyun.upload.dao;

import java.util.HashMap;

public interface FileUploadRepository {
	public int insert(int id, HashMap<String, String> data) throws Exception;
}
