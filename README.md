# Comento-Finance-IT

## Week 1
### Install Maria DB
- Install [Maria DB](https://mariadb.org/download/)
- Setting Maria DB
  - maria DB 설치 경로에서 `my.ini`를 열어 수정
    ```ini
    [mysqld]
    datadir=C:/Program Files/MariaDB 10.6/data
    port=3306
    innodb_buffer_pool_size=2041M
    character-set-client-handshake = FALSE
    character-set-server = utf8mb4
    collation-server = utf8mb4_unicode_ci

    [client]
    port=3306
    plugin-dir=C:/Program Files/MariaDB 10.6/lib/plugin
    default-character-set = utf8mb4

    [mysql]
    default-character-set = utf8mb4
    ```
    서비스 - MariaDB(다시 시작)

  - Run MariaDB
    ```sql
    SHOW VARIABLES LIKE 'c%';
    SET CHARACTER SET euckr;

    # 기존에 만들어뒀던 데이터베이스나 테이블이 있을 경우 다음 쿼리문으로 설정 변경
    ALTER DATABASE <데이터베이스 이름> CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;
    ALTER TABLE <테이블 이름> CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
    ```
  - 출처: [MariaDB 한글 입력 및 깨짐 설정](https://lazeturtle.tistory.com/28)

  - Create database
    ```sql
    CREATE DATABASE stock
    ```
  - Create tables
    ```sql
    USE stock
    CREATE TABLE ${TABLE_INFORMATION}

    ALTER TABLE ${table_name} CONVERT TO CHARSET UTF8;
    ```
    [TABLE_INFORMATION](https://github.com/britko/Comento-Finance-IT/tree/master/Week%201/1%EC%A3%BC%EC%B0%A8%20%EA%B3%BC%EC%A0%9C%20%EC%82%AC%EC%A0%84%20%EC%84%A4%EC%A0%95%20%EB%82%B4%EC%9A%A9(%ED%85%8C%EC%9D%B4%EB%B8%94)/%ED%85%8C%EC%9D%B4%EB%B8%94%20%EC%A0%95%EB%B3%B4)
  - Insert data
    ```sql
    source ${DATA_INFOMATION}PATH
    # ex) SOURCE C:/Users/pc/data/stock_info.sql;
    ```
    [DATA_INFORMATION](https://github.com/britko/Comento-Finance-IT/tree/master/Week%201/1%EC%A3%BC%EC%B0%A8%20%EA%B3%BC%EC%A0%9C%20%EC%82%AC%EC%A0%84%20%EC%84%A4%EC%A0%95%20%EB%82%B4%EC%9A%A9(%ED%85%8C%EC%9D%B4%EB%B8%94)/%EB%8D%B0%EC%9D%B4%ED%84%B0%EC%A0%95%EB%B3%B4)

### 관계형데이터를 통한 데이터 조회 학습

1. 삼성전자의 테마 이름?
    ```sql
    SELECT PRC.code, INF.thema_name 
    FROM stock_price PRC JOIN stock_info INF 
    WHERE PRC.code = INF.code AND PRC.code_name='삼성전자' AND INF.thema_name IS NOT NULL;
    ```

2. 코스피 상위 5종목 시총 합(주식 금융정보 기준 일자 - 2021.01.07)
    ```sql
    SELECT KP.code, KP.code_name, FI.market_cap
    FROM stock_kospi KP, stock_finance FI 
    WHERE KP.code = FI.code AND FI.date = '20210107' 
    ORDER BY FI.market_cap DESC LIMIT 5;

    SELECT SUM(A.market_cap)
    FROM ( 
    SELECT FI.market_cap
    FROM stock_kospi KP, stock_finance FI 
    WHERE KP.code = FI.code AND date = '20210107' 
    ORDER BY FI.market_cap DESC LIMIT 5
    ) A;
    ```

3. 투자위험이 가장 많은 종목 테마명은?
    ```sql
    SELECT MAX(thema_name)
    FROM stock_invest_danger ID, stock_info INF
    WHERE ID.code = INF.code;
    ```

4. 코스닥종목중 가장 높은 ROE를 가진 정보의 정보를 가져오기(code, market_class0, 종목명, ROE)(주식 금융정보 기준 일자 - 2021.01.07)
    ```sql
    SELECT KD.code, INF.market_class0, INF.category1, KD.code_name, FI.ROE
    FROM stock_kosdaq KD, stock_info INF, stock_finance FI
    WHERE KD.code = INF.code AND KD.code = FI.code AND FI.date = '20210107'
    ORDER BY FI.ROE DESC LIMIT 1;
    ```

## Week 1