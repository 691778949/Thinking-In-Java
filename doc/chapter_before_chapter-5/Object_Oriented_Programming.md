# 第一章    对象导论

### 1.1抽象过程

​	面向对象的思想让我们将问题空间中的元素及其在解空间中的表示成为 “ 对象 ” 。（还有一些无法类比为问题空间元素的对象）。

​	这种思想的实质是：程序可以通过添加新类型的对象使自身适用于某个特定问题。

​	OOP允许根据问题来描述问题，而不是根据运行解决方案的计算机来描述问题。

	####  Java语言的五个基本特性： （对象具有状态、行为和标识）

##### 	1） 万物皆为对象。

#####   	2）程序是对象的集合，它们通过发送消息来告知彼此所要做的。

	#####  	3）每个对象都有自己的由其他对象所构成的存储。

#####  	4)每个对象都拥有其类型。

#####  	5)某一特定类型的所有对象都可以接收同样的消息

###  1.3 每个对象都提供服务

​	当正在试图开发或理解一个程序设计时，最好的方法之一就是将对象想象为 “服务提供者”。

​	程序本身将向用户提供服务，它将通过调用其他对象提供的服务来实现这一目的。

​	我们的目标就是去创建（或是最好是在现有代码库中寻找）能够提供理想的服务来解决问题的一系列对象。

	#####  	构造对象的三个问题 

​		1）它们看起来像什么样子？

​		2）它们能提供哪些服务？

​		3）它们需要哪些对象才能履行它们的义务？

​	在良好的面向对象设计中，每个对象都可以很好地完成**一项任务**，但是它并不试图做**更多的事**

###  1.4 被隐藏的具体实现

	####  	Java用三个关键字在类的内部设定边界：

	##### 	1）public：表示紧随其后的元素对任何人都是可用的

	#####  	2）private：表示除类型创建者和类型的内部方法之外的任何人都不能访问的元素

​	（private 就像你与客户端程序员之间的一堵砖墙，如果有人试图访问private成员，就会在编译					           	时得到错误信息。）

##### 		3）protected：与private作用相当，差别仅在与继承的类可以访问protected成员，但是不能访问private成员。

	#####  	4）包访问权限：类可以访问在同一个包（库构件）中其他类的成员，但是在包之外，这些成员如同指定了 private一样。

 













