var textNumber = 4;  
var texttiankong = 1;  
var textqita = 1;  
var textSum = 4;  
function addTextBox(form, afterElement) {  
  // Increment the textbox number  
  textNumber++;  
  var div1 = document.createElement("div");
  div1.setAttribute("class","am-form-group");
  var div2 = document.createElement("div");
  div2.setAttribute("class","am-g");
  // Create the label  
  var label = document.createElement("label");
  label.setAttribute("class","am-u-md-2 am-md-text-right am-padding-left-0");
  label.setAttribute("for","txt"+textNumber);
  // Create the textbox  
  var textField = document.createElement("input");  
  textField.setAttribute("class","am-u-md-10 form-control");
  textField.setAttribute("name","txt");  
  textField.setAttribute("id","txt"+textNumber);  
  // Add the label's text  
  label.appendChild(document.createTextNode("选项"+textNumber));  
  // Put the textbox inside  
  label.appendChild(textField);  
  // Add it all to the form 
  div1.appendChild(div2);
  div2.appendChild(label);
  div2.appendChild(textField);
  form.insertBefore(div1,afterElement);  
  //form.insertBefore(textField,afterElement);
  return false;  
}  
function removeTextBox(form) {  
  if (textNumber > 1) { // If there's more than one text box  
    // Remove the last one added  
    var obj = document.getElementById("txt"+textNumber);
    obj.parentNode.parentNode.removeChild(obj.parentNode);
    textNumber--;  
  }  
}  
function addTextBoxtiankong(form, afterElement) {  
  texttiankong++;  
  var div1 = document.createElement("div");
  div1.setAttribute("class","am-form-group");
  var div2 = document.createElement("div");
  div2.setAttribute("class","am-g");
  var label = document.createElement("label");
  label.setAttribute("class","am-u-md-2 am-md-text-right am-padding-left-0");
  label.setAttribute("for","txtt"+texttiankong);
  var textField = document.createElement("input");  
  textField.setAttribute("class","am-u-md-10 form-control");
  textField.setAttribute("name","txt");  
  textField.setAttribute("id","txtt"+texttiankong);  
  label.appendChild(document.createTextNode("填空"+texttiankong));  
  label.appendChild(textField);  
  div1.appendChild(div2);
  div2.appendChild(label);
  div2.appendChild(textField);
  form.insertBefore(div1,afterElement); 
  return false;  
}  
function removeTextBoxtiankong(form) {  
  if (texttiankong > 1) { 
    var obj = document.getElementById("txtt"+texttiankong);    
    obj.parentNode.parentNode.removeChild(obj.parentNode);
    texttiankong--;  
  }  
}  
function addTextBoxqita(form, afterElement) {  
  textqita++;  
  var div1 = document.createElement("div");
  div1.setAttribute("class","am-form-group");
  var div2 = document.createElement("div");
  div2.setAttribute("class","am-g");
  var label = document.createElement("label");
  label.setAttribute("class","am-u-md-2 am-md-text-right am-padding-left-0");
  label.setAttribute("for","txqt"+textqita);
  var textField = document.createElement("input");  
  textField.setAttribute("class","am-u-md-10 form-control");
  textField.setAttribute("name","txt");  
  textField.setAttribute("id","txtq"+textqita);  
  label.appendChild(document.createTextNode("答案"+textqita));  
  label.appendChild(textField);  
  div1.appendChild(div2);
  div2.appendChild(label);
  div2.appendChild(textField);
  form.insertBefore(div1,afterElement);  
  return false;  
}  
function removeTextBoxqita(form) {  
  if (textqita > 1) {
    var obj = document.getElementById("txtq"+textqita);
    obj.parentNode.parentNode.removeChild(obj.parentNode);
    textqita--;  
  }  
}  
function xuanze() {
	document.getElementById('am-form-xuanze').style.display='';
	document.getElementById('am-form-tiankong').style.display='none';
	document.getElementById('am-form-qita').style.display='none';
}
function tiankong() {
	document.getElementById('am-form-xuanze').style.display='none';
	document.getElementById('am-form-tiankong').style.display='';
	document.getElementById('am-form-qita').style.display='none';
}
function qita() {
	document.getElementById('am-form-xuanze').style.display='none';
	document.getElementById('am-form-tiankong').style.display='none';
	document.getElementById('am-form-qita').style.display='';
}
function addText(form, afterElement) {  
	textSum++;  
	var div1 = document.createElement("div");
	div1.setAttribute("class","am-form-group");
	var div2 = document.createElement("div");
	div2.setAttribute("class","am-g");
	var label = document.createElement("label");
	label.setAttribute("class","am-u-md-2 am-md-text-right am-padding-left-0");
	label.setAttribute("for","txt"+textSum);
	var textField = document.createElement("input");  
	textField.setAttribute("class","am-u-md-10 form-control");
	textField.setAttribute("name","txt");  
	textField.setAttribute("id","txt"+textSum);  
	label.appendChild(document.createTextNode("知识点"+textSum));  
	label.appendChild(textField);  
	div1.appendChild(div2);
	div2.appendChild(label);
	div2.appendChild(textField);
	form.insertBefore(div1,afterElement);  
	return false;  
}  
function removeText(form) {  
	if (textSum > 1) {
	    var obj = document.getElementById("txt"+textSum);
	    obj.parentNode.parentNode.removeChild(obj.parentNode);
	    textSum--;  
	}    
}  

//checkbox 全选/取消全选  
var knowledge = false;
function knowledgeAll() {  
    if (knowledge) {  
        $("input[type='checkbox'][class='knowledge']").each(function() {  
            this.checked = false;  
        });  
        knowledge = false;  
    } else {  
        $("input[type='checkbox'][class='knowledge']").each(function() {  
            this.checked = true;  
        });  
        knowledge = true;  
    }  
}  

var queType = false;
function queTypeAll() {  
    if (queType) {  
        $("input[type='checkbox'][class='que_type']").each(function() {  
            this.checked = false;  
        });  
        queType = false;  
    } else {  
        $("input[type='checkbox'][class='que_type']").each(function() {  
            this.checked = true;  
        });  
        queType = true;  
    }  
}  