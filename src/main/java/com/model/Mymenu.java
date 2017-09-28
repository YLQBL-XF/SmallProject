package com.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Mymenu {
    private String id;

    private String text;

    private String pid;

    private String iconcls;

    private String src;

    private BigDecimal seq;

    public String getId() {
        return id;
    }
	
	private Mymenu mymenu;
    
    private Set mymenus = new HashSet(0);

    public Mymenu() {
	}

	public Mymenu(String id, String text, BigDecimal seq) {
		this.id = id;
		this.text = text;
		this.seq = seq;
	}
	
    public Mymenu(String id, String text, String pid, String iconcls, String src, BigDecimal seq, Mymenu mymenu,
			Set mymenus) {
		super();
		this.id = id;
		this.text = text;
		this.pid = pid;
		this.iconcls = iconcls;
		this.src = src;
		this.seq = seq;
		this.mymenu = mymenu;
		this.mymenus = mymenus;
	}

	public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getIconcls() {
        return iconcls;
    }

    public void setIconcls(String iconcls) {
        this.iconcls = iconcls == null ? null : iconcls.trim();
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src == null ? null : src.trim();
    }

    public BigDecimal getSeq() {
        return seq;
    }

    public void setSeq(BigDecimal seq) {
        this.seq = seq;
    }

	public Mymenu getMymenu() {
		return mymenu;
	}

	public void setMymenu(Mymenu mymenu) {
		this.mymenu = mymenu;
	}

	public Set getMymenus() {
		return mymenus;
	}

	public void setMymenus(Set mymenus) {
		this.mymenus = mymenus;
	}
}