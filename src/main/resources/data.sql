insert into feed(user_id, deleted, deleted_date_time, store_name, category, address, score, visited_date_time, waited, store_size, content)
values (1, false, null, '아무 한식', '한식', '서울특별시 종로구 종로 1', 3, CURRENT_TIMESTAMP, false, 3, '후기 내용 아무렇게'),
       (1, false, null, '양식 가게', '양식', '서울특별시 종로구 세종대로 175', 3, CURRENT_TIMESTAMP + 1, true, 4, '별로'),
       (3, false, null, '중국집', '중식', '서울특별시 종로구 종로 1', 5, CURRENT_TIMESTAMP + 2, false, 2, '아주 맛있었다.');
