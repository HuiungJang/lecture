package com.inter.model.vo;

import com.inter.common.MakeBugger;

public class BuggerDao implements MakeBugger{
	private Bugger[] buggers = new Bugger[5];
	
	public void buggerMaking() {
		
	}

	@Override
	public void makeBugger() {
		buggerMaking();
	}
	
	@Override
	public void infoBugger() {
		
	}
}
