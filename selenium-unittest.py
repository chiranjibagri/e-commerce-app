#!/usr/bin/python3
from selenium import webdriver
from selenium.webdriver.firefox.options import Options
import pytest

target_url = "http://34.93.8.68/"

print("########## Running the Selenium Script ##########")

@pytest.fixture(scope="session")
def get_driver():
    global driver
    options = Options()
    options.add_argument("--headless")
    driver = webdriver.Firefox(options=options)
    yield
    driver.close()

@pytest.mark.usefixtures("get_driver")
def test_data():
    driver.get(target_url)
    element = driver.find_element_by_tag_name("h1")
    print("########## Checking for the main page of the ecommerce application ##########")
    assert element.text == "Welcome to WildFly 11"
