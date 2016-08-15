package com.cabinet.AnXin_file.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cabinet.AnXin_file.define.ACK_CODE;
import com.cabinet.AnXin_file.jEntity.CommonAckJEntity;
import com.cabinet.AnXin_file.jEntity.LoginAckJEntity;
import com.cabinet.AnXin_file.jEntity.LoginJEntity;
import com.cabinet.AnXin_file.service.LoginService;

@Controller
public class LoginController {

	@Resource
	LoginService loginService;
	
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Object doLogin(@RequestBody LoginJEntity loginInfo) {
		String token = loginService.doLogin(loginInfo.getCount(), loginInfo.getPasswd(), loginInfo.getLoginTime());
		if (token == null) {
			return new CommonAckJEntity(ACK_CODE.ERR.getValue(), "login fail.");
		}		
		return new LoginAckJEntity(ACK_CODE.OK.getValue(), "success", token, loginService.getTokenValidTime());
	}
	
}
