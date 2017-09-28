package com.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.MymenuMapper;
import com.httpModel.EasyuiTreeNode;
import com.httpModel.httpModeMenu;
import com.model.Mymenu;
import com.service.MyMenuServiceI;
import com.utils.MenuComparator;

@SuppressWarnings("serial")
@Service("mymenuImpl")
public class MymenuImpl implements MyMenuServiceI {

	Log logger = LogFactory.getLog(UserServiceImpl.class);
	
    private MymenuMapper menumapper;
	
	public MymenuMapper getMenumapper() {
		return menumapper;
	}

	@Autowired
	public void setMenumapper(MymenuMapper menumapper) {
		this.menumapper = menumapper;
	}

	@Cacheable(value = "syproMenuCache", key = "'tree'+#id")
	@Transactional(readOnly = true)
	@Override
	public List<EasyuiTreeNode> findAll() {
		// TODO Auto-generated method stub
		List<Mymenu> allMenu = menumapper.selectAllMenu();
		
		List<EasyuiTreeNode> tree = new ArrayList<EasyuiTreeNode>();
		for (Mymenu symenu : allMenu) {
			tree.add(tree(symenu, false));
		}
		return tree;
	}

	
	private EasyuiTreeNode tree(Mymenu symenu, boolean recursive) {
		EasyuiTreeNode node = new EasyuiTreeNode();
		node.setId(symenu.getId());
		node.setText(symenu.getText());
		node.setIconCls(symenu.getIconcls());
		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("src", symenu.getSrc());
		node.setAttributes(attributes);
		if (symenu.getMymenus() != null && symenu.getMymenus().size() > 0) {
			node.setState("closed");
			if (recursive) {// 递归查询子节点
				List<Mymenu> symenuList = new ArrayList<Mymenu>(symenu.getMymenus());
				Collections.sort(symenuList, new MenuComparator());// 排序
				List<EasyuiTreeNode> children = new ArrayList<EasyuiTreeNode>();
				for (Mymenu m : symenuList) {
					EasyuiTreeNode t = tree(m, true);
					children.add(t);
				}
				node.setChildren(children);
			}
		}
		return node;
	}
	
	@Override
	public List<EasyuiTreeNode> findById(String id) {
		// TODO Auto-generated method stub
//		return  
		Mymenu selectByPrimaryKey = menumapper.selectById(id);
		List<EasyuiTreeNode> tree = new ArrayList<EasyuiTreeNode>();
		tree.add(tree(selectByPrimaryKey, false));
		return tree;
	}

	@Override
	public List<httpModeMenu> treegrid(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
