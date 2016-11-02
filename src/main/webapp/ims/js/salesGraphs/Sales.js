
window.onload = function () {
	  var d1 = 100;
	  var d2 = 400;
	  var d3 = 300;
	  var d4 = 700;
	  var d5 = 650;
	  var m1 = 500;
	  var m2 = 400;
	  var m3 = 300;
	  var m4 = 700;
	  var m5 = 650;
	  var w1 = 500;
	  var w2 = 400;
	  var w3 = 665;
	  var w4 = 700;
	  var w5 = 650;
	  var DaySalesChart = new CanvasJS.Chart("DailySalesContainer",
	  {
		animationEnabled: true,
		
		title:{
			text: "Gnomes Sold on the DD/MM/YYYY"
		},
		data: [
		{
			type: "column", //change type to bar, line, area, pie, etc
			dataPoints: [
				{ label: "Blue Gnome", y: d1 },
				{ label: "Red Gnome", y: d2 },
				{ label: "Green Gnome",  y: d3 },
				{ label: "Zombie Gnome",  y: d4 },
				{ label: "Santa Gnome",  y: d5 }
			]
		}
		]
		});


	  
	  var WeeklySalesChart = new CanvasJS.Chart("WeeklySalesContainer",
	  {
		animationEnabled: true,
		
		title:{
			text: "Gnomes Sold on the DD/MM/YYYY"
		},
		data: [
		{
			type: "column", //change type to bar, line, area, pie, etc
			dataPoints: [
				{ label: "Blue Gnome",    y: w1 },
				{ label: "Red Gnome",     y: w2 },
				{ label: "Green Gnome",   y: w3 },
				{ label: "Zombie Gnome",  y: w4 },
				{ label: "Santa Gnome",   y: w5 }
			]
		}
		]
		});
	  


	  var MonthlySalesChart = new CanvasJS.Chart("MonthlySalesContainer",
	  {
		animationEnabled: true,
		
		title:{
			text: "Gnomes Sold on the DD/MM/YYYY"
		},
		data: [
		{
			type: "column", //change type to bar, line, area, pie, etc
			dataPoints: [
				{ label: "Blue Gnome", y: m1 },
				{ label: "Red Gnome", y: m2 },
				{ label: "Green Gnome",  y: m3 },
				{ label: "Zombie Gnome",  y: m4 },
				{ label: "Santa Gnome",  y: m5 }
			]
		}
		]
		});
	  DaySalesChart.render();
	  DaySalesChart = {};
	  WeeklySalesChart.render();
	  WeeklysSalesChart = {};
	  MonthlySalesChart.render();
	  MonthlySalesChart={};
}