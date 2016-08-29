Task Feedback
=============

> [GwtSample] 當中每個檔案（`pom.xml` 除外）的意義、以及與其他檔案的關聯性。


- src\main\java\com\dtc\test\Test.gwt.xml

	與 GWT 相關的 config file，`<module>` 的 `rename-to` 屬性與 GWT 的 output 路徑相對應。

- src\main\java\com\dtc\test\client\TestEP.java

	是一個 GWT Module，與 `test.gwt.xml` 中的 `entry-point` 對應，裡面包含頁面 layout 設定，以及 ui 元件的行為。
	`start()` method 示範了非同步的 RPC，在 RPC 回應之前以 print log per second 的方式來表達程序還在等待。

- src\main\java\com\dtc\test\client\RpcService.java

	遠端程序呼叫的 API，提供給 `TestEP.java` 遠端呼叫，annotation 定義了該 RPC 的 URI，與 start() 產生出來的 client side code 對應。

- src\main\java\com\dtc\test\server\RpcServiceImpl.java

	實作 `RpcService.java`，實現 RPC 時的 server 端行為。

- src\main\java\com\dtc\test\shared\exception\TestException.java

	`com.dtc.test` 自定義的 Exception。

- src\main\webapp\index.html

	網站首頁，透過 `src="test/test.nocache.js"` 引入 `entry-point`（`TestEP.java`）來呈現畫面以及畫面元件的功能。
	引入的 js 的 uri 與 `Test.gwt.xml` 中的 `rename-to` 有對應關係。

- src\main\webapp\WEB-INF\web.xml

	j2ee 標準的 config file，裡面定義了 RPC 的 URI，由 Test.gwt.xml 的 `rename-to` 以及 RpcService 的 annotation 組合而成。

- 各檔案間的關聯性

                Test.gwt.xml -- define --> TestEP.java
                                                |
                                               call
                                                |
                        RpcService.before() <---+
                                    ^
                                    |
                                implement
                                    |
                                    |
        web.xml -- define --> RpcServiceImpl -- throw --> TestException


> Task-2 的步驟有哪些是不必要的？或是有更好的作法？


1. 只要將 `test\test.nocache.js` 複製到 `GwtSample\src\main\webapp\test` 下就好，其他檔案不用複製。
1. 如果只是為了要跑 `GwtSample`，GPE 的安裝是不需要的。


困惑、問題及心得
================

1. GPE 目前似乎只支援到 Java 1.7，使用 JDK 8 還必須對 IDE 進行「Compiler compliance level」的調整，Why JDK 8？


	[App Engine does not yet support Java 8] [GPfE]


1. 能否一併提供建議的 Eclipse 版本？
1. 「Eclipse / GPE」的步驟 4 中，查詢結果中找不到 Google Plugin for Eclipse（還一直出現 Error）。建議使用 Menu Bar→Help→Install New Software 的安裝方式。
 

	[Google Plugin for Eclipse 4.6 (Neon) Installation Instructions] [Installation]


1. 「Maven」的步驟 2 的 `check point：c:\maven\bin\mvn.bat` 不存在（但有 `mvn.cmd`），
	我安裝的版本為 Apache Maven 3.3.9。
1. 「啟動 web server」的教學中，推測應該是 Maven 比較簡單，而非兩種方式都「比較簡單」。
1. 除了 `Ctrl-C` 之外還有別的方法停止 codeserver 嗎？
	因為發生不小心將 command-line 關閉卻無法停止 codeserver 運作的問題。
1. 經由這個 Task 我對 GWT 的運作方式有了初步認識，目前覺得最特別的是 codeserver 的存在。
	GWT 的 client 程式變動需透過書籤的方式呼叫 codeserver 來進行 compile，
	修改的結果才會正確地顯示在前端頁面，這代表了在 GWT compile 過的前端資源都放在 codeserver，
	不過對於實際的運作方式還是一知半解。
1. 在同一個瀏覽器的同一個分頁中，點擊「送出」鍵時所呼叫的 `start()` 是使用共同的 `rpcFinish` 與 `counter` 類別屬性。
	由於共用的原因，當連續點擊兩次「送出」時可以透過觀察 log 察覺不正確的現象。
	對於兩次呼叫 `start()` 的程序來說應該要獨立使用各別的 `rpcFinish` 與 `counter` 類別屬性。
	解決這個現象的辦法（讓 `start()` 獨立使用這兩個屬性）： 
	1. 在 `new RepeatingCommand()` 中定義 `counter`。
	1. 定義一個實作 `AsyncCallback` 的類別，並定義 `rpcFinish` 屬性以及其 `getter()`，在 `start()` 中使用變數儲存該類別的 instatnce，供 `RepeatingCommand()` 中調用。
	
	```java
	class MyAsyncCallback implements AsyncCallback<Boolean> {
		private boolean rpcFinish = false;
		public boolean getRpcFinish(){return rpcFinish;}
		...
	}
	
	...
	
	private void start() {
		final MyAsyncCallback async = new MyAsyncCallback();
		rpc.before(dateField.getValue(), async); 
		
		Scheduler.get().scheduleFixedPeriod(new RepeatingCommand() {
			int counter = 0;
			
			@Override
			public boolean execute() {
				counter++;
				GWT.log("第 " + counter + " 次 @ " + format.format(new Date()));
				return !async.getRpcFinish();
			}
		}, 1000);
	}
	```
	
	
	以下是推測，對於同一個瀏覽器分頁來說，`TestEP` 並非 Thread-safe；或者說 `TestEP` 的成員屬性為該頁面中的 javascript globle variables。
1. 如果修改 `Test.gwt.xml` 中的 `rename-to` 屬性，就必須跟著修改 `index.html` 中對應的 javascript uri，
	以及 `web.xml` 中對應的 `url-pattern`。然後必須重新執行 mvn install（For module changes）並重啟 codeserver，以及重啟 tomcat（For server side changes）。
1. codeserver 中，主要是以最後一次執行 mvn install 的產出作為基礎在提供 module，
	`Dev Mode On` 時則動態的去 compile 當下的版本，可以關閉 Dev Mode 來做比對
 

[GPfE]: https://developers.google.com/eclipse/docs/getting_started?hl=zh-TW
[Installation]: https://developers.google.com/eclipse/docs/install-eclipse-4.6?hl=zh-TW
