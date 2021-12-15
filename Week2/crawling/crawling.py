from selenium import webdriver
from bs4 import BeautifulSoup
import os, csv, time, datetime
import autoUserAgent

BASE_DIR = os.getcwd()
now = datetime.datetime.now().strftime('%Y-%m-%d %H %M')
filename = BASE_DIR + '/상장법인목록(' + now + ').csv'
f = open(filename, 'w', encoding='utf-8-sig', newline='')
writer = csv.writer(f)

# 탭으로 구분해서 리스트 형식으로 저장 ["회사명", "업종", "주요제품", ...]
title = '회사명,업종,주요제품,상장일,결산월,대표자명,홈페이지,지역,시장,비고1,비고2,비고3,비고4,비고5'.split(',')
# 각 열마다 제목 삽입
writer.writerow(title)

# headless chrome
options = webdriver.ChromeOptions()
options.headless = True
options.add_argument("window-size=1920x1080")   # 브라우저 창 크기 지정(반응형 웹에 사용)
options.add_argument("--disable-gpu")   # 버그 이슈 예방을 위해 그래픽 가속 중지

# headless는 거부되는 서버가 있기 때문에 실제 User-Agent값을 넣어주어야 한다.
# 브라우저에 부하가 증가하는 듯
# curr_userAgent = "user-agent=" + str(autoUserAgent.userAgent)
# options.add_argument(curr_userAgent)

browser = webdriver.Chrome(options=options)
browser.maximize_window()

# 페이지 이동
url = "https://kind.krx.co.kr/corpgeneral/corpList.do?method=loadInitPage"
browser.get(url)

# 페이지 렌더링 시간 기다리기(서버, 하드웨어 상태에 따라 변경)
time.sleep(1)

# 전체 페이지 번호 가져오기
soup = BeautifulSoup(browser.page_source, "html.parser")
full_page_xpath = soup.find('div', 'info type-00').get_text()
full_page_start_index = full_page_xpath.find("/") + 1
full_page_end_index = full_page_start_index
i = 0
while True:
    if '0' <= full_page_xpath[full_page_start_index + i] <= '9':
        full_page_end_index += 1
        i += 1
    else:
        break
full_page = full_page_xpath[full_page_start_index:full_page_end_index]


while True:

    # 데이터 로딩 시간 기다리기(서버, 하드웨어 상태에 따라 변경)
    time.sleep(1)

    soup = BeautifulSoup(browser.page_source, "html.parser")

    data_rows = soup.find("table", "list type-00 tmt30").find("tbody").find_all("tr")
    for row in data_rows:
        columns = row.find_all("td")
        
        if len(columns) <= 1:   # 의미 없는 데이터 skip
            continue
        
        # 현재 행의 text값을 가져온다
        data = [column.get_text().strip() for column in columns]
        
        # 시장, 비고를 따로 가져와 추가
        try:
            stocks = row.find_all('img')
        except TypeError as err:
            data.append('-')
        else:
            for stock in stocks:
                data.append(stock['alt'])

        writer.writerow(data)

    # 현재 페이지 번호 가져오기
    curr_page = soup.find("div", "info type-00").find("strong").get_text().split()

    # 마지막 페이지면 종료
    if int(curr_page[0]) == int(full_page):
        break;

    # 다음 페이지
    # browser.find_element_by_class_name('next').click()    # 가끔 오류
    element = browser.find_element_by_class_name("next")
    browser.execute_script("arguments[0].click();", element)
 

print("스크래핑 완료")
browser.quit()



