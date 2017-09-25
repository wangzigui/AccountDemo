package com.nf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nf.dao.SourceCodeDao;
import com.nf.entity.Account;
import com.nf.entity.Customer;

@Service
public class AccountService {
	
	@Autowired
    private SourceCodeDao sourceCodeDao;
	
	public List<Customer> getSourceCode(int pageNumber,int pageSize){
//        PageRequest request = this.buildPageRequest(pageNumber,pageSize);
        List<Customer> sourceCodes= (List<Customer>) this.sourceCodeDao.inAndOutTest();
        
        return sourceCodes;
    }
	
	//构建PageRequest
    private PageRequest buildPageRequest(int pageNumber, int pagzSize) {
        return new PageRequest(pageNumber - 1, pagzSize, null);
    }
}
