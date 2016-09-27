> # Task-5 #
> * 項目：UiBinder
> * 完成條件：pull request accept


技能介紹
========

UiBinder 是 GWT 當中設計 layout 的方式之一。
教學文件參見[官網介紹][GWT Project]（只需要看 1～7 節），
並搭配 [GXT Example] 學習 `<ui:with>` 的用法
（官網沒有直接介紹，跟著 style 手法一起講讓人混亂 ＝＝"）。

[GWT Project]: http://www.gwtproject.org/doc/latest/DevGuideUiBinder.html
[GXT Example]: http://examples.sencha.com/gxt/4.0.0/#ExamplePlace:horizontallayout(uibinder)


作業需求
========

用 UiBinder 寫出一個名為 `Task5` 的 component，
使下面這個 entry point 可以作到這個網頁的效果：http://montypan.github.io/GYT/task2.html

```Java
	@Override
	public void onModuleLoad() {
		Viewport vp = new Viewport();
		vp.add(new Task5());
		RootPanel.get().add(vp);
	}
```

另外，當「問號」的 button 按下去時，用 `Window.alert()` 跳出一個 browser 的 alert 視窗（內容隨意）。

注意：

1. component 只能使用 `VerticalLayoutContainer`、`HorizontalLayoutContainer`、`TextButton`
1. layout 必須全部都在 `Task5.ui.xml` 當中定義，程式都得寫在 `Task5.java` 中
	* package 一樣，看你方便即可
1. Eclipse（with GPE）可以幫你產生 UiBinder，不過要注意，
	`Task3` extend 的 class 必須改成 `com.sencha.gxt.widget.core.client.Composite`


Task Feedback
==============

Github 操作的部份跟 Task-4 一樣（只是 branch 從 `task-4` 變成 `task-5`），這裡不再贅述。

此次 task 包含了兩個部份，分別是：

* 程式部份
	* 將程式碼放在根目錄下，檔案名稱為 `Task5.java`、`Task5.ui.xml`
* 文件部份
	* 以實作 Task-5 的過程經驗（這表示：即使你找得到，也請不要用 UiBinder 的 source code 來回答）
		試圖回答 UiBinder 的底層運作原理
	* 如果不懂要回答什麼，那也可以用「對 UiBinder 的疑惑」來代替（無論有沒有回答，你都可以問）
	* 將檔案放在個人目錄下，檔案名稱為 `Task5.md`

程式寫完先發 pull request，讓我可以先 review，然後文件再陸續補上，這樣比較節省時間。