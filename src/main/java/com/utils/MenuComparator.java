package com.utils;

import java.util.Comparator;

import org.apache.log4j.Logger;

import com.model.Mymenu;


/**
 * 菜单排序
 * 
 */
public class MenuComparator implements Comparator<Mymenu> {

	private static final Logger logger = Logger.getLogger(MenuComparator.class);

	public int compare(Mymenu o1, Mymenu o2) {
		int i1 = o1.getSeq() != null ? o1.getSeq().intValue() : -1;
		int i2 = o2.getSeq() != null ? o2.getSeq().intValue() : -1;
		logger.debug("i1[" + i1 + "]-i2[" + i2 + "]=" + (i1 - i2));
		return i1 - i2;
	}

}
