package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhonebookDao;
import com.javaex.vo.PersonVo;

@Service
public class PhonebookService {
	
	@Autowired
	private PhonebookDao phonebookDao;
	
	
	public int exeWrite(PersonVo personVo) {
		System.out.println("PhonebookService.exeWrite()");
		
		//PhonebookDao phonebookDao = new PhonebookDao();
		
		int count = phonebookDao.personInsert(personVo);
		
		return count;
		
	}

	
	public List<PersonVo> exeList() {
		System.out.println("PhonebookService.exeList()");
		
		
		//spring @autowired가 제어(제어의 역전) Dao 클래스에는 @Repository써줘야함
		//PhonebookDao phonebookDao = new PhonebookDao();
		List<PersonVo> personList = phonebookDao.personSelect();
		
		return personList;
	}
	

	
	public int exeDelete(int no) {
		System.out.println("PhonebookService.exeDelete()");
		
		//PhonebookDao phoneDao = new PhonebookDao();
		int count = phonebookDao.personDelete(no);
		
		return count;
	}
	
	public PersonVo exeModifyForm(int no) {
		System.out.println("PhonebookService.exeModifyForm()");
		
		//PhonebookDao phonebookDao = new PhonebookDao();
		PersonVo personVo = phonebookDao.personSelectOne(no);
		
		return personVo;
	}
	
	public int exeModify(PersonVo personVo) {
		System.out.println("PhonebookService.exeModify()");
		
		//PhonebookDao phonebookDao = new PhonebookDao();
		int count = phonebookDao.personUpdate(personVo);
		
		return count;
	}
	
}
