package com.inter.controller;

import com.inter.common.MakeBugger;
import com.inter.model.vo.BuggerDao;
import com.inter.model.vo.NewBuggerMake;

public class BuggerController {
	// private BuggerDao dao = new BuggerDao;
	
	// �������̽�
	private MakeBugger dao;
	
	
	public BuggerController() {
		dao = new BuggerDao();
		dao = new NewBuggerMake();
	}
	
	public void makeBugger() {
		dao.makeBugger();
	}
	

}
