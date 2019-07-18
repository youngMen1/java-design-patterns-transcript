---
layout: pattern
title: Singleton
folder: singleton
permalink: /patterns/singleton/
categories: 创建型模式
tags:
 - Java
 - Gang Of Four
 - Difficulty-初学者
---

## Intent
确保一个类只有一个实例，并提供全局点访问它。

![alt text](./etc/singleton_1.png "Singleton")

## 适用性
使用Singleton模式时

* 必须只有一个类的实例，并且客户端必须可以从一个众所周知的访问点访问它
* 当唯一实例应该通过子类化可扩展时，客户端应该能够使用扩展实例而无需修改其代码 

## 典型用例

* 记录类
* 管理与数据库的连接
* 文件管理器

## 现实世界的例子

* [java.lang.Runtime#getRuntime()](http://docs.oracle.com/javase/8/docs/api/java/lang/Runtime.html#getRuntime%28%29)

## Credits

* [Design Patterns: Elements of Reusable Object-Oriented Software](http://www.amazon.com/Design-Patterns-Elements-Reusable-Object-Oriented/dp/0201633612)
* [Effective Java (2nd Edition)](http://www.amazon.com/Effective-Java-Edition-Joshua-Bloch/dp/0321356683)
