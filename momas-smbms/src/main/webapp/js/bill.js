var bill = {
	add : function(path){
		window.location.href=path+'/bill/add';
	},
	watch : function(id){
		window.location.href=path+'/bill/query?id='+id;
	},
	update : function(id){
		window.location.href=path+'/bill/update?id='+id;
	},
	del : function(id){
		confirm('确认删除?')?window.location.href=path+'/bill/del?id='+id:false;
	}
}