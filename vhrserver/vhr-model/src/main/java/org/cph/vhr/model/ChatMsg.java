package org.cph.vhr.model;

import java.util.Date;

/**
 * 消息对象
 *
 * @author cph
 * @date 2021/02/24
 */
public class ChatMsg {
	/**
	 * 消息从哪来，谁发的
	 */
	private String from;
	/**
	 * 消息要发往哪，发给谁
	 */
	private String to;
	/**
	 * 消息内容
	 */
	private String content;
	/**
	 * 消息时间
	 */
	private Date date;
	/**
	 * 中文用户名
	 */
	private String name;

	@Override
	public String toString() {
		return "ChatMsg{" +
				"from='" + from + '\'' +
				", to='" + to + '\'' +
				", content='" + content + '\'' +
				", date=" + date +
				'}';
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
