var app = angular.module('restroReserve', []);

app.controller('ReserveCtrl', function($scope) {

$scope.reservation = [$http, function($http) {
        return $http({
            method: 'GET',
            url: '/rest/reservations/all'
        })
}];

(function(){
	console.log($scope.reservation[0]);
	})();
	
	
	/*[
  {
  "rsrvno" : "1",
  "name" : "abbc",
  "date" : "12/11/2014",
  "size" : "4"
   },
  {
   "rsrvno" : "1",
  "name" : "abbc",
  "date" : "12/11/2014",
  "size" : "4"
  },
  {
  "rsrvno" : "1",
  "name" : "abbc",
  "date" : "12/11/2014",
  "size" : "4"
  },
  {
  "rsrvno" : "1",
  "name" : "abbc",
  "date" : "12/11/2014",
  "size" : "4"
  }];
*/

$scope.editReservations = function(i){
  $scope.editNew = $scope.reservation[i];
};

$scope.addReservations = function(){
  console.log($scope.editNew);
  $scope.reservation.push($scope.editNew);
  $scope.editNew=null;
};

});



app.controller('SeatingCtrl', function($scope) {

$scope.seating = [
  {
  "tableno" : "1",
  "reserveno" : "111",
  "status" : "occupied",
  "size" : "4",
  "time" : "1.00pm"
   },
    {
  "tableno" : "1",
  "reserveno" : "111",
  "status" : "available",
  "size" : "5",
  "time" : "1.00pm"
   },
     {
  "tableno" : "1",
  "reserveno" : "111",
  "status" : "available",
  "size" : "4",
  "time" : "1.00pm"
   },
     {
  "tableno" : "1",
  "reserveno" : "111",
  "status" : "occupied",
  "size" : "4",
  "time" : "1.00pm"
   },

  ];


$scope.editSeating = function(i){
  $scope.newSeat = $scope.seating[i];
};

$scope.addSeating = function(){
  console.log($scope.newSeat);
  $scope.seating.push($scope.newSeat);
  $scope.newSeat=null;
};

});


app.controller('LoginCtrl', function($scope) {

$scope.pri= "priyanka";

$scope.addReservations = function(){

};
});