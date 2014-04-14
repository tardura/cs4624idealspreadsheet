<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>IDEAL Spreadsheet</title>
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
	<style>
		tr, td {
			padding-left: 10px;
			padding-right: 10px;
		}
		input[type="checkbox"] {
			margin-right: 5px;
		}
		#query-generator {
			width: 600px;
			height: 200px;
			overflow: hidden;
			margin: 0 auto;
		}
		#query-slider {
			width: 1200px;
			-webkit-transition:all 1.0s ease-in-out;
		  	-moz-transition:all 1.0s ease-in-out;
		  	-o-transition:all 1.0s ease-in-out;
		  	transition:all 1.0s ease-in-out;
		}
		#query-slider div {
			display: inline-block;
			width: 600px;
			padding: 0;
			margin: 0;
			float: left;
		}
	</style>
</head>
<body>
	<div id="container" class="container">
		<div class="header">
			<h3 class="text-muted">IDEAL Spreadsheet</h3>
		</div>
		<div class="jumbotron">
			<p class="lead strong">
				Welcome to IDEAL Spreadsheet! To query a search, follow along with the wizard below to select the events you are interested in and what kind of data your seeking.
			</p>
			<div id="query-generator">
				<div id="query-slider">
					<div>
						<p>First, let's select some archives to collect data from.</p>
						<input class="archive" type="checkbox" id="970" name="Vt"><label for="970">Alabama Shootings</label><br />
						<input class="archive" type="checkbox" id="a" name="a"><label for="a">Filler</label><br />
						<input class="archive" type="checkbox" id="b" name="b"><label for="b">Filler</label><br />
						<input class="archive" type="checkbox" id="c" name="c"><label for="c">Filler</label><br />
						<button type="button" id="archive-button-next" class="btn btn-success pull-right">Next <span class="glyphicon glyphicon-chevron-right"></span></button>
					</div>
					<div>
						<p>Now, let us know what kind of data you're interested in.</p>
						<input class="fn" type="checkbox" id="tes0" name="wordcount"><label for="tes0">Wordcount</label><br />
						<input class="fn" type="checkbox" id="a" name="a"><label for="a">Filler</label><br />
						<input class="fn" type="checkbox" id="b" name="b"><label for="b">Filler</label><br />
						<input class="fn" type="checkbox" id="c" name="c"><label for="c">Filler</label><br />
						<button type="button" id="query-submit-button" class="btn btn-success pull-right">Submit</button>
					</div>
				</div>
			</div>
		</div>
		<table id="results" class="table table-bordered">
			<tr>
				<td>Event</td>
				<td>Wordcount</td>
			</tr>
			<tr>
				<td>Alabama Shootings</td>
				<td id="wordcount"></td>
			</tr>
		</table>
	</div>

	<script type="application/javascript">
		(function () {
			var archives, url, container, labels, functions;

			container = document.getElementById('container');
			labels = document.getElementsByTagName('label');

			url = document.URL;

			$('#results').hide();

			$('#archive-button-next').on('click', function () {
				$('#query-slider').css('transform', 'translateX(-600px)');
				archives = $('.archive');
			});

			$('#query-submit-button').on('click', function () {
				functions = $('.fn');
				$('#results').show();
				$.ajax({
					type: 'GET',
					url: 'http://localhost:7080/idealspreadsheet/wordcount?id=970'
				}).done(function (response) {
					$('#wordcount').text(JSON.stringify(response));
				});
			});
		})();
	</script>

</body>
</html>
