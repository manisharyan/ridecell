$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("compare.feature");
formatter.feature({
  "line": 1,
  "name": "Compare repositories in UI and through API",
  "description": "",
  "id": "compare-repositories-in-ui-and-through-api",
  "keyword": "Feature"
});
formatter.before({
  "duration": 133596785,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "To perform comparison of list of repositories and their description",
  "description": "",
  "id": "compare-repositories-in-ui-and-through-api;to-perform-comparison-of-list-of-repositories-and-their-description",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@test"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I am on the landing page of Django github repo",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I click on repositories option",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I should be able to see and capture all the listed repositories and their description",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "I compare the values against the values received through API response",
  "keyword": "Then "
});
formatter.match({
  "location": "CompareRepoStep.i_am_on_the_landing_page_of_Django_github_repo()"
});
formatter.result({
  "duration": 6438288746,
  "status": "passed"
});
formatter.match({
  "location": "CompareRepoStep.i_click_on_repositories_option()"
});
formatter.result({
  "duration": 1038895164,
  "status": "passed"
});
formatter.match({
  "location": "CompareRepoStep.i_should_be_able_to_see_and_capture_all_the_listed_repositories_and_their_description()"
});
formatter.result({
  "duration": 736440407,
  "status": "passed"
});
formatter.match({
  "location": "CompareRepoStep.i_compare_the_values_against_the_values_received_through_API_response()"
});
formatter.result({
  "duration": 3804927505,
  "error_message": "java.lang.AssertionError\n\tat org.junit.Assert.fail(Assert.java:87)\n\tat org.junit.Assert.assertTrue(Assert.java:42)\n\tat org.junit.Assert.assertTrue(Assert.java:53)\n\tat pages.RepositoryPage.compareDescription(RepositoryPage.java:63)\n\tat stepdef.CompareRepoStep.i_compare_the_values_against_the_values_received_through_API_response(CompareRepoStep.java:34)\n\tat ✽.Then I compare the values against the values received through API response(compare.feature:8)\n",
  "status": "failed"
});
formatter.after({
  "duration": 184701938,
  "status": "passed"
});
});