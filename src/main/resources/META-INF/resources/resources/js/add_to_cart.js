$(document).ready(function() {
	$("#buttonAdd2Cart").on("click", function(e){
		addToCart();
	});
});

function addToCart(){
	quantity = $("#quantity" + itemId).val();
	
	 url = contextPath + "cart/add/" + itemId +"/" + quantity;
	
	$.ajax({
		type: "POST",
		url: url,
		});
}