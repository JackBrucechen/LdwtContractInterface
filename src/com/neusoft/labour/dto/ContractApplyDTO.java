package com.neusoft.labour.dto;

import java.math.BigDecimal;

public class ContractApplyDTO {
	private static final long serialVersionUID = -4649708643289765936L;
	private String companyId;
	public String getcompanyId() {
		return companyId;
	}

	public void setcompanyId(String companyId) {
		this.companyId = companyId;
	}
	private String companyNumer;/*单位编号*/
	private String departmentid;/*部门ID*/
	private String aac001;/*个人编号*/
	private String name;/*姓名*/
	private String idCountry;/*国籍*/
	private String idType;/*证件类型*/
	private String idNumber;/*公民身份证号码*/
	private String sex;/*性别*/
	private Long birthday;/*出生日期*/
	private String educationLevel;/*文化程度*/
	private String nation;/*民族*/
	private String householdType;/*户籍种类（户口性质）*/
	private String householdState;/*户籍所在地行政区划代码*/
	private String migrantWorkers;/*农民工身份标识*/
	private Long workDate;/*初次参加工作年份（参加工作日期）*/
	private String policitalStatus;/*政治面貌*/
	private String mobile;/*手机号码*/
	private String contractid;/*合同编号*/
	private String aec007;/*用工形式*/
	private String aec102;/*合同类别（期限类型）（固定期限/无固定期限/以完成一定任务为期限）*/
	private String aec003;/*用工类别（订立劳动合同，形成事实劳动关系，劳务派遣人员，使用退休人员，本单位内退人员，兼职/外单位不在岗，离退休返聘人员，在校学生 其他）*/
	private String aca111;/*职业工种*/
	private String aca112;/*岗位名称*/
	private BigDecimal wages;/*工资*/
	private String workplace;/*工作地点*/
	private Long aae030;/*合同期限起始日期*/
	private Long aae031;/*合同期限终止日期*/
	private Long aec103;/*试用期起始日期 格式*/
	private Long aec104;/*试用期终止日期*/
	private String weekhours;/*周工作小时数*/
	private String target;/*工作目标*/
	private String dispatchOrgId;/*劳务派遣到此单位统一信用代码*/
	private String dispatchOrgName;/*劳务派遣到此单位名称*/
	private String schoolName;/*所在院校名称*/
	private String workingHoursSystem;/*工时制度*/
	private String address;/*现居住地址*/
	private String isSign;/*是否签订协议*/
	private String everydayHours;/*平均每天工作小时*/
	private String dispatchOrgRegtype;/**劳务派遣用工单位的经济类型*/
	private BigDecimal probationaryWages;/*试用期工资*/
	private Long dispatchBeginDate;/*劳务派遣起始日期*/
	private Long dispatchEndDate;/*劳务派遣终止日期*/
	private String isSignEmployee;/*是否办理招工手续*/
	
	

	public String getIsSignEmployee() {
		return isSignEmployee;
	}

	public void setIsSignEmployee(String isSignEmployee) {
		this.isSignEmployee = isSignEmployee;
	}

	/**
	 * @return the dispatchBeginDate
	 */
	public Long getDispatchBeginDate() {
		return dispatchBeginDate;
	}

	/**
	 * @param dispatchBeginDate the dispatchBeginDate to set
	 */
	public void setDispatchBeginDate(Long dispatchBeginDate) {
		this.dispatchBeginDate = dispatchBeginDate;
	}

	/**
	 * @return the dispatchEndDate
	 */
	public Long getDispatchEndDate() {
		return dispatchEndDate;
	}

	/**
	 * @param dispatchEndDate the dispatchEndDate to set
	 */
	public void setDispatchEndDate(Long dispatchEndDate) {
		this.dispatchEndDate = dispatchEndDate;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public BigDecimal getProbationaryWages() {
		return probationaryWages;
	}

	public void setProbationaryWages(BigDecimal probationaryWages) {
		this.probationaryWages = probationaryWages;
	}

	/**
	 * @return the isSign
	 */
	public String getIsSign() {
		return isSign;
	}
	
	/**
	 * @return the dispatchOrgRegtype
	 */
	public String getDispatchOrgRegtype() {
		return dispatchOrgRegtype;
	}

	/**
	 * @param dispatchOrgRegtype the dispatchOrgRegtype to set
	 */
	public void setDispatchOrgRegtype(String dispatchOrgRegtype) {
		this.dispatchOrgRegtype = dispatchOrgRegtype;
	}

	/**
	 * @param isSign the isSign to set
	 */
	public void setIsSign(String isSign) {
		this.isSign = isSign;
	}
	/**
	 * @return the everydayHours
	 */
	public String getEverydayHours() {
		return everydayHours;
	}
	/**
	 * @param everydayHours the everydayHours to set
	 */
	public void setEverydayHours(String everydayHours) {
		this.everydayHours = everydayHours;
	}
	/**
	 * @return the schoolName
	 */
	public String getSchoolName() {
		return schoolName;
	}
	/**
	 * @param schoolName the schoolName to set
	 */
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	/**
	 * @return the workingHoursSystem
	 */
	public String getWorkingHoursSystem() {
		return workingHoursSystem;
	}
	/**
	 * @param workingHoursSystem the workingHoursSystem to set
	 */
	public void setWorkingHoursSystem(String workingHoursSystem) {
		this.workingHoursSystem = workingHoursSystem;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the dispatchOrgId
	 */
	public String getDispatchOrgId() {
		return dispatchOrgId;
	}
	/**
	 * @param dispatchOrgId the dispatchOrgId to set
	 */
	public void setDispatchOrgId(String dispatchOrgId) {
		this.dispatchOrgId = dispatchOrgId;
	}
	/**
	 * @return the dispatchOrgName
	 */
	public String getDispatchOrgName() {
		return dispatchOrgName;
	}
	/**
	 * @param dispatchOrgName the dispatchOrgName to set
	 */
	public void setDispatchOrgName(String dispatchOrgName) {
		this.dispatchOrgName = dispatchOrgName;
	}
	public String getCompanyNumer() {
		return companyNumer;
	}
	public void setCompanyNumer(String companyNumer) {
		this.companyNumer = companyNumer;
	}
	public String getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(String departmentid) {
		this.departmentid = departmentid;
	}
	public String getAac001() {
		return aac001;
	}
	public void setAac001(String aac001) {
		this.aac001 = aac001;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdCountry() {
		return idCountry;
	}
	public void setIdCountry(String idCountry) {
		this.idCountry = idCountry;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Long getBirthday() {
		return birthday;
	}
	public void setBirthday(Long birthday) {
		this.birthday = birthday;
	}
	public String getEducationLevel() {
		return educationLevel;
	}
	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getHouseholdType() {
		return householdType;
	}
	public void setHouseholdType(String householdType) {
		this.householdType = householdType;
	}
	public String getHouseholdState() {
		return householdState;
	}
	public void setHouseholdState(String householdState) {
		this.householdState = householdState;
	}
	public String getMigrantWorkers() {
		return migrantWorkers;
	}
	public void setMigrantWorkers(String migrantWorkers) {
		this.migrantWorkers = migrantWorkers;
	}
	public Long getWorkDate() {
		return workDate;
	}
	public void setWorkDate(Long workDate) {
		this.workDate = workDate;
	}
	public String getPolicitalStatus() {
		return policitalStatus;
	}
	public void setPolicitalStatus(String policitalStatus) {
		this.policitalStatus = policitalStatus;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getContractid() {
		return contractid;
	}
	public void setContractid(String contractid) {
		this.contractid = contractid;
	}

	/**
	 * @return the aec007
	 */
	public String getAec007() {
		return aec007;
	}
	/**
	 * @param aec007 the aec007 to set
	 */
	public void setAec007(String aec007) {
		this.aec007 = aec007;
	}
	public String getAec102() {
		return aec102;
	}
	public void setAec102(String aec102) {
		this.aec102 = aec102;
	}
	public String getAec003() {
		return aec003;
	}
	public void setAec003(String aec003) {
		this.aec003 = aec003;
	}
	public String getAca111() {
		return aca111;
	}
	public void setAca111(String aca111) {
		this.aca111 = aca111;
	}
	public String getAca112() {
		return aca112;
	}
	public void setAca112(String aca112) {
		this.aca112 = aca112;
	}
	public BigDecimal getWages() {
		return wages;
	}
	public void setWages(BigDecimal wages) {
		this.wages = wages;
	}
	public String getWorkplace() {
		return workplace;
	}
	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}
	public Long getAae030() {
		return aae030;
	}
	public void setAae030(Long aae030) {
		this.aae030 = aae030;
	}
	public Long getAae031() {
		return aae031;
	}
	public void setAae031(Long aae031) {
		this.aae031 = aae031;
	}
	public Long getAec103() {
		return aec103;
	}
	public void setAec103(Long aec103) {
		this.aec103 = aec103;
	}
	public Long getAec104() {
		return aec104;
	}
	public void setAec104(Long aec104) {
		this.aec104 = aec104;
	}
	public String getWeekhours() {
		return weekhours;
	}
	public void setWeekhours(String weekhours) {
		this.weekhours = weekhours;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
}
