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
package com.iluwatar.factory.method;

/**
 * 
 工厂方法是一种创造性的设计模式，它使用工厂方法来处理
 创建对象的问题，而不指定将要创建的对象的确切类。
 这是通过调用接口中指定的工厂方法创建对象来完成的
 由子类实现，或在基类中实现，并可选择重写
 派生类 - 而不是通过调用构造函数。
 * <p>
 在这个工厂方法示例中，我们有一个接口（{@link Blacksmith}），其中包含一个方法
 创建对象（{@link Blacksmith＃manufactureWeapon}）。具体子类（
 {@link OrcBlacksmith}，{@link ElfBlacksmith}）然后重写方法以生成对象
 他们的喜好。
 * 
 */
public class App {

  private final Blacksmith blacksmith;
  
  /**
   创建<code> App </ code>的实例，该实例将使用<code> blacksmith </ code>进行制作
   战争的武器。
   <code> App </ code>不知道它正在使用的{@link Blacksmith}的具体实现。
   决定使用哪个铁匠实施可能取决于配置，或
   战争中的对手类型。
   @param blacksmith 是一个非空实现的铁匠
   */
  public App(Blacksmith blacksmith) {
    this.blacksmith = blacksmith;
  }
  
  /**
   * Program entry point
   * 
   * @param args command line args
   */
  public static void main(String[] args) {
    // 让我们用兽人武器开战
    App app = new App(new OrcBlacksmith());
    app.manufactureWeapons();
    
    // 让我们与精灵武器开战
    app = new App(new ElfBlacksmith());
    app.manufactureWeapons();
  }
  
  private void manufactureWeapons() {
    Weapon weapon;
    weapon = blacksmith.manufactureWeapon(WeaponType.SPEAR);
    System.out.println(weapon);
    weapon = blacksmith.manufactureWeapon(WeaponType.AXE);
    System.out.println(weapon);
  }
}
