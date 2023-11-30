$(document).ready(function() {
	updateTotal2();
});

function updateTotal2(){
	total = 0.0;
	$(".itemSubtotal").each(function(index,element){
		total = total + parseFloat(element.innerHTML);
	});
	$("#totalAmount").text(total);
	$("#finalAmount").text(total);
}