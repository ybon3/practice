package com.dtc.test.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.Composite;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;

public class Task5 extends Composite {
	interface MyUiBinder extends UiBinder<Widget, Task5> {}
	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);
	
	@UiField TextButton btnQuestion;
	
	@UiHandler({"btnQuestion"})
	public void onButtonClick(SelectEvent event) {
		Window.alert(btnQuestion.getText() + " clicked");
	}
	
	public Task5() {
		initWidget(uiBinder.createAndBindUi(this));
	}
}
