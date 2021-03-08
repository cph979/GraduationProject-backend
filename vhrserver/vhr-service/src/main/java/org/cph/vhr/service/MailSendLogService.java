package org.cph.vhr.service;

import org.cph.vhr.mapper.MailSendLogMapper;
import org.cph.vhr.model.MailSendLog;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author cph
 * @date 2021/02/27
 */
@Service
public class MailSendLogService {
	@Resource
	MailSendLogMapper mailSendLogMapper;

	public Integer updateMailSendLogStatus(String msgId, Integer status) {
		return mailSendLogMapper.updateMailSendLogStatus(msgId, status);
	}

	public Integer insertMailSendLog(MailSendLog mailSendLog) {
		return mailSendLogMapper.insertMailSendLog(mailSendLog);
	}

	public List<MailSendLog> listMailSendLogByStatus() {
		return mailSendLogMapper.listMailSendLogByStatus();
	}

	public Integer updateMainSendLogCount(String msgId, Date date) {
		return mailSendLogMapper.updateMainSendLogCount(msgId, date);
	}
}
