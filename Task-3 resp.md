Task Feedback
=============

> 為什麼會有這些差異？為什麼要在意這些差異？
> 試解釋這些差異的來源或原因


**GWT 的核心元件是一個 Compiler，用來將 Java source 編譯成 JavaScript。**

即使 GWT 讓我們擁有透過 Java 開發所帶來的眾多好處，但事實上編譯這些 Java code 的並不是 Java 的 compiler 而是 GWT Compiler，
然後由 GWT 編譯後產出的 JavaScript code 會再經過瀏覽器的 interpreter 才會產出我們看到的最終結果。

既不經過 Java Compiler，也不是運作在 JVM 上，這兩點原因帶來了許多差異。

而知道這些差異的好處包含：

1. 在開發過程中盡早避開那些問題，例如：使用了不支援的類別。
1. 避免產出效能低落的程式碼，例如：頻繁地使用 `long` 型態。
1. 可以事前避免程式產出不如預期的結果，例如：Regular Expressions 的語法。
1. 在遭遇未知的錯誤時，能夠正確地思考到底是如何造成問題。


目前依照 Task-2 所接觸並使用的是 Super Dev Mode，文件中提及有關 development mode 與 production mode 的差異，
似乎是指舊版的 classic Dev Mode，礙於時間關係我沒有安裝舊版及了解太多。

在 [Super Dev Mode][superDev] 的說明文件中有提及與 classic Dev Mode 的差異，對於開發時應該多少都有幫助。


[superDev]: http://www.gwtproject.org/articles/superdevmode.html



1. 避免一些我們以為正確，但卻是發生問題所在之處的情況發生，畢竟解決問題最好的方式就是從一開始就不讓它發生。

2. 講求效能，避免那些會讓程式運作效率降低的寫法。（similar functionality、long type）

- 試解釋這些差異的來源或原因
- （進階題）GWT 如何決定 JRE Emulation 的範圍與內容？