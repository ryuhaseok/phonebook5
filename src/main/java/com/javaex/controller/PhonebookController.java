package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhonebookDao;
import com.javaex.vo.PersonVo;

@Controller
public class PhonebookController {
	
	
	
	//localhost:8080/phonebook5/phone/writeform
	@RequestMapping(value="/phone/writeform", method = {RequestMethod.POST, RequestMethod.GET})
	public String wirteForm() {
		System.out.println("PhonebookController.writeform()");
		
		return "/WEB-INF/views/writeForm.jsp";
	}
	
	
	//localhost:8080/phonebook5/phone/write?name=
	@RequestMapping(value="/phone/write", method = {RequestMethod.GET, RequestMethod.POST})
	public String write(@RequestParam(value="name") String name,
					  @RequestParam(value="hp") String hp,
					  @RequestParam(value="company") String company) {
		System.out.println("PhonebookController.write()");
		
		System.out.println(name);
		System.out.println(hp);
		System.out.println(company);
		
		//vo로 묶기
		PersonVo personVo = new PersonVo(name, hp, company);
		
		//dao를 메모리에 올린다
		PhonebookDao phoneDao = new PhonebookDao();
		
		//dao.personInsert(vo) 저장한다
		phoneDao.personInsert(personVo);
		
		//리스트로 리다이렉트
		
		return "redirect:/phone/list";
	}
	
	//localhost:8080/phonebook5/phone/write?name=
	@RequestMapping(value="/phone/write2", method = {RequestMethod.GET, RequestMethod.POST})
	public String write2(@ModelAttribute PersonVo personVo) {
		System.out.println("PhonebookController.write2()");
		
		System.out.println(personVo.toString());
		
		
		//dao를 메모리에 올린다
		PhonebookDao phoneDao = new PhonebookDao();
		
		//dao.personInsert(vo) 저장한다
		phoneDao.personInsert(personVo);
		
		
		//리스트로 리다이렉트
		
		return "redirect:/phone/list";
	}
	
	
	@RequestMapping(value="/phone/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("PhonebookController.list()");
		
		PhonebookDao phonebookDao = new PhonebookDao();
		
		List<PersonVo> personList = phonebookDao.personSelect();
		//System.out.println(personList);
		
		model.addAttribute("pList", personList);
	
		return "/WEB-INF/views/list.jsp";
	}
	
	
	@RequestMapping(value="/phone/modifyform", method= {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm(@RequestParam(value="no") int no,
			                 Model model) {
		System.out.println("PhonebookController.modifyForm()");
		
		PhonebookDao phonebookDao = new PhonebookDao();
		PersonVo personVo = phonebookDao.personSelectOne(no);
		System.out.println(no);
		System.out.println(personVo);
		
		model.addAttribute("personVo", personVo);
		
		return "/WEB-INF/views/modifyForm.jsp";
	}
	
	@RequestMapping(value="/phone/modify", method= {RequestMethod.GET, RequestMethod.POST})
	public String modify(@ModelAttribute PersonVo personVo) {
		System.out.println("PhonebookController.modify()");
		
		System.out.println(personVo.toString());
		
		
		PhonebookDao phonebookDao = new PhonebookDao();
		phonebookDao.personUpdate(personVo);
		
		
		return "redirect:/phone/list";
	}
	
	@RequestMapping(value="/phone/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam(value="no") int no) {
		System.out.println("PhonebookController.delete()");
		System.out.println(no);
		
		PhonebookDao phoneDao = new PhonebookDao();
		phoneDao.personDelete(no);
		
		return "redirect:/phone/list";
	}
	

}
