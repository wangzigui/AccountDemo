package com.nf.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nf.AccountService;
import com.nf.commonReslut;
import com.nf.dao.AccountDao;
import com.nf.dao.MessageTestDao;
import com.nf.dao.TestDao;
import com.nf.dao.impl.AccountDaoImpl;
import com.nf.entity.Account;
import com.nf.entity.Customer;
import com.nf.entity.MessageTest;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	  @Autowired
	  AccountDao accountDao;
	  
	  @Autowired
	  TestDao testDao;
	  
	  @Autowired
	  AccountService accountService;
	  
	  @Autowired
	  AccountDaoImpl accountDaoImpl;
	  
	  @Autowired
	  MessageTestDao messageTestDao;
	  
	  private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	 
	  @RequestMapping(value = "/list", method = RequestMethod.GET)
	  public commonReslut<Account> getAccounts() 
	  {
		  PageRequest request = this.buildPageRequest(1,20);
		  
		  logger.debug("日志输出测试 Debug");
		  logger.trace("日志输出测试 Trace");
		  logger.info("日志输出测试 Info");
		  
//		  Page<Account> sourceCodes = accountDao.findAll(request);
		  List<Account> sourceCodes = accountDao.findByAccountId(12345);
//		  System.out.println("第一次查询："+sourceCodes.toString());
//		  List<Account> accounts = testDao.findCustomers();
//		  Page<Account> sourceCodes2 = accountDao.findAll(request);
		  List<Account> sourceCodes2 = accountDao.findByAccountId(12345);
		  
		  Page<Account> list = accountDaoImpl.findBySepc(0, 10);
		  System.out.println(list.toString());
//		  System.out.println("第二次查询："+sourceCodes2.toString());
//		  System.out.println(accounts.toString());
//		  com.nf.domain.Page page = new com.nf.domain.Page(sourceCodes.getNumber()+1,sourceCodes.getSize(),sourceCodes.getTotalElements());
		  commonReslut<Account> result = new commonReslut<Account>("200","success",null,null);

		  return result;

	  }
	  
	  /**
	   * 查询视图
	   * @return
	   */
	  @RequestMapping(value = "/test", method = RequestMethod.GET)
	  public List<MessageTest> getAccounts1() 
	  {
		  List<MessageTest> list = messageTestDao.findAll();
		  System.out.println("第一次查询："+list.toString());
		  List<MessageTest> list1 = messageTestDao.findAll();
		  System.out.println("第一次查询："+list1.toString());
//		  List<MessageTest> list = testDao.findMessageTest();
//		  List<Customer> list = accountService.getSourceCode(1, 10);
		  return list;

	  }
	  
	  
	  
	  
	   //构建PageRequest
	    private PageRequest buildPageRequest(int pageNumber, int pagzSize) {
	        return new PageRequest(pageNumber - 1, pagzSize, null);
	    }
	  
	  @Transactional
	  @RequestMapping(value = "/save", method = RequestMethod.POST)
	  public String saveAccounts() 
	  {
		    Account a = new Account(123456+new Random().nextInt(100),"sa",2460);
		    List<Customer> list = new ArrayList<>();
		    Customer c = new Customer();
		    c.setName("aas11"+new Random().nextInt(100));
		    c.setAddre("sdfdf");
//		    c.setAccountId(a.getId());
		    list.add(c);
//		    a.setCustomer(list);
		    testDao.save(a);
		    
		    return "hellow";
	  }
	  
	  @RequestMapping(value = "/modify", method = RequestMethod.GET)
	  public String modifyAccounts(Account a) 
	  {
		    a.setAccountId(3);
//		    accountDao.modifyAccounts(null, a.getAccountid());
		    return "success";
	  }
	  
	  @RequestMapping(value = "/delete", method = RequestMethod.GET)
	  public String deleteAccounts(int id) 
	  {
		    accountDao.delete(id);
		    return "success";
	  }
	  
	  public static void main(String[] args) {
			TestDao dao = new TestDao();
			List<Account> cu = dao.findCustomers();
			System.out.println(cu.toString());
		}
}
