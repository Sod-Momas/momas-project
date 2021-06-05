var user = {
	add : function(path){
		window.location.href=path+'/user/add';
	},
	query : function(id){
		window.location.href=path+'/user/query?userId='+id;
	},
	update : function(id){
		window.location.href=path+'/user/update?userId='+id;
	},
	del : function(id){
		confirm('确认删除?')?window.location.href=path+'/user/del?userId='+id:false;
	}
}