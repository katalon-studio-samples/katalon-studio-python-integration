import selenium
import modules.utils as utils
import logging
import robot

def hello_world(allArgs, *numbers):
  print("Hello, World from print")
  logging.warning("Hello, World from logging.info")
  print("Sum of", numbers)
  s = sum(numbers)
  print("Sum is", s)
  return s

def goto_google(allArgs):
  driver = utils.get_driver(allArgs)
  driver.get("https://google.com")

# use demo app at https://bitbucket.org/robotframework/webdemo/src/master/
# remember to copy chromedriver.exe to Scripts
def run_robot(allArgs):
  robot.run("c:/data/webdemo/login_tests")
