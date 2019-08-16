## 分布式定时任务框架中的思考
* JobDataMap 存储的对象会被序列化，可能会导致类的版本不一致的问题
  如何保证他人修改定义之后没有改变兼容性。
* `executeInNonManagedTXLock()`如何避免分布式情况下的调用
    * 为何要使用 `auto commit` 和 将数据库隔离级别设置为`READ_COMMIT`
    * 为何没有获取到锁的线程仍然要使用关闭 `auto commit` 和 将数据库隔离级别设置为`READ_COMMIT`
    * `Semaphore` 有什么用 为何用 `obtainLock(conn,lockName)` 来锁住资源
    * 他是如何用行锁来保证 `callback` 方法的线程安全的
    * `threadlocal` 在 `callback` 方法中担任什么样的角色
* 调度模式，如何允许多个线程同时拉取同一个trigger（乐观锁
* ABA 问题如何防止
* 类加载 .java 文件如何传输 如何运行

![](https://segmentfault.com/img/bVbdaoM?w=959&h=892)

