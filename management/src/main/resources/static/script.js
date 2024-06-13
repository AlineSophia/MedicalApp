
function myFunction() {
	let x = document.getElementById("appointmentDate").value;
	console.log(x);
	const xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function () {
		try {
			if (this.readyState == 4 && this.status == 200) {
				console.log(this.responseText)
				document.getElementById("slot").innerHTML = this.responseText;
				// alert(xhttp.responseText);
			}
		}
		catch (erMs) {
			//document.getElementById("idCurrentName").innerHTML = erMs;
		}
	};
	var userUrl = "http://localhost:8080/appointment/availableTimeSlot/" + x;
	xhttp.open("GET", userUrl);
	xhttp.send();
}

function addItem(itemId) {
	const hiddenInput = document.getElementById('selectedItems');
	hiddenInput.value = itemId;
	var elementID = "item-button".concat(itemId);
	console.log(elementID);
	changeButtonColor(elementID);
	//document.getElementById('itemForm').submit();
}

function changeButtonColor(elementID) {
           event.preventDefault(); // Prevent the form from submitting immediately
           document.getElementById(elementID).style.backgroundColor = '#ff6347'; // Change button color to tomato
           setTimeout(() => {
               event.target.submit(); // Submit the form after the color change
           }, 100); // Delay to show the color change
       }