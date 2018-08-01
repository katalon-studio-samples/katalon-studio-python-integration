from selenium import webdriver
import os

dirname = os.path.dirname(__file__)

filename = os.path.join(dirname, 'chromedriver.exe')
driver = webdriver.Chrome(filename)

print('session id ' + driver.session_id)
print('command url ' + driver.command_executor._url)