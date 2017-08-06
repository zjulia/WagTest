# Coding Challenge Android

## Functional Requirements

1. You will need to connect to Stackoverflow Users API Endpoint and retrieve the first page of data. FULL API documentation
	
	This is done in the StackOverflow.java class and the MainActivity.java class with the method createStackOverflowAPI() and the usage of Callback<ListWrapper<User>> usersCallback.
2. Display the retrieved data through a TableLayout.
	
	Once step one is achieved via methods above, users are displayed with method displayUsers(List<User> users) in MainActivity.java
3. We expect from you to display at least username, badges and gravatar for every user.
	
	This is done using the same colors as the StackOverflow badge and badge text which are apparently two different colors.
4. While the gravatar is being downloaded, the UI should show a loading animation.
	
	A loading animation is visible in the activity_main.xml using ProgressBar and it's visibility is set to false when the callback is being completed.
5. Each of the photos should be downloaded only once and stored for offline usage.
	
	The third party library Glide does this automatically according to https://futurestud.io/tutorials/glide-caching-basics.
6. The UI should always be responsive.
	
	The height of the row is hard coded at a comfortable viewing size but everything else will change depending on the screen size.

## Technical Requirements

Language: Java
Platform Version: 5.1+

## Evaluation criteria

1. You care about the user experience.
	
	The design looks fairly attractive I think , I kept a orange/black style similar to StackOverflow's logo. The text is readable and badges are colored as well according to their type. I also created a circle xml similar to the actual badges online for familiarity. I also used Glide's circular photo feature since most apps no longer use square images.
2. You create elegant, clean and maintainable code.
	
	I separated out the helper classes and put them into a Utils package, I would use this package for any other helper methods that I might need in the future such as a xml converter or to handle access to Realm. The Model is where I put objects containing data like User or Question or Answer. This app was fairly straight forward and I only ended up using one activity but if I had more than I would have organized them by their purpose. I also inflated views when relevant (table_row.xml) instead of building it manually. I find that it's easier to read and cleaner when you can inflate a view rather than saying something like TableRow row = new TableRow() and then populating that out. It's easier to debug or change styles and doesn't take up nearly as much code space.
3. You develop in a way that has clearly defined areas of responsibility.
	
	See #2.
4. You develop in a scalable manner.
	
	If more details were necessary about the user, I would have made the tablerow clickable and shown an AlertDialog that displayed all other user details. If there were many more users that needed to be listed, like 1,000,000 then I would have to implement a pagination sort of thing and the displayUsers method would need a bit of tweaking but it should be workable. More pages could be added to this since the top action bar has plenty of room for searching or a drop down menu with more options.
5. You pay attention to details.
	
	I comment most of the code for the benefit of my future self and whoever else happens to look at it and wants to figure out my train of thought at the time. I think the design is fairly attractive, it's not cluttered but I am concerned that it may be a bit too large, though I personally favor larger icons and text. It looks about the same in portrait or landscape mode and switches fairly smoothly. I also added a little cup icon to click on from the regular screen.
6. You know how to keep the UI responsive.
	
	It stretches accordingly. 

## Submission

Push the code to an online repository and send us the link.
Update your project README file with any relevant information.
We expect from you a complete Android project.
The app must run as is.

## Third-party libraries

If you choose to use any third-party libraries, please explain why you made the decision to use each one.

1. Retrofit

    It makes it relatively easy to retrieve and upload JSON 

2. Glide
    
    Glide abstracts out most of the complexity in handling these and other tasks related to working with bitmaps and other images on Android. Considered picasso but didn't use it for these reasons: https://medium.com/@multidots/glide-vs-picasso-930eed42b81d

