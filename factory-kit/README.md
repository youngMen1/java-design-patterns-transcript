---
layout: pattern
title: Factory Kit
folder: factory-kit(其他模式)
permalink: /patterns/factory-kit/
categories: Creational
tags:
 - Java
 - Difficulty-Beginner
 - Functional - 实用
---

## Intent
使用分隔的构建器和工厂接口定义不可变内容的工厂。

![alt text](./etc/factory-kit.png "Factory Kit")

## Applicability
使用Factory Kit模式时

* 类无法预测它必须创建的对象类
* 您只需要一个自定义构建器的新实例而不是全局构建器
* 你明确想要定义工厂可以构建的对象类型
* 你想要一个分离的构建器和创建器接口

## Credits

* [Design Pattern Reloaded by Remi Forax: ](https://www.youtube.com/watch?v=-k2X7guaArU)
