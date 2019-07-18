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
package com.iluwatar.singleton;

/**
 线程安全的Singleton类。该实例被懒惰地初始化，因此需要同步
 机制。
 *
 注意：如果通过反射创建，则不会创建单例，而是创建多个选项
 同一个类加载器
 */
public final class ThreadSafeLazyLoadedIvoryTower {

  private static ThreadSafeLazyLoadedIvoryTower instance;

  private ThreadSafeLazyLoadedIvoryTower() {}

  /**
   * 只有在第一次调用实例时才会创建实例。延迟加载
   */
  public  static synchronized ThreadSafeLazyLoadedIvoryTower getInstance() {

    if (instance == null) {
      instance = new ThreadSafeLazyLoadedIvoryTower();
    }

    return instance;
  }
}
