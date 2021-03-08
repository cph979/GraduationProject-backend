package org.cph.vhr.model;

import java.util.Date;

/**
 * @author cph
 * @date 2021/02/27
 */
public class MailSendLog {
	/**
	 * 消息id
	 */
	private String msgId;
	/**
	 * 消息关联的员工id
	 */
	private Integer empId;
	/**
	 * 0 消息投递中
	 * 1 投递成功
	 * 2 投递失败
	 */
	private Integer status;
	private String routeKey;
	private String exchange;
	/**
	 * 重试次数
	 */
	private Integer count;
	/**
	 * 重试时间
	 */
	private Date tryTime;
	/**
	 * 消息创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRouteKey() {
		return routeKey;
	}

	public void setRouteKey(String routeKey) {
		this.routeKey = routeKey;
	}

	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Date getTryTime() {
		return tryTime;
	}

	public void setTryTime(Date tryTime) {
		this.tryTime = tryTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
