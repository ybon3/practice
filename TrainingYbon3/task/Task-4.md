> # Task-4 #
> * 項目：GXT Layout 機制
> * 完成條件：pull request accept


技能介紹
========

「container」是 UI 元件的一種，它的功能並不是直接顯示在畫面上，
而多半是處理 layout issue，也就是說它所承載的 UI 元件會以什麼**大小**、**位置**呈現在畫面上。

如果 container A 承載了元件 B 跟元件 C，
我們會（比照 DOM）說 A 是 B 跟 C 的爸爸 / parent，
B 跟 C 是 A 的小孩，
B 是 C 的兄弟姊妹。

在這個 task 當中，你會（也只能）用到下面幾個 GXT 提供的 container。

`Viewport` 繼承 `SimpleContainer`，所以具備 `SimpleContainer` 的能力：讓自己唯一的小孩跟自己一樣大；
另外，Viewport 還會讓自己的大小跟 browser 的大小一樣大。
也就是說，`Viewport` 會讓自己唯一的小孩跟 browser 的大小一樣大。

`HorizontalLayoutContainer` 會讓小孩們依序以水平的方式排列。
它控制小孩大小的方式，通常是用 `add(IsWidget, HorizontalLayoutData)`、
透過第二個參數傳入一個 `HorizontalLayoutData` instance 來指定，通稱 layoutData。
`width` / `height` 依值域有不同的意義，分別是：

* x > 1：給多大小孩就是多大
* 0 > x >= 1：如果爸爸**剩下** 300，小孩就是 `300 * x`
* x = -1：小孩子自己原本的大小（使用注意！）
* x < -1：如果爸爸**剩下** 300，小孩就是 `300 + x`

所謂「剩下」，是指如果小孩當中有人有明確指定大小（無論是 x > 1 還是 x = -1 的情況），
那麼會先扣掉，才開始進行計算。

`VerticalLayoutContainer` 會讓小孩們依序以垂直的方式排列。
控制小孩大小的方式與 `HorizontalLayoutContainer` 相同，只是 layoutData 的 class 為 `VerticalLayoutData`。

如果還需要進一步資訊（這個 task 是不需要的），可以參閱這個網頁
http://docs.sencha.com/gxt/ui/layout/LayoutContainers.html

另外還需要 `TextButton`，顧名思義，他是個 button。

所以，如果我希望畫面上出現兩個 `TextButton` 水平排列，
一個寬恆定 100、高恆定為 browser 的一半、
一個寬恆定為 borwser 的四分之一，高恆定為 50，則程式會長得像這樣

```Java
@Override
public void onModuleLoad() {
	HorizontalLayoutContainer hlc = new HorizontalLayoutContainer();
	hlc.add(new TextButton("1"), new HorizontalLayoutData(100, 0.5));
	hlc.add(new TextButton("2"), new HorizontalLayoutData(0.25, 50));
	
	Viewport vp = new Viewport();
	vp.add(hlc);
	
	RootPanel.get().add(vp);
}
```


作業需求
========

寫出這個網頁的效果：http://montypan.github.io/GYT/task2.html

注意：

1. 只能使用上述提到的 class
1. 所有程式都得寫在名為 `Task4` 的 entry point 當中。
	1. 如果你要產生 class，請委屈一點點用 inner class 或是 package level 的 class
	1. 至於 package 則無所謂，你方便即可。
1. 改變 browser 的大小也能正常（尤其是滿版 / 比例的部份）顯示


Task Feedback
==============

1. 建立一個 branch，名稱為 `task-4`，並切換到這個 branch
1. 將程式碼放在根目錄下，檔案名稱為 `Task4.java`
1. 發 pull request 給 `MontyPan` 的 `master`
