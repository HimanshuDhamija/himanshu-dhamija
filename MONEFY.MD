#### MONEFY ####

-----------------------------------------------------------------------------------------------------------------------------------------------------------------
######## <PRIORITISATION OF CHARTERS> ###############################################################################
* The charters below are prioritised with the serial numbers
* Dashboard, Expense, Balance and Budget mode are the highest priority charters based on the name of the App itself
which states - Budget manager and Expense tracker app
followed by "Money Pro" as this one is the revenue generating one and as a business we want users to opt for Premium features

######## </PRIORITISATION OF CHARTERS ###############################################################################
-----------------------------------------------------------------------------------------------------------------------------------------------------------------


################# < TIME ESTIMATES(ASSUMING TOTAL TIME AS 3 HOURS)> ##################################################

1. Dashboard - 30 mins
2. Expense - 25 mins
3. Balance - 25 mins
4. Budget Mode - 20 mins
5. Money Pro - 15 mins
6. Income - 15 mins
7. Adding account - 15 mins
8. Transfer - 10 mins
9. Export the data - 10 mins
10. Search - 10 mins
11. Categories - 5 mins


################# </TIME ESTIMATES(ASSUMING TOTAL TIME AS 3 HOURS)> ##################################################
-----------------------------------------------------------------------------------------------------------------------------------------------------------------


################# <RISKS TO MITIGATE> ##################################################

As an end user, to use a budgeting app we need to mitigate following risks:

1. Data privacy - There should be a privacy statement. 
	Search the word "sell" or "share" to make sure the app won't sell the data to any 3rd parties for targeted ads.

2. Security - Check the encryption standards for user data (128-bit is good; 256-bit is better) 
	and see if it has two-factor authentication as a login option for the end user

3. Don't allow the budget managing apps to automatically access the bank statements directly from email, mobile messages or any other source.
	For iOS it doesn't allow by default but for Android, you need to stop the access explicitly.

4. Password protect your device - To make sure that no one can take a peek at your finances, set up a password or PIN 
	or fingerprint to unlock the home screen of the device you’re using. 
	This is also important for protecting your actual bank account.

5. Use an antivirus on your phone — Malware targeting financial accounts is on the rise, so you should still install a robust antivirus.

6. Be careful using a budgeting app on public Wi-Fi —  You should never check your bank account 
	or use a budgeting app over unsecured public Wi-Fi — it’s just too easy for hackers to see everything you’re doing

################# </RISKS TO MITIGATE> ##################################################
-----------------------------------------------------------------------------------------------------------------------------------------------------------------

###### <CHARTERS AND THEIR FINDINGS> ####################################################################################################

Note: All the below charters should also be tested on dark theme.

1. Explore "Dashboard"
	with "tapping different bar graphs in dashboard"
		to discover "user lands on balance page"
		to discover "the amount entry expanded based on the tapped graph on the dashboard"

#### Bug: If the date-wise filter is selected on the Balance page, then the category or amount entry is not highlighted in any way
#### It is not highlighted even if the filter is manually changed later from the Balance page 

#### Bug: In case if the calculated percentage in a category is in decimal, its roof value is taken into account.
#### For instance, 16.2% is taken as 17% which can take total percentage(Adding percentages of different categories) to more than 100% 

2. Explore "Expense"
	with "various accounts and various categories"
		to discover "expenses getting recorded in individual accounts and collectively in all accounts"
		to discover "percentages of expenses made across categories and displayed in the dashboard"
	with "main tab expense, add amount and select the category"
		to discover "user is allowed to add amount and select a category and note(optional)"

#### Bug: User is not allowed to select a category before adding amount

	with "individual categories"
		to discover "category is already selected and need to add amount and note(optional)"

3. Explore "Balance"
	with "filters sorting - Amount-wise"
		to discover "sorting separated by income and expense and in descending order of amounts with alphabetical order of categories if the amount is same"
		to discover "Number of entries are separately displayed along-with category"
		to discover "separation between income and expense based on color coding of amounts"
	with "filters sorting - date-wise"
		to discover "sorting separated by income and expense and in descending order of amounts with queue-style(FIFO) ordering of categories if the amount is same"
		to discover "Number of entries displayed along-with the date"
		to discover "separation between income and expense based on color coding of bullet points"

4. Explore "Budget mode"
	with "Selected amount"
		to discover "Balance is the difference between Budget amount and expenses"


5. Explore "Money Pro"
	with "different premium features"
		to discover "user lands on a page to unlock Monefy with payment info" 

6. Explore "Income"

	with "various accounts"
		to discover "incomes reflecting in respective accounts and accumulating in all accounts"

7. Explore "add an account"

	with "different types of accounts"
		to discover "Accounts getting reflected in Accounts tab, Transfer dropdown and left menu widget"

8. Explore "Transfer"

	with "different account"
		to discover "Transfer getting recorded"
		to discover "Amount getting reflected in both the accounts involved in transfer"
		to discover "Amount getting reflected in all accounts"

#### Potential bug: Amount in not getting reflected in all accounts. This could be a bug or not depending upon the requirements or use case of the Transfer functionality.

	with "same account"
		to discover "Getting message - Accounts have to be different"


9. Explore "Export the data"
	
	with "data exported via different mediums"
		to discover "data is successfully exported"


10. Explore "Search"
	with "different categories"
		to discover "the entries displayed based on search category"

#### Bug: Searching for "Food" also diplays an entry of Transfer made from Cash account to a credit card account.

11. Explore "Categories"
	with "updating existing categories"
		to discover "Changes getting reflected in main categories tab as well as the Balance page"

###### </CHARTERS AND THEIR FINDINGS> ####################################################################################################

-----------------------------------------------------------------------------------------------------------------------------------------------------------------


