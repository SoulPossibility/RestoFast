<%-- 
    Document   : a_graph
    Created on : 07-11-2019, 1:28:19
    Author     : BlueOcean
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

<!--        <link rel="stylesheet" href="css/bootstrap.min.css"> -->
        <script src="js/graphs/Chart.bundle.js" type="text/javascript"></script>
        <script src="js/graphs/utils.js" type="text/javascript"></script>
        <style>
            canvas{
                -moz-user-select: none;
                -webkit-user-select: none;
                -ms-user-select: none;
            }
        </style>
    </head>
    <body>
        <h1>Hello World!</h1>
        <div class="content">
		<div class="wrapper col-2"><canvas id="chart-0"></canvas></div>
		<div class="wrapper col-2"><canvas id="chart-1"></canvas></div>
		<div class="wrapper col-2"><canvas id="chart-2"></canvas></div>
		<div class="wrapper col-2"><canvas id="chart-3"></canvas></div>

		<div class="toolbar">
			<button onclick="toggleSmooth(this)">Smooth</button>
			<button onclick="randomize(this)">Randomize</button>
		</div>
	</div>

	<script>
		var presets = window.chartColors;
		var utils = Samples.utils;
		var inputs = {
			min: -100,
			max: 100,
			count: 8,
			decimals: 2,
			continuity: 1
		};

		function generateData(config) {
			return utils.numbers(Chart.helpers.merge(inputs, config || {}));
		}

		function generateLabels(config) {
			return utils.months(Chart.helpers.merge({
				count: inputs.count,
				section: 3
			}, config || {}));
		}

		var options = {
			maintainAspectRatio: false,
			spanGaps: false,
			elements: {
				line: {
					tension: 0.000001
				}
			},
			plugins: {
				filler: {
					propagate: false
				}
			},
			scales: {
				xAxes: [{
					ticks: {
						autoSkip: false,
						maxRotation: 0
					}
				}]
			}
		};

		[false, 'origin', 'start', 'end'].forEach(function(boundary, index) {

			// reset the random seed to generate the same data for all charts
			utils.srand(8);

			new Chart('chart-' + index, {
				type: 'line',
				data: {
					labels: generateLabels(),
					datasets: [{
						backgroundColor: utils.transparentize(presets.red),
						borderColor: presets.red,
						data: generateData(),
						label: 'Dataset',
						fill: boundary
					}]
				},
				options: Chart.helpers.merge(options, {
					title: {
						text: 'fill: ' + boundary,
						display: true
					}
				})
			});
		});

		// eslint-disable-next-line no-unused-vars
		function toggleSmooth(btn) {
			var value = btn.classList.toggle('btn-on');
			Chart.helpers.each(Chart.instances, function(chart) {
				chart.options.elements.line.tension = value ? 0.4 : 0.000001;
				chart.update();
			});
		}

		// eslint-disable-next-line no-unused-vars
		function randomize() {
			var seed = utils.rand();
			Chart.helpers.each(Chart.instances, function(chart) {
				utils.srand(seed);

				chart.data.datasets.forEach(function(dataset) {
					dataset.data = generateData();
				});

				chart.update();
			});
		}
	</script>
    </body>
</html>
