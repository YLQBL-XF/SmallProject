package com.service;

import java.io.Serializable;
import java.util.List;

import com.httpModel.EasyuiTreeNode;
import com.httpModel.httpModeMenu;

public interface MyMenuServiceI extends Serializable {

	List<EasyuiTreeNode> findAll();

	List<EasyuiTreeNode> findById(String id);
	
	public List<httpModeMenu> treegrid(String id);
}
