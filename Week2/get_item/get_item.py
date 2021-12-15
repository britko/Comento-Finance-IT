import pandas as pd
import ssl
import os

BASE_DIR = os.getcwd()

class StockItem():
    def __init__(self):
        # 코스피 종목 가져오기
        self.get_item_kospi()

        # 코스닥 종목 가져오기
        self.get_item_kosdaq()

    # 코스피 종목 리스트를 가져오는 메서드(해당 메소드를 작성해주시면 됩니다.)
    def get_item_kospi(self):
        df_stockMkt = pd.read_excel(os.path.join(BASE_DIR, '상장법인목록_stockMkt.xlsx'))
        print('코스피 종목 수: ', len(df_stockMkt))
        print(df_stockMkt[['회사명', '종목코드']])

    # 코스닥 종목 리스트를 가져오는 메서드(해당 메소드를 작성해주시면 됩니다.)
    def get_item_kosdaq(self):
        df_kosdaqMkt = pd.read_excel(os.path.join(BASE_DIR, '상장법인목록_kosdaqMkt.xlsx'))
        print('코스닥 종목 수: ', len(df_kosdaqMkt))
        print(df_kosdaqMkt[['회사명', '종목코드']])

if __name__ == "__main__":

    ssl._create_default_https_context = ssl._create_unverified_context
    
    s = StockItem()