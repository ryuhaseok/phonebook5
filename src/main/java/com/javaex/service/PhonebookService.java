package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhonebookDao;
import com.javaex.vo.PersonVo;

@Service
public class PhonebookService {
	
	@Autowired
	private PhonebookDao phonebookDao;
	
	//등록
	public int exeWrite(PersonVo personVo) {
		System.out.println("PhonebookService.exeWrite()");
		
		//PhonebookDao phonebookDao = new PhonebookDao();
		
		int count = phonebookDao.personInsert(personVo);
		
		return count;
		
	}
	
	//등록2
	public int exeWrite2(String name, String hp, String company) {
		System.out.println("PhonebookService.exeWrite2()");
		
		System.out.println(name);
		System.out.println(hp);
		System.out.println(company);
		
		Map<String, String> personMap = new HashMap<String, String>();
		personMap.put("name", name);
		personMap.put("hp", hp);
		personMap.put("company", company);
		
		int count = phonebookDao.personInsert2(personMap);
		
		return count;
	}

	//전체 가져오기
	public List<PersonVo> exeList() {
		System.out.println("PhonebookService.exeList()");
		
		
		//spring @autowired가 제어(제어의 역전) Dao 클래스에는 @Repository써줘야함
		//PhonebookDao phonebookDao = new PhonebookDao();
		List<PersonVo> personList = phonebookDao.personSelect();
		
		return personList;
	}
	

	//삭제
	public int exeDelete(int no) {
		System.out.println("PhonebookService.exeDelete()");
		
		//PhonebookDao phoneDao = new PhonebookDao();
		int count = phonebookDao.personDelete(no);
		
		return count;
	}
	
	//수정폼
	public PersonVo exeModifyForm(int no) {
		System.out.println("PhonebookService.exeModifyForm()");
		
		//PhonebookDao phonebookDao = new PhonebookDao();
		PersonVo personVo = phonebookDao.personSelectOne(no);
		
		return personVo;
	}
	
	//수정폼2
	public Map<String, Object> exeModifyForm2(int no) {
		System.out.println("PhonebookService.exeModifyForm2()");
		
		Map<String, Object> pMap = phonebookDao.personSelectOne2(no);
		
		return pMap;
	}
	
	//수정
	public int exeModify(PersonVo personVo) {
		System.out.println("PhonebookService.exeModify()");
		
		//PhonebookDao phonebookDao = new PhonebookDao();
		int count = phonebookDao.personUpdate(personVo);
		
		return count;
	}
	
}
