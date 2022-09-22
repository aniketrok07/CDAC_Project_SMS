package com.app.service;

import java.util.List;

import com.app.dto.AddMarksDTO;
import com.app.dto.ClassStudIdDTO;
import com.app.dto.ViewMarksDTO;
import com.app.entities.Marks;

public interface IMarksService {

	Marks addMarks(AddMarksDTO amd);
	
	List<ViewMarksDTO> viewMarks(ClassStudIdDTO csd);
}
