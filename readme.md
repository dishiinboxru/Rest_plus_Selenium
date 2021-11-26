How to run tests 

mvn clean test - from the repo folder

known issues

most major one - - petstore web-site itself is too sluggish - even manually checking those cases you can notice get and delete responses being incorrect if you don't wait or retry several times.
Known timeout solutions (Thread.sleep, awaitly )  doesn't solve the situation so I leave it as is.

1 - chromedriver as file - don't quite know how to add it as dependency or downloadable asset
2 - better xpaths ( from ids or other more robust locators)
3 - need to add tear-downs with data test-data removal
4 - json body generator as separate class

5 - test 4 - due to test site itself being too sluggish the errors create themselves at times.

Time estimates to complete the whole thing to the end
1 - a - if it means being able to configure the website address - 1 day
1 - d - JSON format for interactions - 1-2 h , I've already know that JSONObject is to be used, just didn't have time to convert those properly from strings.
extra 1 - POJO conversion - not sure what's that for since JSONObject seems to be sufficient, but can be done in 3-4 hours 

thus extra 2 days might be enough.