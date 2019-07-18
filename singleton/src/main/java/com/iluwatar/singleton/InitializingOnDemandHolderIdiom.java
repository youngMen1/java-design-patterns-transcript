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

import java.io.Serializable;

/**
 Initialize-on-demand-holder习惯用法是一种创建延迟初始化单例的安全方法
 Java中的对象。请参阅Dhruv Mohindra的“CERT Oracle安全编码标准Java”，
 Robert C. Seacord p.378
 * <p/>
 单例对象通常很难创建，有时需要序列化它们。这个班
 还演示了如何在单例的序列化版本中保留单例。
 *
 * @author mortezaadi@gmail.com
 */
public final class InitializingOnDemandHolderIdiom implements Serializable {

  private static final long serialVersionUID = 1L;

  private InitializingOnDemandHolderIdiom() {}

  public static InitializingOnDemandHolderIdiom getInstance() {
    return HelperHolder.INSTANCE;
  }

  protected Object readResolve() {
    return getInstance();
  }

  private static class HelperHolder {
    public static final InitializingOnDemandHolderIdiom INSTANCE =
        new InitializingOnDemandHolderIdiom();
  }

}
