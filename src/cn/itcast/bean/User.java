package cn.itcast.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
//<bean name="user" class="cn.itcast.bean.User" />
/*@Service("user")  service层
@Controller("user") web层
@Repository("user") dao层             这几个功能和Component一样*/
@Component("user")
@Scope(scopeName="singleton")//多例
public class User {
	@Value("tom")
	private String name;
	
	private Integer age;
	//@Autowired//自动装配
	//问题:如果匹配多个类型一致的对象,将无法选择具体注入哪一类
	//@Qualifier("car2")
	@Resource(name="car")//手动注入，指定注入哪个名称的对象
	private Car car;
	
	
	
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public String getName() {
		return name;
	}
	@Value("tom")
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@PostConstruct//在对象被创建后调用.init-method
	public void init(){
		System.out.println("我是初始化方法!");
	}
	@PreDestroy//在对象销毁前调用。destroy-method
	public void destory(){
		System.out.println("我是销毁方法!");
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", car=" + car + "]";
	}
	
}
