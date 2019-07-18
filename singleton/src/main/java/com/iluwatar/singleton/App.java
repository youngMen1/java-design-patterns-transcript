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
 单例模式确保每个Java类加载器只能有一个现有实例
 实例并提供对它的全局访问。
 * <p/>
 这种模式的风险之一是在a中设置单例导致的错误
 分布式环境可能很难调试，因为如果使用a调试它将正常工作
 单个类加载器。此外，这些问题可能会在实施后出现一段时间
 单身，因为他们可能会开始同步，只会随着时间变得异步，所以你可以
 不清楚为什么你会看到行为的某些变化。
 * <p/>
 有很多方法可以实现Singleton。第一个是急切初始化的实例
 在{@link IvoryTower}。急切初始化意味着实现是线程安全的。如果
 你可以负担得起放弃对实例化时刻的控制，那么这个实现就适合了
 你没事
 * <p/>
 实现热切初始化的Singleton的另一个选择是基于枚举的Singleton。这个例子
 可在{@link EnumIvoryTower}中找到。乍一看，代码看起来简短。但是，你
 应该意识到缺点，包括承诺实施战略，扩展
 枚举类，可序列化和编码限制。这些在Stack中进行了广泛讨论
 溢出：
 * http://programmers.stackexchange.com/questions/179386/what-are-the-downsides-of-implementing
 * -a-singleton-with-javas-enum
 * <p/>
 {@link ThreadSafeLazyLoadedIvoryTower}是一个初始化的Singleton实现
 需求。缺点是访问速度非常慢，因为整个访问方法都是如此
 同步。
 * <p/>
 另一个按需初始化的Singleton实现可以在
 {@link ThreadSafeDoubleCheckLocking}。它有点快
 {@link ThreadSafeLazyLoadedIvoryTower}因为它不同步整个访问方法但是
 只有特定条件的内部方法。
 * <p/>
 另一种实现线程安全延迟初始化Singleton的方法可以在
 {@link InitializingOnDemandHolderIdiom}。但是，此实现至少需要Java 8
 API级别可以工作。
 */
public class App {

  /**
   * Program entry point.
   *
   * @param args command line args
   */
  public static void main(String[] args) {

    // 急切地初始化单身人士
    IvoryTower ivoryTower1 = IvoryTower.getInstance();
    IvoryTower ivoryTower2 = IvoryTower.getInstance();
    System.out.println("ivoryTower1=" + ivoryTower1);
    System.out.println("ivoryTower2=" + ivoryTower2);

    // 懒洋洋地初始化单身人士
    ThreadSafeLazyLoadedIvoryTower threadSafeIvoryTower1 =
        ThreadSafeLazyLoadedIvoryTower.getInstance();
    ThreadSafeLazyLoadedIvoryTower threadSafeIvoryTower2 =
        ThreadSafeLazyLoadedIvoryTower.getInstance();
    System.out.println("threadSafeIvoryTower1=" + threadSafeIvoryTower1);
    System.out.println("threadSafeIvoryTower2=" + threadSafeIvoryTower2);

    // enum singleton
    EnumIvoryTower enumIvoryTower1 = EnumIvoryTower.INSTANCE;
    EnumIvoryTower enumIvoryTower2 = EnumIvoryTower.INSTANCE;
    System.out.println("enumIvoryTower1=" + enumIvoryTower1);
    System.out.println("enumIvoryTower2=" + enumIvoryTower2);

    // 双重检查锁定
    ThreadSafeDoubleCheckLocking dcl1 = ThreadSafeDoubleCheckLocking.getInstance();
    System.out.println(dcl1);
    ThreadSafeDoubleCheckLocking dcl2 = ThreadSafeDoubleCheckLocking.getInstance();
    System.out.println(dcl2);

    // 初始化按需持有人的习语
    InitializingOnDemandHolderIdiom demandHolderIdiom =
        InitializingOnDemandHolderIdiom.getInstance();
    System.out.println(demandHolderIdiom);
    InitializingOnDemandHolderIdiom demandHolderIdiom2 =
        InitializingOnDemandHolderIdiom.getInstance();
    System.out.println(demandHolderIdiom2);
  }
}
