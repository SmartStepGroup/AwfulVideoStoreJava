AwfulVideoStoreJava
===================

##### Task #1. Substitution of concepts
 - Move everything related to Session in LoginService to new method. Write tests on authorization
 - Do the same for SellingReportService. Write tests that only admin can see report.

##### Task #2. Dependency Injection
 - Introduce ISession and use it in LoginService where authorize user
 - Use ISession in DefaultMovieService when loading movie list
 - Introduce new interface which will declare loading movies from XML. Use it in DefaultMovieService instead of direct loading

##### Task #3. SPROUT Method
 - Do not include 18+ rating movies into Selling Report
 - Sort movies displaying for admin (DefaultMovieService) by price

##### Task #4. Wrap method
 - Include into Selling Report Top 5 movies for best selling category
