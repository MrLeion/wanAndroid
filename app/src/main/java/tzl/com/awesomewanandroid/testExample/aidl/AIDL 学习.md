# 参考文章
1.http://weishu.me/2016/01/12/binder-index-for-newer/
2.http://gityuan.com/2015/11/21/binder-framework/



动手实践：
https://developer.android.com/guide/components/aidl?hl=zh-cn
https://blog.csdn.net/u011240877/article/details/72765136

总结：实践过程中发现 要在/aidl 文件夹下面新建一系列 .aidl 文件
原因实际是 Android Studio 系统为我们做了一些代码生成工作：

bean -> Parceble.java
idl -> * extends IInterface
       + Stub extends Binder ---- Server 端操作  自定义操作，继承 service.stub
         + Proxy 代理 stub 完成操作---- Client 端操作 通过stub 引用调用远程自定义操作



多进程出现数据同步、多线程不起作用等问题--》IPC 机制
传统管道、System V IPC、socket --》 安全高效 Binder

Binder 四大元素：
Binder(服务器)
BinderProxy(客户端)
ServiceManager(域名解析器)
Binder驱动(Loadable kernel module)(通信网络)










代理模式：
https://blog.csdn.net/briblue/article/details/73928350

策略模式：
装饰类：类继承

UML 图
https://blog.csdn.net/wanmeirongyan100/article/details/51601570




