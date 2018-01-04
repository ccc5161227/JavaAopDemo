# JavaAopDemo
使用spring aop，便于理解

# 疑问
#####1. annotation注解方式的aop为什么要在xml配置中配置aspectj的bean，不配置aop日志就不生效？
#####2. xml和annotation两种方式的测试结果表明，around后置log打印顺序不一样，为什么？
#####3. @Pointcut("execution(* com.shyu.annotation.demo1.PersonService.*(..))")中的PersonService需要在xml中弄成bean或注解为@Service，aop才生效；如果不写PersonService则会报错，找不到对应的bean
#####4. aop日志只展示before和around，而且方法不执行
   - 问题代码：
    `@Around("pointCut()")
    public void around(ProceedingJoinPoint joinPoint) {
        System.out.println("around start..");
    }`
   - 修正后代码（原因：around中没有执行joinPoint.proceed()导致方法不执行）：
    `@Around("pointCut()")
    public void around(ProceedingJoinPoint joinPoint) {
        System.out.println("around start..");
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("around end..");
    }`
#####5. 切点使用方法 https://www.cnblogs.com/flowwind/p/4782606.html
   - 方法一：execution(* com.shyu.annotation.demo1.PersonService.*(..))    需包含对应的类，否则报错找不到对应的bean；范围是对应类所有方法
   - 方法二：execution(* *(..))    范围是所有类所有方法
   - 方法三：@Pointcut("execution(* com.shyu.annotation.demo1..*(..))")    范围是demo1下的所有类所有方法
> Spring切入点表达式常用写法：http://blog.51cto.com/lavasoft/172292
#####6. 静态和动态aop修改字节码或插入代码的时机？如何直观查看aop修改字节码？（参考：http://caoyaojun1988-163-com.iteye.com/blog/1131660）
`
    切面织入：
        编译时织入（Compile Time Weaving, CTW）：https://jingyan.baidu.com/article/3ea51489b927ff52e71bba4d.html
        载入时织入（Load Time Weaving, LTW）
        运行时织入

    HelloWorld.class 文件的解读：http://caoyaojun1988-163-com.iteye.com/blog/1114436
    CLASS 文件使用例子二：http://caoyaojun1988-163-com.iteye.com/blog/1117497
    CLASS 文件使用例子三--AOP字节码增强探索一 ：http://caoyaojun1988-163-com.iteye.com/blog/1131660

    二进制class文件解析相关博客合集：http://caoyaojun1988-163-com.iteye.com/category/163024

    使用ASM操作Java字节码，实现AOP原理: http://blog.csdn.net/catoop/article/details/50629921

    修改二进制字节码文件工具：asm

    AOP实现原理：http://blog.csdn.net/laliocat/article/details/50676501

    摘自: http://www.importnew.com/13367.html

        注解

            注解是Java 6中采用的一种技术（译注：其实Java 5就有注解了）。它是一种不会影响程序运行的元编程指令，我们可以用它来对一些指定的元素（方法、类或者变量）进行标记。换句话说，注解就是代码中可以看到的标记。一些注解只在编译阶段可见——它们不存在于编译好的.class文件中，另外一些注解在编译后仍然可见。

            例如，@Override是第一种类型（它的保留类型是SOURCE），而JUnit的@Test是第二种类型（保留类型是RUNTIME），@Loggable——我在上面使用过的是第二种注解，包含在jcabi-aspects中，在编译后会留在.class文件中。

            值得注意的是，上文的power()方法即便被注解并且编译，也不会发送任何内容到slf4j。仅仅是一种用来提醒相关软件“请记录我的执行过程”的标记， 理解这一点很重要。
        切面织入（aspect waving）就是将切面应用到目标对象从而创建一个新的代理对象的过程。切面织入将一些代码插入原代码，AspectJ就是这么做的。我们给它两个二进制Java类Foo.class 和 MethodLogger.class; 它返回三个类——修改过的Foo.class、Foo$AjcClosure1.class和未修改的MethodLogger.class。

        为了理解如何将不同的通知应用于对应的哪个方法，AspectJ织入在.class文件中使用了注解，并使用反射来浏览环境变量中的所有类。它分析@Around注解中的哪个方法满足条件。power()就在此时被发现了。
`
#####7. 查看和编辑.class文件中二进制码的方法？
    1. notepad怎么查看16进制编码：http://blog.csdn.net/nameisbill/article/details/54616311
    2. 查看解析好的.class文件的工具：Bytecode viewer（https://github.com/Konloch/bytecode-viewer/releases）、JBE（http://www.cs.ioc.ee/~ando/jbe/）
    3. 反编译.class文件工具：idea、eclipse等
    4. class文件格式：http://caoyaojun1988-163-com.iteye.com/blog/1114420
    5. HelloWorld.class 文件的解读（.class文件解读示例）：http://caoyaojun1988-163-com.iteye.com/blog/1114436
    6. 字符与16进制码速查：https://wenku.baidu.com/view/7988714690c69ec3d5bb757c.html
    7. CLASS 文件使用例子一（.class文件字符替换）：http://caoyaojun1988-163-com.iteye.com/blog/1117474
    8. CLASS 文件使用例子二（.class文件增删）：http://caoyaojun1988-163-com.iteye.com/blog/1117497
    9. 我们一般通过第三方的库文件，比如：asm、 cglib、 serp、 和bcel等去修改二进制码，也有工具，如：JBE、jd-gui + jclasslib
    10. 如何利用JClassLib修改.class文件（查看工具&修改方法）：http://blog.csdn.net/betterandroid/article/details/14520667
    11. 编辑.class文件的用途
        * 实现AOP的功能
        * 修改jar包中的.class功能（直接修改，难度大 或 反编译，修改后，重新编译--需获取jdk编译器版本并用相同版本再次编译）


`
AOP主要包含了通知、切点和连接点等术语，介绍如下

    通知(Advice)
    通知定义了切面是什么以及何时调用，何时调用包含以下几种

        Before 在方法被调用之前调用通知
        After 在方法完成之后调用通知，无论方法执行是否成功
        After-returning 在方法成功执行之后调用通知
        After-throwing 在方法抛出异常后调用通知
        Around 通知包裹了被通知的方法，在被通知的方法调用之前和调用之后执行自定义的行为

    切点(PointCut)
    通知定义了切面的什么和何时，切点定义了何处，切点的定义会匹配通知所要织入的一个或多个连接点，我们通常使用明确的类的方法名称来指定这些切点，或是利用正则表达式定义匹配的类和方法名称来指定这些切点。
    切点的格式如下

    execution(* com.ganji.demo.service.user.UserService.GetDemoUser (..) )

    连接点(JoinPoint)
    连接点是在应用执行过程中能够插入切面的一个点，这个点可以是调用方法时，抛出异常时，甚至是修改一个字段时，切面代码可以利用这些连接点插入到应用的正常流程中，并添加新的行为，如日志、安全、事务、缓存等。
现阶段的AOP框架
AOP框架除了Spring AOP之外，还包括AspectJ、JBoss AOP；
上述框架的区别是Spring AOP只支持到方法连接点，另外两个还支持字段和构造器连接点。
`

`
摘自 AOP与JAVA动态代理：https://www.cnblogs.com/xiaoxiao7/p/6057724.html
1、AOP的各种实现
AOP就是面向切面编程，我们可以从以下几个层面来实现AOP

    在编译期修改源代码
    在运行期字节码加载前修改字节码
    在运行期字节码加载后动态创建代理类的字节码

2、AOP各种实现机制的比较

以下是各种实现机制的比较：
类别	机制	原理	优点	缺点
静态AOP 	静态织入 	在编译期，切面直接以字节码的形式编译到目标字节码文件中 	对系统无性能影响 	灵活性不够
动态AOP 	动态代理 	在运行期，目标类加载后，为接口动态生成代理类，将切面织入到代理类中 	相对于静态AOP更加灵活   切入的关注点需要实现接口。对系统有一点性能影响
动态字节码生成 	CGLIB 	在运行期，目标类加载后，动态构建字节码文件生成目标类的子类，将切面逻辑加入到子类中 	没有接口也可以织入 	扩展类的实例方法为final时，则无法进行织入
自定义类加载器 	  	在运行期，目标加载前，将切面逻辑加到目标字节码里 	可以对绝大部分类进行织入 	代码中如果使用了其他类加载器，则这些类将不会被织入
字节码转换 	  	在运行期，所有类加载器加载字节码前进行拦截 	可以对所有类进行织入


5、AOP实战
5.1 AOP功能

    性能监控：在方法调用前后记录调用时间，方法执行太长或超时报警
    缓存代理：缓存某方法的返回值，下次执行该方法时，直接从缓存里获取
    软件破解：使用AOP修改软件的验证类的判断逻辑
    记录日志：在方法执行前后记录系统日志
    工作流系统：工作流系统需要将业务代码和流程引擎代码混合在一起执行，那么我们可以使用AOP将其分离，并动态挂接业务
    权限验证：方法执行前验证是否有权限执行当前方法，没有则抛出没有权限执行异常，由业务代码捕捉

5.2 Spring的AOP

Spring默认采取动态代理机制实现AOP，当动态代理不可用时（代理类无接口）会使用cglib机制

但Spring的AOP有一定的缺点：

    第一，只能对方法进行切入，不能对接口、字段、静态代码块进行切入（切入接口的某个方法，则该接口下所有实现类的该方法都将被切入）
    第二，同类中的互相调用方法将不会使用代理类。因为要使用代理类必须从Spring容器中获取Bean
    第三，性能不是最好的。从前面几节得知，我们自定义的类加载器，性能优于动态代理和cglib
`

`
摘自：http://onlyor.iteye.com/blog/1478109
AOP作用
　　Authentication 权限
　　Caching 缓存
　　Context passing 内容传递
　　Error handling 错误处理
　　Lazy loading 懒加载
　　Debugging 调试
　　logging, tracing, profiling and monitoring 记录跟踪 优化 校准
　　Performance optimization 性能优化
　　Persistence 持久化
　　Resource pooling 资源池
　　Synchronization 同步
　　Transactions 事务


Spring AOP（动态）：通过代理程序运行时织入
    优点：简单，易用
    缺点：性能略低，仅适用于方法调用，必须在Spring容器

AspectJ（静态）：通过修改程序的字节码完成织入
    优点：性能好，功能强大，无需Spring容器
    缺点：修改需要重新编译，要引入Aspect J的编译器／织入器，复杂
`