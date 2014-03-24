AwfulVideoStoreJava
===================

Refactoring workshop. Practice example on how to manage legacy code and start writing unit tests. Theory is here - http://www.slideshare.net/SmartStepGroup/ss-32655053

.NET: https://github.com/SmartStepGroup/AwfulVideoStore

Java: https://github.com/SmartStepGroup/AwfulVideoStoreJava

##### Task #1. Extract and Override Factory Method
 - Move everything related to Session in LoginService to new method. Write tests on authorization
 - Do the same for SellingReportService. Write tests that only admin can see report

##### Task #2. Dependency Injection
 - Introduce ISession and use it in LoginService where authorize user
 - Use ISession in DefaultMovieService when loading movie list
 - Introduce new interface which will declare loading movies from XML. Use it in DefaultMovieService instead of direct loading

##### Task #3. SPROUT Method
 - Do not include 18+ rating movies into Selling Report
 - In DefaultMovieService for user continue filter movies with 14+ rating but at the same time get all 'New Release' movies.
 - Sort movies list for admin by price

##### Task #4. Wrap method
 - Include into Selling Report Top 5 movies for best selling category
