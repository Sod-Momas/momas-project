
$(function(){
	loadbrand();
	$("#brand").change(loadmodal);
});
function loadbrand() {
	$.ajax( {
		url : ctx + '/carbrandqueryAll',
		type : 'post',
		dataType : 'json',
		success : function(data) {
			$("#brand").html("");
			if(isSearch){
				$("#brand").append("<option value=''>不限</option>");
			}
			$.each(data.blist,
					function(i, brand) {
						$("#brand").append(
								"<option value='" + brand.brandid + "'>" + brand.brandname + "</option>");
						console.log(brand.brandid + "  " + brand.brandname);
					});	
			loadmodal();
//			if(isSearch){//从页面定义来的
//				$("#brand").val(selectDistrictId);
//			}锁定选项
			//loadStreet();;
		}
	})
};
function loadmodal() {
	if(! $("#brand").val()){
		$("#modal").val("");
		return;
	}
	$.ajax( {
		url : ctx + '/carmodalqueryByBrandId',
		type : 'post',
		data : { "brandId": $("#brand").val()},
		dataType : 'json',
		success : function(data) {
			$("#modal").html("");
			if(isSearch){
				$("#modal").append("<option value=''>不限</option>");
			}
			$.each(data.mlist,
					function(i, modal) {
						$("#modal").append(
								"<option value='" + modal.modelid + "'>" + modal.modalname + "</option>");
						console.log(modal.modelid + "  " +  modal.modalname);
					});
//			if(isSearch){//从页面定义来的
//				$("#brand").val(selectDistrictId);
//			}锁定选项
			//loadStreet();;
		}
	})
};