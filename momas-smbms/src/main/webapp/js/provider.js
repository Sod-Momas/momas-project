var provider = {
	add : function(path){
		window.location.href=path+'/provider/add';
	},
	query : function(id){
		window.location.href=path+'/provider/query?proId='+id;
	},
	update : function(id){
		window.location.href=path+'/provider/update?proId='+id;
	},
	del : function(id){
		confirm('确认删除?')?window.location.href=path+'/provider/del?proId='+id:false;
	}
}