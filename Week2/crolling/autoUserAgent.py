from selenium import webdriver
from bs4 import BeautifulSoup

def userAgent():
    options = webdriver.ChromeOptions()
    options.headless = True

    browser = webdriver.Chrome(options=options)
    browser.maximize_window()

    url = "http://www.whatismybrowser.com/detect/what-is-my-user-agent"
    browser.get(url)

    soup = BeautifulSoup(browser.page_source, "html.parser")
    detected_value = soup.find('div', 'value').get_text()
    browser.quit()

    return detected_value

if __name__ == "__main__":
    options = webdriver.ChromeOptions()
    options.headless = True

    browser = webdriver.Chrome(options=options)
    browser.maximize_window()

    url = "http://www.whatismybrowser.com/detect/what-is-my-user-agent"
    browser.get(url)

    soup = BeautifulSoup(browser.page_source, "html.parser")
    detected_value = soup.find('div', 'value').get_text()
    browser.quit()

    print(detected_value)