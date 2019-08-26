var i = 0;
var x;
var responseLocal;
var results;
var count = 0;
function pageUpdate() {
  //         1. I want to  increment the page number that I pass to the Ajax call then make an Ajax request to the OMDB on each click of the button
  i++;
  $.ajax({
    url:
      "https://www.omdbapi.com/?s=" +
      userQuery +
      "&page=" +
      i +
      "&apikey=trilogy& plot=full",
    method: "GET",
    async: true,
    dataType: "jsonp"
  }).then(function(response) {
    // 2. After the request is made, once i receive the response I want to set the response to equal the  var resultsLocal.
    // Then set the var results equal to  the array Search.

    responseLocal = response;
    results = responseLocal.Search;
    console.log(results);
    console.log("i is: " + i);
    console.log();
    var div = $("<div>", { id: i, class: "container row" });

    $("#results").append(div);

    // 3. Then I want to  increment through each result (using variable x and setting it to less than 10 so that it will fetch each property i specify  for the full length of each page sent in the  response).

    for (x = 0; x < 10; x++) {
      count++;
      console.log(
        "index of current object Array is: " +
          x +
          " Title is:" +
          results[x].Title
      );
      var poster = results[x].Poster;
      $("#" + i).append(
        "<div id=card" +
          count +
          "><img class=card-img-top src=" +
          poster +
          "id=Poster" +
          count +
          "></img><div class=card-body><h2 id=title" +
          count +
          ">  " +
          results[x].Title +
          "</h2> <p class=card-text id=year" +
          count +
          "> YEAR RELEASED: " +
          results[x].Year +
          "</p>   <p id=itemnumber" +
          count +
          ">  RESULT#" +
          count +
          "</p></div></div> "
      );

      $("#card" + count + "").attr(
        "class",
        "card col-sm-6 text-center d-block mx-auto"
      );
      $("#title" + count + "").attr("class", "col-12 card-title");
      $("#Poster" + count + "").attr("class", "card-img-top");

      $("#itemnumber" + count + "").attr("class", "col-12 card-text");
      $("#year" + count + "").attr("class", "col-12 card-text");
    }
    $("#" + i + "").append("<h5>PAGE: " + i + "</h5>");
  });
}
var userQuery = prompt("Enter Your Search String");

$().ready(function() {
  pageUpdate();

  $("#refresh").click(function() {
    pageUpdate();
  });
});

// ---------------------------------------------------------

console.log(
  "Because our AJAX requests are asynchronous, this line of code will most likely log first"
);
