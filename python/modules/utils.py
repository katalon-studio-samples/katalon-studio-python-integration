from selenium.webdriver.remote.webdriver import WebDriver as RemoteWebDriver
from selenium.webdriver import Remote

# WebUI.openBrowser("http://vnexpress.net")
# RemoteWebDriver webdriver = DriverFactory.getWebDriver();
# System.out.println(DriverFactory.getWebDriverServerUrl(webdriver));
# System.out.println(webdriver.getSessionId());
#
# driver = create_driver_session('0e0a586c4fe0c3740b784a9cecc2f72d', 'http://localhost:25856')
# driver.get('https://google.com')

def get_driver(all_args):

  web_driver_context = all_args['webDriver']
  session_id = web_driver_context['sessionId']
  server_url = web_driver_context['serverUrl']

  # Save the original function, so we can revert our patch
  org_command_execute = RemoteWebDriver.execute

  def new_command_execute(self, command, params=None):
    if command == "newSession":
      # Mock the response
      return {'success': 0, 'value': None, 'sessionId': session_id}
    else:
      return org_command_execute(self, command, params)

  # Patch the function before creating the driver object
  RemoteWebDriver.execute = new_command_execute

  new_driver = Remote(
    command_executor=server_url, desired_capabilities={})
  new_driver.session_id = session_id

  # Replace the patched function with original function
  RemoteWebDriver.execute = org_command_execute

  return new_driver
