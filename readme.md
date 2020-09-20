Mohamed Yusuf
====================

I have completed all the essential and additional exercises for this task.

Usage
------------

Run main.java located in ``` my-chat/src/main/java/com/mindlinksoft/recruitment/mychat/ ``` and provide as command-line arguments the input and output file, followed by the desired flags.

* To filter by user provide the flag ```-fu``` followed by one or more user names to filter by.

   * e.g ``` chat.txt output.json -fu bob mike ```
   * The output will contain only messages from users specified after the flag.

* To filter by keyword, use the ```-fw``` flag followed by one or more words to filter.

   * e.g ``` chat.txt output.json -fw pie card```
   * The output will therefore only contain messages that include the words "pie" and "card".

* To blacklist words use the ```-b``` flag.

   * e.g ```  chat.txt output.json -b pie card ```
   * The output will redact the keywords "pie" and "card".

* To obfuscate user names use the ```-ou``` flag.

   * e.g ```  chat.txt output.json -ou ```
   * Usernames in the output will be hashed, thus obfuscating them but also retaining message relations.

* To obfuscate credit card details use the ```-oc``` flag.

   * e.g ```  chat.txt output.json -oc ```
   * The output will redact all credit card numbers in the formats ```1234123412341234```, ```1234 1234 1234 1234``` or ```1234-1234-1234-1234```

* To generate a message report use the ```-r``` flag.

   * e.g ```  chat.txt output.json -r ```
   * The output will also contain a report of the most active users ordered by activity.

* Flags can also be piped and used in any order.

   * e.g ```  chat.txt output.json -fu bob mike -fw pie -ou -oc -r ```
   * The output will contain messages from "bob" or "mike" that include the keyword "pie". Furthermore, username and credit cards will be obfuscated and a report will be generated.
   * e.g ```  chat.txt output.json -b -fw all -fu john -ou ```
   * The output will contain messages that include the keyword "all" from "john" whilst obfuscating usernames.
   
   
 Run ```TestRunner.java``` located in ```my-chat/src/test/java/com/mindlinksoft/recruitment/mychat/```, this runner includes multiple unit tests for various parts of the program.
 
Rationale
------------

I created a filter interface that all filters implement with their custom behaviours, a ```FilterFactory``` is then responsible for providing the right filter to requesting clients. This allows additional filters to be quickly implemented, new filters need only to "register" with the filter factory and define a unique flag.

Flags and filters were kept separate as not all flags represented a filter (e.g the report flag). Additional flags can also be effortlessly added in ```FlagProperties```, flags can also be set to require any number of additional targets.

I have also taken this opportunity to improve the exception handling, a new custom checked exception has been created to cover illegal flags and targets.



Programming Exercise
====================

This is a skeleton application to be used as part of a software development interview.

Instructions
------------

* Treat this code as if you owned this application, do whatever you feel is necessary to make this your own.
* There are several deliberate design, code quality and test issues that should be identified and resolved.
* Below is a list of the current features supported by the application; as well as additional features that have been requested by the business owner.
* In order to work on this take a fork into your own GitHub area; make whatever changes you feel are necessary and when you are satisfied submit back via a pull request. See details on GitHub's [Fork & Pull](https://help.github.com/articles/using-pull-requests) model
* Be sure to put your name in the pull request comment so your work can be easily identified.
* The project is written utilising some Java 8 features (java.time), we encourage using Java 7 or 8, but this is your project now, so you are free to choose a different version.
* The project uses maven to resolve dependencies however if you want to avoid maven configuration the only external JARs that are required is junit-4.12 and gson-2.5.
* Refactor and add features (from the below list) as you see fit; there is no need to add all the features in order to "complete" the exercise.
* We will only consider candidates that implemented at least the "essential" features.
* Keep in mind that code quality is the critical measure and there should be an obvious focus on __TESTING__.
* REMEMBER: this is YOUR code, make any changes you feel are necessary.
* You're welcome to spend as much time as you like.
* The code will be a representation of your work, so it's important that all the code--new and pre-existing--is how you want your work to be seen.  Please make sure that you are happy with ALL the code.

#### Things We Value

* Good code structure - separation of concerns,
* A well-formed exception model,
* Tidy code,
* Application of appropriate design patterns,
* Unit tests.

#### Things To Avoid At All Costs

* Throwing general exception,
* Magic strings,
* Methods that do everything,
* No testing.

my-chat
-------

### Essential Features

* A user can export a conversation from a given file path stored in the following file format into a JSON file at the given output path:
```
<conversation_name><new_line>
(<unix_timestamp><space><username><space><message><new_line>)*
```
* Messages can be filtered by a specific user
    * The user can be provided as a command-line argument (how the argument is specified is up to you)
    * All messages sent by the specified user are written to the JSON output
    * Messages sent by any other user are not written to the JSON output
* Messages can be filtered by a specific keyword
    * The keyword can be specified as a command-line argument
    * All messages sent containing the keyword are written to the JSON output
    * Messages sent that do not contain the keyword are not written to the JSON output
* Hide specific words
    * A blacklist can be specified as a command-line argument
    * Any blacklisted word is replaced with "\*redacted\*" in the output.

### Additional Features

Implementing any of these features well will make your submission stand-out. Features listed here are ordered from easy to hard.

* Hide credit card and phone numbers
    * A flag can be specified to hide credit card and phone numbers
    * Any identified credit card or phone numbers are replaced with "\*redacted\*" in the output.
* Obfuscate user IDs
    * A flag can be specified to obfuscate user IDs
    * All user IDs are obfuscated in the output.
    * The same original user ID in any single export is replaced with the same obfuscated user ID i.e. messages retain their relationship with the sender, only the ID that represents the sender is changed.
* A report is added to the conversation that details the most active users
    * The most active user in a conversation is the user who sent the most messages.
    * Most active users are added to the JSON output as an array ordered by activity.
    * The number of messages sent by each user is included.
