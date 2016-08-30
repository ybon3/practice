- 為什麼會有這些差異？為什麼要在意這些差異？
- 試解釋這些差異的來源或原因

**GWT 的核心元件是一個 Compiler，用來將 Java source 編譯成 JavaScript。**

即使 GWT 讓我們擁有透過 Java 開發所帶來的眾多好處，但事實上編譯這些 Java code 的並不是 Java 的 compiler 而是 GWT Compiler。
然後，由 GWT 編譯後產出的 JavaScript code 會再經過瀏覽器的 interpreter 才會產出我們看到的最終結果。

知道這些差異的好處：
1. 在開發過程中盡早避開那些問題，例如：使用了不支援的類別。
1. 避免產出效能低落的程式碼，例如：頻繁地使用 `long` 型態。
1. 可以事前避免程式產出不如預期的結果，例如：Regular Expressions 的語法
1. 在遭遇未知的錯誤時，能夠正確地思考到底是如何造成問題。

文件中提及有關 development mode 與 production mode 的差異，似乎是指舊版的 Development Mode，目前所使用的是 Super Dev Mode，


所以在 Java IDE 下即使沒有顯示任何錯誤，但仍有可能在編譯時發生錯誤。甚至是執行期（JavaScript in Browser）




事實上我們是利用了 Java 既有的規則來模擬 JavaScript 的開發



GWT 最終是輸出 JavaScript，



1. 避免一些我們以為正確，但卻是發生問題所在之處的情況發生，畢竟解決問題最好的方式就是從一開始就不讓它發生。

2. 講求效能，避免那些會讓程式運作效率降低的寫法。（similar functionality、long type）





- 試解釋這些差異的來源或原因


- （進階題）GWT 如何決定 JRE Emulation 的範圍與內容？


問題：

1. 目前仍不明白為什麼要安裝 GPE，或者說如何將我 import 進去的 project 轉換成 GWT project
