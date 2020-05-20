import com.jdd.Application;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ServiceTest {
    /**
     *  事务的传播 - Propagation
     *      REQUIRED：使用当前的事务，如果当前没有事务，则自己新建一个事务，子方法是必须运行在
     *      一个事务中的，如果当前存在事务则加入这个事务，成为一个整体。（意思是如果父方法开启事务那么
     *      子类也会被加入该事务）
     *
     *      SUPPORTS：如果当前有事务，则使用事务；如果当前没有事务，则不使用事务。
     *      （可以理解跟随父方法）
     *
     *      MANDATORY：强制，调用被该属性描述的方法时，
     *      调用方必须存在一个事务若不存在则抛出异常
     *      （说明该方法一定要在事务的情况下才可以执行）
     *
     *      REQUIRES_NEW:如果当前有事务则挂起该事务，并且自己创建一个新的事务自己使用
     *      如果当前没有事务，则同REQUIRED
     *
     *      NOT_SUPPORTED:如果当前有事务则挂机，自己不使用事务去运行数据库操作，没有就没有
     *
     *      NEVER:如果当前有事务存在则抛出异常
     *
     *      NESTED:如果当前有事务，则开启子事务（嵌套事务），嵌套事务是独立提交或则回滚；
     *      如果当前没有事务，则同REQUIRED。
     *      但是如果嵌套的父事务提交，则会携带子事务一起提交
     *      如果主事务回滚，则子事务会一起回滚。相反，子事务异常，则父事务可以回滚或不会滚。
     *
     *
     *
     */

}
