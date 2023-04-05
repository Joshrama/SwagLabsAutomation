#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
 Scenario: Add task to list
  Given I am on the home screen
  When I tap the Add Task button
  And I enter the task name <taskName>
  And I choose date <date> and time <time>
  And I select repeat to other and select <repeat option> for <repeat frequency> weeks
  And I tap the set button
  And I select personal on Add to list
  And I tap the check button
  Then the task <taskName> should be added to the list

Examples:
  | taskName          | date                   | time    | repeatFrequencey |
  | waking up early   | 2023, 4, 7     | 6:30 AM | 3  |
  | go to gym         | 2023, 4, 8    | 7:00 AM | 36 |
  
