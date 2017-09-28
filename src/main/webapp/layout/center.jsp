<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript" src="<%=basePath %>js/jquery-easyui-1.5.3/jquery-3.2.1.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery-easyui-1.5.3/jquery.easyui.min.js"  charset="UTF-8"></script>
<link rel="stylesheet" href="<%=basePath %>js/jquery-easyui-1.5.3/themes/default/easyui.css" type="text/css"  charset="UTF-8"></link>
<link rel="stylesheet" href="<%=basePath %>js/jquery-easyui-1.5.3/themes/icon.css" type="text/css"  charset="UTF-8"></link>
<script type="text/javascript" src="<%=basePath %>js/jquery-easyui-1.5.3/locale/easyui-lang-zh_CN.js"  charset="UTF-8"></script>

<script type="text/javascript" charset="UTF-8">
	var datagrid;
	$(function(){
		datagrid = $('#datagrid').datagrid({
			url : '<%= request.getContextPath()%>/userController/list.do',
			toolbar : '#toolbar',
			title : '用户列表',
			iconCls : '',
			pagination : true,
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 ],
			fit : true,
			fitColumns : true,
			nowrap : false,
			border : false,
			idField : 'id',
			columns:[[
			          {
			        	  title:'编号',
			        	  field:'id',
			        	  width:100,
			        	  checkbox : true,
			        	  sortable:true
					  },
					  
			          {
						  title:'姓名',
			        	  field:'name',
			        	  width:100,
			        	  sortable:true
					  },
					  
			          {
						  title:'密码',
			        	  field:'password',
			        	  width:100,
					  },
					  
			          {
						  title:'年龄',
			        	  field:'age',
			        	  width:100,
			        	  sortable:true
					  },
					  
			          {
						  title:'地址',
			        	  field:'address',
			        	  width:100,
					  },
					  
			          {
						  title:'学历',
			        	  field:'education',
			        	  width:100,
					  },
					  
			          {
						  title:'身份证号',
			        	  field:'identity',
			        	  width:100,
					  },
			          {
						  title:'手机',
			        	  field:'phon',
			        	  width:100,
					  },
					  
			          {
						  title:'单位名称',
			        	  field:'unitname',
			        	  width:100,
					  },
					  
			          {
						  title:'单位地址',
			        	  field:'unitaddress',
			        	  width:100,
					  },
					  
			          {
						  title:'注册时间',
			        	  field:'createDate',
			        	  width:100,
					  },
					  
			          {
						  title:'状态',
			        	  field:'status',
			        	  width:100,
					  },
					  
			          {
						  title:'上次修改时间',
			        	  field:'modificationTime',
			        	  width:100,
					  },
					  
			          {
						  title:'上传文件',
			        	  field:'uploadFile',
			        	  width:100,
					  },
					  
			          {
						  title:'ip',
			        	  field:'ip',
			        	  width:100,
					  }
			          ]],
			          toolbar:[
			          {
			        	  text:'增加',
			        	  iconCls:'icon-add',
			        	  handler:function(){
			        		  
			          	  }
			          },'-',
			          {
			        	  text:'删除',
			        	  iconCls:'icon-remove',
			        	  handler:function(){
			        		  
			          	  }
			          },
			          '-',
			          {
			        	  text:'修改',
			        	  iconCls:'icon-edit',
			        	  handler:function(){
			        		  
			          	  }
			          },
			          '-',
			          {
			        	  text:'查询',
			        	  iconCls:'icon-search',
			        	  handler:function(){
			        		  
			          	  }
			          }
			          ]
		});
	});
	
</script>

<div class="easyui-layout" fit="true" border="false" id="centerTabs">
	<div region="center" title="" border="false" >
		<table id="datagrid">
		
		
		
		</table>
	</div>
</div>
