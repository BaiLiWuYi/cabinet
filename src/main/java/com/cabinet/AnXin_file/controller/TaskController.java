package com.cabinet.AnXin_file.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cabinet.AnXin_file.define.ACK_CODE;
import com.cabinet.AnXin_file.define.TASK_OPT_RES;
import com.cabinet.AnXin_file.jEntity.CommonAckJEntity;
import com.cabinet.AnXin_file.jEntity.TaskDownAckJEntity;
import com.cabinet.AnXin_file.jEntity.TaskDownJEntity;
import com.cabinet.AnXin_file.service.LoginService;
import com.cabinet.AnXin_file.service.TaskService;

@Controller
@RequestMapping("/task")
public class TaskController {

	@Resource
	TaskService taskService;
	
	@ResponseBody
	@RequestMapping(value = "/down", method = RequestMethod.POST)
	public Object down(@RequestBody TaskDownJEntity task) {
		if (!LoginService.isLogined(task.getToken())) {
			return LoginService.commonTokenErrAckJEntity();
		}
				
		switch (taskService.addTask(task)) {
		case value:
			
			break;

		default:
			break;
		}
	}
	
}
