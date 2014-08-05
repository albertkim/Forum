var FinanceHome = (function(){
  
  var config = {};

  var init = function(settings) {
    $.extend(config, settings);
    drawChart($("#sp500"), "SPY");
    drawChart($("#nasdaq100"), "^NDX");
    drawChart($("#facebook"), "FB");
    drawChart($("#twitter"), "TWTR");
  };
  
  var drawChart = function(selector, ticker){
    // S&P 500 charts
    var url = "http://query.yahooapis.com/v1/public/yql?q=";
    
    var currentDate = new Date();
    var currentDateString = currentDate.getFullYear() + "-" + ("0" + (currentDate.getMonth() + 1)).slice(-2) + "-" + "0" + currentDate.getDay();
    var date6MonthsAgo = new Date();;
    var date6MonthsAgo = new Date(date6MonthsAgo.setMonth(currentDate.getMonth() - 6));
    var date6MonthsAgoString = date6MonthsAgo.getFullYear() + "-" + ("0" + (date6MonthsAgo.getMonth() + 1)).slice(-2) + "-" + "0" + date6MonthsAgo.getDay();
    
    var query = 'select * from yahoo.finance.historicaldata where symbol = "' 
            + ticker 
            + '" and startDate = "' 
            // + "2014-01-02"
            + date6MonthsAgoString
            + '" and endDate = "' 
            // + "2014-07-01" 
            + currentDateString
            + '"';
    query = query + "&format=json&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=";
    $.ajax({
      url: url + query,
      dataType: "json",
      success: function(data){        
        // Parse data to work with charts
        var results = data.query.results.quote;
        // Data gets returned in reverse for some reason
        results = results.reverse();
        
        var prevMonth = 0;
        dateList = _.map(results, function(item, key, list){
          var splitDate = item.Date.toString().split("-");
          if((prevMonth !== splitDate[1] || key === list.length-1) && key !== 0){
            prevMonth = splitDate[1];
            return item.Date;
          } else {
            prevMonth = splitDate[1];
            return "";
          }
        });
        parsedList = _.map(results, function(item){
          return item.Close;
        });
        
        // Set up canvas
        Chart.defaults.global.showTooltips = false;
        var ctx = selector.get(0).getContext("2d");
        var myNewChart = new Chart(ctx);
        var data = {
          labels: dateList,
          datasets: [{
              label: "S&P 500",
              fillColor: "rgba(151,187,205,0.2)",
              strokeColor: "rgba(151,187,205,1)",
              pointColor: "rgba(151,187,205,1)",
              pointStrokeColor: "#fff",
              pointHighlightFill: "#fff",
              pointHighlightStroke: "rgba(151,187,205,1)",
              data: parsedList
          }]
        };
        var options = null;
        var myLineChart = new Chart(ctx).Line(data, options);
      }
    });
  };

  return {
    init: init
  };
  
})();