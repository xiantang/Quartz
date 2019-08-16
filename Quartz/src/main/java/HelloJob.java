import org.quartz.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * @Author: xiantang
 * @Date: 2019/8/16 16:14
 */
public class HelloJob implements Job {

    /**
     * 如果要使用默认的无参的SimpleJobFactory
     * 就必须包含无参的构造方法（默认就包含
     * 如果设置为 private 就会报错
     * Class<? extends Job> jobClass = jobDetail.getJobClass();
     * return jobClass.newInstance();
     */
    public HelloJob() {
    }

    /**
     * 当Job的一个trigger被触发时，execute（）方法由调度程序的一个工作线程调用。
     *
     * @param context 传递给execute()方法的JobExecutionContext对象中保存着该job运行时的一些信息
     *                ，执行job的scheduler的引用，触发job的trigger的引用，JobDetail对象引用，
     *                以及一些其它信息。
     */
    @Override
    public void execute(JobExecutionContext context) {
        // 如果你使用的是持久化的存储机制
        // 在决定JobDataMap中存放什么数据的时候需要小心，
        // 因为JobDataMap中存储的对象都会被序列化，因此很可能会导致类的版本不一致的问题
        // Java的标准类型都很安全，如果你已经有了一个类的序列化后的实例，某个时候，别人修改了该类的定义，
        // 此时你需要确保对类的修改没有破坏兼容性
        JobKey key = context.getJobDetail().getKey();
        JobDataMap dataMap = context.getMergedJobDataMap();
        String jobSays = dataMap.getString("jobSays");
        float myFloatValue = dataMap.getFloat("myFloatValue");
        System.err.println("Instance " + key + " of DumbJob says: " + jobSays + ", and val is: " + myFloatValue);
    }




}
