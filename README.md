# Test Automation
Required things as I test my project over java;
- Junit for Java,
- Selenium WebDriver library,
- Driver library must be downloaded for the browser you want to test. (I tested on google chrome (version 90.0.44 ..) first, let's download chromedriver.exe file from the link below and import it into the project)
Link:https://chromedriver.chromium.org/downloads

# All Process
- www.gittigidiyor.com website opens.
- It is checked that the home page is opened. Login to the site
- Login process is controlled.
- Enter the word computer in the search box.
- The 2nd page opens from the search results page.
- It is checked that page 2 is opened.
- According to the result, a random product is chosen from the displayed products.
- The selected product is added to the basket.
- The accuracy of the price on the product page and the price of the product in the basket is compared.
- By increasing the number, it is verified that the number of products is 2.
- The product is deleted from the basket and it is checked that the basket is empty.
