$(document).ready(function() {
	$("#cfmdone").on("click", function(e){
		donee();
	});
	$("#cfmprocess").on("click", function(e){
		process();
	});
});

function donee(){
	
	url = contextPath + "done/" + "${tempItem.id}";
	
	$.ajax({
		type: "GET",
		url: url,
		});
	
	alert("Hoàn thành đơn hàng");
}

function process(){

	url = contextPath + "processing/" + "${tempItem.id}";

	$.ajax({
		type: "GET",
		url: url,
	});

	alert("Đơn hàng đang tiến hành");
}