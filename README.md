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
        sql_mode="STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION"
        innodb_buffer_pool_size=2041M
        init_connect="SET collation_connection = utf8_general_ci" 
        init_connect="SET NAMES utf8" 
        character-set-server = utf8
        collation-server = utf8_general_ci

        [client]
        port=3306
        plugin-dir=C:/Program Files/MariaDB 10.6/lib/plugin
        default-character-set = utf8

        [mysqldump]
        default-character-set = utf8

        [mysql]
        default-character-set = utf8
    ```

  - Run MariaDB
    ```sql
        SHOW VARIABLES LIKE 'c%';
        SET CHARACTER SET euckr;
    ```
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
      [TABLE_INFORMATION]()
  - Insert data
    ```sql
        source ${DATA_INFOMATION}PATH
    ```
      [DATA_INFORMATION]()

### 관계형데이터를 통한 데이터 조회 학습
1. 삼성전자의 테마 이름?
    ```sql

    ```
2. 코스피 상위 5종목 시총 합(주식 금융정보 기준 일자 - 2021.01.07)
    ```sql

    ```
3. 투자위험이 가장 많은 종목 테마명은?
    ```sql

    ```
4. 코스닥종목중 가장 높은 ROE를 가진 정보의 정보를 가져오기(code, market_class0, 종목명, ROE)(주식 금융정보 기준 일자 - 2021.01.07)
    ```sql

    ```