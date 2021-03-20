package org.cph.vhr.model;

/**
 * 工资详情
 *
 * @author cph
 * @date 2021/03/19
 */
public class SalaryTable {
	private Integer id;

	/**
	 * 员工id
	 */
	private Integer eid;

	/**
	 * 工资账套id
	 */
	private Integer sid;

	/**
	 * 基本工资
	 */
	private Integer basicSalary;

	/**
	 * 奖金
	 */
	private Integer bonus;

	/**
	 * 午餐补助
	 */
	private Integer lunchSalary;

	/**
	 * 交通补助
	 */
	private Integer trafficSalary;

	/**
	 * 总工资
	 */
	private Float allSalary;

	private Employee employee;

	private Salary salary;

	public SalaryTable() {
	}

	public SalaryTable(Integer id, Integer eid, Integer sid, Integer basicSalary, Integer bonus, Integer lunchSalary, Integer trafficSalary, Float allSalary) {
		this.id = id;
		this.eid = eid;
		this.sid = sid;
		this.basicSalary = basicSalary;
		this.bonus = bonus;
		this.lunchSalary = lunchSalary;
		this.trafficSalary = trafficSalary;
		this.allSalary = allSalary;
	}

	@Override
	public String toString() {
		return "SalaryTable{" +
				"id=" + id +
				", eid=" + eid +
				", sid=" + sid +
				", basicSalary=" + basicSalary +
				", bonus=" + bonus +
				", lunchSalary=" + lunchSalary +
				", trafficSalary=" + trafficSalary +
				", allSalary=" + allSalary +
				", employee=" + employee +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Integer getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(Integer basicSalary) {
		this.basicSalary = basicSalary;
	}

	public Integer getBonus() {
		return bonus;
	}

	public void setBonus(Integer bonus) {
		this.bonus = bonus;
	}

	public Integer getLunchSalary() {
		return lunchSalary;
	}

	public void setLunchSalary(Integer lunchSalary) {
		this.lunchSalary = lunchSalary;
	}

	public Integer getTrafficSalary() {
		return trafficSalary;
	}

	public void setTrafficSalary(Integer trafficSalary) {
		this.trafficSalary = trafficSalary;
	}

	public Float getAllSalary() {
		return allSalary;
	}

	public void setAllSalary(Float allSalary) {
		this.allSalary = allSalary;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}
}
