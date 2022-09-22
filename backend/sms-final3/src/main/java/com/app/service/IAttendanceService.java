package com.app.service;

import java.util.List;

import com.app.dto.ClassStudIdDTO;
import com.app.dto.ViewAttendanceDTO;
import com.app.dto.ViewMarksDTO;

public interface IAttendanceService {

	List<ViewAttendanceDTO> viewAttendance(ClassStudIdDTO csd);
}
