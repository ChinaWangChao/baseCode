package demo01;

/**
 * @description: show1及注解中的方法
 * @Author: wangchao
 * @Date: 2020/12/27
 */
@MyAnno(value = 2, per = Person.p1, anno2 = @MyAnno2, strs = {"111", "222"})
@MyAnno3
public class Worker {
}
