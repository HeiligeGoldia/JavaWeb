$(document).ready(function() {
	$(".minusButton").on("click", function(evt){
		evt.preventDefault();
		decreaseQuantity($(this));
	
	});
	$(".plusButton").on("click", function(evt){
		evt.preventDefault();
		increaseuantity($(this));
	
	});
	$("#link-remove").on("click", function(evt){
		evt.preventDefault();
		removeFormCart($(this));
	});
	
	updateTotal();

});

function removeFormCart(link){
	url = link.attr("href");
	$.ajax({
		type: "POST",
		url: url,
		}).done(function(){
			rowNumber =  link.attr("rowNumber");
			removeItem(rowNumber);
			updateTotal();
		});
}
function removeItem(rowNumber){
	rowId = "row" + rowNumber;
	$("#" + rowId).remove();
}

function decreaseQuantity(link){
		itemId = link.attr("pid");
		qtyInput = $("#quantity" + itemId);
		
		newQty = parseInt(qtyInput.val())-1;
		if (newQty > 0){
			qtyInput.val(newQty);
			updateQuantity(itemId,newQty);
		} 
}

function increaseuantity(link){
		itemId = link.attr("pid");
		qtyInput = $("#quantity" + itemId);
		newQty = parseInt(qtyInput.val())+1;
		if (newQty > 0){
			qtyInput.val(newQty);
			updateQuantity(itemId,newQty);
		} 
	
}
function updateQuantity(itemId,quantity){
	 url = contextPath + "cart/update/" + itemId +"/" + quantity;
	
	$.ajax({
		type: "POST",
		url: url,
		}).done(function(newSubtotal){
			updateSubtotal(newSubtotal, itemId);
			updateTotal();
		});
}
function updateSubtotal(newSubtotal, itemId){
	$("#subtotal" + itemId).text(newSubtotal);
}

function updateTotal(){
	total = 0.0;
	$(".itemSubtotal").each(function(index,element){
		total = total + parseFloat(element.innerHTML);
	});
	$("#totalAmount").text(total);
	$("#finalAmount").text(total);
}

