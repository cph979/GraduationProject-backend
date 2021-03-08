(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-be7880dc"],{"3bc9":function(e,t,n){},"4eab":function(e,t,n){"use strict";n("562c")},"562c":function(e,t,n){},5865:function(e,t,n){"use strict";n.r(t);var i=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",[e._v(" 员工资料 ")])},l=[],a={name:"PerEmp"},o=a,s=n("2877"),r=Object(s["a"])(o,i,l,!1,null,"76624f98",null);t["default"]=r.exports},"58b4":function(e,t,n){"use strict";n("3bc9")},"83ed":function(e,t,n){"use strict";n.r(t);var i=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",[n("div",[n("el-button",{attrs:{icon:"el-icon-circle-plus-outline",size:"medium ",type:"text"},on:{click:e.showAddEmpTrain}},[e._v(" 添加员工培训记录 ")])],1),n("div",{staticClass:"table"},[n("el-table",{staticStyle:{width:"70%"},attrs:{"header-cell-style":{textAlign:"center"},"cell-style":{textAlign:"center"},data:e.empTrains,stripe:"",border:""},on:{"selection-change":e.handleSelectionChange}},[n("el-table-column",{attrs:{type:"selection",width:"55"}}),n("el-table-column",{attrs:{prop:"id",label:"编号",width:"55"}}),n("el-table-column",{attrs:{prop:"workID",width:"92",label:"工号"}}),n("el-table-column",{attrs:{prop:"name",width:"93",label:"姓名"}}),n("el-table-column",{attrs:{prop:"trainDate",label:"培训日期"}}),n("el-table-column",{attrs:{prop:"trainContent",label:"培训内容"}}),n("el-table-column",{attrs:{label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("el-button",{on:{click:function(n){return e.handleEdit(t.row)}}},[e._v("编辑培训内容")]),n("el-button",{attrs:{type:"danger"},on:{click:function(n){return e.handleDelete(t.row)}}},[e._v("删除")])]}}])})],1)],1),n("el-button",{staticStyle:{"margin-top":"10px"},attrs:{type:"danger",disabled:0==e.multipleSelection.length},on:{click:e.delEmpTrains}},[e._v(" 批量删除 ")]),n("el-dialog",{attrs:{"close-on-click-modal":!1,title:"修改培训内容",visible:e.dialogVisible,width:"30%"},on:{"update:visible":function(t){e.dialogVisible=t}}},[n("div",[n("el-tag",{staticStyle:{"margin-top":"8px"},attrs:{size:"medium"}},[e._v("培训内容")]),n("el-input",{staticClass:"updateTrainInput",model:{value:e.updateEmpTrain.trainContent,callback:function(t){e.$set(e.updateEmpTrain,"trainContent",t)},expression:"updateEmpTrain.trainContent"}})],1),n("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[n("el-button",{on:{click:function(t){e.dialogVisible=!1}}},[e._v("取 消")]),n("el-button",{attrs:{type:"primary"},on:{click:e.doUpdate}},[e._v("确 定")])],1)]),n("el-dialog",{attrs:{"close-on-click-modal":!1,title:"添加培训记录",visible:e.addDialogVisible,width:"50%"},on:{"update:visible":function(t){e.addDialogVisible=t}}},[n("el-select",{staticStyle:{width:"183px"},attrs:{size:"medium",filterable:"",placeholder:"搜索员工名"},model:{value:e.empTrain.eid,callback:function(t){e.$set(e.empTrain,"eid",t)},expression:"empTrain.eid"}},e._l(e.allEmpNameWorkID,(function(t){return n("el-option",{key:t.id,attrs:{label:t.name,value:t.id}},[n("span",{staticStyle:{float:"left"}},[e._v(e._s(t.name))]),n("span",{staticStyle:{float:"right",color:"#8492a6","font-size":"5px"}},[e._v("工号："+e._s(t.workID))])])})),1),n("el-input",{staticStyle:{"margin-top":"18px"},attrs:{size:"medium",clearable:"",placeholder:"请输入培训内容"},model:{value:e.empTrain.trainContent,callback:function(t){e.$set(e.empTrain,"trainContent",t)},expression:"empTrain.trainContent"}}),n("span",{attrs:{slot:"footer"},slot:"footer"},[n("el-button",{on:{click:function(t){e.addDialogVisible=!1}}},[e._v("取 消")]),n("el-button",{attrs:{type:"primary"},on:{click:e.addEmpTrain}},[e._v("确 定")])],1)],1)],1)},l=[],a=(n("4160"),n("b0c0"),n("159b"),{name:"PerTrain",data:function(){return{empTrain:{eid:null,trainContent:""},updateEmpTrain:{trainContent:""},allEmpNameWorkID:[],addDialogVisible:!1,dialogVisible:!1,empTrains:[],multipleSelection:[]}},mounted:function(){this.initEmpTrains()},methods:{emptyEmpTrain:function(){this.empTrain={eid:null,trainContent:""}},showAddEmpTrain:function(){this.getEmpNameWorkID(),this.addDialogVisible=!0},getEmpNameWorkID:function(){var e=this;this.getRequest("employee/basic/empWithNameAndWordID").then((function(t){t&&(e.allEmpNameWorkID=t)}))},addEmpTrain:function(){var e=this;this.empTrain.eid&&this.empTrain.trainContent?this.postRequest("personnel/train",this.empTrain).then((function(t){t&&(e.initEmpTrains(),e.addDialogVisible=!1,e.emptyEmpTrain())})):this.$message({type:"warning",message:"请输入所有字段",duration:2e3,showClose:!0})},doUpdate:function(){var e=this;this.putRequest("personnel/train",this.updateEmpTrain).then((function(t){t&&(e.initEmpTrains(),e.dialogVisible=!1)}))},handleEdit:function(e){this.dialogVisible=!0,Object.assign(this.updateEmpTrain,e)},handleSelectionChange:function(e){this.multipleSelection=e},handleDelete:function(e){var t=this;this.$confirm("此操作将永久删除 [ "+e.name+" ] 的培训记录，是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){t.deleteRequest("personnel/train/"+e.id).then((function(e){e&&t.initEmpTrains()}))})).catch((function(){}))},initEmpTrains:function(){var e=this;this.getRequest("personnel/train").then((function(t){e.empTrains=t}))},delEmpTrains:function(){var e=this;this.$confirm("此操作将永久删除 [ "+this.multipleSelection.length+" ] 条记录，是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){var t=[];e.multipleSelection.forEach((function(e){t.push(e.id)})),e.deleteRequestData("personnel/train",t).then((function(t){t&&e.initEmpTrains()}))})).catch((function(){}))}}}),o=a,s=(n("4eab"),n("2877")),r=Object(s["a"])(o,i,l,!1,null,null,null);t["default"]=r.exports},cfbb:function(e,t,n){"use strict";n.r(t);var i=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",[e._v(" 员工调动 ")])},l=[],a={name:"PerMv"},o=a,s=n("2877"),r=Object(s["a"])(o,i,l,!1,null,"3c90dbf6",null);t["default"]=r.exports},d9ac:function(e,t,n){"use strict";n.r(t);var i=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",[n("div",[n("el-button",{attrs:{icon:"el-icon-circle-plus-outline",size:"medium ",type:"text"},on:{click:e.showAddEmpEC}},[e._v(" 添加员工奖惩记录 ")])],1),n("div",{staticClass:"posManageMain"},[n("el-table",{staticStyle:{width:"90%"},attrs:{"header-cell-style":{textAlign:"center"},"cell-style":{textAlign:"center"},data:e.empECs,stripe:"",border:""},on:{"selection-change":e.handleSelectionChange}},[n("el-table-column",{attrs:{type:"selection",width:"55"}}),n("el-table-column",{attrs:{prop:"id",label:"编号",width:"55"}}),n("el-table-column",{attrs:{prop:"workID",width:"92",label:"工号"}}),n("el-table-column",{attrs:{prop:"name",width:"93",label:"姓名"}}),n("el-table-column",{attrs:{prop:"ecDate",label:"奖罚日期"}}),n("el-table-column",{attrs:{prop:"ecReason",label:"奖罚原因"}}),n("el-table-column",{attrs:{prop:"ecPoint",label:"奖罚分",width:"100"}}),n("el-table-column",{attrs:{prop:"ecType",label:"奖罚类别",width:"100"},scopedSlots:e._u([{key:"default",fn:function(t){return[0==t.row.ecType?n("el-tag",{attrs:{type:"success"}},[e._v("加分")]):n("el-tag",{attrs:{type:"danger"}},[e._v("减分")])]}}])}),n("el-table-column",{attrs:{label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("el-button",{on:{click:function(n){return e.handleEdit(t.row)}}},[e._v("编辑奖罚分")]),n("el-button",{attrs:{type:"danger"},on:{click:function(n){return e.handleDelete(t.row)}}},[e._v("删除")])]}}])})],1)],1),n("el-button",{staticStyle:{"margin-top":"10px"},attrs:{type:"danger",disabled:0==e.multipleSelection.length},on:{click:e.delEmpECs}},[e._v(" 批量删除 ")]),n("el-dialog",{attrs:{"close-on-click-modal":!1,title:"编辑奖罚分",visible:e.dialogVisible,width:"40%"},on:{"update:visible":function(t){e.dialogVisible=t}}},[0==e.updateEmpEC.ecType?n("el-alert",{attrs:{closable:!1,title:"加分项",type:"success",center:""}}):1==e.updateEmpEC.ecType?n("el-alert",{attrs:{closable:!1,title:"减分项",type:"error",center:""}}):e._e(),n("div",{staticStyle:{"margin-top":"25px"}},[n("el-tag",{staticStyle:{"margin-right":"8px"},attrs:{size:"medium"}},[e._v("奖罚原因")]),n("el-input",{staticClass:"updateECInput",attrs:{disabled:""},model:{value:e.updateEmpEC.ecReason,callback:function(t){e.$set(e.updateEmpEC,"ecReason",t)},expression:"updateEmpEC.ecReason"}})],1),n("div",{staticStyle:{"margin-top":"10px"}},[n("el-tag",{staticStyle:{"margin-right":"8px"},attrs:{size:"medium"}},[e._v("分数调整")]),n("el-input-number",{staticClass:"updateECPointInput",attrs:{min:1,max:100},model:{value:e.updateEmpEC.ecPoint,callback:function(t){e.$set(e.updateEmpEC,"ecPoint",t)},expression:"updateEmpEC.ecPoint"}})],1),n("span",{attrs:{slot:"footer"},slot:"footer"},[n("el-button",{on:{click:function(t){e.dialogVisible=!1}}},[e._v("取 消")]),n("el-button",{attrs:{type:"primary"},on:{click:e.doUpdate}},[e._v("确 定")])],1)],1),n("el-dialog",{attrs:{"close-on-click-modal":!1,"before-close":e.handleClose,title:"添加奖惩记录",visible:e.addDialogVisible,width:"50%"},on:{"update:visible":function(t){e.addDialogVisible=t}}},[n("el-form",{ref:"empECForm",attrs:{model:e.empEC,rules:e.rules}},[n("el-form-item",{attrs:{prop:"eid"}},[n("el-select",{staticStyle:{width:"183px"},attrs:{size:"medium",filterable:"",placeholder:"搜索员工名"},model:{value:e.empEC.eid,callback:function(t){e.$set(e.empEC,"eid",t)},expression:"empEC.eid"}},e._l(e.allEmpNameWorkID,(function(t){return n("el-option",{key:t.id,attrs:{label:t.name,value:t.id}},[n("span",{staticStyle:{float:"left"}},[e._v(e._s(t.name))]),n("span",{staticStyle:{float:"right",color:"#8492a6","font-size":"5px"}},[e._v("工号："+e._s(t.workID))])])})),1)],1),n("el-form-item",{attrs:{prop:"ecReason"}},[n("el-input",{attrs:{size:"medium",clearable:"",placeholder:"请输入奖罚原因"},model:{value:e.empEC.ecReason,callback:function(t){e.$set(e.empEC,"ecReason",t)},expression:"empEC.ecReason"}})],1),n("el-form-item",{attrs:{prop:"ecType"}},[n("el-select",{staticStyle:{width:"183px"},attrs:{size:"medium",placeholder:"选择加分或者减分"},model:{value:e.empEC.ecType,callback:function(t){e.$set(e.empEC,"ecType",t)},expression:"empEC.ecType"}},[n("el-option",{attrs:{label:"加分",value:0}}),n("el-option",{attrs:{label:"减分",value:1}})],1)],1),n("el-form-item",{attrs:{prop:"ecPoint"}},[n("el-input",{attrs:{placeholder:"请输入1-100的整数",size:"medium"},model:{value:e.empEC.ecPoint,callback:function(t){e.$set(e.empEC,"ecPoint",t)},expression:"empEC.ecPoint"}})],1)],1),n("span",{attrs:{slot:"footer"},slot:"footer"},[n("el-button",{on:{click:e.clearValidatesMethod}},[e._v("取 消")]),n("el-button",{attrs:{type:"primary"},on:{click:e.addEmpEC}},[e._v("确 定")])],1)],1)],1)},l=[],a=(n("4160"),n("b0c0"),n("159b"),{name:"PerEc",data:function(){return{pointType:["加分","减分"],empEC:{eid:null,ecReason:"",ecPoint:null,ecType:null},updateEmpEC:{ecReason:"",ecPoint:null,ecType:null},allEmpNameWorkID:[],addDialogVisible:!1,dialogVisible:!1,empECs:[],multipleSelection:[],rules:{ecReason:[{required:!0,message:"请输入奖罚原因",trigger:"blur"}],ecType:[{required:!0,message:"请选择加分或减分",trigger:"blur"}],ecPoint:[{required:!0,message:"请输入奖罚分",trigger:"blur"},{pattern:/(^([1-9]|[1-9]\d|100)$)/,message:"请输入1-100的整数",trigger:"blur"}]}}},mounted:function(){this.initEmpECs()},methods:{handleClose:function(){this.clearValidatesMethod()},emptyEmpEC:function(){this.empEC={eid:null,ecReason:"",ecPoint:null,ecType:null}},clearValidatesMethod:function(){this.addDialogVisible=!1,this.emptyEmpEC(),this.$refs.empECForm.clearValidate()},showAddEmpEC:function(){this.getEmpNameWorkID(),this.addDialogVisible=!0},getEmpNameWorkID:function(){var e=this;this.getRequest("employee/basic/empWithNameAndWordID").then((function(t){t&&(e.allEmpNameWorkID=t)}))},addEmpEC:function(){var e=this;this.empEC.eid?this.$refs.empECForm.validate((function(t){t&&e.postRequest("personnel/ec",e.empEC).then((function(t){t&&(e.initEmpECs(),e.addDialogVisible=!1,e.emptyEmpEC())}))})):this.$message({type:"warning",message:"请选择员工",duration:2e3,showClose:!0})},doUpdate:function(){var e=this;this.putRequest("personnel/ec",this.updateEmpEC).then((function(t){t&&(e.initEmpECs(),e.dialogVisible=!1)}))},handleEdit:function(e){this.dialogVisible=!0,Object.assign(this.updateEmpEC,e)},handleSelectionChange:function(e){this.multipleSelection=e},handleDelete:function(e){var t=this;this.$confirm("此操作将永久删除 [ "+e.name+" ] 奖罚记录，是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){t.deleteRequest("personnel/ec/"+e.id).then((function(e){e&&t.initEmpECs()}))})).catch((function(){}))},initEmpECs:function(){var e=this;this.getRequest("personnel/ec").then((function(t){e.empECs=t}))},delEmpECs:function(){var e=this;this.$confirm("此操作将永久删除 [ "+this.multipleSelection.length+" ] 条记录，是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){var t=[];e.multipleSelection.forEach((function(e){t.push(e.id)})),e.deleteRequestData("personnel/ec",t).then((function(t){t&&e.initEmpECs()}))})).catch((function(){}))}}}),o=a,s=(n("58b4"),n("2877")),r=Object(s["a"])(o,i,l,!1,null,null,null);t["default"]=r.exports},ee1c:function(e,t,n){var i={"./PerEc.vue":"d9ac","./PerEmp.vue":"5865","./PerMv.vue":"cfbb","./PerTrain.vue":"83ed"};function l(e){var t=a(e);return n(t)}function a(e){if(!n.o(i,e)){var t=new Error("Cannot find module '"+e+"'");throw t.code="MODULE_NOT_FOUND",t}return i[e]}l.keys=function(){return Object.keys(i)},l.resolve=a,e.exports=l,l.id="ee1c"}}]);
//# sourceMappingURL=chunk-be7880dc.1adbaec5.js.map