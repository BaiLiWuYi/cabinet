package com.cabinet.AnXin_file.service;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.cabinet.AnXin_file.beans.LoginInfo;
import com.cabinet.AnXin_file.dao.UserDao;
import com.cabinet.AnXin_file.define.ACK_CODE;
import com.cabinet.AnXin_file.entity.UserEntity;
import com.cabinet.AnXin_file.jEntity.CommonAckJEntity;
import com.infrastructure.utils.Sha256Encryption;
import com.infrastructure.utils.TimeRoutine;

@Service
public class LoginService {

	private static LinkedList<LoginInfo> logined;
	private static Logger log = Logger.getLogger(LoginService.class);
	
	public static void loadinit() {
		logined = new LinkedList<>();	
		
		log.info("LoginService loadinit.");
	}
	
	@Resource
	UserDao userDao;
	
	/**
	 * 
	 * @param count
	 * @param passwd
	 * @param loginTime
	 * @return
	 *  the token, null if login fail.
	 */
	public String doLogin(String count, String encryptedPasswd, String loginTime) {
		List<UserEntity> userRes = userDao.findUserByCount(count);
		if (userRes==null || userRes.size()==0) {
			log.info("count: "+ count+ " is not exist.");
			return null;
		}
		if (userRes.size() != 1) {
			log.info("count: "+ count+ "is not unique.");
			return null;
		}
		
		UserEntity user = userRes.get(0);
		String myEncryptedPasswd = Sha256Encryption.SHA256Encrypt(user.getPasswd()+loginTime);
		if (!myEncryptedPasswd.equals(encryptedPasswd)) {
			return null;
		}

		String token = myEncryptedPasswd;
		updateLoginInfo(user, token);
		return token;
	}

	/**
	 * 检测token是否有效
	 * @param token
	 * @return
	 */
	public static boolean isLogined(String token) {
		for (LoginInfo loginInfo : logined) {
			if (loginInfo.getToken().equals(token)) {
				return true;
			}
		}
		return false;
	}			
	
	public static CommonAckJEntity commonTokenErrAckJEntity() {
		return new CommonAckJEntity(ACK_CODE.TOKEN_ERR.getValue(), "token illegal.");
	}
	
	public int getTokenValidTime() {
		return 24*60;
	}
	
	private void updateLoginInfo(UserEntity user, String token) {
		for (LoginInfo loginInfo : logined) {
			if (!user.getCount().equals(loginInfo.getUser().getCount())) {
				continue;
			}			
			// refresh it, if exist.
			loginInfo.refresh(token, System.currentTimeMillis());
			log.info("count: "+ user.getCount()+ " refresh, at "+ TimeRoutine.getSysTimeInFormat());
			return;
		}
		logined.add(new LoginInfo(user, token, System.currentTimeMillis()));
		log.info("count: "+ user.getCount()+ " login, at "+ TimeRoutine.getSysTimeInFormat());
	}
	
}
