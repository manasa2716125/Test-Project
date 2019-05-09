package com.hibernate.hib.test;

import com.hibernate.hib.dao.StudentDao;
import com.hibernate.hib.dto.StudentDto;

public class test {
	
public static void main(String[] args) {
	
	StudentDto dto = new StudentDto();
	dto.setName("Ram");
	dto.setPercentage(75.2);
	
	StudentDto dto2 = new StudentDto();
	dto2.setName("Raj");
	dto2.setPercentage(78.0);
	StudentDto dto0 = new StudentDto();
	dto0.setName("Rajj");
	dto0.setPercentage(78.0);
	
	StudentDao dao = new StudentDao();
	dao.save(dto);
	dao.save(dto2);
     // dao.delete(5);
	dao.update(3);

	dao.save(dto0);
	StudentDto dto3 = dao.read(5);
	System.out.println(dto0);
	dao.save(dto2);
	StudentDto dto4 = dao.read(5);
	System.out.println(dto2);
}
}
