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
 * 双重检查锁定
 * <p/>
 * http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html
 * <p/>
 * Broken under Java 1.4.
 *
 * @author mortezaadi@gmail.com
 */
public final class ThreadSafeDoubleCheckLocking {

  private static volatile ThreadSafeDoubleCheckLocking instance;

  /**
   * 私有构造函数，以防止客户端实例化。
   */
  private ThreadSafeDoubleCheckLocking() {
    // 防止通过Reflection调用实例化
    if (instance != null) {
      throw new IllegalStateException("Already initialized.");
    }
  }

  /**
   * 公共访问者。
   *
   * @return an instance of the class.
   */
  public static ThreadSafeDoubleCheckLocking getInstance() {
    // 局部变量使性能提高25％
    // Joshua Bloch "Effective Java, Second Edition", p. 283-284
    ThreadSafeDoubleCheckLocking result = instance;
    if (result == null) {
      synchronized (ThreadSafeDoubleCheckLocking.class) {
        result = instance;
        if (result == null) {
          instance = result = new ThreadSafeDoubleCheckLocking();
        }
      }
    }
    return result;
  }
}
