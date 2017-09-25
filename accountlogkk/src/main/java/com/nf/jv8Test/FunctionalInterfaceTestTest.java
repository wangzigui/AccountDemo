package com.nf.jv8Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.junit.Test;

import com.nf.entity.Account;
/**
 * lambda简写形式 - 方法引用：
        如果我们想要调用的方法拥有一个名字，我们就可以直接调用它。
- 静态方法引用 className::methodName
- 实例上的实例方法引用 instanceReference::methodName
- 超类上的实例方法引用 super::methodName
- 类型上的实例方法引用 className::methodName，比如String::toUpperCase，语法和静态方法引用相同，编译器会根据实际情况作出决定
- 构造方法引用 className::new
- 数组构造方法引用 TypeName[]::new
 * @author wangzigui_cs
 *
 */
public class FunctionalInterfaceTestTest {

	@Test
	public void test() {
		
	}
	
	public static final String FUNCTIONALNUM = "0";
	
	public static void main(String[] args) {
		FunctionalInterfaceTest<String,Integer> test = (from) -> Integer.valueOf(from);
		Integer testNumber = test.coverter("123");
		System.out.println(testNumber);
		
		//Consumer<T> - T作为输入，执行某种动作但没有返回值
		Consumer<String> con = (x) ->{System.out.println(x);};
		con.accept("hello world!!");
		
		//Predicate<T> -T作为输入，返回的boolean值作为输出
		Predicate<String> pre = (x) ->{System.out.println(x);if(x.equals("aa"))
			return false;
		else
			return true; };
		System.out.println(pre.test("Predicate  input!!"));
	    String kk = "0";
		// Function<T, R> -T作为输入，返回的R作为输出
	    Function<Account,String> function = (x) -> {System.out.print(x.toString()+": ");return "Function";};
	    Account a = new Account();
	    a.setAccountId(11);
	    System.out.println(function.apply(a));
	    
	    //BinaryOperator<T> -两个T作为输入，返回一个T作为输出，对于“reduce”操作很有用
	    BinaryOperator<String> bina = (x,y) ->{System.out.print(x+" "+y+FUNCTIONALNUM+kk);return "BinaryOperator";};
	    String str = bina.apply("hello ","world");
	    System.out.println("  "+str);
	    
	    Comparator<String> c;
	    c = (String s1, String s2) -> s1.compareToIgnoreCase(s2);	 
	    System.out.println(c.compare("a", "a"));
	    
//	    Function<Integer, Integer> fuc = i ->{System.out.println(i); return i;};
	    
//	    fuc.apply(2);
	    List<Integer> list = new ArrayList<>();
	    list.add(1);
	    list.add(2);
	    list.add(13);
	    list.add(14);
//	    list.forEach(
//	    		value ->{System.out.println(value);}
//	    		);
	    Stream<Integer> integerStreams = list.stream();
	    integerStreams.distinct()
	    			.filter(t -> t>10 && t<14)
	    			.forEach(e ->{System.out.println(e);});
	    
	    Stream<Integer> integerStream = Stream.of(1, 2, 3, 5);
	    int sum = (int) integerStream.distinct()
	    			 .filter(t -> t>1)
	    			 .mapToDouble(t -> t)
	    			 .sum()
//	    			 .forEach(e -> {System.out.println("e:"+e);})
	    			 ;
	    System.out.println(sum);			 
	    
	}

}
