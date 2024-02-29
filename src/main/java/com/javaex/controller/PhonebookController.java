package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.PhonebookService;
import com.javaex.vo.PersonVo;

@Controller
public class PhonebookController {
	
	@Autowired
	private PhonebookService phonebookService;
	
	//수정폼
	@RequestMapping(value="/phone/modifyform", method= {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm(@RequestParam(value="no") int no, Model model) {
		System.out.println("PhonebookController.modifyForm()");
		
		//PhonebookService phonebookService = new PhonebookService();
		PersonVo personVo = phonebookService.exeModifyForm(no);
		
		model.addAttribute("personVo", personVo);
		
		return "modifyForm";
	}
	
	//수정폼2
	@RequestMapping(value="/phone/modifyform2", method= {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm2(@RequestParam(value="no") int no, Model model) {
		System.out.println("PhonebookController.modifyForm2()");
		
		Map<String, Object> pMap = phonebookService.exeModifyForm2(no);
		System.out.println(pMap);
		
		model.addAttribute("pMap", pMap);
		
		return "modifyForm2";
	}
	
	
	//localhost:8080/phonebook5/phone/write?name=
	@RequestMapping(value="/phone/write", method = {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute PersonVo personVo) {
		System.out.println("PhonebookController.write()");
		
		//PhonebookService phonebookService = new PhonebookService();
		phonebookService.exeWrite(personVo);
		
		return "redirect:/phone/list";
	}
	
	
	@RequestMapping(value="/phone/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("PhonebookController.list()");
		
		//spring @autowired가 알아서 제어(제어의 역전) Service 클래스에는 @Service써줘야함
		//PhonebookService phonebookService = new PhonebookService();
		
		List<PersonVo> personList = phonebookService.exeList();
		
		model.addAttribute("pList", personList);
	
		return "list";
	}
		
	
	//localhost:8080/phonebook5/phone/writeform
	@RequestMapping(value="/phone/writeform", method = {RequestMethod.POST, RequestMethod.GET})
	public String wirteForm() {
		System.out.println("PhonebookController.writeform()");
		
		return "writeForm";
	}
	
	
	//localhost:8080/phonebook5/phone/write?name=
	@RequestMapping(value="/phone/write2", method = {RequestMethod.GET, RequestMethod.POST})
	public String write2(@RequestParam(value="name") String name,
					  @RequestParam(value="hp") String hp,
					  @RequestParam(value="company") String company) {
		System.out.println("PhonebookController.write2()");
		
		System.out.println(name);
		System.out.println(hp);
		System.out.println(company);
		
		
		phonebookService.exeWrite2(name, hp, company);
		
		return "redirect:/phone/list";
	}
	
	
	@RequestMapping(value="/phone/modify", method= {RequestMethod.GET, RequestMethod.POST})
	public String modify(@ModelAttribute PersonVo personVo) {
		System.out.println("PhonebookController.modify()");
		
		System.out.println(personVo.toString());
		
		//PhonebookService phonebookService = new PhonebookService();
		phonebookService.exeModify(personVo);
		
		return "redirect:/phone/list";
	}
	
	@RequestMapping(value="/phone/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam(value="no") int no) {
		System.out.println("PhonebookController.delete()");
		System.out.println(no);
		
		//PhonebookService phonebookService = new PhonebookService();
		phonebookService.exeDelete(no);
		
		return "redirect:/phone/list";
	}
	

}
