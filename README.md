# Test automation demo-project

# <a name="TableOfContents">Table of contents</a>
+ [Description](#Description)
+ [Tools and technologies](#Technology)
+ [How to run](#Jenkins)
    + [Gradle command](#GradleCommand)
      + []
    + [Run in Jenkins](#RunInJenkins)
+ [Telegram Notifications](#TelegramNotifications)
+ [Test results report in Allure Report](#AllureReport)
+ [Allure TestOps integration](#AllureTestOps)
    + [Project in Allure TestOps](#AllureTestOpsProject)
    + [Start a run of custom set of tests](#AllureTestOpsStartTests)
    + [Dashboards](#Dashboards)
    + [Defects](#Defects)
+ [Video of running tests](#Video)


# <a name="Description">Description</a>
The test project consists of Web, API and mobile(android) tests.\
A brief list of interesting facts about the project:
- [x] `Page Object` with steps using `Chain of Invocations`
- [x] Fake data generating with `Faker` library
- [x] Parametrized build
- [x] Different configuration files for test running depending on build parameters
- [x] Config with `Owner` library
- [x] Using `Lombok` for models for API tests
- [x] Objects serialization/deserialization for API requests/responses using `Jackson`
- [x] Using request/response specifications for API tests
- [x] Custom Allure listener for beautiful API requests/responses logging
- [x] `Allure TestOps` integration


# <a name="Technology">Tools and a technologies</a>
<p  align="center">
  <code><img width="5%" title="IntelliJ IDEA" src="./images/icons/IDEA-logo.svg"></code>
  <code><img width="5%" title="Java" src="./images/icons/java-logo.svg"></code>
  <code><img width="5%" title="Selenide" src="./images/icons/selenide-logo.svg"></code>
  <code><img width="5%" title="REST-Assured" src="./images/icons/rest-assured-logo.svg"></code>
  <code><img width="5%" title="Gradle" src="./images/icons/gradle-logo.svg"></code>
  <code><img width="5%" title="JUnit5" src="./images/icons/junit5-logo.svg"></code>
  <code><img width="5%" title="Allure Report" src="./images/icons/allure-Report-logo.svg"></code>
  <code><img width="5%" title="Allure TestOps" src="./images/icons/allure-ee-logo.svg"></code>
  <code><img width="5%" title="Jenkins" src="./images/icons/jenkins-logo.svg"></code>
  <code><img width="5%" title="Telegram" src="./images/icons/Telegram.svg"></code>
  <code><img width="5%" title="Browserstack" src="./images/icons/browserstack.svg"></code>
  <code><img width="5%" title="Android Studio" src="https://upload.wikimedia.org/wikipedia/commons/9/95/Android_Studio_Icon_3.6.svg"></code>
  <code><img width="5%" title="Appium" src="./images/icons/appium.svg"></code>
</p>

The autotests in this project are written in `Java` using `Selenide` framework.\
`Gradle` - is used as a build automation tool.  \
`JUnit5` - to execute tests.\
`REST Assured` - for easy API testing of REST services.\
`Jenkins` - CI/CD for running tests remotely.\
`Selenoid` - to remote launching browsers in `Docker` containers.\
`Browserstack` - to run mobile tests.\
`Android Studio tools`, `Appium` - to tun mobile tests locally in a mobile device emulator.\
`Allure Report` - for test results visualisation.\
`Telegram Bot` - for test results notifications.\
`Allure TestOps` - as Test Management System.

[Back to the table of contents ⬆](#TableOfContents)

# <a name="HowToRun">How to run</a>

## <a name="GradleCommand"> Launch from the terminal</a>

To start local test run use the following commands

for web tests:
```bash
gradle clean webTest -Dplatform=<plaform> -DisRemote=<false>
```
for mobile tests:

```bash
gradle clean mobileTest -Dplatform=<plaform> -DisRemote=<false>
```
To start remote test run use the same command with parameter 

```bash
-DisRemote=<true>
```

### Parameters:

`platfrom` - defines a browser for running tests:
>- *Web*
>- *Mobile*
 
`isRemote` - defines the test run is local or remote


[Back to the table of contents ⬆](#TableOfContents)

## <a name="RunInJenkins">Run in [Jenkins](https://jenkins.autotests.cloud/job/demo-project_item/)</a>
Main page of the build:
<p  align="center">
<img src="images/AllureJobImage.png" alt="AllureJobImage" width="950">
</p>

A parametrized Jenkins job can be launched with needed ***platform***, ***isRemote*** and ***task***:
<p  align="center">
<img src="images/AllureParameters.png" alt="AllureParameters" width="950">
</p>


After the build is done the test results are available in:
>- <code><strong>*Allure Report*</strong></code>
>- <code><strong>*Allure TestOps*</strong></code> - results are uploaded there and the automated test-cases can be automatically updated accordingly to the recent changes in the code.

[Back to the table of contents ⬆](#TableOfContents)


# <a name="TelegramNotifications">Telegram Notifications</a>
Telegram bot sends a brief report to a specified telegram chat by results of each build.
<p  align="center">
<img src="images/screens/TelegramNotification.png" alt="TelegramNotification" width="550">
</p>

[Back to the table of contents ⬆](#TableOfContents)

# <a name="AllureReport">Test results report in [Allure Report](https://jenkins.autotests.cloud/job/C12-vyach_son-bookmate_test/47/allure/)</a>

## Main page
Main page of Allure report contains the following blocks:

>- <code><strong>*ALLURE REPORT*</strong></code> - displays date and time of the test, overall number of launched tests, а также диаграмму с указанием процента и количества успешных, упавших и сломавшихся в процессе выполнения тестов
>- <code><strong>*TREND*</strong></code> - displays trend of running tests for all runs
>- <code><strong>*SUITES*</strong></code> - displays distribution of tests by suites
>- <code><strong>*CATEGORIES*</strong></code> - displays distribution of unsuccessful tests by defect types
<p align="center">
  <img src="images/screens//AllureReportMain.png" alt="AllureReportMain" width="950">
</p>

## List of tests with steps and test artefacts
On the page the list of the tests grouped by suites with status shown for each test.\
Full info about each test can be shown: tags, severity, duration, detailed steps.

<p align="center">
  <img src="images/screens/AllureReportSuites.png" alt="AllureReportSuites" width="1150">
</p>

Also additional test artifacts are available:
>- Screenshot
>- Page Source
>- Video
>- Browserstack full info link

<p align="left">
  <img src="images/screens/AllureReportSuites2.png" alt="AllureReportSuites2" width="950">
</p>

[Back to the table of contents ⬆](#TableOfContents)

# <a name="AllureTestOps">[Allure TestOps](https://allure.autotests.cloud/project/1466/test-cases?treeId=2804) integration</a>
> The link can be accessed only by authorized users.

## <a name="AllureTestOpsProject">Project in Allure TestOps</a>
Test-cases in the project are imported and constantly updated from the code,
so there is no need in complex process of synchronization manual test-cases and autotests.\
It is enough to create and update an autotest in the code and the test-case in TMS always will be in actual state.\
Manual test-cases also can be added in TMS in case of need(via web interface or via code).
<p align="center">
  <img src="images/screens/AllureTestOpsTests.gif" alt="AllureTestOpsTests" width="1050">
</p>

```mermaid
stateDiagram-v2
state "Test created/updated in the code" as A
state "Build in Jenkins is triggered on push or started manually" as B
state "Jenkins build is done" as C
state "Allure TestOps launch related to the build marked as closed" as D
state "All executed test-cases are automatically created/updated according to the code" as E
[*] --> A
A --> B
B --> C
C --> D
D --> E
E --> A
```

## <a name="AllureTestOpsStartTests">Ability to start a run of custom set of tests from Allure TestOps</a>
Any person not related to autotest creation can select a set of tests, environment parameter(RunIn) and start a run.\
Allure TestOps run will be created, Jenkins job triggered with correct parameters. And results of the job will be seamlessly integrated into Allure TestOps.
<p align="center">
  <img src="images/screens/AllureTestOpsSelectionOfTests.gif" alt="AllureTestOpsSelectionOfTests" width="1050">
</p>

As soon as the Jenkins job is done, corresponding tests get their statuses. A tester can finish manual tests(if any) and click "Close launch".

<p align="center">
  <img src="images/screens/AllureTestOpsFinishedRunClickStop.png" alt="AllureTestOpsFinishedRunClickStop" width="1250">
</p>

> After that all these test-cases(names, steps, tags etc.) will be updated according to the recent code changes.

[Back to the table of contents ⬆](#TableOfContents)

## <a name="Dashboards">Dashboards</a>
Automation trends charts, distribution tests by some different parameters etc.:
<p align="center">
  <img src="images/screens/AllureTestOpsDashboardsOverview.png" alt="AllureTestOpsDashboardsOverview" width="1050">
</p>

<p align="center">
  <img src="images/screens/AllureTestOpsDashboardsAutomation.png" alt="AllureTestOpsDashboardsAutomation" width="1050">
</p>

<p align="center">
  <img src="images/screens/AllureTestOpsDashboardsMembers.png" alt="AllureTestOpsDashboardsMembers" width="1050">
</p>

<p align="center">
  <img src="images/screens/AllureTestOpsDashboardsAdditional.png" alt="AllureTestOpsDashboardsAdditional" width="1050">
</p>

[Back to the table of contents ⬆](#TableOfContents)

## <a name="Defects">Defects</a>
Knows defects are automatically recognized by defined patterns for test fails in further launches.
<p align="center">
  <img src="images/screens/AllureTestOpsDefects.png" alt="AllureTestOpsDefects" width="1050">
</p>

[Back to the table of contents ⬆](#TableOfContents)


# <a name="GithubWebhooks">GitHub webhooks</a>
Each push to the repository triggers 3 builds in Jenkins:
```bash
gradle clean test -Dtag=API
```
```bash
gradle clean test -Dtag=Web -DrunIn=browser_selenoid
```
```bash
gradle clean test -Dtag=Android -DrunIn=android_browserstack
```
This way we can find problems earlier and always have actual state of test-cases in Allure TestOps.
<p align="center">
  <img src="images/screens/GithubWebhooks1.png" alt="GithubWebhooks" width="1050">
</p>

<p align="center">
  <img src="images/screens/JenkinsRemoteBuildTrigerring.png" alt="JenkinsRemoteBuildTrigerring" width="1050">
</p>


[Back to the table of contents ⬆](#TableOfContents)


# <a name="JiraIntegration">Jira integration</a>
<p align="center">
  <img src="images/screens/JiraIntegration.png" alt="JiraIntegration" width="1050">
</p>

[Back to the table of contents ⬆](#TableOfContents)


# <a name="Video">Video of running tests</a>


https://user-images.githubusercontent.com/103368614/181073019-19e5e4f2-f28e-4c67-a2f5-d5e209951d77.mp4


https://user-images.githubusercontent.com/103368614/181072201-6a35966f-f7b4-4fac-9319-10d34b07b90a.mp4







[Back to the table of contents ⬆](#TableOfContents)
