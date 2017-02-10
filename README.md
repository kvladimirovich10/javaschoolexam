# README #

This is a repo with T-Systems Java School preliminary examination tasks.
Code points where you solution is to be located are marked with TODOs.

[ ![Codeship Status for tschool/javaschoolexam](https://app.codeship.com/projects/a9af8940-d130-0134-89a6-5e8aaaa2a5a2/status?branch=master)](https://app.codeship.com/projects/201451)

### How to start?  ###
* Install [GIT](https://git-scm.com/) and [Maven](https://maven.apache.org)
* [Fork](https://confluence.atlassian.com/bitbucket/forking-a-repository-221449527.html) the repository 
* You're ready to go!

### How can I submit the result?  ###

* Make sure your code can be built and all tests are green (example command: "mvn clean install")
* Commit and push all changes to your repository
* Configure the build on CI server like Codeship
* Add build badge to the README.md
* Check that the badge shows green build
* Send us an email with the link to your repository. Be aware that the build must be green all the time after you send us the link

### Test fails but I'm sure my solution is correct. What to do?  ###
* First of all - **don't** modify the tests. It will be considered as fraud and treated accordingly
+ Send us an email with full details:
    * Link to your repository
    * Name of failing test
    * Explain what is expected behaviour from your point of view
    * Explain why do you think your version is correct
* Wait for the response

### Tips and tricks for Codeship CI  ###
* Codeship use Java 7 by default. Please refer to [this article](https://documentation.codeship.com/basic/languages-frameworks/java-and-jvm-based-languages/) to set up Java 8
* jdk_switcher is to be used in "Setup Commands" of project configuration
* Test command is "mvn -B test"
* Markdown code to add badge to your README is located in Project Settings -> Notification -> Status images 

### Who do I talk to? ###

* In case of any questions contact the person who sent you the task (first) or [HR department](mailto:job@t-systems.ru) of T-Systems RU (second).

### Useful links ###

* [Learn Markdown](https://bitbucket.org/tutorials/markdowndemo)
* [Codeship](https://codeship.com)