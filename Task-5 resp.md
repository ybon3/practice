Task Feedback
=============

> 試圖回答 UiBinder 的底層運作原理


看起來背後的運作是先將 ui.xml 轉換成像是 Task-4.java 的內容後再進行後續動作。
作法上類似 JSP -> Servlet，目的應該是讓 layout 的部分用比較好閱讀的方式呈現，對於維護上也比較容易理解，
相比 Task-4，顯然透過 ui.xml 的呈現方式對於 layout 的結構更加清晰，另一方面也將程式邏輯跟畫面分離。

在這次 Task 中對於 `Task5.ui.xml` 與 `Task5.java` 的理解有：
- Tag 與 API Doc 中的 `class` 對應，例如 `<c:VerticalLayoutContainer>` 對應 `com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer`
	所以我們如果要使用其他 UI Component 可以用同樣的方式來撰寫。
- Tag 的 attribute 對應該 `class` 的 setter，例如 `<b:TextButton text="xxx">` 可以在 `TextButton` 的 `class` 中找到 `setText(String text)` 方法。


疑問：
- `Task5.java` 中設定 Click 事件的方式

	```java
	@UiHandler({"btnQuestion"})
	public void onButtonClick(SelectEvent event) {
		...
	}
	```

	
	我嘗試用用下面的 code 取代
	
	```java
	@UiField TextButton btnQuestion;
	btnQuestion.addSelectHandler(new SelectEvent.SelectHandler(){
		@Override
		public void onSelect(SelectEvent event) {
			...
		}
	});
	```
	
	
	取代後的效果看似一樣，但可能是歪打正著。
	
	由於我無法從 Annotation 的寫法找出跟 API 文件中的 addXXXHandler 對應的機制，所以我的疑問是：這個機制是如何運作的？
