Feature: As a user, I want to be able to open web page.

    @desktop
    Scenario Outline: Login to the page
        * The user goes to "https://practicetestautomation.com/practice-test-login/"
        * The user sees the login form
        * The user clicks on username input
        * The user types "<username>" into username input
        * The user clicks on password input
        * The user types "<password>" into password input
        * The user clicks on submit button
        * The user sees the login success message

        Examples:
            | username | password |
            | student | Password123 |

    @mobile
    Scenario Outline: Login to the page
        * The user goes to "https://practicetestautomation.com/practice-test-login/"
        * The user sees the login form
        * The user clicks on username input
        * The user types "<username>" into username input
        * The user clicks on password input
        * The user types "<password>" into password input
        * The user clicks on submit button
        * The user sees the login success message

        Examples:
            | username | password |
            | student | Password123 |