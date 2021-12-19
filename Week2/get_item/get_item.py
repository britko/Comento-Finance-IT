import pandas as pd
import ssl
import os

class StockItem():
    def __init__(self):
        # HTML 읽어오기
        self.BASE_URL = "http://kind.krx.co.kr/corpgeneral/corpList.do?method=download&searchType=13&marketType="
        # 엑셀 읽어오기
        self.BASE_DIR = os.getcwd()

        # 코스피 종목 가져오기
        self.get_item_kospi()

        # 코스닥 종목 가져오기
        self.get_item_kosdaq()

    ## HTML로 읽어오기
    # 코스피 종목 리스트를 가져오는 메서드(해당 메소드를 작성해주시면 됩니다.)
    def get_item_kospi(self):
        self.df_stockMkt = pd.read_html(self.BASE_URL + 'stockMkt', header=0)[0]
        self.df_stockMkt.종목코드 = self.df_stockMkt.종목코드.map('{:06d}'.format)

        # # 우리가 필요한 것은 회사명과 종목코드이기 때문에 필요없는 column들은 제외해준다.
        # self.df_stockMkt = self.df_stockMkt[['회사명', '종목코드']]

        # 한글로된 컬럼명을 영어로 바꿔준다.
        self.df_stockMkt = self.df_stockMkt.rename(columns={'회사명': 'code_name', '종목코드': 'code'})

        return self.df_stockMkt

    # 코스닥 종목 리스트를 가져오는 메서드(해당 메소드를 작성해주시면 됩니다.)
    def get_item_kosdaq(self):
        self.df_kosdaqMkt = pd.read_html(self.BASE_URL + 'kosdaqMkt', header=0)[0]
        self.df_kosdaqMkt.종목코드 = self.df_kosdaqMkt.종목코드.map('{:06d}'.format)
        
        # # 우리가 필요한 것은 회사명과 종목코드이기 때문에 필요없는 column들은 제외해준다.
        # self.df_kosdaqMkt = self.df_kosdaqMkt[['회사명', '종목코드']]

        # 한글로된 컬럼명을 영어로 바꿔준다.
        self.df_kosdaqMkt = self.df_kosdaqMkt.rename(columns={'회사명': 'code_name', '종목코드': 'code'})

        return self.df_kosdaqMkt


    ## 엑셀로 읽어오기
    # # 코스피 종목 리스트를 가져오는 메서드(해당 메소드를 작성해주시면 됩니다.)
    # def get_item_kospi(self):
    #     df_stockMkt = pd.read_excel(os.path.join(self.BASE_DIR, '상장법인목록_stockMkt.xlsx'))
    #     print('코스피 종목 수: ', len(df_stockMkt))
    #     print(df_stockMkt[['회사명', '종목코드']])

    # # 코스닥 종목 리스트를 가져오는 메서드(해당 메소드를 작성해주시면 됩니다.)
    # def get_item_kosdaq(self):
    #     df_kosdaqMkt = pd.read_excel(os.path.join(self.BASE_DIR, '상장법인목록_kosdaqMkt.xlsx'))
    #     print('코스닥 종목 수: ', len(df_kosdaqMkt))
    #     print(df_kosdaqMkt[['회사명', '종목코드']])

if __name__ == "__main__":

    ssl._create_default_https_context = ssl._create_unverified_context

    s = StockItem()

    # 코스피
    print("코스피 종목수: ", len(s.df_stockMkt))
    print(s.df_stockMkt[['code_name', 'code']])
    print(type(s.df_stockMkt))

    # 코스닥
    print("코스닥 종목수: ", len(s.df_kosdaqMkt))
    print(s.df_kosdaqMkt[['code_name', 'code']])
    print(type(s.df_kosdaqMkt))