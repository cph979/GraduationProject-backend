(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-32db800e"],{"58da":function(e,t,i){"use strict";i.r(t);var a=function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",[i("div",[i("div",{staticStyle:{display:"flex","justify-content":"space-between"}},[i("div",[i("el-input",{staticStyle:{width:"350px","margin-right":"10px"},attrs:{disabled:e.searchView,clearable:"",placeholder:"输入员工名回车搜索员工","prefix-icon":"el-icon-search"},on:{clear:e.initEmp},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.searchEmpByName(t)}},model:{value:e.name,callback:function(t){e.name=t},expression:"name"}}),i("el-button",{attrs:{type:"primary",icon:"el-icon-search",disabled:e.searchView},on:{click:e.initEmp}},[e._v("搜索")]),i("el-button",{attrs:{type:"primary"},on:{click:function(t){e.searchView=!e.searchView}}},[i("i",{class:e.searchView?"fa fa-angle-double-up":"fa fa-angle-double-down"}),e._v("高级搜索")])],1),i("div",[i("el-upload",{staticStyle:{display:"inline-flex","margin-right":"10px"},attrs:{"before-upload":e.beforeUpload,"on-success":e.onSuccess,"on-error":e.onError,"show-file-list":!1,action:"/employee/basic/import"}},[i("el-button",{attrs:{type:"success",icon:e.importDataBtnIcon,disabled:e.importDataDisabled}},[e._v(e._s(e.importDataBtnText))])],1),i("el-button",{attrs:{type:"success",icon:"el-icon-download"},on:{click:e.exportData}},[e._v("导出数据")]),i("el-button",{attrs:{type:"primary",icon:"el-icon-plus"},on:{click:e.showAddEmpView}},[e._v("添加用户")])],1)]),i("transition",{attrs:{name:"fade"}},[i("div",{directives:[{name:"show",rawName:"v-show",value:e.searchView,expression:"searchView"}],staticStyle:{border:"1px solid #409eff","border-radius":"5px","box-sizing":"border-box",padding:"5px",margin:"10px 0"}},[i("el-row",[i("el-col",{attrs:{span:5}},[e._v(" 政治面貌: "),i("el-select",{staticStyle:{width:"130px"},attrs:{placeholder:"政治面貌",size:"mini"},model:{value:e.searchCondition.politicId,callback:function(t){e.$set(e.searchCondition,"politicId",t)},expression:"searchCondition.politicId"}},e._l(e.politicsStatus,(function(e){return i("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})})),1)],1),i("el-col",{attrs:{span:4}},[e._v(" 民族: "),i("el-select",{staticStyle:{width:"130px"},attrs:{placeholder:"民族",size:"mini"},model:{value:e.searchCondition.nationId,callback:function(t){e.$set(e.searchCondition,"nationId",t)},expression:"searchCondition.nationId"}},e._l(e.nations,(function(e){return i("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})})),1)],1),i("el-col",{attrs:{span:4}},[e._v(" 职位: "),i("el-select",{staticStyle:{width:"130px"},attrs:{placeholder:"职位",size:"mini"},model:{value:e.searchCondition.posId,callback:function(t){e.$set(e.searchCondition,"posId",t)},expression:"searchCondition.posId"}},e._l(e.positions,(function(e){return i("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})})),1)],1),i("el-col",{attrs:{span:4}},[e._v(" 职称: "),i("el-select",{staticStyle:{width:"130px"},attrs:{placeholder:"职称",size:"mini"},model:{value:e.searchCondition.jobLevelId,callback:function(t){e.$set(e.searchCondition,"jobLevelId",t)},expression:"searchCondition.jobLevelId"}},e._l(e.jobLevels,(function(e){return i("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})})),1)],1),i("el-col",{attrs:{span:7}},[e._v(" 聘用形式: "),i("el-radio-group",{model:{value:e.searchCondition.engageForm,callback:function(t){e.$set(e.searchCondition,"engageForm",t)},expression:"searchCondition.engageForm"}},[i("el-radio",{attrs:{label:"劳动合同"}},[e._v("劳动合同")]),i("el-radio",{attrs:{label:"劳务合同"}},[e._v("劳务合同")])],1)],1)],1),i("el-row",{staticStyle:{"margin-top":"10px"}},[i("el-col",{staticStyle:{display:"flex","align-items":"center"},attrs:{span:5}},[e._v(" 所属部门: "),i("el-popover",{attrs:{placement:"right",title:"选择部门",width:"200",trigger:"manual"},model:{value:e.deptTreeVisible,callback:function(t){e.deptTreeVisible=t},expression:"deptTreeVisible"}},[i("el-tree",{attrs:{data:e.departments,props:e.defaultProps,"default-expand-all":""},on:{"node-click":e.searchHandleNodeClick}}),i("div",{staticStyle:{width:"130px",display:"inline-flex","font-size":"13px",border:"1px solid #dedede",height:"26px","border-radius":"5px",cursor:"pointer","align-items":"center","padding-left":"15px","box-sizing":"border-box","margin-left":"3px"},attrs:{slot:"reference"},domProps:{textContent:e._s(e.deptTxt)},on:{click:function(t){e.deptTreeVisible=!e.deptTreeVisible}},slot:"reference"})],1)],1),i("el-col",{attrs:{span:10}},[e._v(" 入职日期: "),i("el-date-picker",{attrs:{size:"mini",type:"daterange","value-format":"yyyy-MM-dd","range-separator":"至","start-placeholder":"开始日期","end-placeholder":"结束日期"},model:{value:e.searchCondition.beginDateScope,callback:function(t){e.$set(e.searchCondition,"beginDateScope",t)},expression:"searchCondition.beginDateScope"}})],1),i("el-col",{attrs:{span:4,offset:5}},[i("el-button",{attrs:{size:"mini"},on:{click:e.advancedCancel}},[e._v("取消")]),i("el-button",{attrs:{type:"primary",icon:"el-icon-search",size:"mini"},on:{click:function(t){return e.initEmp("advanced")}}},[e._v("搜索")])],1)],1)],1)])],1),i("div",{staticStyle:{"margin-top":"10px"}},[i("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],staticStyle:{width:"100%"},attrs:{"header-cell-style":{textAlign:"center"},"cell-style":{textAlign:"center"},data:e.emps,stripe:"",border:""},on:{"selection-change":e.handleSelectionChange}},[i("el-table-column",{attrs:{type:"selection",width:"55"}}),i("el-table-column",{attrs:{prop:"name",fixed:"",label:"姓名",width:"90"}}),i("el-table-column",{attrs:{prop:"workID",label:"工号",width:"85"}}),i("el-table-column",{attrs:{prop:"gender",label:"性别",width:"60"}}),i("el-table-column",{attrs:{prop:"birthday",width:"95",label:"出生日期"}}),i("el-table-column",{attrs:{prop:"idCard",width:"150",label:"身份证号码"}}),i("el-table-column",{attrs:{prop:"wedlock",width:"70",label:"婚姻状况"}}),i("el-table-column",{attrs:{prop:"nation.name",width:"60",label:"民族"}}),i("el-table-column",{attrs:{prop:"nativePlace",width:"80",label:"籍贯"}}),i("el-table-column",{attrs:{prop:"politicsstatus.name",width:"100",label:"政治面貌"}}),i("el-table-column",{attrs:{prop:"email",width:"180",label:"电子邮件"}}),i("el-table-column",{attrs:{prop:"phone",width:"100",label:"电话号码"}}),i("el-table-column",{attrs:{prop:"address",width:"220",label:"联系地址"}}),i("el-table-column",{attrs:{prop:"department.name",width:"100",label:"所属部门"}}),i("el-table-column",{attrs:{prop:"position.name",width:"100",label:"职位"}}),i("el-table-column",{attrs:{prop:"jobLevel.name",width:"100",label:"职称"}}),i("el-table-column",{attrs:{prop:"engageForm",width:"100",label:"聘用形式"}}),i("el-table-column",{attrs:{prop:"tiptopDegree",width:"80",label:"最高学历"}}),i("el-table-column",{attrs:{prop:"specialty",width:"130",label:"专业"}}),i("el-table-column",{attrs:{prop:"school",width:"120",label:"毕业院校"}}),i("el-table-column",{attrs:{prop:"workState",width:"80",label:"在职状态"}}),i("el-table-column",{attrs:{prop:"beginDate",width:"95",label:"入职日期"}}),i("el-table-column",{attrs:{prop:"conversionTime",width:"95",label:"转正日期"}}),i("el-table-column",{attrs:{prop:"beginContract",width:"95",label:"合同起始日期"}}),i("el-table-column",{attrs:{prop:"endContract",width:"95",label:"合同终止日期"}}),i("el-table-column",{attrs:{width:"100",label:"合同期限(年)"},scopedSlots:e._u([{key:"default",fn:function(t){return[i("el-tag",[e._v(e._s(t.row.contractTerm))]),e._v(" 年 ")]}}])}),i("el-table-column",{attrs:{fixed:"right",width:"100",label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[i("el-button",{staticStyle:{padding:"3px"},on:{click:function(i){return e.showEditEmpView(t.row)}}},[e._v("编辑")]),i("el-button",{staticStyle:{padding:"3px"},attrs:{type:"danger"},on:{click:function(i){return e.deleteEmp(t.row)}}},[e._v("删除 ")])]}}])})],1),i("div",{staticStyle:{display:"flex","justify-content":"space-between","margin-top":"10px"}},[i("el-button",{attrs:{type:"danger",disabled:0==e.multipleSelection.length},on:{click:e.delEmployees}},[e._v("批量删除")]),i("el-pagination",{staticStyle:{display:"flex","justify-content":"flex-end"},attrs:{background:"",layout:"prev, pager, next, sizes, total",total:e.total,"page-sizes":[10,20,30,40],"page-size":10},on:{"current-change":e.handleCurrentChange,"size-change":e.handleSizeChange}})],1)],1),i("el-dialog",{attrs:{"close-on-click-modal":!1,"before-close":e.handleClose,title:e.title,visible:e.dialogVisible,width:"80%"},on:{"update:visible":function(t){e.dialogVisible=t}}},[i("div",[i("el-form",{ref:"empForm",attrs:{model:e.emp,rules:e.rules}},[i("el-row",[i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"姓名:",prop:"name"}},[i("el-input",{staticStyle:{width:"150px"},attrs:{"prefix-icon":"el-icon-edit",clearable:"",placeholder:"输入员工姓名"},model:{value:e.emp.name,callback:function(t){e.$set(e.emp,"name",t)},expression:"emp.name"}})],1)],1),i("el-col",{attrs:{span:5}},[i("el-form-item",{attrs:{label:"性别:",prop:"gender"}},[i("el-radio-group",{model:{value:e.emp.gender,callback:function(t){e.$set(e.emp,"gender",t)},expression:"emp.gender"}},[i("el-radio",{attrs:{label:"男"}},[e._v("男")]),i("el-radio",{attrs:{label:"女"}},[e._v("女")])],1)],1)],1),i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"出生日期:",prop:"birthday"}},[i("el-date-picker",{staticStyle:{width:"170px"},attrs:{type:"date",placeholder:"选择日期"},model:{value:e.emp.birthday,callback:function(t){e.$set(e.emp,"birthday",t)},expression:"emp.birthday"}})],1)],1),i("el-col",{attrs:{span:7}},[i("el-form-item",{attrs:{label:"政治面貌:",prop:"politicId"}},[i("el-select",{staticStyle:{width:"200px"},attrs:{placeholder:"选择政治面貌"},model:{value:e.emp.politicId,callback:function(t){e.$set(e.emp,"politicId",t)},expression:"emp.politicId"}},e._l(e.politicsStatus,(function(e){return i("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})})),1)],1)],1)],1),i("el-row",[i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"民族:",prop:"nationId"}},[i("el-select",{staticStyle:{width:"150px"},attrs:{placeholder:"选择民族"},model:{value:e.emp.nationId,callback:function(t){e.$set(e.emp,"nationId",t)},expression:"emp.nationId"}},e._l(e.nations,(function(e){return i("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})})),1)],1)],1),i("el-col",{attrs:{span:5}},[i("el-form-item",{attrs:{label:"籍贯:",prop:"nativePlace"}},[i("el-input",{staticStyle:{width:"150px"},attrs:{clearable:"","prefix-icon":"el-icon-edit",placeholder:"输入籍贯"},model:{value:e.emp.nativePlace,callback:function(t){e.$set(e.emp,"nativePlace",t)},expression:"emp.nativePlace"}})],1)],1),i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"电子邮箱:",prop:"email"}},[i("el-input",{staticStyle:{width:"170px"},attrs:{clearable:"","prefix-icon":"el-icon-message",placeholder:"输入邮箱"},model:{value:e.emp.email,callback:function(t){e.$set(e.emp,"email",t)},expression:"emp.email"}})],1)],1),i("el-col",{attrs:{span:7}},[i("el-form-item",{attrs:{label:"联系地址:",prop:"address"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{clearable:"","prefix-icon":"el-icon-edit",placeholder:"输入联系地址"},model:{value:e.emp.address,callback:function(t){e.$set(e.emp,"address",t)},expression:"emp.address"}})],1)],1)],1),i("el-row",[i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"职位:",prop:"posId"}},[i("el-select",{staticStyle:{width:"150px"},attrs:{placeholder:"选择职位"},model:{value:e.emp.posId,callback:function(t){e.$set(e.emp,"posId",t)},expression:"emp.posId"}},e._l(e.positions,(function(e){return i("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})})),1)],1)],1),i("el-col",{attrs:{span:5}},[i("el-form-item",{attrs:{label:"职称:",prop:"jobLevelId"}},[i("el-select",{staticStyle:{width:"150px"},attrs:{placeholder:"选择职称"},model:{value:e.emp.jobLevelId,callback:function(t){e.$set(e.emp,"jobLevelId",t)},expression:"emp.jobLevelId"}},e._l(e.jobLevels,(function(e){return i("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})})),1)],1)],1),i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"所属部门:",prop:"departmentId"}},[i("el-popover",{attrs:{placement:"right",title:"选择部门",width:"200",trigger:"manual"},model:{value:e.visible,callback:function(t){e.visible=t},expression:"visible"}},[i("el-tree",{attrs:{data:e.departments,props:e.defaultProps,"default-expand-all":""},on:{"node-click":e.handleNodeClick}}),i("div",{staticStyle:{width:"170px",display:"inline-flex","font-size":"13px",border:"1px solid #dedede",height:"32px","border-radius":"5px",cursor:"pointer","align-items":"center","padding-left":"15px","box-sizing":"border-box"},attrs:{slot:"reference"},domProps:{textContent:e._s(e.deptTxt)},on:{click:function(t){e.visible=!e.visible}},slot:"reference"})],1)],1)],1),i("el-col",{attrs:{span:7}},[i("el-form-item",{attrs:{label:"电话号码:",prop:"phone"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{clearable:"","prefix-icon":"el-icon-phone",placeholder:"输入电话号码"},model:{value:e.emp.phone,callback:function(t){e.$set(e.emp,"phone",t)},expression:"emp.phone"}})],1)],1)],1),i("el-row",[i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"工号:",prop:"workID"}},[i("el-input",{staticStyle:{width:"150px"},attrs:{disabled:"","prefix-icon":"el-icon-edit"},model:{value:e.emp.workID,callback:function(t){e.$set(e.emp,"workID",t)},expression:"emp.workID"}})],1)],1),i("el-col",{attrs:{span:5}},[i("el-form-item",{attrs:{label:"学历:",prop:"tiptopDegree"}},[i("el-select",{staticStyle:{width:"150px"},attrs:{placeholder:"选择学历"},model:{value:e.emp.tiptopDegree,callback:function(t){e.$set(e.emp,"tiptopDegree",t)},expression:"emp.tiptopDegree"}},e._l(e.tiptopDegrees,(function(e,t){return i("el-option",{key:t,attrs:{label:e,value:e}})})),1)],1)],1),i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"毕业院校:",prop:"school"}},[i("el-input",{staticStyle:{width:"170px"},attrs:{clearable:"","prefix-icon":"el-icon-edit",placeholder:"输入学校"},model:{value:e.emp.school,callback:function(t){e.$set(e.emp,"school",t)},expression:"emp.school"}})],1)],1),i("el-col",{attrs:{span:7}},[i("el-form-item",{attrs:{label:"专业名称:",prop:"specialty"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{clearable:"","prefix-icon":"el-icon-edit",placeholder:"输入专业"},model:{value:e.emp.specialty,callback:function(t){e.$set(e.emp,"specialty",t)},expression:"emp.specialty"}})],1)],1)],1),i("el-row",[i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"入职日期:",prop:"beginDate"}},[i("el-date-picker",{staticStyle:{width:"130px"},attrs:{type:"date",placeholder:"选择日期"},model:{value:e.emp.beginDate,callback:function(t){e.$set(e.emp,"beginDate",t)},expression:"emp.beginDate"}})],1)],1),i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"转正日期:",prop:"conversionTime"}},[i("el-date-picker",{staticStyle:{width:"130px"},attrs:{type:"date",placeholder:"选择日期"},model:{value:e.emp.conversionTime,callback:function(t){e.$set(e.emp,"conversionTime",t)},expression:"emp.conversionTime"}})],1)],1),i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"合同开始日期:",prop:"beginContract"}},[i("el-date-picker",{staticStyle:{width:"130px"},attrs:{type:"date",placeholder:"选择日期"},model:{value:e.emp.beginContract,callback:function(t){e.$set(e.emp,"beginContract",t)},expression:"emp.beginContract"}})],1)],1),i("el-col",{attrs:{span:6}},[i("el-form-item",{attrs:{label:"合同终止日期:",prop:"endContract"}},[i("el-date-picker",{staticStyle:{width:"130px"},attrs:{type:"date",placeholder:"选择日期"},model:{value:e.emp.endContract,callback:function(t){e.$set(e.emp,"endContract",t)},expression:"emp.endContract"}})],1)],1)],1),i("el-row",[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"身份证号码:",prop:"idCard"}},[i("el-input",{staticStyle:{width:"195px"},attrs:{clearable:"","prefix-icon":"el-icon-edit",placeholder:"输入身份证号码"},model:{value:e.emp.idCard,callback:function(t){e.$set(e.emp,"idCard",t)},expression:"emp.idCard"}})],1)],1),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"聘用形式:",prop:"engageForm"}},[i("el-radio-group",{staticStyle:{"margin-top":"10px"},model:{value:e.emp.engageForm,callback:function(t){e.$set(e.emp,"engageForm",t)},expression:"emp.engageForm"}},[i("el-radio",{attrs:{label:"劳动合同"}},[e._v("劳动合同")]),i("el-radio",{attrs:{label:"劳务合同"}},[e._v("劳务合同")])],1)],1)],1),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"婚姻状况:",prop:"wedlock"}},[i("el-radio-group",{staticStyle:{"margin-top":"10px"},model:{value:e.emp.wedlock,callback:function(t){e.$set(e.emp,"wedlock",t)},expression:"emp.wedlock"}},[i("el-radio",{attrs:{label:"已婚"}},[e._v("已婚")]),i("el-radio",{attrs:{label:"未婚"}},[e._v("未婚")]),i("el-radio",{attrs:{label:"离异"}},[e._v("离异")])],1)],1)],1)],1)],1)],1),i("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{on:{click:e.clearValidatesMethod}},[e._v("取 消")]),i("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.submitForm("empForm")}}},[e._v("确 定")])],1)])],1)},l=[],n=(i("4160"),i("b0c0"),i("498a"),i("159b"),{name:"EmpBasic",data:function(){return{searchView:!1,deptTreeVisible:!1,searchCondition:{politicId:null,nationId:null,posId:null,jobLevelId:null,engageForm:"",departmentId:null,beginDateScope:""},deptTxt:"所属部门",defaultProps:{children:"children",label:"name"},visible:!1,loading:!1,importDataBtnText:"导入数据",importDataBtnIcon:"el-icon-upload2",importDataDisabled:!1,name:"",emps:[],departments:[],politicsStatus:[],nations:[],positions:[],jobLevels:[],tiptopDegrees:["博士","硕士","本科","大专","高中","初中","小学"],emp:{name:"cph",workID:"00000957",gender:"男",birthday:"1997-09-13",idCard:"320928199709130031",wedlock:"已婚",nationId:1,nativePlace:"江苏盐城",politicId:13,email:"cph979@qq.com",phone:"17625958586",address:"南京市江宁区",departmentId:null,jobLevelId:9,posId:55,engageForm:"劳务合同",tiptopDegree:"本科",specialty:"信息安全",school:"南京大学",beginDate:"2017-12-31",conversionTime:"2018-03-31",beginContract:"2017-12-31",endContract:"2019-12-31"},total:0,page:1,size:10,multipleSelection:[],dialogVisible:!1,title:"",rules:{name:[{required:!0,message:"请输入姓名",trigger:"blur"}],gender:[{required:!0,message:"请选择性别",trigger:"blur"}],birthday:[{required:!0,message:"请选择出生日期",trigger:"blur"}],politicId:[{required:!0,message:"请选择政治面貌",trigger:"blur"}],nationId:[{required:!0,message:"请选择民族",trigger:"blur"}],nativePlace:[{required:!0,message:"请输入籍贯",trigger:"blur"}],email:[{required:!0,message:"请输入邮箱",trigger:"blur"},{type:"email",message:"邮箱地址格式错误",trigger:"blur"}],address:[{required:!0,message:"请输入联系地址",trigger:"blur"}],posId:[{required:!0,message:"请选择职位",trigger:"blur"}],jobLevelId:[{required:!0,message:"请选择职称",trigger:"blur"}],departmentId:[{required:!0,message:"请选择所属部门",trigger:"blur"}],phone:[{required:!0,message:"请输入电话号码",trigger:"blur"},{pattern:/(^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\d{8}$)/,message:"电话号码格式错误",trigger:"blur"}],workID:[{required:!0,message:"",trigger:"blur"}],tiptopDegree:[{required:!0,message:"请选择学历",trigger:"blur"}],school:[{required:!0,message:"请输入毕业院校",trigger:"blur"}],specialty:[{required:!0,message:"请输入专业名称",trigger:"blur"}],beginDate:[{required:!0,message:"请选择入职日期",trigger:"blur"}],conversionTime:[{required:!0,message:"请选择转正日期",trigger:"blur"}],beginContract:[{required:!0,message:"请选择合同开始日期",trigger:"blur"}],endContract:[{required:!0,message:"请选择合同终止日期",trigger:"blur"}],idCard:[{required:!0,message:"请输入身份证号码",trigger:"blur"},{pattern:/(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{4}$)/,message:"身份证号码格式错误",trigger:"blur"}],engageForm:[{required:!0,message:"请选择聘用形式",trigger:"blur"}],wedlock:[{required:!0,message:"请选择婚姻状况",trigger:"blur"}]}}},mounted:function(){this.initEmp(),this.initPoliticsStatus(),this.initNations(),this.initPositions(),this.initJobLevels(),this.initDepartments()},methods:{empInit:function(){this.searchView?this.initEmp("advanced"):this.initEmp()},advancedCancel:function(){this.searchView=!this.searchView,this.searchCondition={politicId:null,nationId:null,posId:null,jobLevelId:null,engageForm:"",departmentId:null,beginDateScope:""},this.initEmp()},searchHandleNodeClick:function(e){this.deptTxt=e.name,this.searchCondition.departmentId=e.id,this.deptTreeVisible=!this.deptTreeVisible},handleNodeClick:function(e){this.deptTxt=e.name,this.emp.departmentId=e.id,this.visible=!this.visible},beforeUpload:function(){this.importDataBtnText="正在上传",this.importDataBtnIcon="el-icon-loading",this.importDataDisabled=!0},onSuccess:function(e){this.importDataBtnText="导入数据",this.importDataBtnIcon="el-icon-upload2",this.importDataDisabled=!1,200==e.status?this.$message({showClose:!0,message:"导入成功",type:"success",duration:2e3}):this.$message({showClose:!0,message:"导入失败",type:"error",duration:2e3}),this.initEmp()},onError:function(){this.importDataBtnText="导入数据",this.importDataBtnIcon="el-icon-upload2",this.importDataDisabled=!1},handleClose:function(){this.clearValidatesMethod()},clearValidatesMethod:function(){this.dialogVisible=!1,this.$refs.empForm.clearValidate()},submitForm:function(e){var t=this;this.emp.id?this.$refs[e].validate((function(e){e&&t.putRequest("/employee/basic",t.emp).then((function(e){e&&(t.dialogVisible=!1,t.empInit())}))})):this.$refs[e].validate((function(e){e&&t.postRequest("/employee/basic",t.emp).then((function(e){e&&(t.dialogVisible=!1,t.empInit())}))}))},getMaxWorkId:function(){var e=this;this.getRequest("employee/basic/maxWorkID").then((function(t){e.emp.workID=t.obj}))},emptyEmp:function(){this.emp={name:"",gender:"",birthday:"",idCard:"",wedlock:"",nationId:null,nativePlace:"",politicId:null,email:"",phone:"",address:"",departmentId:null,jobLevelId:null,posId:null,engageForm:"",tiptopDegree:"",specialty:"",school:"",beginDate:"",workID:"",conversionTime:"",notworkDate:null,beginContract:"",endContract:""},this.deptTxt=""},initDepartments:function(){var e=this;this.getRequest("system/basic/department").then((function(t){e.departments=t}))},initJobLevels:function(){var e=this;this.getRequest("employee/basic/jobLevels?enabled=true").then((function(t){e.jobLevels=t}))},initPositions:function(){var e=this;this.getRequest("employee/basic/positions?enabled=true").then((function(t){e.positions=t}))},initNations:function(){var e=this;window.sessionStorage.getItem("nation")?this.nations=JSON.parse(window.sessionStorage.getItem("nation")):this.getRequest("employee/basic/nations").then((function(t){e.nations=t,window.sessionStorage.setItem("nation",JSON.stringify(t))}))},initPoliticsStatus:function(){var e=this;window.sessionStorage.getItem("politicsStatus")?this.politicsStatus=JSON.parse(window.sessionStorage.getItem("politicsStatus")):this.getRequest("employee/basic/politicsStatus").then((function(t){e.politicsStatus=t,window.sessionStorage.setItem("politicsStatus",JSON.stringify(t))}))},showAddEmpView:function(){this.dialogVisible=!0,this.title="添加员工",this.getMaxWorkId(),this.emptyEmp()},showEditEmpView:function(e){this.dialogVisible=!0,this.title="编辑员工信息",this.deptTxt=e.department.name,Object.assign(this.emp,e)},delEmployees:function(){var e=this;this.$confirm("此操作将永久删除 [ "+this.multipleSelection.length+" ] 条记录，是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){var t=[];e.multipleSelection.forEach((function(e){t.push(e.id)})),e.deleteRequestData("/employee/basic",t).then((function(t){t&&e.empInit()}))})).catch((function(){}))},handleSelectionChange:function(e){this.multipleSelection=e},exportData:function(){window.open("/employee/basic/export","_parent")},deleteEmp:function(e){var t=this;this.$confirm("此操作将永久删除 [ "+e.name+" ] ，是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){t.deleteRequest("/employee/basic/"+e.id).then((function(e){e&&t.empInit()}))})).catch((function(){}))},handleSizeChange:function(e){this.size=e,this.empInit()},handleCurrentChange:function(e){this.page=e,this.empInit()},searchEmpByName:function(){this.name.trim(),this.initEmp()},initEmp:function(e){var t=this;this.loading=!0;var i="/employee/basic?page="+this.page+"&size="+this.size;e&&"advanced"==e?(this.searchCondition.politicId&&(i+="&politicId="+this.searchCondition.politicId),this.searchCondition.nationId&&(i+="&nationId="+this.searchCondition.nationId),this.searchCondition.posId&&(i+="&posId="+this.searchCondition.posId),this.searchCondition.jobLevelId&&(i+="&jobLevelId="+this.searchCondition.jobLevelId),this.searchCondition.engageForm&&(i+="&engageForm="+this.searchCondition.engageForm),this.searchCondition.departmentId&&(i+="&departmentId="+this.searchCondition.departmentId),this.searchCondition.beginDateScope&&(i+="&beginDateScope="+this.searchCondition.beginDateScope)):i+="&name="+this.name,this.getRequest(i).then((function(e){t.loading=!1,e&&(t.emps=e.data,t.total=e.total)}))}},watch:{total:function(){this.total==(this.page-1)*this.size&&0!=this.total&&(this.page-=1,this.initEmp())}}}),o=n,s=(i("ec21"),i("2877")),r=Object(s["a"])(o,a,l,!1,null,null,null);t["default"]=r.exports},8759:function(e,t,i){"use strict";i.r(t);var a=function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",[e._v(" 高级资料 ")])},l=[],n={name:"EmpAdv"},o=n,s=i("2877"),r=Object(s["a"])(o,a,l,!1,null,"6e0ac741",null);t["default"]=r.exports},c6ed:function(e,t,i){},ec21:function(e,t,i){"use strict";i("c6ed")}}]);
//# sourceMappingURL=chunk-32db800e.cb15e4cb.js.map