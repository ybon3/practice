> # Task-1 #
> * 項目：native JS coding skill
> * 完成條件：pull request accept

改寫 [Task-1.html]，使其變成一個拼圖遊戲。


遊戲規則
--------

1. 系統**隨機**抽掉 12 張圖的其中一張
1. 系統將剩下的 11 張圖**亂數**散佈在 4 * 3 的格子中，會留下一個空格
1. 使用者移動圖片的規則與華容道相同
	* 例如：使用者點選空格上方的圖片，該圖片就會移到原本的空格中。
1. 當所有圖片都移動到正確的位置，系統補上一開始抽掉的圖片。


coding 規則
-----------

1. 你可以隨意修改 [Task-2.html]（包括圖片），不過...
	* 圖片必須要用 Data URI scheme、也必須要能看得出是否拼完
1. 你不能使用任何外部的 resource
	* 這表示 CSS 跟 JS 都得跟 HTML 寫在一起... Orz
	* 這表示你不能使用**任何** JS library，包含 jQuery  [奸笑]
1. 系統必須在 Chrome（v45 以後）上正常執行
	* 也只要在 Chrome 上頭正常執行就好，IE 什麼的可以不用理會。~~（還不快謝主隆恩）~~


Bonus
-----
* 可以 cross browser（IE 8 以前就算了）
* 使用者自己上傳（並不是真的上傳）圖片
* 不違反上述規則的前提下，發揮你需求面的創意 or 技術面的能力 \囧/
* 指出這個 task 該要求卻沒要求的部份，甚至直接實作出來。


[Task-1.html]: Task-1.html


Task Feedback
==============

1. 建立一個 branch，名稱為 `task-1`，並切換到這個 branch
1. 把改完的 `Task-1.html` 儲存在根目錄下
1. 如果有什麼心得 / 問題 / feedback，也可以用註解 or HTML 的方式寫在 `Task-1.html` 當中
1. 發 pull request 給 `MontyPan/TraningYbon3` 的 `master`