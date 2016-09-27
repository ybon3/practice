package com.dtc.test.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.Viewport;
import com.sencha.gxt.widget.core.client.form.DateField;

public class TaskEP implements EntryPoint {

	private DateField dateField = new DateField();
	private TextButton button = new TextButton("送出");
	
	@Override
	public void onModuleLoad() {

		Viewport vp = new Viewport();
        vp.add(new Task5());
        RootPanel.get().add(vp);
		
		/*
		HelloWidgetWorld helloWidgetWorld = new HelloWidgetWorld("123","456","789");
		RootPanel.get().add(helloWidgetWorld);
		*/
		/*
		final HelloWorld helloWorld = new HelloWorld();
		// Don't forget, this is DOM only; will not work with GWT widgets
		Document.get().getBody().appendChild(helloWorld.getElement());
		helloWorld.setName("World");
		
		//每隔 1 秒鐘寫一行 log 以顯示出 async 的行為
		Scheduler.get().scheduleFixedPeriod(new RepeatingCommand() {
			int counter = 0;
			
			@Override
			public boolean execute() {
				counter++;

				helloWorld.setName("World " + counter);
				return counter < 10;
			}
		}, 1000);	
		*/
		/*
		button.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				
			}
		});
		
		VerticalLayoutContainer vc = new VerticalLayoutContainer();
		vc.add(dateField);
		vc.add(button);

		RootPanel.get().add(vc);*/
	}
}
