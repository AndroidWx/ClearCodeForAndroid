# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/joye/Library/Android/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-dontshrink
## 代码混淆压缩比，在0和7之间，默认为5，一般不需要改
#-optimizationpasses 5
#
## 混淆时不使用大小写混合，混淆后的类名为小写
#-dontusemixedcaseclassnames
#
## 指定不去忽略非公共的库的类
#-dontskipnonpubliclibraryclasses
#
## 指定不去忽略非公共的库的类的成员
#-dontskipnonpubliclibraryclassmembers
#
## 不做预校验，preverify是proguard的4个步骤之一
## Android不需要preverify，去掉这一步可加快混淆速度
#-dontpreverify
#
## 有了verbose这句话，混淆后就会生成映射文件
## 包含有类名->混淆后类名的映射关系
## 然后使用printmapping指定映射文件的名称
#-verbose
#-printmapping proguardMapping.txt
#
## 指定混淆时采用的算法，后面的参数是一个过滤器
## 这个过滤器是谷歌推荐的算法，一般不改变
#-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*
#
## 保护代码中的Annotation不被混淆，这在JSON实体映射时非常重要，比如fastJson
#-keepattributes *Annotation*
#
## 避免混淆泛型，这在JSON实体映射时非常重要，比如fastJson
#-keepattributes Signature
##抛出异常时保留代码行号，在异常分析中可以方便定位
#-keepattributes SourceFile,LineNumberTable
##用于告诉ProGuard，不要跳过对非公开类的处理。默认情况下是跳过的，因为程序中不会引用它们，有些情况下人们编写的代码与类库中的类在同一个包下，并且对包中内容加以引用，此时需要加入此条声明。
#-dontskipnonpubliclibraryclasses
-dontshrink

