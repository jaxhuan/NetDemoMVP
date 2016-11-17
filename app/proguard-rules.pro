## normal
# 指定压缩级别
-optimizationpasses 5
# 不跳过非公共的库的类成员
-dontskipnonpubliclibraryclassmembers
# 混淆时采用的算法(google推荐，一般不改变)
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*
# 把混淆类中的方法名也混淆了
-useuniqueclassmembernames
# 优化时允许访问并修改有修饰符的类和类的成员
-allowaccessmodification
# 不做预检验,preverify是proguard的四个步骤之一,Android不需要preverify,去掉这一步可以加快混淆速度
-dontpreverify
# 将文件来源重命名为“SourceFile”字符串
-renamesourcefileattribute SourceFile
# 保留行号
-keepattributes SourceFile,LineNumberTable
#-keep public class * extends android.app.Fragment
#-keep public class * extends android.app.Activity
#-keep public class * extends android.app.Application
#-keep public class * extends android.app.Service
#-keep public class * extends android.content.BroadcastReceiver
#-keep public class * extends android.preference.Preference
#-keep public class * extends android.content.ContentProvider
#-keep public class * extends android.support.v4.**
#-keep public class * extends android.support.annotation.**
#-keep public class * extends android.support.v7.**
-keep class * implements android.os.Parcelable {public static final android.os.Parcelable$Creator *;}
# 注解
-keepattributes *Annotation*
# 异常
-keepattributes Exceptions
# 泛型
-keepattributes Signature
# 反射
-keepattributes EnclosingMethod
## normal

## retrofit2[version 2.1.0]
-dontnote retrofit2.Platform
-dontnote retrofit2.Platform$IOS$MainThreadExecutor
-dontwarn retrofit2.Platform$Java8
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
## retrofit2

## rx[version_rx_java 1.1.8,version_rx_android 1.2.1]
-dontwarn sun.misc.**
-keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {long producerIndex;long consumerIndex;}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {rx.internal.util.atomic.LinkedQueueNode producerNode;}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueConsumerNodeRef {rx.internal.util.atomic.LinkedQueueNode consumerNode;}
## rx

## glide[version 3.7.0]
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
  **[] $VALUES;
  public *;}
## glide

## okhttp3[version_logging-interceptor 3.3.1]
-dontwarn com.squareup.okhttp3.**
-keep class com.squareup.okhttp3.** { *;}
-dontwarn okio.**
## okhttp3

## butterknife[version 8.2.1]
-keep class butterknife.*
-keep class butterknife.** { *; }
-dontwarn butterknife.internal.**
-keepclasseswithmembernames class * { @butterknife.* <methods>; }
-keepclasseswithmembernames class * { @butterknife.* <fields>; }
-keep class **$$ViewBinder { *; }
## butterknife

## gson[version 2.8.0]
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }
-keep class com.google.gson.examples.android.model.** { *; }
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer
## gson

## Mine proguard rules(需要根据项目更改)
# Keep the bean_data in project(保留项目中需要gson转换的数据基类)
-keep class com.skyzone.netdemomvp.data.** { *; }
