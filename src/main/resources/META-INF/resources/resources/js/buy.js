$(document).ready(function() {
	$("#buyit").on("click", function(e){
		buyyy();
	});

});

function buyyy(){
	
	url = contextPath + "addOrder/";
	
	$.ajax({
		type: "POST",
		url: url,
		});
	
	alert("Đặt hàng thành công");
}