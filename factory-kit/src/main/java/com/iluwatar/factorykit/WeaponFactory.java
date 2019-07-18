/**
 * The MIT License
 * Copyright (c) 2014 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.iluwatar.factorykit;

import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
  功能界面，工厂套件设计模式的一个例子。
  <br>本地创建的实例提供了严格定义的机会
  工厂实例将能够创建哪些对象类型。
  <br> Factory是{@link Builder}的占位符
  使用{@link WeaponFactory #create（WeaponType）}方法初始化新对象。
 */
public interface WeaponFactory {

  /**
   * 创建给定类型的实例。
   * @param name 表示要创建的对象类型的枚举。
   * @return new instance of a requested class implementing {@link Weapon} interface.
   */
  Weapon create(WeaponType name);

  /**
   * 创建工厂 - 指定的占位符 {@link Builder}s.
   * @param consumer 为工厂的新建筑工人。
   * @return factory with specified {@link Builder}s
   */
  static WeaponFactory factory(Consumer<Builder> consumer) {
    HashMap<WeaponType, Supplier<Weapon>> map = new HashMap<>(16);
    consumer.accept(map::put);
    return name -> map.get(name).get();
  }
}
