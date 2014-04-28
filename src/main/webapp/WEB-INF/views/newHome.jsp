<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>IDEAL Spreadsheet</title>
	<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
	<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/newHome.css">
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
	<script>
		var query = 0;
		
		function clickedAddQuery(){
			$('#addModal').modal('show');
		};
		
		function addButtonClicked(){
			$('#addQueryModal').modal('hide');
			var table = document.getElementById("spreadsheet");
			var row = table.insertRow(query+1);
			var x = row.insertCell(0);
			x.innerHTML=$('#collection').text();
			var x = row.insertCell(1);
			x.innerHTML=$('#eventType').text() + ", "+$('#event').text()+"<br>Keywords: "+$('#keywords').val();
			var x = row.insertCell(2);
			x.innerHTML='<div class="input-group"><input type="text" row="'+query+'" target="operation" class="form-control"></div>';
			var x = row.insertCell(3);
			x.innerHTML='<div class="input-group"><input type="text" row="'+query+'" target="visualization" class="form-control"></div>';
			query++;
		};
		
		function eventSelected(){
			var x = document.getElementById("eventTypeHeader");
		};
		
		$(document).on('click','#collectionDropdown li a', function(){
			$('#collection')[0].innerHTML = this.innerHTML + ' <span class="caret"></span>';

		});
		
		$(document).on('click','#eventTypeDropdown li a', function(){
			$('#eventType')[0].innerHTML = this.innerHTML + ' <span class="caret"></span>';

		});
		
		$(document).on('click','#eventDropdown li a', function(){
			$('#event')[0].innerHTML = this.innerHTML + ' <span class="caret"></span>';

		});
		
		$(document).keypress(function(e) {
		    if (e.which == "13") {
		    	var box = document.activeElement;
		    	if(box.getAttribute("target") == "operation"){
		        	alert("Clicked Operation in row "+box.getAttribute("row") + " with value "+box.value);
		    	} else if(box.getAttribute("target") == "visualization"){
		    		alert("Clicked Visualization in row "+ box.getAttribute("row")+ " with value "+ box.value);
		    		
		    	}
		    }       
		});
		
	</script>
</head>
<body>
	<div id="topLevelContainer" class="container">
		<div id="infoBar"> Welcome to IDEAL Spreadsheet
		<br>
			<p>
			Here is how to use our tool:
			<br>
			<br>
			1. 
			<br>
			Click the large green '+' button at the top of your screen.
			<br>
			<br>
			2.<br>
			Fill in the window with all your requests and click the "Add" button.
			<br>
			<br>
			3.<br>
			In the 'Operations' column type in your desired operation (example: '=itemCount')
			<br>
			<br>
			4.<br>
			In the 'Visualizations' column type in your desired visualization (example: '=wordCloud')
			<br>
			</p>
		</div>
		<div id="tableContainer">
		<button type="button" id="addButton" onclick="clickedAddQuery()" class="btn btn-success">
			<span class="glyphicon glyphicon-plus"></span>
		</button>
			<table id="spreadsheet" class="table table-striped table-hover table-bordered">
				<tbody>
					<tr>
						<td> Collection </td>
						<td> Query </td>
						<td> Operation</td>
						<td> Visualization</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
		
		<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel" aria-hidden="true">
  			<div class="modal-dialog">
    			<div class="modal-content">
      				<div class="modal-header">
        				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        					<h4 class="modal-title" id="addModalLabel">Add Your Query</h4>
      				</div>
      				<div class="modal-body">
      					What Collection would you like to use?
      					<div class="input-group-btn">
  							<button id="collection" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
   								 Collection 
   								 <span class="caret"></span>
  							</button>
  							<ul id=collectionDropdown class="dropdown-menu" role="menu">
    							<li><a href="#">Collection 1</a></li>
    							<li><a href="#">Collection 2</a></li>
    							<li><a href="#">Collection 3</a></li>
  							</ul>
						</div>
						What Type of Event are you looking for?:
						<div class="input-group-btn">
  							<button id="eventType" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
   								 Type 
   								 <span class="caret"></span>
  							</button>
  							<ul id="eventTypeDropdown" class="dropdown-menu" role="menu">
    							<li><a href="#">Shooting</a></li>
    							<li><a href="#">Flood</a></li>
    							<li><a href="#">Hurricane</a></li>
  							</ul>
						</div>
						Where in the world is your event?
						<div class="input-group-btn">
  							<button id="event" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
   								 Location 
   								 <span class="caret"></span>
  							</button>
  							<ul id="eventDropdown" class="dropdown-menu" role="menu">
    							<li><a href="#">Japan</a></li>
    							<li><a href="#">China</a></li>
    							<li><a href="#">USA</a></li>
  							</ul>
						</div>
						What Keywords are you interested in?:
  						<div class="input-group">
  							<input id ="keywords" type="text" class="form-control">
						</div>
  						What date range are you interested in?
  						<div class="input-group">
  							<input type="text" class="form-control">
						</div>
						<p class="help-block">Put in format: MM/DD/YYYY-MM/DD/YYYY.</p>
      				</div>
     				 <div class="modal-footer">
       					 <button id="addQueryButton" onclick="addButtonClicked();" type="button" class="btn btn-primary" >Add</button>
      				</div>
    			</div>
  			</div>
		</div>
</body>
</html>