# HK6走势分析
## 前言
	关于研发这个应用程序，初衷是应人之托，写一个直接干净简洁的框架，15年就持续关注Android-CleanArchitecutre以及最早的mvp概念，如今成了主流，Google官方也出了干净简洁框架的demo，建议大家每个框架尝试看一遍

[Android-CleanArchitecture](https://github.com/android10/Android-CleanArchitecture)
##why to use HK6‘s data?
	14年的时候,看了几本双色球的书，利用的书中的公式写了一个排号杀号的java程序，然并卵，500万无缘；对书中影响最深的就是博彩公式N=log(1-DC)/log(1-P) N为间隔期数,DC为发生可能性 ，P为理论中奖概率,莫名其妙的就做上了hk6的数据处理分析，可能身边有人买这个吧。


##功能说明
	1.展示90年到现在的数据。
	2.对每个永久属性的90%95%96％97%98%99%99.9%的阈值情况分析以及预警提示。
	3.对每个永久属性归类的每个元素做历史阈值统计，以及阈值后出码的图表展示。
	4.todo 每个永久属性归类的每个元素连续出现期数统计，以及图标分析。

###感悟
	任何一个“市场”都有一套系统性的知识，博彩也好，期货也好，现货也罢，高风险高利润行业，都是要反人性的，如果遇见此时的你，打算买博彩，建议业余玩玩而已，千万别重仓；如果你会处理仓位控制，它将会是一个业余稳定收入，我在现货市场亏损的钱买来了仓位控制的教训！

###技术
[基础依赖配置文件](https://github.com/AndroidWx/SimpleCodeForAndroid/blob/master/buildsystem/dependencies.gradle)
</br>
[每个子项目拓展文件类似](https://github.com/AndroidWx/SimpleCodeForAndroid/blob/master/buildsystem/childDependencies.gradle)
<br>
ci集成配置可以写在项目里面，也可以在jenkins写，单独这种项目，别没有公开，上gank去宣传,纯素私人私用。
