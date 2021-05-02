(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2701b065"],{"21c7":function(t,a,e){"use strict";e.r(a);var l=function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",[e("el-table",{staticStyle:{width:"60%"},attrs:{data:t.salaries,border:"",stripe:"","header-cell-style":{textAlign:"center"},"cell-style":{textAlign:"center"}}},[e("el-table-column",{attrs:{prop:"employee.workID",label:"工号",width:"80"}}),e("el-table-column",{attrs:{prop:"employee.name",label:"姓名",width:"70"}}),e("el-table-column",{attrs:{prop:"salary.name",label:"隶属部门账套",width:"120"}}),e("el-table-column",{attrs:{prop:"basicSalary",label:"基本工资",width:"70"}}),e("el-table-column",{attrs:{prop:"bonus",label:"奖金",width:"70"}}),e("el-table-column",{attrs:{prop:"lunchSalary",label:"午餐补助",width:"70"}}),e("el-table-column",{attrs:{prop:"trafficSalary",label:"交通补助",width:"70"}}),e("el-table-column",{attrs:{prop:"allSalary",label:"总工资",width:"80"},scopedSlots:t._u([{key:"default",fn:function(a){return[e("el-tag",[t._v(t._s(a.row.allSalary))])]}}])}),e("el-table-column",{attrs:{label:"操作"},scopedSlots:t._u([{key:"default",fn:function(a){return[e("el-button",{staticStyle:{"margin-right":"10px"},on:{click:function(e){return t.showDiaLog(a.row)}}},[t._v("编辑")]),e("el-popconfirm",{attrs:{icon:"el-icon-info","icon-color":"red",title:"确定删除"+a.row.employee.name+"薪资记录吗？"},on:{confirm:function(e){return t.handleDelete(a.row)}}},[e("el-button",{attrs:{slot:"reference",type:"danger"},slot:"reference"},[t._v("删除")])],1)]}}])})],1),e("el-dialog",{attrs:{"close-on-click-modal":!1,"before-close":t.handleClose,title:"编辑工资",visible:t.dialogVisible,width:"50%"},on:{"update:visible":function(a){t.dialogVisible=a}}},[e("div",{staticStyle:{display:"flex","justify-content":"space-around","align-items":"center"}},[e("el-steps",{attrs:{direction:"vertical",active:t.salaryItemIndex}},t._l(t.salaryItemName,(function(t,a){return e("el-step",{key:a,attrs:{title:t}})})),1),t._l(t.salary,(function(a,l,i){return e("el-input",{directives:[{name:"show",rawName:"v-show",value:t.salaryItemIndex==i,expression:"salaryItemIndex == index"}],key:i,staticStyle:{width:"300px"},model:{value:t.salary[l],callback:function(a){t.$set(t.salary,l,a)},expression:"salary[title]"}})}))],2),e("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[e("el-button",{on:{click:t.preStep}},[t._v("上一步")]),e("el-button",{attrs:{type:"primary"},on:{click:t.nextStep}},[t._v(t._s(3==t.salaryItemIndex?"完成":"下一步"))])],1)])],1)},i=[],n={name:"SalTable",data:function(){return{salaries:[],dialogVisible:!1,salaryItemName:["基本工资","奖金","交通补助","午餐补助"],salaryItemIndex:0,salary:{basicSalary:0,bonus:0,trafficSalary:0,lunchSalary:0}}},mounted:function(){this.initTable()},methods:{clearSalary:function(){this.salary={basicSalary:0,bonus:0,trafficSalary:0,lunchSalary:0}},handleClose:function(){this.dialogVisible=!1,this.salaryItemIndex=0},preStep:function(){0!=this.salaryItemIndex&&this.salaryItemIndex--},nextStep:function(){var t=this;3==this.salaryItemIndex&&(this.putRequest("/salary/table/",this.salary).then((function(a){a&&t.initTable()})),this.dialogVisible=!1,this.salaryItemIndex=-1),this.salaryItemIndex++},handleDelete:function(t){var a=this;this.deleteRequest("/salary/table/"+t.id+"/"+t.eid).then((function(t){t&&a.initTable()}))},showDiaLog:function(t){this.dialogVisible=!0,this.salary.basicSalary=t.basicSalary,this.salary.trafficSalary=t.trafficSalary,this.salary.lunchSalary=t.lunchSalary,this.salary.bonus=t.bonus,this.salary.id=t.id,this.salary.sid=t.sid},initTable:function(){var t=this;this.getRequest("/salary/table").then((function(a){a&&(t.salaries=a.obj)}))}}},r=n,s=e("2877"),o=Object(s["a"])(r,l,i,!1,null,null,null);a["default"]=o.exports},"2bc5":function(t,a,e){"use strict";e.r(a);var l=function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",[e("div",[e("el-button",{attrs:{icon:"el-icon-plus",type:"primary"},on:{click:t.showAddDialog}},[t._v("添加工资账套")])],1),e("div",{staticClass:"fixTable"},[e("el-table",{attrs:{data:t.salaries,border:"",stripe:"","header-cell-style":{textAlign:"center"},"cell-style":{textAlign:"center"}}},[e("el-table-column",{attrs:{width:"120",label:"账套名称",prop:"name"}}),e("el-table-column",{attrs:{width:"70",label:"基本工资",prop:"basicSalary"}}),e("el-table-column",{attrs:{width:"70",label:"交通补助",prop:"trafficSalary"}}),e("el-table-column",{attrs:{width:"70",label:"午餐补助",prop:"lunchSalary"}}),e("el-table-column",{attrs:{width:"70",label:"奖金",prop:"bonus"}}),e("el-table-column",{attrs:{width:"100",label:"启用时间",prop:"createDate"}}),e("el-table-column",{attrs:{label:"养老金"}},[e("el-table-column",{attrs:{width:"70",label:"基数",prop:"pensionBase"}}),e("el-table-column",{attrs:{width:"70",label:"比率",prop:"pensionPer"}})],1),e("el-table-column",{attrs:{label:"医疗保险"}},[e("el-table-column",{attrs:{width:"70",label:"基数",prop:"medicalBase"}}),e("el-table-column",{attrs:{width:"70",label:"比率",prop:"medicalPer"}})],1),e("el-table-column",{attrs:{label:"公积金"}},[e("el-table-column",{attrs:{width:"70",label:"基数",prop:"accumulationFundBase"}}),e("el-table-column",{attrs:{width:"70",label:"比率",prop:"accumulationFundPer"}})],1),e("el-table-column",{attrs:{label:"操作"},scopedSlots:t._u([{key:"default",fn:function(a){return[e("el-button",{on:{click:function(e){return t.handleEdit(a.row)}}},[t._v("编辑")]),e("el-button",{attrs:{type:"danger"},on:{click:function(e){return t.handleDelete(a.row)}}},[t._v("删除")])]}}])})],1)],1),e("el-dialog",{attrs:{"close-on-click-modal":!1,"before-close":t.handleClose,title:t.dialogTitle,visible:t.dialogVisible,width:"50%"},on:{"update:visible":function(a){t.dialogVisible=a}}},[e("div",{staticClass:"diaLogStyle"},[e("el-steps",{attrs:{direction:"vertical",active:t.salaryItemIndex}},t._l(t.salaryNames,(function(t,a){return e("el-step",{key:a,attrs:{title:t}})})),1),t._l(t.salary,(function(a,l,i){return e("el-input",{directives:[{name:"show",rawName:"v-show",value:t.salaryItemIndex==i,expression:"salaryItemIndex == index"}],key:i,staticStyle:{width:"200px"},attrs:{placeholder:"输入"+t.salaryNames[i]},model:{value:t.salary[l],callback:function(a){t.$set(t.salary,l,a)},expression:"salary[title]"}})}))],2),e("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[e("el-button",{on:{click:t.preStep}},[t._v("上一步")]),e("el-button",{attrs:{type:"primary"},on:{click:t.nextStep}},[t._v(t._s(10==t.salaryItemIndex?"完成":"下一步"))])],1)])],1)},i=[],n=(e("b0c0"),{name:"SalSob",data:function(){return{dialogTitle:"",salaries:[],dialogVisible:!1,salaryNames:["基本工资","交通补助","午餐补助","奖金","养老金基数","养老金比率","医疗保险基数","医疗保险比率","公积金基数","公积金比率","账套名称"],salaryItemIndex:0,salary:{basicSalary:0,trafficSalary:0,lunchSalary:0,bonus:0,pensionBase:0,pensionPer:0,medicalBase:0,medicalPer:0,accumulationFundBase:0,accumulationFundPer:0,name:""}}},mounted:function(){this.initSalaries()},methods:{clearSalary:function(){this.salary={basicSalary:0,trafficSalary:0,lunchSalary:0,bonus:0,pensionBase:0,pensionPer:0,medicalBase:0,medicalPer:0,accumulationFundBase:0,accumulationFundPer:0,name:""}},handleClose:function(){this.dialogVisible=!1,this.salaryItemIndex=0,this.clearSalary()},preStep:function(){0!=this.salaryItemIndex&&this.salaryItemIndex--},nextStep:function(){var t=this;10==this.salaryItemIndex&&(this.salary.id?this.putRequest("salary/sob/",this.salary).then((function(a){a&&t.initSalaries()})):this.postRequest("salary/sob/",this.salary).then((function(a){a&&t.initSalaries()})),this.dialogVisible=!1,this.salaryItemIndex=-1),this.salaryItemIndex++},showAddDialog:function(){this.dialogTitle="添加工资账套",this.salary.name="默认账套",this.dialogVisible=!0},handleDelete:function(t){var a=this;this.$confirm("此操作将永久删除 [ "+t.name+" ] 账套记录，是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){a.deleteRequest("salary/sob/"+t.id).then((function(t){t&&a.initSalaries()}))})).catch((function(){}))},handleEdit:function(t){this.dialogVisible=!0,this.dialogTitle="修改工资账套",this.dialogVisible=!0,this.salary.basicSalary=t.basicSalary,this.salary.trafficSalary=t.trafficSalary,this.salary.lunchSalary=t.lunchSalary,this.salary.bonus=t.bonus,this.salary.pensionPer=t.pensionPer,this.salary.pensionBase=t.pensionBase,this.salary.medicalPer=t.medicalPer,this.salary.medicalBase=t.medicalBase,this.salary.accumulationFundPer=t.accumulationFundPer,this.salary.accumulationFundBase=t.accumulationFundBase,this.salary.name=t.name,this.salary.id=t.id},initSalaries:function(){var t=this;this.getRequest("salary/sob/").then((function(a){a&&(t.salaries=a)}))}}}),r=n,s=(e("6c55"),e("2877")),o=Object(s["a"])(r,l,i,!1,null,null,null);a["default"]=o.exports},"6ac98":function(t,a,e){"use strict";e.r(a);var l=function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",[e("el-table",{attrs:{size:"mini",data:t.data,border:"",stripe:"","header-cell-style":{textAlign:"center"},"cell-style":{textAlign:"center"}}},[e("el-table-column",{attrs:{label:"姓名",prop:"name"}}),e("el-table-column",{attrs:{label:"工号",prop:"workID"}}),e("el-table-column",{attrs:{label:"电子邮件",prop:"email"}}),e("el-table-column",{attrs:{label:"电话号码",prop:"phone"}}),e("el-table-column",{attrs:{label:"所属部门",prop:"department.name"}}),e("el-table-column",{attrs:{label:"所属账套"},scopedSlots:t._u([{key:"default",fn:function(a){return[a.row.salary?e("el-tooltip",{attrs:{placement:"right"}},[e("div",{attrs:{slot:"content"},slot:"content"},[e("table",[e("tr",[e("td",[t._v("基本工资")]),e("td",[t._v(t._s(a.row.salary.basicSalary))])]),e("tr",[e("td",[t._v("交通补助")]),e("td",[t._v(t._s(a.row.salary.trafficSalary))])]),e("tr",[e("td",[t._v("午餐补助")]),e("td",[t._v(t._s(a.row.salary.lunchSalary))])]),e("tr",[e("td",[t._v("奖金")]),e("td",[t._v(t._s(a.row.salary.bonus))])]),e("tr",[e("td",[t._v("养老金基数")]),e("td",[t._v(t._s(a.row.salary.pensionBase))])]),e("tr",[e("td",[t._v("养老金比率")]),e("td",[t._v(t._s(a.row.salary.pensionPer))])]),e("tr",[e("td",[t._v("医疗保险基数")]),e("td",[t._v(t._s(a.row.salary.medicalBase))])]),e("tr",[e("td",[t._v("医疗保险比率")]),e("td",[t._v(t._s(a.row.salary.medicalPer))])]),e("tr",[e("td",[t._v("公积金基数")]),e("td",[t._v(t._s(a.row.salary.accumulationFundBase))])]),e("tr",[e("td",[t._v("公积金比率")]),e("td",[t._v(t._s(a.row.salary.accumulationFundPer))])]),e("tr",[e("td",[t._v("启用时间")]),e("td",[t._v(t._s(a.row.salary.createDate))])])])]),e("el-tag",[t._v(t._s(a.row.salary.name))])],1):e("el-tag",[t._v("暂未设置")])]}}])}),e("el-table-column",{attrs:{label:"操作"},scopedSlots:t._u([{key:"default",fn:function(a){return[e("el-popover",{attrs:{placement:"left",title:"修改工资账套",width:"200",trigger:"click"},on:{show:function(e){return t.showPopover(a.row)},hide:function(e){return t.hidePopover(a.row)}}},[e("el-select",{attrs:{placeholder:"请选择账套"},model:{value:t.currentSalary,callback:function(a){t.currentSalary=a},expression:"currentSalary"}},t._l(t.salaries,(function(t){return e("el-option",{key:t.id,attrs:{label:t.name,value:t.id}})})),1),e("el-button",{attrs:{slot:"reference",type:"danger"},slot:"reference"},[t._v("修改工资账套")])],1)]}}])})],1),e("div",{staticStyle:{"margin-top":"10px"}},[e("el-pagination",{staticStyle:{display:"flex","justify-content":"flex-end"},attrs:{background:"",layout:"prev, pager, next, sizes, total",total:t.total,"page-sizes":[10,20,30,40],"page-size":10},on:{"current-change":t.handleCurrentChange,"size-change":t.handleSizeChange}})],1)],1)},i=[],n={name:"SalSobCfg",data:function(){return{data:[],total:0,page:1,size:10,salaries:[],currentSalary:null}},mounted:function(){this.initAllEmpWithSalary(),this.initSalaries()},methods:{hidePopover:function(t){var a=this;this.currentSalary&&this.putRequest("/salary/sobcfg?eid="+t.id+"&sid="+this.currentSalary).then((function(t){t&&a.initAllEmpWithSalary()}))},showPopover:function(t){t.salary?this.currentSalary=t.salary.id:this.currentSalary=null},initSalaries:function(){var t=this;this.getRequest("/salary/sob/").then((function(a){a&&(t.salaries=a)}))},handleSizeChange:function(t){this.size=t,this.initAllEmpWithSalary()},handleCurrentChange:function(t){this.page=t,this.initAllEmpWithSalary()},initAllEmpWithSalary:function(){var t=this;this.getRequest("/salary/sobcfg?page="+this.page+"&size="+this.size).then((function(a){a&&(t.data=a.data,t.total=a.total)}))}}},r=n,s=e("2877"),o=Object(s["a"])(r,l,i,!1,null,null,null);a["default"]=o.exports},"6c55":function(t,a,e){"use strict";e("c045")},c045:function(t,a,e){},d7e6:function(t,a,e){var l={"./SalSob.vue":"2bc5","./SalSobCfg.vue":"6ac98","./SalTable.vue":"21c7"};function i(t){var a=n(t);return e(a)}function n(t){if(!e.o(l,t)){var a=new Error("Cannot find module '"+t+"'");throw a.code="MODULE_NOT_FOUND",a}return l[t]}i.keys=function(){return Object.keys(l)},i.resolve=n,t.exports=i,i.id="d7e6"}}]);
//# sourceMappingURL=chunk-2701b065.424b77b8.js.map