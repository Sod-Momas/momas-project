function loadTypes() {
	$.ajax( {
		url : ctx + '/house/housequeryAllTypes',
		type : 'post',
		dataType : 'json',
		success : function(data) {
			$("#housetype").html("");
			$("#housetype").append("<option value=''>不限</option>")
			$.each(data.typesList,
					function(i, t) {
						$("#housetype").append("<option value='" + t.id + "'>" + t.name + "</option>");
						console.log(t.id + "  " + t.name);
					});
			if(isSearch){//从页面定义来的
				$("#housetype").val(selectType);
			}
		}
	});

};
function loadDistrict() {
	$.ajax( {
		url : ctx + '/district/districtqueryAllDistrict',
		type : 'post',
		dataType : 'json',
		success : function(data) {
			$("#district_id").html("");
			if(isSearch){
				$("#district_id").append("<option value=''>不限</option>");
			}
			$.each(data.districtList,
					function(i, d) {
						$("#district_id").append(
								"<option value='" + d.id + "'>" + d.name
										+ "</option>");
						console.log(d.id + "  " + d.name);
					});
			if(isSearch){//从页面定义来的
				$("#district_id").val(selectDistrictId);
			}
			loadStreet();;
		}
	})

};
function loadStreet() {
	if($("#district_id").val() == "" || $("#district_id").val() == "不限"){
		$("#street_id").html("");
		$("#street_id").append("<option value=''>不限</option>");
		return;
	}
	$.ajax( {
		url : ctx + '/district/districtquerydistrictbyId?district.id=' + $("#district_id").val(),
		type : 'post',
		dataType : 'json',
		success : function(data) {
		$("#street_id").html("");
		if(isSearch){
			$("#street_id").append("<option value=''>不限</option>");
		}
		$.each(data.district.streets, function(
			index, d) {
			$("#street_id").append("<option value='" + d.id + "'>" + d.name + "</option>");
			console.log(d.id + "  " + d.name);
		});
		if(isSearch){//从页面定义来的
			$("#street_id").val(selectStreetId);
		}
	}
	});
}

$(function() {
	loadDistrict();
	
	$("#district_id").change(loadStreet);
})


/*
 * * 
 * {
	margin:0;
	padding:0;
	list-style-type:none;
}
img, a {
	border:0;
}
.piccon {
	height:75px;
	margin:100px 0 0 50px;
}
.piccon li {
	float:left;
	padding:0 10px;
}
#preview {
	position:absolute;
	border:1px solid #ccc;
	background:#333;
	padding:5px;
	display:none;
	color:#fff;
}
* 
* 
 * 
 * <li>
	<a href="http://sc.chinaz.com/" rel="images/4.jpg" class="preview">
	<img src="images/4s.jpg" alt="画廊缩略图" width="100" height="75" />
	</a>
</li>
* 
* 
* 
 this.imagePreview = function(){	
	xOffset = 10;
	yOffset = 30;
	$("a.preview").hover(function(e){
		this.t = this.title;
		this.title = "";	
		var c = (this.t != "") ? "<br/>" + this.t : "";
		$("body").append("<div id=´preview´><img src=´" 
		+ this.rel +"´ alt=´Image preview´ />"+ c +"</div>");								 
		$("#preview")
			.css("top",(e.pageY - xOffset) + "px")
			.css("left",(e.pageX + yOffset) + "px")
			.fadeIn("fast");						
    },
	function(){
		this.title = this.t;	
		$("#preview").remove();
    });	
	$("a.preview").mousemove(function(e){
		$("#preview")
			.css("top",(e.pageY - xOffset) + "px")
			.css("left",(e.pageX + yOffset) + "px");
	});			
};
* 
* 
* /
 */
