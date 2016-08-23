> # Task-2 #
> * 項目：GWT 開發環境與 Hello World
> * 完成條件：pull request accept


開發環境
========

* JDK 8
* Maven 3.3+
* Eclipse (強烈建議)
	* Google Plugin for Eclipse（GPE）
* Chrome (建議)
* Tomcat / Jetty (option)

此文件是以 Windows 為 OS，其他作業系統請自行對應。


環境建置
========

以下請自行解決

* JDK 安裝
* Eclipse 安裝


Maven
-----

1. 下載 [Maven](https://maven.apache.org/)，V3.3+ 均可
1. 解壓縮之後的目錄，假設存放位置為 `c:\maven`
	* check point：`c:\maven\bin\mvn.bat` 存在
1. 設定 Windows 系統環境變數中的系統變數 `Path`，最末端加上

		;c:\maven\bin;
		
	或是（每次）在 cmd 下指令
	
		set path=%path%;c:\maven\bin;
		
1. 開啟 cmd，輸入 `mvn -version`
	* check point：出現 Maven、JDK 版本資訊
	

Eclipse / GPE
-------------

1. Eclipse ready
1. Menu Bar→Help→Eclipse Marketplace
1. 在 `Find` 輸入 `google` 按下 enter
1. 尋找對應 Eclipse 版本的 `Google Plugin for Eclipse`，按下 `Install`
	* 在「Confirm Selected Features」頁面可將下列取消勾選（加快速度）
		* Google App Engine*


開發流程
========

**注意**：下列操作會使用到 8080、9876 port，請避開或著自己找修改使用 port 號的方式。


一次性的準備工作
----------------

1. git clone 一份 [GwtSample] 到 local repo，
	假設路徑為 `c:\repo\GwtSample`
1. 在 Eclipse 中
	1. File→Import
	1. Maven→Existing Maven Projects
	1. Root Directory 輸入 `c:\repo\GwtSample`
1. 開啟 cmd，切到 `c:\repo\GwtSample` 下，執行

		mvn install

1. 啟動 GWT code server：
	開啟 cmd，切到 `c:\repo\GwtSample` 下，執行

		mvn gwt:run-codeserver
		
	直到畫面停在
	
		The code server is ready at http://localhost:9876/
		
1. 開啟 browser，瀏覽 http://localhost:9876
1. 將「Dev Mode On」drag 到 browser 的 bookmark 區


啟動 web server
---------------

有兩種方式，Maven 比較簡單，但如果需要持續改 server-side code 就會需要一直切掉重起很麻煩。
Eclipse 比較簡單、code 有變動會自動 reload，但前面設定步驟比較繁瑣、也比較耗 resource。


### Maven 啟動 Tomcat 7 ###

開啟 cmd，切到 `c:\repo\GwtSample` 下，執行

	mvn war:exploded tomcat7:run
	

### Server in Eclipse ###

1. (一次性動作) 將 `c:\repo\GwtSample\target\GwtTest-0.0.1-SNAPSHOT\test` 這個目錄，
	複製到 `c:\repo\GwtSample\src\main\webapp` 下
1. 新增 Server、加入 GwtSample、啟動 server（細節略）


啟動 GWT 	
--------

1. 啟動 web server		
1. 啟動 GWT code server：

		mvn gwt:run-codeserver

1. 開啟 browser，輸入網址 http://localhost:8080/

每次變更 client side 的 code（以目前的 case，就是 `com.dtc.test.client` 這個 package 以下的 class），
需要按下剛剛建立在 bookmark 區的「Dev Mode On」→「Compile」


Task Feedback
==============

請試圖回答下列問題：

* [GwtSample] 當中每個檔案（`pom.xml` 除外）的意義、以及與其他檔案的關聯性。
	* 請以「檔案」為描述單位，而不是「解釋每一行程式碼」的方式來回答。
* Task-2 的步驟有哪些是不必要的？或是有更好的作法？

也可附上你的困惑、問題或心得。

1. 建立一個 branch，名稱為 `task-2`，並切換到這個 branch
1. 將 feedback 寫在個人目錄下的 `Task-2.md`
1. 發 pull request 給 `MontyPan/Traning` 的 `master`


[GwtSample]: https://github.com/DatacomRD/GwtSample