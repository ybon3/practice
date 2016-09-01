Task Feedback
=============

> 為什麼會有這些差異？為什麼要在意這些差異？
> 試解釋這些差異的來源或原因


**GWT 的核心元件是一個 Compiler，用來將 Java source 編譯成 JavaScript。**

即使 GWT 讓我們擁有透過 Java 開發所帶來的眾多好處，但事實上編譯這些 Java code 的並不是 Java 的 compiler 而是 GWT Compiler，
然後由 GWT 編譯後產出的 JavaScript code 會再經過瀏覽器的 interpreter 才會產出我們看到的最終結果。

既不經過 Java Compiler，也不是運作在 JVM 上，這兩點原因帶來了許多差異。

而知道這些差異的好處包含：

1. 避免產出效能低落的程式碼，例如：頻繁地使用 `long` 型態。
	JavaScript 沒有 64-bit 的整數型態，GWT 1.5 開始，透過一對 integer 來實現 `long` 型態的範圍。
	可以想像的是，為了模擬 `long` 就必須在 runtime 對模擬用的 integer 在運算時頻繁地去判斷是否發生溢位來確保數值的正確性。
1. 可以事前避免程式產出不如預期的結果，例如：Regular Expressions 的語法。
	Runtime 走的是 JavaScript 的語法規則，顯然 GWT Compiler 沒有幫我們轉換的打算。
1. 在開發過程中盡早避開那些問題，例如：使用了不支援的類別。
	因為 IDE 還是當作你在開發 Java 程式（Refer rt.jar），但實際上 GWT compiler 用的是 JRE emulation library。
	另外，在沒有一一確認出哪些 J2SE class 被支援的情況之下，我們應盡可能頻繁地對程式進行測試來確保程式的可用性，以避免開發時間的浪費。
1. 對於使用 `JSNI` 能夠掌握更好的時機。
	JSNI 看起來是在開發時解決問題的好幫手，但在 GWT 原本就能解決的情況之下我們應避免使用。
1. 在遭遇未知的錯誤時，能夠正確地思考到底是如何造成問題。	

	
一些差異的補充：

1. 由於 Runtime 不是在 JVM 下運作，一些 Runtime Exception 由 JavaScriptException 取代。 
1. 由於 JavaScript interpreter 是 single-thread，所以我們不該在 GWT 中使用 multi-thread 的技巧。
 

絕大多數的差異（限制、不支援）其原因在於最終運作的環境是 JavaScript interpreter 而非 JVM，故受限於此。
其次，程式得依賴 GWT Compiler 把 code translate 到 JavaScript，也受限於 GWT Compiler 的智慧以及 JavaScript 的語言本身。

文件一開始就提及有關 development mode 與 production mode 的差異，但由於目前依照 Task-2 所接觸的是 Super Dev Mode 與舊版的 classic Dev Mode 不太一樣，礙於時間關係我沒有安裝舊版及了解太多。

在 [Super Dev Mode][superDev] 的說明文件中有提及與 classic Dev Mode 的差異，對於開發時應該多少都有幫助。


[superDev]: http://www.gwtproject.org/articles/superdevmode.html
