# HK6走势分析
[APK](http://fir.im/eu9g)
## 前言
    关于研发这个应用程序，初衷是应人之托，写一个直接干净简洁的框架。
    15年就持续关注Android-CleanArchitecutre以及最早的mvp概念，
    如今成了主流，Google官方也出了干净简洁框架的demo。
    ps.建议大家每个框架尝试看一遍

[Android-CleanArchitecture](https://github.com/android10/Android-CleanArchitecture)
##why to use HK6‘s data?
	14年的时候,看了几本双色球的书，利用的书中的公式写了一个排号杀号的java程序,然并卵，500万无缘；
	对书中影响最深的就是博彩公式N=log(1-DC)/log(1-P)
	N为间隔期数,DC为发生可能性 ，P为理论中奖概率
	很意外就做上了hk6的数据处理分析，可能身边有人买这个吧。


##功能说明
	1.展示90年到现在的数据。
	2.对每个永久属性的90%95%96％97%98%99%99.9%的阈值情况分析以及预警提示。
	3.对每个永久属性归类元素做历史阈值统计，以及阈值后出码的图表展示。
	4.对每个永久属性归类元素连续出现期数统计，以及图表分析。

###感悟
	任何一个“市场”都有一套系统性的知识。
	博彩也好，期货也好，现货也罢，高风险高利润行业，都是要反人性的。
	如果遇见此时的你，打算买博彩，建议业余玩玩而已，千万别重仓；
	如果你会处理仓位控制，它将会是一个业余稳定收入。
	这是我在现货市场亏损换来的感悟！
	希望遇见的你也是在摸索不同的致富之道,可以给我提issue

###技术
[基础依赖配置文件](https://github.com/AndroidWx/SimpleCodeForAndroid/blob/master/buildsystem/dependencies.gradle)
</br>
[每个子项目拓展文件类似](https://github.com/AndroidWx/SimpleCodeForAndroid/blob/master/buildsystem/childDependencies.gradle)
<br>
		ci集成配置可以写在项目里面，也可以在jenkins写
		github仅仅就是个存放而已，不gank，不妹子！
###求解决的一个仓位公式
	求每一期投资每个数的下注额度？
	题目：
		假如1个属性10个数，设置变量为s,当前这个属性遗漏阈值达到20,设置变量c，
		该属性历史最大阈值或者是理论中奖概率99.9％出现的阈值是30,设置变量Max，
		此时你打算追投次属性到阈值Max，
		假如你的本金为20000，设置变量为sum，
		设置回报率为30%（开始到Max其中一期每次回报率是30%以上），设置变量为y，
		如何计算每期每一个数的下注额度。


