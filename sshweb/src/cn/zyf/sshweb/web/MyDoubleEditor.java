package cn.zyf.sshweb.web;

import java.beans.PropertyEditorSupport;

public class MyDoubleEditor extends PropertyEditorSupport{

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		//
		if(text==null||text.equals("")) {
			text="0";
		}
		Double dd = Double.parseDouble(text)+100;
		setValue(dd);
	}
	
}
