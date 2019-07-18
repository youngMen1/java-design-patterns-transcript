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

/**
 Factory-kit是一种创建模式，它定义了一个不可变内容的工厂
 用分离的构建器和工厂接口来处理问题
 创建直接在factory-kit实例中指定的对象之一。
 *
 * <p>
 在给定的示例中，{@link WeaponFactory}表示包含的工厂工具包
 用于创建新对象的四个{@link Builder}
 实现{@link Weapon}接口的类。
 <br>每个人都可以使用{@link WeaponFactory #create（WeaponType）}方法调用
 表示需要的{@link WeaponType}实例的输入
 在工厂实例中使用所需的类类型显式映射。
 */
public class App {
  /**
   * Program entry point.
   *
   * @param args @param args command line args
   */
  public static void main(String[] args) {
    WeaponFactory factory = WeaponFactory.factory(builder -> {
      builder.add(WeaponType.SWORD, Sword::new);
      builder.add(WeaponType.AXE, Axe::new);
      builder.add(WeaponType.SPEAR, Spear::new);
      builder.add(WeaponType.BOW, Bow::new);
    });
    Weapon axe = factory.create(WeaponType.AXE);
    System.out.println(axe);
  }
}
