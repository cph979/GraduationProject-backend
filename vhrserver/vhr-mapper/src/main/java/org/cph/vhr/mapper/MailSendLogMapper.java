package org.cph.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.cph.vhr.model.MailSendLog;

import java.util.Date;
import java.util.List;

/**
 * @author cph
 * @date 2021/02/27
 */
public interface MailSendLogMapper {
	@Update("update mail_send_log set status = #{status} where msgId = #{msgId}")
	Integer updateMailSendLogStatus(@Param("msgId") String msgId, @Param("status") Integer status);

	Integer insertMailSendLog(MailSendLog mailSendLog);

	List<MailSendLog> listMailSendLogByStatus();

	@Update("update mail_send_log set count = count + 1, updateTime = #{date} where msgId = #{msgId}")
	Integer updateMainSendLogCount(@Param("msgId") String msgId, @Param("date") Date date);
}
