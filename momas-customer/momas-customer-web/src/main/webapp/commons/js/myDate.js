var myTime = {
	showTime : function(){
		var dateStr = "";
		var date = new Date();
	
		dateStr += date.getFullYear() + "年";
		dateStr += date.getMonth() + 1 + "月";
		dateStr += date.getDate() + "日";
		dateStr += " ";
		dateStr += "星期" + myTime.week(date.getDay());
		dateStr += " ";
		dateStr += myTime.doubleNum(myTime.toTwelve(date.getHours())) + ":";
		dateStr += myTime.doubleNum(date.getMinutes()) + ":";
		dateStr += myTime.doubleNum(date.getSeconds());
		dateStr += " ";
		dateStr += myTime.getroon(date.getHours());
		return dateStr;
	},
	doubleNum: function (number) {
		if(number < 10) {
			return "0" + number;
		}
		return number;
	},
	week: function (number) {
		switch(number) {
			case 0:
				return "日";
			case 1:
				return "一";
			case 2:
				return "二";
			case 3:
				return "三";
			case 4:
				return "四";
			case 5:
				return "五";
			case 6:
				return "六";
		}
	},
	getroon: function (hour) {
		return hour < 13 ? "上午" : "下午";
	},
	toTwelve: function (hour) {
			return hour < 13 ? hour : hour - 12;
		}
}






