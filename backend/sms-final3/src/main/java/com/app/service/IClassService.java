package com.app.service;

import com.app.dto.AddClassDTO;

import com.app.entities.Class;

public interface IClassService {
	
	Class addClass(AddClassDTO acd);

}
