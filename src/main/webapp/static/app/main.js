/**
 * Created with IntelliJ IDEA.
 * User: dewmalpc
 * Date: 6/21/13
 * Time: 2:46 AM
 * To change this template use File | Settings | File Templates.
 */


angular.module('main-app', [], function ($routeProvider, $locationProvider) {
    $routeProvider.when('/postquestion', {
        templateUrl: './static/app/templates/postquestion.html',
        controller: PostQuestion
    });

    $routeProvider.when('/', {
        templateUrl: './static/app/templates/localhome.html',
        controller: Index
    });
});

function MainCntl($scope, $route, $routeParams, $location) {
    $scope.$route = $route;
    $scope.$location = $location;
    $scope.$routeParams = $routeParams;

    console.log($scope.$route);
}

function PostQuestion($scope, $route, $routeParams, $location) {

    console.log('insert A Question');
}

function Index($scope, $route, $routeParams, $location) {

    console.log('index');
}

